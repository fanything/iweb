package com.iweb.common.util;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 有关map处理的工具类
 * 
 * @author   fanmingxin
 * @Date	 2018年4月12日
 */
public final class MapUtil {

	/**
	 * 
	 * 较方便的创建一个map
	 * <p>
	 * 注，这里的 Map，是 HashMap 的实例
	 * 
	 * @param <K> key的类型
	 * @param <V> value的类型
	 * @return map对象
	 */
	public static <K, V> Map<K, V> map() {
		return new HashMap<K, V>();
	}

	/**
	 * 
	 * 较方便的创建一个map
	 * <p>
	 * 注，这里的 Map线程安全，是 ConcurrentHashMap的实例
	 * 
	 * @param <K> key的类型
	 * @param <V> value的类型
	 * @return map对象
	 */
	public static <K, V> Map<K, V> concurrentMap() {
		return new ConcurrentHashMap<K, V>();
	}

	/**
	 * 
	 * 较方便的创建一个map
	 * <p>
	 * 注，这里的 Map，是 HashMap 的实例
	 * 
	 * @param <K> key的类型
	 * @param <V> value的类型
	 * @param key 键
	 * @param value 值
	 * @return map对象，包含key、value
	 */
	public static <K, V> Map<K, V> map(final K key, final V value) {
		Map<K, V> map = map();
		map.put(key, value);
		return map;
	}

	/**
	 * 较方便的创建一个map
	 * <p>
	 * 奇数个作为key，偶数个作为value 生成map对象
	 * 请注意数据的类型，要是不匹配，在获取时会提示 java.lang.ClassCastException
	 * @param args 参数
	 * @return map对象
	 */
	public static <K, V> Map<K, V> map(final Object... args) {
		Map<K, V> map = map();
		evenoddMap(map, args);
		return map;
	}

	/**
	 * 将数据奇数个作为key，偶数个作为value，填充到对象中
	 * 请注意数据的类型，要是不匹配，在获取时会提示 java.lang.ClassCastException
	 * @param <K> key的类型
	 * @param <V> value的类型
	 * @param map 填充的map
	 * @param args 参数列表
	 */
	@SuppressWarnings({ "unchecked" })
	private static <K, V> void evenoddMap(final Map<K, V> map, final Object... args) {
		if (args.length % 2 != 0) {
			throw ExceptionUtil.bEx("生成map时,元素为单数!");
		}
		for (int i = 0; i < args.length; i += 2) {
			map.put((K) args[i], (V) args[i + 1]);
		}
	}

	/**
	 * 
	 * 较方便的创建一个map
	 * <p>
	 * 注，这里的 Map，是 LinkedHashMap 的实例
	 * 
	 * @param <K> key的类型
	 * @param <V> value的类型
	 * @return map对象
	 */
	public static <K, V> Map<K, V> linkedMap() {
		return new LinkedHashMap<K, V>();
	}

	/**
	 * 
	 * 较方便的创建一个map
	 * <p>
	 * 注，这里的 Map，是 LinkedHashMap 的实例
	 * 
	 * @param <K> key的类型
	 * @param <V> value的类型
	 * @param key 键
	 * @param value 值
	 * @return map对象，包含key、value
	 */
	public static <K, V> Map<K, V> linkedMap(final K key, final V value) {
		Map<K, V> map = linkedMap();
		map.put(key, value);
		return map;
	}

	/**
	 * 较方便的创建一个LinkedHashMap
	 * <p>
	 * 奇数个作为key，偶数个作为value 生成map对象
	 * @param args 参数
	 * @return map对象
	 */
	public static <K, V> Map<K, V> linkedMap(final Object... args) {
		Map<K, V> map = linkedMap();
		evenoddMap(map, args);
		return map;
	}
}
