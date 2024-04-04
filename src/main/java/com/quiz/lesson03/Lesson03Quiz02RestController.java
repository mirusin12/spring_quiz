package com.quiz.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.Real_estateBO;
import com.quiz.lesson03.domain.Real_estate;

@RestController
@RequestMapping("/lesson03/quiz02")
public class Lesson03Quiz02RestController {
	
	@Autowired
	private Real_estateBO realEstateBO;
	
	// http://localhost:8080/lesson03/quiz02/1
	@RequestMapping("/1")
	public String quiz02_1() {
		Real_estate realEstate = new Real_estate();
		realEstate.setRealtorId(3);
		realEstate.setAddress("푸르지용 리버 303동 1104호");
		realEstate.setArea(89);
		realEstate.setType("매매");
		realEstate.setPrice(100000);
		
		// insert 후 성공한 row 수를 리턴 받는다.
		int rowCount = realEstateBO.addRealEstate(realEstate);
		
		return "성공한 행의 개수:" + rowCount;
	}
	
	// http://localhost:8080/lesson03/quiz02/2?realtor_id=5
	@RequestMapping("/2")
	public String quiz02_2(
			@RequestParam("realtor_id") int realtorId) {
		int rowCount = realEstateBO.addRealEstateAsField(realtorId, "썅떼빌리버 오피스텔 814호", 45, "월세", 100000, 120);
		
		return "입력 성공 : " + rowCount;
	}
}