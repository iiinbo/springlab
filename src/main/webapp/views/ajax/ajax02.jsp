<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script>

       let ajax02={
        init:function(){
            this.keyupevent();
            this.sendevent();
        },
           keyupevent:function(){
            $('#r_form > input[name=id]').keyup(function (){
                var id = $(this).val();
                if(id.length <=3){
                    $('#r_form > #idspan').text('ID를 4자리 이상으로 만드세요');
                    return; // 밑에 함수로 내려가지 않고 현재 함수에서 종료 하도록 리턴으로 제어한다. 개 중요하니 암기해라
                };
                $.ajax({
                    url:'/checkid',
                    data:{'id':id}, // 'id' 라는 이름으로 id를 전송하 겠다
                    success:function (result){
                        if(result == 0){
                            $('#r_form > #idspan').text('사용가능한 ID입니다.')
                            $('#r_form > input[name="pwd"]').focus();
                        }else{
                            $('#r_form > #idspan').text('이미 사용중인 ID입니다..')

                        }
                    }  //주의!!!success일때는 세미콜론, 컴마가 없다!!!!!!!!!!!!!!!!!!!!
                });
            });
           },
           sendevent:function (){}
    };

    // hhh
    $(function (){
        ajax02.init();
    })

</script>

<div class="col-sm-8 text-left">
    <div class="container">
        <h3>ajax02</h3>
        <form id="r_form">
            ID<input type="text" name="id"><span id="idspan"></span><br>
            PWD<input type="text" name="pwd"><br>
            NAME<input type="text" name="name"><br>
            <input type="button" name="Register"><br>
        </form>

    </div>
</div>