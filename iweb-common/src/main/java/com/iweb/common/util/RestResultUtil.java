/**
 * RequestUtil.java
 * com.uxuexi.web.util
 * Copyright (c) 2014, 北京聚智未来科技有限公司版权所有.
*/
package com.iweb.common.util;

import com.iweb.common.exception.IBusinessException;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:FanMingxin
 * @Date: 2018-05-15 下午 04:19
 * @Description:
 */
@Slf4j
public class RestResultUtil {
	private static final String DATA = "data";
	private static final String MESSAGE_KEY = "message";
	private static final String CODE_KEY = "code";

	public static enum StatusCode {
		SUCCESS(0, "成功"), FAIL(-1, "失败");
		private int key;
		private String value;

		private StatusCode(final int key, final String value) {
			this.key = key;
			this.value = value;
		}

		public int key() {
			return key;
		}

		public String value() {
			return value;
		}
	}

	public static Map<String, Object> data(final Object data) {
		return success("ok",data);
	}

	public static Map<String, Object> success(final String message) {
		return success(message,null);
	}

	public static Map<String, Object> success(final String message,final Object data) {
		Map<String, Object> map = new HashMap<>();
		map.put(CODE_KEY, StatusCode.SUCCESS.key());
		map.put(MESSAGE_KEY, message);
		if(data != null){
			map.put(DATA, data);
		}

		return map;
	}

	public static Map<String, Object> error(final String message) {
		return error(StatusCode.FAIL.key(),message);
	}

	public static Map<String, Object> error(int code,final String message) {
		Map<String, Object> map = new HashMap<>();
		map.put(CODE_KEY, code);
		map.put(MESSAGE_KEY, message);
		return map;
	}

	/**
	 * 将异常转换为错误信息
	 *
	 * @param th 异常
	 * @return 错误信息json对象
	 */
	public static Map<String, Object> toMap(final Throwable th) {
		if (th instanceof IBusinessException) {
			return error(StatusCode.FAIL.key(),ExceptionUtil.getSimpleMessage(th));
		}
		log.error(ExceptionUtil.getSimpleMessage(th),th);
		return error(StatusCode.FAIL.key(),ExceptionUtil.getSimpleMessage(th));
	}
}