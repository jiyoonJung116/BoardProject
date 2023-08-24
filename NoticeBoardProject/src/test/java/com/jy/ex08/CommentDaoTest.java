package com.jy.ex08;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jy.dao.CommentDao;
import com.jy.dto.CommentDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class CommentDaoTest {
	@Autowired
	CommentDao cDao;
	
	@Test
	public void deleteComment() throws Exception {
		int rno = 113;
		cDao.deleteComment(rno);;
	}
	
	@Test
	public void updateComment() throws Exception {
		cDao.updateComment(new CommentDto(112, "배고파"));
	}
	
	@Test
	public void getWritedate() throws Exception {
		int rno = 114;
		String writeDate = cDao.getCommentWritedateByRno(rno);
		System.out.println(writeDate);
	}
	
	@Test
	public void writeComment() throws Exception {
		cDao.writeComment(new CommentDto(1, "yoon", "테스트댓글"));
	}
	@Test
	public void writeReply() throws Exception {
		cDao.writeReply(new CommentDto(116, 1, "yoon", "테스트대댓글"));
	}
}

