package com.nsp.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.nsp.model.StudentRegister;

public class StudentDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	/**
	 * Encryption For Password
	 * @param str
	 * @return Encrypted String
	 */

	public String encrypt(String str)
	{

		int i=0; String hash="";
		while(i<str.length())
		{
			char c=(char)(str.charAt(i)+3);
			hash=hash+c;
			i++;
		}
		return hash;
	}


	/**
	 * save data into database
	 * @param st
	 * @return Integer
	 */

	public int saveData(StudentRegister st){

		String hash=encrypt(st.getGs_password());
		String query="insert into gr12_Students values('"+st.getGs_name()+"','"+st.getGs_dob()+"',"+st.getGs_mobile()+",'"+st.getGs_email()+"','"+st.getGs_insname()+"',"+st.getGs_aadhar()+",'"+st.getGs_bank_name()+"','"+st.getGs_ifsc()+"',"+st.getGs_account_no()+",'"+hash+"','"+st.getGs_state()+"',0,0,0,0,'no caste',default,'not approved')";
		return jdbcTemplate.update(query);
	}


	/**
	 * Retrieving Password For Validation
	 * @param gs_aadhar
	 * @return Hashed Password
	 */

	public String getpass(long gs_aadhar){  

		String password=null;

		try {

			Object obj=jdbcTemplate.queryForObject("select gs_password from gr12_Students where gs_aadhar=?", new Object[] {gs_aadhar}, String.class);
			password=(String)obj;

		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return password;

	}

	/**
	 * Update student data in database
	 * @param st
	 */
	public void saveUploadData(StudentRegister st,long gs_aadhar){

		String query="update gr12_Students set gs_metric="+st.getGs_metric()+",gs_hsc="+st.getGs_hsc()+",gs_degree="+st.getGs_degree()+",gs_income="+st.getGs_income()+",gs_caste='"+st.getGs_caste()+"' where gs_aadhar="+gs_aadhar+" ";
		jdbcTemplate.update(query);
	}


	/**
	 * Displaying Student Records To Institute
	 */

	public List<StudentRegister> DisplayStudentRecord(){

		List<Map<String,Object>> list=jdbcTemplate.queryForList("select * from gr12_Students where gs_doc_uploaded='YES' and gs_status='not approved'");

		ArrayList<StudentRegister> last = new ArrayList<StudentRegister>();

		for(Map<String,Object> lst:list){
			
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
	 * Extracting Aadhar using Email
	 * @param email
	 * @return Aadhar No 
	 */

	public long getaadhar(String email) throws 	java.lang.NullPointerException
	{

		long gs_aadhar=0;
		Object obj=null;

		try {
			obj=jdbcTemplate.queryForObject("select gs_aadhar from gr12_students where gs_email='"+email+"' ", Long.class);
		} catch (DataAccessException e) {

			e.printStackTrace();
		}

		gs_aadhar=(Long)obj;
		return gs_aadhar;
	}

	/**
	 * Checking Application Status
	 * @param gs_aadhar
	 * @return
	 */

	public String getApplicationStatus(long gs_aadhar) {

		String status=null;
		Object obj;
		try {
			obj=jdbcTemplate.queryForObject("select gs_status from gr12_students where gs_aadhar="+gs_aadhar+"",String.class);
			status=obj.toString();

		} catch (DataAccessException e) {

			e.printStackTrace();
		}

		return status;
	}

	public void SaveSecurity(String gs_question, String gs_answer,long gs_aadhar) {

		jdbcTemplate.update("insert into gr12_security values("+gs_aadhar+",'"+gs_question+"','"+gs_answer+"')");
	}
	
	public int recovery(long gs_aadhar,String gs_question,String gs_answer) {
		String question=null,answer=null;

		try {
			question=jdbcTemplate.queryForObject("select gs_question from gr12_security where gs_aadhar="+gs_aadhar+" ", String.class);
			answer=jdbcTemplate.queryForObject("select gs_answer from gr12_security where gs_aadhar="+gs_aadhar+" ", String.class);
		} 
		catch (DataAccessException e) {

			return -1;
		}

		if(gs_question.equals(question) && gs_answer.equals(answer))
			return 1;
		else return -1;

	}
	
	public void SetPassword(long gs_aadhar, String password) {

		String hash_password=encrypt(password);
		jdbcTemplate.update("update gr12_students set gs_password='"+hash_password+"' where gs_aadhar="+gs_aadhar+"");
	}
	
	public String getName(long gs_aadhar) {		
		return jdbcTemplate.queryForObject("select gs_name from gr12_Students where gs_aadhar="+gs_aadhar+"", String.class);
	}

}
