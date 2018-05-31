package org.theplu.entities;

import org.theplu.utils.UtilsMethods;

public class Recipes extends BasicEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String desc;
	
	public static final String REC_NAME = "rec_name";
	public static final String REC_DESC = "rec_desc";
	
	public Recipes(){
		super();
		this.columnsName.add(REC_NAME);
		this.columnsName.add(REC_DESC);
	}

	@Override
	public void setValueForColumnName(String columnName, Object value) {
		if( REC_NAME.equals(columnName)){
			setName(UtilsMethods.safetyConversionToStr(value));
			return;
		}
		
		if( REC_DESC.equals(columnName)){
			setDesc(UtilsMethods.safetyConversionToStr(value));
			return;
		}
		
		super.setValueForColumnName(columnName, value);
	}
	
	@Override
	public Object getValueForColumnName(String columnName){
		if( REC_NAME.equals(columnName)){
			return getName();
		}
		
		if( REC_DESC.equals(columnName)){
			return getDesc();
		}
		
		return super.getValueForColumnName(columnName);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
