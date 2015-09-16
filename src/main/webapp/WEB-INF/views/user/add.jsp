<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor"%>
<%@ taglib uri="http://cksource.com/ckfinder" prefix="ckfinder"%>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/ckeditor/ckeditor.js"></script>
<!-- /.aside -->
<style>
.input-file-row-1:after {
	content: ".";
	display: block;
	clear: both;
	visibility: hidden;
	line-height: 0;
	height: 0;
}

.input-file-row-1 {
	display: inline-block;
	margin-top: 25px;
	position: relative;
}

#preview_image {
	display: none;
	width: 90px;
	height: 90px;
	margin: 2px 0px 0px 5px;
	border-radius: 10px;
}

.upload-file-container {
	position: relative;
	width: 100px;
	height: 137px;
	overflow: hidden;
	background: url(http://i.imgur.com/AeUEdJb.png) top center no-repeat;
	float: left;
	margin-left: 23px;
}

.upload-file-container-text {
	font-family: Arial, sans-serif;
	font-size: 12px;
	color: #719d2b;
	line-height: 17px;
	text-align: center;
	display: block;
	position: absolute;
	left: 0;
	bottom: 0;
	width: 100px;
	height: 35px;
}

.upload-file-container-text>span {
	border-bottom: 1px solid #719d2b;
	cursor: pointer;
}

.one_opacity_0 {
	opacity: 0;
	height: 0;
	width: 1px;
	float: left;
}
</style>
<section id="content">
	<section class="vbox">
		<section class="scrollable padder">
			<ul
				class="breadcrumb no-border no-radius b-b b-light pull-in bg-primary">
				<li><a
					href="<%=request.getContextPath()%>/quan-ly-nguoi-dung.html"><i
						class="fa fa-book"></i> Quản lý người dùng</a></li>
				<li><a href=""><i class="fa fa-book"></i> Thêm mới người dùng</a></li>
			</ul>
			<div class="row">
				<div class="col-sm-12">
					<section class="panel panel-default">
						<div class="panel-body">
							<form:form class="bs-example form-horizontal" id="frmAdd"
								data-validate="parsley" modelAttribute="user"
								action="them-moi-nguoi-dung.html" method="post">
								<h5 class="page-header m-t-xs" style="font-weight: 600;">
									<i class="fa fa-foursquare"></i> Thêm mới người dùng
								</h5>
								<div class="form-group m-b-xs">
									<span class="col-lg-2 control-span m-l">Họ tên <font
										color="red">*</font> :
									</span>
									<div class="col-lg-3">
										<form:input type="text" path="familyName"
											class="form-control input-sm" placeholder="Họ tên"
											data-required="true" data-trigger="change" autofocus="autofocus"
											data-required-message="<font color=green>Họ tên</font> không được bỏ trống"
											data-maxlength="100"
											data-maxlength-message="Độ dài không được vượt quá 100 ký tự" 
											/>
									</div>
								</div>
								<div class="form-group m-b-xs">
									<span class="col-lg-2 control-span m-l">Tài khoản đăng
										nhập<font color="red">*</font> :
									</span>
									<div class="col-lg-3">
										<form:input type="text" id="txtAccount" path="username"
											class="form-control input-sm parsley-validated ${userMSG != null ? 'parsley-error' : ''}"
											placeholder="Tài khoản đăng nhập" 
											data-required="true" data-trigger="change"
											data-required-message="<font color=green>Tài khoản đăng nhập</font> không được bỏ trống"
											data-maxlength="20"
											data-maxlength-message="Độ dài không được vượt quá 20 ký tự"
											data-regexp="^[A-Za-z0-9_-]+$"
											data-regexp-message="Tài khoản không hợp lệ (Tài khoản chỉ được gồm các kí tự A - z, số, dấu gạch dưới và dấu gạch ngang.)"
											/>
										<ul id="userError" class="parsley-error-list"
											style="display: ${userMSG != null ? 'block' : 'none'};">
											<li class="required" style="display: list-item;">${userMSG}</li>
										</ul>
									</div>
								</div>
								<div class="form-group m-b-xs">
									<span class="col-lg-2 control-span m-l">Mật khẩu <font
										color="red">*</font> :
									</span>
									<div class="col-lg-4">
										<form:input type="password" path="password" id="password"
											class="form-control input-sm"
											placeholder="Mật khẩu" 
											data-required="true" data-trigger="change"
											data-required-message="<font color=green>Mật khẩu</font> không được bỏ trống"
											data-maxlength="100"
											data-maxlength-message="Độ dài không được vượt quá 100 ký tự"
											/>
									</div>
								</div>
								<div class="form-group m-b-xs">
									<span class="col-lg-2 control-span m-l">Nhập lại mật
										khẩu <font color="red">*</font> :
									</span>
									<div class="col-lg-4">
										<input type="password" name="confirmpassword"
											class="form-control input-sm"
											placeholder="Nhập lại mật khẩu"
											data-required="true" data-trigger="change"
											data-required-message="<font color=green>Xác nhận mật khẩu</font> không được bỏ trống"
											data-maxlength="100"
											data-maxlength-message="Độ dài không được vượt quá 100 ký tự"
											data-equalto="#password"
											data-equalto-message="Xác nhận mật khẩu không chính xác"
											/>
									</div>
								</div>
								<div class="form-group m-b-xs">
									<span class="col-lg-2 control-span m-l">Trạng thái: </span>
									<div class="col-lg-3">
										<form:select class="form-control" path="enabled">
												<form:option value="1">Khóa
													</form:option>
												<form:option value="2">Đang
													hoạt động</form:option>
										</form:select>
									</div>
								</div>
								<div class="form-group m-b-xs">
									<span class="col-lg-2 control-span m-l">Email: </span>
									<div class="col-lg-3">
										<form:input type="text" id="email" class="form-control input-sm" path="email" />
									</div>
								</div>
								<%-- 
								<div class="form-group m-b-xs">
									<span class="col-lg-2 control-span m-l">Chuyên mục gốc: </span>
									<div class="col-lg-3  input-group m-b"
										style="margin-bottom: 0px;">
										<form:select path="parent" class="form-control input-sm">
											<form:option value="0">--
													Không --</form:option>
											<c:if test="${!empty categorys}">
												<c:forEach var="cate" items="${categorys}">
													<form:option value="${cate.cateId}">${cate.cateName}</form:option>
												</c:forEach>
											</c:if>
										</form:select>

									</div>
								</div>
								<div class="form-group m-b-xs">
									<span class="col-lg-2 control-span m-l"
										style="padding-top: 5px;">Trạng thái: </span>
									<div class="col-lg-3  input-group m-b">
										<form:select path="active" class="form-control input-sm">
												<form:option value="0">--
													Chọn --</form:option>
												<form:option value="1">Khóa
													</form:option>
												<form:option value="2">Đang
													hoạt động</form:option>
											</form:select>
									</div>
								</div> --%>
								<div class="line line-dashed line-lg pull-in"></div>
								<div class="form-group m-b-xs">
									<span class="col-lg-2 control-span m-l"></span>
									<div class="col-lg-6">
										<input type="submit" id="btnSave" style="display: none;"
											onclick="return addAuction();" /> <a
											class="btn btn-sm btn-primary" id="linkSave"
											onclick="$('#btnSave').click();" style="width: 90px;"><i
											class="fa fa-save"></i> Lưu</a> <a href="javascript: back();"
											class="btn btn-sm btn-danger" style="width: 90px;">Hủy bỏ</a>
									</div>
								</div>
							</form:form>
						</div>
					</section>
				</div>
			</div>
		</section>
	</section>
</section>
<script
	src="<%=request.getContextPath()%>/resources/js/bootstrap-filestyle.min.js"></script>
<script>
	function addAuction() {
		if ($("#frmAdd").parsley().isValid())
			$("#linkSave").removeAttr("onclick");
		return true;
	}
	$(document).ready(function() {

	});
	function back() {
		if (confirm("Bạn có chắc chắn muốn hủy bỏ?")) {
			window.location = "quan-ly-nguoi-dung.html";
		}
	}
</script>