package com.my.board;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import board.bean.BoardDTO;
import board.bean.FAQDTO;
import board.bean.InqiresDTO;
import board.bean.ReplyDTO;
import member.bean.MemberDTO;

public interface BoardService {

	//관리자
	public int listDelete(List<Integer> list);
	public List<BoardDTO> adminReviewList(int startNum,int endNum);
	public int adminAnswerWrite(int id,String content,String admin_id);
	public List<InqiresDTO>  inqiresList();
	public List<InqiresDTO>  inqiresList(String id);
	public int inqiresWrite(String question,String id);
	public List<FAQDTO> FAQList();
	public List<MemberDTO> memberList(int startNum,int endNum);
	public int memberTotal();
	//
	public int boardWrite(BoardDTO dto);
	public int imgUpload(String fileName);
	public List<BoardDTO> boardList(String id,int startNum,int endNum);
	public List<String> getImgs(int id);
	public BoardDTO boardView(int id);
	//public int updateHit(int seq);
	
	//public List<BoardDTO> reviewList();
	public List<Map<String,Object>> reviewList(int startNum,int endNum);
	
	public int getTotal();
	public int searchtitleTotal(String title);
	public int searchwriterTotal(String writer);
	public int getMyReviewTotal(String id);
	
	
	public int insertReply(ReplyDTO dto);
	public List<ReplyDTO> replyView(int re_ref);
	public int replyModify(ReplyDTO dto) ;
	
	public List<Map<String,Object>> newestReviewList();
	public List<Map<String,Object>> RecommendReviewList();
	
	
	public int imagesDelete(int id);
	public int imageModify(String fileName, int seq);
	public int boardModify(BoardDTO dto,int seq);
	public int boardDelete(int seq);
	
	
	
	public int insertRecommend(int seq,String id);
	public boolean checkRecommend(int seq,String id);
	public int deleteRecommend(int seq,String id);
	public int getRecommendTotal(int seq);
	public List<Map<String,Object>> boardsearch(int startNum, int endNum,String content);
	public List<Map<String,Object>> searchWriter(int startNum, int endNum,String content);
	
	
	
	public  List<BoardDTO> myRecommendList(String id);
	
	
	public int getGenreTotal(String genre);
	public List<Map<String,Object>>  genreReviewList(int startNum,int endNum,String genre);
	
	
}
