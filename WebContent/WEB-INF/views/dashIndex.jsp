<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="dashHeader.jsp"/>
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/3.0.0/css/bootstrap-datetimepicker.min.css" rel="stylesheet" /> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.8.2/moment-with-locales.min.js"></script> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/3.0.0/js/bootstrap-datetimepicker.min.js"></script>
	
	<div class="content-title"">
	<form action="dashIndex.do" method="post">
	<input name="somedate" type="date" value="${somedate}">
	<input type="submit" value="확인">
	</form>
	</div>
    
                    <div class="inner-content">
                        <div class="row">
                            <div class="col-md-6 col-sm-12 col-xs-12">
                                <div class="card z-depth-1">
                                    <div class="status-seven">
                                        <div class="card-content">
                                            <div class="item">
                                                <h5>해당일 수익</h5>
                                                <div class="heading">
                                                    <h4>${todayCash}원</h4>
                                                </div>
                                                <div class="bar-chart"><span class="seven-bar-one">13,28,35,16,12,53,18,55,36,22</span></div>
                                                <div class="content">
                                                    <div class="seven-content seven-border"><i class="fa fa-circle green"></i>&nbsp; 총 수익 <span>${allCash}원</span></div>
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
                                                <h5>가맹점 수</h5>
                                                <h4>${allFranchise} <i class="fa fa-angle-double-up green"></i></h4>
                                                <div class="five-visitor"><span class="five-pie-four pie-chart">93,28,35,16,12</span> &nbsp; 신규
                                                    &nbsp;
                                                    <span class="green">${todayFranchise}</span>
                                                </div>
                                                <div class="five-visitor"><span class="five-pie-three pie-chart">28,87,65,45</span> &nbsp; 신청 &nbsp;
                                                    &nbsp; &nbsp;
                                                    <span class="red">${agreeFranchise}</span></div>
                                            </div>
                                        </div>
                                    </div>
                            </div>
                            <div class="status-five">
                                <div class="col-md-3 col-sm-6 col-xs-12 col-mob">
                            	<div class="card z-depth-1">
                                        <div class="card-content">
                                            <div class="item">
                                                <h5>회원 수</h5>
                                                <h4>${allUser} <i class="fa fa-angle-double-up green"></i></h4>
                                                <div class="five-visitor"><span class="five-pie-four pie-chart">93,28,35,16,12</span> &nbsp; 사장
                                                    &nbsp;
                                                    <span class="green">${Boss}</span>
                                                </div>
                                                <div class="five-visitor"><span class="five-pie-three pie-chart">28,87,65,45</span> &nbsp; 사용자 &nbsp;
                                                    &nbsp; &nbsp;
                                                    <span class="red">${User}</span></div>
                                            </div>
                                        </div>
                                    </div>
                            </div>
                        </div>
                    </div>
                    <div class="inner-content">
                        <div class="row">
	                        <div class="col-md-3 col-sm-12 col-xs-12">
							<div class="card z-depth-1">
                                    <div class="status-seven">
                                        <div class="card-content">
                                            <div class="item">
                                                <h5>그 외</h5>
                                                <div class="heading">
                                                   	<div></div>
                                                   	<div></div>
                                                </div>
                                                <div class="content">
                                                    <div class="seven-content seven-border"><i class="fa fa-circle green"></i>&nbsp; 아르바이트 ID 신청<span>${empAgree}</span></div>
                                                    <div class="seven-content seven-border"><i class="fa fa-circle green"></i>&nbsp; 아르바이트 ID 삭제 <span>${empDelete}</span></div>
                                                </div>
                                                <div class="clearfix">
                                               &nbsp; &nbsp; </br>
                                               &nbsp; &nbsp;                                                 	
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
							</div>
                            <div class="col-md-9 col-sm-12 col-xs-12">
							<div id="myCarousel" class="carousel slide" data-ride="carousel">
							  <!-- Indicators -->
							  <ol class="carousel-indicators">
							    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
							    <li data-target="#myCarousel" data-slide-to="1"></li>
							    <li data-target="#myCarousel" data-slide-to="2"></li>
							  </ol>
							
							  <!-- Wrapper for slides -->
							  <div class="carousel-inner">
							    <div class="item active">
							      <center><img src="/buengbueng/picture/test1.jpg" width="100%" alt="Los Angeles"></center>
							    </div>
							
							    <div class="item">
							      <center><img src="/buengbueng/picture/test2.jpg" width="100%" alt="Chicago"></center>
							    </div>
							
							    <div class="item">
							      <cetner><img src="/buengbueng/picture/test3.jpg" width="100%" alt="New York"></center>
							    </div>
							  </div>
							
							  <!-- Left and right controls -->
							  <a class="left carousel-control" href="#myCarousel" data-slide="prev">
							    <span class="glyphicon glyphicon-chevron-left"></span>
							    <span class="sr-only">Previous</span>
							  </a>
							  <a class="right carousel-control" href="#myCarousel" data-slide="next">
							    <span class="glyphicon glyphicon-chevron-right"></span>
							    <span class="sr-only">Next</span>
							  </a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

<jsp:include page="dashFooter.jsp"/>