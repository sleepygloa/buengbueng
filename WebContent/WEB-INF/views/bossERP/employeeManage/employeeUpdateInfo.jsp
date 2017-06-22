<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="employeeUpdateInfoPro.do" method="post">
<!-- 카테고리 -->
	<!-- 알바생아이디 -->
	<div class="row">
		<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
				<div class=" col-xs-12-12 col-sm-12-12 col-md-12-12 form-group">
					<div class="input-group">
					<label>아이디 : ${userDto.id}<br /></label>
						<input type="hidden" name="id" value="${userDto.id}" placeholder="${userDto.id}" />
					</div>
				</div>														
		</div>
	</div>	

	<!-- 비밀번호 -->
	<div class="row">
		<div class=" col-xs-12-12 col-sm-12-12 col-md-12-12">
			<div class=" col-xs-12-12 col-sm-12-12 col-md-12-12 form-group">
				<div class=" col-xs-12-12 col-sm-12-12 col-md-12-12 input-group">
				<label>비밀번호<br /></label>
					<input type="text" name="pw" class="col-xs-12-12 col-sm-12-12 col-md-12-12 form-control" value="${userDto.pw}" placeholder="${userDto.pw}" />
				</div>
			</div>														

			<div class="col-xs-12-12 col-sm-12-12 col-md-12-12  form-group">
				<div class="col-xs-12-12 col-sm-12-12 col-md-12-12  input-group">
				<label>이름<br /></label>
					<input type="text" name="name" class="col-xs-12-12 col-sm-12-12 col-md-12-12 form-control" value="${userDto.name}" placeholder="${userDto.name}" />
				</div>
			</div>														

			<div class="col-xs-12-12 col-sm-12-12 col-md-12-12  form-group">
				<div class="col-xs-12-12 col-sm-12-12 col-md-12-12  input-group">
				<label>생년월일<br /></label>
					<input type="text" class="col-xs-12-12 col-sm-12-12 col-md-12-12 form-control" value="${userDto.birth}" placeholder="${userDto.birth}" />
				</div>
			</div>														

			<div class="col-xs-12-12 col-sm-12-12 col-md-12-12  form-group">
				<div class="col-xs-12-12 col-sm-12-12 col-md-12-12  input-group">
				<label>연락처<br /></label>
					<input type="text" name="phone" class="col-xs-12-12 col-sm-12-12 col-md-12-12 form-control" value="${userDto.phone}" placeholder="${userDto.phone}" />
				</div>
			</div>														

			<div class="col-xs-12-12 col-sm-12-12 col-md-12-12  form-group">
				<div class="col-xs-12-12 col-sm-12-12 col-md-12-12  input-group">
				<label>주소<input type="button" onclick="sample5_execDaumPostcode()" value="주소 검색"><br /></label></label>
					<input class="col-xs-12-12 form-control" type="text"  value="${userDto.address}" placeholder="${userDto.address}"
						id="sample5_address" name="address" placeholder="사업장 주소 입력" onblur="return checkB_address();">
					<br>
					<div id="map" style="width:300px;height:300px;margin-top:10px;display:none"></div>
				</div>
			</div>														

			<div class="col-xs-12-12 col-sm-12-12 col-md-12-12  form-group">
				<div class="col-xs-12-12 col-sm-12-12 col-md-12-12  input-group">
				<label>email<br /></label>
					<input type="text" name="email" class="col-xs-12-12 col-sm-12-12 col-md-12-12 form-control" value="${userDto.email}" placeholder="${userDto.email}" />
				</div>
				</div>														
		</div>
	</div>	
	
	<div class="row">
		<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
			<input class="btn btn-success col-xs-12-12 col-sm-6-12 col-md-6-12" type="submit" value="신청하기" />
			<input class="btn btn-default col-xs-12-12 col-sm-6-12 col-md-6-12" type="button" value="취소하기"
			onclick="window.location='index.do'" />
		</div>					
	</div>	

</form>
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