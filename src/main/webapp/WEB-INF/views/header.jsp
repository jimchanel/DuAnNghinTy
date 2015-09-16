<%@ page isELIgnored="true" pageEncoding="UTF-8" import="java.util.*"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<header class="bg-dark dk header navbar navbar-fixed-top-xs">
	<div class="navbar-header aside-md">
		<a class="btn btn-link visible-xs" data-toggle="class:nav-off-screen"
			data-target="#nav"> <i class="fa fa-bars"></i>
		</a> <a href="<%=request.getContextPath()%>/index.html"
			class="navbar-brand"> <img
			src="<%=request.getContextPath()%>/resources/images/avatar.jpg"
			class="m-r-sm">jinzjn web
		</a> <a class="btn btn-link visible-xs" data-toggle="dropdown"
			data-target=".nav-user"> <i class="fa fa-cog"></i>
		</a>
	</div>
	<div class="navbar-header">
		<p class="text-center text-uc text-xs text-mute font-bold m-sm">
			<small></small><br>
		</p>
	</div>
	<ul class="nav navbar-nav navbar-right hidden-xs nav-user">
		<li class="hidden-xs"><a href="#" class="dropdown-toggle dk"
			data-toggle="dropdown"> <i class="fa fa-bell"></i> <span
				class="badge badge-sm up bg-danger m-l-n-sm count">2</span>
		</a>
			<section class="dropdown-menu aside-xl">
				<section class="panel bg-white">
					<header class="panel-heading b-light bg-light">
						<strong>You have <span class="count">2</span>
							notifications
						</strong>
					</header>
				</section>
			</section></li>
		<li class="dropdown hidden-xs"><a href="#"
			class="dropdown-toggle dker" data-toggle="dropdown"><i
				class="fa fa-fw fa-search"></i></a>
			<section class="dropdown-menu aside-xl animated fadeInUp">
				<section class="panel bg-white">
					<form role="search">
						<div class="form-group wrapper m-b-none">
							<div class="input-group">
								<input type="text" class="form-control" placeholder="Search">
								<span class="input-group-btn">
									<button type="submit" class="btn btn-info btn-icon">
										<i class="fa fa-search"></i>
									</button>
								</span>
							</div>
						</div>
					</form>
				</section>
			</section></li>
		<li class="dropdown"><a href="#" class="dropdown-toggle"
			data-toggle="dropdown"> <span class="thumb-sm avatar pull-left">
					<img
					src="" />
			</span> <%=request.getRemoteUser()%> <b class="caret"></b>
		</a>
			<ul class="dropdown-menu animated fadeInRight">
				<li><a
					href="<%=request.getContextPath()%>/profile.html?username=<%=request.getRemoteUser()%>">Hồ
						sơ</a></li>
				<li class="divider"></li>
				<%-- <li><a
					href="<%=request.getContextPath()%>/j_spring_security_logout">Đăng
						xuất</a></li> --%>
				<li><a href="<c:url value="/j_spring_security_logout" />" >Đăng
						xuất</a></li>
			</ul></li>
	</ul>
</header>
