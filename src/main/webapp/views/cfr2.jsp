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
    <h2>CFR2 얼굴 인식해보기</h2>
    <h2> 1 emotion : 당신의 표정은 ${result1} </h2>  <%--   --%>
    <h2> 2 gender : 당신의 성별은 ${result2} </h2>
    <h2> 3 pose : 당신이 취한 자세는 ${result3} </h2>
    <h2> 4 age : 당신의 얼굴 나이는 ${result4} </h2>
    <h5>여러분의 사진파일을 올려주세요!</h5>
    <%-- from에선 img 만 전송 하기   --%>
    <form id="cfr2_form" enctype="multipart/form-data"  action="/cfr2impl" method="post" class="form-horizontal well">
      <div class="form-group">
        <label for="img">IMG : </label>
        <input type="file" class="form-control" id="img" name="img" placeholder="이미지를 선택해 주세요"/>
      </div>
      <button type="submit" class="btn btn-info" id="cfr2_btn">버튼버튼</button>
    </form>

  </div>
</div>

