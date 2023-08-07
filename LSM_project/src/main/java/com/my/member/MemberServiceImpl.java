package com.my.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	MemberDAO dao;
	
	// @Autowired
	// private JavaMailSenderImpl javaMailSender;
	
	
	@Override
	public int memberWrite(MemberDTO dto) {
		int result=dao.memberWrite(dto);
		return result;
	}

	@Override
	public String login(String id, String pwd) {
		
		return dao.login(id, pwd);
	}

	@Override
	public MemberDTO membermodify(String id) {
		
		return dao.membermodify(id);
	}

	@Override
	public MemberDTO selectOne(String id) {
	
		return dao.selectOne(id);
	}

	@Override
	public int idCheck(String id) {
		
		return dao.CheckId(id);
	}

	@Override
	public int passwordModify(String id,String pwd) {
		
		return dao.passwordModify(id, pwd);
	}

	@Override
	public MemberDTO selectAdmin(String id) {
		// TODO Auto-generated method stub
		return null;
	}



}
