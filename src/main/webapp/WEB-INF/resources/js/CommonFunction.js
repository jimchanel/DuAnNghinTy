//Viết các hàm javascript sử dụng chung
CommonFunction = {
	// Đi đến một trang cụ thể trong khi xem danh sách
	// p: trang muốn đi đến, curPage: trang hiện tại,maxPage: trang tối đa có
	// thể đi đến
	goToPageNum : function(p, curPage, maxPage, e) {
		setFilterValue();
		if (e != null) {
			if (e.keyCode == 13 && p > 0 && p != parseInt(curPage)
					&& p <= parseInt(maxPage)) {
				$("#page").val(p);
				$("#frmSearch").submit();
			}
		} else {
			$("#page").val(p);
			$("#frmSearch").submit();
		}
	},
	// Lưu danh sách các bản ghi được chọn
	// item: checkbox;
	selectedItems : function(item) {
		var value = item.value;
		if (value != "0") {
			var ids = $("#hdfIds").val();
			if (item.checked) {
				if (ids == ";") {
					$("#hdfIds").val(ids + value + ";");
				} else {
					if (ids.indexOf(";" + value + ";") < 0)
						$("#hdfIds").val(ids + value + ";");
				}
			} else {
				var re = new RegExp(';' + value + ';', 'g');
				$("#hdfIds").val(ids.replace(re, ";"));
			}
		} else {
			var ids = ";";
			if (item.checked) {
				$("table.table > tbody > tr").each(function() {
					var id = $('td:eq(0) input', this).val();
					if (ids == ";")
						ids = ids + id + ";";
					else if (ids.indexOf(";" + id + ";") < 0)
						ids = ids + id + ";";
				});
				$("#hdfIds").val(ids);
			} else {
				$("#hdfIds").val(";");
			}
		}
	},
	// Hiển thị popup thông báo
	// title: tiêu đề thông báo, msg: nội dung thông báo
	// type: error, warning...
	showPopUpMsg : function(title, msg, type) {
		$('#confirm-delete').modal('hide');
		$("#popup-message #myModalLabel").empty();
		if (type.indexOf("error") > -1) {
			$("#popup-message #myModalLabel").append("<i class='fa fa-warning'></i>");
			$("#popup-message .modal-header").addClass("alert-danger");
		} else {
			$("#popup-message .modal-header").removeClass("alert-danger");
		}
		$("#popup-message #myModalLabel").append(title);
		$("#popup-message .modal-body").text(msg);
		$("#popup-message").modal('show');
	},
	// Xóa một hoặc nhiều bản ghi bằng ajax
	// id: id của bản ghi đó
	deleteItems : function(id) {
		if ($("#hdfIds").val() != ";")
			$("#frmDelete").submit();
		else
			CommonFunction.showPopUpMsg(CommonMessenger.ErrorTitle,
					CommonMessenger.MustChoiceBeforeDelete,
					CommonMessenger.errorType);
	},
	deleteFile : function(id, file) {
		var ids = $("#fileIdsDel").val();
		if (ids == ";") {
			$("#fileIdsDel").val(ids + id + ";");
		} else {
			if (ids.indexOf(";" + id + ";") < 0)
				$("#fileIdsDel").val(ids + id + ";");
		}
		localStorage.setItem("fileDel" + id,$(file).html());
		localStorage.setItem("fileDelImage" + id,$(file).css("background-image"));
		$(file).css("background-image","none");
		$(file).html("<p class=\"reject text-orange\" onclick=\"CommonFunction.rejectDeleteFile("+ id +", this.parentNode)\">Hoàn tác</p>");
	}, 
	rejectDeleteFile : function(id, file){
		if(localStorage.getItem("fileDel" + id))
			$(file).html(localStorage.getItem("fileDel" + id));
		var re = new RegExp(';' + id + ';', 'g');
		$("#fileIdsDel").val($("#fileIdsDel").val().replace(re, ";"));
		if(localStorage.getItem("fileDelImage" + id))
			$(file).css("background-image", localStorage.getItem("fileDelImage" + id));
	},
	downloadFile: function(e, id){
		if(e.target.tagName.indexOf("DIV") > -1)
		{
			var a = document.createElement('a');
			a.href='download.html?id=' + id;
			a.target = '_blank';
			document.body.appendChild(a);
			a.click();
		}
	},
	loadContractTemp: function(contractKindId, type)
	{
		$.ajax({
			url:"../contracttemplate/getByContractKind.html",
			type : "get",
            mimeType:"text/html; charset=UTF-8",
			data: { kindId: contractKindId, type: type },
			success: function(data){
				$("#contractTemplate").empty();
				var decoded = decodeURIComponent(data);
				$("#contractTemplate").append(decoded.replace(/\+/g, ' '));
			}
		});
	},
	loadContractTempHtml: function(id, edit)
	{
		$.ajax({
			url:"../contracttemplate/getContractTempHtml.html",
			type : "get",
            mimeType:"text/html; charset=UTF-8",
			data: { id: id},
			success: function(data){
				if("".indexOf(data) > -1){
					$("#divcontract").addClass("hide");
				}
				else
				{
					$("#divcontract").empty();
					var decoded = decodeURIComponent(data);
					$("#divcontract").append(decoded.replace(/\+/g, ' '));
					//$("#divcontract").append("<div id='div' style='position: absolute;top:0;right:0;z-index:9999;border:solid 1px #e4e4e4;max-width:350px;'></div>");					
					$("#divcontract").removeClass("hide");
				}
				if(edit != null)
					$("#divcontract").loadJSON(JSON.parse($("#contractJsonStr").text()));
			}
		});
	},
	getDisp: function(input, count) {
        if (input == null) {
            return null;
        }
        if (input.length > count ) {
            var index = count;
            if((input.substring(0, index).trim().endsWith("<b") && input.substring(index, input.length).trim().startsWith("style"))
        			|| (input.substring(0, index).trim().endsWith("style='background:") && input.substring(index, input.length).trim().startsWith("yellow"))){
            	index++;
        	}
            while (index < input.length && input.charAt(index) != ' ') {
                index++;
                if(index < input.length && input.charAt(index) == ' ') {
                	if((input.substring(0, index).trim().endsWith("<b") && input.substring(index, input.length).trim().startsWith("style"))
                			|| (input.substring(0, index).trim().endsWith("style='background:") && input.substring(index, input.length).trim().startsWith("yellow"))){
                    	index++;
                	}
                }
            }
            var  titleReturn = (index == input.length) ? input.substring(0, index) : input.substring(0, index) + " ... ";
            return titleReturn;
        }
        return input;
	},
	convertContractProperty: function(jsonStr, type)
	{
		var str = "";
		try{
			var obj = JSON.parse(jsonStr);
			if(obj!=null)
			{
				if(type == "01")
				{
					if(obj[PropertyPreventInfo.landAddress.name] != null && obj[PropertyPreventInfo.landAddress.name] != "")
						str += PropertyPreventInfo.landAddress.value + ": " + obj[PropertyPreventInfo.landAddress.name] + "; ";
					if(obj[PropertyPreventInfo.landCertificate.name] != null && obj[PropertyPreventInfo.landCertificate.name] != "")
						str += PropertyPreventInfo.landCertificate.value + ": " + obj[PropertyPreventInfo.landCertificate.name] + "; ";
					if(obj[PropertyPreventInfo.landIssuePlace.name] != null && obj[PropertyPreventInfo.landIssuePlace.name] != "")
						str += PropertyPreventInfo.landIssuePlace.value + ": " + obj[PropertyPreventInfo.landIssuePlace.name] + "; ";
					if(obj[PropertyPreventInfo.landIssueDate.name] != null && obj[PropertyPreventInfo.landIssueDate.name] != "")
						str += PropertyPreventInfo.landIssueDate.value + ": " + obj[PropertyPreventInfo.landIssueDate.name] + "; ";
					if(obj[PropertyPreventInfo.landNumber.name] != null && obj[PropertyPreventInfo.landNumber.name] != "")
						str += PropertyPreventInfo.landNumber.value + ": " + obj[PropertyPreventInfo.landNumber.name] + "; ";
					if(obj[PropertyPreventInfo.landMapNumber.name] != null && obj[PropertyPreventInfo.landMapNumber.name] != "")
						str += PropertyPreventInfo.landMapNumber.value + ": " + obj[PropertyPreventInfo.landMapNumber.name]  + "; ";
					if(obj[PropertyPreventInfo.landArea.name] != null && obj[PropertyPreventInfo.landArea.name] != "")
						str += PropertyPreventInfo.landArea.value + ": " + obj[PropertyPreventInfo.landArea.name]  + "; ";
					if(obj[PropertyPreventInfo.landPrivateArea.name] != null && obj[PropertyPreventInfo.landPrivateArea.name] != "")
						str += PropertyPreventInfo.landPrivateArea.value + ": " + obj[PropertyPreventInfo.landPrivateArea.name]  + "; ";
					if(obj[PropertyPreventInfo.landPublicArea.name] != null && obj[PropertyPreventInfo.landPublicArea.name] != "")
						str += PropertyPreventInfo.landPublicArea.value + ": " + obj[PropertyPreventInfo.landPublicArea.name] + "; ";
					if(obj[PropertyPreventInfo.landUsePurpose.name] != null && obj[PropertyPreventInfo.landUsePurpose.name] != "")
						str += PropertyPreventInfo.landUsePurpose.value + ": " + obj[PropertyPreventInfo.landUsePurpose.name] + "; ";
					if(obj[PropertyPreventInfo.landUsePeriod.name] != null && obj[PropertyPreventInfo.landUsePeriod.name] != "")
						str += PropertyPreventInfo.landUsePeriod.value + ": " + obj[PropertyPreventInfo.landUsePeriod.name] + "; ";
					if(obj[PropertyPreventInfo.landUseOrigin.name] != null && obj[PropertyPreventInfo.landUseOrigin.name] != "")
						str += PropertyPreventInfo.landUseOrigin.value + ": " + obj[PropertyPreventInfo.landUseOrigin.name] + "; ";
					if(obj[PropertyPreventInfo.landAssociateProperty.name] != null && obj[PropertyPreventInfo.landAssociateProperty.name] != "")
						str += PropertyPreventInfo.landAssociateProperty.value + ": " + obj[PropertyPreventInfo.landAssociateProperty.name] + "; ";
					if(obj[PropertyPreventInfo.landAssociatePropertyAddress.name] != null && obj[PropertyPreventInfo.landAssociatePropertyAddress.name] != "")
						str += PropertyPreventInfo.landAssociatePropertyAddress.value + ": " + obj[PropertyPreventInfo.landAssociatePropertyAddress.name] + "; ";
					if(obj[PropertyPreventInfo.landAssociatePropertyInfo.name] != null && obj[PropertyPreventInfo.landAssociatePropertyInfo.name] != "")
						str += PropertyPreventInfo.landAssociatePropertyInfo.value + ": " + obj[PropertyPreventInfo.landAssociatePropertyInfo.name] + "; ";
				}
				else if(type == "02")
				{
					if(obj[PropertyPreventInfo.carLicenseNumber.name] != null && obj[PropertyPreventInfo.carLicenseNumber.name] != "")
						str += PropertyPreventInfo.carLicenseNumber.value + ": " + obj[PropertyPreventInfo.carLicenseNumber.name] + "; ";
					if(obj[PropertyPreventInfo.carRegistNumber.name] != null && obj[PropertyPreventInfo.carRegistNumber.name] != "")
						str += PropertyPreventInfo.carRegistNumber.value + ": " + obj[PropertyPreventInfo.carRegistNumber.name] + "; ";
					if(obj[PropertyPreventInfo.carIssuePlace.name] != null && obj[PropertyPreventInfo.carIssuePlace.name] != "")
						str += PropertyPreventInfo.carIssuePlace.value + ": " + obj[PropertyPreventInfo.carIssuePlace.name] + "; ";
					if(obj[PropertyPreventInfo.carIssueDate.name] != null && obj[PropertyPreventInfo.carIssueDate.name] != "")
						str += PropertyPreventInfo.carIssueDate.value + ": " + obj[PropertyPreventInfo.carIssueDate.name] + "; ";
					if(obj[PropertyPreventInfo.carFrameNumber.name] != null && obj[PropertyPreventInfo.carFrameNumber.name] != "")
						str += PropertyPreventInfo.carFrameNumber.value + ": " + obj[PropertyPreventInfo.carFrameNumber.name] + "; ";
					if(obj[PropertyPreventInfo.carMachineNumber.name] != null && obj[PropertyPreventInfo.carMachineNumber.name] != "")
						str += PropertyPreventInfo.carMachineNumber.value + ": " + obj[PropertyPreventInfo.carMachineNumber.name] + "; ";
				}
				else if(type == "99")
				{
					if(obj[PropertyPreventInfo.propertyInfo.name] != null && obj[PropertyPreventInfo.propertyInfo.name] != "")
						str += obj[PropertyPreventInfo.propertyInfo.name] + "; ";
				}
				if(obj[PropertyPreventInfo.ownerInfo.name] != null && obj[PropertyPreventInfo.ownerInfo.name] != "")
					str += PropertyPreventInfo.ownerInfo.value + ": " + obj[PropertyPreventInfo.ownerInfo.name] + "; ";
				if(obj[PropertyPreventInfo.otherInfo.name] != null && obj[PropertyPreventInfo.otherInfo.name] != "")
					str += PropertyPreventInfo.otherInfo.value + ": " + obj[PropertyPreventInfo.otherInfo.name] + "; ";
			}
		}catch(e){
			
		}
		return str;
	}
}
var PropertyPreventInfo = {
		propertyPreventType: {name: "propertyPreventType", value: "Loại tài sản"},
		// Nhà đất
		landAddress: {name: "nhadat_diachithuadat", value: "Địa chỉ"},
		landCertificate: {name: "nhadat_sogiaychungnhan", value: "Số giấy chứng nhận"},
		landIssuePlace: {name: "nhadat_noicapgiaychungnhan", value: "Nơi cấp"},
		landIssueDate: {name: "nhadat_ngaycapgiaychungnhan", value: "Ngày cấp"},
		landNumber: {name: "nhadat_thuadatso", value: "Thửa đất số"},
		landMapNumber: {name: "nhadat_tobandoso", value: "Tờ bản đồ số"},
		landArea: {name: "nhadat_dientichdat", value: "Diện tích"},
		landPublicArea: {name: "nhadat_hinhthucsudung", value: "Hình thức sử dụng"},
		landUsePurpose: {name: "nhadat_mucdichsudung", value: "Mục đích sử dụng"},
		landUsePeriod : {name: "nhadat_thoihansudung", value: "Thời hạn sử dụng"},
		landUseOrigin: {name: "nhadat_nguongocsudung", value: "Nguồn gốc sử dụng"},
		landAssociateProperty: {name: "nhadat_tentaisanganlien", value: "Tài sản gắn liền với đất"},
		landAssociatePropertyAddress: {name: "nhadat_diachitaisanganlien", value: "Địa chỉ"},
		landAssociatePropertyInfo: {name: "nhadat_thongtintaisanganlien", value: "Thông tin tài sản"},
		// Ô tô - xe máy
		carLicenseNumber: {name: "xe_bienkiemsoat", value: "Biển kiểm soát"},
		carRegistNumber: {name: "xe_sodangky", value: "Số giấy đăng ký"},
		carIssuePlace: {name: "xe_noicapgiaychungnhan", value: "Nơi cấp"},
		carIssueDate: {name: "xe_ngaycapgiaychungnhan", value: "Ngày cấp"},
		carFrameNumber: {name: "xe_sokhung", value: "Số khung"},
		carMachineNumber: {name: "xe_somay", value: "Số máy"},
		// Other
		propertyInfo: {name: "propertyInfo", value: "Thông tin tài sản"},
		// Common
		ownerInfo: {name: "ownerInfo", value: "Chủ sở hữu"},
		otherInfo: {name: "otherInfo", value: "Thông tin khác"}
};
var CommonMessenger = {
	errorType : 'error',
	ErrorTitle : ' Thông báo lỗi',
	Info : 'Thông báo',
	Warning : 'Cảnh báo',
	Success : 'Cập nhật thành công!',
	Delete : 'Bạn có chắc chắn xóa dữ liệu này không?',
	Error : 'Đã có lỗi trong quá trình xử lý!',
	SureToDelete : 'Bạn có chắc chắn muốn xóa dữ liệu này không?',
	NothingToDownload : 'Dữ liệu này không có tập tin đính kèm!',
	ConfirmWrongPassword : 'Nhắc lại mật khẩu mới chưa đúng!',
	OnlyChoiceToView : 'Bạn chỉ được chọn một giá trị để xem chi tiết!',
	OnlyChoiceToEdit : 'Bạn chỉ được chọn một giá trị để thực hiện thay đổi nội dung!',
	OnlyChoiceToAction : 'Bạn chỉ được chọn một giá trị để {0}!',
	MustFillAll : 'Bạn phải nhập đầy đủ thông tin!',
	MustChoiceBeforeAction : 'Bạn phải chọn dữ liệu cần {0} trước!',
	MustChoiceBeforeAction2 : 'Bạn phải chọn {0} cần {1} trước!',
	MustChoiceBeforeView : 'Bạn phải chọn dữ liệu cần xem trước!',
	MustChoiceBeforePhanCong : 'Bạn phải chọn hồ sơ để phân công rà soát!',
	MustChoiceBeforeEdit : 'Bạn phải chọn dữ liệu cần sửa trước!',
	MustChoiceBeforeTrinh : 'Bạn phải chọn hồ sơ trước khi trình lãnh đạo!',
	MustChoiceBeforeDelete : 'Bạn phải chọn dữ liệu cần xóa trước!',
	MustChoiceBeforePrint : 'Bạn phải chọn dữ liệu cần in trước!',
	MustChoiceBeforeSendMail : 'Bạn phải chọn dữ liệu cần phải gửi email trước!',
	MustChoiceBeforeDownload : 'Bạn phải chọn tài liệu đính kèm cần tải xuống trước!',
	MustChoiceDeXuatBeforeAttach : 'Bạn phải chọn đề xuất cần đính kèm tài liệu trước!',
	MustChoiceDeTaiDuAnBeforeAttach : 'Bạn phải chọn đề tài - dự án cần đính kèm tài liệu trước!',
	MustChoiceBeforeAddAttach : 'Bạn phải chọn {0} cần đính kèm tài liệu trước!',
	MustChoiceBeforeEditAttach : 'Bạn phải chọn tài liệu {0} cần sửa thông tin trước!',
	MustChoiceBeforeDeleteAttach : 'Bạn phải chọn tài liệu {0} cần xóa trước!',
	MustChoiceBeforeUpdate : 'Bạn phải chọn dữ liệu cần cập nhật thông tin trước!',
	MustChoiceBeforeSecurity : 'Bạn phải chọn ứng dụng cần phân quyền trước!',
	MustChoiceBeforeAddUserOrGroup : 'Bạn phải chọn nhóm quyền cần thêm nhóm/người dùng trước!',
	MustChoiceBeforeDanhGia : 'Bạn phải chọn tài liệu {0} cần đánh giá trước!',
	OnlyChoiceOneRecode : 'Bạn chỉ được chọn một bản ghi ',

	successNotice : function(title, msg) {
		window.Ext.net.Notification.show({
			// iconCls: 'icon-information',
			// icon: windown.Ext.Net.Icon.Information,
			icon : window.Ext.Msg.INFO,
			hideDelay : 3000,
			autoHide : true,
			closeVisible : true,
			html : msg,
			title : CommonMessenger.Info,
			alignToCfg : {
				offset : [ 0, 20 ],
				position : 'tr-tr'
			},
			showFx : {
				args : [ 't', {} ],
				fxName : 'slideIn'
			},
			hideFx : {
				args : [ 't', {} ],
				fxName : 'ghost'
			}
		});
	},
	successHandler : function(form, action) {
		if (action.result && action.result.msg) {
		}
		CommonFunction.CloseWindow();
		// successNotice('Thông báo', 'Lưu dữ liệu thành công');
	},

	failureHandler : function(form, action) {
		var msg = '';

		if (action.failureType == 'client'
				|| (action.result && action.result.errors && action.result.errors.length > 0)) {
			msg = "Không nhập đủ thông tin";
		} else if (action.result && action.result.msg) {
			msg = action.result.msg;
		} else if (action.response) {
			msg = action.response.responseText;
		}
		CommonMessenger.showErrorMessage('', msg);
	},

	showInfoMessage : function(title, msg) {
		window.Ext.Msg.show({
			title : CommonMessenger.Info,
			msg : msg,
			buttons : window.Ext.Msg.OK,
			icon : window.Ext.Msg.INFO
		});
	},

	showErrorMessage : function(title, msg) {
		window.Ext.Msg.show({
			title : CommonMessenger.ErrorTitle,
			msg : msg,
			buttons : window.Ext.Msg.OK,
			icon : window.Ext.Msg.ERROR
		});
	},

	showWarningMessage : function(title, msg) {
		window.Ext.Msg.show({
			title : CommonMessenger.Warning,
			msg : msg,
			buttons : window.Ext.Msg.OK,
			icon : window.Ext.Msg.WARNING
		});
	},

	showConfirmMessage : function(title, msg, func) {
		Ext.Msg.show({
			title : CommonMessenger.Info,
			msg : msg,
			buttons : Ext.MessageBox.YESNO,
			icon : Ext.MessageBox.QUESTION,
			fn : func,
			width : 350
		});
	},

	showWindowMessage : function(title, msg, func) {
		window.Ext.Msg.show({
			title : title,
			msg : msg,
			buttons : window.Ext.Msg.OK,
			icon : window.Ext.Msg.INFO
		});
	}
};
