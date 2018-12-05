package com.nsp.controller;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nsp.dao.InstituteDao;
import com.nsp.dao.StudentDao;
import com.nsp.model.InstituteLogin;
import com.nsp.model.InstituteRegister;
import com.nsp.model.StudentRegister;

@Controller
public class InstituteRegisterController {

	@Autowired
	StudentDao sdao;
	@Autowired
	InstituteDao idao;
	private long value;

	/**
	 * Redirecting to Register Page
	 * @return
	 */

	@RequestMapping("/iregister")
	public ModelAndView register() {
		return new ModelAndView("iregister");
	}


	/**
	 * Redirecting to Login Page
	 * @return
	 */

	@RequestMapping("/ilogin")
	public ModelAndView ilogin() {
		return new ModelAndView("ilogin");
	}



	/**For Register
	 * Controller to register institute
	 * @param ir
	 * @return 
	 * @throws ServerException
	 * @throws IOException
	 */
	@RequestMapping("/register")
	public ModelAndView InstituteRegister(@ModelAttribute InstituteRegister ir) throws ServerException,IOException{

		try {
			int i = idao.saveData(ir);
			if(i>0) {
				return new ModelAndView("ilogin");
			}
			else
			{
				return new ModelAndView("index");
			}
		} catch (Exception e) {
			return new ModelAndView("iregister","ins",e.getMessage());
			
		}

	}

	/**For Login
	 * controller to login for institute
	 * @param it
	 * @return 
	 */
	@RequestMapping("/institute_login")
	public ModelAndView Institutelogin(@ModelAttribute InstituteLogin it) {
		if(it.getGi_pass().equals(idao.getpass(it.getGi_code()))){
			return new ModelAndView("institute dashboard");	
		}
		else {
			return new ModelAndView("ilogin");
		}
	}

	/**
	 * For Displaying a Single Record
	 * @param gs_aadhar
	 * @return
	 */

	@RequestMapping("/view/{gs_aadhar}")
	public ModelAndView viewer(@PathVariable long gs_aadhar) {
		StudentRegister sr = new StudentRegister();
		sr.setGs_aadhar(gs_aadhar);
		value = sr.getGs_aadhar();
		sr=idao.getStudentByGs_aadhar(gs_aadhar);
		ArrayList<StudentRegister> st=new ArrayList<StudentRegister>();
		st.add(sr);
		ModelAndView mv=new ModelAndView("view","list",st);
		mv.addObject("gs_aadhar", sr.getGs_aadhar());
		return mv;
	}

	/**
	 * For Download
	 * @param gs_aadhar
	 * @return
	 */

	@RequestMapping("/download_student_documents/{gs_aadhar}/{file_name}")
	public ModelAndView student_record_download(@PathVariable long gs_aadhar){
		return new ModelAndView("view");
	}


	/**
	 * Display All Records
	 * @return
	 */

	@RequestMapping("/ViewUpload")
	public ModelAndView displayStudent(){

		List<StudentRegister> list=sdao.DisplayStudentRecord();

		return new ModelAndView("institute dashboard","lst",list);

	}

}
