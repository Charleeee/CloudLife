package com.app.cloud.Model;

import java.util.ArrayList;

/**
 * ��ʳ����expandable�б� group+child
 *
 */
public class DietMeal {

	public String group; // ����
	ArrayList<FoodMenu> child; // ������

	public DietMeal() {
		group = "";
		child = null;
	}

	public DietMeal(String groupName) {
		this.group = groupName;
		this.child = new ArrayList<FoodMenu>();
	}

	public DietMeal(String groupName, ArrayList<FoodMenu> groupChild) {
		this.group = groupName;
		this.child = new ArrayList<FoodMenu>();
		for (int i = 0; i < groupChild.size(); i++)
			child.add(groupChild.get(i));
	}

	// ��С�������������
	public void add(FoodMenu u) {
		child.add(u);
	}

	// �����û������Ƴ�������
	public void remove(FoodMenu u) {
		child.remove(u);
	}

	// �����±��Ƴ�������
	public void remove(int index) {
		child.remove(index);
	}

	// �����ݵĴ�С
	public int getChildSize() {
		return child.size();
	}

	// �������������
	public void clearAllChild() {
		for (int i = getChildSize() - 1; i >= 0; i--)
			remove(i);
	}

	// �����±�õ����û�
	public FoodMenu getChild(int index) {
		return child.get(index);
	}

	// get...set...
	public String getGroup() {
		return group;
	}

	public void setGroup(String m_group) {
		this.group = m_group;
	}

	public ArrayList<FoodMenu> getGroupChild() {
		return child;
	}

	public void setGroupChild(ArrayList<FoodMenu> groupChild) {
		this.child = groupChild;
	}

}
