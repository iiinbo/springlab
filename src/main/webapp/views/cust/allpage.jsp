<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


  <%-- cust : 센터 시작  --%>
  <div class="col-sm-12">
  <div class ="container col-sm-12">
    <div class="row content">
      <h3>Cust_ 전체 회원 이력 게시판(Page)</h3><br>
      <%-- 표(테이블)로 db에 담긴 사용자정보(list. 화면에서 뿌릴 땐 clist로 이름 지었다.) 출력하기   --%>
      <table class="table table-hover">
        <thead>
        <tr>
<%--          <th>번호</th>--%>
          <th>아이디</th>
          <th>이름</th>
        </tr>
        </thead>
        <tbody>
        <%--  어떤 items(list명칭)에서 값(무슨)을 꺼낼래?    --%>
        <%-- 컨트롤러에서 cpage 라는 이름으로 만든 걸 사용할 때, getList() 붙여줘야 보임.  --%>
       <c:forEach var="c" items="${cpage.getList()}">
         <tr>
           <td><a href="/cust/get?id=${c.id}"> ${c.id} </a></td>
             <%--  사용자가 각각 id를 누르면 해당하는 id에 대한 정보를 보여줘  --%>
            <td>${c.name}</td>
          </tr>
        </c:forEach>
        </tbody>
      </table>

        <!-- 번호넘기기 : pagination start -->
        <%--  views 폴더 안에 있는 공통 양식의 페이지네이션 바를 사용하면 편리    --%>
        <jsp:include page="../page.jsp"></jsp:include>
        <!-- pagination end -->
    </div>
  </div>
  </div>
