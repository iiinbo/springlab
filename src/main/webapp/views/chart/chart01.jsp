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
    let chart01 = {
      init:function (){
        // 아래부턴 https://www.highcharts.com/demo/spline-symbols 에서 가져온 영역(하단)
        Highcharts.chart('container', {
          chart: {
            type: 'spline'
          },
          title: {
            text: 'Monthly Average Temperature'
          },
          subtitle: {
            text: 'Source: ' +
                    '<a href="https://en.wikipedia.org/wiki/List_of_cities_by_average_temperature" ' +
                    'target="_blank">Wikipedia.com</a>'
          },
          xAxis: {
            categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
              'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
            accessibility: {
              description: 'Months of the year'
            }
          },
          yAxis: {
            title: {
              text: 'Temperature'
            },
            labels: {
              formatter: function () {
                return this.value + '°';
              }
            }
          },
          tooltip: {
            crosshairs: true,
            shared: true
          },
          plotOptions: {
            spline: {
              marker: {
                radius: 4,
                lineColor: '#666666',
                lineWidth: 1
              }
            }
          },
          // series : 데이터(배열로 이루어져있다.)
          series: [{
            name: 'Tokyo',
            marker: {
              symbol: 'square'
            },
            data: [5.2, 5.7, 8.7, 13.9, 18.2, 21.4, 25.0, 26,  22.8, 17.5, 12.1, 7.6]

          }, {
            name: 'Bergen',
            marker: {
              symbol: 'diamond'
            },
            data: [ 1.0, 1.6, 3.3, 5.9, 10.5, 13.5, 14.5, 14.4, 11.5, 8.7, 4.7, 2.6]
          },
            // 아래 값 추가하면 그래프 추가됨.
            {
            name: 'Korea',
            marker: {
              symbol: 'diamond'
            },
            data: [ 2.0, 2.6, 4.3, 6.9, 11.5, 14.5, 13.5, 18.4, 12.5, 3.7, 6.7, 5.6]
          }
          ]
        }); // 복붙종료

      }
    }



    // 실행
    $(function (){
        chart01.init();
    })
  </script>
</head>

<body>
    <div class="col-sm-12">
      <div class ="container col-sm-12" id="chart01">
        <h3>chart 01</h3>
        <div id="container"></div>


      </div>
    </div>

</body>
</html>
