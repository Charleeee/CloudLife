package com.app.cloud.Model;

/**
 * �û���
 */
import org.json.JSONObject;

import com.amap.api.services.core.LatLonPoint;

import android.graphics.Bitmap;

public class User {

	private String icon ="";

	private String phone;
	private String password;
	private String name = "������";
	private String sign = "��̫����ʲôҲû����";
	private String weight = "0";
	private String height = "0";
	private String sex = "����"; // f or m
	private String bodytype = "δ����";
	private String birthday = "1995-01-01";
	private String city = "����-����";
	private String cookie = "";

	//��λ��γ�ȣ�����
	public String location;
	public String locationCity;
	public LatLonPoint lp;
	
	// ����
	public JSONObject weather;

	// ְҵ
	private String work = "ѧ��";

	// ģ����ı�ֽ
	public Bitmap wallBlurs;

	// Ĭ��δ��½
	private boolean isLogin = false;

	// Ψһ��½ʵ��
	static private User customer = null;

	// ���ʵ��
	static public User getInstance() {
		if (User.customer == null) {
			User.customer = new User();
		}
		return User.customer;
	}

	public User() {
	}

	//////////////////////////////////////////////////////////////
	/// �����Ļ�ȡ������

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		if (name.equals(""))
			this.name = "������";
		else
			this.name = name;
	}

	public String getSign() {
		return this.sign;
	}

	public void setSign(String sign) {
		if (sign.equals(""))
			this.sign = "��̫����ʲôҲû���¡�";
		else
			this.sign = sign;
	}

	public String getsex() {
		return this.sex;
	}

	// ���ط����� f m
	public String getSex() {

		if (sex.equals("��"))
			return "m";
		else if (sex.equals("Ů"))
			return "f";
		else
			return "";
	}

	public void setsex(String sex) {
		this.sex = sex;
	}

	public void setSex(String sex) {
		if (sex.equals("m"))
			this.sex = "��";
		else if (sex.equals("f"))
			this.sex = "Ů";
		else
			this.sex = "����";
	}

	public String getWeight() {
		return this.weight;
	}

	public void setWeight(String weight) {
		if (weight.equals(""))
			this.weight = "0";
		else
			this.weight = weight;
	}

	public String getHeight() {
		return this.height;
	}

	public void setHeight(String height) {
		if (height.equals(""))
			this.height = "0";
		else
			this.height = height;
	}

	public String getBirth() {
		return this.birthday;
	}

	public void setBirth(String birth) {
		if (birth.equals(""))
			this.birthday = "1995-1-1";
		else
			this.birthday = birth;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		if (city.equals(""))
			this.city = "����-����";
		else
			this.city = city;
	}

	//���غ���
	public String getBodytype() {
		return this.bodytype;
	}

	// ���ط�����ABCD
	public String getBodyType() {

		switch (this.bodytype) {
		case "ƽ����":
			return "A";
		case "������":
			return "B";
		case "������":
			return "C";
		case "������":
			return "D";
		case "̵ʪ��":
			return "E";
		case "ʪ����":
			return "F";
		case "Ѫ����":
			return "G";
		case "������":
			return "H";
		case "������":
			return "I";
		default:
		}
		return "";
	}

	public void setBodytype(String body) {

		switch (body) {
		case "A":
			this.bodytype = "ƽ����";
			break;
		case "B":
			this.bodytype = "������";
			break;
		case "C":
			this.bodytype = "������";
			break;
		case "D":
			this.bodytype = "������";
			break;
		case "E":
			this.bodytype = "̵ʪ��";
			break;
		case "F":
			this.bodytype = "ʪ����";
			break;
		case "G":
			this.bodytype = "Ѫ����";
			break;
		case "H":
			this.bodytype = "������";
			break;
		case "I":
			this.bodytype = "������";
			break;
		case "":
			this.bodytype = "δ����";
			break;
		}
	}

	public String getCookie() {
		return this.cookie;
	}

	public void setCookie(String cookie) {
		this.cookie = cookie;
	}

	public String getWork() {
		return this.work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public Boolean getLogin() {
		return this.isLogin;
	}

	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}

}
