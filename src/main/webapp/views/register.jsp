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

  <script>
    <%-- 회원가입 기능 --%>
    // 회원가입 기능(스크립트)를 상단에 기입했으므로, 스크립트 끝나기 전 아래 함수 적어줘야 함.
    $(function (){
      register_form.init();
    });
  </script>

</head>
<body>
<div class="col-sm-12">
  <div class ="container col-sm-12">

      <h2>회원가입</h2>
      <p>브레드 이발소의 친구가 되어주세요!</p>
      <form id="register_form">
        <div class="form-floating mb-3 mt-3">
          <label for="name">이름</label>
          <input type="text" class="form-control" id="name" placeholder="Enter name" name="name"/>
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
