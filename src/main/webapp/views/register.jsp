<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <title>register page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <%-- 회원가입 기능 --%>
  <script>
    let register_form = {
      init:function (){ // 화면에 이벤트 처리
        $('#register_btn').click(function (){
          register_form.send();
        });
      },
      send:function () {
        $('#register_form').attr({
          'action':'/registerimpl', // maincontroller 로 보낸다.
          'method':'post'
        });
        $('#register_form').submit();
      }
    };

    // 회원가입 기능(스크립트)를 상단에 기입했으므로, 스크립트 끝나기 전 아래 함수 적어줘야 함.
    $(function (){
      register_form.init();
    });
  </script>
  <style>
    /* Remove the navbar's default margin-bottom and rounded borders */
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }

    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {height: 450px}

    /* Set gray background color and 100% height */
    .sidenav {
      padding-top: 20px;
      background-color: #f1f1f1;
      height: 100%;
    }

    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }

    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height:auto;}
    }
  </style>

</head>
<body>
<div class="col-sm-12">
  <div class ="container col-sm-12">

      <h2>회원가입</h2>
      <p>브레드 이발소의 친구가 되어주세요!</p>
      <form id="register_form">
        <div class="form-floating mb-3 mt-3">
          <label for="username">이름</label>
          <input type="text" class="form-control" id="username" placeholder="Enter username" name="username"/>
        </div>
        <div class="form-floating mb-3 mt-3">
          <label for="id">아이디</label>
          <input type="text" class="form-control" id="id" placeholder="Enter id" name="id"/>
        </div>
        <div class="form-floating mt-3 mb-3">
          <label for="pwd">비밀번호</label>
          <input type="text" class="form-control" id="pwd" placeholder="Enter password" name="pwd"/>
        </div>
        <button type="button" class="btn btn-primary"  id="register_btn">가입하기</button>
      </form>



  </div>
</div>


</body>
</html>
