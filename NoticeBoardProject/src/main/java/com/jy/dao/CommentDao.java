package com.jy.dao;

import com.jy.dto.CommentDto;

public interface CommentDao {
	void deleteComment(int rno);
	void updateComment(CommentDto dto);
	String getCommentWritedateByRno(int rno);
	void writeComment(CommentDto dto);
	public void writeReply(CommentDto dto);
}
