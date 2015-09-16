<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
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
				<li><a href="index.html"><i class="fa fa-credit-card"></i>Thông
						tin cá nhân</a></li>
			</ul>
			<div class="row">
				<div class="col-sm-12">
					<section class="panel panel-default">
						<div class="panel-body">
							<form class="bs-example form-horizontal" data-validate="parsley"
								action="profileEdit.html" method="post" name="userEditForm"
								enctype="multipart/form-data" onsubmit="return edit();">
								<input type="hidden" name="username"
									value="${userInfo.username}"> <input type="hidden"
									name=enabled value="${userInfo.enabled}"> <input
									type="hidden" name="hiddenFlg" value="${userInfo.hiddenFlg}">
								<h5 class="page-header m-t-xs" style="font-weight: 600;">
									<i class="fa fa-foursquare"></i> Thông tin cá nhân
								</h5>
								<c:if test="${!empty userInfo}">
									<div class="form-group m-b-xs">
										<span class="col-lg-2 control-span m-l">Họ đệm : </span>
										<div class="col-lg-3">
											<input type="text" class="form-control input-sm"
												name="familyName" data-required="true"
												data-required-message="Họ đệm không được bỏ trống"
												placeholder="Họ đệm" value="${userInfo.familyName}">
										</div>
										<span class="col-lg-1 control-span">Tên : </span>
										<div class="col-lg-3">
											<input type="text" class="form-control input-sm"
												name="firstName" data-required="true"
												data-required-message="Tên không được được bỏ trống"
												placeholder="Tên" value="${userInfo.firstName}">
										</div>
									</div>
									<div class="form-group m-b-xs">
										<span class="col-lg-2 control-span m-l">Tài khoản đăng
											nhập: </span>
										<div class="col-lg-3">
											<input type="text" class="form-control input-sm"
												disabled="disabled" value="${userInfo.username}">
										</div>
									</div>
									<div class="form-group m-b-xs">
										<span class="col-lg-2 control-span m-l">Ngày sinh:</span>
										<div class="col-lg-4">
											<input type="text" class="form-control input-sm"
												name="birthday" placeholder="Ngày sinh"
												value="${userInfo.birthday}">
										</div>
										<span class="col-lg-1 control-span m-l">Giới tính:</span>
										<div class="col-lg-2">
											<select name="sex" class="form-control input-sm">
												<option value="true"
													<c:if test="${userInfo.sex == true }">selected</c:if>>
													Nam</option>
												<option value="false"
													<c:if test="${userInfo.sex == false }">selected</c:if>>
													Nữ</option>
											</select>
										</div>
									</div>
									<div class="form-group m-b-xs">
										<span class="col-lg-2 control-span m-l">Địa chỉ:</span>
										<div class="col-lg-7">
											<input type="text" class="form-control input-sm"
												name="address" placeholder="Địa chỉ"
												value="${userInfo.address}">
										</div>
									</div>
									<div class="form-group m-b-xs">
										<span class="col-lg-2 control-span m-l">Email:</span>
										<div class="col-lg-4">
											<input type="text" name="email" class="form-control input-sm"
												placeholder="Email" value="${userInfo.email}">
										</div>
									</div>
									<div class="form-group m-b-xs">
										<span class="col-lg-2 control-span m-l">Điện thoại cố
											định:</span>
										<div class="col-lg-4">
											<input type="text" class="form-control input-sm"
												name="telephone" placeholder="Điện thoại cố định"
												value="${userInfo.telephone}">
										</div>
									</div>
									<div class="form-group m-b-xs">
										<span class="col-lg-2 control-span m-l">Điện thoại di
											động:</span>
										<div class="col-lg-4">
											<input type="text" class="form-control input-sm"
												name="mobile" placeholder="Điện thoại di động"
												value="${userInfo.mobile}">
										</div>
									</div>
									<div class="form-group m-b-xs">
										<span class="col-lg-2 control-span m-l">Chức vụ:</span>
										<div class="col-lg-4">
											<input type="text" class="form-control input-sm"
												disabled="disabled" value="${userInfo.role.name}" />
										</div>
									</div>
									<div class="form-group m-b-xs">
										<span class="col-lg-2 control-span m-l">Mật khẩu : </span>
										<div class="col-lg-4">
											<input type="password" id="password"
												value="${userInfo.password}" name="password"
												data-required="true"
												data-required-message="Mật khẩu không được bỏ trống"
												class="form-control input-sm" name="password"
												placeholder="Mật khẩu">
										</div>
									</div>
									<div class="form-group m-b-xs">
										<span class="col-lg-2 control-span m-l">Nhập lại mật
											khẩu <font color="red">*</font> :
										</span>
										<div class="col-lg-4">
											<input type="password" id="passwordComfirm"
												value="${userInfo.password}" class="form-control input-sm"
												name="confirmpassword" placeholder="Nhập lại mật khẩu"
												data-required="true"
												data-required-message="Nhập lại mật khẩu không được bỏ trống"
												data-equalto="#password"
												data-equalto-message="Xác nhận mật khẩu không chính xác">
										</div>
									</div>
									<div class="form-group m-b-xs">
										<fieldset>
											<div class="input-file-row-1">
												<div class="upload-file-container">
													<img id="preview_image" src="#" alt="" />
													<div class="upload-file-container-text">
														<div class='one_opacity_0'>
															<input type="file" name="profileImgage" id="patient_pic" />
														</div>
														<span> Thay đổi ảnh đại diện </span>
													</div>
												</div>
											</div>
										</fieldset>
									</div>
								</c:if>

								<div class="line line-dashed line-lg pull-in"></div>
								<div class="form-group m-b-xs">
									<span class="col-lg-2 control-span m-l-xl"></span>
									<div class="col-lg-6">
										<input type="submit" class="btn btn-sm btn-primary"
											style="width: 90px;" value="Lưu"> <a
											href="javascript: back();" class="btn btn-sm btn-danger"
											style="width: 90px;">Hủy bỏ</a>
									</div>
								</div>
							</form>
						</div>
					</section>
				</div>
			</div>
		</section>
		<footer class="footer bg-white b-t b-light">
			<p style="color: #000; font-weight: 600; padding-left: 0px;"
				class="col-lg-8">Văn phòng công chứng OSP - Địa chỉ: Số 3, đường
				Nam Kỳ Khởi Nghĩa, P.Tân An, Q.Ninh Kiều, TP Cần Thơ</p>
			<p class="pull-right">
				&copy; 2015 Bản quyền thuộc về <a href="#" style="color: #3B87DE;"><img
					src="/uchi/resources/images/osp_logo_grey.gif"
					style="padding-bottom: 3px;"> osp.com.vn</a>
			</p>
		</footer>
	</section>
</section>

<script>
	$('#slRole').select2();

	function back() {
		if (confirm("Bạn có chắc chắn muốn hủy bỏ?")) {
			window.location = "index.html";
		}
	}

	function checkAll(selector_fire, alt_name) {
		//$('input[alt=' + alt_name + ']').attr('checked', $('#' + selector_fire).is(':checked'));
		$('input[alt=' + alt_name + ']').prop('checked',
				$('#' + selector_fire).is(':checked'));
	}

	$('#slRole').select2();
	$(document)
			.ready(
					function() {
						function readURL(input, target) {
							var size = input.files[0];
							if (size.size > 2000000) {
								alert("Kích thước ảnh : "
										+ size.size
										+ " đã vượt quá dung lượng cho phép \r\nKích thước ảnh tối đa 2Mb");
							} else {
								if (input.files && input.files[0]) {
									var reader = new FileReader();
									var image_target = $(target);
									reader.onload = function(e) {
										image_target.attr('src',
												e.target.result).show();
									};
									reader.readAsDataURL(input.files[0]);
								}
							}

						}

						$("body").on("change", "#patient_pic", function() {
							readURL(this, "#preview_image")
						});
					});
</script>