<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>회원 정보 리스트</h1>
		<img src="/img/sunny.jpg">
		<table class="table">
			<thead>
				<tr>
					<th>No</th>
					<th>이름</th>
					<th>전화 번호</th>
					<th>국적</th>
					<th>이메일</th>
					<th>자기소개</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${members}" var="member" varStatus="status">
					<tr>
						<td>${status.count}</td>
						<td>${member.name}</td>
						<td>
							<c:choose>
								<c:when test="${fn:startsWith(member.phoneNumber, '010') == false}">
									유효하지 않은 전화번호
								</c:when>
								<c:otherwise>
									${member.phoneNumber}
								</c:otherwise>
							</c:choose>
						</td>
						<td>${fn:replace(member.nationality, '삼국시대', '삼국 - ')}</td>
						<td><span class="font-weight-bold">${fn:split(member.email, '@')[0]}</span>@<span>${fn:split(member.email, '@')[1]}</span></td>
						<td>
							<c:set var="len" value="${member.introduce.length()}" />
							<c:set var="introduceVal" value="${member.introduce}" />
							<c:choose>
									<c:when test="${len >= 15}">
										${fn:substring(member.introduce, 0, 15)}
										...
									</c:when>
									<c:otherwise>
										${member.introduce}
									</c:otherwise>
							</c:choose>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>