package com.my.board;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import board.bean.BoardDTO;
import board.bean.FAQDTO;
import board.bean.InqiresDTO;
import board.bean.ReplyDTO;
import board.dao.BoardDao;
import member.bean.MemberDTO;

@Service
public class BoardServiceImpl implements BoardService{

	
	@Autowired
	BoardDao dao;

	@Override
	public int boardWrite(BoardDTO dto) {
		
		return dao.boardWrtie(dto);
	}

	@Override
	public int imgUpload(String fileName) {
		
		return dao.imgUpload(fileName);
	}

	@Override
	public List<BoardDTO> boardList(String id,int startNum,int endNum) {
		
		return dao.boardList(id,startNum,endNum);
	}

	@Override
	public List<String> getImgs(int id) {
		
		return dao.getImgs(id);
	}
	
	public BoardDTO boardView(int id) {
		return dao.boardView(id);
	}

	@Override
	/*
	 * public List<BoardDTO> reviewList() {
	 * 
	 * return dao.reviewList(); }
	 */
	
	public List<Map<String,Object>> reviewList(int startNum,int endNum){
		
		return dao.reviewList(startNum,endNum);
	}

	@Override
	public int getTotal() {
		
		return dao.getTotal();
	}

	@Override
	public int insertReply(ReplyDTO dto) {
		
		return dao.insertReply(dto);
	}

	@Override
	public List<ReplyDTO> replyView(int re_ref) {
		// TODO Auto-generated method stub
		return dao.replyView(re_ref);
	}

	@Override
	public int replyModify(ReplyDTO dto) {
		
		return dao.replyModify(dto);
	}

	@Override
	public List<Map<String, Object>> newestReviewList() {
		// TODO Auto-generated method stub
		return dao.newestReviewList();
	}

	@Override
	public int insertRecommend(int seq, String id) {
		
		return dao.insertRecommend(seq, id);
	}

	@Override
	public boolean checkRecommend(int seq, String id) {
		
		return dao.checkRecommend(seq, id);
	}

	@Override
	public int deleteRecommend(int seq, String id) {
		// TODO Auto-generated method stub
		return dao.deleteRecommend(seq, id);
	}

	@Override
	public int getRecommendTotal(int seq) {
		// TODO Auto-generated method stub
		return dao.getRecommendTotal(seq);
	}

	@Override
	public List<Map<String, Object>> boardsearch(int startNum, int endNum, String content) {
		
		return dao.boardsearch(startNum, endNum, content);
	}

	@Override
	public int searchtitleTotal(String title) {
		// TODO Auto-generated method stub
		return dao.searchtitleTotal(title);
	}

	@Override
	public int searchwriterTotal(String writer) {
		// TODO Auto-generated method stub
		return dao.searchwriterTotal(writer);
	}

	@Override
	public List<Map<String, Object>> searchWriter(int startNum, int endNum, String content) {
		// TODO Auto-generated method stub
		return dao.searchWriter(startNum, endNum, content);
	}

	@Override
	public List<Map<String, Object>> RecommendReviewList() {
		// TODO Auto-generated method stub
		return dao.RecommendReviewList();
	}

	@Override
	public int imagesDelete(int id) {
		// TODO Auto-generated method stub
		return dao.imagesDelete(id);
	}


	@Override
	public int imageModify(String fileName, int seq) {
		// TODO Auto-generated method stub
		return dao.imageModify(fileName,seq);
	}

	@Override
	public int boardModify(BoardDTO dto,int seq) {
		// TODO Auto-generated method stub
		return dao.boardModify(dto,seq);
	}

	@Override
	public int boardDelete(int seq) {
		// TODO Auto-generated method stub
		return dao.boardDelete(seq);
	}

	@Override
	public int getMyReviewTotal(String id) {
		// TODO Auto-generated method stub
		return dao.getMyReviewTotal(id);
	}

	@Override
	public List<BoardDTO> myRecommendList(String id) {
		// TODO Auto-generated method stub
		return dao.myRecommendList(id);
	}

	@Override
	public int getGenreTotal(String genre) {
		// TODO Auto-generated method stub
		return dao.getGenreTotal(genre);
	}

	@Override
	public List<Map<String, Object>> genreReviewList(int startNum,int endNum,String genre) {
		// TODO Auto-generated method stub
		return dao.genreReviewList(startNum,endNum,genre);
	}

	@Override
	public List<MemberDTO> memberList(int startNum, int endNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int memberTotal() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<FAQDTO> FAQList() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int inqiresWrite(String question,String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<InqiresDTO> inqiresList(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InqiresDTO> inqiresList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int adminAnswerWrite(int id, String content, String admin_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BoardDTO> adminReviewList(int startNum, int endNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int listDelete(List<Integer> list) {
		// TODO Auto-generated method stub
		return 0;
	}





}
