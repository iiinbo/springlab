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
  <script>
      let ajax01 = {
        init:function (){

            setInterval(function (){ // setInterval : 00초 마다 함수 호출(비동기 함수)
                $.ajax({ // ajax 부르기. (ajax 요청 처리하는 곳 : 일반 컨트롤러 아님 / 별도 존재)
                    url:'/getservertime', // 여기 적은 서버에게 요청하기
                    success:function (data){
                        ajax01.display(data); // 결과 : 성공 시 값을 알럿창  또는 화면에 알려줘
                    },
                    error:function (){
                        alert('Error!');// 결과 : 실패 시 실행되는 함수 다르게.
                    }
                });
            }, 3000);
        },

      display:function (data){ // 성공 시 display로 띄우기 위해  data 여기로-
            $('#server_time').text(data); // html.에서 지정한 id값
        }
      };
      //실행
      $(function (){
        ajax01.init();
      });
  </script>
</head>
<body>
  <div class="col-sm-12">
   <div class ="container col-sm-12">
      <h3>ajax 01</h3>
      <h4>Server Time</h4>
      <h5 id="server_time"></h5>

   </div>
  </div>

</body>
</html>

<%--let ajax01 = {--%>
<%--init:function (){--%>
<%--$.ajax({ // ajax 부르기. (ajax 요청 처리하는 곳 : 일반 컨트롤러 아님 / 별도 존재)--%>
<%--url:'/getservertime', // 여기 적은 서버에게 요청하기--%>
<%--success:function (data){--%>
<%--ajax01.display(data); // 결과 : 성공 시 값을 알럿창  또는 화면에 알려줘--%>
<%--},--%>
<%--error:function (){--%>
<%--alert('Error!');// 결과 : 실패 시 실행되는 함수 다르게.--%>
<%--}--%>
<%--});--%>
<%--},--%>
<%--display:function (data){ // 성공 시 display로 띄우기 위해  data 여기로---%>
<%--$('#server_time').text(data); // html.에서 지정한 id값--%>
<%--}--%>
<%--};--%>