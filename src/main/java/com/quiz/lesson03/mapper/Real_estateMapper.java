package com.quiz.lesson03.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.quiz.lesson03.domain.Real_estate;

@Mapper
public interface Real_estateMapper {
	public Real_estate selectReal_estate(int id);
	public List<Real_estate> selectReal_estateListByRentPrice(int rentPrice);
	public List<Real_estate> selectReal_estateListByAreaAndPrice(int area, int price);
}
