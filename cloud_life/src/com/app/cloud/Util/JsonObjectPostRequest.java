package com.app.cloud.Util;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;

import android.util.Log;

/**
 * Volley Post����
 *  ���Խ��ܺͷ���Cookie
 */
public class JsonObjectPostRequest extends Request<JSONObject> {

	private Map<String, String> mMap;
	private Response.Listener<JSONObject> mListener;

	// ����cookie
	public String cookieFromResponse;
	private Map<String, String> sendHeader = new HashMap<String, String>();

	public JsonObjectPostRequest(String url, Response.Listener<JSONObject> listener,
			Response.ErrorListener errorListener, Map<String, String> map) {
		super(Request.Method.POST, url, errorListener);
		mListener = listener;
		mMap = map;
	}

	// ��http������postʱ������Ҫ��ʹ�øú���������������ӵļ�ֵ��
	@Override
	protected Map<String, String> getParams() throws AuthFailureError {
		return mMap;
	}

	// ��д����������cookie
	@Override
	protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {
		try {

			// ��ֹ��������
			@SuppressWarnings("deprecation")
			String jsonString = new String(response.data, HTTP.UTF_8);

			// ��cookie�ַ�����ӵ�jsonObject�У���jsonObject�ᱻdeliverResponse�ݽ�����������ʱ������onResponse�еõ�
			JSONObject jsonObject = new JSONObject(jsonString);

			// ��ȡcookie�ֶ�
			sendHeader = response.headers;

			// �����ΪһЩԭ��û�з���cookie���ж�
			if (sendHeader.get("Set-Cookie") != null) {
				cookieFromResponse = sendHeader.get("Set-Cookie");
				cookieFromResponse = cookieFromResponse.replace("\n", ";");
				Log.w("cookie", cookieFromResponse);
				jsonObject.put("Cookie", cookieFromResponse);
			}

			Log.w("json", "jsonObject " + jsonObject.toString());

			return Response.success(jsonObject, HttpHeaderParser.parseCacheHeaders(response));

		} catch (UnsupportedEncodingException e) {
			return Response.error(new ParseError(e));
		} catch (JSONException je) {
			return Response.error(new ParseError(je));
		}
	}

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
}