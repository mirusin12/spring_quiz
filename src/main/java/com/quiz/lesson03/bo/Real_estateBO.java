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
	
	
	
}
