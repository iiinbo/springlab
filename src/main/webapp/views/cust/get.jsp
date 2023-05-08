<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

<script>
    // 화면에 접속 되면 로그인폼 객체에 이닛을 출력해라
    $(function (){

    });
</script>

<div class="col-sm-8 text-left">
  <div class="container col-sm-8">
      <h1>Detail Page</h1></br>
      <form id="update_form" class="form-horizontal well">
          <div class="form-group">
              <input type="ID" class="form-control" id="id" name="id" value="${gcust.id}" readonly>
          </div>

          <div class="form-group">
              <input type="password" class="form-control" id="pwd" name="pwd" value="${gcust.pwd}" >
          </div>

          <div class="form-group">
              <input type="name" class="form-control" id="name" name="name" value="${gcust.name}" >
          </div>

              <div>
                  <button type="button" id="Update_btn" class="btn btn-primary">Update</button>
              </div>

              <div>
                  <button type="button" id="Remove_btn" class="btn btn-primary">Remove</button>
              </div>
      </form>

  </div>
</div>