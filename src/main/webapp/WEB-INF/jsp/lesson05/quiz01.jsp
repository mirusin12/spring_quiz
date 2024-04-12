<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Core 라이브러리(1)</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</head>
<body>
	<c:set var="number1" value="36" />
	<c:set var="number2" value="3" />
	<h1>1. JSTL core 변수</h1>
	<div class="font-weight-bold">첫번째 숫자 : ${number1}</div>
	<div class="font-weight-bold">두번째 숫자 : ${number2}</div>
	
	<h1>2. JSTL core 연산</h1>
	<div class="font-weight-bold">더하기 :  ${number1 + number2}</div>
	<div class="font-weight-bold">빼기 :  ${number1 - number2}</div>
	<div class="font-weight-bold">곱하기 :  ${number1 * number2}</div>
	<div class="font-weight-bold">나누기 :  ${number1 / number2}</div>
	
	<h1>3. JSTL core out</h1>
	<c:out value="<title>core out</title>" />
	
	<h1>4. core if</h1>
	
	<c:if test="${((number1 + number2) / 2) >= 10}">
		<h1>${(number1 + number2) / 2}</h1>
	</c:if>
	<c:if test="${((number1 + number2) / 2) < 10}">
		<h3>${(number1 + number2) / 2}</h3>
	</c:if>
	
	<h1>5. core if</h1>
	<c:if test="${number1 * number2 >= 100}">
		<h1><c:out value="<script>alert('너무 큰 수 입니다.')</script>" escapeXml="false"/></h1>
	</c:if>
</body>
</html>