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
    <style>
        /* Remove the navbar's default margin-bottom and rounded borders */

        .navbar {
            margin-bottom: 0;
            border-radius: 0;

        }
        .navbar-brand{
            margin: 0px;
            padding: 0px;

        }
        /*#logo > img {*/
        /*    width: 110px;*/
        /*    height: 50px;*/
        /*    margin-top: -15px;*/


        /*}*/
        /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
        .row.content {height: 450px}

        /* Set gray background color and 100% height */
        .sidenav {
            padding-top: 20px;
            background-color: #f1f1f1;
            height: 100%;
        }

        /* Set black background color, white text and some padding */
        footer {
            background-color: #555;
            color: white;
            padding: 15px;
        }

        /* On small screens, set height to 'auto' for sidenav and grid */
        @media screen and (max-width: 767px) {
            .sidenav {
                height: auto;
                padding: 15px;
            }
            .row.content {height:auto;}
        }
    </style>

</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" id="logo" href="/">
<%--            <img src="/img/logo.png"/>--%>
            </a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/">홈</a></li>
                <li><a href="/quics?page=캐릭터소개">캐릭터소개</a></li>
                <li><a href="/quics?page=스토리">스토리</a></li>
                <li><a href="/quics?page=브랜드몰">브랜드몰</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                <li><a href="/register"><span class="glyphicon glyphicon-log-in"></span> register</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container-fluid text-center">
    <div class="row content">
        <div class="col-sm-2 sidenav">
        <%-- 왼쪽 사이드바 영역 시작  --%>
        <jsp:include page="leftNav.jsp"/>
        </div>
         <%-- 왼쪽 사이드바 끝  --%>

        <%-- 센터 시작  --%>
        <div class="col-sm-8 text-left">
        <c:choose>
            <%--  center 가 지정이 안되어있으면(조건) include(실행)--%>
            <c:when test="${center == null}">
                <jsp:include page="center.jsp"/>
            </c:when>
            <c:otherwise>
                <%--  center 가 지정되어 있으면(조건) 지정된 center 페이지로 include(실행)--%>
                <jsp:include page="${center}.jsp"/>
        </c:otherwise>
        </c:choose>
        </div>
        <%-- 센터 끝  --%>

            <%-- 오른쪽 사이드바 시작  --%>
        <div class="col-sm-2 sidenav">
            <jsp:include page="rightNav.jsp"/>
        </div>
            <%-- 오른쪽 사이드바 끝  --%>


    </div>
</div>

<footer class="container-fluid text-center">
    <p>Footer Text</p>
</footer>

<%--   다른 페이지로 넘어가기. <h3><a href="/quics?page=bs03">BS03</a> </h3>--%>
</body>
</html>
