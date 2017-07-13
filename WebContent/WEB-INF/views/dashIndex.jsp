<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="dashHeader.jsp"/>
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/3.0.0/css/bootstrap-datetimepicker.min.css" rel="stylesheet" /> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.8.2/moment-with-locales.min.js"></script> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/3.0.0/js/bootstrap-datetimepicker.min.js"></script>
<script>
$('#fromDate').datetimepicker({ 
	language : 'ko',// 화면에 출력될 언어를 한국어로 설정한다. 
	pickTime : false, // 사용자로부터 시간 선택을 허용하려면 true를 설정하거나 pickTime 옵션을 생략한다. 
	defalutDate : new Date() // 기본값으로 오늘 날짜를 입력한다. 기본값을 해제하려면 defaultDate 옵션을 생략한다. 
	}); 
$('#toDate').datetimepicker({ language : 'ko', pickTime : false, defalutDate : new Date() });
//DateTimePicker 위젯은 기본적으로 TextBox이므로 아래와 같은 일반적인 방법으로 사용자가 입력한 날짜를 획득할 수 있다. 
var fromDate = $('#fromDate').val(); // '2014.01.01' 
var toDate = $('#toDate').val(); // '2014.12.31' 
// Sugar 라이브러리가 제공하는 Date 확장 메써드를 사용하여 간편하게 날짜 형식을 변경할 수 있다. MySQL에서 바로 쿼리 조회가 가능한 문자열 형식으로 변경해보자. Moment.js를 사용해도 된다. 
var fromDate = Date.create($('#fromDate').val()).format('{yyyy}-{MM}-{dd}'); // '2014-01-01' 
// Sugar 라이브러리를 이용하여 날짜를 변경하는 것도 가능하다. 역시 Moment.js를 사용해도 된다. 
var toDate = Date.create($('#toDate').val()).addDays(1).format('{yyyy}-{MM}-{dd}'); // '2015-01-01'
</script>
	
	<div class="content-title">
	<input id="someDate" type="date"> <input id="someDateTime" type="datetime">

	<input id="fromDate" type="text"> <input id="toDate" type="text">

	</div>
    
                    <div class="inner-content">
                        <div class="row">
                            <div class="col-md-8 col-sm-12 col-xs-12">
                                <div class="portlet z-depth-1" style=" padding-bottom: 0; padding-left: 0; padding-right: 0;">
                                    <div class="portlet-title  no-margin-b" style="  padding-left: 20px; padding-right: 20px">
                                        <div class="caption">
                                            <i class="glyphicon glyphicon-calendar"></i>
                                            <span class="caption-subject text-uppercase"> Stats</span>
                                        </div>
                                        <div class="actions">
                                            <div class="btn-group" data-toggle="buttons">
                                                <label class="btn btn-red">
                                    <input type="radio" name="options" class="toggle" id="option1">Website 2</label>
                                                <label class="btn btn-red active">
                                    <input type="radio" name="options" class="toggle" id="option2">Website 1</label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="portlet-body">
                                        <div class="ui-chart">
                                            <div id="chart_combination" class="chart-placeholder"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4 col-sm-12 col-xs-12">
                                <div class="portlet z-depth-1">
                                    <div class="portlet-title  no-margin-b">
                                        <div class="caption">
                                            <i class="glyphicon glyphicon-calendar"></i>
                                            <span class="caption-subject text-uppercase">Disk Space</span>
                                        </div>
                                    </div>
                                    <div class="portlet-body">
                                        <div class="ui-chart">
                                            <div id="chart_gauge" class="chart-placeholder"></div>
                                        </div>
                                    </div>
                                </div>
                                <div class="portlet z-depth-1">
                                    <!--<div class="portlet-title  no-margin-b" >
                                <div class="caption">
                                    <i class="glyphicon glyphicon-calendar"></i>
                                    <span class="caption-subject text-uppercase">Server Disk</span>
                                </div>
                            </div>-->
                                    <div class="portlet-body">
                                        <br>
                                        <p>The percentage of server disk used. Lorem ipsum dolor sit amet, consectetur adipiscing.
                                            </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="inner-content">
                        <div class="row">
                            <div class="col-md-6 col-sm-12 col-xs-12">
                                <div class="card z-depth-1">
                                    <div class="status-seven">
                                        <div class="card-content">
                                            <div class="item">
                                                <h5>Today's Report</h5>
                                                <div class="heading">
                                                    <h4><span class="lblue">$</span>4,680</h4>
                                                </div>
                                                <div class="bar-chart"><span class="seven-bar-one">13,28,35,16,12,53,18,55,36,22</span></div>
                                                <div class="content">
                                                    <div class="seven-content"><i class="fa fa-circle red"></i>&nbsp; Visitors <span>$89,789,89</span></div>
                                                    <div class="seven-content seven-border"><i class="fa fa-circle green"></i>&nbsp; Profit <span>$48,567,98</span></div>
                                                </div>
                                                <div class="clearfix"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="status-five">
                                <div class="col-md-3 col-sm-6 col-xs-12 col-mob">
                                    <div class="card z-depth-1">
                                        <div class="card-content">
                                            <div class="item">
                                                <h5>Malorum</h5>
                                                <h4>23,345 <i class="fa fa-angle-double-down red"></i></h4>
                                                <div class="five-visitor"><span class="five-pie-three pie-chart">28,87,65,45</span> &nbsp; Visitors
                                                    &nbsp;
                                                    <span class="green">$234</span>
                                                </div>
                                                <div class="five-visitor"><span class="five-pie-one pie-chart">10,48,30,26,12,89</span> &nbsp; Profit
                                                    &nbsp; &nbsp; &nbsp;
                                                    <span class="red">$989</span></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3 col-sm-6 col-xs-12 col-mob">
                                    <div class="card z-depth-1">
                                        <div class="card-content">
                                            <div class="item">
                                                <h5>Bonorum</h5>
                                                <h4>34,897 <i class="fa fa-angle-double-up green"></i></h4>
                                                <div class="five-visitor"><span class="five-pie-four pie-chart">93,28,35,16,12</span> &nbsp; Visitors
                                                    &nbsp;
                                                    <span class="green">$567</span>
                                                </div>
                                                <div class="five-visitor"><span class="five-pie-three pie-chart">28,87,65,45</span> &nbsp; Profit &nbsp;
                                                    &nbsp; &nbsp;
                                                    <span class="red">$545</span></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="ui-223">
                                <div class="col-md-8 col-sm-12 col-xs-12">
                                    <div class="ui-item">
                                        <div class="ui-head">
                                            <h3>Download.com</h3>
                                            <h2 class="lblue">$16,000</h2>
                                        </div>
                                        <div class="ui-chart">
                                            <div id="plot-chart-two" class="chart-placeholder"></div>
                                        </div>
                                        <div class="container-fluid">
                                            <div class="row">
                                                <div class="col-md-3 col-sm-3 col-xs-3 col-pad">
                                                    <div class="ui-content ui-rbor">
                                                        <h4>Visitors</h4>
                                                        <h5 class="red">$2,000 <i class="fa fa-angle-double-up red"></i></h5>
                                                        <div class="progress">
                                                            <div class="progress-bar bg-red" style="width: 60%;"></div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-3 col-sm-3 col-xs-3 col-pad">
                                                    <div class="ui-content">
                                                        <h4>Users</h4>
                                                        <h5 class="green">$1,000 <i class="fa fa-angle-double-down green"></i></h5>
                                                        <div class="progress">
                                                            <div class="progress-bar bg-green" style="width: 50%;"></div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-3 col-sm-3 col-xs-3 col-pad">
                                                    <div class="ui-content ui-bor ui-rbor">
                                                        <h4>Members</h4>
                                                        <h5 class="lblue">$14,000 <i class="fa fa-angle-double-up red"></i></h5>
                                                        <div class="progress">
                                                            <div class="progress-bar bg-lblue" style="width: 30%;"></div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-3 col-sm-3 col-xs-3 col-pad">
                                                    <div class="ui-content ui-bor">
                                                        <h4>Subscribers</h4>
                                                        <h5 class="yellow">$10,000 <i class="fa fa-angle-double-down green"></i></h5>
                                                        <div class="progress">
                                                            <div class="progress-bar bg-yellow" style="width: 70%;"></div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="ui-73">
                                <div class="col-md-4 col-sm-12 col-xs-12">
                                    <div class="ui-item"><img class="img-responsive" alt="Image Here" src="images/picture.jpg">
                                        <div class="ui-details">
                                            <div class="ui-heading clearfix">
                                                <a href="#"><img class="img-responsive" alt="Image Here" src="images/1.jpg"  ></a>
                                                <h2><a href="#">Jennifer Joseph</a> &nbsp;<a href="#"><i class="fa fa-check bg-lblue"></i></a><span>@DoeJohn</span></h2>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-4 col-sm-4 col-xs-4 col-mob">
                                                    <div class="ui-ditem">
                                                        <h4><a href="#">Tweets</a></h4>
                                                        <h3><a href="#">2,000</a></h3>
                                                    </div>
                                                </div>
                                                <div class="col-md-4 col-sm-4 col-xs-4 col-mob">
                                                    <div class="ui-ditem">
                                                        <h4><a href="#">Followers</a></h4>
                                                        <h3><a href="#">1,000</a></h3>
                                                    </div>
                                                </div>
                                                <div class="col-md-4 col-sm-4 col-xs-4 col-mob">
                                                    <div class="ui-ditem">
                                                        <h4><a href="#">Followings</a></h4>
                                                        <h3><a href="#">3,000</a></h3>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
                <div id="styleSelector">
                    <div class="selector-toggle">
                        <a href="javascript:void(0)"></a>
                    </div>
                    <ul>
                        <li>
                            <p class="selector-title">Style Selector</p>
                        </li>
                        <li class="theme-option">
                            <span class="sub-title">Header BG Color Option</span>
                            <div class="theme-color">
                                <a href="#" class="header-bg" data-mt-color-type="header-bg1">&nbsp;</a>
                                <a href="#" class="header-bg" data-mt-color-type="header-bg2">&nbsp;</a>
                                <a href="#" class="header-bg" data-mt-color-type="header-bg3">&nbsp;</a>
                                <a href="#" class="header-bg" data-mt-color-type="header-bg4">&nbsp;</a>
                                <a href="#" class="header-bg" data-mt-color-type="header-bg5">&nbsp;</a>
                                <a href="#" class="header-bg" data-mt-color-type="header-bg6">&nbsp;</a>
                                <a href="#" class="header-bg" data-mt-color-type="header-bg7">&nbsp;</a>
                                <a href="#" class="header-bg" data-mt-color-type="header-bg8">&nbsp;</a>
                                <a href="#" class="header-bg" data-mt-color-type="header-bg9">&nbsp;</a>
                            </div>
                        </li>
                        <li class="theme-option">
                            <span class="sub-title">Left Panel BG Color Option</span>
                            <div class="theme-color">
                                <a href="#" class="lpanel-bg" data-mt-color-type="lpanel-bg1">&nbsp;</a>
                                <a href="#" class="lpanel-bg" data-mt-color-type="lpanel-bg2">&nbsp;</a>
                                <a href="#" class="lpanel-bg" data-mt-color-type="lpanel-bg3">&nbsp;</a>
                                <a href="#" class="lpanel-bg" data-mt-color-type="lpanel-bg4">&nbsp;</a>
                                <a href="#" class="lpanel-bg" data-mt-color-type="lpanel-bg5">&nbsp;</a>
                                <a href="#" class="lpanel-bg" data-mt-color-type="lpanel-bg6">&nbsp;</a>
                                <a href="#" class="lpanel-bg" data-mt-color-type="lpanel-bg7">&nbsp;</a>
                                <a href="#" class="lpanel-bg" data-mt-color-type="lpanel-bg8">&nbsp;</a>
                                <a href="#" class="lpanel-bg" data-mt-color-type="lpanel-bg9">&nbsp;</a>
                            </div>
                        </li>
                        <li class="theme-option">
                            <span class="sub-title">Logo Color BG Option</span>
                            <div class="theme-color">
                                <a href="#" class="logo-bg" data-mt-color-type="logo-bg1">&nbsp;</a>
                                <a href="#" class="logo-bg" data-mt-color-type="logo-bg2">&nbsp;</a>
                                <a href="#" class="logo-bg" data-mt-color-type="logo-bg3">&nbsp;</a>
                                <a href="#" class="logo-bg" data-mt-color-type="logo-bg4">&nbsp;</a>
                                <a href="#" class="logo-bg" data-mt-color-type="logo-bg5">&nbsp;</a>
                                <a href="#" class="logo-bg" data-mt-color-type="logo-bg6">&nbsp;</a>
                                <a href="#" class="logo-bg" data-mt-color-type="logo-bg7">&nbsp;</a>
                                <a href="#" class="logo-bg" data-mt-color-type="logo-bg8">&nbsp;</a>
                                <a href="#" class="logo-bg" data-mt-color-type="logo-bg9">&nbsp;</a>
                            </div>
                        </li>
                        <li class="theme-option">
                            <span class="sub-title">Theme Background BG Option</span>
                            <div class="theme-color">
                                <a href="#" class="data-theme-bg" data-mt-themebg-type="bg1">&nbsp;</a>
                                <a href="#" class="data-theme-bg" data-mt-themebg-type="bg2">&nbsp;</a>
                                <a href="#" class="data-theme-bg" data-mt-themebg-type="bg3">&nbsp;</a>
                                <a href="#" class="data-theme-bg" data-mt-themebg-type="bg4">&nbsp;</a>
                                <a href="#" class="data-theme-bg" data-mt-themebg-type="bg5">&nbsp;</a>
                                <a href="#" class="data-theme-bg" data-mt-themebg-type="bg6">&nbsp;</a>
                                <a href="#" class="data-theme-bg" data-mt-themebg-type="bg7">&nbsp;</a>
                                <a href="#" class="data-theme-bg" data-mt-themebg-type="bg8">&nbsp;</a>
                                <a href="#" class="data-theme-bg" data-mt-themebg-type="bg9">&nbsp;</a>
                            </div>
                        </li>
                        <li class="theme-option">
                            <span class="sub-title">Theme Layout</span>
                            <select id="data-theme-layout" class="form-control minimal input-sm">
                            <option id="data-theme-layout-1" value="wide-layout">Wide Layout</option>
                            <option id="data-theme-layout-2" value="box-layout">Boxed Layout</option> 
                        </select>
                        </li>
                        <li class="theme-option">
                            <span class="sub-title">SideBar Effect</span>
                            <select id="leftpanel-effect" class="form-control minimal input-sm">
                            <option id="lpanel-effect" value="shrink">Default</option>
                            <option id="lpanel-effect-1" value="overlay">Overlay</option>
                            <option id="lpanel-effect-2" value="push">Push</option>
                        </select>
                        </li>
                        <li class="theme-option">
                            <span class="sub-title">Navigation Type</span>
                            <select id="navigation-type" class="form-control minimal input-sm">
                            <option id="navigation-type-1" value="vertical">Vertical</option>
							<option id="navigation-type-2" value="vertical-compact">Vertical Compact</option>
                            <option id="navigation-type-3" value="horizontal">Horizontal</option>
							<option id="navigation-type-4" value="horizontal-compact">Horizontal compact</option>
                        </select>
                        </li>
                        <li class="theme-option">
                            <span class="sub-title">Sidebar Position</span>
                            <select id="sidebar-position" class="form-control minimal input-sm">
                            <option id="sidebar-position-1" value="default">Default</option>
                            <option id="sidebar-position-2" value="fixed">Fixed</option>
                        </select>
                        </li>
                    </ul>
                </div>
                </div>
            </div>    

<jsp:include page="dashFooter.jsp"/>