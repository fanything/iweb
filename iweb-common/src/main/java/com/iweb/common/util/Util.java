/**
 * Util.java
 * com.uxuexi.core.utils
 * Copyright (c) 2011, 北京聚智未来科技有限公司版权所有.
*/

package com.iweb.common.util;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

/**
 * 常用的工具类的集合
 * <p>
 * 包含最常用工具类，比如判空、判断相等等与具体对象无关的方法
 * 
 * @author   fanmingxin
 * @Date	 2018年6月2日
 */
public final class Util {

	/**
	 * 判断一个对象是否为空
	 *
	 * @param obj 任意对象
	 * @return 是否为空
	 */
	public final static boolean isEmpty(final Object obj) {
		if (obj == null) {
			return true;
		}
		if (obj instanceof String) {
			return "".equals(String.valueOf(obj).trim());
		}
		if (obj.getClass().isArray()) {
			return Array.getLength(obj) == 0;
		}
		if (obj instanceof Collection<?>) {
			return ((Collection<?>) obj).isEmpty();
		}
		if (obj instanceof Map<?, ?>) {
			return ((Map<?, ?>) obj).isEmpty();
		}
		if (obj instanceof Optional<?>) {
			Optional<?> result = (Optional<?>) obj;
			return !result.isPresent();
		}
		if (obj instanceof Integer || obj instanceof Long) {
			long value = Long.valueOf(String.valueOf(obj));
			return value <= 0;
		}
		return false;
	}

}
