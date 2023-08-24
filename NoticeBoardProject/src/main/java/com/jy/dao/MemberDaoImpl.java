package com.jy.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jy.dto.JoinDto;
import com.jy.dto.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao {
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public String selectPw(String id) {
		return sqlSession.selectOne("memberMapper.getPwById",id);
	}

	@Override
	public String selectName(String id) {
		return sqlSession.selectOne("memberMapper.getNameById",id);
	}

	@Override
	public void boardJoin(JoinDto dto) {
		sqlSession.insert("memberMapper.memberJoin", dto);
	}

	@Override
	public String getNicknameByLoginId(String id) {
		return sqlSession.selectOne("memberMapper.getNicknameById", id);
	}
	
	@Override
	public int naverLogin(MemberDto dto) {
	    String email = dto.getEmail();
	    String token = dto.getToken();

	    MemberDto existingMember = sqlSession.selectOne("memberMapper.naverLogin", email);

	    if (existingMember != null) {
	        String naverToken = existingMember.getToken();

	        if (naverToken.equals(token)) {
	            return 2; 
	        } else {
	            existingMember.setToken(token);
	            sqlSession.update("memberMapper.naverTokenUpdate", existingMember);
	            return 2;
	        }
	    } else {
	        Map<String, Object> paramMap = new HashMap<>();
	        paramMap.put("email", email);
	        paramMap.put("token", token);
	        paramMap.put("name", dto.getUsername());
	        paramMap.put("nickName", dto.getNickname());
	        paramMap.put("birthday", dto.getBirth());
	        paramMap.put("gender", dto.getGender());

	        sqlSession.insert("memberMapper.naverInsert", paramMap);
	        return 2;
	    }
	}


//	@Override
//    public int naverLogin(MemberDto dto) {
//        String email = dto.getEmail();
//        String token = dto.getToken();
//
//        Map<String, Object> paramMap = new HashMap<>();
//        paramMap.put("email", email);
//        paramMap.put("token", token);
//
//        int count = sqlSession.selectOne("memberMapper.naverLogin", email);
//
//        if (count > 0) {
//            String naverToken = sqlSession.selectOne("memberMapper.getNaverTokenByEmail", email);
//
//            if (naverToken.equals(token)) {
//                return 2; // 로그인
//            } else {
//                paramMap.put("token", token);
//                sqlSession.update("memberMapper.naverTokenUpdate", paramMap);
//                return 2;
//            }
//        } else {
//            paramMap.put("name", dto.getUsername());
//            paramMap.put("nickName", dto.getNickname());
//            paramMap.put("birthday", dto.getBirth());
//            paramMap.put("gender", dto.getGender());
//
//            sqlSession.insert("memberMapper.naverInsert", paramMap);
//            return 2;
//        }
//    }

}
