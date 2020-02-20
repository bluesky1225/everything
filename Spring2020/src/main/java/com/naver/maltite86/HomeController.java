package com.naver.maltite86;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.naver.maltite86.domain.User;

/**
 * Handles requests for the application home page.
 */
// Controller 클래스를 만들어주고 Bean을 자동생성해주는 어노테이션
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	// 요청이 GET 방식으로 오면 처리하는 메소드 설정
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		// model에 attribute를 저장하면 request 객체에 저장
		// 문자열을 리턴하면 이 문자열이 view의 이름이다
		// /(기본 요청)요청이 오면 serverTime이라는 attribute를 request에 저장해서
		// home -> WEB-INF/views/home.jsp로 포워딩 함
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		// request 객체
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/display", method = RequestMethod.GET)
	public String display(Model model) {
		String msg = "테스트 성공";
		
		// request.setAttribute()와 동일
		model.addAttribute("mymessage", msg);
		
		return "display";
	}
	
	@RequestMapping(value = "/param", method = RequestMethod.GET)
	public String param(Model model, HttpServletRequest request) {
		String num = request.getParameter("num");
		System.out.println("num의 값 출력 결과 : "+num);
		return "";
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public String get(Model model, @RequestParam("keyword") String keyword) {
		//String keyword = request.getParameter("keyword");
		System.out.println("keyword의 값 출력 결과 : "+keyword);
		return "";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model, User user) {
		System.out.println(user);
		return "";
	}
	
	@RequestMapping(value = "/article/{num}", method = RequestMethod.GET)
	public String login(Model model, @PathVariable int num) {
		System.out.println(num);
		return "";
	}
}
