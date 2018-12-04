package com.nsp.controller;
import java.io.IOException;
import java.rmi.ServerException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nsp.dao.StudentDao;
import com.nsp.model.StudentLogin;
import com.nsp.model.StudentRegister;

@Controller
public class StudentRegisterController {

	@Autowired
	StudentDao sdao;
	/**
	 * Redirecting To Register Page
	 * @return
	 */

	@RequestMapping("/sregister")
	public ModelAndView register() {
		return new ModelAndView("sregister");
	}

	/**
	 * Redirecting To Login Page
	 * @return
	 */
	@RequestMapping("/post")
	public ModelAndView dashboard() {
		return new ModelAndView("post");
	}

	/**
	 * For Student Registration
	 * @param ir
	 * @return
	 * @throws ServerException
	 * @throws IOException
	 */
	@RequestMapping("/student_register")
	public ModelAndView StudentRegister(@ModelAttribute StudentRegister ir,HttpServletRequest request) throws ServerException,IOException{

		sdao.SaveSecurity(request.getParameter("gs_question"),request.getParameter("gs_answer"),ir.getGs_aadhar());

		int i = sdao.saveData(ir);
		if(i>0) {
			return new ModelAndView("index");
		}
		else
		{
			return new ModelAndView("index");
		}

	}


	/**
	 * For Student Login
	 * @param st
	 * @return
	 */
	@RequestMapping(value="/student_login" , method=RequestMethod.POST)
	public ModelAndView Studentlogin(@ModelAttribute StudentLogin st,HttpSession session) {

		String hash=sdao.encrypt(st.getGs_password());

		if(hash.equals(sdao.getpass(st.getGs_aadhar()))){

			session.setAttribute("str", st.getGs_aadhar());
			String name= sdao.getName(st.getGs_aadhar());
			session.setAttribute("name", name);
			long check=(Long)session.getAttribute("str");

			return new ModelAndView("sdashboard");	
		}
		else {
			return new ModelAndView("index");
		}
	}


	/**
	 * For checking Application Status
	 * @param session
	 * @return
	 */

	@RequestMapping("/applicationStatus")
	public ModelAndView StatusRequest(HttpSession session){

		long gs_aadhar=(Long)session.getAttribute("str");
		String status=sdao.getApplicationStatus(gs_aadhar);
		return new ModelAndView("applicationstatus","str",status);
	}


	@RequestMapping("/forget")
	public ModelAndView Recovery()
	{
		return new ModelAndView("password_recovery");
	}

	@RequestMapping(value="/forget_password", method=RequestMethod.POST)
	public ModelAndView Recovery1(HttpServletRequest request){

		long gs_aadhar=Long.parseLong(request.getParameter("gs_aadhar"));
		int result=sdao.recovery(gs_aadhar,request.getParameter("gs_question"),request.getParameter("gs_answer"));
		if(result==1) {
			return new ModelAndView("set_password","gs_aadhar",gs_aadhar);
		}
		else {
			return new ModelAndView("password_recovery","result","Invalid Credentials");
		}
	}


	@RequestMapping(value="/new_password/{gs_aadhar}" , method=RequestMethod.POST)
	public ModelAndView SetPassword(@PathVariable long gs_aadhar,HttpServletRequest request)
	{
		sdao.SetPassword(gs_aadhar,request.getParameter("gs_password"));

		return new ModelAndView("password_changed","message","Your Password Has been Successfully Changed");

	}


	/**
	 * Redirecting to Student DashBoard
	 * @return
	 */

	@RequestMapping("/student_redirect")
	public ModelAndView StatusRedirect()
	{
		return new ModelAndView("sdashboard");
	}

}
