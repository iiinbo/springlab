<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <title>login page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


  <script>
    <%-- 로그인 기능 --%>
      // 로그인 기능(스크립트)를 상단에 기입했으므로, 스크립트 끝나기 전 아래 함수 적어줘야 함.
      $(function (){
          login_form.init();
      });
  </script>


</head>
<body>
<div class="col-sm-12">
  <div class ="container col-sm-12">
    <h2>로그인</h2>
    <p>브레드 이발소에서 제공하는 다양한 서비스를 이용하시려면 로그인 해주세요</p>
    <form id="login_form" class="form-horizontal well">
      <div class="form-group">
        <label for="id">아이디</label>
        <input type="text" class="form-control" id="id" name="id"/>
      </div>
      <div class="form-group">
        <label for="pwd">비밀번호</label>
        <input type="password" class="form-control" id="pwd" name="pwd"/>
      </div>
      <button type="button" class="btn btn-info" id="login_btn">로그인</button>
    </form>

  </div>
</div>


</body>
</html>
