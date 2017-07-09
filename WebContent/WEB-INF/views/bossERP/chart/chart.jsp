<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
    $(function () {
        $('.min-chart#chart-sales').easyPieChart({
            barColor: "#4caf50",
            onStep: function (from, to, percent) {
                $(this.el).find('.percent').text(Math.round(percent));
            }
        });
    });
    </script>
</head>
<body>
	<span class="min-chart" id="chart-sales" data-percent="56"><span class="percent"></span></span>
<h5><span class="label green">Sales <i class="fa fa-arrow-circle-up"></i></span></h5>
<div class="text-center">
    <span class="min-chart" id="chart-sales" data-percent="56"><span class="percent"></span></span>
    <h5><span class="label green">Sales <i class="fa fa-arrow-circle-up"></i></span></h5>
</div>
</body>
</html>