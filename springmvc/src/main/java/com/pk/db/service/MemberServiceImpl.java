package com.pk.db.service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.pk.db.dao.MemberDao;
import com.pk.db.domain.Member;

public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDao memberDao;
	
	@Transactional
	@Override
	public Member login(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Member member = null;
		
		// 파라미터 읽기
		String userid = request.getParameter("myid");
		String userpw = request.getParameter("mypw");
		
		member = new Member();
		member.setUserid(userid);
		memberDao = new MemberDao();
		// userid에 해당하는 데이터 찾아오기
		member = memberDao.login(member);
		
		// userid에 해당하는 데이터가 있다면
		if(member != null) {
			if(member.getUserpw().contentEquals(userpw)) {
				// 로그인 성공한 경우는 session에 로그인 정보를 저장
				member.setUserpw(null);
				request.getSession().setAttribute("member", member);
			} else {
				//로그인 실패
				member = null;
			}
		}
		
		return member;
	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub

	}

}
