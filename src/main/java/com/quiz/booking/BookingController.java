package com.quiz.booking;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.booking.bo.BookingBO;
import com.quiz.domain.Booking;

@RequestMapping("/booking")
@Controller
public class BookingController {
	@Autowired
	private BookingBO bookingBO;
	
	
	// 예약 목록 페이지
	// http://localhost:8080/booking/booking-list-view
	@GetMapping("/booking-list-view")
	public String bookingListView(Model model) {
		
		// db select
		List<Booking> bookingList = bookingBO.getBookingList();
		
		// model
		model.addAttribute("bookingList", bookingList);
		return "booking/bookingList";
	}
	
	// 삭제하기
	// http://localhost:8080/booking/delete-booking
	@ResponseBody
	// @GetMapping("/delete-booking")
	@DeleteMapping("/delete-booking")
	public Map<String, Object> deleteBooking(
			@RequestParam("id") int id) {
		
		// delete db
		int rowCount = bookingBO.deleteBookingById(id);
		
		// {"code":500, "error_message":"삭제할 데이터가 없습니다."}
		Map<String, Object> result = new HashMap<>();
		if (rowCount > 0) {
			result.put("code", 200);
			result.put("result", "성공");
		} else {
			result.put("code", 500);
			result.put("error_message", "삭제할 데이터가 없습니다.");
		}
		return result;
	}
	
	// 예약하기 페이지
	// http://localhost:8080/booking/make-booking-view
	@GetMapping("/make-booking-view")
	public String makeBooking() {
		return "booking/makeBooking";
	}
	
	// 예약하기 - AJAX
	@ResponseBody
	@PostMapping("/make-booking")
	public Map<String, Object> makeBooking(
			@RequestParam("name") String name
			, @RequestParam("date") String date
			, @RequestParam("day") int day
			, @RequestParam("headcount") int headcount
			, @RequestParam("phoneNumber") String phoneNumber) {
		
		// db insert
		bookingBO.addBooking(name, date, day, headcount, phoneNumber);
		
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");
		return result;
	}
	
	// 예약 조회 화면
	// http://localhost:8080/booking/check-booking-view
	@GetMapping("/check-booking-view")
	public String checkBookingView() {
		return "booking/checkBooking";
	}
	
	// 예약 조회 - ajax
	@ResponseBody
	@PostMapping("/check-booking")
	public Map<String, Object> checkBooking(
			@RequestParam("name") String name
			, @RequestParam("phoneNumber") String phoneNumber) {
		
		// select db
		// 중복일 수 있지만 가장 마지막 1개만 가져옴
		Booking booking = bookingBO.getBookingByNamePhoneNumber(name, phoneNumber);
		// response
		// {"code":200, "result":"booking 객체"}
		Map<String, Object> result = new HashMap<>();
		if (booking != null) {
			result.put("code", 200);
			result.put("result", booking);
		} else {
			// 만약 booking이 null이면 예약 내역 없음
			// {"code":500, "error_message":"예약 내역이 없습니다."}
			result.put("code", 500);
			result.put("error_message", "예약 내역이 없습니다.");
		}
		
		return result;
		
		
	}
	
	
	
	
}
