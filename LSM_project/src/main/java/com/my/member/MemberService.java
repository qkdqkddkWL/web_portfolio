package com.my.member;

import member.bean.MemberDTO;

public interface MemberService {
	public int memberWrite(MemberDTO dto);
	public String login(String id, String pwd);
	public MemberDTO membermodify(String id);
	
	
	public MemberDTO selectAdmin(String id);
	public MemberDTO selectOne(String id);
	public int idCheck(String id);
	public int passwordModify(String id ,String pwd);
	

}
