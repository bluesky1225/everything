package com.pk.db.util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

// 클래스 이름에 Adapter가 붙는 클래스는 Adapter를 제외한 Interface가 존재
// Interface는 모든 메소드를 재정의해야하고 Adapter 클래스는 필요한 메소드만 재정의하면 된다

// Bean을 자동 생성해주는 어노테이션 : Component, Controller, Service, Repository, RestController
@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		boolean result = false;
		
		// 로그인이 안 된 것을 확인
		if(request.getSession().getAttribute("member") != null) { 
			result = true;
		} else {
			try {
				HttpSession session = request.getSession();
				String command = request.getRequestURI().substring(request.getContextPath().length());
				String queryString = request.getQueryString(); // 파라미터 가져오기
				
				if(queryString != null) {
					command += "?" + queryString;
				}
				
				session.setAttribute("preCommand", command);
				
				// 로그인 페이지로 이동할 때 메시지 저장
				request.getSession().setAttribute("msg", "채팅을 하려면 로그인 상태여야합니다.");
				
				// 로그인이 되어있지않으면 로그인 페이지로 이동
				response.sendRedirect("login");
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {	// 출력용 modelAndView
		// TODO Auto-generated method stub
		System.out.println("Controller의 요청을 정상적으로 처리");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
	}
	
}
