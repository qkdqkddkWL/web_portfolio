package com.my.board;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.my.member.MemberService;

import board.bean.BoardDTO;
import board.bean.FAQDTO;
import board.bean.InqiresDTO;
import board.bean.ReplyDTO;
import member.bean.MemberDTO;


@RequestMapping("/board/")
@Controller
public class BoardController {


	@Autowired
	@Qualifier("board_mybatis")
	BoardService service;
	
	@Autowired
	@Qualifier("member_mybatis")
	MemberService member;
	
	@RequestMapping("inqiresList")
	public ModelAndView inqiresList(HttpServletRequest request) {
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		ModelAndView mv= new ModelAndView("mypage.inqiresList");
		List<InqiresDTO> list=service.inqiresList(id);
		

		mv.addObject("list",list);
		
		
		return mv;
	}
	
	
	@RequestMapping("inqiresWrite")
	public ModelAndView inqiresWrite(HttpServletRequest request,String question) {
		ModelAndView mv= new ModelAndView();
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
	
		System.out.println("문의글 입력"+question);
		int result=service.inqiresWrite(question,id);
		
		mv.addObject("result",result);
		mv.setViewName("board/boardWrite");
		
		return mv;
	}
	
	
	
	// 관리자 페이지
	//글 리스트
	
	@RequestMapping("/adminpage/listDelete")
	public ModelAndView adminListDelete(String review_id[]) {
		ModelAndView mv= new ModelAndView();

		if(review_id == null) {
			mv.setViewName("redirect:/board/adminpage/adminReviewList?pg=1");
			
		}else {
			
		
		
		
		List<Integer> list= new ArrayList<Integer>();
		
		for(int i=0; i<review_id.length;i++) {
			list.add(Integer.parseInt(review_id[i]));
		}
		
		int result=service.listDelete(list);
		mv.addObject("result",result);
		mv.setViewName("/board/boardDeleteResult");
		
		}
		
		return mv;
	}
	
	
	@RequestMapping("/adminpage/adminReviewList")
	public ModelAndView adminReviewList(int pg) {
		ModelAndView mv= new ModelAndView();
		
		List<BoardDTO> list= null;
		// 한페이지에 게시글 5개
		int endNum = pg * 5;
		int startNum = endNum - 4;
		int total=service.getTotal();
		list=service.adminReviewList(startNum, endNum);
		
		int totalPage= (total+4) / 5;
		
		// 페이징 5개씩(1,2,3,4,5)
		int startPage = (pg-1)/5 * 5  +1 ;		//	1,5,11
		int endPage=startPage+4;
		
		if(endPage > totalPage) endPage = totalPage;
		
		mv.addObject("list",list);
		mv.addObject("total",total);
		mv.addObject("startPage",startPage);
		mv.addObject("endPage",endPage);
		mv.addObject("totalPage",totalPage);
		mv.addObject("pg",pg);
		mv.setViewName("admin.adminReviewList");
		
		return mv;
	}
	
	
	
	// 답변 등록
	@RequestMapping("/adminpage/adminAnswerWrite")
	public ModelAndView adminAnswerWrite(HttpServletRequest request,String seq,String content) {
		ModelAndView mv= new ModelAndView();
		HttpSession session=request.getSession();
		String admin_id=(String)session.getAttribute("id");
		
		int id=Integer.parseInt(seq);
		

		int result=service.adminAnswerWrite(id,content,admin_id);
		System.out.println(result);
		
		mv.addObject("result",result);
		mv.setViewName("adminpage/adminWrite");
		
		return mv;
	}
	
	
	
	@RequestMapping("/adminpage/admin_answer")
	public ModelAndView adminAnswer(String id) {
		ModelAndView mv= new ModelAndView();
		
		mv.setViewName("adminpage/admin_answer");
		mv.addObject("id",id);
		
		return mv;
	}
	
	
	@RequestMapping("/adminpage/inqiresList")
	public ModelAndView adminInqiresList() {
		ModelAndView mv= new ModelAndView();
		List<InqiresDTO> list=service.inqiresList();
		mv.addObject("list",list);
		mv.setViewName("admin.admin_inqiresList");
		
		
		return mv;
	}
	
	@RequestMapping("/adminpage/FAQ")
	public ModelAndView FAQ() {
		ModelAndView mv= new ModelAndView();
		List<FAQDTO> list= service.FAQList();

		mv.addObject("list",list);
		mv.setViewName("admin.board_FAQ");
		
		return mv;
	}
	
