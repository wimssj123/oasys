package com.cc.utils;

import com.cc.common.JsonBean;
import com.cc.common.JsonLayBean;

public class JsonUtils {

	public static JsonBean createJsonBean(int code, Object info){
		JsonBean bean = new JsonBean();
		bean.setCode(code);
		bean.setInfo(info);
		
		return bean;
	}

	public  static JsonLayBean createJsonBean(int code, String msg, int count, Object data) {

		return new JsonLayBean(code, msg, count, data);
	}
}
