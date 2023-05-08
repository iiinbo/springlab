<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>

</style>

<script>
    let chart03 = {
        init:function (){
            this.getdata1();
            this.getdata2();
            this.getdata3();
        },
        getdata1:function (){
            $.ajax({
                url:'/chart0301',
                success:function (result){
                    chart03.display1(result);
                }
            });
        },
        getdata2:function (){
            $.ajax({
                url:'/chart0302',
                success:function (result){
                    chart03.display2(result);
                }
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
        display1:function (result){
            Highcharts.chart('c1', {
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
                    data: result
                }]
            });
        },
        display2:function (result){Highcharts.chart('c2', {
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
                name: '한국',
                lineColor: 'rgb(180,90,50)',
                color: 'rgb(200,110,50)',
                fillColor: 'rgb(200,110,50)',
                data: result.r01
            }, {
                xAxis: 1,
                lineColor: 'rgb(120,160,180)',
                color: 'rgb(140,180,200)',
                fillColor: 'rgb(140,180,200)',
                name: '일본',
                data:result.r02
            }, {
                xAxis: 2,
                lineColor: 'rgb(200, 190, 140)',
                color: 'rgb(200, 190, 140)',
                fillColor: 'rgb(230, 220, 180)',
                name: '미국',
                data: result.r03
            }]
        });
        },
        display3:function (result){
            Highcharts.chart('c3', {
                chart: {
                    type: 'pyramid3d',
                    options3d: {
                        enabled: true,
                        alpha: 10,
                        depth: 50,
                        viewDistance: 50
                    }
                },
                title: {
                    text: 'Highcharts Pyramid3D Chart'
                },
                plotOptions: {
                    series: {
                        dataLabels: {
                            enabled: true,
                            format: '<b>{point.name}</b> ({point.y:,.0f})',
                            allowOverlap: true,
                            x: 10,
                            y: -5
                        },
                        width: '60%',
                        height: '80%',
                        center: ['50%', '45%']
                    }
                },
                series: [{
                    name: 'Unique users',
                    data: result
                }]
            });
        }
    };


    $(function (){
        chart03.init();
    })

</script>

<div class="col-sm-8 text-left">
    <div class="container">
        <h3>CHART03</h3>
        <div class="row">
            <div class="col-sm-4" id="c1">

            </div>
            <div class="col-sm-4" id="c2">

            </div>
            <div class="col-sm-4" id="c3">

            </div>
        </div>
    </div>
</div>