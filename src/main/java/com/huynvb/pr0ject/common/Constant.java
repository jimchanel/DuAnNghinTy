/**
 * 
 */
package com.huynvb.pr0ject.common;

import java.math.BigInteger;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * @author SONY
 *
 */
public class Constant {

	/** Filter Kind */
	public enum FilterKind {
		/** Left */
		LEFT
		/** Middle */
		, MIDDLE
		/** Right */
		, RIGHT
		/** Full */
		, FULL;

		public Integer getValue() {
			switch (this) {
			case LEFT:
				return 1;
			case MIDDLE:
				return 2;
			case RIGHT:
				return 3;
			case FULL:
				return 4;
			default:
				return null;
			}
		}

		public static FilterKind changeValue(Integer value) {
			if (value == null) {
				return null;
			}
			switch (value) {
			case 1:
				return LEFT;
			case 2:
				return MIDDLE;
			case 3:
				return RIGHT;
			case 4:
				return FULL;
			default:
				return null;
			}
		}
	};
	
	public static final int ROLE_ADMIN = 1;
	public static final int ROLE_NOTARY = 2;
	public static final int ROLE_DRAFTER = 3;
	public static final int ROLE_VANTHU_THUQUY = 4;
	public static final int ROLE_OTHER = 99;
	
	public static final String CH_HISTORY_ACTION_ADD = "�?ăng  ký";
	public static final String CH_HISTORY_ACTION_EDIT = "Chỉnh sửa";
	public static final String CH_HISTORY_ACTION_DELETE = "Xóa";
	public static final String CH_HISTORY_ACTION_CANCEL = "Hủy hợp đồng";

	/** Row page */
	public static final String LIMIT_CONFIG_PROPERTIES = "rowPerPage";
	public static final String MAX_PAGE_LINE_CONFIG_PROPERTIES = "maxPageLine";

	public static final String AUTHORITY_ADMIN = "ROLE_ADMIN";
	public static final String AUTHORITY_NOTIFY = "ROLE_NOTIFY";
	public static final String AUTHORITY_CREATE_PREVENT = "ROLE_CREATE_PREVENT";
	public static final String AUTHORITY_DEL_PREVENT = "ROLE_DEL_PREVENT";
	public static final String AUTHORITY_CREATE_CONTRACT = "ROLE_CREATE_CONTRACT";
	public static final String AUTHORITY_DEL_CONTRACT = "ROLE_DEL_CONTRACT";
	public static final String AUTHORITY_CREATE_TEMP_CONTRACT = "ROLE_CREATE_TEMP_CONTRACT";
	public static final String AUTHORITY_DEL_TEMP_CONTRACT = "ROLE_DEL_TEMP_CONTRACT";
	public static final String AUTHORITY_REPORT_CONTRACT = "ROLE_REPORT_CONTRACT";
	public static final String AUTHORITY_REPORT_BANK = "ROLE_REPORT_BANK";
	public static final String AUTHORITY_VANTHU = "ROLE_VANTHU";
	public static final String AUTHORITY_RELATION = "ROLE_RELATION";
	
	// Json filed contract history
	public static final String ACTION_ADD = "01";
	public static final String ACTION_EDIT = "02";
	public static final String ACTION_DELETE = "03";
	public static final String ACTION_CANCEL = "04";
	public static final String ACTION_MORTAGE = "05";
	public static final String ACTION_TAOPHULUC = "06";

	// Dang ky
	public static final String JSON_CH_CONTRACT_NAME = "contract_name";
	public static final String JSON_CH_BENA_NOIDUNG = "bena_noidung";
	public static final String JSON_CH_BENB_NOIDUNG = "benb_noidung";
	public static final String JSON_CH_BENC_NOIDUNG = "benc_noidung";
	public static final String JSON_CH_PROPERTY_INFO = "property_info";
	public static final String JSON_CH_RECEIVED_DATE = "received_date";
	public static final String JSON_CH_NOTARY_DATE = "notary_date";
	public static final String JSON_CH_NOTARY_PERSON = "notary_person";

