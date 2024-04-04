package com.practice.cycle1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.cycle1.bo.StoreBO;
import com.practice.cycle1.domain.Store;

@RestController
// @RequestMapping("/cycle1/quiz2")
public class RestController1 {
	
	@Autowired
	private StoreBO storeBO;
	
	// http://localhost:8080/cycle1/quiz2/1
	@RequestMapping("/cycle1/quiz2/1")
	public List<Store> quiz021() {
		return storeBO.getStoreList();
	}
}
