package com.pk.db;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pk.db.domain.Item;
import com.pk.db.domain.ItemReport;
import com.pk.db.domain.Member;
import com.pk.db.service.ItemService;
import com.pk.db.service.MemberService;
import com.pk.db.service.MemberServiceImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	// Service 객체를 주입
	@Autowired
	private ItemService itemService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request, Model model) {
		// 서비스 메소드 호출
		List<Item> list = itemService.getAll(request);
		
		// 데이터 저장
		model.addAttribute("list", list);
		
		return "home";
	}
	
	
	@RequestMapping(value = "/detail/{itemid}", method = RequestMethod.GET)
	public String detail(HttpServletRequest request, Model model, @PathVariable int itemid) {
		// 서비스 메소드 호출
		//Item item = itemService.getOne(request); //파라미터를 받을때
		Item item = itemService.getOne(request, itemid); // 파라미터를 받지 않을때
		
		// 데이터 저장
		model.addAttribute("item", item);
		
		return "detail";
	}
	
	@RequestMapping(value = "/chat", method = RequestMethod.GET)
	public String chat(HttpServletRequest request) {
		// 뷰 이름을 리턴
		return "chat";
	}
	
	// 엑셀파일 읽기
	@RequestMapping(value = "/item.xls", method = RequestMethod.GET)
	public String excel(HttpServletRequest request, Model model) {
		// 서비스 메소드 호출
		
		List<Item> list = itemService.getAll(request); 
		
		// 데이터 저장
		model.addAttribute("list", list);
		
		return "excel";
	}
	
	// pdf파일 읽기
	@RequestMapping(value = "/item.pdf", method = RequestMethod.GET)
	public String pdf(HttpServletRequest request, Model model) {
		// 서비스 메소드 호출

		List<Item> list = itemService.getAll(request); 

		// 데이터 저장
		model.addAttribute("list", list);

		return "pdf";
	}
	
	// json파일 읽기
	@RequestMapping(value = "/item1.json", method = RequestMethod.GET)
	public String item1json(HttpServletRequest request, Model model) {
		// 서비스 메소드 호출

		List<Item> list = itemService.getAll(request); 

		// 데이터 저장
		model.addAttribute("list", list);

		return "item1json";
	}
	
	// 문자열 리턴시 문자열 출력
	@RequestMapping(value="/item.xml", method=RequestMethod.GET)
	public String xml(HttpServletRequest request, Model model) {
		List<Item> list = itemService.getAll(request);
		
		ItemReport itemReport = new ItemReport();
		itemReport.setList(list);
		
		model.addAttribute("list", itemReport);
		
		return "xmlreport";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(HttpServletRequest request) {
		// 뷰이름을 리턴
	
		
		return "insert";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(MultipartHttpServletRequest request) {
		// 서비스 메소드 호출
		int result = itemService.insertItem(request);
		
		if (result <= 0) {
			
		}
		
		// 삽입, 삭제, 갱신 등 새로고침을 했을때 이전 작업을 다시 수행하면 안 되는 경웅는 리다이렉트를 해야합니다.
		// 리다이렉트 할때는 view 이름이 아니라 url 작성
		return "redirect:./";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request, Model model) {
		// 뷰의 이름을 리턴
		return "login";
	}
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, Model model, RedirectAttributes attrs){
		// RedirectAttributes는 redirect 할 때 1번만 사용하는 데이터를
		//	저장할 수 있는 Spring이 제공하는 클래스
		
		// 서비스의 메소드 호출
		Member member = memberService.login(request);
		
		// 로그인 처리도 redirect로 이동
		if(member == null) {
			// 로그인 실패의 경우 msg를 저장하고 login으로 다시 이동
			attrs.addFlashAttribute("msg", "없는 아이디거나 잘못된 비밀번호입니다.");
			return "redirect:login";
		} else {
			// 로그인 성공이면 메인 페이지로 이동
			
			// 로그인이 안 되어서 채팅뷰로 이동하지 못 하고 로그인 하게 된 경우
			//  채팅뷰로 이동하도록 해준다
			HttpSession session = request.getSession();
			String dest = (String)session.getAttribute("preCommand");
			
			// 이동할 URL이 있는지 확인하고 있으면 이동 및 세션 삭제
			if(dest != null) {
				// preCommand에 저장된 내용을 삭제 - 계속 남아서 문제를 발생 시킬 가능성이 있음
				session.removeAttribute("preCommand");
				
				return "redirect:"+dest;
			}
			
			// 로그인 성공이면 메인 페이지로 이동
			return "redirect:./";
		}
		
	}
		
	@RequestMapping(value = "/logout", method = RequestMethod.GET) // POST OR GET
	public String logout(HttpServletRequest request, HttpSession session) {	
		
		// 세션 초기화
		session.invalidate();
		// or session.removeAttribute("member");
		
		// 로그인과 로그아웃도 리다이렉트
		return "redirect:./";
	}
}
