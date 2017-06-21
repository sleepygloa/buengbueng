<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
[class*=col]{margin-bottom:10px}
</style>
<!-- HEADER TEMPLATE -->
<jsp:include page="../header.jsp" />

	<!-- 페이지 제목 -->
	<div class="margin_bottom50">
		<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
			<h3>가맹점 수정 Form</h3>
		</div>
	</div>
	
	<div class="margin_bottom50">	
		<div class="col-xs-12-12">
					
			<form  action="franchiseeInfoUpdatePro.do" method="post">
				<!-- 가맹점 이름 -->
				<div class="row">
					<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
						<label>가맹점 이름<br /></label>
						<div class="form-group">
							<input class="col-xs-12-12 col-sm-12-12 col-md-12-12 form-control" 
							type="text" name="b_name" value="${dto.b_name}" placeholder="아이디를 입력하세요" />
						</div>
					</div>
				</div>
				<!-- 가맹점 사업자번호 -->
				<div class="row">
					<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
						<label>사업자 번호<br /></label>
						<div class="form-group">
							<input class="col-xs-12-12 col-sm-12-12 col-md-12-12 form-control" 
							type="text" name="b_number" value="${dto.b_number}" placeholder="- 포함하여 입력해주세요" maxLength="12"/>
						</div>
					</div>
				</div>	
				<!-- 가맹점 주소 -->
				<div class="row">
					<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
							<label>사업장 주소 <input type="button" onclick="sample5_execDaumPostcode()" value="주소 검색"><br /></label>
							<div class="form-group">
								<input class="col-xs-12-12 form-control" type="text"
									id="sample5_address" name="b_address" placeholder="사업장 주소 입력" onblur="return checkB_address();">
								<br>
								<div id="map" style="width:300px;height:300px;margin-top:10px;display:none"></div>
							</div>
					</div>
				</div>
				<!-- 가맹점 사업장 전화번호 -->
				<div class="row">
					<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
						<label>가맹점 전화번호<br /></label>
						<div class="form-group">
							<input class="col-xs-12-12 col-sm-12-12 col-md-12-12 form-control" 
							type="text" name="b_tel" value="${dto.b_tel}" placeholder="가맹점 대표전화번호를 입력해주세요"/>
						</div>
					</div>
				</div>	
				<!-- 가맹점 규모 -->
				<div class="row">
					<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
						<label>가맹점 규모<br /></label>
						<div class="form-group">
							<input class="col-xs-12-12 col-sm-12-12 col-md-12-12 form-control" 
							type="text" name="b_size" value="${dto.b_size}" placeholder="가맹점 평수를 입력해주세요"/>
						</div>
					</div>
				</div>	
				<!-- PC수 -->
				<div class="row">
					<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
						<label>가맹점 PC 수<br /></label>
						<div class="form-group">
							<input class="col-xs-12-12 col-sm-12-12 col-md-12-12 form-control" 
							type="text" name="b_pccount" value="${dto.b_pccount}" placeholder="사장님 PC포함 대수를 입력해주세요"/>
						</div>
					</div>
				</div>	
				<!-- 사장님 IP -->
				<div class="row">
					<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
						<label>가맹점 IP<br /></label>
						<div class="form-group">
							<input class="col-xs-12-12 col-sm-12-12 col-md-12-12 form-control" 
							type="text" name="b_ip" value="${dto.b_ip}" placeholder="공인 IP 주소를 입력해주세요"/>
						</div>
					</div>
				</div>	
				<!-- 라이센스KEY -->
				<div class="row">
					<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
						<label>가맹점 라이센스<br /></label>
						<div class="form-group">
						${dto.b_key}
						<input type="hidden" name="b_key" value="b_key" />
						</div>
					</div>
				</div>																		
				<!-- 버튼 -->
				<div class="row">
					<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
						<input class="btn btn-success col-xs-12-12 col-sm-6-12 col-md-6-12" type="submit" value="신청하기" />
						<input class="btn btn-default col-xs-12-12 col-sm-6-12 col-md-6-12" type="button" value="취소하기"
						onclick="window.location='franchiseeList.do'" />
					</div>					
				</div>	
			</form>	
			<div class="row">
				<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
					<button class="btn btn-default col-xs-12-12 col-sm-12-12 col-md-12-12" 
					onclick="window.location='index.do'" >메인페이지로</button>
				</div>
			</div>
		</div>
	</div>
	
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="//apis.daum.net/maps/maps3.js?apikey=발급받은 API KEY를 사용하세요&libraries=services"></script>
<script>
    var mapContainer = document.getElementById('map'), // 지도를 표시할 div
        mapOption = {
            center: new daum.maps.LatLng(37.537187, 127.005476), // 지도의 중심좌표
            level: 5 // 지도의 확대 레벨
        };

    //지도를 미리 생성
    var map = new daum.maps.Map(mapContainer, mapOption);
    //주소-좌표 변환 객체를 생성
    var geocoder = new daum.maps.services.Geocoder();
    //마커를 미리 생성
    var marker = new daum.maps.Marker({
        position: new daum.maps.LatLng(37.537187, 127.005476),
        map: map
    });

    function sample5_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullAddr = data.address; // 최종 주소 변수
                var extraAddr = ''; // 조합형 주소 변수

                // 기본 주소가 도로명 타입일때 조합한다.
                if(data.addressType === 'R'){
                    //법정동명이 있을 경우 추가한다.
                    if(data.bname !== ''){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있을 경우 추가한다.
                    if(data.buildingName !== ''){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                }

                // 주소 정보를 해당 필드에 넣는다.
                document.getElementById("sample5_address").value = fullAddr;
                // 주소로 좌표를 검색
                geocoder.addr2coord(data.address, function(status, result) {
                    // 정상적으로 검색이 완료됐으면
                    if (status === daum.maps.services.Status.OK) {
                        // 해당 주소에 대한 좌표를 받아서
                        var coords = new daum.maps.LatLng(result.addr[0].lat, result.addr[0].lng);
                        // 지도를 보여준다.
                        mapContainer.style.display = "block";
                        map.relayout();
                        // 지도 중심을 변경한다.
                        map.setCenter(coords);
                        // 마커를 결과값으로 받은 위치로 옮긴다.
                        marker.setPosition(coords)
                    }
                });
            }
        }).open();
    }
</script>



