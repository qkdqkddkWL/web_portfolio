package com.my.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.my.board.BoardService;

@Controller
public class IndexController {

	@Autowired
	@Qualifier("board_mybatis")
	BoardService service;
	
	
	
	
	
	@RequestMapping("/index")
	public ModelAndView index() {
		System.out.println(service.RecommendReviewList().size());
		System.out.println("접속");
		ModelAndView mv= new ModelAndView("root.index");
		
		System.out.println("아이디 : "+ " "+ service.newestReviewList().get(0).get("id"));
		
		
		mv.addObject("list",service.newestReviewList());
		mv.addObject("list2",service.RecommendReviewList());
		
		return mv;
	}
	
}
