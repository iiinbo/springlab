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

</head>
<body>

  <%-- cust : 센터 시작  --%>
  <div class="col-sm-12">
  <div class ="container col-sm-12">
    <h3>jsp02 page</h3>
    <%-- JSTL :  if 문 --%>
    <c:if test = "${rcust != null }">
          <h4>rcust 객체에 정보 있으면, 다음과같이 출력 : ${rcust.id}</h4>
          <c:if test=" ${rcust.id} == 'id01' ">
              <h4>콜센터 직원</h4>
          </c:if>
    </c:if>
    <%-- JSTL :  else-if 문 --%>
    <c:choose>
          <c:when test="${num == 3}">
              <h3>Num is 3</h3>
          </c:when>
          <c:when test="${num == 2}">
            <h3>Num is 2</h3>
          </c:when>
          <c:otherwise>
            <h3>Num is 1</h3>
          </c:otherwise>
    </c:choose>
    <h4>end</h4>

  </div>
  </div>

</body>
</html>
