<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="http://bootstraptema.ru/plugins/2015/bootstrap3/bootstrap.min.css" />
<link type="text/css" rel="StyleSheet" href="http://bootstraptema.ru/plugins/2016/shieldui/style.css" />
<script src="http://bootstraptema.ru/plugins/jquery/jquery-1.11.3.min.js"></script>
<script src="http://bootstraptema.ru/plugins/2016/shieldui/script.js"></script>

<br><br><br>

<div class="container">
    <div class="row">
        <div class="col-md-8 col-md-offset-2">

            <!-- График --><div id="chart">

            <script>
                $(function () {
                    $("#chart").shieldChart({
                        theme: "light",
                        exportOptions: {
                            image: false,
                            print: false
                        },
                        axisX: {
                            categoricalValues: ['2005', '2006', '2007', '2008', '2009', '2010', '2011', '2012', '2013', '2014', '2015', '2016']
                        },
                        axisY: {
                            axisTickText: {
                                format: "{text:c}"
                            },
                            title: {
                                text: "Цена (EUR в kWh)"
                            }
                        },
                        tooltipSettings: {
                            chartBound: true
                        },
                        seriesSettings: {
                            line: {
                                enablePointSelection: true,
                                pointMark: {
                                    activeSettings: {
                                        pointSelectedState: {
                                            drawWidth: 4,
                                            drawRadius: 4
                                        }
                                    }
                                }
                            }
                        },
                        primaryHeader: {
                            text: "Цены на электроэнергию"
                        },
                        dataSeries: [{
                            seriesType: 'line',
                            collectionAlias: 'Домохозяйства',
                            data: [0.164, 0.173, 0.184, 0.167, 0.177, 0.189, 0.180, 0.183, 0.188, 0.160, 0.176, 0.178]
                        }, {
                            seriesType: 'line',
                            collectionAlias: 'Промышленность',
                            data: [0.103, 0.105, 0.112, 0.111, 0.102, 0.099, 0.110, 0.113, 0.117, 0.119, 0.123, 0.117]
                        }]
                    });
                });
            </script><!-- /.График -->

        </div><!-- /.col-md-8 col-md-offset-2 -->
        </div><!-- /.row -->
    </div><!-- /.container -->