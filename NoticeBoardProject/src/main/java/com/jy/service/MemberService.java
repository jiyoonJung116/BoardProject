package com.jy.service;

import com.jy.dto.JoinDto;
import com.jy.dto.MemberDto;

public interface MemberService {
	boolean checkLogin(String id, String pw);	//id와 pw 받아서 로그인.
	String getNameMemberId(String id);	//id 받아서 이름 출력.
	void boardJoin(JoinDto dto);	//파라미터로 회원가입 dto 받아서 회원가입.
	String getNicknameByLoginId(String id);	//id 받아서 닉네임 출력.
	int naverLogin(MemberDto dto);	//파라미터로 회원dto 받아서 네이버로그인.
}
