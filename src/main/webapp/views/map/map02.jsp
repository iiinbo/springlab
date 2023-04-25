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
        #map02 > #map {
            width: 90%;
            height: 400px;
            border: 2px solid red;
        }
    </style>
    <script>
        let map02 = {
            map:null,
            init:function (){
                this.display(); // 지도 뿌려줘~
                $('#s_btn').click(function (){
                    map02.go(37.5452446, 127.0570452);
                } ); // 각 버튼에 이벤트 발생시키기.
                $('#b_btn').click(function (){
                    map02.go(35.1531696, 129.118666);
                } );
                $('#j_btn').click(function (){
                    map02.go(33.5042977, 126.954048);
                } );
            },
            display:function (){
                //카카오 참조
                var mapContainer = document.querySelector('#map02 > #map'); // 지도 뿌릴 영역
                var mapOption = {
                    center: new kakao.maps.LatLng(37.5452446, 127.0570452), // 지도의 중심좌표 성수!
                    level: 5 // 지도의 확대 레벨
                };
                map = new kakao.maps.Map(mapContainer, mapOption); // 지도 그리기
                var mapTypeControl = new kakao.maps.MapTypeControl(); // 컨트롤 만들기
                // 지도에 컨트롤을 추가해야 지도위에 표시됩니다
                // kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
                map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

                // 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
                var zoomControl = new kakao.maps.ZoomControl();

                map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

            },
            go:function (lat, lng){ // go를 하려면 경도와 위도 받아오면 됨.
                //카카오에서 참조
                var moveLatLon = new kakao.maps.LatLng(lat, lng); // 이동할 위치는 각자 다르니까.
                map.panTo(moveLatLon);
                // 지도 이동 먼저 하고, 마커 표시하자.
                // 마커가 표시될 위치입니다
                var markerPosition  = new kakao.maps.LatLng(lat, lng); // 마커 3군데

                // 마커를 생성합니다
                var marker = new kakao.maps.Marker({
                    position: markerPosition
                });

                // 마커가 지도 위에 표시되도록 설정합니다
                marker.setMap(map);
            }

        };


        //실행
        $(function (){
            map02.init();
        });
    </script>
</head>
<body>
    <div class="col-sm-12">
      <div class ="container col-sm-12" id="map02">
        <h3>map 02</h3>
          <button type="button" class="btn btn-primary" id="s_btn">SEOUL</button>
          <button type="button" class="btn btn-primary" id="b_btn">BUSAN</button>
          <button type="button" class="btn btn-primary" id="j_btn">JEJU</button>
          <div id="map"></div>

      </div>
    </div>

</body>
</html>
