package com.my.member;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import member.bean.MemberDTO;



@RequestMapping("/member/")
@Controller
public class MemberController {
	


	 @Autowired
	 PasswordEncoder passwordEncoder;
	
	@Autowired
	@Qualifier("member_mybatis")
	MemberService service;
	
	@RequestMapping("loginForm")
	public String loginForm() {
		
		//return "member/loginForm";
		
		return "member.loginForm";
	}
	
	
	@RequestMapping("memberWriteForm")
	public String memberWriteForm() {

		
		return "member.memberWriteForm";
	}
	
	@RequestMapping("findPasswordForm")
	public String findPasswordForm() {
		
		return "member.findPasswordForm";
	}
	@RequestMapping("passwordModifyForm")
	public String passwordModifyForm() {
		
		return "member.passwordModifyForm";
	}
	
	@RequestMapping("memberWrite")
	public ModelAndView memberWrite(String id,String password,String name,String email,String email2,String year,String month,String day,HttpServletResponse response) {

		response.setCharacterEncoding("utf-8");

		String encodePW=passwordEncoder.encode(password);	//pwd 암호화해서 db 저장
		//encode() 메소드 1.패스워드를 암호화하는 메소드다.
		//				2.매개변수는 String타입이며 반환타입도 String이다.	
		
		MemberDTO dto= new MemberDTO();
		dto.setId(id);
		dto.setPwd(encodePW);
		dto.setName(name);
		dto.setEmail(email+email2);
		String birthday=year+month+day;
		dto.setBirthday(birthday);

		int result=0;
		ModelAndView mv=  new ModelAndView();
		
		if(service.idCheck(id) ==  1 ) {
			mv.setViewName("member.memberWriteForm");
		}else {
			result=service.memberWrite(dto);
			mv.setViewName("redirect:/index");
		}
		
		
	
		
		mv.addObject("result",result);
		return mv;
	}
	
	@ResponseBody
	@RequestMapping("checkId")
	public Map<String,Integer> CheckId(String id) {

		Map<String,Integer> map= new HashMap<String, Integer>();
		System.out.println(id);
		int result=service.idCheck(id);
		map.put("result", result);
		System.out.println(result);

		return map;
	}
	
	
	
	@RequestMapping( value="login", method= {RequestMethod.POST})
	public ModelAndView login(String id, String pwd, HttpServletRequest request) {
		HttpSession session=request.getSession();
		
		
		ModelAndView mv = new ModelAndView();	
		MemberDTO dto= null;
		
		if (id.contains("admin")) {
			System.out.print("관리자로그인");
			dto=service.selectAdmin(id);
			if(dto != null) {
				if(dto.getPwd().equals(pwd)) {
					String name=dto.getName();
					session.setAttribute("id", id);
					session.setAttribute("name", name);
					session.setAttribute("role", "admin");
					mv.setViewName("redirect:/index");
				} else {
					System.out.println("로그인실패");
					mv.addObject("result", 1);
					mv.setViewName("member.loginForm");
				}

			}
		}
		
		else {
			if (service.selectOne(id) != null) {
				dto = service.selectOne(id);
				// matches(java.lang.CharSequence rawPassword, java.lang.String encodePassword)
				// 1. 입력 pwd , 암호화된 pwd를 비교하여 boolean값 반환

				if (passwordEncoder.matches(pwd, dto.getPwd())) {
					System.out.println("pwd: " + pwd + " 암호화 : " + dto.getPwd());
					String name = dto.getName();
					session.setAttribute("id", id);
					session.setAttribute("name", name);
					session.setAttribute("role", "user");
					mv.setViewName("redirect:/index");
					

				} else {
					System.out.println("로그인실패");
					mv.addObject("result", 1);
					mv.setViewName("member.loginForm");
				}

			} else {

				mv.addObject("result", 1);
				mv.setViewName("member.loginForm");

			}
		}
	  
		return mv;
		
	}
	
	
	
	@RequestMapping("logout")
	public String logout(HttpServletRequest request) {
		
		HttpSession session=request.getSession();
		session.removeAttribute("name");
		session.removeAttribute("id");
		
		return "redirect:/index";
	}
	
	
	@RequestMapping("memberModifyForm")
	public ModelAndView memberModifyForm(HttpServletRequest request) {
		HttpSession session=request.getSession();
		String id = (String) session.getAttribute("id");
		MemberDTO dto= new MemberDTO();
		dto=service.membermodify(id);
		ModelAndView mv=new ModelAndView("mypage.memberModifyForm");
		mv.addObject("dto",dto);
		return mv;
	}
	
	@ResponseBody
	@RequestMapping("findPassword")
	public int findPassword(@RequestParam String id,HttpServletResponse response) {
		//response.setContentType("text/html; charset=utf-8");	
		return service.idCheck(id);
	}
	
	
	
	@RequestMapping("passwordModify")
	public ModelAndView passwordModify(String id,String password) {

		ModelAndView mv= new ModelAndView("member/passwordModify");
		
		String encodePW=passwordEncoder.encode(password);

		int result=service.passwordModify(id, encodePW);
		mv.addObject("result",result);
		
		return mv;
	}
	
	

	
	
	
	
}
