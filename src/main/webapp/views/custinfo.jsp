<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

<script>
    let custinfo_form = {
        init:function (){
            $('#custinfo_btn').click(function (){
                custinfo_form.send();
            });

        },
        send:function (){
            var id = $('#id').val();
            var pwd = $('#pwd').val();
            var name = $('#name').val();
            if(id.length <= 3){
                $('#check_id').text('ID는 4자리 이상으로 만들어 주세용~♥');
                $('#id').focus();
                return;
            }
            if(pwd == ''){
                $('#pwd').focus();
                return;
            }
            if(name == ''){
                $('#name').focus();
                return;
            }

            $('#custinfo_form').attr({
                'action':'/custinfoimpl',
                'method':'post'
            });
            $('#custinfo_form').submit();
        }
    };



    // 화면에 접속 되면 로그인폼 객체에 이닛을 출력해라
    $(function (){
        custinfo_form.init();
    });
</script>

<div class="col-sm-8 text-left">
  <div class="container col-sm-8">
      <h1>Cust Info Page</h1></br>
      <form id="custinfo_form" class="form-horizontal well">
          <div class="form-group">
              <input type="ID" class="form-control" id="id" name="id" value="${custinfo.id}" readonly>
          </div>
              <div class="col-sm-10">
                  <span id="check_id" class="bg-danger"></span>
              </div>

          <div class="form-group">
              <input type="password" class="form-control" id="pwd" name="pwd" >
          </div>

          <div class="form-group">
              <input type="name" class="form-control" id="name" name="name" value="${custinfo.name}" >
          </div>

              <div>
                  <button type="button" id="custinfo_btn" class="btn btn-primary">회원정보 수정</button>
              </div>
      </form>


  </div>
</div>