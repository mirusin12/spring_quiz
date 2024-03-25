package com.quiz.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson02.domain.Store;
import com.quiz.lesson02.mapper.StoreMapper;

@Service
public class StoreBO {
	
	@Autowired
	private StoreMapper storeMapper;
	
	// input: 컨트롤러로 부터 요청 받음 즉 받는게 없음
	// output: 컨트롤러로 돌려줌 List<Store>
	public List<Store> getStoreList() {
		return storeMapper.selectStoreList();
	}
}
