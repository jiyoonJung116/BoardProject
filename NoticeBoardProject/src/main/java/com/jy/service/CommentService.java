package com.jy.service;

import com.jy.dto.CommentDto;

public interface CommentService {
	void deleteComment(int rno);	//댓글 번호를 받아 댓글 삭제. 
	void updateComment(CommentDto dto);	//파라미터로 댓글 dto 받아서 댓글 수정. 
	String getCommentWritedateByRno(int rno);	//댓글 번호를 받아 댓글날짜 리턴.
	void writeComment(CommentDto dto);	//파라미터로 댓글 dto를 받아서 댓글 작성.
	public void writeReply(CommentDto dto);	//파라미터로 댓글 dto를 받아서 대댓글 작성.
}
