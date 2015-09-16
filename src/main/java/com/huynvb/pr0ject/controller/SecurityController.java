package com.huynvb.pr0ject.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.huynvb.pr0ject.common.ConfigProperties;

@Controller
public class SecurityController {
	private static final String ERR_FAILURE_LOGIN = "errFailureLogin";
	private static final String MSG_LOGOUT_SUCCESS = "msgLogoutSuccess";
	
	@RequestMapping(value = "/login.html", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error, @RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Tài khoản hoặc mật khẩu đăng nhập chưa đúng");
		}

		if (logout != null) {
			model.addObject("msg", "Bạn đã đăng xuất thành công !");
		}
		model.setViewName("login");

		return model;

	}
}
