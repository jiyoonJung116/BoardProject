package com.jy.dao;

import com.jy.dto.JoinDto;
import com.jy.dto.MemberDto;

public interface MemberDao {
	String selectPw(String id);
	String selectName(String id);
	void boardJoin(JoinDto dto);
	String getNicknameByLoginId(String id);
	int naverLogin(MemberDto dto);
}
