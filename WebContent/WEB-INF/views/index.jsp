<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- HEADER TEMPLATE -->
<jsp:include page="header.jsp" />

<!-- ARTICLE -->

<!-- 메인 화면 전광판  -->
<div class="main--hero--wrap">
	<div class="main--hero">
		<div class="container main--hero--text--wrap">
			<h1 class="hero__title exa">NEW PC방 관리프로그램 출시!!</h1>
			<p class="hero__sub__desc major-fourth">통합회원관리시스템!</p>
			<!--  <a href="tryitforfree" class="btn main--hero--btn"></a> -->
		</div>
	</div>
</div>
<!-- 끝 : 메인화면 전광판 -->	
	
	
<!-- 메인 주요기능 : 카드 섹션? 영역 -->
<div class="main--offer--wrap">
    <div class="main--offer container">
        <div class="offer__title--wrap">
            <h3 class="offer__title">와우! Usable!</h3>
        </div>
    </div>
    <div class="offer__insight">
            <h4 class="offer__insight__title">필요한 UX 정보를 데이터로 쉽게 확인할 수 있습니다.</h4>
            <div class="row">
                <div class="col-xs-12 col-sm-6 col-md-4-12">
                    <a class="offer__function__section scalable"  href="/ux_heatmap">
                        <div class="tool__funtion__icon ux-heatmap"></div>
                        <h6 class="insight__section__title minor">UX Heatmap</h6>
                        <p class="tool__section__desc">사용자의 UX결과를 히트맵 형태로<br/>한눈에 볼 수 있습니다.</p>
                        <span class="goProduct">더 알아보기 &gt;</span>
                    </a>
                </div>
                <div class="col-xs-12 col-sm-6 col-md-4-12 ">
                    <a class="offer__function__section scalable" href="/reporting">
                        <div class="tool__funtion__icon reporting-heatmap"></div>
                        <h6 class="insight__section__title minor">Reporting Heatmap</h6>
                        <p class="tool__section__desc">히트맵 분석 결과와 이슈를 자동으로<br/>요약하고 정리 해드립니다.</p>
                        <span class="goProduct">더 알아보기 &gt;</span>
                    </a>
                </div>
                <div class="col-xs-12 col-sm-6 col-md-4-12 ">
                    <a class="offer__function__section scalable" href="/comparing">
                        <div class="tool__funtion__icon comparing-referrers"></div>
                        <h6 class="insight__section__title minor">Comparing as Referrers</h6>
                        <p class="tool__section__desc">유입 경로에 따라 달라지는 UX를<br/>직접 비교해 볼 수 있습니다.</p>
                        <span class="goProduct">더 알아보기 &gt;</span>
                    </a>
                </div>
                <div class="col-xs-12 col-sm-6 col-md-4-12 ">
                    <a class="offer__function__section scalable" href="/analytics">
                        <div class="tool__funtion__icon user-heatmap"></div>
                        <h6 class="insight__section__title minor">User Analytics</h6>
                        <p class="tool__section__desc">뷰저블을 설치하셨다면 사용자 지표도<br/>실시간으로 볼 수 있습니다.</p>
                        <span class="goProduct">더 알아보기 &gt;</span>
                    </a>
                </div>
                <div class="col-xs-12 col-sm-6 col-md-4-12 ">
                    <a class="offer__function__section scalable" href="/gaze">
                        <div class="tool__funtion__icon gaze-heatmap"></div>
                        <h6 class="insight__section__title minor">Gaze Heatmap</h6>
                        <p class="tool__section__desc">사용자들의 전반적인 사용 흐름을<br/>시각적으로 제공합니다.</p>
                        <span class="goProduct">더 알아보기 &gt;</span>
                    </a>
                </div>
                <div class="col-xs-12 col-sm-6 col-md-4-12 ">
                    <a class="offer__function__section scalable" href="/cta">
                        <div class="tool__funtion__icon segmenting-cta"></div>
                        <h6 class="insight__section__title minor">Segmenting as CTA</h6>
                        <p class="tool__section__desc">특정 버튼이나 클릭 요소를 어떤 유형의</br> 사용자들이 선택했는지 알 수 있습니다.</p>
                        <span class="goProduct">더 알아보기 &gt;</span>
                    </a>
                </div>
            </div>
	</div>
</div>
<!-- 메인 주요기능 : 카드 섹션? 영역 -->

<!-- FOOTER TEMPLATE -->
<jsp:include page="footer.jsp" />