<%@ page isELIgnored="true" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="en" class="app">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>jinzjn - Quản trị website</title>
<meta name="description" content="uchi-vpcc-20" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/app.v2.css" type="text/css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/font.css" type="text/css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/js/datatables/datatables.css" type="text/css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/js/select2/select2.css" type="text/css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/js/select2/theme.css" type="text/scss" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/js/datepicker/datepicker.css" type="text/css" />
<!-- js -->
<script src="<%=request.getContextPath()%>/resources/js/app.v2.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/datepicker/bootstrap-datepicker.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/parsley/parsley.min.js" ></script>
<script src="<%=request.getContextPath()%>/resources/js/parsley/parsley.extend.js" ></script>
<script src="<%=request.getContextPath()%>/resources/js/select2/select2.min.js" ></script>
<script src="<%=request.getContextPath()%>/resources/js/select2/select2.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/datatables/jquery.dataTables.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.spin.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/notify/notify.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/CommonFunction.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/wysiwyg/jquery.hotkeys.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/wysiwyg/bootstrap-wysiwyg.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/wysiwyg/demo.js"></script>
</head>
<link rel="shortcut icon" href="<%=request.getContextPath()%>/resources/images/osp.ico" />
<body>
	<section class="vbox">
		<tiles:insertAttribute name="header" />
		<section>
			<section class="hbox stretch">
				<tiles:insertAttribute name="leftpanel" />
				<tiles:insertAttribute name="page" />
			</section>
		</section>
	</section>
	<%@include file="popup.jsp"%>
</body>
</html>
