<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script>
    let ajax01 ={
        init:function (){

            setInterval(function (){
                $.ajax({
                    url:'/getservertime',
                    success:function (data){
                        ajax01.display(data);
                    },
                    error:function (){
                        alert('Error...............')
                    }
                });
            },1000);

        },
        display:function (data){
            $('#server_time').text(data)
        }
    };

    $(function (){
        ajax01.init();
    })

    $(document).ready(function() {
        $('#citySelect').change(function() {
            var city = $(this).val();
            $.ajax({
                url: '/getWeather',
                method: 'GET',
                data: {
                    city: city
                },
                success: function(data) {
                    $('#weather').text(city + ' 날씨: ' + data);
                }
            });
        });
    });

</script>

<div class="col-sm-8 text-left">
    <div class="container">
        <h3>ajax01</h3>
        <h4>Server Time</h4>
        <h5 id="server_time"></h5>

        <select id="citySelect">
            <option value="seoul">서울</option>
            <option value="busan">부산</option>
            <option value="daegu">대구</option>
        </select>
        <p id="weather"></p>
    </div>
</div>