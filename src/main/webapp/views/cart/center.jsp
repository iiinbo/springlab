<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<style>
  .medium_img{
    width: 60px;
    height: 60px;
  }
</style>

  <%-- cart : 센터 시작  --%>
  <div class="col-sm-12">
  <div class ="container col-sm-12">
    <h3>나의 장바구니</h3>
    <div class = "row content">
      <div class="col-sm-12 text-left">
        <c:set var="total" value="0" />

        <table class="table table-hover ">
          <colgroup>
            <col width="10%" />
            <col width="10%" />
            <col width="20%" />
            <col width="15%" />
            <col width="10%" />
            <col width="15%" />
            <col width="10%" />
            <col width="10%" />
          </colgroup>
          <thead>
          <tr>
            <th>IMG</th>
            <th>ITEM_ID</th>
            <th>상품명</th>
            <th>상품금액</th>
            <th>개수</th>
            <th>총금액</th>
            <th>담은날짜</th>
            <th>비고</th>
          </tr>
          </thead>
          <tbody>
          <c:forEach var="obj" items="${mycart}"> <%--cart컨트롤러에서 정한 명칭 : mycart의 객채 1개씩 obj라는 이름으로 끄집어 내겟다--%>
            <tr>
              <td><img class="medium_img" src="/uimg/${obj.item_imgname}"></td>
              <td>${obj.item_id}</td>
              <td>${obj.item_name}</td>
              <td><fmt:formatNumber value="${obj.item_price}" pattern="###,###원" /></td>
              <td>${obj.cnt}</td>
              <td><fmt:formatNumber value="${obj.cnt * obj.item_price}" pattern="###,###원" /></td> <%-- total 금액 --%>
              <td><fmt:formatDate  value="${obj.rdate}" pattern="yyyy-MM-dd" /></td>
              <%-- cart 컨트롤러에서 담긴상품 삭제 처리 --%>
              <%-- id 는 cart 테이블의 시퀀스로 된 id --%>
              <td><a href="/cart/delete?id=${obj.id}" class="btn btn-info" role="button">삭제</a> </td>
            </tr>
            <%-- total 초기값 0 + 더해지는 ITEM 금액 누적하기 --%>
            <c:set var="total" value="${total + (obj.cnt * obj.item_price) }" />
          </c:forEach>
          </tbody>
        </table>
        <%--  장바구니에 담긴 아이템 금액 합계 찍기위해 상단에 set으로 변수 total선언, 하단에 value표기--%>
        <h4>결제 시 예상금액 <fmt:formatNumber value="${total}" pattern="###,###원" /></h4>

      </div>
    </div>
  </div>
  </div>


