package com.nsp.model;

public class InstituteRegister {
	
	/**
	 * model class for institute registration
	 */
	private int gi_code;
	private String gi_name;
	private String gi_status;
	private String gi_state;
	private String gi_uni;
	private String gi_pass;

	public int getGi_code() {
		return gi_code;
	}
	public void setGi_code(int gi_code) {
		this.gi_code = gi_code;
	}
	public String getGi_name() {
		return gi_name;
	}
	public void setGi_name(String gi_name) {
		this.gi_name = gi_name;
	}
	public String getGi_state() {
		return gi_state;
	}
	public void setGi_state(String gi_state) {
		this.gi_state = gi_state;
	}
	public String getGi_uni() {
		return gi_uni;
	}
	public void setGi_uni(String gi_uni) {
		this.gi_uni = gi_uni;
	}
	public String getGi_pass() {
		return gi_pass;
	}
	public void setGi_pass(String gi_pass) {
		this.gi_pass = gi_pass;
	}
	public String getGi_status() {
		return gi_status;
	}
	public void setGi_status(String gi_status) {
		this.gi_status = gi_status;
	}
	@Override
	public String toString() {
		return "InstituteRegister [gi_code=" + gi_code + ", gi_name=" + gi_name + ", gi_status=" + gi_status
				+ ", gi_state=" + gi_state + ", gi_uni=" + gi_uni + ", gi_pass=" + gi_pass + "]";
	}
	

}
