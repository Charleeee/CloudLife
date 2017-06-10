package com.app.cloud.Model;

import java.io.Serializable;

/**
 * ��Ʒģ��
 *
 */
public class FoodDish implements Serializable {

	/**
	 * bundle �ӿ�id
	 */
	private static final long serialVersionUID = 1L;

	private String image;// ͼƬ����
	private String name;// ����
	private String bodyType;// ��������
	private String introduction;// ��Ʒ����
	private String nutrition;// ��ҪӪ��
	private String effect;// ʳ�ƺ͹�Ч
	private String man_suit = "";// ������Ⱥ
	private String man_unsuit = "";// ������Ⱥ
	private String fun = "";// ��Ч������
	private String how_eat = "";// ʹ�÷���
	private String save = "";// ��α���
	private String how_select = "";// �����ѡ
	private String value;// Ӫ����ֵ��
	private String collocation_good;// ʳ�������� json����
	private String collocation_bad;// ʳ����˱� json����

	public FoodDish() {

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

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setNutrition(String nutrition) {
		this.nutrition = nutrition;
	}

	public String getNutrition() {
		return nutrition;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}

	public String getEffect() {
		return effect;
	}

	public void setMan_suit(String man_suit) {
		this.man_suit = man_suit;
	}

	public String getMan_suit() {
		return man_suit;
	}

	public void setMan_unsuit(String man_unsuit) {
		this.man_unsuit = man_unsuit;
	}

	public String getMan_unsuit() {
		return man_unsuit;
	}

	public void setHow_eat(String eat) {
		this.how_eat = eat;
	}

	public String getHow_eat() {
		return how_eat;
	}

	public void setSave(String save) {
		this.save = save;
	}

	public String getSave() {
		return save;
	}

	public void setHow_select(String how_select) {
		this.how_select = how_select;
	}

	public String getHow_select() {
		return how_select;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setCollocation_good(String collocation_good) {
		this.collocation_good = collocation_good;
	}

	public String getCollocation_good() {
		return collocation_good;
	}

	public void setCollocation_bad(String collocation_bad) {
		this.collocation_bad = collocation_bad;
	}

	public String getCollocation_bad() {
		return collocation_bad;
	}

	public void setFun(String fun) {
		this.fun = fun;
	}

	public String getFun() {
		return fun;
	}

}
