<%@ page pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!-- /.aside -->

<section id="content">
	<section class="vbox">
		<section class="scrollable padder">
			<ul
				class="bg-primary breadcrumb no-border no-radius b-b b-light pull-in">
				<li><a href="index.html"><i class="fa fa-home"></i> Trang
						chủ</a></li>
				<!-- <li class="active">Workset</li> -->
			</ul>
			<!-- .crousel slide -->
			<section class="panel panel-default">
				<div class="carousel slide auto panel-body" id="c-slide">
					<ol class="carousel-indicators out">
						<li data-target="#c-slide" data-slide-to="0" class="active"></li>
						<li data-target="#c-slide" data-slide-to="1" class=""></li>
						<li data-target="#c-slide" data-slide-to="2" class=""></li>
					</ol>
					<div class="carousel-inner">
						<div class="item active">
							<p class="text-center">
								<em class="h4 text-mute">Công ty cổ phần công nghệ phần mềm
									và nội dung số <a href="http://osp.com.vn/" target="blank">OSP</a>
								</em><br> <small class="text-muted">&copy; 2015</small>
							</p>
						</div>
						<div class="item">
							<p class="text-center">
								<em class="h4 text-mute">Đối tác đáng tin cậy</em><br> <small
									class="text-muted">Be your solid partner</small>
							</p>
						</div>
						<div class="item">
							<p class="text-center">
								<em class="h4 text-mute">UCHI Văn phòng công chứng</em><br>
								<small class="text-muted">Mobile/Tablet/Desktop</small>
							</p>
						</div>
					</div>
					<a class="left carousel-control" href="#c-slide" data-slide="prev">
						<i class="fa fa-angle-left"></i>
					</a> <a class="right carousel-control" href="#c-slide"
						data-slide="next"> <i class="fa fa-angle-right"></i>
					</a>
				</div>
			</section>
			<!-- / .carousel slide -->
			<!-- thanh trái -->
			<div class="col-md-8">
				<div class="col-md-6 portlet">
					<section class="panel b-light portlet-item">
						<header class="panel-heading bg-primary no-border">
							<strong><i class="fa fa-bell "></i> BẢNG THÔNG BÁO</strong>
						</header>
						<div class="list-group">
							<a href="#" class="list-group-item text-ellipsis"> <i
								class="fa fa-angle-right "></i> Thông báo
							</a> <a href="#" class="list-group-item text-ellipsis"> <i
								class="fa fa-angle-right "></i> Thêm mới thông báo
							</a> <a href="#" class="list-group-item text-ellipsis"> <i
								class="fa fa-angle-right "></i> Cập nhật thông tin các...
							</a> <a href="#" class="list-group-item text-ellipsis"> <i
								class="fa fa-angle-right "></i> Giấy mời gửi các VPCC
							</a> <a href="#" class="list-group-item text-ellipsis"> <i
								class="fa fa-angle-right "></i> Giấy mời gửi các VPCC
							</a>
						</div>
					</section>
				</div>
				<div class="col-md-6 portlet">
					<section class="panel b-light portlet-item">
						<header class="panel-heading bg-primary no-border">
							<strong><i class="fa fa-calendar"></i> HỢP ĐỒNG MỚI NHẬP
								TRONG NGÀY</strong>
						</header>
						<div class="list-group">
							<a href="#" class="list-group-item text-ellipsis"><i
								class="fa fa-angle-right "></i> <span class="badge bg-success">1</span>
								Toàn văn phòng </a> <a href="#"
								class="list-group-item text-ellipsis"><i
								class="fa fa-angle-right "></i> <span class="badge bg-success">2</span>
								Công chứng viên 1 </a> <a href="#"
								class="list-group-item text-ellipsis"><i
								class="fa fa-angle-right "></i> <span class="badge bg-light">12</span>
								Công chứng viên 2 </a> <a href="#"
								class="list-group-item text-ellipsis"><i
								class="fa fa-angle-right "></i> <span class="badge bg-light">12</span>
								Chuyên viên soạn thảo 1 </a> <a href="#"
								class="list-group-item text-ellipsis"><i
								class="fa fa-angle-right "></i> <span class="badge bg-light">12</span>
								Chuyên viên soạn thảo 2 </a>
						</div>
					</section>
				</div>
				<div class="col-md-6 portlet">
					<section class="panel b-light portlet-item">
						<header class="panel-heading bg-primary no-border">
							<strong><i class="fa fa-bar-chart-o"></i> BÁO CÁO THỐNG
								KÊ</strong>
						</header>
						<div class="list-group">
							<a href="#" class="list-group-item text-ellipsis"> <i
								class="fa fa-angle-right "></i> Báo cáo theo nhóm hợp đồng
							</a> <a href="#" class="list-group-item text-ellipsis"> <i
								class="fa fa-angle-right "></i> Báo cáo theo công chứng viên
							</a> <a href="#" class="list-group-item text-ellipsis"> <i
								class="fa fa-angle-right "></i> Báo cáo theo chuyên viên soạn
								thảo
							</a> <a href="#" class="list-group-item text-ellipsis"> <i
								class="fa fa-angle-right "></i> Báo cáo theo ngân hàng
							</a> <a href="#" class="list-group-item text-ellipsis"> <i
								class="fa fa-angle-right "></i> Báo cáo hợp đồng lỗi
							</a> <a href="#" class="list-group-item text-ellipsis"> <i
								class="fa fa-angle-right "></i> Báo cáo hợp đồng cần bổ sung
							</a> <a href="#" class="list-group-item text-ellipsis"> <i
								class="fa fa-angle-right "></i> Thống kê tổng hợp
							</a> <a href="#" class="list-group-item text-ellipsis"> <i
								class="fa fa-angle-right "></i> In sổ công chứng
							</a>
						</div>
					</section>
				</div>
				<div class="col-md-6 portlet">
					<section class="panel b-light portlet-item">
						<header class="panel-heading bg-primary no-border">
							<strong><i class="fa fa-file"></i> HỢP ĐỒNG CÔNG CHỨNG</strong>
						</header>
						<div class="list-group">
							<a href="#" class="list-group-item text-ellipsis"><i
								class="fa fa-angle-right "></i> <span class="badge bg-success">1</span>
								Danh sách hợp đồng công chứng </a> <a href="#"
								class="list-group-item text-ellipsis"><i
								class="fa fa-angle-right "></i> <span class="badge bg-success">2</span>
								Thêm mới hợp đồng công chứng </a> <a href="#"
								class="list-group-item text-ellipsis"><i
								class="fa fa-angle-right "></i> <span class="badge bg-light">12</span>
								Hợp đồng mẫu </a>
						</div>
					</section>
				</div>
			</div>
			<!-- kết thúc thanh trái -->

			<!-- thanh phải -->

			<div class="col-md-4 portlet">
				<div class="col-md-12 portlet">
					<section class="panel b-light portlet-item">
						<header class="panel-heading bg-primary no-border">
							<strong><i class="fa fa-wrench"></i> CÔNG CỤ TRUY CẬP
								NHANH</strong>
						</header>
						<div class="list-group">
							<a href="<%=request.getContextPath() %>/search/index.html"
								class="list-group-item text-ellipsis"><i
								class="fa fa-angle-right "></i>
								Tra cứu thông tin ngăn chặn </a> 
							<sec:authorize
									access="hasAnyRole({'ROLE_CREATE_TEMP_CONTRACT'})">
								<a href="<%=request.getContextPath()%>/contract/add.html"
									class="list-group-item text-ellipsis"><i
									class="fa fa-angle-right "></i>
									Nhập mới hợp đồng công chứng </a> 
							</sec:authorize>
							<a href="<%=request.getContextPath()%>/document/index.html"
								class="list-group-item text-ellipsis"><i
								class="fa fa-angle-right "></i>
								Tài liệu nội bộ </a>
						</div>
					</section>
				</div>
				<div class="col-md-12 portlet">
					<section class="panel b-light portlet-item">
						<header class="panel-heading bg-primary no-border">
							<strong><i class="fa fa-files-o"></i> DANH SÁCH HỢP ĐỒNG
								MẪU</strong>
						</header>
						<div class="list-group">
							<div class="form-group">
								<div class="col-sm-10">
									<select name="account" class="form-control m-b">
										<option>option 1</option>
										<option>option 2</option>
										<option>option 3</option>
										<option>option 4</option>
									</select>
								</div>
							</div>
							<a href="#" class="list-group-item text-ellipsis"><i
								class="fa fa-angle-right "></i>
								Meet a friend </a> <a href="#" class="list-group-item text-ellipsis"><i
								class="fa fa-angle-right "></i>
								Meet a friend </a> <a href="#" class="list-group-item text-ellipsis"><i
								class="fa fa-angle-right "></i>
								Meet a friend </a>
						</div>
					</section>
				</div>
			</div>
			<c:if test="${notification != null}">
				<div class="modal fade" id="popup-notification" tabindex="-1"
					role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="alert-info modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModalLabel">
									<i class="fa fa-bullhorn"></i> Thông báo từ sở tư pháp
								</h4>
							</div>
							<div class="modal-body">
								<p><strong>${notification.title}</strong></p>
								<p>${notification.content}</p>
								<div>Được gửi vào lúc <fmt:formatDate value="${notification.updateDatetime}" pattern="HH" /> giờ 
									<fmt:formatDate value="${notification.updateDatetime}" pattern="mm" /> phút ngày <fmt:formatDate value="${notification.updateDatetime}" pattern="dd/MM/yyyy" /> bởi <strong>${notification.updateUsername}</strong></div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-info"
									data-dismiss="modal">Đóng</button>
							</div>
						</div>
					</div>
				</div>
				<a  id="linkpopupnotification"
					data-toggle="modal" data-target="popup-notification"
					href="javascript:void(0)"></a>
				<script type="text/javascript">
					$(document).ready(function() {
						$('#popup-notification').modal('show');
					});
				</script>
			</c:if>
			<!-- kết thúc thanh phải -->
		</section>
		<footer class="footer bg-white b-t b-light">
			<small> Bản quyền thuộc về công ty cổ phần công nghệ phần mềm
				và nội dung số <a href="http://osp.com.vn/" target="blank">OSP</a>&copy;
				2015
			</small>
		</footer>
	</section>
	<a href="#" class="hide nav-off-screen-block"
		data-toggle="class:nav-off-screen" data-target="#nav"></a>
</section>
<!-- App -->
<script src="<%=request.getContextPath() %>/resources/js/jquery.ui.touch-punch.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/jquery-ui-1.10.3.custom.min.js"></script>
