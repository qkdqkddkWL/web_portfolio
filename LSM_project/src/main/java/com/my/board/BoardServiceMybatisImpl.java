package com.my.board;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import board.bean.BoardDTO;
import board.bean.FAQDTO;
import board.bean.InqiresDTO;
import board.bean.ReplyDTO;
import board.dao.BoardDao;
import board.dao.BoardDao2;
import member.bean.MemberDTO;


@Service
@Qualifier("board_mybatis")
public class BoardServiceMybatisImpl implements BoardService{

		
	@Autowired
	BoardDao2 dao;

	
	// 관리자
	@Override
	public int listDelete(List<Integer> list) {
		// TODO Auto-generated method stub
		return dao.listDelete(list);
	}


	@Override
	public List<BoardDTO> adminReviewList(int startNum, int endNum) {
		// TODO Auto-generated method stub
		return dao.adminReviewList(startNum, endNum);
	}

	@Override
	public int adminAnswerWrite(int id,String content,String admin_id) {
		// TODO Auto-generated method stub
		return dao.adminAnswerWrite(id,content,admin_id);
	}

	
	@Override
	public List<InqiresDTO> inqiresList() {
		// TODO Auto-generated method stub
		return dao.inqiresList();
	}


	@Override
	public List<InqiresDTO> inqiresList(String id) {
		// TODO Auto-generated method stub
		return dao.inqiresList(id);
	}

	
	@Override
	public int inqiresWrite(String question,String id) {
		
		return dao.inqiresWrite(question,id);
	}



	
	@Override
	public List<FAQDTO> FAQList() {
		
		return dao.FAQList();
	}
	
	@Override
	public int memberTotal() {
		// TODO Auto-generated method stub
		return dao.memberTotal();
	}

	
	public List<MemberDTO> memberList(int startNum,int endNum){
		
		return dao.memberList(startNum,endNum);
	}
	//
	
	@Override
	public int boardWrite(BoardDTO dto) {
		
		return dao.boardWrtie(dto);
	}

	@Override
	public int imgUpload(String fileName) {
		
		return dao.imgUpload(fileName);
	}

	@Override
	public List<BoardDTO> boardList(String id, int startNum, int endNum) {
		
		return dao.boardList(id, startNum, endNum);
	}

	@Override
	public List<String> getImgs(int id) {
		
		return dao.getImgs(id);
	}

	@Override
	public BoardDTO boardView(int id) {
		
		dao.updateHit(id);
		return dao.boardView(id);
	}


	
	@Override
	public List<Map<String, Object>> reviewList(int startNum, int endNum) {
		
		return dao.reviewList(startNum, endNum);
	}

	@Override
	public int getTotal() {
		
		return dao.getTotal();
	}

	@Override
	public int searchtitleTotal(String title) {
		
		return dao.searchtitleTotal(title);
	}

	@Override
	public int searchwriterTotal(String writer) {
		
		return dao.searchtitleTotal(writer);
	}

	@Override
	public int getMyReviewTotal(String id) {
		
		return dao.getMyReviewTotal(id);
	}

	@Override
	public int insertReply(ReplyDTO dto) {
	
		dao.insertReply_update(dto);	//댓글db에 넣기전 레벨 업데이트
		return dao.insertReply(dto);
	}

	@Override
	public List<ReplyDTO> replyView(int re_ref) {
		
		return dao.replyView(re_ref);
	}

	@Override
	public int replyModify(ReplyDTO dto) {
		
		return dao.replyModify(dto);
	}

	@Override
	public List<Map<String, Object>> newestReviewList() {
		
		return dao.newestReviewList();
	}

	@Override
	public List<Map<String, Object>> RecommendReviewList() {
		
		return dao.RecommendReviewList();
	}

	@Override
	public int imagesDelete(int id) {
		
		return dao.imagesDelete(id);
	}

	@Override
	public int imageModify(String fileName, int seq) {
		
		return dao.imageModify(fileName, seq);
	}

	@Override
	public int boardModify(BoardDTO dto, int seq) {
		
		return dao.boardModify(dto, seq);
	}

	@Override
	public int boardDelete(int seq) {
		
		return dao.boardDelete(seq);
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
		
		return dao.deleteRecommend(seq, id);
	}

	@Override
	public int getRecommendTotal(int seq) {
		
		return dao.getRecommendTotal(seq);
	}

	@Override
	public List<Map<String, Object>> boardsearch(int startNum, int endNum, String content) {
		
		return dao.boardsearch(startNum, endNum, content);
	}

	@Override
	public List<Map<String, Object>> searchWriter(int startNum, int endNum, String content) {
		
		return dao.searchWriter(startNum, endNum, content);
	}

	@Override
	public List<BoardDTO> myRecommendList(String id) {
		
		return dao.myRecommendList(id);
	}

	@Override
	public int getGenreTotal(String genre) {
		
		return dao.getGenreTotal(genre);
	}

	@Override
	public List<Map<String, Object>> genreReviewList(int startNum, int endNum, String genre) {
		
		return dao.genreReviewList(startNum, endNum, genre);
	}

	







}
