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
    let ajax02 = {
      init:function (){
        this.keyupevent(); // 먼저, 초기화
        this.sendevent(); // 초기화
      },
      keyupevent:function (){
        $('#r_form > input[name=id]').keyup(function (){ // $ 부분에 keyup(키보드 입력 즉시) 발생하면 - 함수 실행해줘
            var id = $(this).val();
            // id 자리수 = 4자리이상
            if(id.length <= 3 ){
                $('#r_form > #idspan').text('id는 4자리 이상 가능합니다.');
                return; // 함수 그만두기.(이거 없으면 아래 쭉 실행)
            };
            $.ajax({ // ajax로 전송해달라고 요청
              url : '/checkid',
              data : {'id':id}, // id값은 id라는 이름으로 전송.
              success:function (data){
                //id값 사용여부
                if(data == 0){
                    $('#r_form > #idspan').text('사용 가능한 아이디 입니다!');
                    $('#r_form > input[name=pwd]').focus(); // pwd 창으로 자동 이동
                }
                else{
                    $('#r_form > #idspan').text('이미 존재하는 아이디');
                }
              },
              error:function (){
                alert("error");
              }
            });
        });
      },
      sendevent:function (){}
    };

    //실행
    $(function (){
      ajax02.init();
    });
  </script>
</head>
<body>
<div class="col-sm-12">
  <div class ="container col-sm-12">
    <h3>ajax02</h3>
    <form id="r_form">
        아이디 : <input type="text" name="id"/><span id="idspan"></span> <br>
        비밀번호 : <input type="text" name="pwd"/> <br>
        이름 : <input type="text" name="name"/> <br>
        <button type="button" value="resister">전송</button>
    </form>

  </div>
</div>

</body>
</html>
