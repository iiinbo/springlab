<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 다국어 적용 : 라이브러리 --%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<script>
    let center = {
        init:function (){
            $.ajax({ // 브라우저 화면에서, ajax로 요청 주면, data 보여주기
                url : '/weather2', // ajaximpl 컨트롤러에서 처리
                success : function (data){
                    center.display(data);
                }
            });
        }, display:function (data){ // data : json이 담겨있어
             var result = data.response.body.items.item; // result = item : [] 배열이다.
            var txt = ''; // 배열에 담긴 {} 객체 여러~개를 예쁘게 txt로 출력해서-
            $(result).each(function (index, item){ //index(0) 부터 item에 담긴 마지막 {object} 까지 돈다.
                txt += '<h5>';
                txt += ' 연월일시 :' + item.tm + ' 기온 :' + item.ta ;
                txt += '<h5>';
            });
            $('#w2').html(txt); // -화면에 보여주기.
        }
    };
    // 실행
    $(function (){
       // center.init();
    });
</script>
<style>
    #w2 {
        width: 500px;
        height: 500px;
        border: 2px solid red;
    }
</style>

    <%-- 센터 시작  --%>
    <div class="col-sm-8">
<%--          다국어 적용 :  site.title 란에 '영어' 또는 '한국어' 보임--%>
                <h1><spring:message code="site.title"/></h1>
                <div class ="container col-sm-12">
                     <img src="/uimg/a.jpg" alt="Chicago" class="d-block" style="width:100%">
                </div><hr>
                  <h5><spring:message code="site.contents"/></h5>
        <textarea id="w1" cols="60" rows="10">${weatherinfo}</textarea><hr>
        <div id="w2"></div>
    </div>
    <%-- 센터 끝  --%>

