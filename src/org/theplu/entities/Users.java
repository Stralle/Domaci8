package org.theplu.entities;

import org.theplu.utils.UtilsMethods;

public class Users extends BasicEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	private String pass;
	private String mail;
	
	public static final String USER_NAME = "user_name";
	public static final String USER_PASS = "user_pass";
	public static final String USER_MAIL = "user_mail";
	
	public Users(){
		super();
		this.columnsName.add(USER_NAME);
		this.columnsName.add(USER_PASS);
		this.columnsName.add(USER_MAIL);
	}

	@Override
	public void setValueForColumnName(String columnName, Object value) {
		if( USER_NAME.equals(columnName)){
			setName(UtilsMethods.safetyConversionToStr(value));
			return;
		}
		
		if( USER_PASS.equals(columnName)){
			setPass(UtilsMethods.safetyConversionToStr(value));
			return;
		}
		
		if( USER_MAIL.equals(columnName)){
			setMail(UtilsMethods.safetyConversionToStr(value));
			return;
		}
		
		super.setValueForColumnName(columnName, value);
	}
	
	@Override
	public Object getValueForColumnName(String columnName){
		if( USER_NAME.equals(columnName)){
			return getName();
		}
		
		if( USER_PASS.equals(columnName)){
			return getPass();
		}
		
		if( USER_MAIL.equals(columnName)){
			return getMail();
		}
		
		return super.getValueForColumnName(columnName);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}	
}
