package com.nsp.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.nsp.model.InstituteRegister;
import com.nsp.model.StudentRegister;

public class MinistryDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * retrieving password from database
	 * @param name
	 * @return
	 */
	public String getpassword(String name)
	{

		String password=null;

		try {
			Object obj=(String)jdbcTemplate.queryForObject("select password from gr12_Ministry where name=?",new Object[] {name},String.class);
			password=(String)obj;
		} catch (DataAccessException e) {

			e.printStackTrace();
		}
		return password;
	}

	/**
	 * Displaying Records All Student
	 * @return
	 */

	public List<StudentRegister> DisplayStudentRecord() {

		List<Map<String,Object>> list=jdbcTemplate.queryForList("select * from gr12_Students where gs_doc_uploaded='YES' and gs_status='Approved By State'");

		ArrayList<StudentRegister> last = new ArrayList<StudentRegister>();

		for(Map<String,Object> lst:list)
		{
			Object obj;
			String str;

			StudentRegister st=new StudentRegister();
			//Setting Values
			obj=lst.get("gs_name"); 
			str=obj.toString(); 
			st.setGs_name(str);

			obj=lst.get("gs_dob");  
			str=obj.toString(); 
			st.setGs_dob(str);

			obj=lst.get("gs_mobile");  
			str=obj.toString();    
			st.setGs_mobile(Long.parseLong(str));

			obj=lst.get("gs_email");  
			str=obj.toString(); 
			st.setGs_email(str);

			obj=lst.get("gs_insname");  
			str=obj.toString(); 
			st.setGs_insname(str);

			obj=lst.get("gs_aadhar");  
			str=obj.toString();    
			st.setGs_aadhar(Long.parseLong(str));

			obj=lst.get("gs_bank_name");  
			str=obj.toString(); 
			st.setGs_bank_name(str);

			obj=lst.get("gs_ifsc");  
			str=obj.toString(); 
			st.setGs_ifsc(str);

			obj=lst.get("gs_account_no");  
			str=obj.toString();    
			st.setGs_account_no(Long.parseLong(str));

			obj=lst.get("gs_state");  
			str=obj.toString(); 
			st.setGs_state(str);

			obj=lst.get("gs_metric");  
			str=obj.toString();    
			st.setGs_metric(Long.parseLong(str));

			obj=lst.get("gs_hsc");  
			str=obj.toString();    
			st.setGs_hsc(Long.parseLong(str));

			obj=lst.get("gs_degree");  
			str=obj.toString();    
			st.setGs_degree(Long.parseLong(str));

			obj=lst.get("gs_income");  
			str=obj.toString();    
			st.setGs_income(Long.parseLong(str));

			obj=lst.get("gs_caste");  
			str=obj.toString(); 
			st.setGs_caste(str);

			last.add(st);
		}

		return last;
	}

	/**
	 * Retrieving Record Of A Single Student
	 * @param gs_aadhar
	 * @return
	 */

	public StudentRegister getStudentByGs_aadhar(long gs_aadhar){  
		String q;
		q = "select * from gr12_Students where gs_aadhar = ?";
		return jdbcTemplate.queryForObject(q, new Object[] {gs_aadhar}, new BeanPropertyRowMapper<StudentRegister>(StudentRegister.class)) ;
	}

	/**
	 * Updating Scholarship made by the State Nodal Officer After Verification
	 * @param gs_aadhar
	 * @param status
	 */

	public void changestatus(long gs_aadhar, String status) {

		jdbcTemplate.update("update gr12_students set GS_STATUS='"+status+"' where gs_aadhar="+gs_aadhar+" ");

	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<InstituteRegister> DisplayAllInstituteRecords() {

		List<Map<String,Object>> list=jdbcTemplate.queryForList("select * from gr12_institutes where gi_status='Approved By State'");

		ArrayList<InstituteRegister> last = new ArrayList<InstituteRegister>();

		for(Map<String,Object> lst:list)
		{
			Object obj;
			String str;

			InstituteRegister st=new InstituteRegister();
			//Setting Values
			obj=lst.get("gi_code"); 
			str=obj.toString();    
			st.setGi_code(Integer.parseInt(str));

			obj=lst.get("gi_name"); 
			str=obj.toString(); 
			st.setGi_name(str);

			obj=lst.get("gi_pass");  
			str=obj.toString();
			st.setGi_pass(str);

			obj=lst.get("gi_state");  
			str=obj.toString(); 
			st.setGi_state(str);

			obj=lst.get("gi_uni"); 
			str=obj.toString(); 
			st.setGi_uni(str);

			obj=lst.get("gi_status"); 
			str=obj.toString();    
			st.setGi_status(str);

			last.add(st);
		}

		return last;

	}

	/**
	 * 
	 * @param gi_code
	 * @param status
	 */
	
	public InstituteRegister getStudentByGs_aadhar(int gi_code){  
		String q;
		q = "select * from gr12_Institutes where gi_code=?";
		return jdbcTemplate.queryForObject(q, new Object[] {gi_code}, new BeanPropertyRowMapper<InstituteRegister>(InstituteRegister.class)) ;
	}

	/**
	 * 
	 * @param gi_code
	 * @param status
	 */
	public void changestatusins(int gi_code, String status) {

		jdbcTemplate.update("update gr12_institutes set gi_status='"+status+"' where gi_code="+gi_code+" ");

	}
}
