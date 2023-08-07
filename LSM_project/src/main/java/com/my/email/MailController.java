package com.my.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@RequestMapping("/email/")
@Controller
public class MailController {

	@Autowired
	MailSendService service;
	
	
	
	@ResponseBody
	@RequestMapping("emailCode")
	public String emailCode(String email) {
		
		System.out.println("이메일로 인증번호 발송");
		return service.joinEmail(email);
	}
	
}
