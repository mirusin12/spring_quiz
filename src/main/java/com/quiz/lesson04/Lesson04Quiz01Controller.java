package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.bo.SellerBO;
import com.quiz.lesson04.domain.Seller;

@RequestMapping("/lesson04/quiz01")
@Controller
public class Lesson04Quiz01Controller {
	
	@Autowired
	private SellerBO sellerBO;
	
	// 판매자 추가 화면
	// http://localhost:8080/lesson04/quiz01/add-seller-view
	@GetMapping("/add-seller-view")
	public String addSellerView() {
		return "lesson04/addSeller";
	}
	
	// 판매자 추가 DB insert => 입력 성공! 화면
	@PostMapping("/add-seller")
	public String addSeller(
			@RequestParam("nickname") String nickname,
			@RequestParam(value = "profileImage", required = false) String profileImage, // required = false => null 일 수도 있다.
			@RequestParam(value = "temperature", defaultValue = "36.5") double temperature) {
		
		// db insert
		sellerBO.addSeller(nickname, profileImage, temperature);
		
		// 성공 화면
		return "lesson04/afterAddSeller";
	}
	
	// http://localhost:8080/lesson04/quiz01/seller-info-view
	// http://localhost:8080/lesson04/quiz01/seller-info-view?id=1
	@GetMapping("/seller-info-view")
	public String sellerInfoView(
			@RequestParam(value = "id", required = false) Integer id,
			Model model) {
		
		Seller seller = null;
		// db select
		if (id == null) {
			seller = sellerBO.getLatestSeller();
		} else {
			seller = sellerBO.getSellerById(id);
		}
		// model에 담기
		model.addAttribute("seller", seller);
		model.addAttribute("title", "판매자 정보");
		
		// 응답 화면
		return "lesson04/sellerInfo";
		
	}
	
	
	
	
}
