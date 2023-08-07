package com.my.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import member.bean.MemberDTO;
import member.dao.MemberDao2;


@Service
@Qualifier("member_mybatis")
public class MemberServiceMybatisImpl  implements MemberService{

	@Autowired
	MemberDao2 dao;
	
	@Override
	public int memberWrite(MemberDTO dto) {
		// TODO Auto-generated method stub
		return dao.memberWrite(dto);
	}

	@Override
	public String login(String id, String pwd) {
		// TODO Auto-generated method stub
		return dao.login(id, pwd);
	}

	@Override
	public MemberDTO membermodify(String id) {
		// TODO Auto-generated method stub
		return dao.membermodify(id);
	}

	@Override
	public MemberDTO selectOne(String id) {
		// TODO Auto-generated method stub
		return dao.selectOne(id);
	}

	@Override
	public int idCheck(String id) {
		// TODO Auto-generated method stub
		return dao.CheckId(id);
	}

	@Override
	public int passwordModify(String id, String pwd) {
		// TODO Auto-generated method stub
		return dao.passwordModify(id, pwd);
	}

	@Override
	public MemberDTO selectAdmin(String id) {
		
		return dao.selectAdmin(id);
	}



}
