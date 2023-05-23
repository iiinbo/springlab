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
    let chart05={
      init:function (){
        // 버튼 누르면 이벤트 발생해주기
        $('#get_btn').click( function (){
          var year = $('#sel1').val(); // input과 같은 값은 val로 가져온당
          chart05.getdata(year);
        });

      },
      getdata:function (year){
          //데이터는 서버에 ajax로 보내기
          $.ajax({
            url:'/chart05',
            data:{"year":year},
            success:function (result){
             chart05.display1(result);
             chart05.display2(result);
            }
          });
      },
      display1:function (result){
        // 붙이기
        Highcharts.chart('c1', {
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
          series: [{
            name: 'Korea',
            marker: {
              symbol: 'square'
            },
            data: result

          }]
        });

      },
      display2:function (result){
        // 붙이기
        Highcharts.chart('c2', {
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
            text: 'External trade in goods by country, Norway 2021',
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
            categories: ['Belgium', 'China', 'Denmark', 'Fiji', 'Germany', 'Netherlands', 'Russia',
              'Sweden', 'Turkey', 'United States', 'Unspecified', 'Vietnam'],
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
            data: result
          }]
        });

      },
    }



    // 실행
    $(function (){
      chart05.init();
    })
  </script>
</head>
<body>
  <div class="col-sm-12">
    <div class ="container col-sm-12" id="chart05">
      <h3>chart 05 : 차트 선택하면 해당차트 보기</h3>
      <div class="row">
      <div class="form-group col-sm-4">
        <label for="sel1">Year:</label>
        <select class="form-control" id="sel1">
          <%-- jstl 사용해서 2010년~2020년까지 for문이 계속 돈당 --%>
          <c:forEach begin="2010" end="2020" var="year">
                <option value="${year}">${year}</option>
          </c:forEach>
        </select><br>
        <button type="button" id="get_btn">Show me!</button>
      </div>

      </div>
      <%--  버튼 누르면, 해당 차트가 보여지는 영역    --%>
      <div class="row">
        <div class="col-sm-6" id="c1">chart1</div>
        <div class="col-sm-6" id="c2">chart2</div>

      </div>
    </div>
  </div>

</body>
</html>
