<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>
    #map02 > #map{
        width:800px;
        height:400px;
        border: 2px solid blue;
        margin-top: 10px;
    }
</style>

<script>
    let map02 = {
        map:null,
        init:function (){
           this.display();
           $('#s_btn').click(function (){
               map02.go(37.579617,126.977041);
           });
           $('#b_btn').click(function (){
               map02.go(39.0581367,125.7682553);
           });
           $('#j_btn').click(function (){
               map02.go(33.4853707,126.4815713);
           });
        },
        display:function (){
            var mapContainer = document.querySelector('#map02 > #map');
            var mapOption = {
                center: new kakao.maps.LatLng(37.5192199, 126.9271762), // 지도의 중심좌표
                level: 3 // 지도의 확대 레벨
            };
            map = new kakao.maps.Map(mapContainer, mapOption);

            var mapTypeControl = new kakao.maps.MapTypeControl();
            map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);
            var zoomControl = new kakao.maps.ZoomControl();
            map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

            var markerPosition  = new kakao.maps.LatLng(37.5192199, 126.9271762);
            var marker = new kakao.maps.Marker({
                position: markerPosition
            });
            marker.setMap(map);
        },
        go:function (lat,lng){
            var moveLatLon = new kakao.maps.LatLng(lat,lng);
            // 지도 중심을 부드럽게 이동시킵니다
            // 만약 이동할 거리가 지도 화면보다 크면 부드러운 효과 없이 이동합니다
            map.panTo(moveLatLon);
            var markerPosition  = new kakao.maps.LatLng(lat,lng);
            var marker = new kakao.maps.Marker({
                position: markerPosition
            });
            marker.setMap(map);
        }
    };
    $(function (){
        map02.init();
    })

</script>

<div class="col-sm-8 text-left">
    <div class="container" id="map02">
        <h3>MAP02</h3>
        <button id="s_btn" type="button" class="btn btn-primary">SEOUL</button>
        <button id="b_btn"type="button" class="btn btn-primary">BUSAN</button>
        <button id="j_btn"type="button" class="btn btn-primary">JEJU</button>
        <div id="map"></div>
    </div>
</div>