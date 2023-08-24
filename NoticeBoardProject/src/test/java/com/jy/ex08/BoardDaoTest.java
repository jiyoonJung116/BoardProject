package com.jy.ex08;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jy.dao.BoardDao;
import com.jy.dao.BoardDaoImpl;
import com.jy.dto.BoardDto;
import com.jy.dto.CommentDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class BoardDaoTest {
	@Autowired
	BoardDao bDao;
	
	@Test
	public void testSelectBoardList() throws Exception{
		int pageNum = 1;
		ArrayList<BoardDto> listBoard = (ArrayList<BoardDto>)bDao.selectBoardList(pageNum);
		System.out.println("읽어온 레코드 개수:"+listBoard.size());
		
		for(int i = 0; i<=listBoard.size()-1; i++) {
			System.out.println(i+1+")"+listBoard.get(i).getBno()+"/"+listBoard.get(i).getTitle()+"/ 조회수:"+listBoard.get(i).getHitcount());
		}
	}
	
	@Test
	public void testSelectLastPageNumber() throws Exception {
		System.out.println("last page number:"+bDao.selectlastPageNumber());
	}
	
	@Test
	public void testIncreaseHitCount() throws Exception{
		int bno = 62;
		bDao.increaseHitCount(bno);
	}
	
	@Test
	public void testSelectBoardDetail() throws Exception{
		int bno = 63;
		BoardDto dto = bDao.selectBoardDetail(bno);
		System.out.println("게시글 번호 : "+dto.getBno());
		System.out.println("제목 : "+dto.getTitle());
		System.out.println("내용:"+dto.getContent());
		System.out.println("조회수 :"+dto.getHitcount());
	}
	
	@Test
	public void testInsertBoard() throws Exception {
		BoardDto dto = new BoardDto("제목테스트", "하이", "yoon");
		bDao.insertBoard(dto);
	}
	
	@Test
	public void testInsertBoardAndPhoto() throws Exception {
		BoardDto dto = new BoardDto("안녕하세요", "사진이될까요?", "하이.jsp", "yoon");
		bDao.insertBoardAndPhoto(dto);
	}
	
	@Test
	public void testUpdateBoard() throws Exception {
		BoardDto dto = new BoardDto(124,"제목테스트", "되라얍");
		bDao.updateBoard(dto);
	}
	
	@Test
	public void testDeleteBoardList() throws Exception{
		int bno = 117;
		bDao.deleteBoard(bno);
	}
	
	@Test
	public void testSelectPhoto() throws Exception{
		ArrayList<BoardDto> photo = (ArrayList<BoardDto>)bDao.getPhoto();
		System.out.println("읽어온 레코드 개수:"+photo.size());
		
		for(int i = 0; i<=photo.size()-1; i++) {
			System.out.println(i+1+")"+photo.get(i).getPhoto());
		}
	}
	
	@Test
	public void testGetWriterId() throws Exception {
		String nickname="아기호랭이";
		int bno = 122;

		String writerId = bDao.getWriterId(nickname, bno);
		System.out.println(writerId);
	}
	
	@Test
	public void testCommentSelect() throws Exception {
		int bno = 76;
		ArrayList<CommentDto> comment = (ArrayList<CommentDto>)bDao.comment_select(bno);
		for(int i = 0; i<=comment.size()-1; i++) {
			System.out.println(i+1+")"+comment.get(i).getRno()+"/"+comment.get(i).getContent());
		}
	}
	
	@Test
	public void testSearchKeyword() throws Exception {
		String searchKeyword = "ㅋㅋㅋㅋ";
		ArrayList<BoardDto> shk = (ArrayList<BoardDto>)bDao.getBoardListBySearchKeyword(searchKeyword);
		for(int i = 0; i<=shk.size()-1; i++) {
			System.out.println(i+1+")"+shk.get(i).getBno()+"/"+shk.get(i).getTitle()+"/"+shk.get(i).getNickname()+"/"+shk.get(i).getWritedate()+"/"+shk.get(i).getHitcount());
		}
	}
	
	@Test
	public void testSelectBoard() throws Exception {
		ArrayList<BoardDto> selectBoard = (ArrayList<BoardDto>)bDao.board_select();
		for(int i = 0; i<=selectBoard.size()-1; i++) {
			System.out.println(i+1+")"+selectBoard.get(i).getBno()+"/"+selectBoard.get(i).getTitle()+"/"+selectBoard.get(i).getNickname()+"/"+selectBoard.get(i).getWritedate()+"/"+selectBoard.get(i).getHitcount());
		}
	}
	
}

