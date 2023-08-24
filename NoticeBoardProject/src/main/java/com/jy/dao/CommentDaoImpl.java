package com.jy.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jy.dto.CommentDto;

@Repository
public class CommentDaoImpl implements CommentDao {
	@Autowired
	SqlSession sqlSession;

	@Override
	public void deleteComment(int rno) {
		sqlSession.delete("commentMapper.deleteComment", rno);
	}

	@Override
	public void updateComment(CommentDto dto) {
		sqlSession.update("commentMapper.commentUpdate", dto);
	}


	@Override
	public String getCommentWritedateByRno(int rno) {
		return sqlSession.selectOne("commentMapper.getWritedate", rno);
	}

	@Override
	public void writeComment(CommentDto dto) {
		sqlSession.insert("commentMapper.writeComment", dto);
	}

	@Override
	public void writeReply(CommentDto dto) {
		sqlSession.insert("commentMapper.writeReply", dto);
	}

	

}
