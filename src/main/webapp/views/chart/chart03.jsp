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
    /*#c1, #c2, #c3{*/
    /*  width: 32%;*/
    /*  height: 50%;*/
    /*  border: #555555 solid 1px;*/
    /*  margin: 2px;*/
    /*}*/

  </style>

  <script>
    let chart03={
      init:function (){
          this.getdata1();

          this.getdata2();
          this.getdata3();
      },
      // 3번의 data를 ajax보고 가져오라 요청하고, 각각 display에 뿌리기.
      getdata1:function (){
          $.ajax({
              url:'/chart0301',
              success:function (result){
                chart03.display1(result); }

          });
      },
      getdata2:function (){
          $.ajax({
            url:'/chart0302',
            success:function (result){ chart03.display2(result); }
          });
      },
      getdata3:function (){
        $.ajax({
          url:'/chart0303',
          success:function (result){
            chart03.display3(result);
          }
        });
      },
      // 차트 그리는 공간 : 복사 붙여넣기
      display1:function (result){
        Highcharts.chart('c1', { // id변경
          chart: {
            type: 'pie',
            options3d: {
              enabled: true,
              alpha: 45
            }
          },
          title: {
            text: 'Beijing 2022 gold medals by country',
            align: 'left'
          },
          subtitle: {
            text: '3D donut in Highcharts',
            align: 'left'
          },
          plotOptions: {
            pie: {
              innerSize: 100,
              depth: 45
            }
          },
          series: [{
            name: 'Medals',
            data: result // 배열안에 배열형태.

          }]
        }); // 붙여넣기 끝.

      },
      display2:function (result){
        Highcharts.chart('c2', {
          chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false,
            type: 'pie'
          },
          title: {
            text: 'Browser market shares in May, 2020',
            align: 'left'
          },
          tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
          },
          accessibility: {
            point: {
              valueSuffix: '%'
            }
          },
          plotOptions: {
            pie: {
              allowPointSelect: true,
              cursor: 'pointer',
              dataLabels: {
                enabled: true,
                format: '<b>{point.name}</b>: {point.percentage:.1f} %'
              }
            }
          },
          series: [{
            name: 'Brands',
            colorByPoint: true,
            data: result
          }]
        });
        // 붙 끝.

      },
      display3:function (result){
        Highcharts.chart('c3', {
          chart: {
            type: 'area',
            options3d: {
              enabled: true,
              alpha: 15,
              beta: 30,
              depth: 200
            }
          },
          title: {
            text: 'Visual comparison of Mountains Panorama'
          },
          accessibility: {
            description: 'The chart is showing the shapes of three mountain ranges as three area line series laid out in 3D behind each other.',
            keyboardNavigation: {
              seriesNavigation: {
                mode: 'serialize'
              }
            }
          },
          lang: {
            accessibility: {
              axis: {
                xAxisDescriptionPlural: 'The chart has 3 unlabelled X axes, one for each series.'
              }
            }
          },
          yAxis: {
            title: {
              text: 'Height Above Sea Level',
              x: -40
            },
            labels: {
              format: '{value:,.0f} MAMSL'
            },
            gridLineDashStyle: 'Dash'
          },
          xAxis: [{
            visible: false
          }, {
            visible: false
          }, {
            visible: false
          }],
          plotOptions: {
            area: {
              depth: 100,
              marker: {
                enabled: false
              },
              states: {
                inactive: {
                  enabled: false
                }
              }
            }
          },
          tooltip: {
            valueSuffix: ' MAMSL'
          },
          series: [{
            name: 'Tatra Mountains visible from Rusinowa polana',
            lineColor: 'rgb(180,90,50)',
            color: 'rgb(200,110,50)',
            fillColor: 'rgb(200,110,50)',
            data: result.datas1
          }, {
            xAxis: 1,
            lineColor: 'rgb(120,160,180)',
            color: 'rgb(140,180,200)',
            fillColor: 'rgb(140,180,200)',
            name: 'Dachstein panorama seen from Krippenstein',
            data: result.datas2
          }, {
            xAxis: 2,
            lineColor: 'rgb(200, 190, 140)',
            color: 'rgb(200, 190, 140)',
            fillColor: 'rgb(230, 220, 180)',
            name: 'Panorama from Col Des Mines',
            data: result.datas3
          }]
        });

      }

    }

    // 실행
    $(function (){
      chart03.init();
    })
  </script>
</head>
<body>
    <div class="col-sm-12">
      <div class ="container col-sm-12" id="chart03">
        <h3>chart 03</h3>
        <div class="row">
          <div class="col-sm-4" id="c1">chart1</div>
          <div class="col-sm-4" id="c2">chart2</div>
          <div class="col-sm-4" id="c3">chart3</div>
        </div>

      </div>
    </div>

</body>
</html>
