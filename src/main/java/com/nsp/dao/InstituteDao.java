package com.nsp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.nsp.model.InstituteRegister;
import com.nsp.model.StudentRegister;

public class InstituteDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/** Saving The Data Into The Database
	 * Saving data into database
	 * @param ir
	 * @return Integer indicating whether The Operation was Successful or not
	 */
	public int saveData(InstituteRegister ir){

		String query="insert into gr12_Institutes values('"+ir.getGi_code()+"','"+ir.getGi_name()+"','"+ir.getGi_pass()+"','"+ir.getGi_state()+"','"+ir.getGi_uni()+"',default)";
		return jdbcTemplate.update(query);
	}

	/**Extracting Student Data
	 * retrieving password from database
	 * @param gi_code
	 * @return A Object Contaning the whole data
	 */



	public StudentRegister getStudentById(long aadhar){

		StudentRegister st=new StudentRegister();
		st=(StudentRegister)jdbcTemplate.queryForObject("select * from gr12_students where gs_aadhar="+aadhar+" ", StudentRegister.class);
		return st;
	}


	/**
	 * Extracting Password From Database For Validation
	 * @param gi_code
	 * @return Hashed Password
	 */

	public String getpass(int gi_code)
	{   
		String password=null;

		try {
			Object obj=jdbcTemplate.queryForObject("select gi_pass from gr12_Institutes where gi_code=?", new Object[] {gi_code}, String.class);
			password=(String)obj;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return password;
	}

	/**
	 * Extracting A Single Student Data
	 * @param gs_aadhar
	 * @return
	 */

	public StudentRegister getStudentByGs_aadhar(long gs_aadhar){  
		String q;
		q = "select * from gr12_Students where gs_aadhar = ?";
		return jdbcTemplate.queryForObject(q, new Object[] {gs_aadhar}, new BeanPropertyRowMapper<StudentRegister>(StudentRegister.class)) ;
	}

	/**
	 * Updating The Scholarship Status
	 * @param gs_aadhar
	 * @param status
	 */

	public void changestatus(long gs_aadhar,String status){
		
		jdbcTemplate.update("update gr12_students set GS_STATUS='"+status+"' where gs_aadhar="+gs_aadhar+" ");
	}
	public String getstatus(int gi_code) {
		String str=null; Object obj;

		obj=jdbcTemplate.queryForObject("Select gi_status from gr12_institutes where  gi_code="+gi_code+"" ,String.class);
		str=obj.toString();
		return str;
	}

}	


