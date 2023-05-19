<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>




<div class="col-sm-12">
  <div class ="container col-sm-12">
    <h2>OCR1 사업자등록증 넣고 자동인식</h2>
      <h5>사업자등록증 이미지를 올려주세요!</h5>
        <h2>   ${result.biznum} </h2>
        <h2>${result.bizname} </h2>
        <h2>  ${result.bizowner}</h2>
        <h2> ${result.bizdate}</h2>
        <h2> ${result.bizadd}</h2>

    <%-- from에선 img 만 전송 하기   --%>
    <form id="ocr1_form" enctype="multipart/form-data"  action="/ocr1impl" method="post" class="form-horizontal well">
      <div class="form-group">
        <label for="img">IMG : </label>
        <input type="file" class="form-control" id="img" name="img" placeholder="이미지를 선택해 주세요"/>
      </div>
      <button type="submit" class="btn btn-info" id="ocr1_btn">버튼버튼</button>
    </form>

  </div>
</div>

