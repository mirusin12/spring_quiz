package com.quiz.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson07.bo.CompanyBO;
import com.quiz.lesson07.entity.CompanyEntity;

@RequestMapping("/lesson07/quiz01")
@RestController
public class Lesson07Quiz01RestController {
	
	@Autowired
	private CompanyBO companyBO;
	
	// C: create
	// http://localhost:8080/lesson07/quiz01/save1
	@GetMapping("/save1")
	public CompanyEntity save1() {
		/*회사명 : 넥손
		사업내용 : 컨텐츠 게임
		규모 : 대기업
		사원수 : 3585명*/
		return companyBO.addCompany("넥슨", "컨텐츠 게임", "대기업", 3585); 
	}
	
	// http://localhost:8080/lesson07/quiz01/save2
	@GetMapping("/save2")
	public CompanyEntity save2() {
		/*회사명 : 버블팡
		사업내용 : 여신 금융업
		규모 : 대기업
		사원수 : 6834명*/
		return companyBO.addCompany("버블팡", "여신 금융업", "대기업", 6834);
		
	}
	
	// U: update
	// http://localhost:8080/lesson07/quiz01/update
	@GetMapping("/update")
	public CompanyEntity update() {
		/*
		버블팡이 극심한 경영 악화로 회사 정보가 변경되었다.
		규모를 중소기업, 사원수를 34명 으로 수정하세요. (버블팡의 pk id번호로 업데이트 - workbench에서 조회)
		*/
		return companyBO.updateCompanyScaleHeadcountById(8, "중소기업", 34);
	}
	
	
	// D: delete
	// http://localhost:8080/lesson07/quiz01/delete
	@GetMapping("/delete")
	public String delete() {
		// id = 8
		companyBO.deleteCompanyById(8);
		companyBO.deleteCompanyById(9);
		return "삭제 완료";
	}
}
