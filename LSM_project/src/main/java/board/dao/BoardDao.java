package board.dao;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import board.bean.BoardDTO;
import board.bean.ReplyDTO;


@Component
public class BoardDao {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
	private String username = "dbprac";
	private String password = "m1234";

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	
	public BoardDao() {
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
			
		try {
			conn=DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	public void close() {
		
		try {
		if(rs != null)	rs.close();
		if(pstmt != null)	pstmt.close();
		if(conn != null)	conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	
	
	public int boardWrtie(BoardDTO dto) {
	
		int result=0;
		String sql="insert into review values(seq_review.nextval,?,?,?,?,0,sysdate,?)";
		conn=getConnection();
		
		try {
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getGenre());
			pstmt.setInt(3, dto.getRating());
			pstmt.setString(4, dto.getContent());
			pstmt.setString(5,dto.getMember_id());
			
			result=pstmt.executeUpdate();

			pstmt=conn.prepareStatement(sql);
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close();
		}
		
	
		return result;
	}
	
	public int imgUpload(String fileName) {

		
		
		int result=0;
		String sql="insert into review_photo values(seq_review_photo.nextval,?,(select max(id) id from review))";
		conn=getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, fileName);
			
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close();
		}
	
		return result;
	}
	
	
	//내 게시글
	public List<BoardDTO> boardList(@Param("id") String id,@Param("startNum") int startNum,@Param("endNum") int endNum){
		List<BoardDTO> list= new ArrayList<BoardDTO>();
			
		String sql="select * from(select row_number() over \r\n"
				+ "(order by regdate desc,id desc) rn,review.* from review where member_id=?)\r\n"
				+ "where  rn between ? and ?";
		conn=getConnection();
		try {                                                         
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, startNum);
			pstmt.setInt(3, endNum);
			
			rs=pstmt.executeQuery();
			while(rs.next()) {
				BoardDTO dto= new BoardDTO();
				dto.setId(rs.getInt("id"));
				dto.setTitle(rs.getString("title"));
				dto.setGenre(rs.getString("genre"));
				dto.setRating(rs.getInt("rating"));
				dto.setContent(rs.getString("content"));
				dto.setHit(rs.getInt("hit"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setMember_id(rs.getString("member_id"));
				
				list.add(dto);
			}              
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close();
		}

		return list;
	}
	
	
	
	
	
	public List<String> getImgs(int id) {
		
		List<String> list= new ArrayList<String>();
		String sql="select *from review_photo where review_id=?";
		conn=getConnection();

		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			rs= pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(rs.getString("img"));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			close();
		}	
		
		return list;
	}
	
	
	
	
	public BoardDTO boardView(int id)  {
		BoardDTO dto= new BoardDTO();
		
		String sql="select *from review where id=?";
		
		
		conn=getConnection();
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setId(rs.getInt("id"));
				dto.setTitle(rs.getString("title"));
				dto.setGenre(rs.getString("genre"));
				dto.setRating(rs.getInt("rating"));
				dto.setContent(rs.getString("content"));
				dto.setHit(rs.getInt("hit"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setMember_id(rs.getString("member_id"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return dto;
		
	}
	
	public List<Map<String,Object>> reviewList(@Param("startNum") int startNum,@Param("endNum") int endNum){
		
		List<Map<String,Object>> list2=new ArrayList<Map<String,Object>>();
		//List<BoardDTO> list= new ArrayList<BoardDTO>();
		int result;
		String sql="select *from (select rownum n,id,title,img from "
				+ "(select id,title,img from\r\n"
				+ "(select row_number() over(partition by review.id order by review.id) "
				+ "rn, review.id, review.title, rp.img "
				+ "from review left join review_photo rp "
				+ "on review.id = rp.review_id) where rn=1 order by id desc)) "
				+ "where n between ? and ?";
		
		conn=getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
			result=pstmt.executeUpdate();
			
			if(result!=0) {
				rs=pstmt.executeQuery();
				
				while(rs.next()) {
					Map<String,Object> map=new HashMap<String, Object>();
					//BoardDTO dto= new BoardDTO();
					//dto.setId(rs.getInt("id"));
					//dto.setTitle(rs.getString("title"));
					//dto.setImg(null);
					
					map.put("id", rs.getInt("id"));
					map.put("title", rs.getString("title"));
					map.put("img",rs.getString("img"));
					
					
					list2.add(map);

				}
				
			}
						
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close();
		}

		
		return list2;
	}
	
	
	// 여기부터 할차례
	public List<Map<String,Object>> boardsearch(@Param("startNum") int startNum,@Param("endNum") int endNum,@Param("content") String content){
		
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();		
		int result;
		String sql="select *from (select rownum rown,t.*from(\r\n"
				+ "select *from(select row_number() over(PARTITION by review.id order by review.id)\r\n"
				+ "rn, review.id, review.title, rp.img,review.regdate,review.member_id\r\n"
				+ "from review left join review_photo rp \r\n"
				+ "on review.id = rp.review_id) t where rn=1 and title like ? order by regdate desc) t) \r\n"
				+ "where rown between ? and ?";
		
		conn=getConnection();
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "%"+content+"%");
			pstmt.setInt(2, startNum);
			pstmt.setInt(3, endNum);
			
			result=pstmt.executeUpdate();
			
			if(result!=0) {
				rs=pstmt.executeQuery();
				
				while(rs.next()) {
					Map<String,Object> map=new HashMap<String, Object>();
					
					map.put("id", rs.getInt("id"));
					map.put("title", rs.getString("title"));
					map.put("img",rs.getString("img"));
					
					
					list.add(map);

				}
				
			}
						
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close();
		}

		
		return list;
	}
		
	public List<Map<String,Object>> searchWriter(@Param("startNum") int startNum,@Param("endNum") int endNum,@Param("content") String content){
		
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();		
		int result;
		String sql="select *from (select rownum rown,t.*from(\r\n"
				+ "select *from(select row_number() over(PARTITION by review.id order by review.id)\r\n"
				+ "rn, review.id, review.title, rp.img,review.regdate,review.member_id\r\n"
				+ "from review left join review_photo rp \r\n"
				+ "on review.id = rp.review_id) t where rn=1 and member_id like ? order by regdate desc) t) \r\n"
				+ "where rown between ? and ?";
		
		conn=getConnection();
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "%"+content+"%");
			pstmt.setInt(2, startNum);
			pstmt.setInt(3, endNum);
			
			result=pstmt.executeUpdate();
			
			if(result!=0) {
				rs=pstmt.executeQuery();
				
				while(rs.next()) {
					Map<String,Object> map=new HashMap<String, Object>();
					
					map.put("id", rs.getInt("id"));
					map.put("title", rs.getString("title"));
					map.put("img",rs.getString("img"));
					
					
					list.add(map);

				}
				
			}
						
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close();
		}

		
		return list;
	}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int getTotal() {
		int result=0;
		
		conn=getConnection();
		String sql="select  count(*) cnt from review";
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				result=rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close();
		}
		
		
		return result;
	}
	
	public int getMyReviewTotal(String id) {
		int result=0;
		conn=getConnection();
		String sql="select count(*) cnt from(select row_number() over \r\n"
				+ "(order by regdate desc,id desc) rn,review.* from review) where member_id= ?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				result=rs.getInt("cnt");
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			close();
		}
		
		
		return result;
	}
	
	
	
	public int searchtitleTotal(String title) {
		int result=0;
		
		conn=getConnection();
		String sql="select  count(*) cnt from review where title like ?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,"%"+title+"%");
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				result=rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close();
		}
			
		return result;
	}
	
	
	public int searchwriterTotal(String writer) {
		int result=0;
		
		conn=getConnection();
		String sql="select  count(*) cnt from review where member_id like ?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,"%"+writer+"%");
			rs=pstmt.executeQuery();
			  
			if(rs.next()) {
				result=rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close();
		}
			
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	public int insertReply(ReplyDTO dto) {

		int result=0;
		String sql="";
		conn=getConnection();
		try {
			sql="update review_reply set re_seq=re_seq+1 where re_ref=? and re_seq>?";
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getRe_ref());
			pstmt.setInt(2, dto.getRe_seq());
			pstmt.executeUpdate();
			
			sql="insert into review_reply values(seq_reply.nextval,?,?,?,?,?,sysdate)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,dto.getMember_id());
			pstmt.setString(2,dto.getContent());
			pstmt.setInt(3, dto.getRe_ref());
			pstmt.setInt(4, dto.getRe_seq()+1);
			pstmt.setInt(5, dto.getRe_lev()+1);
			
			
			result=pstmt.executeUpdate();
			
  		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close();
		}
		
		
		
		return result;
	}
	
	
	
	public List<ReplyDTO> replyView(int re_ref) {
		List<ReplyDTO> list= new ArrayList<ReplyDTO>();
		
		String sql="select *from review_reply where re_ref=? order by re_seq";
		conn=getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, re_ref);
			
			rs=pstmt.executeQuery();
			while(rs.next()) {
			ReplyDTO dto= new ReplyDTO();
			dto.setMember_id(rs.getString("member_id"));
			dto.setContent(rs.getString("content"));
			dto.setRe_ref(rs.getInt("re_ref"));
			dto.setRe_seq(rs.getInt("re_seq"));
			dto.setRe_lev(rs.getInt("re_lev"));
			dto.setRegdate(rs.getString("regdate"));
				
			list.add(dto);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			
			close();
		}
		
		return list;
	}

	
	
	public int replyModify(ReplyDTO dto) {
		
		
		int result=0;
		String sql="update review_reply set content=? where re_ref=? and re_seq= ?";
		conn=getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getContent());
			pstmt.setInt(2, dto.getRe_ref());
			pstmt.setInt(3, dto.getRe_seq());
			
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			
			close();
		}
		
		
		
		return result;
	}
	
	

	public List<Map<String,Object>> newestReviewList(){
		
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		
		String sql=  "select *from (select rownum rown,t.*from("
				+ "select *from(select row_number() over(PARTITION by review.id order by review.id)\r\n"
				+ "rn, review.id, review.title, rp.img,review.regdate\r\n"
				+ "from review left join review_photo rp \r\n"
				+ "on review.id = rp.review_id) t where rn=1 order by regdate desc) t) where rown between 1 and 12";
		conn=getConnection();
		
		
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				Map<String,Object> map= new HashMap<String, Object>();
				
				map.put("id", rs.getInt("id"));
				map.put("title", rs.getString("title"));
				map.put("img",rs.getString("img"));
				
			
				
				list.add(map);
				
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			
			close();
		}
	
		return list;
	}
	
	
	
