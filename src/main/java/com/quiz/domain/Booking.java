package com.quiz.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Booking {
	private int id;
	private String name;
	private int headcount;
	private int day;
	private Date date;
	private String phoneNumber;
	private String state;
	private Date createdAt;
	private Date updatedAt;
	
	
}
