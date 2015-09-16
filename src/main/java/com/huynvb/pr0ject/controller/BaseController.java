package com.huynvb.pr0ject.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import org.codehaus.jackson.JsonNode;
import org.junit.Test;
import org.springframework.ui.Model;

import com.mysql.jdbc.StringUtils;
import com.huynvb.pr0ject.common.ConfigProperties;

public class BaseController {

	private final String START_ITEM_INDEX_KEY = "start";
	private final String LIMIT_KEY = "rowPerPage";
	private final String DIR_UPLOAD_IMG	= "uploadimg";
	private final String DIR_UPLOAD_URL	= "uploadurl";
	private final String MAX_PAGE_LINE_KEY = "maxPageLine";
	private final String TOTAL_ITEM_KEY = "total";
	private final String TOTAL_PAGE_KEY = "totalPage";
	private final String START_PAGE = "startPage";
	private final String END_PAGE = "endPage";
	protected final String START_TIME = " 00:00:00";
	protected final String END_TIME = " 23:59:59";
	protected static final String FILE_TYPE_NOTIFY = "ThÃ´ng bÃ¡o";
	protected static final String FILE_TYPE_CONTRACT = "Há»£p Ä‘á»“ng";
	protected static final String FILE_TYPE_CONTRACT_TEMPLATE = "Máº«u há»£p Ä‘á»“ng";
	protected static final String FILE_TYPE_DOCUMENT = "TÃ i liá»‡u";
	protected static final String STATUS_DANGCHINHSUA = "Ä�ang chá»‰nh sá»­a";
	protected static final String STATUS_TRAVE = "Tráº£ vá»�";
	protected static final String STATUS_CHOKY = "Chá»� kÃ½";
	protected static final String STATUS_DAKY = "Ä�Ã£ kÃ½";
	protected static final String STATUS_DADONGDAU = "Ä�Ã£ Ä‘Ã³ng dáº¥u";
	protected static final String ROLE_ID_NORARY = "2";
	protected static final String ROLE_ID_EDITOR = "3";
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

	protected static final HashMap<String, Integer> fileTypes;
	static {
		fileTypes = new HashMap<String, Integer>();
		fileTypes.put(FILE_TYPE_CONTRACT, 1);
		fileTypes.put(FILE_TYPE_NOTIFY, 2);
		fileTypes.put(FILE_TYPE_CONTRACT_TEMPLATE, 3);
		fileTypes.put(FILE_TYPE_DOCUMENT, 4);
	};
	protected static final HashMap<String, String> dateFilterTypes;
	static {
		dateFilterTypes = new HashMap<String, String>();
		dateFilterTypes.put("1", "1");
		dateFilterTypes.put("2", "2");
		dateFilterTypes.put("3", "3");
		dateFilterTypes.put("4", "4");
		dateFilterTypes.put("5", "5");
	};
	
	protected static final HashMap<String, Byte> contractStatus;
	static {
		contractStatus = new HashMap<String, Byte>();
		contractStatus.put(STATUS_DANGCHINHSUA, (byte)0);
		contractStatus.put(STATUS_TRAVE, (byte)1);
		contractStatus.put(STATUS_CHOKY, (byte)2);
		contractStatus.put(STATUS_DAKY, (byte)3);
		contractStatus.put(STATUS_DADONGDAU, (byte)4);
	};
	
