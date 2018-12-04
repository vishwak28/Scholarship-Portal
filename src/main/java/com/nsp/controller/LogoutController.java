package com.nsp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LogoutController {

	/**
	 * For Ministry Logout
	 * @param session
	 * @return
	 */

	@RequestMapping(value="/ministry_logout",method=RequestMethod.GET)
	public String logout(HttpSession session) {

		return "logout";
	}


	/**
	 * For Logout
	 * @param session
	 * @return
	 */
	@RequestMapping("/logout")
	public ModelAndView Studentlogout(HttpSession session) {

		session.invalidate();
		return new ModelAndView("logout");
	}

}