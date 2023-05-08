<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>
    #map01 > #map{
        width:400px;
        height:400px;
        border: 2px solid blue;
    }
</style>

<script>
    let map01 = {
        map:null,
        init:function (){
            var mapContainer = document.querySelector('#map');
            var mapOption = {
                center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
                level: 3 // 지도의 확대 레벨
            };
            map = new kakao.maps.Map(mapContainer, mapOption);

            var mapTypeControl = new kakao.maps.MapTypeControl();
            map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);
            var zoomControl = new kakao.maps.ZoomControl();
            map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

            var markerPosition  = new kakao.maps.LatLng(33.450701, 126.570667);
            var marker = new kakao.maps.Marker({
                position: markerPosition
            });
            marker.setMap(map);

            var iwContent = '<img src="/img/a.jpg" style="width:200px"><div style="padding:5px;">푸하하하하하하하하</imgdiv>';
            var infowindow = new kakao.maps.InfoWindow({
                content : iwContent
            });
            kakao.maps.event.addListener(marker, 'mouseover', function() {
                // 마커에 마우스오버 이벤트가 발생하면 인포윈도우를 마커위에 표시합니다
                infowindow.open(map, marker);
            });
            kakao.maps.event.addListener(marker, 'mouseout', function() {
                // 마커에 마우스아웃 이벤트가 발생하면 인포윈도우를 제거합니다
                infowindow.close();
            });
            kakao.maps.event.addListener(marker, 'click', function() {
                // 마커에 마우스 클릭시 어디로 보내라
                location.href='http://www.nate.com';
            });
        }
    };

    $(function (){
        map01.init();
    })

</script>

<div class="col-sm-8 text-left">
    <div class="container" id="map01">
        <h3>map01</h3>
        <div id="map"></div>
    </div>
</div>