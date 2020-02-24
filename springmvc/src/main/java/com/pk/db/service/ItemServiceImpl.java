package com.pk.db.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.pk.db.dao.HibernateDao;
import com.pk.db.dao.ItemDao;
import com.pk.db.domain.Item;

// Bean을 자동 생성해주는 어노테이션
@Service
public class ItemServiceImpl implements ItemService {
	// ItemDao 타입의 Bean이 있으면 자동으로 주입시켜주는 어노테이션
	//@Autowired
	//private ItemDao dao;
	
	@Autowired
	private HibernateDao hibernateDao;
		
	@Override
	@Transactional
	public List<Item> getAll(HttpServletRequest request) {
		// Dao의 메소드에 파라미터가 없는 경우는 Dao 메소드를 호출해서 리턴
		
		// MyBatis
		//return dao.getAll();
		
		return hibernateDao.getAll();
	}
	
	@Override
	@Transactional
	public Item getOne(HttpServletRequest request) {
		// TODO Auto-generated method stub
		// MyBatis
		System.out.println("아이템번호  : "+Integer.parseInt(request.getParameter("itemid")));
		//return dao.getOne(Integer.parseInt(request.getParameter("itemid")));
		return hibernateDao.getOne(Integer.parseInt(request.getParameter("itemid")));
	}
	
	@Override
	@Transactional
	public Item getOne(HttpServletRequest request, int itemid) {
		// TODO Auto-generated method stub
		// MyBatis
		//return dao.getOne(itemid);
		return hibernateDao.getOne(itemid);
	}

	@Override
	@Transactional
	public int insertItem(MultipartHttpServletRequest request) {
		// 파라미터 읽기
		String itemid = request.getParameter("itemid");
		String itemname = request.getParameter("itemname");
		String price = request.getParameter("price");
		String description = request.getParameter("description");
		
		//Dao 객체의 파라미터 만들기
		Item item = new Item();
		item.setItemid(Integer.parseInt(itemid));
		item.setItemname(itemname);
		/*
		String temp = "";
		if(price.charAt(0) == '+' || price.charAt(0) == '-') {
			for(int i=1; i<price.length(); i++) {
				temp += price.charAt(i);
			}
		} 
		
		if(price.charAt(0) == '+') {
			item.setPrice(Integer.parseInt(temp));
		} else if(price.charAt(0) == '-' ) {
			item.setPrice(-1*Integer.parseInt(temp));
		} else {
			item.setPrice(Integer.parseInt(price));
		}
		*/
		item.setPrice(Integer.parseInt(price));
		item.setDescription(description);
		
		// 파일 읽기
		MultipartFile mf = request.getFile("pictureurl");
		
		// 업로드 할 파일이 존재하는 경우에만
		if(mf.isEmpty() == false) {
			// 원본 파일이름 가져오기
			String originName = request.getFile("pictureurl").getOriginalFilename();
			
			// 원본파일이름은 여러개의 파일을 업로드 하다보면 중복될 수 있기때문에
			// 파일이름을 만들때는 동일한 디렉토리에 저장한다면 중복되지 않도록 
			// 파일이름을 생성할 필요가 있음
			// 기본키와 파일명을 합치는 방법이 있고 UUID클래스를 이용해서 만드는 방법이 있음
			String uploadName = itemid + originName;
			item.setPictureurl(uploadName);
			// 파일을 저장할 경로를 생성
			// 프로젝트내의 경로를 가지고 절대경로를 생성
			// 프로젝트내의 경로가 아니면 직접 경로를 작성
			String uploadPath = request.getRealPath("/resources/images");
			
			//servlet 3.0 이상인 경우에는
			// request.getServletContext().getRealPath("/images");
			
			//업로드할 file객체 생서
			File file = new File(uploadPath + "\\" + uploadName);
			try {
				request.getFile("pictureurl").transferTo(file);
			} catch(IllegalStateException e) {
				e.printStackTrace();
			} catch(IOException e) {
				e.printStackTrace();
			}
			
		}
		
		return hibernateDao.insertItem(item);
	}
}
