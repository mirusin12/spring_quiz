package com.quiz.booking.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.domain.Booking;

@Mapper
public interface BookingMapper {
	public List<Booking> selectBookingList();
	
	public int deleteBookingById(int id);
	
	public void insertBooking(
			@Param("name") String name
			,@Param("date") String date
			,@Param("day") int day
			,@Param("headcount") int headcount
			,@Param("phoneNumber") String phoneNumber);
	
	public List<Booking> selectBookingByNamePhoneNumber(
			@Param("name") String name
			,@Param("phoneNumber") String phoneNumber);
	
}
