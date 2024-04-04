package com.quiz.lesson03.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.lesson03.domain.Real_estate;

@Mapper
public interface Real_estateMapper {
	public Real_estate selectReal_estate(int id);
	public List<Real_estate> selectReal_estateListByRentPrice(int rentPrice);
	
	// xml로 파라미터를 보낼 때 한 개 밖에 보낼 수 없다.
	// 파라미터들은 하나의 Map에 담아 보낸다.
	// @Param 어노테이션을 붙이면 하나의 Map이 된다.
	public List<Real_estate> selectReal_estateListByAreaAndPrice(
			@Param("area") int area,
			@Param("price") int price);
	
	public int insertRealEstate(Real_estate realEstate);
	
	public int insertRealEstateAsField(
			@Param("realtorId") int realtorId,
			@Param("address") String address, 
			@Param("area") int area, 
			@Param("type") String type, 
			@Param("price") int price, 
			@Param("rentPrice") Integer rentPrice);
	
	public int updateRealEstateById(
			@Param ("id") int id, 
			@Param ("type") String type,
			@Param ("price") int price);
	
	public int deleteRealEstateById(int id);
	
}
