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
    #map03 > #map {
      width: 90%;
      height: 400px;
      border: 2px solid red;
    }
  </style>
  <script>
    let map03 = {
      map:null,
      init:function (){
        this.display(); // 지도 뿌려줘~
        $('#s_btn').click(function (){
          map03.go(37.5452446, 127.0570452, 's');
        } ); // 각 버튼에 이벤트 발생시키기.
        $('#b_btn').click(function (){
          map03.go(35.1531696, 129.118666, 'b');
        } );
        $('#j_btn').click(function (){
          map03.go(33.5042977, 126.954048, 'j');
        } );
      },
      display:function (){
        //카카오 참조
        var mapContainer = document.querySelector('#map03 > #map'); // 지도 뿌릴 영역
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
      go:function (lat, lng, loc){ // go를 하려면 경도와 위도 받아오면 됨. +loc
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
        map03.markers(loc);
      },
      //**새로 추가한 함수. 해당 지역의 맛집정보 가져오기
      markers:function (loc){
        $.ajax({
          url:'/markers',
          data:{'loc':loc},
          success:function (data){
            map03.displaymarkers(data);
          }
        });
      },
      //displaymarkers : 함수 추가로 화면에 뿌려주기
      displaymarkers:function (positions){
        // 이 안에 내용은 1-6 자료실 참고
        var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";
        for (var i = 0; i < positions.length; i ++) {
          var imageSize = new kakao.maps.Size(20, 30);
          var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);
          var marcerposition = new kakao.maps.LatLng(positions[i].lat, positions[i].lng);
          var marker = new kakao.maps.Marker({
            map: map,
            position: marcerposition,
            title : positions[i].title,
            image : markerImage
          });
          // infoWindow
          var iwContent = '<h2>'+positions[i].title+'</h2>';
          iwContent += '<img src="/img/'+positions[i].img+'" style="width:50px">';

          var infowindow = new kakao.maps.InfoWindow({
            position : marcerposition,
            content : iwContent
          });

          kakao.maps.event.addListener(marker, 'mouseover', mouseoverListener(marker, infowindow));
          kakao.maps.event.addListener(marker, 'mouseout', mouseoutListener(marker, infowindow));
          kakao.maps.event.addListener(marker, 'click', mouseclickListener(positions[i].target));


          function mouseoverListener(marker, infowindow) {
            return function(){
              infowindow.open(map, marker);
            };
          }
          function mouseoutListener(marker, infowindow) {
            return function(){
              infowindow.close();
            };
          }
          function mouseclickListener(target) {
            return function(){
              location.href = target;
            };
          }

        } // end for

      }

    };



    //실행
    $(function (){
      map03.init();
    });
  </script>
</head>
<body>
      <div class="col-sm-12">
        <div class ="container col-sm-12" id="map03">
          <h3>map 03</h3>
          <button type="button" class="btn btn-primary" id="s_btn">SEOUL</button>
          <button type="button" class="btn btn-primary" id="b_btn">BUSAN</button>
          <button type="button" class="btn btn-primary" id="j_btn">JEJU</button>
          <div id="map"></div>
        </div>
      </div>

</body>
</html>
