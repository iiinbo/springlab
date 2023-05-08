<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

<script>
     // 화면에 접속 되면 로그인폼 객체에 이닛을 출력해라
    $(function (){
        login_form.init();
    });
</script>
<div class="col-sm-8 text-left">
  <div class="container col-sm-12">
      <div class="col-sm-6">
          <div class=col-sm-6">
          <h1>Login Page</h1>

          <form id="login_form" class="form-horizontal well">
              <div class="form-group">
                  <input type="ID" class="form-control" id="id" name="id" placeholder="Enter Your ID" >
              </div>

              <div class="form-group">
                  <input type="password" class="form-control" id="pwd" name="pwd" placeholder="Enter password" >
              </div>

              <div class="btns">
                  <button type="button" id="login_btn" class="btn btn-primary">Login</button>
              </div>
          </form>

          </div>
      </div>
  </div>
</div>