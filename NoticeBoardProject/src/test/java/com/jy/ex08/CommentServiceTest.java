package com.jy.ex08;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jy.dto.BoardDto;
import com.jy.dto.CommentDto;
import com.jy.service.CommentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class CommentServiceTest {
	@Autowired
	CommentService svc;
	
	@Test
	public void deleteComment() throws Exception {
		int rno = 110;
		svc.deleteComment(rno);;
	}
	
	@Test
	public void updateComment() throws Exception {
		svc.updateComment(new CommentDto(112, "점심을조금만먹을까"));
	}
	
	@Test
	public void getWritedate() throws Exception {
		int rno = 114;
		String writeDate = svc.getCommentWritedateByRno(rno);
		System.out.println(writeDate);
	}
	
	@Test
	public void writeComment() throws Exception {
		svc.writeComment(new CommentDto(1, "yoon", "테스트댓글"));
	}
	@Test
	public void writeReply() throws Exception {
		svc.writeReply(new CommentDto(116, 1, "yoon", "테스트대댓글1"));
	}
	
	
}

