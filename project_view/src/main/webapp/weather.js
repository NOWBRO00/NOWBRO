const API_KEY = "ffd7a00bf82dc39075ee0b14f3d23d7d"; // OpenWeatherMap API 키
const COORDS = 'coords'; // 좌표 정보를 저장할 상수

// DOM에서 날씨 정보와 아이콘을 표시할 요소를 선택
const weatherInfo = document.querySelector('.weatherInfo'); // 날씨 정보를 표시할 요소
const weatherIconImg = document.querySelector('.weatherIcon'); // 날씨 아이콘을 표시할 이미지 요소

// 초기화 함수
function init() {
    askForCoords(); // 좌표 요청 함수 호출
}

// 좌표를 물어보는 함수
function askForCoords() {
    // 브라우저의 Geolocation API를 사용하여 현재 위치 좌표를 요청
    navigator.geolocation.getCurrentPosition(handleSuccess, handleError);
}

// 좌표를 얻는 데 성공했을 때 호출되는 함수
function handleSuccess(position) {
    const latitude = position.coords.latitude; // 위도 추출
    const longitude = position.coords.longitude; // 경도 추출
    const coordsObj = {
        latitude,  // 위도 값을 coordsObj 객체에 저장
        longitude  // 경도 값을 coordsObj 객체에 저장
    };
    getWeather(latitude, longitude); // 좌표값을 바탕으로 날씨 정보 요청
}

// 좌표를 얻는 데 실패했을 때 호출되는 함수
function handleError() {
    console.log("can't not access to location"); // 위치 접근 실패 시 콘솔에 오류 출력
}

// 날씨 API를 통해 날씨 정보를 받아오는 함수
function getWeather(lat, lon) {
    // OpenWeatherMap API를 호출하여 지정한 위도(lat)와 경도(lon)의 날씨 정보를 가져옴
    fetch(`https://api.openweathermap.org/data/2.5/weather?lat=${lat}&lon=${lon}&appid=${API_KEY}&units=metric&lang=kr`)
    .then(function(response) {
        return response.json(); // 응답을 JSON 형태로 변환
    })
    .then(function(json) {
        // JSON 응답에서 온도, 위치(도시 이름), 날씨 설명, 아이콘 정보를 추출
        const temperature = json.main.temp; // 현재 온도
        const place = json.name; // 도시 이름
        const weatherDescription = json.weather[0].description; // 날씨 설명
        const weatherIcon = json.weather[0].icon; // 날씨 아이콘 코드
        const weatherIconAdrs = `http://openweathermap.org/img/wn/${weatherIcon}@2x.png`; // 아이콘 이미지 주소 생성

        // 추출한 정보들을 DOM 요소에 표시
        weatherInfo.innerText = `${temperature} °C / @${place} / ${weatherDescription}`; // 온도, 도시, 날씨 설명 표시
        weatherIconImg.setAttribute('src', weatherIconAdrs); // 아이콘 이미지 설정
    })
    .catch((error) => console.log("error:", error)); // API 요청 실패 시 오류 메시지를 콘솔에 출력
}

// 초기화 함수 실행
init(); // 페이지 로드 시 좌표 요청을 통해 날씨 정보를 불러오도록 함
