<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script>
/*    let jsp01 ={
        data:0,
        init:function (){
            // this.data = ${num};
            this.data = '<c:out value="${num}"/>';
            this.display();
        },
        display:function (){
            $('#jsp01').text(this.data+'');
        }
    };*/

    $(function (){
        jsp01.init(${num});
    })

</script>

<div class="col-sm-8 text-left">
    <div class="container">
        <h3 id="jsp01">JSP01</h3> <%--변수선언으로 script 안의 변수와 함수를 받아옴--%>
        <h3><fmt:parseNumber integerOnly="true" type="number" value="${num}" /></h3>
        <h3><fmt:formatNumber value="${num}" type="currency" /></h3>
        <h3><fmt:formatNumber value="${num}" type="number" pattern="###.###$"  /></h3>
        <h3><fmt:formatDate  value="${cdate}" pattern="yyyy-MM-dd hh:mm:ss" /></h3>
        <h3><c:out value="${cust.id}"/></h3>    <%--보안상 이렇게 함--%>
        <h3><c:out value="${cust.name}"/></h3>  <%--보안상 이렇게 함--%>
        <h3>${num*2}</h3>
        <c:set var="mynum" value="${num * 3}"/> <%--화면에 출력은 안되지만 mynum을 특정 향후에 뿌리겟다지만 있다는것만 기억하고 실무상은 안써 서버에서 계산해서 뿌리는게 좋다--%>
        <h3><c:out value="${mynum}"/> </h3>
    </div>
</div>