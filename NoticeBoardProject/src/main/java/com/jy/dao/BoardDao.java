package com.jy.dao;

import java.util.ArrayList;

import com.jy.dto.BoardDto;
import com.jy.dto.CommentDto;

public interface BoardDao {
	ArrayList<BoardDto> selectBoardList(int pageNumber);
	int selectlastPageNumber();
	void increaseHitCount(int bno);
	BoardDto selectBoardDetail(int bno);
	void insertBoard(BoardDto dto);
	void insertBoardAndPhoto(BoardDto dto);
	void updateBoard(BoardDto dto);
	void deleteBoard(int bno);
	ArrayList<BoardDto> getPhoto();
	String getWriterId(String nickname, int bno);
	ArrayList<CommentDto> comment_select(int bno);
	ArrayList<BoardDto> getBoardListBySearchKeyword(String searchKeyword);
	ArrayList<BoardDto> board_select();
}
