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
    // 제목 다른 텍스트로 바꾸기
      $(function (){
        jsp01.init(${num});
      })
  </script>
</head>
<body>

  <%-- cust : 센터 시작  --%>
  <div class="col-sm-12">
  <div class ="container col-sm-12">
    <h3 id="jsp01">jsp01 page</h3><br>

    <h3><c:out value="${cust}"/></h3>
    <h3><c:out value="${cust.id}"/></h3>
    <h3><c:out value="${cust.name}"/></h3>
    <h3>${cdate}</h3>
    <hr>
    <%--  JSTL : 통화 1 : 소숫점 버리기 --%>
    <h3><fmt:parseNumber integerOnly="true" type="number" value="${num}" /></h3>
    <%--  통화  2 : 맨 앞에 원 표시 넣기--%>
    <h3><fmt:formatNumber value="${num}" type="currency" /></h3>
    <%--  통화 3 : 달러표시 넣기 --%>
    <h3><fmt:formatNumber type="number" pattern="###.###$" value="${num}" /></h3>
    <%--  날짜   --%>
    <h3><fmt:formatDate  value="${cdate}" pattern="yyyy-MM-dd hh:mm:ss" /></h3>

  <%-- JSTL : <c:out value : 사용자가 이름란에 특이한 입력값을 넣어도, 값으로 출력되도록 하는 방법   --%>
    <%-- JSPcontroller 에서 적은 명칭 그대로 쓰면 화면에 보여진다  --%>
    <hr>
    <h3>${num * 2}</h3>


  </div>
  </div>

</body>
</html>
