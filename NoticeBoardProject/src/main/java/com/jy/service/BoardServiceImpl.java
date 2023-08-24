package com.jy.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jy.dao.BoardDao;
import com.jy.dto.BoardDto;
import com.jy.dto.CommentDto;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardDao bDao;

	@Override
	public ArrayList<BoardDto> getBoardListByPageNumber(int pageNumber) {
		return bDao.selectBoardList(pageNumber);
	}

	@Override
	public int getLastPageNumber() {
		return bDao.selectlastPageNumber();
	}

	@Override
	public void increaseHitCount(int bno) {
		bDao.increaseHitCount(bno);
	}

	@Override
	public BoardDto getBoardDetail(int bno) {
		return bDao.selectBoardDetail(bno);
	}

	@Override
	public void insertBoard(BoardDto dto) {
		bDao.insertBoard(dto);
	}

	@Override
	public void updateBoard(BoardDto dto) {
		bDao.updateBoard(dto);
	}

	@Override
	public void deleteBoard(int bno) {
		bDao.deleteBoard(bno);
	}

	@Override
	public void insertBoardAndPhoto(BoardDto dto) {
		bDao.insertBoardAndPhoto(dto);
	}

	@Override
	public ArrayList<BoardDto> getPhoto() {
		return bDao.getPhoto();
	}

	@Override
	public String getWriterId(String nickname, int bno) {
		return bDao.getWriterId(nickname, bno);
	}

	@Override
	public ArrayList<CommentDto> comment_select(int bno) {
		return bDao.comment_select(bno);
	}

	@Override
	public ArrayList<BoardDto> getBoardListBySearchKeyword(String searchKeyword) {
		return bDao.getBoardListBySearchKeyword(searchKeyword);
	}

	@Override
	public ArrayList<BoardDto> board_select() {
		return bDao.board_select();
	}

}
