package member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import member.bean.MemberDTO;


@Component
public class MemberDAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
	private String username = "dbprac";
	private String password = "m1234";

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	public MemberDAO() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
	}
	
	public Connection getConnection() {
		try {
			conn= DriverManager.getConnection(url,username,password);
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
	

	public int memberWrite(MemberDTO dto) {
		int result=0;
		String sql="insert into member values(?,?,?,?,?,sysdate)";
		conn=getConnection();
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1,dto.getId());
			pstmt.setString(2,dto.getPwd());
			pstmt.setString(3,dto.getName());
			pstmt.setString(4,dto.getBirthday());
			pstmt.setString(5,dto.getEmail());
			
			result=pstmt.executeUpdate();	
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {		
			close();
		}
		return result;
	}
	
	public String login(String id,String pwd) {
		
		String sql="select *from member where id=? and pwd=?";
		String name=null;
		conn=getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				name=rs.getString("name");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {		
			close();
		}
		return name;
	}
	
	public MemberDTO membermodify(String id) {
		
		MemberDTO dto = new MemberDTO();
		String sql="select *from member where id=?";
		conn=getConnection();
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setId(id);
				dto.setPwd(rs.getString("pwd"));
				dto.setName(rs.getString("name"));
				dto.setBirthday(rs.getString("birthday"));
				dto.setEmail(rs.getString("email"));				
			}
			
		} catch (SQLException e) {

			
			e.printStackTrace();
		}finally {		
			close();
		}
		return dto;
	}
	
	public MemberDTO selectOne(String id) {
		MemberDTO dto= new MemberDTO();
		String sql="select *from member where id=?";
		conn=getConnection();
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setId(id);
				dto.setPwd(rs.getString("pwd"));
				dto.setName(rs.getString("name"));
				dto.setBirthday(rs.getString("birthday"));
				dto.setEmail(rs.getString("email"));				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			close();
			
		}
		

		return dto;
	}
	
	
	public int CheckId(String id) {
		int result=0;
		String sql="select *from member where id=?";
		conn=getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			result= rs.next() ? 1 : 0;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close();
		}
		
		
		
		return result;
	}
	
	public int passwordModify(String id,String pwd) {

		int result=0;
		String sql="update member set pwd=? where id=?";
		conn=getConnection();
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,pwd);
			pstmt.setString(2,id);
			
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close();
		}
		
		
		
		return result;
	}
	
	
}
