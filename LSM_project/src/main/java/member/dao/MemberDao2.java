package member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import member.bean.MemberDTO;

@Component
public class MemberDao2 {

	
	
	
	@Autowired
	SqlSessionTemplate sqlSession;
	

	public int memberWrite(MemberDTO dto) {
		
		return sqlSession.insert("mybatis.memberMapper.memberWrite",dto);

	}
	
	public String login(String id, String pwd) {
		Map<String, String> map= new HashMap<String,String>();
		map.put("id", id);
		map.put("pwd", pwd);
		
		return sqlSession.selectOne("mybatis.memberMapper.login",map);
		

	}
	
	public MemberDTO membermodify(String id) {
		
		return sqlSession.selectOne("mybatis.memberMapper.membermodify",id);

	}
	
	public MemberDTO selectAdmin(String id) {
		
		return sqlSession.selectOne("mybatis.memberMapper.selectAdmin",id);

	}
	
	
	
	public MemberDTO selectOne(String id) {
		
		return sqlSession.selectOne("mybatis.memberMapper.selectOne",id);

	}
	
	
	public int CheckId(String id) {
		
		int result=0;
		String check=sqlSession.selectOne("mybatis.memberMapper.CheckId",id);

			
		if(check != null) {
			result=1;
		}	
		else 
			result=0;
		
			
		return result;

	}
	
	public int passwordModify(String id, String pwd) {
		
		Map<String, String> map= new HashMap<String,String>();
		map.put("id", id);
		map.put("pwd", pwd);
		
		return sqlSession.update("mybatis.memberMapper.passwordModify",map);

	
	}
	
	
}
