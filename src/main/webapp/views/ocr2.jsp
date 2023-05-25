<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--JSTL : 통화 날짜를 표현하게 해주는 문법--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



<div class="col-sm-12">
  <div class ="container col-sm-12">
    <h2>OCR1 납부할 고지서 이미지를 첨부하면 자동인식</h2>
      <h5>고객님께서 납부할 내용은 아래와 같습니다.</h5>
        <h2> 고지번호 :  ${result.ocrnum} </h2>
        <h2> 납부금액 : ${result.amount} </h2>
        <h2> 전자납부번호 : ${result.custnum}</h2>


    <%-- from에선 img 만 전송 하기 : 페이지 이동은 main컨트롤러. 검증기능은 CFR 컨트롤러서 처리. --%>
    <form id="ocr2_form" enctype="multipart/form-data"  action="/ocr2impl" method="post" class="form-horizontal well">
      <div class="form-group">
        <label for="img">IMG : </label>
        <input type="file" class="form-control" id="img" name="img" placeholder="이미지를 선택해 주세요"/>
      </div>
      <button type="submit" class="btn btn-info" id="ocr2_btn">버튼버튼</button>
    </form>

  </div>
</div>

<fmt:formatNumber value="${result.amount}" type="number" pattern="###,###원" />