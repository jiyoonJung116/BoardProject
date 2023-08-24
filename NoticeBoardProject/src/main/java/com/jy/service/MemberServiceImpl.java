package com.jy.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jy.dao.MemberDao;
import com.jy.dto.JoinDto;
import com.jy.dto.MemberDto;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberDao mDao;
	@Autowired
	SqlSession sqlSession;

	@Override
	public boolean checkLogin(String id, String pw) {
		String pwFromDB = mDao.selectPw(id); 
		if(pw!=null&& pw.equals(pwFromDB)) {
			return true; //로그인성공
		}
		return false;
	}

	@Override
	public String getNameMemberId(String id) {
		return mDao.selectName(id);
	}

	@Override
	public void boardJoin(JoinDto dto) {
		mDao.boardJoin(dto);
	}

	@Override
	public String getNicknameByLoginId(String id) {
		return mDao.getNicknameByLoginId(id);
	}

	@Override
	public int naverLogin(MemberDto dto) {
		String email = dto.getEmail();
        String token = dto.getToken();

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("email", email);
        paramMap.put("token", token);

        int count = mDao.naverLogin(dto);

        if (count > 0) {
            String naverToken = sqlSession.selectOne("memberMapper.naverLogin", email);

            if (naverToken.equals(token)) {
                return 2; // 로그인
            } else {
                paramMap.put("token", token);
                sqlSession.update("memberMapper.naverTokenUpdate", paramMap);
                return 2;
            }
        } else {
            paramMap.put("name", dto.getUsername());
            paramMap.put("nickName", dto.getNickname());
            paramMap.put("birthday", dto.getBirth());
            paramMap.put("gender", dto.getGender());

            sqlSession.insert("memberMapper.naverInsert", paramMap);
            return 2;
        }
	}

}