	// Chinh sua
	public static final String JSON_CH_TEN_HD_TRUOC = "contract_name_truoc";
	public static final String JSON_CH_TEN_HD_SAU = "contract_name_sau";
	public static final String JSON_CH_CONTRACT_NUMBER_TRUOC = "contract_number_truoc";
	public static final String JSON_CH_CONTRACT_NUMBER_SAU = "contract_number_sau";
	public static final String JSON_CH_RECEIVED_DATE_TRUOC = "received_date_truoc";
	public static final String JSON_CH_RECEIVED_DATE_SAU = "received_date_sau";
	public static final String JSON_CH_NOTARY_DATE_TRUOC = "notary_date_truoc";
	public static final String JSON_CH_NOTARY_DATE_SAU = "notary_date_sau";
	public static final String JSON_CH_DRAFTER_USERNAME_TRUOC = "drafter_username_truoc";
	public static final String JSON_CH_DRAFTER_USERNAME_SAU = "drafter_username_sau";
	public static final String JSON_CH_NOTARY_USERNAME_TRUOC = "notary_username_truoc";
	public static final String JSON_CH_NOTARY_USERNAME_SAU = "notary_username_sau";
	public static final String JSON_CH_BENA_TRUOC = "bena_truoc";
	public static final String JSON_CH_BENA_SAU = "bena_sau";
	public static final String JSON_CH_BENB_TRUOC = "benb_truoc";
	public static final String JSON_CH_BENB_SAU = "benb_sau";
	public static final String JSON_CH_BENC_TRUOC = "benc_truoc";
	public static final String JSON_CH_BENC_SAU = "benc_sau";
	public static final String JSON_CH_SUMMANY_TRUOC = "summany_truoc";
	public static final String JSON_CH_SUMMANY_SAU = "summany_sau";
	public static final String JSON_CH_PROPERTY_TYPE_TRUOC = "property_type_truoc";
	public static final String JSON_CH_PROPERTY_TYPE_SAU = "property_type_sau";
	public static final String JSON_CH_PROPERTY_INFO_TRUOC = "property_info_truoc";
	public static final String JSON_CH_PROPERTY_INFO_SAU = "property_info_sau";
	public static final String JSON_CH_CONTRACT_TYPE_TRUOC = "contract_type_truoc";
	public static final String JSON_CH_CONTRACT_TYPE_SAU = "contract_type_sau";
	public static final String JSON_CH_CONTRACT_VALUE_TRUOC = "contract_value_truoc";
	public static final String JSON_CH_CONTRACT_VALUE_SAU = "contract_value_sau";
	public static final String JSON_CH_NOTARY_PLACE_TRUOC = "notary_place_truoc";
	public static final String JSON_CH_NOTARY_PLACE_SAU = "notary_place_sau";
	
	public static final String JSON_CH_GIAI_CHAP_DATE = "mortage_date";
	public static final String JSON_CH_GIAI_CHAP_NOI_DUNG = "mortage_description";
	public static final String JSON_CH_GIAI_CHAP_FLAG = "mortage_flag";
	
	public static final String JSON_CH_CONTRACT_ERROR_CONTENT_TRUOC = "contract_error_content_truoc";
	public static final String JSON_CH_CONTRACT_ERROR_CONTENT_SAU = "contract_error_content_sau";
	
	public static final String JSON_CH_CONTRACT_ADDITION_CONTENT_TRUOC = "contract_addition_content_truoc";
	public static final String JSON_CH_CONTRACT_ADDITION_CONTENT_SAU = "contract_addition_content_sau";
	
	//Huy hop dong
	public static final String JSON_CH_HUY_HOP_DONG = "cancel_contract_number";
	
	//Lich su thay doi duong su
	public static final String JSON_LI_NAME_TRUOC = "litigant_name_truoc";
	public static final String JSON_LI_NAME_SAU = "litigant_name_sau";
	public static final String JSON_LI_BIRTHDAY_TRUOC = "birthday_truoc";
	public static final String JSON_LI_BIRTHDAY_SAU = "birthday_sau";
	public static final String JSON_LI_IDENTIFICATION_TRUOC = "identification_truoc";
	public static final String JSON_LI_IDENTIFICATION_SAU = "identification_sau";
	public static final String JSON_LI_PURVEY_DATE_TRUOC = "purvey_truoc";
	public static final String JSON_LI_PURVEY_DATE_SAU = "purvey_sau";
	public static final String JSON_LI_PURVEY_ADDREES_TRUOC = "purvey_address_truoc";
	public static final String JSON_LI_PURVEY_ADDREES_SAU = "purvey_address_sau";
	public static final String JSON_LI_PERMANENT_RESIDENCE_TRUOC = "permanent_residence_truoc";
	public static final String JSON_LI_PERMANENT_RESIDENCE_SAU = "permanent_residence_sau";
	public static final String JSON_LI_ADDRESS_TRUOC = "address_truoc";
	public static final String JSON_LI_ADDRESS_SAU = "address_sau";
			
