<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 다국어 적용 : 라이브러리 --%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>



    <%-- 센터 시작  --%>
    <div class="col-sm-8">
        <%--  다국어 적용 :  site.title 란에 '영어' 또는 '한국어' 보임 --%>
        <h1><spring:message code="site.title"/></h1>
        <div class ="container col-sm-12">
             <img src="/uimg/a.jpg" alt="Chicago" class="d-block" style="width:100%">
        </div><hr>
          <h5><spring:message code="site.contents"/></h5>
    </div>
    <%-- 센터 끝  --%>

