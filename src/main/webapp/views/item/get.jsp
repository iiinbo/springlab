<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
    #img{
        width:200px;
    }
</style>

<script>
    // 장바구니 담기 기능
    item_get = {
        init:function (){
            $('#cart_btn').click(function (){
                // 다른 방법 : ajax로 정보(3개) 보내보기(본 페이지에 남을 수 있음,)
                let cust_id = '${logincust.id}';
                let item_id = ${gitem.id};
                let cnt = $('#cnt').val();
                $.ajax({
                    url : '/addcart', // ajaximpl 컨트롤러에서 처리
                    data : {cust_id:cust_id, item_id:item_id, cnt:cnt}, // ajax에서 data보내는 방법
                    success : function (){
                        // 여기서 모달 호출 가능(ex. 장바구니에 성공적으로 상품을 담았습니다.)
                        $('#myModal').modal();
                    }
                });
               // 베이직 방법(form 으로 전송하기) : $('#cart_form').attr({
               //     method:'get', /*여기서는 get방식으로 써야한다*/
               //     action:'/item/addcart'
               // });
               //  $('#cart_form').submit();
            });
        }
    };
    $(function (){

    });
    // 화면에 접속 되면 로그인폼 객체에 이닛을 출력해라
    $(function (){
        item_get.init();
    });
</script>

<div class="col-sm-8 text-left">
    <div class="container">
        <h3>Item Info</h3>
        <img id="img" src="/uimg/${gitem.imgname}">
        <h4>${gitem.id}</h4>
        <h4>${gitem.name}</h4>
        <h4>${gitem.price}</h4>

        <c:if test="${logincust !=null}">
        <form id="cart_form" class="form-inline well col-sm-8">
            <input type="hidden" name="cust_id" value="${logincust.id}">
            <input type="hidden" name="item_id" value="${gitem.id}">
            <div class="form-group col-sm-6">
                <label class="control-label col-sm-3" for="cnt">Count: </label>
                <input type="number" class="form-control" id="cnt" name="cnt" placeholder="Enter Count" >
            </div>

            <div class="btns">
                <div class = "col-sm-offset-2 col-sm-2">
                    <button type="button" id="cart_btn" class="btn btn-primary">CART</button>
                </div>
            </div>
        </form>
        </c:if>
    </div>
</div>

<%-- 장바구니에 item 성공적으로 담으면 모달 호출하기 --%>
<!-- id : myModal -->
<div id="myModal" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">

            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">장바구니 추가</h4>
            </div>
            <div class="modal-body">
                <p>상품을 성공적으로 장바구니에 담았습니다! </p>
                <a href="/item/allcart?id=${logincust.id}" class="btn btn-info" role="button">장바구니로 이동</a>
                <a href="/item/allpage" class="btn btn-info" role="button">쇼핑 계속하기</a>

            </div>
            <div class="modal-footer">
            </div>
        </div>

    </div>
</div>