	@RequestMapping("/adminpage/management")
	public ModelAndView Admin_management(int pg) {

		ModelAndView mv= new ModelAndView();
		List<MemberDTO> list= null;
		
		// 한페이지에 게시글 5개
		int endNum = pg * 5;
		int startNum = endNum - 4;
		int total=0;

		total= service.memberTotal();
		list=service.memberList(startNum, endNum);


		int totalPage= (total+4) / 5;
		
		// 페이징 5개씩(1,2,3,4,5)
		int startPage = (pg-1)/5 * 5  +1 ;		//	1,5,11
		int endPage=startPage+4;
		
		if(endPage > totalPage) endPage = totalPage;
		
		mv.addObject("list",list);
		mv.addObject("total",total);
		mv.addObject("startPage",startPage);
		mv.addObject("endPage",endPage);
		mv.addObject("totalPage",totalPage);
		mv.addObject("pg",pg);
		mv.setViewName("admin.management");
		
		return mv;
	}
	
	
	// 유저
	@RequestMapping("userQuestion")
	public String userQuestion() {
		return "mypage.userQuestion";
	}
	
	@RequestMapping("movieList")
	public String MovieList() {
		
		return "board/movieList";
	}
	
	@RequestMapping("boardWriteForm")
	public String boardWriteForm() {
		
		return "board.boardWriteForm";
	}
	
