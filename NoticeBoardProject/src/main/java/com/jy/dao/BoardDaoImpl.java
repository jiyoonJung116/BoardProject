package com.jy.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jy.dto.BoardDto;
import com.jy.dto.CommentDto;

@Repository
public class BoardDaoImpl implements BoardDao {
	@Autowired
	SqlSession sqlSession;

	@Override
	public ArrayList<BoardDto> selectBoardList(int pageNumber) {
		// start, end : rownum '시작값'과 '끝값'을 결정.
		int start = pageNumber*20-29;
		int end = pageNumber*30;
		
		//mapper에게 값을 전달(1개만 가능) ?? > 2개 이상을 넘겨야 되는데 ?? 그래서 Map객체를 이용
		HashMap<String, Integer> mapParams = new HashMap<String, Integer>();
		mapParams.put("start", start);
		mapParams.put("end", end);
		
		List<BoardDto> listBoard = sqlSession.selectList("boardMapper.selectBoardList",mapParams);
		ArrayList<BoardDto> list2 = new ArrayList<BoardDto>();
		list2.addAll(listBoard);
		return list2;
	}

	@Override
	public int selectlastPageNumber() {	//마지막 페이지 번호를 리턴
		int boardCount = sqlSession.selectOne("boardMapper.selectAllCount");
		int pageCount = boardCount/20;
		pageCount += (boardCount%20>0?1:0);
		return pageCount;
	}

	@Override
	public void increaseHitCount(int bno) {
		sqlSession.update("boardMapper.incHitCount", bno);
	}

	@Override
	public BoardDto selectBoardDetail(int bno) {
		return sqlSession.selectOne("boardMapper.selectBoardDetail", bno);
	}

	@Override
	public void insertBoard(BoardDto dto) {
		sqlSession.insert("boardMapper.insertBoard", dto);
	}

	@Override
	public void updateBoard(BoardDto dto) {
		sqlSession.update("boardMapper.updateBoard", dto);
	}

	@Override
	public void deleteBoard(int bno) {
		sqlSession.delete("boardMapper.deleteBoard", bno);
	}

	@Override
	public void insertBoardAndPhoto(BoardDto dto) {
		sqlSession.insert("boardMapper.insertBoardAndPhoto", dto);
	}

	@Override
	public ArrayList<BoardDto> getPhoto() {
		List<BoardDto> photo = sqlSession.selectList("boardMapper.selectPhoto");
		ArrayList<BoardDto> photo2 = new ArrayList<BoardDto>();
		photo2.addAll(photo);
		return photo2;
	}

	@Override
	public String getWriterId(String nickname, int bno) {
	    Map<String, Object> paramMap = new HashMap<>();
	    paramMap.put("nickname", nickname);
	    paramMap.put("bno", bno);

	    return sqlSession.selectOne("boardMapper.getWriterId", paramMap);
	}

	@Override
	public ArrayList<CommentDto> comment_select(int bno) {
		List<CommentDto> comment = sqlSession.selectList("boardMapper.selectComment", bno);
		ArrayList<CommentDto> comment2 = new ArrayList<CommentDto>();
		comment2.addAll(comment);
		return comment2;
	}

	@Override
	public ArrayList<BoardDto> getBoardListBySearchKeyword(String searchKeyword) {
		List<BoardDto> shk = sqlSession.selectList("boardMapper.searchKeyword", searchKeyword);
		ArrayList<BoardDto> shk2 = new ArrayList<BoardDto>();
		shk2.addAll(shk);
		return shk2;
	}

	@Override
	public ArrayList<BoardDto> board_select() {
		List<BoardDto> selectBoard = sqlSession.selectList("boardMapper.boardSelect");
		ArrayList<BoardDto> selectBoard2 = new ArrayList<BoardDto>();
		selectBoard2.addAll(selectBoard);
		return selectBoard2;
	}
	
	
	
}
