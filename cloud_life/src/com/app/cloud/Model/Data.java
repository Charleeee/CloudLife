package com.app.cloud.Model;

/**
 * ����ģ�����ģ��
 *
 */
public class Data {

	// ʳ������
	private String type;
	// ������
	private String kind;
	// �������ٿ�
	private String num;

	public Data() {
	}

	public Data(String type, String kind, String num) {
		this.type = type;
		this.kind = kind;
		this.num = num;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getKind() {
		return kind;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getNum() {
		return num;
	}

}
