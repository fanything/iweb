/**
 * ConvertUtil.java
 * com.uxuexi.common.util
 * Copyright (c) 2014, 北京聚智未来科技有限公司版权所有.
*/

package com.iweb.common.util;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;

import javax.activation.MailcapCommandMap;
import java.lang.reflect.*;
import java.util.*;

/**
 * 类型转换工具类
 * 
 * @author   庄君祥
 * @Date	 2014-4-3 
 */
public final class ConvertUtil {

	/**
	 * 对象转换成字符串
	 * @param o 对象
	 * @return 字符串,如果为null，则返回空串
	 */
	public static String obj2str(final Object o) {
		if (o == null) {
			return "";
		}
		return String.valueOf(o);
	}

	/**
	 * 通用的将对象转换为map的方法
	 *
	 * @param obj 待转化的对象
	 * @return map
	 */
	private static Map<String, Object> obj2Map(final Object obj){
		if(obj == null){
			return null;
		}

		Map<String, Object> map = MapUtil.map();
		try {
			Field[] declaredFields = obj.getClass().getDeclaredFields();
			for (Field field : declaredFields) {
				field.setAccessible(true);
				map.put(field.getName(), field.get(obj));
			}
		} catch (Exception e) {
			map = null;
		}

		return map;
	}

	/**
	 * map转换为对象
	 *
	 * @param map 源map
	 * @param toType 对象类别
	 * @return 对象
	 */
	public static <T> T map2Object(final Map<?, ?> map, final Class<T> toType){
		if (map == null){
			return null;
		}

		T obj;
		try {
			obj = toType.newInstance();

			Field[] fields = obj.getClass().getDeclaredFields();
			for (Field field : fields) {
                int mod = field.getModifiers();
                if(Modifier.isStatic(mod) || Modifier.isFinal(mod)){
                    continue;
                }

                field.setAccessible(true);
                field.set(obj, map.get(field.getName()));
            }
		} catch (Exception e) {
			obj = null;
		}

		return obj;
	}

	/**
	 * 转为DTO
	 *
	 * @param obj 对象
	 * @param clazz 类名
	 * @return 对象
	 */
	public static <T> Object obj2Dto(Object obj, Class<T> clazz) {
		if (null == obj)
			return null;

		if (obj.getClass().isArray()) {
			List<Object> list = new ArrayList<>();
			int len = Array.getLength(obj);
			for (int i = 0; i < len; i++) {
				list.add(item2Dto(Array.get(obj, i), clazz));
			}
			return list;
		}

		if (obj instanceof Collection) {
			List<Object> list = new ArrayList<>();
			for (Iterator<T> it = ((Collection<T>) obj).iterator(); it.hasNext();) {
				list.add(item2Dto(it.next(), clazz));
			}
			return list;
		}

		return item2Dto(obj, clazz);
	}

	/**
	 * 单实体转Dto
	 *
	 * @param obj 对象
	 * @param clazz dto类
	 * @return 对象
	 */
	private static <T> Object item2Dto(Object obj, Class<T> clazz) {

		if (obj instanceof Map || obj instanceof String) {
			return obj;
		}

		if (obj instanceof Number) {
			Map<String, Object> result = MapUtil.map();
			result.put("id", obj);
			return result;
		}

		T dto = null;
		try {
			dto = clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw ExceptionUtil.bEx("DTO对象创建失败", e);
		}

		BeanUtils.copyProperties(obj, dto);
		return dto;
	}

	public static void main(String[] args){
		Integer a = 1;
		System.out.print(ConvertUtil.obj2str(a));
	}
}
