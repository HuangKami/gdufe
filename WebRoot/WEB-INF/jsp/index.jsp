<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>广财突突突</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<link href="css/index.css" rel='stylesheet' type='text/css' />
</head>

<body>
	<div class="services" id="services">
		<div style="float: right;">${user.name}</div>
		<div class="container">
			<div class="agile-heading heading">
				<h3 style="color:#fc636b">广财突突突</h3>
			</div>
			<div class="wthree-services-grids">
				<div class="col-sm-3 wthree-services">
					<div class="wthree-services-grid">
						<div class="wthree-services-info">
							<i class="fa fa-trophy" aria-hidden="true"></i>
							<h4>个人信息</h4>
							<div class="w3ls-border"> </div>
						</div>
						<div class="wthree-services-captn">
							<h4>个人信息</h4>
							<p>点击查询个人详细信息，突突突</p>
						</div>
					</div>
				</div>
				<div class="col-sm-3 wthree-services">
					<div class="wthree-services-grid">
						<div class="wthree-services-info">
							<i class="fa fa-graduation-cap" aria-hidden="true"></i>
							<h4>校园卡</h4>
							<div class="w3ls-border"> </div>
						</div>
						<div class="wthree-services-captn">
							<h4>校园卡</h4>
							<p>点击查询饭卡余额状态以及当天的交易记录，突突突</p>
						</div>
					</div>
				</div>
				<div class="col-sm-3 wthree-services">
					<div class="wthree-services-grid">
						<div class="wthree-services-info">
							<i class="fa fa-black-tie" aria-hidden="true"></i>
							<h4>成绩查询</h4>
							<div class="w3ls-border"> </div>
						</div>
						<div class="wthree-services-captn">
							<h4>成绩查询</h4>
							<p>点击查询期末成绩，四六级成绩等信息，突突突</p>
						</div>
					</div>
				</div>
				<div class="col-sm-3 wthree-services">
					<div class="wthree-services-grid">
						<div class="wthree-services-info">
							<i class="fa fa-thumbs-o-up" aria-hidden="true"></i>
							<h4>图书馆服务</h4>
							<div class="w3ls-border"> </div>
						</div>
						<div class="wthree-services-captn">
							<h4>图书馆服务</h4>
							<p>点击查询图书借阅历史记录，当前记录，续借，搜索图书信息，突突突</p>
						</div>
					</div>
				</div>
				<div class="clearfix"> </div>
			</div>
			<div class="wthree-services-grids services-grids1">
				<div class="col-sm-3 wthree-services">
					<div class="wthree-services-grid">
						<div class="wthree-services-info">
							<i class="fa fa-calendar-minus-o" aria-hidden="true"></i>
							<h4>素拓信息</h4>
							<div class="w3ls-border"> </div>
						</div>
						<div class="wthree-services-captn">
							<h4>素拓信息</h4>
							<p>点击查询素拓信息，突突突</p>
						</div>
					</div>
				</div>
				<div class="col-sm-3 wthree-services">
					<div class="wthree-services-grid">
						<div class="wthree-services-info">
							<i class="fa fa-sun-o" aria-hidden="true"></i>
							<h4>敬请期待</h4>
							<div class="w3ls-border"> </div>
						</div>
						<div class="wthree-services-captn">
							<h4>敬请期待</h4>
							<p>敬请期待</p>
						</div>
					</div>
				</div>
				<div class="col-sm-3 wthree-services">
					<div class="wthree-services-grid">
						<div class="wthree-services-info">
							<i class="fa fa-percent" aria-hidden="true"></i>
							<h4>敬请期待</h4>
							<div class="w3ls-border"> </div>
						</div>
						<div class="wthree-services-captn">
							<h4>敬请期待</h4>
							<p>敬请期待</p>
						</div>
					</div>
				</div>
				<div class="col-sm-3 wthree-services">
					<div class="wthree-services-grid">
						<div class="wthree-services-info">
							<i class="fa fa-university" aria-hidden="true"></i>
							<h4>敬请期待</h4>
							<div class="w3ls-border"> </div>
						</div>
						<div class="wthree-services-captn">
							<h4>敬请期待</h4>
							<p>敬请期待</p>
						</div>
					</div>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>
</body>
</html>
