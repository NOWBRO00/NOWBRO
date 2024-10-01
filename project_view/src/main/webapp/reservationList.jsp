<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약 목록 페이지</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="css/style.css" type="text/css">

<!-- jQuery 사용을 위한 연결 -->
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	crossorigin="anonymous"></script>
<style type="text/css">
input {
	border: none !important;
	background-color: orange !important;
}

h5 {
	width: 120px;
	align-content: center !important;
}
</style>
</head>
<body>
	<!-- 헤더 -->
	<jsp:include page="header.jsp" />
	<br>
	<!-- 예약 내역 상세보기 -->
	<div class="container text-center">
		<div class="row">
			<div class="col-12 card" style="background-color: #ffffff">
				<div class="card-body">
					<br>
					<div>
						<h2>예약 목록</h2>
					</div>
					<br>
					<!-- 
					<c:forEach var="data" items=""><!--${boardList}-->
					<div class="col-md-4">
						<!-- 게시판 태그 -->
						<mytag:smallBoard />
					</div>
					</c:forEach>
					-->
					<!-- 예시 데이터 -->
					<table class="table">
						<thead>
							<tr>
								<th scope="col"></th>
								<th scope="col">상품명</th>
								<th scope="col">금액</th>
								<th scope="col">예약상태</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th scope="row">썸네일</th>
								<td>${data[0].product_name}상품명1</td>
								<td>${data.payment_price}결제금액1</td>
								<td>${data.reservation_status}예약상태1</td>
							</tr>
							<tr>
								<th scope="row">썸네일</th>
								<td>${data[1].product_name}상품명2</td>
								<td>${data.payment_price}결제금액2</td>
								<td>${data.reservation_status}예약상태2</td>
							</tr>
							<tr>
								<th scope="row">썸네일</th>
								<td>${data.product_name}상품명3</td>
								<td>${data.payment_price}결제금액3</td>
								<td>${data.reservation_status}예약상태3</td>
							</tr>
						</tbody>
					</table>


					<!-- 뒤로가기 버튼 -->
					<button type="button" id="backBtn"
						class="btn btn-outline-secondary" style="width: 140px">뒤로가기</button>
				</div>
			</div>
		</div>
	</div>
	<br>
	<br>
	<br>
	<!-- 푸터 연결 -->
	<c:import url="footer.jsp"></c:import>
</body>
</html>