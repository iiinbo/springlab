<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

<script>
    let register_form = {
        init:function (){
            $('#register_btn').addClass('disabled');
            $('#register_btn').click(function (){
                register_form.send();
            });
            $('#name').keyup(function () {
                var id = $('#id').val();
                var pwd = $('#pwd').val();
                var name = $('#name').val();
                if (id != '' && pwd != '' && name != '') {
                    $('#register_btn').removeClass('disabled')
                }
            });

                $('#id').keyup(function (){
                var txt_id =  $('#id').val();
                if(txt_id.length <= 3){
                   return;
               }
                $.ajax({
                    url:'/checkid',
                    data:{'id':txt_id}, // 'id' 라는 이름으로 id를 전송하 겠다
                    success:function (result){
                        if(result == 0){
                            $('#check_id').text('사용가능한 ID입니다.')
                            //$('#pwd').focus();
                        }else{
                            $('#check_id').text('이미 사용중인 ID입니다..')
                        }
                    }  //주의!!!success일때는 세미콜론, 컴마가 없다!!!!!!!!!!!!!!!!!!!!
                });
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

            $('#register_form').attr({
                'action':'/registerimpl',
                'method':'post'
            });
            $('#register_form').submit();
        }
    };



    // 화면에 접속 되면 로그인폼 객체에 이닛을 출력해라
    $(function (){
        register_form.init();
    });
</script>

<div class="col-sm-8 text-left">
  <div class="container col-sm-8">
      <h1>Register Page</h1></br>
      <form id="register_form" class="form-horizontal well">
          <div class="form-group">
              <input type="text" class="form-control" id="id" name="id" placeholder="Make Your ID" >
          </div>
              <div class="col-sm-10">
                  <span id="check_id" class="bg-danger"></span>
              </div>

          <div class="form-group">
              <input type="password" class="form-control" id="pwd" name="pwd" placeholder="Enter password" >
          </div>

          <div class="form-group">
              <input type="name" class="form-control" id="name" name="name" placeholder="name" >
          </div>

              <div>
                  <button type="button" id="register_btn" class="btn btn-primary">Regsiter</button>
              </div>
      </form>


  </div>
</div>