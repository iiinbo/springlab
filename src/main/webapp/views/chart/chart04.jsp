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
  let chart04 = {
      init:function (){
       //차트 뿌리기
            var defaultData = 'http://127.0.0.1/logs/custinfo.log'; // 나의 log로 바꿈.
            var urlInput = document.getElementById('fetchURL');
            var pollingCheckbox = document.getElementById('enablePolling');
            var pollingInput = document.getElementById('pollingTime');

            function createChart() {
              Highcharts.chart('container', {
                chart: {
                  type: 'spline'
                },
                title: {
                  text: 'Live Data'
                },
                accessibility: {
                  announceNewData: {
                    enabled: true,
                    minAnnounceInterval: 15000,
                    announcementFormatter: function (allSeries, newSeries, newPoint) {
                      if (newPoint) {
                        return 'New point added. Value: ' + newPoint.y;
                      }
                      return false;
                    }
                  }
                },
                data: {
                  csvURL: urlInput.value,
                  enablePolling: pollingCheckbox.checked === true,
                  dataRefreshRate: parseInt(pollingInput.value, 10)
                }
              });

              if (pollingInput.value < 1 || !pollingInput.value) {
                pollingInput.value = 1;
              }
            }

            urlInput.value = defaultData;

          // We recreate instead of using chart update to make sure the loaded CSV
           // and such is completely gone.
            pollingCheckbox.onchange = urlInput.onchange = pollingInput.onchange = createChart;

          // Create the chart
            createChart();

      }

  }


    // 실행
    $(function (){
      chart04.init();
    })
  </script>

</head>
<body>
    <div class="col-sm-12">
      <div class ="container col-sm-12" id="chart04">
        <h3>chart 04</h3>
        <div id="container"></div>
        <div class="ld-row">
          <label class="ld-label">
            Enable Polling
          </label>
          <input type="checkbox" checked="checked" id="enablePolling"/>
        </div>
        <div class="ld-row">
          <label class="ld-label">
            Polling Time (Seconds)
          </label>
          <input class="ld-time-input" type="number" value="2" id="pollingTime"/>
        </div>
        <div class="ld-row">
          <label class="ld-label">
            CSV URL
          </label>
          <input class="ld-url-input" type="text" id="fetchURL"/>
        </div>
      </div>
    </div>

</body>
</html>
