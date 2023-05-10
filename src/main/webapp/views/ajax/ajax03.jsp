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
    let ajax03 = {
      init:function (){
        $('#getdata > button').click(function (){ // 버튼 클릭 이벤트 발생 시(아래)

        });
        //아무 동작 안하고, setInterval :  알아서 '3초'마다 회원정보를 업데이트한 후 화면에 출력해주기.
        setInterval( function (){
          $.ajax({  // ajax에게 요청한다. server정보 가져오라구
            url:'/getdata', // 서버주소
            success : function (data){
              ajax03.display(data);
            },
            error : function (){
              alert('error');
            }
          });
        }, 3000);
      },
      display:function (data){
        var result = "";
        $(data).each(function (index, item){ // for(each)문을 돌리면서, result가 계속 쌓이면서 보이게
            result += '<h4>';
            result += item.id + '' + item.pwd + '' + item.name ;
            result += '<h4>';
        });
        $('#getdata > div').html(result); // div 영역 안에 결과 출력
      }
    };


    //실행
    $(function (){
      ajax03.init();
    });
  </script>
  <style>
    #getdata > div {
      width: 500px;
      border: 2px;
    }
  </style>
</head>
<body>
    <div class="col-sm-12">
      <div class ="container col-sm-12" id="getdata">
        <h3>ajax03</h3>
        <button type="button" class="btn">GET DATA</button>
        <div>

        </div>
      </div>
    </div>

</body>
</html>
