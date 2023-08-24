package com.jy.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jy.dto.BoardDto;
import com.jy.dto.CommentDto;
import com.jy.service.BoardService;
import com.jy.service.CommentService;

@Controller
public class CommentController {
	@Autowired
	BoardService bsvc;
	@Autowired
	CommentService csvc;


	@RequestMapping(value = "/commentWrite")
	public String writeComment(@RequestParam int bno,CommentDto dto, Model model) {
		ArrayList<CommentDto> listComment = bsvc.comment_select(bno);
		csvc.writeComment(dto);
		model.addAttribute("bno",bno);
		model.addAttribute("listComment", listComment);
	    return "redirect:NoticeBoardDetail";
	}
	
	@RequestMapping(value= "/replyWrite")
	public String writeReply(@RequestParam int bno,CommentDto dto, Model model) {
		ArrayList<CommentDto> listComment = bsvc.comment_select(bno);
		csvc.writeReply(dto);
		model.addAttribute("bno",bno);
		model.addAttribute("listComment", listComment);
	    return "redirect:NoticeBoardDetail";
	}


}
