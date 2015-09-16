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
				<li><a href=""><i class="fa fa-book"></i> Phân quyền người dùng</a></li>
			</ul>
			<div class="row">
				<div class="col-sm-12">
					<section class="panel panel-default">
						<div class="panel-body">
							<form:form class="bs-example form-horizontal" id="frmAdd"
								data-validate="parsley" modelAttribute="userRole"
								action="phan-quyen-nguoi-dung.html" method="post">
								<h5 class="page-header m-t-xs" style="font-weight: 600;">
									<i class="fa fa-foursquare"></i> Phân quyền người dùng
								</h5>
								<form:hidden path="username" id="username"/>
								<div class="form-group m-b-xs">
									<span class="col-lg-2 control-span m-l" style="padding-top: 5px">Họ tên:
									</span>
									<div class="col-lg-4">
									<label class="form-control input-sm currency" hidden="true">${userRole.familyName }</label>
									</div>
								</div>
								<div class="form-group m-b-xs">
									<span class="col-lg-2 control-span m-l">Danh sách quyền:
									</span>
									<div class="col-lg-3">
										<c:choose>
											<c:when test="${ROLE_CUSTOMER == 1 }">
												<input type="checkbox" class="role" name="ROLE_CUSTOMER" checked="checked" value="1" /> Tư vấn khách hàng
											</c:when>
											<c:otherwise>
												<input type="checkbox" class="role" name="ROLE_CUSTOMER" value="1" /> Tư vấn khách hàng
											</c:otherwise>
										</c:choose>
									</div>
								</div>
								<div class="form-group m-b-xs">
									<span class="col-lg-2 control-span m-l">
									</span>
									<div class="col-lg-3">
										<c:choose>
											<c:when test="${ROLE_NEWS == 1 }">
												<input type="checkbox" class="role" name="ROLE_NEWS" checked="checked" value="1" /> Quản lý tin tức
											</c:when>
											<c:otherwise>
												<input type="checkbox" class="role" name="ROLE_NEWS" value="1" /> Quản lý tin tức
											</c:otherwise>
										</c:choose>
									</div>
								</div>
								<div class="form-group m-b-xs">
									<span class="col-lg-2 control-span m-l">
									</span>
									<div class="col-lg-3">
										<c:choose>
											<c:when test="${ROLE_USER == 1 }">
												<input type="checkbox" class="role" name="ROLE_USER" checked="checked" value="1" /> Quản lý tài khoản
											</c:when>
											<c:otherwise>
												<input type="checkbox" class="role" name="ROLE_USER" value="1" /> Quản lý tài khoản
											</c:otherwise>
										</c:choose>
									</div>
								</div>
								<div class="form-group m-b-xs">
									<span class="col-lg-2 control-span m-l">
									</span>
									<div class="col-lg-3">
										<c:choose>
											<c:when test="${ROLE_CONTACT == 1 }">
												<input type="checkbox" class="role" name="ROLE_CONTACT" checked="checked" value="1" /> Liên hệ
											</c:when>
											<c:otherwise>
												<input type="checkbox" class="role" name="ROLE_CONTACT" value="1" /> Liên hệ
											</c:otherwise>
										</c:choose>
									</div>
								</div>
								<div class="line line-dashed line-lg pull-in"></div>
								<div class="form-group m-b-xs">
									<span class="col-lg-2 control-span m-l"></span>
									<div class="col-lg-6">
										<input type="submit" id="btnSave" style="display: none;"
											onclick="return searchNotify();" /> <a
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
	function setFilterValue() {
		$("#filter").val(
				"{\"keyFilter\":\"" + $("#keyFilter").val() +  "\"}");
	}
	function searchNotify() {
		$("#page").val("1");
		setFilterValue();
		$("#frmSearch").submit();
	}
	$(document).ready(function() {

	});
	function back() {
		if (confirm("Bạn có chắc chắn muốn hủy bỏ?")) {
			window.location = "quan-ly-nguoi-dung.html";
		}
	}
</script>