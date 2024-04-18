package com.quiz.lesson07;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson07.entity.RecruitEntity;
import com.quiz.lesson07.repository.RecruitRepository;

@RequestMapping("/lesson07/quiz02")
@RestController
public class Lesson07Quiz02RestController {
	// !!! BO 생략 (원래는 하면 안됨!!)
	@Autowired
	private RecruitRepository recruitRepository;
	
	// http://localhost:8080/lesson07/quiz02/1
	@GetMapping("/1")
	public RecruitEntity select() {
		return recruitRepository.findById(8).orElse(null) ;
	}
	
	// http://localhost:8080/lesson07/quiz02/2
	@GetMapping("/2")
	public List<RecruitEntity> select2(
			@RequestParam("companyId") int companyId) {
		
		return recruitRepository.findByCompanyId(companyId);
	}

	// http://localhost:8080/lesson07/quiz02/3
	@GetMapping("/3")
	public List<RecruitEntity> select3() {
		return recruitRepository.findByPositionAndType("웹 back-end 개발자", "정규직");
	}
	
	// http://localhost:8080/lesson07/quiz02/4
	@GetMapping("/4")
	public List<RecruitEntity> select4() {
		return recruitRepository.findByTypeOrSalaryGreaterThanEqual("정규직", 9000);
	}

	// http://localhost:8080/lesson07/quiz02/5
	@GetMapping("/5")
	public List<RecruitEntity> select5() {
		return recruitRepository.findTop3ByTypeOrderBySalaryDesc("계약직");
	}
	
	// http://localhost:8080/lesson07/quiz02/6
	@GetMapping("/6")
	public List<RecruitEntity> select6() {
		return recruitRepository.findByRegionAndSalaryBetween("성남시 분당구", 7000, 8500);
	}
	
	// native query
	@GetMapping("/7")
	public List<RecruitEntity> select7() {
		return recruitRepository.findByDeadlineAfterAndSalaryGreaterThanEqualAndTypeOrderBySalaryDesc(
				"2026-04-10", 8100, "정규직");
	}
	
	
	
	
	
	
}
