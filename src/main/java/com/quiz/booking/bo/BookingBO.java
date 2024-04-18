package com.quiz.booking.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.booking.mapper.BookingMapper;
import com.quiz.domain.Booking;

@Service
public class BookingBO {
	@Autowired
	private BookingMapper bookingMapper;
	
	
	public List<Booking> getBookingList() {
		return bookingMapper.selectBookingList();
	}
	
	public int deleteBookingById(int id) {
		return bookingMapper.deleteBookingById(id);
	}
	
	public void addBooking(String name, String date, int day, int headcount, String phoneNumber) {
		bookingMapper.insertBooking(name, date, day, headcount, phoneNumber);
	}
	
	// input: name, phoneNumber
	// output: 최신 예약 내역 단건 1개(Booking) or null
	public Booking getBookingByNamePhoneNumber(String name, String phoneNumber) {
		// List의 경우 있으면: [1,2.3] 없으면:[]
		List<Booking> bookingList = bookingMapper.selectBookingByNamePhoneNumber(name, phoneNumber);
//		if (bookingList.isEmpty()) {
//			return null;
//		}
//		
//		return bookingList.get(bookingList.size() - 1);
		return bookingList.isEmpty() ? null : bookingList.get(bookingList.size() - 1);
	}
}
