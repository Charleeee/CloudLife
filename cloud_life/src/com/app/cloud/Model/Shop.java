package com.app.cloud.Model;

import java.io.Serializable;

/**
 * �̼�ģ��
 *
 */
public class Shop implements Serializable {
	
	/**
	 * bundle �ӿ�
	 */
	private static final long serialVersionUID = 2L;
	
	private String icon;
	private String name;
	public int number;
	
	public Shop() {

	}
	
	public Shop(String n,String c,int p) {
		name = n;
		icon = c;
		number = p;
	}
	
	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getIcon() {
		return icon;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	

}
