package com.jy.ex08;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jy.dao.MemberDao;
import com.jy.dto.BoardDto;
import com.jy.dto.JoinDto;
import com.jy.dto.MemberDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MemberDaoTest {
	@Autowired
	MemberDao mDao;
	
	@Test
	public void testSelectPw() throws Exception {
		String id ="a";
		String pw = mDao.selectPw(id);
		System.out.println("id : " + id +", pw : "+pw );
	}
	
	@Test
	public void testSelectName() throws Exception {
		String id="a";
		String name = mDao.selectName(id);
		System.out.println("id:"+id+"name:"+name);
	}
	
	@Test
	public void testInsertMember() throws Exception{
		JoinDto dto = new JoinDto("yoon", "1234", "자윤", "jayoon@naver.com", "아기호랭이", "2023-04-05", "여성", "010-1234-5678");
		mDao.boardJoin(dto);
	}
	
	@Test
	public void testSelectNickname() throws Exception {
		String id = "yoon";
		String nickname = mDao.getNicknameByLoginId(id);
		System.out.println("별명 : "+nickname);
	}
	
	@Test
	public void testnaverLogin() throws Exception {
		mDao.naverLogin(new MemberDto("mpkung@naver.com", "", "정지윤", "mpkung@naver.com", "긍정부자", "여자", "01059205226", "20230824", "AAAANi1zJQF2HuxWKu-15OEtGt3vVZv0VToWTKoc7VpsnjzjPUBtWUWElTvRz8P8_z0l3q_muwDoiQ7l-eyUhjgp7Bs", "20001106"));
	}
}


























