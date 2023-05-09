<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--JSTL : 통화 날짜를 표현하게 해주는 문법--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="ko">
<head>
  <title>main</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <style>
  <%-- MAP 지도는 반드시 가로세로 사이즈 지정 필수 --%>
    #map01 > #map {
      width: 90%;
      height: 400px;
      border: 2px solid red;
    }
  </style>
  <script>
      let map01 = {
        map:null,
        init:function (){
            var mapContainer = document.querySelector('#map'); // 지도 뿌릴 영역
            var mapOption = {
              center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
              level: 3 // 지도의 확대 레벨
            };
            map = new kakao.maps.Map(mapContainer, mapOption); // 지도 그리기
            var mapTypeControl = new kakao.maps.MapTypeControl(); // 컨트롤 만들기
            // 지도에 컨트롤을 추가해야 지도위에 표시됩니다
            // kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
                      map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

            // 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
            var zoomControl = new kakao.maps.ZoomControl();
            map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

            // 마커가 표시될 위치입니다
            var markerPosition  = new kakao.maps.LatLng(33.450701, 126.570667);

            // 마커를 생성합니다
            var marker = new kakao.maps.Marker({
              position: markerPosition
            });

            // 마커가 지도 위에 표시되도록 설정합니다
            marker.setMap(map);

            //
          // 마커에 커서가 오버됐을 때 마커 위에 표시할 인포윈도우를 생성합니다
          var iwContent = '<img src="/img/a.jpg" style="width:50px"><div style="padding:5px;">돈버는 땅인가!</div>'; // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다

          // 인포윈도우를 생성합니다
          var infowindow = new kakao.maps.InfoWindow({
            content : iwContent
          });

          // 마커에 마우스오버 이벤트를 등록합니다
          kakao.maps.event.addListener(marker, 'mouseover', function() {
            // 마커에 마우스오버 이벤트가 발생하면 인포윈도우를 마커위에 표시합니다
            infowindow.open(map, marker);
          });

          // 마커에 마우스아웃 이벤트를 등록합니다
          kakao.maps.event.addListener(marker, 'mouseout', function() {
            // 마커에 마우스아웃 이벤트가 발생하면 인포윈도우를 제거합니다
            infowindow.close();
          });
          // 이벤트 추가해보기. 클릭하면 이동하도록
          kakao.maps.event.addListener(marker, 'click', function() {
            // 마커에 마우스아웃 이벤트가 발생하면 인포윈도우를 제거합니다
            location.href='http://www.nate.com';
          });

          }

      };


      //실행
      $(function (){
        map01.init();
      });
  </script>
</head>
<body>
    <div class="col-sm-12">
      <div class ="container col-sm-12" id="map01">
        <h3>map 01</h3>
            <div id="map"></div>
      </div>
      </div>

</body>
</html>
