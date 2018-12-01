<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href='https://fonts.googleapis.com/css?family=Playball'
	rel='stylesheet' type='text/css'>
<!--slider-->
<script src="js/jquery.min.js"></script>
<script src="js/script.js" type="text/javascript"></script>
<script src="js/superfish.js"></script>
<script type="text/javascript">
	
</script>
  </head>
  
  <body>
   <div class="header-bg">
		<div class="wrap">	
			<div class="h-bg">
				<div class="total">
					<div class="header">
						<div class="box_header_user_menu">
							<ul class="user_menu">
								<li class="act first"><a href="">
										<div class="button-t">
								</a></li>
								<li class=""><a href="">
						</div>
						<div class="clear"></div>
						<div class="header-bot">
							<div class="logo">
								<a href="index.html"><img src="images/logo.png" alt="" /></a>
							</div>
							<div class="search">
								<input type="text" class="textbox" value=""
									onfocus="this.value = '';"
									onblur="if (this.value == '') {this.value = '';}">
								<button class="gray-button">
									<span>Search</span>
								</button>
							</div>
							<div class="clear"></div>
						</div>
					</div>
					<div class="menu">
						<div class="top-nav">
							<ul>
								<li class="active"><a href="index.html">发现</a></li>
								<li><a href="about.html">我的</a></li>
								<li><a href="#">音频上传</a></li>
								<li><a href="#">认证中心</a></li>
								<li><a href="contact.jsp">个人中心</a></li>
							</ul>
							<div class="clear"></div>
						</div>
					</div>
					<div class="banner-top">
						<div class="header-bottom">
							<div class="header_bottom_right_images">
								<div id="slideshow">
									<ul class="slides">
									<c:forEach items="${bookimgs}" var="imgs"></c:forEach>
										<li><a href="details.html"><canvas></canvas>
												<img src="images/banner4.jpg"></a></li>		
										<li><a href="details.html"><canvas></canvas>
												<img src="images/banner2.jpg" ></a></li>
										<li><a href="details.html"><canvas></canvas>
												<img src="images/banner3.jpg" ></a></li>
										<li><a href="details.html"><canvas></canvas>
												<img src="images/banner1.jpg" ></a></li>
									</ul>
									<span class="arrow previous"></span> <span class="arrow next"></span>
								</div>
								<div class="content-wrapper" id="content-wrapper">
								<c:forEach items="${clist }" var="c" varStatus="index" begin="0" end="2">
									 <div class="content-top"id="content-top" >
										<div class="box_wrapper">
									 	<h1>${c.cfname }</h1>
										</div>
										<div class="text" >	
											 <c:forEach items="${c.listbook}" var="b" begin="0" end="2" >
											<div class="grid_1_of_3 images_1_of_3">
												<div class="grid_1">
													<a href="">
													<img id="img1" src=${b.bookimg }></a>
													<div class="grid_desc">
													<p class="title" id="bookname">${b.bookname }</p>
													<p class="title1" id="uname">${b.uid }</p>
													</div>
												</div>
											</div>		
											</c:forEach>    
											</div>
											</div>
										</c:forEach> 	
									</div>	
								</div>
							</div>
							<div class="header-para">
								<div class="categories">
									<div class="list-categories">
									<c:forEach items="${bookAll }"  var="ba" begin="0" end="3" varStatus="count">
										<div class="first-list">
											<div class="div_2">
												<a href="">${count.count }.</a>
												<span style="font-size: 22;color:teal;">${ba.bookname }</span>
											</div>
											<div class="div_img">
												<img src="${ba.bookimg }" alt="Cars" title="Cars"
													width="80" height="50">
											</div>
											<div class="clear"></div>
										</div>
									</c:forEach>
									</div>
									<div class="box">
										<div class="box-heading">
											<h1>
												<img alt="" src="images/arrows.png">
												<a href="#">用户名:&nbsp;</a>
											</h1>
										</div>
										<div class="box-content">
											订阅数&nbsp;<strong>0</strong>
										</div>
									</div>
									<div class="box-title">
										<h1>
											<span class="title-icon"></span><a href="">推荐</a>
										</h1>
									</div>
									<div class="section group example">
										<div class="col_1_of_2 span_1_of_2">
											<img src="images/pic21.jpg" alt="" /> <img
												src="images/pic24.jpg" alt="" /> <img src="images/pic25.jpg"
												alt="" /> <img src="images/pic27.jpg" alt="" />
										</div>
										<div class="col_1_of_2 span_1_of_2">
											<img src="images/pic22.jpg" alt="" /> <img
												src="images/pic23.jpg" alt="" /> <img src="images/pic26.jpg"
												alt="" /> <img src="images/pic28.jpg" alt="" />
										</div>
										<div class="clear"></div>
									</div>
									<div class="clear"></div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
  </body>
</html>
