<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <title>main</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

  <%-- cust : 센터 시작  --%>
  <div class="col-sm-12">
  <div class ="container col-sm-12">
    <div class="row content">
      <h3>Cust_ 전체 회원 이력 게시판</h3><br>
      <%-- 표(테이블)로 db에 담긴 사용자정보(list. 화면에서 뿌릴 땐 clist로 이름 지었다.) 출력하기   --%>
      <table class="table table-hover">
        <thead>
        <tr>
<%--          <th>번호</th>--%>
          <th>아이디</th>
          <th>비밀번호</th>
          <th>이름</th>
        </tr>
        </thead>
        <tbody>
        <%--  어떤 items(list명칭)에서 값(무슨)을 꺼낼래?    --%>
        <c:forEach var="c" items="${clist}">
          <tr>
            <td><a href="/cust/get?id=${c.id}"> ${c.id} </a></td>
              <%--  사용자가 각각 id를 누르면 해당하는 id에 대한 정보를 보여줘  --%>
            <td>${c.pwd}</td>
            <td>${c.name}</td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </div>
  </div>
  </div>

</body>
</html>
