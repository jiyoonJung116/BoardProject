package com.jy.ex08;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jy.dto.JoinDto;
import com.jy.dto.MemberDto;
import com.jy.service.MemberServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MemberServiceTest {
	@Autowired
	MemberServiceImpl svc;
	
	@Test
	public void testCheckLogin() throws Exception{
		String id="a";
		String pw = "123";
		System.out.println(svc.checkLogin(id, pw));
	}
	
	@Test
	public void testGetNameByMemberid() throws Exception{
		String id="a";
		System.out.println(svc.getNameMemberId(id));
	}
	
	@Test
	public void testMemberJoin() throws Exception {
		JoinDto dto = new JoinDto("bubble", "1234", "스테이씨", "jayoon@naver.com", "아기호랭이", "2023-04-05", "여성", "010-1234-5678");
		svc.boardJoin(dto);
	}
	
	@Test
	public void testGetNickNameByMemberid() throws Exception {
		String id="yoon";
		System.out.println(svc.getNicknameByLoginId(id));
	}
	
	@Test
	public void testnaverLogin() throws Exception {
		svc.naverLogin(new MemberDto("mpkung@naver.com", "", "정지윤", "mpkung@naver.com", "긍정부자", "여자", "01059205226", "20230824", "AAAANi1zJQF2HuxWKu-15OEtGt3vVZv0VToWTKoc7VpsnjzjPUBtWUWElTvRz8P8_z0l3q_muwDoiQ7l-eyUhjgp7Bs", "20001106"));
	}

	
// mapper(SQL) > Dao,DaoImpl -> DaoTest(jUnit) -> Service, ServiceImpl ->ServiceTest(jUnit)->사용(컨트롤러,jsp)
	
	
	
	
}