	@RequestMapping("myPage")
	public String myPage() {
		
		return "board.myPage";
	}
	
	
	@RequestMapping("boardWrite")
	public ModelAndView boardWrite(String title,String gerne,int rating,String content,List<MultipartFile> imgs,HttpServletRequest request) {

		BoardDTO dto=new BoardDTO();
		HttpSession session=request.getSession();
		String id=(String) session.getAttribute("id");
		dto.setTitle(title);
		dto.setGenre(gerne);
		dto.setRating(rating);
		dto.setContent(content);
		dto.setMember_id(id);
		
		System.out.println(dto.getMember_id()+" " +dto.getRating());
		int result=service.boardWrite(dto);
		System.out.println("result: "+ result);
		
		
		
		String filePath = request.getSession().getServletContext().getRealPath("/public");
		String folder="/storage";
		String realPath=filePath+folder;
		
		for (int i = 0; i < imgs.size(); i++) {
			String fileName = imgs.get(i).getOriginalFilename();
			
			if(fileName != null && fileName !="") {
				try {
					service.imgUpload(fileName);
					imgs.get(i).transferTo(new File(realPath+"/"+fileName));
					
				} catch (IllegalStateException e) {
					
					e.printStackTrace();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}

		}
			
		ModelAndView mv= new ModelAndView("board/boardWrite");
		mv.addObject("result",result);
		
		return mv;
		
	}
	
	
	
	
	
	@RequestMapping("myReview")
	public ModelAndView myReview(HttpServletRequest request,int pg) {
		ModelAndView mv=new ModelAndView();
		HttpSession session=request.getSession();
		String id=(String) session.getAttribute("id");
		
		
		int endNum=pg*5;
		int startNum=endNum-4;
		
		int total=service.getMyReviewTotal(id);
		
		int totalPage= (total + 4) / 5;
		
		
		int startPage= (pg -1)/5 *5  +1;
		int endPage = startPage +4;
		if(endPage > totalPage) endPage = totalPage;
		
		if(id == null) {
			mv.setViewName("redirect:index");
		}else {
			mv.setViewName("mypage.myReview");
		}

		List<BoardDTO> list=service.boardList(id,startNum,endNum);
		mv.addObject("list",list);
		mv.addObject("total",total);
		mv.addObject("startPage",startPage);
		mv.addObject("endPage",endPage);
		mv.addObject("totalPage",totalPage);
		mv.addObject("pg",pg);
		
		return mv;
		
		
		
		// 페이징 처리 해야함 
		
	}
	
	
	
	
	
	
	
	
	@RequestMapping("boardView")
	public ModelAndView boardView(int seq,HttpServletRequest request) {
		
		ModelAndView mv= new ModelAndView("board.boardView");
		HttpSession session=request.getSession();
		String id=(String) session.getAttribute("id");
		
		BoardDTO dto= service.boardView(seq);
		List<String> imgs=service.getImgs(seq);
		
		List<ReplyDTO> list=service.replyView(seq);
		int count= service.getRecommendTotal(seq);
		
		boolean state=false; 
		
		if(id != null) {
			state =service.checkRecommend(seq, id);
		}
		
		
		
		mv.addObject("state",state);
		mv.addObject("count",count);
		mv.addObject("dto", dto);
		mv.addObject("re_lev",0);
		mv.addObject("re_seq",0);
		mv.addObject("imgs",imgs);
		mv.addObject("list",list);
		mv.addObject("replyTotal",list.size());
		
		
		return mv;
		
		
	}
	
	
	//영화 리스트 목록 보기
	@RequestMapping("reviewList")
	public ModelAndView boardList(int pg,String genre) {
		ModelAndView mv= new ModelAndView("board.reviewList");
		// 한페이지에 게시글 9개
		int endNum = pg * 9;
		int startNum = endNum - 8;
		
		
		int total=0;
		
		int totalPage=0;
		
		// 페이징 5개씩(1,2,3,4,5)
		int startPage = (pg-1)/5 * 5  +1 ;		//	1,5,11
		int endPage=startPage+4;
		
		List<Map<String,Object>> list=null;
		
		if(genre.equals("new")) {
			total= service.getTotal();
			System.out.println("전");
			list=service.reviewList(startNum,endNum);	// 여기서 에러 발생
			System.out.println("후");
		}else {		
			total= service.getGenreTotal(genre);
			list=service.genreReviewList(startNum,endNum,genre);
		}
		
		totalPage= (total+8) / 9;
		if(endPage > totalPage) endPage = totalPage;
	
		
		System.out.println("asd"+list.size());
		
		mv.addObject("list",list);
		mv.addObject("startPage",startPage);
		mv.addObject("endPage",endPage);
		mv.addObject("totalPage",totalPage);
		mv.addObject("pg",pg);
		mv.addObject("genre",genre);
		
		return mv;
	}
	
	
	@RequestMapping("boardsearch")
	public ModelAndView boardsearch(String word,String content,int pg) {
		ModelAndView mv= new ModelAndView("board.reviewList");
		List<Map<String,Object>> list=null;
		
		if(word == null) {
			word="title";
		}
		
	
		
		
		// 한페이지에 게시글 9개
		int endNum = pg * 9;
		int startNum = endNum - 8;
		int total=0;
		if(word.equals("title")) {
			total= service.searchtitleTotal(content);
			list=service.boardsearch(startNum,endNum,content);
		}else if(word.equals("writer")) {
			total=service.searchwriterTotal(content);
			list=service.searchWriter(startNum, endNum, content);
			
		}
		

		
		int totalPage= (total+8) / 9;
		
		// 페이징 5개씩(1,2,3,4,5)
		int startPage = (pg-1)/5 * 5  +1 ;		//	1,5,11
		int endPage=startPage+4;
		
		if(endPage > totalPage) endPage = totalPage;

		String genre=null;
	
		
	
		
		
		mv.addObject("list",list);
		mv.addObject("startPage",startPage);
		mv.addObject("endPage",endPage);
		mv.addObject("totalPage",totalPage);
		mv.addObject("pg",pg);
		mv.addObject("genre",genre);
		mv.addObject("word",word);
		mv.addObject("content",content);
		
		
		return mv;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("replyWrite")
	public ModelAndView replyWrite(HttpServletRequest request,ReplyDTO dto) {
		ModelAndView mv=new ModelAndView();
		HttpSession session= request.getSession();
		String id= (String) session.getAttribute("id");
		dto.setMember_id(id);
		int result=service.insertReply(dto);
		
		System.out.println("re_ref : "+dto.getRe_ref() + "re_lev : "+ dto.getRe_lev()+ "re_seq :"+dto.getRe_seq());
		
		mv.addObject("result",result);  
		mv.addObject("seq",dto.getRe_ref());
		mv.setViewName("board/replyResult");
		return mv;
	}
	
	
	@RequestMapping("replyModify")
	public ModelAndView replyModify(ReplyDTO dto) {
		ModelAndView mv= new ModelAndView();
		
		int result=service.replyModify(dto);
		
		
		mv.addObject("result",result);
		mv.addObject("seq",dto.getRe_ref());
		mv.setViewName("board/replyResult");
		return mv;
	}
	
	
	@ResponseBody
	@RequestMapping("insertRecommend")
	public int insertRecommend(int seq ,String id,HttpServletResponse response) {
		


		boolean state=service.checkRecommend(seq, id);
		int count= 0;

		if(state == false) {
			service.insertRecommend(seq, id);
			count= service.getRecommendTotal(seq);
		} else {
			count= service.getRecommendTotal(seq);
		}
			
		
		
		return count;
	}
	
	
	@ResponseBody
	@RequestMapping("deleteRecommend")
	public int deleteRecommend(int seq ,String id) {
		String msg="";
		System.out.println("취소"+" " +id +" "+ seq);
		
		service.deleteRecommend(seq, id);
		int count= service.getRecommendTotal(seq);
		return count;
		
		
	}
	
	@RequestMapping("boardModifyForm")
	public ModelAndView boardModifyForm(int seq) {
		ModelAndView mv= new ModelAndView("board.boardModifyForm");
		
		BoardDTO dto= service.boardView(seq);
		List<String> imgs=service.getImgs(seq);
		
		
		mv.addObject("dto",dto);
		mv.addObject("imgs",imgs);
		
		
		return mv;
	}

	
	@RequestMapping("boardModify")
	public ModelAndView boardModify(BoardDTO dto, List<MultipartFile> imgs,int seq,HttpServletRequest request) {
		ModelAndView mv= new ModelAndView("/board/boardModify");
		
		service.imagesDelete(seq);
		
		String filePath = request.getSession().getServletContext().getRealPath("/public");
		String folder="/storage";
		String realPath=filePath+folder;
		
		for (int i = 0; i < imgs.size(); i++) {
			String fileName = imgs.get(i).getOriginalFilename();
			
			if(fileName != null && fileName !="") {
				try {
					service.imageModify(fileName,seq);
					imgs.get(i).transferTo(new File(realPath+"/"+fileName));
					
				} catch (IllegalStateException e) {
					
					e.printStackTrace();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}

		}
		
		System.out.println(dto.getTitle()+ " " + dto.getGenre() + " " +dto.getContent());
		
		int result=service.boardModify(dto,seq);
		mv.addObject("result",result);
		
		
		return mv;
	}
	
	
	@RequestMapping("boardDelete")
	public ModelAndView boardDelete(int seq) {
		ModelAndView mv= new ModelAndView("/board/boardDeleteResult");
		int result= service.boardDelete(seq);
		mv.addObject("result",result);
		
		
		return mv;
	}
	

	
	@RequestMapping("myProfile")
	public ModelAndView myProfile(HttpServletRequest request) {
		ModelAndView mv= new ModelAndView("mypage.myProfile");
		HttpSession session=request.getSession();
		String id= (String) session.getAttribute("id");
		
		
		MemberDTO dto= member.selectOne(id);
		
		
		
		mv.addObject("dto",dto);
		
		return mv;
	}
	
	@RequestMapping("myRecommendList")
	public ModelAndView myRecommendList(HttpServletRequest request) {
		ModelAndView mv= new ModelAndView("mypage.myRecommendList");
		HttpSession session=request.getSession();
		String id= (String) session.getAttribute("id");
		
		List<BoardDTO> list= service.myRecommendList(id);
		
		mv.addObject("list",list);
		
		
		return mv;
	}
	
	
	
	@RequestMapping("genreboardList")
	public ModelAndView GenreboardList(String genre,int pg) {
		ModelAndView mv= new ModelAndView("board.reviewList");

		
		// 한페이지에 게시글 9개
		int endNum = pg * 9;
		int startNum = endNum - 8;
		
		int total= service.getGenreTotal(genre);
		
		int totalPage= (total+8) / 9;
		
		// 페이징 5개씩(1,2,3,4,5)
		int startPage = (pg-1)/5 * 5  +1 ;		//	1,5,11
		int endPage=startPage+4;
		
		if(endPage > totalPage) endPage = totalPage;

		
		List<Map<String,Object>> list=service.genreReviewList(startNum,endNum,genre);
		System.out.println(total);
		
		mv.addObject("list",list);
		mv.addObject("startPage",startPage);
		mv.addObject("endPage",endPage);
		mv.addObject("totalPage",totalPage);
		mv.addObject("pg",pg);
		mv.addObject("genre",genre);
		
		
		return mv;
	}
	
	
	
}
