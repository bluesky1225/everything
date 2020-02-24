package com.pk.db;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.pk.db.domain.Item;
import com.pk.db.domain.ItemReport;
import com.pk.db.service.ItemService;

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
}
