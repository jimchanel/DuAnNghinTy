package com.huynvb.pr0ject.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysql.jdbc.StringUtils;
import com.huynvb.pr0ject.common.Constant.FilterKind;
import com.huynvb.pr0ject.model.User;
import com.huynvb.pr0ject.service.UserService;

@Controller
public class UserController extends BaseController {
	//private String ORDER_FIELD = "createDate";
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/quan-ly-nguoi-dung.html", method = RequestMethod.GET)
	public String view(Model model) {
		//userService.addOrderField(new OrderField(ORDER_FIELD, OrderType.DESC));
		userService.clearFilter();
		getListUser(model, 1);
		return "viewUser";
	}
	@RequestMapping(value = "/quan-ly-nguoi-dung.html", method = RequestMethod.POST)
	public String view(
			Model model,
			@RequestParam(value = "filter", required = false, defaultValue = "{}") String filter,
			@RequestParam(value = "p", required = false, defaultValue = "1") int page)
			throws JsonProcessingException, IOException {
		userService.clearFilter();
		if (!filter.equals("{}")) {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode actualObj = mapper.readTree(filter);
			JsonNode key = actualObj.findValue("keyFilter");
			if (key != null && !StringUtils.isNullOrEmpty(key.getTextValue()))
				userService.setKeyFilter(key.getTextValue(), FilterKind.MIDDLE);
		}
		//categoryService.addOrderField(new OrderField(ORDER_FIELD, OrderType.DESC));
		getListUser(model, page);
		return "viewUser";
	}
	@RequestMapping(value = "/them-moi-nguoi-dung.html", method = RequestMethod.GET)
	public String add(Model model) {
		model.addAttribute("user", new User());
		return "addUser";
	}
	@RequestMapping(value = "/them-moi-nguoi-dung.html", method = RequestMethod.POST)
	public String add(Model model,
			@ModelAttribute("user") User user
			) throws Exception {
		if (userService.checkUSER_EXIST(user.getUsername(), false, 0)) {
			model.addAttribute("userMSG",
					"<font color=red>Tài khoản đăng nhập</font> đã tồn tại");
			return "addUser";
		}
		user.setHiddenFlg(true);
		user.setRoleId(5);
		userService.add(user);
		return "redirect:/quan-ly-nguoi-dung.html";
	}
	@RequestMapping(value = "/sua-nguoi-dung.html", method = RequestMethod.GET)
	public String update(Model model, @RequestParam("username") String username) {
		User u = userService.findById(username);
		if (u == null) {
			return "404";
		}
		model.addAttribute("userUpdate", u);
		return "updateUser";
	}
	@RequestMapping(value = "/sua-nguoi-dung.html", method = RequestMethod.POST)
	public String update(Model model, @ModelAttribute("userUpdate") User userUpdate) throws Exception {
		User u = userService.findById(userUpdate.getUsername());
		if (u == null) {
			return "404";
		}
		userService.update(userUpdate);
		return "redirect:/quan-ly-nguoi-dung.html";
	}
	@RequestMapping(value = "/phan-quyen-nguoi-dung.html", method = RequestMethod.GET)
	public String role(Model model, @RequestParam("username") String username) {
		User u = userService.findById(username);
		if (u == null) {
			return "404";
		}
		model.addAttribute("userRole", u);
		String arr = userService.role(username);
		if(arr.indexOf("ROLE_CONTACT") != -1){
			model.addAttribute("ROLE_CONTACT", "1");
		}
		if(arr.indexOf("ROLE_CUSTOMER") != -1){
			model.addAttribute("ROLE_CUSTOMER", 1);
		}
		if(arr.indexOf("ROLE_NEWS") != -1){
			model.addAttribute("ROLE_NEWS", 1);
		}
		if(arr.indexOf("ROLE_USER") != -1){
			model.addAttribute("ROLE_USER", 1);
		}
		if(arr.indexOf("ROLE_CUSTOMER") != -1){
			model.addAttribute("ROLE_CUSTOMER", 1);
		}
		return "roleUser";
	}
	@RequestMapping(value = "/phan-quyen-nguoi-dung.html", method = RequestMethod.POST)
	public String role(Model model, 
			@ModelAttribute("userRole") User u,
			@ModelAttribute("ROLE_CONTACT") String ROLE_CONTACT,
			@ModelAttribute("ROLE_CUSTOMER") String ROLE_CUSTOMER,
			@ModelAttribute("ROLE_NEWS") String ROLE_NEWS,
			@ModelAttribute("ROLE_USER") String ROLE_USER
			) throws ParseException {
		userService.deleteRole(u.getUsername());
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if ("1".equals(ROLE_CONTACT)) {
			userService.addRole(u.getUsername(), "ROLE_CONTACT", auth.getName(), "Liên hệ");
		}
		if ("1".equals(ROLE_CUSTOMER)) {
			userService.addRole(u.getUsername(), "ROLE_CUSTOMER", auth.getName(), "Tư vấn khách hàng");
		}
		if ("1".equals(ROLE_NEWS)) {
			userService.addRole(u.getUsername(), "ROLE_NEWS", auth.getName(), "Quản lý tin tức");
		}
		if ("1".equals(ROLE_USER)) {
			userService.addRole(u.getUsername(), "ROLE_USER", auth.getName(), "Quản lý ngư�?i dùng");
		}
		return "redirect:/quan-ly-nguoi-dung.html";
	}
	
	@RequestMapping(value = "/xoa-nguoi-dung.html", method = RequestMethod.GET)
	public String delete(Model model,
			@RequestParam(value = "username") String username, HttpServletRequest request) {
		try {
			/*if (!ConstantAuthor
					.contain(ConstantAuthor.NumberBookingCost.delete)) {
				return "403";
			}*/
			if (userService.findById(username) == null) {
				return "404";
			}
			userService.deleteRole(username);
			userService.delete(username);
			/*Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/quan-ly-nguoi-dung.html";
	}
	
	private void getListUser(Model model, int page) {
		int limit = getLimit();
		List<User> list = userService.getPaging(page, limit);
		int total = userService.countTotal();
		int totalPage = total / limit;
		if (total % limit != 0)
			totalPage++;
		model.addAttribute("user", list);
		setPagingProperty(model, page, total, totalPage, limit);
	}
}
