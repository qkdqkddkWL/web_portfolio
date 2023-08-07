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
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import board.bean.BoardDTO;
import board.bean.FAQDTO;
import board.bean.InqiresDTO;
import board.bean.ReplyDTO;
import member.bean.MemberDTO;


@Component
public class BoardDao2 {


	@Autowired
	SqlSessionTemplate sqlSession;
	
	// 관리자 모든 문의글리스트
	public List<BoardDTO> adminReviewList(int startNum,int endNum) {
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		
		
		return sqlSession.selectList("mybatis.boardMapper.adminReviewList",map);
		
	}
	
	
	
	public int listDelete(List<Integer> list) {
		return sqlSession.delete("mybatis.boardMapper.listDelete",list);
	}
	
	
	public int adminAnswerWrite(int id,String content,String admin_id) {
		Map<String,Object> map= new HashMap<String, Object>();
		map.put("id", id);
		map.put("content", content);
		map.put("admin_id", admin_id);
		
		return sqlSession.update("mybatis.boardMapper.adminAnswerWrite",map);
	}
	
	public List<InqiresDTO>  inqiresList() {
		
		return sqlSession.selectList("mybatis.boardMapper.admin_inqiresList");
	}
	
	// 유저개인 문의글리스트
	public List<InqiresDTO>  inqiresList(String id) {
			
		return sqlSession.selectList("mybatis.boardMapper.inqiresList",id);
	}
	
	
	public int inqiresWrite(String question,String id) {
		Map<String,String> map=new HashMap<String, String>();
		map.put("question", question);
		map.put("id", id);
		
		
		return sqlSession.insert("mybatis.boardMapper.inqiresWrite",map);
	}
	
	public List<FAQDTO> FAQList(){
		return sqlSession.selectList("mybatis.boardMapper.FAQList");
	}
	
	public int memberTotal() {
		
		return sqlSession.selectOne("mybatis.boardMapper.memberTotal");
	}
	
	public List<MemberDTO> memberList(int startNum, int endNum){
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		return sqlSession.selectList("mybatis.boardMapper.memberList",map);
	}
	
	public int boardWrtie(BoardDTO dto) {
		
		return sqlSession.insert("mybatis.boardMapper.boardWrtie", dto);
	
	}
	
	public int imgUpload(String fileName) {

		
		return sqlSession.insert("mybatis.boardMapper.imgUpload", fileName);
	

	}
	
	
	//내 게시글
	public List<BoardDTO> boardList(@Param("id") String id,@Param("startNum") int startNum,@Param("endNum") int endNum){
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		
		return sqlSession.selectList("mybatis.boardMapper.boardList",map);
		
	}
	
	
	
	
	
	public List<String> getImgs(int id) {
		
		return sqlSession.selectList("mybatis.boardMapper.getImgs", id);
		

	}
	
	public int updateHit(int seq) {
		return sqlSession.insert("mybatis.boardMapper.updateHit",seq);
	}
	
	public BoardDTO boardView(int id)  {
		
		return sqlSession.selectOne("mybatis.boardMapper.boardView",id);

		
	}
	
	public List<Map<String,Object>> reviewList( int startNum, int endNum){
		
	
		Map< String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		
		return sqlSession.selectList("mybatis.boardMapper.reviewList",map);
		
	
	}
	
	
	
	
	
	public List<Map<String,Object>> boardsearch( int startNum, int endNum,String content){
		
		
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		map.put("content", content);
		
		return sqlSession.selectList("mybatis.boardMapper.boasrdSearch", map);
		
	}
		
	public List<Map<String,Object>> searchWriter( int startNum,int endNum,String content){
		
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		map.put("content", content);
		
		
		return sqlSession.selectList("mybatis.boardMapper.searchWriter",map);
		
		
	}
		
	

	
	
	public int getTotal() {
		
		return sqlSession.selectOne("mybatis.boardMapper.getTotal");

	}
	
