package com.app.cloud.Util;

import java.io.ByteArrayOutputStream;
import android.graphics.Bitmap;

/**
 * �ϴ���ͼ��ʵ����
 *
 */
public class FormImage {

	// ����������
	private String mName;

	// �ļ���
	private String mFileName;

	// �ļ��� mime����Ҫ�����ĵ���ѯ
	private String mMime;

	// ��Ҫ�ϴ���ͼƬ��Դ����Ϊ�������Ϊ�˷��������ֱ�Ӱ� bitmap ����������������Ŀ��һ�㲻���������
	// ���ǰ�ͼƬ��·�����������������ͼƬ���ж�����ת��
	private Bitmap mBitmap = null;

	public FormImage(Bitmap bitmap) {
		this.mBitmap = bitmap;
	}

	public String getName() {
		return "file";
	}

	public String getFileName() {
		return "add.png";
	}

	// ��ͼƬ���ж�����ת��
	public byte[] getValue() {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		mBitmap.compress(Bitmap.CompressFormat.JPEG, 80, bos);
		return bos.toByteArray();
	}

	// ��Ϊ��֪���� png �ļ�������ֱ�Ӹ����ĵ����
	public String getMime() {
		return "image/png";
	}
}
