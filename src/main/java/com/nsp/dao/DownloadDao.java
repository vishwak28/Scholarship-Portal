package com.nsp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class DownloadDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	/**
	 * Extracting Location Of File
	 * @param gs_aadhar
	 * @param document_name
	 * @return Absolute File Path
	 */
	
	public String getlocation(long gs_aadhar,String document_name )
	{
		String loc=null;
		Object obj=null;
		
		
		try {
			obj = jdbcTemplate.queryForObject("select "+document_name+" from gr12_documents where gs_aadhar_no="+gs_aadhar+"", String.class);
		} catch (DataAccessException e) {
			
			
			e.printStackTrace();
		}
		
		loc=obj.toString();
		return loc;
	}
	
}
