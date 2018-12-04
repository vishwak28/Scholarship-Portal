package com.nsp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nsp.dao.StateDao;
import com.nsp.model.InstituteRegister;
import com.nsp.model.StateLogin;
import com.nsp.model.StudentRegister;

@Controller
public class StateController {

	@Autowired
	StateDao statedao;

	@Autowired
	StateDao sdao;

	private long value;


	/**
	 * For Redirecting to State Login
	 * @return
	 */

	@RequestMapping("/StateLogin")
	public ModelAndView statelogin() {
		return new ModelAndView("StateLogin");

	}

	/**
	 * For State Login
	 * @param st
	 * @return
	 */
	@RequestMapping(value="/state_login", method = RequestMethod.POST)
	public ModelAndView StateLogin(@ModelAttribute StateLogin st){


		if(st.getGstate_password().equals(statedao.getpassword(st.getGstate_name()))){
			return new ModelAndView("statedashboard"); 
		}
		else  return new ModelAndView("StateLogin");	
	}


	/**
	 * For Display Of All All Student Record
	 * @return
	 */

	@RequestMapping("/ViewUpload_state")
	public ModelAndView displayStudent(){

		List<StudentRegister> list=sdao.DisplayStudentRecord();
		if(!list.isEmpty()){

			StudentRegister sr=list.get(0);

			return new ModelAndView("statedashboard","lst",list);
		}
		else 
		{ 
			return new ModelAndView("empty dashboard","str","Take Some Rest There's No Records For Students To Be Verified");
		}
	}


	/**
	 * For Display Of a single Student
	 * @param gs_aadhar
	 * @return
	 */

	@RequestMapping("/view_state/{gs_aadhar}")
	public ModelAndView viewer(@PathVariable long gs_aadhar) {
		StudentRegister sr = new StudentRegister();
		sr.setGs_aadhar(gs_aadhar);
		value = sr.getGs_aadhar();
		sr=sdao.getStudentByGs_aadhar(gs_aadhar);
		ArrayList<StudentRegister> st=new ArrayList<StudentRegister>();
		st.add(sr);
		ModelAndView mv=new ModelAndView("view_state","list",st);
		mv.addObject("gs_aadhar", sr.getGs_aadhar());
		return mv;
	}


	/**
	 * For Submitting State Officer Action
	 * @param gs_aadhar
	 * @param request
	 * @return
	 */

	@RequestMapping(value="/submit_state/{gs_aadhar}" , method = RequestMethod.POST)
	public ModelAndView SubmitDecision(@PathVariable long gs_aadhar,HttpServletRequest request){

		String status=request.getParameter("checkstatus");

		if(status.equals("Approved")){

			status="Approved By State";
			sdao.changestatus(gs_aadhar,status);
			
			return new ModelAndView("State_officer_acion_save");
		}
		else {
			status="Rejected By State";
			sdao.changestatus(gs_aadhar,status);
			return new ModelAndView("State_officer_acion_save");
		}
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping("/viewinstitute_data")
	public ModelAndView InstituteDisplay(){

		ArrayList<InstituteRegister>lst=new ArrayList<InstituteRegister>();
		lst=sdao.DisplayAllInstituteRecords();
		/*if(lst.isEmpty())
			System.out.println("list is empty");
		else System.out.println(lst.get(0));
		System.out.println("Last Step");
		 */
		return new ModelAndView("statedashboard","list",lst);
	}

	/**
	 * 
	 * @param gi_code
	 * @return
	 */
	@RequestMapping("/view_institute/{gi_code}")
	public ModelAndView DisplaySingleInstitute(@PathVariable int gi_code){

		InstituteRegister ir=sdao.getStudentByGs_aadhar(gi_code);
		ArrayList<InstituteRegister> sr=new ArrayList<InstituteRegister>();
		sr.add(ir);

		ModelAndView mv=new ModelAndView("view_institute_data");

		mv.addObject("list", sr);
		mv.addObject("gi_code", ir.getGi_code());
		return mv;

	}


	/**
	 * 
	 * @param gi_code
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/ChangeStatus/{gi_code}" , method=RequestMethod.POST)
	public ModelAndView Status( @PathVariable int gi_code,HttpServletRequest request){

		String status=request.getParameter("checkstatus");

		if(status.equals("Approved")){

			status="Approved By State";
			sdao.changestatusins(gi_code,status);
			return new ModelAndView("State_officer_acion_save");
		}
		else {
			status="Rejected By State";
			sdao.changestatusins(gi_code,status);
			return new ModelAndView("State_officer_acion_save");
		}
	}
	
	/**
	 * For Redirecting to State DashBoard
	 * @return
	 */

	@RequestMapping("/state_redirect")
	public ModelAndView redirect()
	{
		return new ModelAndView("statedashboard");
	}

	/**
	 * For Handling Unmapped Requests
	 * @return
	 */

	@RequestMapping("*")
	public ModelAndView fallbackMethod(){
		return new ModelAndView("index");
	}

}
