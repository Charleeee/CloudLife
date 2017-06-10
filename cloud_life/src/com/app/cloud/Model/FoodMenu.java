package com.app.cloud.Model;

import java.io.Serializable;

/**
 * ����ģ��
 *
 */
public class FoodMenu implements Serializable {

	/**
	 * bundle �ӿ�
	 */
	private static final long serialVersionUID = 1L;

	private String image = "";// ͼƬ����
	private String name;// ����
	private String bodyType;// ��������
	private String effect;// ʳ�ƺ͹�Ч
	private String material_main;// ��Ҫʳ��
	private String material_assist;// ����ʳ��
	private String how_make;// ʳ������
	private String flavor;// ζ��

	public FoodMenu() {

	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getImage() {
		return image;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setBodyType(String body) {
		this.bodyType = body;
	}

	public String getBodyType() {
		return bodyType;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}

	public String getEffect() {
		return effect;
	}

	public void setMaterial_main(String material_main) {
		this.material_main = material_main;
	}

	public String getMaterial_main() {
		return material_main;
	}

	public void setMaterial_assist(String material_assist) {
		this.material_assist = material_assist;
	}

	public String getMaterial_assist() {
		return material_assist;
	}

	public void setHow_make(String how_make) {
		this.how_make = how_make;
	}

	public String getHow_make() {
		return how_make;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	public String getFlavor() {
		return flavor;
	}

}