	public static String encryptMD5(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(input.getBytes());
			BigInteger number = new BigInteger(1, messageDigest);
			String hashtext = number.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	public static String getMacAddress() {
		String result = "";
		InetAddress ip;
		try {
			ip = InetAddress.getLocalHost();
			NetworkInterface network = NetworkInterface.getByInetAddress(ip);

			byte[] mac = network.getHardwareAddress();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < mac.length; i++) {
				sb.append(String.format("%02X%s", mac[i],
						(i < mac.length - 1) ? "-" : ""));
			}
			result = sb.toString();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String convertLitigantHistory(String strJson){
		String str = "";
		try {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode actualObj = mapper.readTree(strJson);
			JsonNode type = actualObj.findValue("type");
			if (type != null) {
				if(Constant.ACTION_ADD.equals(type.getTextValue())){
					JsonNode nameTruoc = actualObj.findValue(Constant.JSON_LI_NAME_TRUOC);
					if (nameTruoc != null && !nameTruoc.getTextValue().equals(""))
						str += pareChangeHtml("H�? và tên:", nameTruoc.getTextValue(), null);
					
					JsonNode birthdayTruoc = actualObj.findValue(Constant.JSON_LI_BIRTHDAY_TRUOC);
					if (birthdayTruoc != null && !birthdayTruoc.getTextValue().equals(""))
						str += pareChangeHtml("Ngày sinh:", birthdayTruoc.getTextValue(), null);
					
					JsonNode identificationTruoc = actualObj.findValue(Constant.JSON_LI_IDENTIFICATION_TRUOC);
					if (identificationTruoc != null  && !identificationTruoc.getTextValue().equals(""))
						str += pareChangeHtml("CMT:", identificationTruoc.getTextValue(), null);
					
					JsonNode purveyDateTruoc = actualObj.findValue(Constant.JSON_LI_PURVEY_DATE_TRUOC);
					if (purveyDateTruoc != null && !purveyDateTruoc.getTextValue().equals(""))
						str += pareChangeHtml("Ngày cấp CMT:", purveyDateTruoc.getTextValue(), null);
					
					JsonNode purveyAddressTruoc = actualObj.findValue(Constant.JSON_LI_PURVEY_ADDREES_TRUOC);
					if (purveyAddressTruoc != null && purveyAddressTruoc != null && !purveyAddressTruoc.getTextValue().equals(""))
						str += pareChangeHtml("Nơi cấp CMT:", purveyAddressTruoc.getTextValue(), null);
					
					JsonNode permanentResidenceTruoc = actualObj.findValue(Constant.JSON_LI_PERMANENT_RESIDENCE_TRUOC);
					if (permanentResidenceTruoc != null && !permanentResidenceTruoc.getTextValue().equals(""))
						str += pareChangeHtml("Hộ khẩu thư�?ng trú:", permanentResidenceTruoc.getTextValue(), null);
				
				} else if(Constant.ACTION_EDIT.equals(type.getTextValue())){
					JsonNode nameTruoc = actualObj.findValue(Constant.JSON_LI_NAME_TRUOC);
					JsonNode nameSau = actualObj.findValue(Constant.JSON_LI_NAME_SAU);
					if (nameTruoc != null && nameSau != null && !nameSau.getTextValue().equals(nameTruoc.getTextValue()))
						str += pareChangeHtml("H�? và tên:", nameTruoc.getTextValue(), nameSau.getTextValue());
					
					JsonNode birthdayTruoc = actualObj.findValue(Constant.JSON_LI_BIRTHDAY_TRUOC);
					JsonNode birthdaySau = actualObj.findValue(Constant.JSON_LI_BIRTHDAY_SAU);
					if (birthdayTruoc != null && birthdaySau != null && !birthdaySau.getTextValue().equals(birthdayTruoc.getTextValue()))
						str += pareChangeHtml("Ngày sinh:", birthdayTruoc.getTextValue(), birthdaySau.getTextValue());
					
					JsonNode identificationTruoc = actualObj.findValue(Constant.JSON_LI_IDENTIFICATION_TRUOC);
					JsonNode identificationSau = actualObj.findValue(Constant.JSON_LI_IDENTIFICATION_SAU);
					if (identificationTruoc != null && identificationSau != null && !identificationSau.getTextValue().equals(identificationTruoc.getTextValue()))
						str += pareChangeHtml("CMT:", identificationTruoc.getTextValue(), identificationSau.getTextValue());
					
					JsonNode purveyDateTruoc = actualObj.findValue(Constant.JSON_LI_PURVEY_DATE_TRUOC);
					JsonNode purveyDateSau = actualObj.findValue(Constant.JSON_LI_PURVEY_DATE_SAU);
					if (purveyDateTruoc != null && purveyDateSau != null && !purveyDateSau.getTextValue().equals(purveyDateTruoc.getTextValue()))
						str += pareChangeHtml("Ngày cấp CMT:", purveyDateTruoc.getTextValue(), purveyDateSau.getTextValue());
					
					JsonNode purveyAddressTruoc = actualObj.findValue(Constant.JSON_LI_PURVEY_ADDREES_TRUOC);
					JsonNode purveyAddressSau = actualObj.findValue(Constant.JSON_LI_PURVEY_ADDREES_SAU);
					if (purveyAddressTruoc != null && purveyAddressSau != null && !purveyAddressSau.getTextValue().equals(purveyAddressTruoc.getTextValue()))
						str += pareChangeHtml("Nơi cấp CMT:", purveyAddressTruoc.getTextValue(), purveyAddressSau.getTextValue());
					
					JsonNode permanentResidenceTruoc = actualObj.findValue(Constant.JSON_LI_PERMANENT_RESIDENCE_TRUOC);
					JsonNode permanentResidenceSau = actualObj.findValue(Constant.JSON_LI_PERMANENT_RESIDENCE_SAU);
					if (permanentResidenceTruoc != null && permanentResidenceSau != null && !permanentResidenceSau.getTextValue().equals(permanentResidenceTruoc.getTextValue()))
						str += pareChangeHtml("Hộ khẩu thư�?ng trú:", permanentResidenceTruoc.getTextValue(), permanentResidenceSau.getTextValue());
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return str;
	}
	
	public static String convertContractHistory(String strJson) {
		String str = "";
		try {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode actualObj = mapper.readTree(strJson);
			JsonNode type = actualObj.findValue("type");
			if (type != null) {
				if(Constant.ACTION_ADD.equals(type.getTextValue())){
					JsonNode tenHD = actualObj.findValue(Constant.JSON_CH_CONTRACT_NAME);
					if(tenHD != null)
						str += pareChangeHtml("Tên hợp đồng:", tenHD.getTextValue(), null);
					
					JsonNode receviedDate = actualObj.findValue(Constant.JSON_CH_RECEIVED_DATE);
					if(receviedDate != null)
						str += pareChangeHtml("Ngày thụ lý:", receviedDate.getTextValue(), null);
					
					JsonNode notaryDate = actualObj.findValue(Constant.JSON_CH_NOTARY_DATE);
					if(notaryDate != null)
						str += pareChangeHtml("Ngày công chứng:", notaryDate.getTextValue(), null);
					
					JsonNode notaryPerson = actualObj.findValue(Constant.JSON_CH_NOTARY_PERSON);
					if(notaryPerson != null)
						str += pareChangeHtml("Công chứng viên:", notaryPerson.getTextValue(), null);
					
				} else if (Constant.ACTION_EDIT.equals(type.getTextValue())) {
					JsonNode tenHDTruoc = actualObj.findValue(Constant.JSON_CH_TEN_HD_TRUOC);
					JsonNode tenHDSau = actualObj.findValue(Constant.JSON_CH_TEN_HD_SAU);
					if (tenHDTruoc != null && tenHDSau != null && !tenHDSau.getTextValue().equals(tenHDTruoc.getTextValue()))
						str += pareChangeHtml("Tên hợp đồng:", tenHDTruoc.getTextValue(), tenHDSau.getTextValue());
					
					JsonNode contractNumberTruoc = actualObj.findValue(Constant.JSON_CH_CONTRACT_NUMBER_TRUOC);
					JsonNode contractNumberSau = actualObj.findValue(Constant.JSON_CH_CONTRACT_NUMBER_SAU);
					if (contractNumberTruoc != null && contractNumberSau != null && !contractNumberTruoc.getTextValue().equals(contractNumberSau.getTextValue()))
						str += pareChangeHtml("Số hợp đồng:", contractNumberTruoc.getTextValue(), contractNumberSau.getTextValue());
					
					JsonNode ngayThuLyTruoc = actualObj.findValue(Constant.JSON_CH_RECEIVED_DATE_TRUOC);
					JsonNode ngayThuLySau = actualObj.findValue(Constant.JSON_CH_RECEIVED_DATE_SAU);
					if (ngayThuLyTruoc != null && ngayThuLySau != null && !ngayThuLyTruoc.getTextValue().equals(ngayThuLySau.getTextValue()))
						str += pareChangeHtml("Ngày thụ lý:", ngayThuLyTruoc.getTextValue(), ngayThuLySau.getTextValue());
					
					JsonNode ngayCongChungTruoc = actualObj.findValue(Constant.JSON_CH_NOTARY_DATE_TRUOC);
					JsonNode ngayCongChungSau = actualObj.findValue(Constant.JSON_CH_NOTARY_DATE_SAU);
					if (ngayCongChungTruoc != null && ngayCongChungSau != null && !ngayCongChungTruoc.getTextValue().equals(ngayCongChungSau.getTextValue()))
						str += pareChangeHtml("Ngày công chứng:", ngayCongChungTruoc.getTextValue(), ngayCongChungSau.getTextValue());
					
					JsonNode benaTruoc = actualObj.findValue(Constant.JSON_CH_BENA_TRUOC);
					JsonNode benaSau = actualObj.findValue(Constant.JSON_CH_BENA_SAU);
					if (benaTruoc != null && benaSau != null && !benaSau.getTextValue().equals(benaTruoc.getTextValue()))
						str += pareChangeHtml("Bên A:", benaTruoc.getTextValue(), benaSau.getTextValue());
					
					JsonNode benbTruoc = actualObj.findValue(Constant.JSON_CH_BENB_TRUOC);
					JsonNode benbSau = actualObj.findValue(Constant.JSON_CH_BENB_SAU);
					if (benbTruoc != null && benbSau != null && !benbSau.getTextValue().equals(benbTruoc.getTextValue()))
						str += pareChangeHtml("Bên B:", benbTruoc.getTextValue(), benbSau.getTextValue());
					
					JsonNode bencTruoc = actualObj.findValue(Constant.JSON_CH_BENC_TRUOC);
					JsonNode bencSau = actualObj.findValue(Constant.JSON_CH_BENC_SAU);
					if (bencTruoc != null && bencSau != null && !bencSau.getTextValue().equals(bencTruoc.getTextValue()))
						str += pareChangeHtml("Bên C:", bencTruoc.getTextValue(), bencSau.getTextValue());
					
					JsonNode summanyTruoc = actualObj.findValue(Constant.JSON_CH_SUMMANY_TRUOC);
					JsonNode summanySau = actualObj.findValue(Constant.JSON_CH_SUMMANY_SAU);
					if (summanyTruoc != null && summanySau != null && !summanySau.getTextValue().equals(summanyTruoc.getTextValue()))
						str += pareChangeHtml("Nội dung hợp đồng:", summanyTruoc.getTextValue(), summanySau.getTextValue());
					
					JsonNode contractValueTruoc = actualObj.findValue(Constant.JSON_CH_CONTRACT_VALUE_TRUOC);
					JsonNode contractValueSau = actualObj.findValue(Constant.JSON_CH_CONTRACT_VALUE_SAU);
					if (contractValueTruoc != null && contractValueSau != null && !contractValueTruoc.getTextValue().equals(contractValueSau.getTextValue()))
						str += pareChangeHtml("Giá trị hợp đồng:", contractValueTruoc.getTextValue(), contractValueSau.getTextValue());
					
					JsonNode notaryPlaceTruoc = actualObj.findValue(Constant.JSON_CH_NOTARY_PLACE_TRUOC);
					JsonNode notaryPlaceSau = actualObj.findValue(Constant.JSON_CH_NOTARY_PLACE_SAU);
					if (notaryPlaceTruoc != null && notaryPlaceSau != null && !notaryPlaceTruoc.getTextValue().equals(notaryPlaceSau.getTextValue()))
						str += pareChangeHtml("�?ịa điểm công chứng:", notaryPlaceTruoc.getTextValue(), notaryPlaceSau.getTextValue());
					
					JsonNode loaiTaiSanTruoc = actualObj.findValue(Constant.JSON_CH_PROPERTY_TYPE_TRUOC);
					JsonNode loaiTaiSanSau = actualObj.findValue(Constant.JSON_CH_PROPERTY_TYPE_SAU);
					if (loaiTaiSanTruoc != null && loaiTaiSanSau != null && !loaiTaiSanTruoc.getTextValue().equals(loaiTaiSanSau.getTextValue()))
						str += pareChangeHtml("Loại tài sản:", loaiTaiSanTruoc.getTextValue(), loaiTaiSanSau.getTextValue());
					
					JsonNode thongTinTaiSanTruoc = actualObj.findValue(Constant.JSON_CH_PROPERTY_INFO_TRUOC);
					JsonNode thongTinTaiSanSau = actualObj.findValue(Constant.JSON_CH_PROPERTY_INFO_SAU);
					if (thongTinTaiSanTruoc != null && thongTinTaiSanSau != null && !thongTinTaiSanTruoc.getTextValue().equals(thongTinTaiSanSau.getTextValue()))
						str += pareChangeHtml("Thông tin tài sản:", thongTinTaiSanTruoc.getTextValue(), thongTinTaiSanSau.getTextValue());
					
					JsonNode contractTypeTruoc = actualObj.findValue(Constant.JSON_CH_CONTRACT_TYPE_TRUOC);
					JsonNode contractTypeSau = actualObj.findValue(Constant.JSON_CH_CONTRACT_TYPE_SAU);
					if (contractTypeTruoc != null && contractTypeSau != null && !contractTypeTruoc.getTextValue().equals(contractTypeSau.getTextValue()))
						str += pareChangeHtml("Trạng thái hợp đồng:", contractTypeTruoc.getTextValue(), contractTypeSau.getTextValue());
					
					JsonNode contractErrorTruoc = actualObj.findValue(Constant.JSON_CH_CONTRACT_ERROR_CONTENT_TRUOC);
					JsonNode contractErrorSau = actualObj.findValue(Constant.JSON_CH_CONTRACT_ERROR_CONTENT_SAU);
					if (contractErrorTruoc != null && contractErrorSau != null && !contractErrorTruoc.getTextValue().equals(contractErrorSau.getTextValue()))
						str += pareChangeHtml("Tình trạng hợp đồng:", contractErrorTruoc.getTextValue(), contractErrorSau.getTextValue());
					
					JsonNode contractAdditionTruoc = actualObj.findValue(Constant.JSON_CH_CONTRACT_ADDITION_CONTENT_TRUOC);
					JsonNode contractAdditionSau = actualObj.findValue(Constant.JSON_CH_CONTRACT_ADDITION_CONTENT_SAU);
					if (contractAdditionTruoc != null && contractAdditionSau != null && !contractAdditionTruoc.getTextValue().equals(contractAdditionSau.getTextValue()))
						str += pareChangeHtml("Tình trạng hợp đồng:", contractAdditionTruoc.getTextValue(), contractErrorSau.getTextValue());
					
					JsonNode flagGiaiChap = actualObj.findValue(Constant.JSON_CH_GIAI_CHAP_FLAG);
					JsonNode ngayGiaiChap = actualObj.findValue(Constant.JSON_CH_GIAI_CHAP_DATE);
					JsonNode noidungGiaiChap = actualObj.findValue(Constant.JSON_CH_GIAI_CHAP_NOI_DUNG);
					if (ngayGiaiChap != null && noidungGiaiChap != null)
						if(flagGiaiChap != null && flagGiaiChap.getTextValue().equals("false")){
							str += pareChangeHtml("Tình trạng:", "<b style=\"color : #C00000;\"> �?ã giải chấp ngày: " + ngayGiaiChap.getTextValue() + "<br/>Nội dung giải chấp: " + noidungGiaiChap.getTextValue() + "<b>", "");
						} else{
							str += pareChangeHtml("Tình trạng:", "", "<b style=\"color : #C00000;\"> �?ã giải chấp ngày: " + ngayGiaiChap.getTextValue() + "<br/>Nội dung giải chấp: " + noidungGiaiChap.getTextValue() + "<b>");
						}
					
				} else if(Constant.ACTION_DELETE.equals(type.getTextValue())){
					JsonNode tenHD = actualObj.findValue(Constant.JSON_CH_CONTRACT_NAME);
					if(tenHD != null)
						str += pareChangeHtml("Tên hợp đồng:", tenHD.getTextValue(), null);
					
					JsonNode receviedDate = actualObj.findValue(Constant.JSON_CH_RECEIVED_DATE);
					if(receviedDate != null)
						str += pareChangeHtml("Ngày thụ lý:", receviedDate.getTextValue(), null);
					
					JsonNode notaryDate = actualObj.findValue(Constant.JSON_CH_NOTARY_DATE);
					if(notaryDate != null)
						str += pareChangeHtml("Ngày công chứng:", notaryDate.getTextValue(), null);
					
					JsonNode notaryPerson = actualObj.findValue(Constant.JSON_CH_NOTARY_PERSON);
					if(notaryPerson != null)
						str += pareChangeHtml("Công chứng viên:", notaryPerson.getTextValue(), null);
					
					JsonNode benaNoiDung = actualObj.findValue(Constant.JSON_CH_BENA_NOIDUNG);
					if(benaNoiDung != null)
						str += pareChangeHtml("Bên A:", benaNoiDung.getTextValue(), null);
					
					JsonNode benbNoiDung = actualObj.findValue(Constant.JSON_CH_BENB_NOIDUNG);
					if(benbNoiDung != null)
						str += pareChangeHtml("Bên B:", benbNoiDung.getTextValue(), null);
					
					JsonNode bencNoiDung = actualObj.findValue(Constant.JSON_CH_BENC_NOIDUNG);
					if(bencNoiDung != null)
						str += pareChangeHtml("Bên C:", bencNoiDung.getTextValue(), null);
					
					JsonNode propertyInfo = actualObj.findValue(Constant.JSON_CH_PROPERTY_INFO);
					if(propertyInfo != null)
						str += pareChangeHtml("Nội dung:", propertyInfo.getTextValue(), null);
				} else if(Constant.ACTION_CANCEL.equals(type.getTextValue())){
					JsonNode hopDongHuy = actualObj.findValue(Constant.JSON_CH_HUY_HOP_DONG);
					if (hopDongHuy != null && !hopDongHuy.getTextValue().equals(""))
						str += pareChangeHtml("Tình trạng:", "", "<b style=\"color : #C00000;\"> Hợp đồng đã được hủy bởi hợp đồng số: " + hopDongHuy.getTextValue() + "<b>");
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return str;
	}

	public static String pareChangeHtml(String change, String strTruoc, String strSau) {
		String str = "";
		str += "<div class=\"change-title\" style=\"font-weight: 600;\">";
		str += change;
		str += "</div>";
		str += "<div class=\"change-block\">";
		str += strTruoc;
		if(strSau != null){
			str += "<font color=\"red\"> → </font>";
			str += strSau;
		}
		str += "</div>";
		return str;
	}

	public static void main(String[] args) {
		System.out
				.println(Constant
						.convertContractHistory("{\"type\":\"02\",\"bena_truoc\":\"Nguyen Huu Tung sinh nam 1991, so CMT 174240345\",\"bena_sau\":\"Nguyen Huu Tung sinh nam 1990, so CMT 174240345\"}\""));
	}
}
