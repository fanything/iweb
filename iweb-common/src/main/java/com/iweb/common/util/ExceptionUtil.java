/**
 * ExceptionUtil.java
 * com.uxuexi.util
 * Copyright (c) 2012, 北京聚智未来科技有限公司版权所有.
*/

package com.iweb.common.util;


import com.iweb.common.exception.IBusinessException;
import com.iweb.common.exception.impl.BusinessException;
import com.sun.corba.se.impl.io.TypeMismatchException;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.BindException;
import java.sql.SQLException;
import static com.iweb.common.util.Util.*;
/**
 * @Author:FanMingxin
 * @Date: 2018-05-16 下午 04:19
 * @Description:
 */
@Slf4j
public final class ExceptionUtil {


	/**
	 * 生成businessException
	 *
	 * @param message 异常信息
	 * @return 业务异常
	 */
	public static BusinessException bEx(final String message, final Object... args) {
		String content = String.format(message, args);
		log.info(content);
		return new BusinessException(content);
	}

	/**
	 * 生成businessException
	 *
	 * @param message 异常信息
	 * @param e 包装的其他异常
	 * @return 业务异常
	 */
	public static BusinessException bEx(final String message, final Throwable e, final Object... args) {
		String content = String.format(message, args);
		log.info(content);
		return new BusinessException(content, e);
	}

	/**
	 * 判断主键是否为空
	 *
	 * @param id 主键
	 * @param msg 提示信息
	*/
	public static void checkId(final Object id, final String msg) {
		if (isEmpty(id)) {
			throw bEx(msg);
		}
	}

	/**
	 * 判断是否为空，如果为空则抛出数据异常
	 * @param obj 判断对象
	 * @param msg 提示信息
	*/
	public static void checkEmpty(final Object obj, final String msg) {
		if (isEmpty(obj)) {
			throw bEx(msg);
		}
	}

	public static String getSimpleMessage(final Throwable th) {
		if (th instanceof IBusinessException) {
			return th.getMessage();
		} else if (th instanceof NullPointerException) {
			return "调用了未经初始化的对象或者是不存在的对象！";
		} else if (th instanceof IOException) {
			return "IO异常！";
		} else if (th instanceof ClassNotFoundException) {
			return "指定的类不存在！";
		} else if (th instanceof ArithmeticException) {
			return "数学运算异常！";
		} else if (th instanceof ArrayIndexOutOfBoundsException) {
			return "数组下标越界!";
		} else if (th instanceof IllegalArgumentException) {
			return "方法的参数错误！";
		} else if (th instanceof ClassCastException) {
			return "类型强制转换错误！";
		} else if (th instanceof SecurityException) {
			return "违背安全原则异常！";
		} else if (th instanceof SQLException) {
			return "操作数据库异常！";
		} else if (th instanceof NoSuchMethodError) {
			return "方法未找到异常！";
		} else if (th instanceof InternalError) {
			return "Java虚拟机发生了内部错误";
		} else if (th instanceof BindException) {
			return "绑定异常";
		} else if (th instanceof TypeMismatchException) {
			return "类型不匹配";
		} else {
			return "程序内部错误，操作失败！";
		}
	}
}
