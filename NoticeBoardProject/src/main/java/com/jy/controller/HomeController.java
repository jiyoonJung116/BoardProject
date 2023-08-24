package com.jy.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jy.service.BoardService;
import com.jy.service.MemberService;

@Controller
public class HomeController {
	@Autowired
	MemberService msvc;
	@Autowired
	BoardService bsvc;
	
	@RequestMapping(value = "/")
	public String home(Locale locale, Model model) {
		return "NoticeBoard";
	}
	
}
