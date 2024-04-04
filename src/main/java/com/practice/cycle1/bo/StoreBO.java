package com.practice.cycle1.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.cycle1.domain.Store;
import com.practice.cycle1.mapper.StoreMapper;

@Service
public class StoreBO {
	
	@Autowired
	private StoreMapper storeMapper;
	
	// input: StoreMapper로 부터 받아옴
	// output: List<Store> (Mapper한테 받은 정보를 컨트롤러에게 돌려줌)
	public List<Store> getStoreList() {
		return storeMapper.selectStoreList();
	}
}
