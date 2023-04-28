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
<style>
  img{
    width: 50px;
    height: 50px;
  }
</style>
</head>
<body>

  <%-- cust : 센터 시작  --%>
  <div class="col-sm-12">
  <div class ="container col-sm-12">
    <div class="row content">
      <h3>판매 중인 브랜드 상품 모아보기</h3><br>
      <%-- 표(테이블)로 db에 담긴 사용자정보(list. 화면에서 뿌릴 땐 이름지어뒀다.) 출력하기   --%>
      <table class="table table-hover">
        <thead>
        <tr>
          <th>이미지</th>
          <th>상품번호</th>
          <th>상품명</th>
          <th>가 격</th>
          <th>등록일</th>
        </tr>
        </thead>
        <tbody>
        <%--  어떤 items(list명칭 : 컨트롤러에서 지정)에서 값(무슨)을 꺼낼래?    --%>
        <c:forEach var="c" items="${allitem}">
          <tr>
            <td><img src="/uimg/${c.imgname}"></td>
            <td><a href="/item/get?id=${c.id}"> ${c.id} </a></td>
              <%--  사용자가 각각 id를 누르면 해당하는 id에 대한 상세 정보를 보여줘  --%>
            <td>${c.name}</td>
            <td><fmt:formatNumber value="${c.price}" type="currency" /></td>
            <td><fmt:formatDate  value="${c.rdate}" pattern="yyyy-MM-dd" /></td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </div>
  </div>

  </div>


</body>
</html>
<fmt:formatDate  value="${c.rdate}" pattern="yyyy-MM-dd hh:mm:ss" />
