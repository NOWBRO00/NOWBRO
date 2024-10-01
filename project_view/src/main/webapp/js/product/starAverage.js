$(document).ready(function() {
	// 페이지 로드 시 평균 별점을 가져오는 함수
	function fetchAverageRating() {
		$.ajax({
			type: 'GET', // GET타입으로 정보전달
  			url: 'getAverageRating.do', // 평균 별점을 가져올 URL
			dataType: 'json', // 서버 응답 데이터 타입 설정
			success: function(data) {
				if (data && data.averageRating) {
					$("#averageRating").text("현재 평균 별점: " + data.averageRating.toFixed(1) + "개 별"); // 평균 별점 표시
					// toFixed(1) : 소수점 자리 1번째까지 출력
				} else {
					$("#averageRating").text("평균 별점을 가져오는 데 실패했습니다."); // 평균 별점 가져오기 실패 메시지
					}
				},
				error: function(xhr, status, error) {
					console.log('서버 응답 실패...'); // 서버 요청 실패 시 출력
  					console.log(xhr); // 자세한 오류 정보 출력
				$("#averageRating").text("서버에 요청을 보낼 수 없습니다."); // 서버 요청 실패 메시지
			}
		});
	}
	// 페이지 로드 시 평균 별점 초기 로드
	fetchAverageRating();
});