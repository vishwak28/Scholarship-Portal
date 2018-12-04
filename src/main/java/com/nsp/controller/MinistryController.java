package com.nsp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nsp.dao.MinistryDao;
import com.nsp.model.InstituteRegister;
import com.nsp.model.MinistryLogin;
import com.nsp.model.StudentRegister;

@Controller
public class MinistryController {

	@Autowired
	MinistryDao mindao;

	private long value;


	/**
	 * For Redirecting to Ministry Login
	 * @return
	 */

	@RequestMapping("/MinistryLogin")
	public ModelAndView ministrylogin() {
		return new ModelAndView("MinistryLogin");
	}

	/**
	 * For Ministry Login
	 * @param mn
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/ministry_login",method=RequestMethod.POST)
	public ModelAndView MinistryLogin(@ModelAttribute MinistryLogin mn,HttpServletRequest request,HttpServletResponse response){

		if(mn.getPassword().equals(mindao.getpassword(mn.getName())))
		{ 

			HttpSession session=request.getSession(true);
			session.setAttribute("str", mn.getName());

			String str=(String)session.getAttribute("str");

			return new ModelAndView("MinistryDashBoard"); 
		}
		else  return new ModelAndView("index");	
	}


	/**
	 * For Ministry Logout
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 */
	@RequestMapping("/ministry_logout")
	public ModelAndView logout(HttpServletRequest request,HttpServletResponse response,HttpSession session){

		ModelAndView model=new ModelAndView("MinistryLogin");
		String name=(String)session.getAttribute("str");
		session.invalidate();
		return model;
	}

	/**
	 * For Display Of All Students
	 * @return
	 */

	@RequestMapping("/view_ministry")
	public ModelAndView displayStudent(){
		
		List<StudentRegister> list=mindao.DisplayStudentRecord();
		if(!list.isEmpty()){
			StudentRegister sr = list.get(0);
			return new ModelAndView("MinistryDashBoard","lst",list);
		}
		else { 
			return new ModelAndView("empty_ministry_dashboard","str","Take Some Rest There's No Records For Students To Be Verified");
		}
	}

	/**
	 * For Display Of Single Student
	 * @param gs_aadhar
	 * @return
	 */

	@RequestMapping(value="/view_data/{gs_aadhar}")
	public ModelAndView viewer(@PathVariable long gs_aadhar) {
		StudentRegister sr = new StudentRegister();
		sr.setGs_aadhar(gs_aadhar);
		value = sr.getGs_aadhar();
		sr=mindao.getStudentByGs_aadhar(gs_aadhar);
		ArrayList<StudentRegister> st=new ArrayList<StudentRegister>();
		st.add(sr);
		ModelAndView mv=new ModelAndView("view_ministry","list",st);
		mv.addObject("gs_aadhar", sr.getGs_aadhar());
		return mv;
	}


	/**
	 * For Submitting Ministry Action
	 * @param gs_aadhar
	 * @param request
	 * @return
	 */

	@RequestMapping(value="/submit_ministry/{gs_aadhar}" , method = RequestMethod.POST)
	public ModelAndView SubmitDecision(@PathVariable long gs_aadhar,HttpServletRequest request){
		
		String status=request.getParameter("checkstatus");

		if(status.equals("Approved by State")){

			status="Scholarship Has Been Granted";
			mindao.changestatus(gs_aadhar,status);
			return new ModelAndView("State_officer_acion_save");
		}
		else {
			status="Rejected By Ministry";
			mindao.changestatus(gs_aadhar,status);
			return new ModelAndView("State_officer_acion_save");
		}
	}

	/**
	 * For Redirecting
	 * @return
	 */

	@RequestMapping("/ministry_redirect")
	public ModelAndView redirect(){
		
		return new ModelAndView("MinistryDashBoard");
	}


	/**
	 * 
	 * @return
	 */
	@RequestMapping("/viewins_data")
	public ModelAndView InstituteDisplay(){

		ArrayList<InstituteRegister>lst=new ArrayList<InstituteRegister>();
		lst=mindao.DisplayAllInstituteRecords();
		/*if(lst.isEmpty()) {
			System.out.println("list is empty");
		}
		else {
			System.out.println(lst.get(0));
		}
		System.out.println("Last Step");*/
		 
		return new ModelAndView("MinistryDashBoard","list",lst);
	}

	/**
	 * 
	 * @param gi_code
	 * @return
	 */
	@RequestMapping("/view_ins/{gi_code}")
	public ModelAndView DisplaySingleInstitute(@PathVariable int gi_code){

		InstituteRegister ir=mindao.getStudentByGs_aadhar(gi_code);
		ArrayList<InstituteRegister> sr=new ArrayList<InstituteRegister>();
		sr.add(ir);

		ModelAndView mv=new ModelAndView("single_institute_data");

		mv.addObject("list", sr);
		mv.addObject("gi_code", ir.getGi_code());
		return mv;

	}


	@RequestMapping(value="/ChangeStatusins/{gi_code}" , method=RequestMethod.POST)
	public ModelAndView Status( @PathVariable int gi_code,HttpServletRequest request){

		String status=request.getParameter("checkstatus");

		if(status.equals("Approved")){

			status="Approved By Ministry";
			mindao.changestatusins(gi_code,status);
			return new ModelAndView("State_officer_acion_save");
		}
		else {
			status="Rejected By Ministry";
			mindao.changestatusins(gi_code,status);
			return new ModelAndView("State_officer_acion_save");
		}
	}
}




