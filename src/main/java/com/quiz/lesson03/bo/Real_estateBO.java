package com.quiz.lesson03.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson03.domain.Real_estate;
import com.quiz.lesson03.mapper.Real_estateMapper;

@Service
public class Real_estateBO {
	
	@Autowired
	private Real_estateMapper real_estateMapper;
	// input: int id
	// output: Real_estate
	
	public Real_estate getReal_estate(int id) {
		return real_estateMapper.selectReal_estate(id);
	}
	
	// input: rentPrice
	// output: List<Real_estate> ,   [] or 채워져 있거나
	public List<Real_estate> getReal_estateListByRentPrice(int rentPrice) {
		return real_estateMapper.selectReal_estateListByRentPrice(rentPrice);
	}
	
	// input: area & price
	// output: List<Real_estate>
	public List<Real_estate> getReal_estateListByAreaAndPrice(int area, int price) {
		return real_estateMapper.selectReal_estateListByAreaAndPrice(area, price);
	}
	
	// input: Real_estate
	// output: int(성공한 행의 개수)
	public int addRealEstate(Real_estate realEstate) {
		return real_estateMapper.insertRealEstate(realEstate);
	}
	
	// addRealEstateAsField(realtorId "썅떼빌리버 오피스텔 814호", 45, "월세", 100000, 120)
	public int addRealEstateAsField(int realtorId, String address, int area, String type, int price, Integer rentPrice) {
		return real_estateMapper.insertRealEstateAsField(realtorId, address, area, type, price, rentPrice);
	}
	
	// input: id, type, price
	// output: int(성공한 행 개수)
	public int updateRealEstateById(int id, String type, int price) {
		return real_estateMapper.updateRealEstateById(id, type, price);
	}
	
	// input: id
	// output: int(성공한 행 개수) !! 굳이 출력 하기 싫으면 void로 가능
	public int deleteRealEstateById(int id) {
		return real_estateMapper.deleteRealEstateById(id);
	}
	
	
}
