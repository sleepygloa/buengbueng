<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<style>
			#container {
				width:100%;
				margin:0 auto;
				text-align:center;
				float:left;
			}
			.tab {
				list-style: none;
				margin: 0;
				padding: 0;
				overflow: hidden;
			}
			/* Float the list items side by side */
			.tab li {
				float: left;
			}
			/* Style the links inside the list items */
			.tab li a {
				display: inline-block;
				color: #000;
				text-align: center;
				text-decoration: none;
				padding: 14px 16px;
				font-size: 17px;
				transition:0.3s;
			}
			/* Style the tab content */
			.tabcontent {
				display: none;
				background-color:green;
				padding: 6px 12px;
				color:#fff;
			}
			ul.tab li.current{
				border-bottom:1.5px #555 solid;
				color: #222;
			}
			.tabcontent.current {
				display: block;
			}
			.tabTitlebox{border:1px #dcdcdc solid; text-align: center; margin-bottom:40px;}
			.tabTitlebox_in{margin:0 auto; width:425px;}
			.banner{width:100%; float:left; background: #999; height:290px; float:left; margin-bottom:30px;}
		</style>
		<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
	</head>
	
	<jsp:include page="../header.jsp" />  
	
	<body>
		<div class="banner">12</div>
	
		<div id="container">
			<div class="tabTitlebox">
				<div class="tabTitlebox_in">
					<ul class="tab">
						<li class="current" data-tab="tab1"><a href="#">가맹문의</a></li>
						<li data-tab="tab2"><a href="#">자주 묻는 질문</a></li>
						<li data-tab="tab3"><a href="#">1:1문의</a></li>
						<li data-tab="tab4"><a href="#">공지사항</a></li>
					</ul>
				</div>
			</div>
	
			<div id="tab1" class="tabcontent current">
				<h3>About</h3>
				<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
			</div>
	
			<div id="tab2" class="tabcontent">
				<h3>Portfolio</h3>
				<p>Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of "de Finibus Bonorum et Malorum" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, "Lorem ipsum dolor sit amet..", comes from a line in section 1.10.32.</p>
			</div>
	
			<div id="tab3" class="tabcontent">
				<h3>Contact</h3>
				<p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).</p>
			</div>
	
			<div id="tab4" class="tabcontent">
				<h3>Travel</h3>
				<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
			</div>
		</div>
	
		<script>
			$(function() {
				$('ul.tab li').click(function() {
					var activeTab = $(this).attr('data-tab');
					$('ul.tab li').removeClass('current');
					$('.tabcontent').removeClass('current');
					$(this).addClass('current');
					$('#' + activeTab).addClass('current');
				})
			});
		</script>
	</body>
</html>