	public int getMyReviewTotal(String id) {
		
		return sqlSession.selectOne("mybatis.boardMapper.getMyReviewTotal",id);

	}
	
	
	
	public int searchtitleTotal(String title) {
		
		
		return sqlSession.selectOne("mybatis.boardMapper.searchtitleTotal",title);
		

	}
	
	
	public int searchwriterTotal(String writer) {
		
		
		return sqlSession.selectOne("mybatis.boardMapper.searchwriterTotal",writer);

	}
	

	
	public int insertReply_update(ReplyDTO dto) {
		
		return sqlSession.update("mybatis.boardMapper.insertReply_update",dto);
	}
	
	public int insertReply(ReplyDTO dto) {

		
		return sqlSession.insert("mybatis.boardMapper.insertReply_insert",dto);

	}
	
	
	
	public List<ReplyDTO> replyView(int re_ref) {
		
		
		return sqlSession.selectList("mybatis.boardMapper.replyView",re_ref);

	}

	
	
	public int replyModify(ReplyDTO dto) {
		
		return sqlSession.update("mybatis.boardMapper.replyModify",dto);
		

	}
	
	

	public List<Map<String,Object>> newestReviewList(){
		
		return sqlSession.selectList("mybatis.boardMapper.newestReviewList");

	}
	
	
	
	public List<Map<String, Object>> RecommendReviewList() {

		return sqlSession.selectList("mybatis.boardMapper.RecommendReviewList");

	}
	
	
	
	
	
	
	
	
	
	
	public int insertRecommend( int seq, String id) {
		
		Map<String,Object> map= new HashMap<String, Object>();
		map.put("seq", seq);
		map.put("id", id);
		return sqlSession.insert("mybatis.boardMapper.insertRecommend",map);

	}
	
	
	
	public boolean checkRecommend( int seq, String id) {
		
		Map<String,Object> map= new HashMap<String, Object>();
		map.put("seq", seq);
		map.put("id", id);
		
		boolean result=false;
		if(sqlSession.selectOne("mybatis.boardMapper.checkRecommend",map)) {
			result=true;
		}

		return result;
	}
	
	
	public int deleteRecommend( int seq, String id) {
		Map<String,Object> map= new HashMap<String, Object>();
		map.put("seq", seq);
		map.put("id", id);
		
		return sqlSession.delete("mybatis.boardMapper.deleteRecommend",map);

	}
	
	
	
	public int getRecommendTotal(int seq) {
		
		return sqlSession.selectOne("mybatis.boardMapper.getRecommendTotal",seq);

	}
	
	
	
	
	
	
	public int boardModify(BoardDTO dto,int seq) {
		
		Map<String,Object> map = new HashMap<String, Object>();
		
		map.put("dto", dto);
		map.put("seq", seq);
		
		
		return sqlSession.update("mybatis.boardMapper.boardModify",map);


	}
	
	
	
	public int imagesDelete(int id) {
		
		return sqlSession.delete("mybatis.boardMapper.imagesDelete",id);

	}
	
	
	
	
	
	public int imageModify(String fileName,int seq) {
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("fileName", fileName);
		map.put("seq", seq);
		
		return sqlSession.insert("mybatis.boardMapper.imageModify",map);

	
	}
	
	
	
	
	public int boardDelete(int seq) {
		
		return sqlSession.delete("mybatis.boardMapper.boardDelete",seq);

	}
	

	public  List<BoardDTO> myRecommendList(String id){
		
		return sqlSession.selectList("mybatis.boardMapper.myRecommendList",id);

	}

	
	// 장르별 리스트
	
	public List<Map<String,Object>>  genreReviewList(int startNum, int endNum, String genre){
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		map.put("genre", genre);
		
		
		return sqlSession.selectList("mybatis.boardMapper.genreReviewList",map);

	}
	
	
	
	
	public int getGenreTotal(String genre) {
		
		return sqlSession.selectOne("mybatis.boardMapper.getGenreTotal",genre);

		
		
		
	}
	
	
	
	
	
}
