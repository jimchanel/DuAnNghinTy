package com.huynvb.pr0ject.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;








import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
// @RequestMapping(value = "/home")
public class HomeController {
	/**
	 * Simply selects the home view to render by returning its name .
	 * 
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	private String sessionId;
	private int count = 0;

	@RequestMapping(value = "/index.html", method = RequestMethod.GET)
	public String home(Locale locale, ModelMap model, HttpServletRequest request)
			throws IOException {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		return "homepage";
	}
	
	@RequestMapping(value = "/404.html", method = RequestMethod.GET)
	public String notfound(Locale locale, ModelMap model, HttpServletRequest request)
			throws IOException {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		System.out.println("page not found");
		return "404";
	}
	
	@RequestMapping(value = "/403.html", method = RequestMethod.GET)
	public String accessdenine(Locale locale, ModelMap model, HttpServletRequest request)
			throws IOException {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		return "403";
	}
}
