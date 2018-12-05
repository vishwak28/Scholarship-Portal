package com.nsp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class UploadDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	/**
	 * Saving Location Of The File
	 * @param gs_aadhar
	 * @param loc
	 * @param column_name
	 * @return A Integer Indicating STATUS Of the query executed
	 */

	public int savelocation(long gs_aadhar,String loc,String column_name)
	{
		int i= jdbcTemplate.update("insert into gr12_documents values("+gs_aadhar+",'','','','','','','')");

		int j=jdbcTemplate.update("update gr12_documents set "+column_name+"='"+loc+"' where gs_aadhar_no="+gs_aadhar+" ");

		return j;
	}

	/**
	 * updating file location
	 * @param gs_aadhar
	 * @param loc
	 * @param column_name
	 * @return
	 */
	public int updatelocation(long gs_aadhar,String loc,String column_name) {
		return jdbcTemplate.update("update gr12_documents set "+column_name+"='"+loc+"' where gs_aadhar_no="+gs_aadhar+" ");
	}


	/**
	 * changing student status
	 * @param gs_aadhar
	 * @param status
	 */
	public void changestatus(long gs_aadhar,String status){
		jdbcTemplate.update("update gr12_students set GS_STATUS='"+status+"' where gs_aadhar="+gs_aadhar+" ");
	}

	/**
	 * updating document status
	 * @param gs_aadhar
	 */
	public void Updatedoc(long gs_aadhar) {
		jdbcTemplate.update("update gr12_students set gs_doc_uploaded='YES' where gs_aadhar="+gs_aadhar+"");
	}

	/**
	 * deleting records of documents
	 * @param gs_aadhar
	 */
	public void DeleteRecords(long gs_aadhar) {
		jdbcTemplate.update("delete from gr12_documents where gs_aadhar_no="+gs_aadhar+" ");
	}

}
