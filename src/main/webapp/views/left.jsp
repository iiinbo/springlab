<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-sm-2 sidenav">
    <p><a href="/pic">Pic</a></p>
        <%--  로그인 고객만 보여지게  --%>
    <c:if test="${logincust != null}">
    <p><a href="/websocket">websocket</a></p>
    </c:if>
    <p><a href="/">ll</a></p>
</div>