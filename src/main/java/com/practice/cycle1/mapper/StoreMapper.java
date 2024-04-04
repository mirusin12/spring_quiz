package com.practice.cycle1.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.practice.cycle1.domain.Store;



@Mapper
public interface StoreMapper {
	// input: DB로 부터 가져옴
	// output: List<Store> (BO로 보내줌)
	public List<Store> selectStoreList(); 
}
