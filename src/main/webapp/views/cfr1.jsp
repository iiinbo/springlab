<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


  <script>
    <%-- 기능 --%>

      $(function (){
          login_form.init();
      });
  </script>



<div class="col-sm-12">
  <div class ="container col-sm-12">
    <h2>CFR1 유명인 얼굴 인식해보기</h2>
    <h2>닮은 유명인은 바로!...${result} 입니다.</h2>  <%-- 마동석  --%>
    <h5>여러분의 사진파일을 올려주세요! 닮은 유명인을 찾아드립니다.</h5>
    <%-- from에선 img 만 전송 하기   --%>
    <form id="cfr1_form" enctype="multipart/form-data"  action="/cfr1impl" method="post" class="form-horizontal well">
      <div class="form-group">
        <label for="img">IMG : </label>
        <input type="file" class="form-control" id="img" name="img" placeholder="이미지를 선택해 주세요"/>
      </div>
      <button type="submit" class="btn btn-info" id="cfr1_btn">버튼버튼</button>
    </form>

  </div>
</div>

