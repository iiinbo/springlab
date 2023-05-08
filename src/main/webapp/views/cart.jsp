<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<style>
    .medium_img{
        width:80px;
    }
</style>
<%--복습필요--%>
<div class="col-sm-8 text-left">
    <div class="container">
        <h3>Cart 나의 장바구니</h3>
        <div class = "row content">
            <div class="col-sm-8 text-left">
                <c:set var="total" value="0" />
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>IMG</th>
                        <th>ITEM_ID</th>
                        <th>NAME</th>
                        <th>Price</th>
                        <th>Count</th>
                        <th>Total</th>
                        <th>RegDate</th>
                        <th>Delete</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="obj" items="${allcart}"> <%--clist의 객채 1개씩 c라는 이름으로 끄집어 내겟다--%>
                        <tr>
                            <td><img class="medium_img" src="/uimg/${obj.item_imgname}"></td>
                            <td>${obj.item_id}</td>
                            <td>${obj.item_name}</td>
                            <td><fmt:formatNumber value="${obj.item_price}" pattern="###,###원" /></td>
                            <td>${obj.cnt}</td>
                            <td>${obj.cnt * obj.item_price}</td> <%-- total 금액 --%>
                            <td><fmt:formatDate  value="${obj.rdate}" pattern="yyyy-MM-dd" /></td>
                            <td><a href="/item/delcart?id=${obj.id}" class="btn btn-info" role="button">삭제</a> </td> <%-- id 는 cart 테이블의 시퀀스로 된 id --%>
                        </tr>
                        <%-- total 초기값 0 + 더해지는 ITEM 금액 누적하기 --%>
                        <c:set var="total" value="${total + (obj.cnt * obj.item_price) }" />
                    </c:forEach>
                    </tbody>
                </table>
                <%--  장바구니에 담긴 아이템 금액 합계 찍기위해 상단에 set으로 변수 total선언, 하단에 value표기--%>
                    <h4>장바구니 합계 <fmt:formatNumber value="${total}" pattern="###,###원" /></h4>

            </div>
        </div>

    </div>
</div>