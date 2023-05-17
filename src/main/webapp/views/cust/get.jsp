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
    <%--  기능 --%>
    // 기능(스크립트)를 상단에 기입했으므로, 스크립트 끝나기 전 아래 함수 적어줘야 함.
    $(function (){
      //register_form.init();
    });
  </script>

</head>
<body>
<div class="col-sm-12">
  <div class ="container col-sm-12">

      <h2>회원 상세보기</h2>

      <form id="update_form">
        <div class="form-floating mb-3 mt-3">
          <label for="name">이름</label>
          <input type="text" class="form-control" id="name"  name="name" value="${gcust.name}"/>
          <%--   CustController 에서 db에 있는 회원 정보를 담겠다고 만든 이름 : gcust    --%>
        </div>
        <div class="form-floating mb-3 mt-3">
          <label for="id">아이디</label>
          <%--  readonly : 수정 불가한 input 보여주기만 가능.--%>
          <input type="text" class="form-control" id="id" name="id" value="${gcust.id}" readonly/>
        </div>
        <div class="form-floating mt-3 mb-3">
          <label for="pwd">비밀번호</label>
          <input type="text" class="form-control" id="pwd" name="pwd" value="${gcust.pwd}"/>
        </div><br>
        <button type="button" class="btn btn-primary"  id="update_btn">수정하기</button>
        <button type="button" class="btn btn-primary"  id="remove_btn">삭제하기</button>
      </form>



  </div>
</div>


</body>
</html>
