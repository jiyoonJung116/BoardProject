package com.jy.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jy.dto.BoardDto;
import com.jy.dto.CommentDto;
import com.jy.service.BoardService;
import com.jy.service.CommentService;

@Controller
public class BoardController {
	@Autowired
	BoardService bsvc;
	@Autowired
	CommentService csvc;
	
	@RequestMapping("/NoticeBoard")
	public String boardList(Integer page, Model model) {
		if(page==null) page=1;
		ArrayList<BoardDto> listBoard = bsvc.getBoardListByPageNumber(page);
		model.addAttribute("listBoard",listBoard);
		model.addAttribute("page",page);
		return "NoticeBoard";
	}
	
	@RequestMapping("/board_write")
	public String boardWrite(Model model) {
		return "NoticeBoardWrite";
	}
	
	@PostMapping("/boardWrite")
	public String writeBoard(BoardDto dto) {
	    bsvc.insertBoard(dto);
	    return "redirect:NoticeBoard";
	}
	
	@RequestMapping("/boardDetail")
	public String boardDetail(@RequestParam int bno, @RequestParam String nickname,Model model) {
		bsvc.increaseHitCount(bno);
		String writerId = bsvc.getWriterId(nickname, bno);
		BoardDto detailBoard = bsvc.getBoardDetail(bno);
		ArrayList<CommentDto> listComment = bsvc.comment_select(bno);	
		
		model.addAttribute("bno",bno);
        model.addAttribute("nickname", nickname);
        model.addAttribute("writerId", writerId);
        model.addAttribute("detailBoard", detailBoard);
        model.addAttribute("listComment", listComment);

        return "NoticeBoardDetail"; 
	}
	
	@RequestMapping("/notice_update_form")
	public String boardUpdateForm(@RequestParam int bno,Model model) {
		BoardDto detailBoard = bsvc.getBoardDetail(bno);
		model.addAttribute("detailBoard", detailBoard);
		model.addAttribute("bno",bno);
		return "NoticeBoardUpdate";
	}
	
	@RequestMapping("/noticeUpdate")
	public String boardUpdate(@RequestParam int bno,BoardDto dto,Model model) {
	    bsvc.updateBoard(dto);
	    model.addAttribute("bno",bno);
	    return "redirect:NoticeBoardDetail";
	}
	
	@GetMapping("/NoticeBoardDetail") 
	public String showBoardDetail(@RequestParam int bno, BoardDto dto,Model model) {
		BoardDto detailBoard = bsvc.getBoardDetail(bno);
		model.addAttribute("detailBoard", detailBoard);
		model.addAttribute("bno",bno);
	    return "NoticeBoardDetail"; 
	}
	
	@RequestMapping("/noticeDelete")
	public String boardDelete(@RequestParam int bno,Model model) {
		bsvc.deleteBoard(bno);
		return "redirect:NoticeBoard";
	}
	
	

	

	
	
}
