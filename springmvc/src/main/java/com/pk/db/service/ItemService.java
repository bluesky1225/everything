package com.pk.db.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.pk.db.domain.Item;

public interface ItemService {
	// 전체 데이터를 가져오는 메소드
	public List<Item> getAll(HttpServletRequest request);
	
	// 데이터를 1개 가져오는 메소드
	public Item getOne(HttpServletRequest request);
	
	// 파라미터를 읽지않고 받는 메소드
	public Item getOne(HttpServletRequest request, int itemid);
	
	// 데이터 삽입(파일 업로드) 처리를 위한 메소드
	public int insertItem(MultipartHttpServletRequest request);
}
