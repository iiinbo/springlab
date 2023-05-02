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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <%-- 한데 모은 자바스크립트 파일 가져오기   --%>
    <script src="/js/index0421.js"></script>
    <%-- MAP : 지도 생성   --%>
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4617571d8f9917ae900e8b494a093c31"></script>
    <%-- chart01 : 차트 생성 --%>
    <script src="https://code.highcharts.com/highcharts.js"></script>
    <script src="https://code.highcharts.com/modules/series-label.js"></script>
    <script src="https://code.highcharts.com/modules/exporting.js"></script>
    <script src="https://code.highcharts.com/modules/export-data.js"></script>
    <script src="https://code.highcharts.com/modules/accessibility.js"></script>
    <%--  chart 02...  --%>
    <script src="https://code.highcharts.com/highcharts-3d.js"></script>
    <script src="https://code.highcharts.com/modules/drilldown.js"></script>
    <%-- 라이브 차트 만들기  --%>
    <script src="https://code.highcharts.com/modules/data.js"></script>

    <style>
        /* Remove the navbar's default margin-bottom and rounded borders */
        .navbar {
            margin-bottom: 0;
            border-radius: 0;
        }

        /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
        .row.content {height: 650px}

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
            <a class="navbar-brand" id="logo" href="/">logo</a>
<%--            <img src="/img/logo.png"/>--%>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li><a href="/">홈</a></li>
                <li><a href="/jsp">JSP</a></li>
                <li><a href="/ajax">AJAX</a></li>
                <li><a href="/map">Map</a></li>
                <li><a href="/chart">Chart</a></li>
                <li><a href="/cust">Cust</a></li>
                <li><a href="/item">Item</a></li>
                <%-- 로그인 고객에게만 보여주기    --%>
                <c:if test="${logincust != null }">
                <li><a href="/quics?page=브랜드몰">Contect(회원전용)</a></li>
                </c:if>
            </ul>
            <%--   로그인 고객 & 로그아웃 / 미로그인 고객 & 로그인, 회원가입 노출        --%>
            <c:choose>
                <c:when test="${logincust == null}">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                        <li><a href="/register"><span class="glyphicon glyphicon-log-in"></span> register</a></li>
                    </ul>
                </c:when>
                <c:otherwise>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="/logout"><span class="glyphicon glyphicon-log-in"></span> logout</a></li>
                    </ul>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</nav>

<div class="container-fluid text-center">
    <div class="row content">
        <div class="col-sm-2 sidenav">
        <%-- 왼쪽 사이드바 영역 시작  --%>
            <c:choose>
                <%--  leftNav 가 지정이 안되어있으면(조건) include(실행)--%>
                <c:when test="${leftNav == null}">
                    <jsp:include page="leftNav.jsp"/>
                </c:when>
                <c:otherwise>
                    <%--  center 가 지정되어 있으면(조건) 지정된 leftNav 페이지로 include(실행)--%>
                    <jsp:include page="${leftNav}.jsp"/>
                </c:otherwise>
            </c:choose>
        </div>
         <%-- 왼쪽 사이드바 끝  --%>

        <%-- 센터 시작  --%>
        <div class="col-sm-8 text-left" id="center">
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
