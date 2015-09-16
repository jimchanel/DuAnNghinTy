<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- /.aside -->
<section id="content">
	<div class="modal fade" id="confirm-filterauto" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="alert-warning modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">
						<i class="fa fa-warning"></i> Xác nhận
					</h4>
				</div>
				<div class="modal-body">Bạn chắc chắn muốn xóa người dùng này
					?</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Hủy</button>
					<a class="btn btn-primary" id="link" href=""><i
						class="fa fa-check"></i> Đồng ý</a>
				</div>
			</div>
		</div>
	</div>
	<section class="vbox">
		<section class="scrollable padder">
			<ul
				class="bg-primary breadcrumb no-border no-radius b-b b-light pull-in">
				<li><a><i class="fa fa-bell-o icon"></i> Quản trị hệ thống</a></li>
				<li>Quản lý người dùng</li>
			</ul>
			<div class="row">
				<div class="col-sm-12">
					<section class="panel panel-default">
						<div class="panel-body">
							<form method="post" id="frmSearch"
								action="quan-ly-nguoi-dung.html">
								<input type="hidden" id="page" name="p"
									value="${param.p != null ? param.p : 1}" /> <input
									type="hidden" id="filter" name="filter" />
								<div class="form-group">
									<div class="form-group col-lg-5">
										<label class="col-sm-5 control-label"
											style="padding-top: 7px;">Từ khóa:</label>
										<div class="col-sm-7">
											<input type="text" id="keyFilter" name="keyFilter"
												class="input-sm form-control" value="${param.keyFilter}"
												placeholder="" />
										</div>
									</div>
									<div class="form-group col-lg-5">
										<div class="col-sm-12">
											<a class="btn btn-s-md btn-primary" href="javascript:void(0)"
												onclick="searchNotify();"> <i class="fa fa-search"></i>
												Tìm kiếm
											</a> <a class="btn btn-s-md btn-danger" href="javascript:void(0)"
												style="margin-left: 10px;" onclick="clearFilter();"> <i
												class="fa fa-trash-o"></i> Xóa dữ liệu
											</a>
										</div>
									</div>
								</div>
							</form>
						</div>
					</section>
				</div>
			</div>
			<div class="row m-b-sm">
				<div class="col-lg-12">
					<div class="pull-right">
						<a href="them-moi-nguoi-dung.html" style="font-weight: bold;"
							class="btn btn-sm btn-s-sm btn-primary"> <i
							class="fa fa-print"></i> Thêm mới
						</a>
					</div>
				</div>
			</div>
			<div class="table-responsive">
				<table class="table table-striped b-t b-light text-sm list-group">
					<thead>
						<tr class="bg-info">
							<th width="5%" style="text-align: center;">STT</th>
							<th width="30%" style="text-align: center;">Tên truy cập</th>
							<th width="20%" style="text-align: center;">Họ tên</th>
							<th width="15%" style="text-align: center;">Email</th>
							<th width="15%" style="text-align: center;">Trạng thái</th>
							<th width="5%" style="text-align: center;"></th>
						</tr>
					</thead>
					<tbody>
						<c:set var="k" value="${start}"></c:set>
						<c:if test="${!empty user}">
							<c:forEach items="${user}" var="user">
								<tr>
									<td style="text-align: center;">${k=k+1}</td>
									<td><a class="link-blue"
										href="sua-nguoi-dung.html?username=${ user.username }">${user.username}</a></td>
									<td>${ user.familyName }</td>
									<td>${ user.email }</td>
									<td><c:choose>
											<c:when test="${user.enabled == 1 }">
												<font style="color: #6B6A6A;">Khóa</font>
											</c:when>
											<c:when test="${user.enabled == 2 }">
												<font style="color: blue;">Đang hoạt động</font>
											</c:when>
											<c:otherwise>
												<font style="color: red;">Không xác định</font>
											</c:otherwise>
										</c:choose></td>
									<td style="text-align: center;">
										<div class="dropdown">
											<a data-toggle="dropdown" class="dropdown-toggle" href="#"><i
												class="fa fa-cog text-default"></i></a>
											<ul class="dropdown-menu text-left pull-right">
												<c:if test="${user.username != 'admin' }">
												<li><a
													href="phan-quyen-nguoi-dung.html?username=${ user.username }"><i
														class="fa fa-edit"></i> Phân quyền</a></li></c:if>
												<li><a
													href="sua-nguoi-dung.html?username=${ user.username }"><i
														class="fa fa-edit"></i> Sửa</a></li>
												<c:if test="${user.username != 'admin' }">
												<li><a href="javascript:void(0)" data-toggle="modal"
													data-toggle="modal" data-target="#confirm-filterauto"
													onclick="linkgetUsername('${ user.username }');"> <i
														class="fa fa-trash-o"></i> Xóa
												</a></li></c:if>
											</ul>
										</div>
									</td>
								</tr>
							</c:forEach>
						</c:if>
					</tbody>
				</table>
			</div>
			<%@include file="../../views/paging.jsp"%>
		</section>
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
<!-- App -->
<script type="text/javascript">
	function setFilterValue() {
		$("#filter").val(
				"{\"keyFilter\":\"" + $("#keyFilter").val() +  "\"}");
	}
	function searchNotify() {
		$("#page").val("1");
		setFilterValue();
		$("#frmSearch").submit();
	}
	function clearFilter() {
		$("#keyFilter").val("");
	}
	function linkgetUsername(username) {
		$("#link").attr("href", "xoa-nguoi-dung.html?username=" + username);
	}
</script>