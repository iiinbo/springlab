<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
  td > img{
    width: 70px;
    height: 70px;
  }
</style>


  <%-- Map : 센터 시작  --%>
  <div class="col-sm-12">
  <div class ="container col-sm-12">
    <h3> ${gmarker.loc}맛집 추천 리스트</h3><hr>
    <h4><a href="${gmarker.target}"> ${gmarker.title}</a></h4>
    <img src="/uimg/${gmarker.img}">
    <h4>${gmarker.id}</h4>

    <br>
        <div class="row content">
          <h3>메뉴 자세히 보기</h3><br>
          <%-- 표(테이블)로 db에 담긴 사용자정보(list. 화면에서 뿌릴 땐 clist로 이름 지었다.) 출력하기   --%>
          <table class="table table-hover">
            <colgroup>
                <col width="50%">
                <col width="25%">
                <col width="25%">
            </colgroup>
            <thead>
            <tr>
              <%--          <th>번호</th>--%>
              <th>이미지</th>
              <th>아이템</th>
              <th>가격</th>
            </tr>
            </thead>
            <tbody>
            <%--  어떤 items(list명칭)에서 값(무슨)을 꺼낼래?    --%>
            <c:forEach var="m" items="${mlist}">
              <tr>
                <td><img src="/uimg/${m.imgname}" ></td>
                <td>${m.item}</td>
                <td>${m.price}</td>
              </tr>
            </c:forEach>
            </tbody>
          </table>
        </div>


  </div>
  </div>

