package com.pk.db.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	
}
