<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <link rel="stylesheet" href="http://bootstraptema.ru/plugins/2015/bootstrap3/bootstrap.min.css"/>
    <link type="text/css" rel="StyleSheet" href="http://bootstraptema.ru/plugins/2016/shieldui/style.css"/>

    <title>Sensor data</title>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/">Dashboard</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="${pageContext.request.contextPath}/device-catalog">Device list</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Sign up</a>
            </li>
            <li class="nav-item">
                <a class="nav-link " href="#">Login </a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Device search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>


<br><br><br>

<div class="container">
    <div class="row">
        <div class="col-md-8 col-md-offset-2">

            <!-- График -->
            <div id="chart">

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

    <ul class="list-group">
        <c:forEach var="sensor" items="${sensorData}">
            <li class="list-group-item">${sensor}</li>
        </c:forEach>
    </ul>


    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
    <script src="http://bootstraptema.ru/plugins/jquery/jquery-1.11.3.min.js"></script>
    <script src="http://bootstraptema.ru/plugins/2016/shieldui/script.js"></script>
</body>
</html>
