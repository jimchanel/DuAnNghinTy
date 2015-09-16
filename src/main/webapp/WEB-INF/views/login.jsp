<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>UCHI Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- CSS -->
<link rel="shortcut icon" href="<%=request.getContextPath()%>/resources/images/osp.ico" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/login/css/reset.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/login/css/supersized.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/app.v2.css"
	type="text/css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/font.css"
	type="text/css" />
<style>
.errorss {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}
</style>
</head>
<body onload='document.loginForm.j_username.focus();'>
	<div class="page-container">
		<div class="container aside-xxl">
			<label class="navbar-brand block" style="color: white;">UCHI  -  News </label>
			<section class="panel panel-default bg-white m-t-lg">
				<header class="panel-heading text-center">
					<strong>Đăng nhập hệ thống</strong>
				</header>
				<form name='loginForm'
					action="<c:url value='/j_spring_security_check' />" method="POST"
					class="panel-body wrapper-lg">
					<div class="form-group">
						<c:if test="${not empty error}">
							<div class="errorss">${error}</div>
						</c:if>
						<label class="control-label">Tài khoản </label> <input type="text"
							id="j_username" name="j_username" placeholder="Tên truy cập"
							class="form-control input-lg">
					</div>
					<div class="form-group">
						<label class="control-label">Mật khẩu</label> <input
							type="password" id="j_password" name="j_password"
							placeholder="Mật khẩu" class="form-control input-lg">
					</div>
					<div class="checkbox">
						<label> <input type="checkbox" value="yes"
							name="_spring_security_remember_me"> ghi nhớ tài khoản
						</label>
					</div>
					<a href="#" class="pull-right m-t-xs"><small>Quên mật
							khẩu?</small></a>
					<button type="submit" class="btn btn-primary">Đăng nhập</button>
					<p class="text-muted text-center">
						<small>Bạn chưa có tài khoản?</small>
					</p>
					<a href="#" class="btn btn-default btn-block">Tạo mới tài khoản</a>
				</form>
			</section>
		</div>
	</div>
	<!-- footer -->
	<footer id="footer">
		<div class="text-center padder">
			<small> Bản quyền thuộc về công ty cổ phần công nghệ phần mềm<br>
				và nội dung số <a href="http://osp.com.vn/" target="blank">OSP</a><br>&copy;
				2015
			</small>
		</div>
	</footer>
	<!-- / footer -->
	<!-- Javascript -->
	<script src="<%=request.getContextPath()%>/resources/login/js/jquery-1.8.2.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/login/js/supersized.3.2.7.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/login/js/supersized-init.js"></script>
	<script src="<%=request.getContextPath()%>/resources/login/js/scripts.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/app.v2.js"></script>
</body>

</html>

