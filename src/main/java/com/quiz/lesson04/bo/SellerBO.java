package com.quiz.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson04.domain.Seller;
import com.quiz.lesson04.mapper.SellerMapper;

@Service
public class SellerBO {
	
	@Autowired
	private SellerMapper sellerMapper;
	
	// input: 파라미터들
	// output: X
	public void addSeller(String nickname, String profileImage, double temperature) {
		sellerMapper.insertSeller(nickname, profileImage, temperature);
	}
	
	// input: X
	// output: Seller (마지막으로 가입된 사용자) or null(insert 때문에 null은 사실 없음)
	public Seller getLatestSeller() {
		return sellerMapper.selectLatestSeller();
	}
	
	public Seller getSellerById(int id) {
		return sellerMapper.selectSellerById(id);
	}
}