public List<Map<String,Object>> RecommendReviewList(){
		
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		
		String sql=  "select *from(select row_number() over(\r\n"
				+ "order by br.cnt desc nulls last,bw.regdate desc) rn,\r\n"
				+ "bw.id,bw.title,bw.img,bw.regdate,br.cnt\r\n"
				+ "from board_view bw left join board_recommend br\r\n"
				+ "on bw.id=br.id) where rn between 1 and 12";
		conn=getConnection();
		
		
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				Map<String,Object> map= new HashMap<String, Object>();
				
				map.put("id", rs.getInt("id"));
				map.put("title", rs.getString("title"));
				map.put("img",rs.getString("img"));
				
				
				list.add(map);
				
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			
			close();
		}
	
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	public int insertRecommend(@Param("seq") int seq,@Param("id") String id) {
		
		int result=0;
		
		conn=getConnection();
		String sql="insert into recommend values(seq_recommend.nextval,?,?)";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			pstmt.setString(2, id);
			
			result=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			
			close();
		}
		
		
	
		return result;
	}
	
	
	
	public boolean checkRecommend(@Param("seq") int seq,@Param("id") String id) {
		boolean result=false;
		conn=getConnection();
		String sql="select *from recommend where board_id=? and member_id=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			pstmt.setString(2, id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				
				result=true;
			} 
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			
			close();
		}
		
		
		
		
		return result;
	}
	
	
	public int deleteRecommend(@Param("seq") int seq,@Param("id") String id) {
		
		int result=0;
		
		conn=getConnection();
		String sql="delete recommend where board_id=? and member_id=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			pstmt.setString(2, id);
			
			result=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			
			close();
		}
		
		
	
		return result;
	}
	
	
	
	public int getRecommendTotal(int seq) {
		int result=0;
		String sql="select count(board_id) cnt from recommend where board_id=?";
		conn=getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,seq);
			rs=pstmt.executeQuery();
			
			if(rs.next()) result=rs.getInt("cnt");
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			
			close();
		}
		
		
		
		return result;
	}
	
	
	
	
	
	
	public int boardModify(@Param("dto") BoardDTO dto,@Param("seq")int seq) {
		int result=0;
		String sql="update review set title=?,genre=?,rating=?,content=? where id=?";
		conn=getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getGenre());
			pstmt.setInt(3, dto.getRating());
			pstmt.setString(4,dto.getContent());
			pstmt.setInt(5, seq);
		
			result=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			
			close();
		}
		
		
		
		return result;
	}
	
	
	
	public int imagesDelete(int id) {
		int result=0;
		String sql="delete review_photo where review_id= ? ";
		conn=getConnection();
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			result=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			
			close();
		}
		
		
		
		return result;
	}
	
	
	
	
	
	public int imageModify(@Param("fileName") String fileName,@Param("seq") int seq) {
		int result=0;
		String sql="insert into review_photo values(seq_review_photo.nextval,?,?)";
		conn=getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,fileName);
			pstmt.setInt(2, seq);

			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close();
		}
		

		return result;
	
	}
	
	
	
	
	public int boardDelete(int seq) {
		int result=0;
		String sql="delete review where id=?";
		conn=getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close();
		}
		
		
		
		
		
		return result;
	}
	

	public  List<BoardDTO> myRecommendList(String id){
		
		List<BoardDTO> list= new ArrayList<BoardDTO>();
		String sql="select review.* from recommend\r\n"
				+ "join review on recommend.board_id=review.id \r\n"
				+ "where recommend.member_id=?";
		
		conn=getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,id);  
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO dto= new BoardDTO();
				dto.setId(rs.getInt("id"));
				dto.setTitle(rs.getString("title"));
				dto.setGenre(rs.getString("genre"));
				dto.setRating(rs.getInt("rating"));
				dto.setContent(rs.getString("content"));
				dto.setHit(rs.getInt("hit"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setMember_id(rs.getString("member_id"));
				
				list.add(dto);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close();
		}
		
		
		
		
		
		return list;
	}

	
	// 장르별 리스트
	
	public List<Map<String,Object>>  genreReviewList(@Param("startNum") int startNum,@Param("endNum") int endNum,@Param("genre") String genre){
		
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		
		String sql= "select *from (select rownum rown,t.*from(select *from(select row_number()\r\n"
				+ "	over(PARTITION by review.id order by review.id\r\n"
				+ "	) rn, review.id, review.title, rp.img,review.regdate,review.genre\r\n"
				+ "	from review left join review_photo rp\r\n"
				+ "	on review.id = rp.review_id) t where rn=1 and genre=? order by regdate desc) t) where rown between ? and ?";
		conn=getConnection();
		
		
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,genre);
			pstmt.setInt(2, startNum);
			pstmt.setInt(3, endNum);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				Map<String,Object> map= new HashMap<String, Object>();
				
				map.put("id", rs.getInt("id"));
				map.put("title", rs.getString("title"));
				map.put("img",rs.getString("img"));
				
				
				list.add(map);
				
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			
			close();
		}
	
		return list;
	}
	
	
	
	
	public int getGenreTotal(String genre) {
		int result=0;
		
		conn=getConnection();
		String sql="select count(id) cnt from review where genre=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, genre);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				result=rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close();
		}
		
		
		return result;
		
		
		
	}
	
	
	
	
	
}
