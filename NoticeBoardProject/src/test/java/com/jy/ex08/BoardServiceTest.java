package com.jy.ex08;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jy.dao.BoardDao;
import com.jy.dto.BoardDto;
import com.jy.dto.CommentDto;
import com.jy.service.BoardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class BoardServiceTest {
	@Autowired
	BoardService svc;
	
	@Test
	public void testGetBoardListByPageNumber() throws Exception {
		int pageNum = 1;
		ArrayList<BoardDto> list1 = svc.getBoardListByPageNumber(pageNum);
		for(BoardDto dto : list1) {
			System.out.println("게시글 번호 : "+dto.getBno());
			System.out.println("제목 : "+dto.getTitle());
			System.out.println("내용:"+dto.getContent());
			System.out.println("조회수 :"+dto.getHitcount());
		}
	}
	
	@Test
	public void testGetLastPageNumber() throws Exception {
		System.out.println("마지막 페이지 번호:"+svc.getLastPageNumber());
	}
	
	@Test
	public void testIncreaseHitCount() throws Exception {
		int bno = 1;
		svc.increaseHitCount(bno);
	}
	
	@Test
	public void testGetBoardDetail() throws Exception{
		int bno = 1;
		BoardDto dto = svc.getBoardDetail(bno);
		System.out.println("게시글 번호 : "+dto.getBno());
		System.out.println("제목 : "+dto.getTitle());
		System.out.println("내용:"+dto.getContent());
		System.out.println("조회수 :"+dto.getHitcount());
	}
	
	@Test
	public void testWriteBoard() throws Exception{
		String title = "hi";
		String content ="서비스테스트";
		String loginId = "a";
		svc.insertBoard(new BoardDto(title, content, loginId));
	}
	
	@Test
	public void testWriteBoardAndPhoto() throws Exception{
		String title = "hi";
		String content ="서비스테스트";
		String loginId = "a";
		String photo = "일어나.jsp";
		svc.insertBoardAndPhoto(new BoardDto(title, content, photo, loginId));
	}
	
	@Test
	public void testModifyBoard() throws Exception{
		int bno = 125;
		String title = "오빠";
		String content ="피곤해?";
		svc.updateBoard(new BoardDto(bno, title, content));
	}
	
	@Test
	public void testDeleteBaord() throws Exception {
		int bno = 119;
		svc.deleteBoard(bno);
	}
	
	@Test
	public void testGetPhoto() throws Exception {
		ArrayList<BoardDto> photo = (ArrayList<BoardDto>)svc.getPhoto();
		System.out.println("읽어온 레코드 개수:"+photo.size());
		
		for(int i = 0; i<=photo.size()-1; i++) {
			System.out.println(i+1+")"+photo.get(i).getPhoto());
		}
	}
	
	@Test
	public void testGetWriterId() throws Exception {
		String nickname="아기호랭이";
		int bno = 122;

		String writerId = svc.getWriterId(nickname, bno); 
		System.out.println(writerId);
	}
	
	@Test
	public void testGetComment() throws Exception {
		int bno = 76;
		ArrayList<CommentDto> comment = (ArrayList<CommentDto>)svc.comment_select(bno);
		for(int i = 0; i<=comment.size()-1; i++) {
			System.out.println(i+1+")"+comment.get(i).getRno()+"/"+comment.get(i).getContent());
		}
	}
	
	@Test
	public void testGetSearchKeyword() throws Exception {
		String searchKeyword = "ㅋㅋㅋㅋ";
		ArrayList<BoardDto> shk = (ArrayList<BoardDto>)svc.getBoardListBySearchKeyword(searchKeyword);
		for(int i = 0; i<=shk.size()-1; i++) {
			System.out.println(i+1+")"+shk.get(i).getBno()+"/"+shk.get(i).getTitle()+"/"+shk.get(i).getNickname()+"/"+shk.get(i).getWritedate()+"/"+shk.get(i).getHitcount());
		}
	}
	
	@Test
	public void testSelectBoard() throws Exception {
		ArrayList<BoardDto> selectBoard = (ArrayList<BoardDto>)svc.board_select();
		for(int i = 0; i<=selectBoard.size()-1; i++) {
			System.out.println(i+1+")"+selectBoard.get(i).getBno()+"/"+selectBoard.get(i).getTitle()+"/"+selectBoard.get(i).getNickname()+"/"+selectBoard.get(i).getWritedate()+"/"+selectBoard.get(i).getHitcount());
		}
	}
}

