package com.jy.service;

import java.util.ArrayList;

import com.jy.dto.BoardDto;
import com.jy.dto.CommentDto;

public interface BoardService {
	ArrayList<BoardDto> getBoardListByPageNumber(int pageNumber); //파라미터로 페이지번호를 받아 게시글 목록을 리턴.
	int getLastPageNumber(); //마지막 페이지 번호를 리턴.
	void increaseHitCount(int bno); //파라미터로 게시글 번호를 받아 조회수를 1증가
	BoardDto getBoardDetail(int bno); //파라미터로 게시글 번호를 받아 게시글 dto를 리턴
	void insertBoard(BoardDto dto); //파라미터로 게시글 dto를 받아서 새 글 등록(사진X).
	void insertBoardAndPhoto(BoardDto dto); //파라미터로 게시글 dto 받아서 새글 등록(사진O).
	void updateBoard(BoardDto dto); //파라미터로 게시글 dto를 받아서 새 글 수정.
	void deleteBoard(int bno); //파라미터로 게시글 번호를 받아 해당 게시글 삭제
	ArrayList<BoardDto> getPhoto(); //사진이 있는 게시글만 리턴.
	String getWriterId(String nickname, int bno);//파라미터로 게시글 dto를 받아서 작성자ID 리턴.
	ArrayList<CommentDto> comment_select(int bno);//파라미터로 댓글 dto받아서 댓글 리턴.
	ArrayList<BoardDto> getBoardListBySearchKeyword(String searchKeyword); //파라미터로 검색키워드 받아서 검색키워드 포함된 게시글 조회
	ArrayList<BoardDto> board_select(); //게시글 전체 조회
}
