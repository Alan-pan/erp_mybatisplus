<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<title>首页</title>
<style type="text/css">
.side-nav-item {
	display: block;
	padding: 10px 15px 10px 15px;
	background-color: #FFFFFF;
	cursor: pointer;
	box-shadow: 0 1px 1px rgba(0, 0, 0, .05);
	-webkit-box-shadow: 0 1px 1px rgba(0, 0, 0, .05);
}

.item-title {
	background-color: #F5F5F5;
	border-top-left-radius: 3px;
	border-top-right-radius: 3px;
	border-bottom: 1px solid #DDDDDD;
}

.panel-heading {
	margin-top: 5px;
	padding: 0;
	border-radius: 3px;
	border: 1px solid transparent;
	border-color: #DDDDDD;
}

.item-body {
	padding: 10px 15px 5px 15px;
	border-bottom: 1px solid #DDDDDD;
}

.item-second {
	margin-top: 5px;
	cursor: pointer;
}

.item-second a {
	display: block;
	height: 100%;
	width: 100%;
}

.at {
	color: red;
}
</style>
</head>
<body>
	<!-- 顶部的左侧信息 -->
	<nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0">
	<a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#">erp</a> <!-- 右上角登录信息 -->
	<ul class="navbar-nav px-3">
		 <li style="color:white">${e}<a href="#">退出</a></li>
	</ul>
	</nav>

	<!-- 左侧栏与右侧栏 -->
	<div class="container-fluid">
		<div class="row">
			<!-- 左侧栏 -->
			<div class="col-md-2 side-nav">
				<div class="panel-group" id="accordion">
					<div class="panel-heading panel">
						<a class="side-nav-item item-title"> 首页 </a>
						<div class="item-body collapse" id='index'></div>
					</div>
					<div class="panel-heading panel">

						<div id="accordion">
							<div class="card">
							<c:forEach items="${menus}" var="menu">
									<c:if test="${menu.pid==0}">
										<div class="card-header">
											<a class="card-link" data-toggle="collapse" href="#${menu.mid}">
												${menu.name}
											</a>
										</div>
									</c:if>
									<c:forEach items="${menus}" var="smenu">
										<c:if test="${smenu.pid==menu.mid}">
										<div id="${smenu.pid}" class="collapse" data-parent="#accordion" href="javascript:(0)" onclick="getContent(this);" data-url="${pageContext.request.contextPath}/${smenu.url}">
											<div class="card-body">
												${smenu.name}
											</div>
										</div>
										</c:if>
									</c:forEach>
								</c:forEach>
							</div>
						</div>

					</div>
				</div>
			</div>
			<!-- 右侧栏 -->
			<main role="main" class="col-md-10 ml-sm-auto col-lg-10 pt-3 px-4">
			<!-- 点击所有的左侧菜单，对应的页面都在iframe中显示 -->
			<iframe src="test.html"
				frameborder="0" scrolling="no" id="external-frame" width="100%" height="1680px;"></iframe>
			</main>
		</div>
	</div>

	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/popper.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		/*设置iframe高度*/
		function setIframeHeight(iframe) {
			if (iframe) {
				var iframeWin = iframe.contentWindow
						|| iframe.contentDocument.parentWindow;
				if (iframeWin.document.body) {
					iframe.height = iframeWin.document.body.scrollHeight
							|| iframeWin.document.documentElement.scrollHeight;
				}
			}
		};

		window.onload = function() {
			setIframeHeight(document.getElementById('external-frame'));
		};

		/**点击左侧菜单*/
		function getContent(e) {
			$(e).attr("height","680px");
			//setIframeHeight(document.getElementById('external-frame'));
			var url=$(e).data("url");
			//获取iframe对象
			$("#external-frame").attr("src",url);
			//setIframeHeight(e);
		}
	</script>
</body>
</html>