package com.quiz.lesson07.entity;

import java.time.LocalDate;
import java.time.ZonedDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString // 객체를 출력할 때 필드 값들이 보인다.
@AllArgsConstructor // 모든 파라미터가 있는 생성자
@NoArgsConstructor // 파라미터 없는 생성자
@Getter
@Builder(toBuilder = true) // setter의 대용, toBuilder=true 필드 수정 허용
@Table(name = "recruit")
@Entity // 이 객체는 엔티티다. DB-JPA 통신 사이

public class RecruitEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;
	
	// 카멜 케이스로 되어 있으면 Column
	@Column(name="companyId")
	private int companyId;
	
	private String position;
	private String responsibilities;
	private String qualification;
	private String type;
	private String region;
	private int salary;
	private LocalDate deadline;
	
	@UpdateTimestamp
	@Column(name = "createdAt", updatable = false)
	private ZonedDateTime createdAt;
	
	@UpdateTimestamp
	@Column(name="updatedAt")
	private ZonedDateTime updatedAt;
}
