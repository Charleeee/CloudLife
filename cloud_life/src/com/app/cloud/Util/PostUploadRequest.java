package com.app.cloud.Util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;

import android.util.Log;

/**
 * �����ļ���volley 
 * post���� Cookie
 *
 */
public class PostUploadRequest extends Request<JSONObject> {

	private Map<String, String> sendHeader = new HashMap<String, String>();
	/**
	 * ��ȷ���ݵ�ʱ��ص���
	 */
	private Response.Listener<JSONObject> mListener;
	/* ���� ����ͨ����������ʽ���� */
	private String content;
	private FormImage mImage;

	private String BOUNDARY = "----CloudLifeUpLoadImage"; // ���ݷָ���
	private String MULTIPART_FORM_DATA = "multipart/form-data";

	public PostUploadRequest(String url, String text, FormImage Item, Response.Listener<JSONObject> listener,
			Response.ErrorListener errorListener) {
		super(Method.POST, url, errorListener);
		this.mListener = listener;
		setShouldCache(false);
		mImage = Item;
		content = text;
		// �����������Ӧ�¼�����Ϊ�ļ��ϴ���Ҫ�ϳ���ʱ�䣬����������Ӵ��ˣ���Ϊ5��
		setRetryPolicy(new DefaultRetryPolicy(5000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
				DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
	}

	/**
	 * ���￪ʼ��������
	 * 
	 * @param response
	 *            Response from the network
	 * @return
	 */
	@Override
	protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {
		try {
			// ��ֹ��������
			@SuppressWarnings("deprecation")
			String jsonString = new String(response.data, HTTP.UTF_8);

			JSONObject jsonObject = new JSONObject(jsonString);

			Log.w("upLoad", "jsonObject " + jsonObject.toString());

			return Response.success(jsonObject, HttpHeaderParser.parseCacheHeaders(response));
		} catch (UnsupportedEncodingException e) {
			return Response.error(new ParseError(e));
		} catch (JSONException je) {
			return Response.error(new ParseError(je));
		}
	}

	/**
	 * �ص���ȷ������
	 * 
	 * @param response
	 *            The parsed response returned by
	 */
	@Override
	protected void deliverResponse(JSONObject response) {
		mListener.onResponse(response);
	}

	@Override
	public Map<String, String> getHeaders() throws AuthFailureError {
		return sendHeader;
	}

	public void setSendCookie(String cookie) {
		sendHeader.put("Cookie", cookie);
	}

	@Override
	public byte[] getBody() throws AuthFailureError {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();

		StringBuffer sb = new StringBuffer();

		if (content == null) {
			/**
			 * ͼƬ
			 */
			/* ��һ�� */
			// `"--" + BOUNDARY + "\r\n"`
			sb.append("--" + BOUNDARY + "\r\n");

			/* �ڶ��� */
			// Content-Disposition: form-data; name="����������"; filename="�ϴ����ļ���" +
			// "\r\n"
			sb.append("Content-Disposition: form-data;");
			sb.append(" name=\"");
			sb.append(mImage.getName());
			sb.append("\"");
			sb.append("; filename=\"");
			sb.append(mImage.getFileName());
			sb.append("\"");
			sb.append("\r\n");

			/* ������ */
			// Content-Type: �ļ��� mime ���� + "\r\n"
			sb.append("Content-Type: ");
			sb.append(mImage.getMime());
			sb.append("\r\n");

			/* ������ */
			// "\r\n" �հ׵�һ��
			sb.append("\r\n");

			try {
				bos.write(sb.toString().getBytes("utf-8"));
				/* ������ */
				// �ļ��Ķ��������� + "\r\n"
				bos.write(mImage.getValue());
				bos.write("\r\n".getBytes("utf-8"));
			} catch (IOException e) {
				e.printStackTrace();
			}

			/* ��β�� */
			// `"--" + BOUNDARY + "--" + "\r\n"`
			String endLine = "--" + BOUNDARY + "--" + "\r\n";
			try {
				bos.write(endLine.toString().getBytes("utf-8"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			Log.v("upLoad", "=====formImage====\n" + bos.toString());
			return bos.toByteArray();
		}
		/**
		 * ����
		 */
		/* ��һ�� */
		// `"--" + BOUNDARY + "\r\n"`
		sb.append("--" + BOUNDARY + "\r\n");

		/* �ڶ��� */
		// Content-Disposition: form-data; name="text" + "\r\n"
		sb.append("Content-Disposition: form-data;");
		sb.append(" name=\"");
		sb.append("text");
		sb.append("\"");
		sb.append("\r\n");

		/* ������ */
		// "\r\n" �հ׵�һ��
		sb.append("\r\n");

		/* ������ */
		// �ı�����
		sb.append(content);
		sb.append("\r\n");

		if (mImage == null) {
			/* ��β�� */
			// `"--" + BOUNDARY + "--" + "\r\n"`
			String endLine = "--" + BOUNDARY + "--" + "\r\n";
			try {
				bos.write(sb.toString().getBytes("utf-8"));
				bos.write(endLine.toString().getBytes("utf-8"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			Log.v("upLoad", "=====formImage====\n" + bos.toString());
			return bos.toByteArray();
		} else {
			/**
			 * ͼƬ
			 */
			/* ��һ�� */
			// `"--" + BOUNDARY + "\r\n"`
			sb.append("--" + BOUNDARY + "\r\n");

			/* �ڶ��� */
			// Content-Disposition: form-data; name="����������"; filename="�ϴ����ļ���" +
			// "\r\n"
			sb.append("Content-Disposition: form-data;");
			sb.append(" name=\"");
			sb.append(mImage.getName());
			sb.append("\"");
			sb.append("; filename=\"");
			sb.append(mImage.getFileName());
			sb.append("\"");
			sb.append("\r\n");

			/* ������ */
			// Content-Type: �ļ��� mime ���� + "\r\n"
			sb.append("Content-Type: ");
			sb.append(mImage.getMime());
			sb.append("\r\n");

			/* ������ */
			// "\r\n" �հ׵�һ��
			sb.append("\r\n");

			try {
				bos.write(sb.toString().getBytes("utf-8"));
				/* ������ */
				// �ļ��Ķ��������� + "\r\n"
				bos.write(mImage.getValue());
				bos.write("\r\n".getBytes("utf-8"));
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		/* ��β�� */
		// `"--" + BOUNDARY + "--" + "\r\n"`
		String endLine = "--" + BOUNDARY + "--" + "\r\n";
		try {
			bos.write(endLine.toString().getBytes("utf-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Log.v("upLoad", "=====formImage====\n" + bos.toString());
		return bos.toByteArray();
	}

	// Content-Type: multipart/form-data; boundary=----------8888888888888
	@Override
	public String getBodyContentType() {
		return MULTIPART_FORM_DATA + "; boundary=" + BOUNDARY;
	}
}
