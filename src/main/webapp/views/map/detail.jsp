<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-sm-8 text-left">
    <div class="container">
        <h3>${gmarker.title} 상세정보</h3>
        <img src="/uimg/${gmarker.img}">
        <h4>${gmarker.id}</h4>
        <h4><a href="${gmarker.target}">${gmarker.title} 홈페이지</a></h4>

        <h4>${gmarker.lat}</h4>
        <h4>${gmarker.lng}</h4>

        <div class = "row content">
            <div class="col-sm-6 text-left">
                <h3>${gmarker.title} 메뉴</h3>
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>IMG</th>
                        <th>ITEM</th>
                        <th>PRICE</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="m" items="${mlist}"> <%--clist의 객채 1개씩 c라는 이름으로 끄집어 내겟다--%>
                        <tr>
                            <td><img src="/uimg/${m.imgname}" style="width: 50px"></td>
                            <td>${m.item}</td>
                            <td>${m.price}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

    </div>
</div>