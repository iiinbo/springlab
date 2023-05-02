<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <title>register page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

  <script>

    <%-- 나의 회원정보 수정하기 기능 --%>

    let custinfo_form = {
      init:function () { // 화면에 이벤트 처리
        // 버튼 클릭되면 send 함수가 실행된다
        $('#custinfo_btn').click(function () {
          custinfo_form.send();
        });
      },
      send:function () { // 보내기
        var id =  $('#id').val();
        var pwd = $('#pwd').val();
        var name = $('#name').val();
        if( id.length <= 3 ){ // 3자리 이하면 그만진행(가입 안되게)
          $('#check_id').text("id는 4자리 이상이어야 합니다.");
          $('#id').focus();

          return;
        }
        if( pwd == '' ){ // 공백이면 그만진행(수정 안되게)
          $('#pwd').focus();
          return;
        }
        if( name == '' ){ // 공백이면 그만진행
          $('#name').focus();
          return;
        }

        $('#custinfo_form').attr({
          'action':'/custinfoimpl', // maincontroller 로 보낸다.
          'method':'post'
        });
        $('#custinfo_form').submit(); // 수정한 pwd, name 모두 전송.
      }
    };
    $(function (){
      custinfo_form.init();
    });
  </script>
</head>
  <div class="col-sm-8 text-left">
    <div class="container">
      <div class="row content">
        <div class="col-sm-6  text-left ">
          <h1>custinfo Page</h1>
          <form id="custinfo_form" class="form-horizontal well">
            <%-- 나의 정보 상세보기  --%>
            <div class="form-group">
              <label class="control-label col-sm-2" for="id">ID:</label>
              <div class="col-sm-10">
                <input type="text" name="id" class="form-control" id="id" value="${custinfo.id}" readonly>
              </div>
            <div class="form-group">
              <label class="control-label col-sm-2" for="pwd">Password:</label>
              <div class="col-sm-10">
                <input type="password" name="pwd" class="form-control" id="pwd">
              </div>
            </div>
            <div class="form-group">
              <label class="control-label col-sm-2" for="name">NAME:</label>
              <div class="col-sm-10">
                <input type="text" name="name" class="form-control" id="name" value="${custinfo.name}">
              </div>
            </div>
            <div class="form-group">
              <div class="col-sm-offset-2 col-sm-10">
                <button id="custinfo_btn" type="button" class="btn btn-default">수정하기</button>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>