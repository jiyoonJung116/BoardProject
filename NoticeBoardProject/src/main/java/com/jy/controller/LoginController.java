package com.jy.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jy.dto.JoinDto;
import com.jy.dto.MemberDto;
import com.jy.service.MemberService;

@Controller
public class LoginController {
	@Autowired
	MemberService msvc;

	@RequestMapping(value = "/login")
	public String home(Locale locale, Model model) {
		return "Login";
	}

	@RequestMapping(value = "/LoginCheck")
	public String loginCheck(String id, String pw, Model model, HttpSession session) {
		boolean result = false;
		result = msvc.checkLogin(id, pw);

		if (result) {
			session.setAttribute("loginId", id);
			return "redirect:NoticeBoard";
		}
		// 로그인 실패시
		model.addAttribute("msg", "잘못된 로그인 정보입니다.");
		return "forward:/";
	}

	@RequestMapping("/logout")
	public String memberLogout(HttpSession session) {
		session.invalidate();
		return "NoticeBoard";
	}

	@RequestMapping("/join")
	public String memberJoin(Model model) {
		return "NoticeBoardJoin";
	}

	@RequestMapping(value = "/joinComplete", method = RequestMethod.POST)
	public String join(HttpServletRequest request, HttpServletResponse response, JoinDto jDto) {
		msvc.boardJoin(jDto);
		return "Login";
	}
	
	@RequestMapping("/NaverLogin")
	public String naverLogin(MemberDto dto) {
		msvc.naverLogin(dto);
		return "Login";
	}
	
	@RequestMapping("/Callback")
	public String moveCallback() {
		return "callback";
	}

}
