<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--JSTL : 통화 날짜를 표현하게 해주는 문법--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="ko">
<head>
  <title>main</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <style>
    #container{
      width: 90%;
      height: 400px;
      border: red 2px solid;
    }
  </style>
  <script>
  let chart02 = {
    init:function (){
      // 버튼 이벤트 만들기
      $('#chart02 > button').on('click', function (){
        // data를 요청한다. 버튼을 눌렀을 때 chart를 그리기 위해.
        $.ajax({
            url : '/chart02',
            success:function (result){
              chart02.display(result);

            }
        });

      });
      // init:function 함수 안에 - 00초마다 업데이트
      setInterval( function (){
        $.ajax({
          url : '/chart02',
          success:function (result){
            chart02.display(result);
          }
        });
      }, 3000);
    },
    display:function (result){
      // 아래부턴 차트 만들기 가져온 것
      Highcharts.chart('container', {
        chart: {
          type: 'column',
          options3d: {
            enabled: true,
            alpha: 10,
            beta: 25,
            depth: 70
          }
        },
        title: {
          text: 'External trade in goods by country, Norway 2011-2022',
          align: 'left'
        },
        subtitle: {
          text: 'Source: ' +
                  '<a href="https://www.ssb.no/en/statbank/table/08804/"' +
                  'target="_blank">SSB</a>',
          align: 'left'
        },
        plotOptions: {
          column: {
            depth: 25
          }
        },
        xAxis: {
          categories: result.category,
          labels: {
            skew3d: true,
            style: {
              fontSize: '16px'
            }
          }
        },
        yAxis: {
          title: {
            text: 'NOK (million)',
            margin: 20
          }
        },
        tooltip: {
          valueSuffix: ' MNOK'
        },
        series: [{
          name: 'Total imports',
          data: result.datas // 실제 data 들어오는 곳
        }]
      }); //끝.

    }
  };

  // 실행
  $(function (){
    chart02.init();
  })
  </script>
</head>


<body>
    <div class="col-sm-12">
      <div class ="container col-sm-12" id="chart02">
        <h3>chart 02</h3>
        <button type="button" class="btn btn-primary">Chart</button>
        <div id="container"></div>
        <p class="highcharts-description">
          Chart designed to show the difference between 0 and null in a 3D column
          chart. A null point represents missing data, while 0 is a valid value.
        </p>
      </div>
    </div>

</body>
</html>