	public String getDir() {
		return ConfigProperties
					.getConfigProperties(DIR_UPLOAD_IMG);
	}
	public String getDirUrl() {
		return ConfigProperties
					.getConfigProperties(DIR_UPLOAD_URL);
	}
	public int getLimit() {
		int limit = 10;
		try {
			limit = Integer.parseInt(ConfigProperties
					.getConfigProperties(LIMIT_KEY));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return limit;
	}

	public int getMaxPageToDisplay() {
		int maxPage = 5;
		try {
			maxPage = Integer.parseInt(ConfigProperties
					.getConfigProperties(MAX_PAGE_LINE_KEY));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return maxPage;
	}

	public void setPagingProperty(Model model, int page, int total,
			int totalPage, int limit) {
		model.addAttribute(START_ITEM_INDEX_KEY, page * limit - limit);
		model.addAttribute(TOTAL_ITEM_KEY, total);
		model.addAttribute(TOTAL_PAGE_KEY, totalPage);
		int maxPage = getMaxPageToDisplay();
		int div = maxPage / 2;
		int start = page - div > 0 ? page - div : 1;
		if (start > 1 && page + div >= totalPage)
			start = (totalPage - maxPage + 1) > 0 ? (totalPage - maxPage + 1)
					: 1;
		model.addAttribute(START_PAGE, start);
		model.addAttribute(END_PAGE, start + maxPage - 1 < totalPage ? start
				+ maxPage - 1 : totalPage);
	}

	/**
	 * Method total page
	 * 
	 * @param totalCount
	 * @param limit
	 * @return
	 */
	public int pageCalculation(int totalCount, int limit) {
		int totalPage = totalCount / limit;
		if (0 < (totalCount % limit)) {
			++totalPage;
		}
		return totalPage;
	}

	/**
	 * <P>
	 * Operate page transition
	 * </P>
	 * 
	 * @param direction
	 *            page transition direction
	 * @param page
	 *            current page
	 * @param totalPage
	 *            total page
	 * @return page number
	 */
	public int pageTransition(String direction, int page, int totalPage) {

		if (direction == null) {
			direction = "";
		}

		if (direction.equalsIgnoreCase("first")) {
			page = 1;
		} else if (direction.equalsIgnoreCase("ahead")) {
			if (1 > (page - 1)) {
				page = totalPage;
			} else {
				--page;
			}
		} else if (direction.equalsIgnoreCase("next")) {
			if (totalPage < (page + 1)) {
				page = 1;
			} else {
				++page;
			}
		} else if (direction.equalsIgnoreCase("last")) {
			page = totalPage;
		} else {
			if (page > totalPage) {
				page = totalPage;
			}
		}
		return page;
	}

	/**
	 * 
	 * @param totalCount
	 * @param limit
	 * @return
	 */
	public int fistPageCalculation(int maxPageLine, int totalPage, int page) {
		int firstPage;
		if (totalPage <= maxPageLine) {
			firstPage = 1;
		} else {
			int firstLinePage, lastLinePage;
			int middlePage = maxPageLine / 2;
			if (maxPageLine % 2 != 0) {
				middlePage = middlePage + 1;
			}
			firstLinePage = middlePage - 1;
			lastLinePage = maxPageLine - middlePage;
			if ((page + lastLinePage) >= totalPage) {
				firstPage = totalPage - maxPageLine + 1;
			} else {
				if ((page - firstLinePage) > 1) {
					firstPage = page - firstLinePage;
				} else {
					firstPage = 1;
				}
			}
		}
		return firstPage;
	}

	/**
	 * Last page calculation
	 * 
	 * @param userForm
	 * @param maxPageLine
	 * @param totalPage
	 * @param page
	 */
	public int lastPageCalculation(int maxPageLine, int totalPage, int page,
			int firstPage) {
		int lastPage;
		if (totalPage <= maxPageLine) {
			lastPage = totalPage;
		} else {
			if ((firstPage + maxPageLine) > totalPage) {
				lastPage = totalPage;
			} else {
				lastPage = firstPage + maxPageLine - 1;
			}
		}
		return lastPage;
	}

	public String getDateTimeFilter(String type, String dateStart,
			String dateEnd, JsonNode actualObj) {
		if (type.equals(dateFilterTypes.get("1"))) {
			dateStart = formatter.format(new Date()) + START_TIME;
			dateEnd = formatter.format(new Date()) + END_TIME;
		} else if (type.equals(dateFilterTypes.get("2"))) {
			dateStart = getFirstDayOfWeek() + START_TIME;
			dateEnd = getLastDayOfWeek() + END_TIME;
		} else if (type.equals(dateFilterTypes.get("3"))) {
			dateStart = "01/" + getCurrentMonth() + "/" + getCurrentYear()
					+ START_TIME;
			dateEnd = getLastDayOfMonth() + END_TIME;
		} else if (type.equals(dateFilterTypes.get("4"))) {
			dateStart = "01/01/" + getCurrentYear() + START_TIME;
			dateEnd = "31/12/" + getCurrentYear() + END_TIME;
		} else if (type.equals(dateFilterTypes.get("5"))) {
			JsonNode dateStartNode = actualObj.findValue("datestart");
			JsonNode dateEndNode = actualObj.findValue("dateend");
			if (dateStartNode != null
					&& !StringUtils.isNullOrEmpty(dateStartNode.getTextValue()))
				dateStart = dateStartNode.getTextValue() + START_TIME;
			if (dateEndNode != null
					&& !StringUtils.isNullOrEmpty(dateEndNode.getTextValue()))
				dateEnd = dateEndNode.getTextValue() + END_TIME;
			else
				dateEnd = formatter.format(new Date()) + END_TIME;
		}
		return dateStart + ";" + dateEnd;
	}

	public int getCurrentDay() {
		Calendar cal = Calendar.getInstance();
		Date date = new Date();
		cal.setTime(date);
		return cal.get(Calendar.DATE);
	}

	public String getCurrentMonth() {
		Calendar cal = Calendar.getInstance();
		int month = cal.get(Calendar.MONTH) + 1;
		return month > 9 ? "" + month : "0" + month;
	}

	public int getCurrentYear() {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.YEAR);
	}

	public String getCurrentDate() {
		Calendar cal = Calendar.getInstance();
		Date date = new Date();
		cal.setTime(date);
		int day = cal.get(Calendar.DATE);
		int month = cal.get(Calendar.MONTH) + 1;
		int year = cal.get(Calendar.YEAR);
		return (day > 9 ? day : "0" + day) + "/"
				+ (month > 9 ? month : "0" + month) + "/" + year;
	}

	public String getLastDayOfMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());

		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.add(Calendar.DATE, -1);

		Date lastDayOfMonth = calendar.getTime();
		return formatter.format(lastDayOfMonth);
	}

	public String getLastDayOfWeek() {
		// Get calendar set to current date and time
		Calendar c = Calendar.getInstance();

		// Set the calendar to monday of the current week
		c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

		// Print dates of the current week starting on Monday
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		c.add(Calendar.DATE, 6);
		return df.format(c.getTime());
	}

	public String getFirstDayOfWeek() {
		// Get calendar set to current date and time
		Calendar c = Calendar.getInstance();

		// Set the calendar to monday of the current week
		c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

		// Print dates of the current week starting on Monday
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		return df.format(c.getTime());
	}
}
