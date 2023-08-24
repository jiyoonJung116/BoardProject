package com.jy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jy.dao.CommentDao;
import com.jy.dto.CommentDto;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	CommentDao cDao;

	@Override
	public void deleteComment(int rno) {
		cDao.deleteComment(rno);
	}

	@Override
	public void updateComment(CommentDto dto) {
		cDao.updateComment(dto);
	}
	

	@Override
	public String getCommentWritedateByRno(int rno) {
		return cDao.getCommentWritedateByRno(rno);
	}

	@Override
	public void writeComment(CommentDto dto) {
		cDao.writeComment(dto);
	}

	@Override
	public void writeReply(CommentDto dto) {
		cDao.writeReply(dto);
	}

	

}
