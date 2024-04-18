<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약 하기</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">

<%-- AJAX를 사용하려면 jquery 원본 필요 --%>
<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
	crossorigin="anonymous"></script>

<%-- datepicker --%>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>

<!-- 외부 stylesheet -->
<link rel="stylesheet" type="text/css" href="/css/booking/style.css">
</head>
<body>
	<div id="wrap" class="container">
		<header class="d-flex justify-content-center">
			<div class="display-4">통나무 펜션</div>
		</header>
		<nav>
			<ul class="nav nav-fill">
				<li class="nav-item"><a href="#"
					class="nav-link text-white font-weight-bold">팬션소개</a></li>
				<li class="nav-item"><a href="#"
					class="nav-link text-white font-weight-bold">객실보기</a></li>
				<li class="nav-item"><a href="#"
					class="nav-link text-white font-weight-bold">예약하기</a></li>
				<li class="nav-item"><a href="#"
					class="nav-link text-white font-weight-bold">예약목록</a></li>
			</ul>
		</nav>
		
		
		<section class="contents">
			<h2 class="font-weight-bold text-center mt-5">예약 목록 보기</h2>
			<div class="d-flex justify-content-center">
				<div class="booking-box mt-4">
					<div class="font-weight-bold">이름</div>
					<input type="text" id="name" class="form-control mt-2">
					
					<div class="font-weight-bold mt-2">예약날짜</div>
					<input type="text" id="date" class="form-control mt-2">
					
					<div class="font-weight-bold mt-2">숙박일수</div>
					<input type="text" id="day" class="form-control mt-2">
					
					<div class="font-weight-bold mt-2">숙박인원</div>
					<input type="text" id="headcount" class="form-control mt-2">
					
					<div class="font-weight-bold mt-2">전화번호</div>
					<input type="text" id="phoneNumber" class="form-control mt-2">
					
					<button type="button" id="makeBookingBtn" class="btn btn-warning w-100 mt-3">예약하기</button>
				</div>
			</div>
		</section>
		<footer>
			<div class="footerInfo pt-2">
				<small class="text-secondary"> 
					제주특별자치도 제주시 애월읍<br>
					사업자등록번호: 111-22-255222 / 농어촌민박사업자지정 / 대표:김통목<br> 
					Copyright © marondal 2021
				</small>
			</div>
		</footer>
	</div>
	<script>
		$(document).ready(function() {
			// 날짜 선택
			$("#date").datepicker({
				dateFormat:'yy-mm-dd'
				, minDate:0
			});
			
			// 예약하기
			$("#makeBookingBtn").on('click', function() {
				// alert("예약");
				let name = $("#name").val().trim();				
				let date = $("#date").val().trim();				
				let day = $("#day").val().trim();				
				let headcount = $("#headcount").val().trim();				
				let phoneNumber = $("#phoneNumber").val().trim();
				
				if (!name) {
					alert("예약자명을 입력해주세요.");
					return;
				}
				if (!date) {
					alert("예약날짜를 입력해주세요.");
					return;
				}
				if (!day) {
					alert("숙박일수를 입력해주세요.");
					return;
				}
				if (!headcount) {
					alert("숙박인원을 입력해주세요.");
					return;
				}
				if (!phoneNumber) {
					alert("전화번호를 입력해주세요.");
					return;
				}
				
				$.ajax({
					// request
					type:"POST"
					, url:"/booking/make-booking"
					, data:{"name":name, "date":date, "day":day, "headcount":headcount, "phoneNumber":phoneNumber}
					
					// response
					, success:function(data) {
						if (data.result == "성공") {
							location.href="/booking/booking-list-view"
						}
					}
					, error:function(e) {
						alert("예약에 실패했습니다. 관리자에게 문의해주세요.");
					}
				});
				
			});
		});
	</script>
</body>
</html>



















