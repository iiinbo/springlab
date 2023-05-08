<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<style>
    .medium_img{
        width:200px;
        height:100px;
    }
</style>

<div class="col-sm-8 text-left">
    <div class="container">
        <h3>Item All Page</h3>
        <div class = "row content">
            <div class="col-sm-8 text-left">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>IMG</th>
                        <th>ID</th>
                        <th>NAME</th>
                        <th>Price</th>
                        <th>RegDate</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="obj" items="${cpage.getList()}"> <%--clist의 객채 1개씩 c라는 이름으로 끄집어 내겟다--%>
                        <tr>
                            <td><img class="medium_img" src="/uimg/${obj.imgname}"></td>
                            <td><a href="/item/get?id=${obj.id}">${obj.id}</a></td>
                            <td>${obj.name}</td>
                            <td><fmt:formatNumber value="${obj.price}" pattern="###,###원"  /></td>
                            <td><fmt:formatDate  value="${obj.rdate}" pattern="yyyy-MM-dd" /></td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
                <jsp:include page="../page.jsp"/>
            </div>
        </div>

    </div>
</div>