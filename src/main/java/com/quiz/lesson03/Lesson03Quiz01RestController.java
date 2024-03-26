package com.quiz.lesson03;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.Real_estateBO;
import com.quiz.lesson03.domain.Real_estate;

@RestController
@RequestMapping("/lesson03/quiz01")
public class Lesson03Quiz01RestController {
	@Autowired
	private Real_estateBO real_estateBO;
	
	// http://localhost:8080/lesson03/quiz01/1?id=
	@RequestMapping("/1")
	public Real_estate quiz01(
			@RequestParam("id") int id
			) {
		return real_estateBO.getReal_estate(id);
	}
	
	// http://localhost:8080/lesson03/quiz01/2?rentPrice=90
	@RequestMapping("/2")
	public List<Real_estate> quiz01_2(
			@RequestParam(value = "rentPrice") int rentPrice
			) {
		return real_estateBO.getReal_estateListByRentPrice(rentPrice);
	}
	
	// http://localhost:8080/lesson03/quiz01/3?area=90&price=130000
	@RequestMapping("/3")
	public List<Real_estate> quiz01_3(
			@RequestParam(value = )
			) {
		return;
	}
}
