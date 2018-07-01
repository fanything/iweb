package com.iweb.context.aop;

import com.iweb.common.util.MapUtil;
import com.iweb.common.util.Util;
import com.iweb.context.page.Page;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

/**
 * 分页切面
 *
 * @author   fanmingxin
 * @Date	 2018年4月12日
 */
@Component
@Aspect
@Order(3)
public class PageAspect {

	@Value("${pagination.pageSize:10}")
	private String pageSize;

	/**
	 * 填充分页信息
	 *
	 * @param pjp 切点
	 * @return 分页格式的数据
	 * @throws Throwable 方法执行错误的时候会抛此异常
	*/
	@Around("@annotation(com.iweb.context.annotation.Pagination)")
	@Order(2)
	public Object setPageInfos(final ProceedingJoinPoint pjp) throws Throwable {
		Page page = getPage(pjp.getArgs());
		if (Util.isEmpty(page)) {
			page = new Page();
		}

		Object list = pjp.proceed();
		Map<String, Object> map = MapUtil.map();
		map.put("list", list);
		map.put("page", page);
		return map;
	}

	/**
	 * 设置分页默认值
	 * <p>
	 * 如果分页没有设置值，则默认从系统的配置文件里读取
	 *
	 * @param jp 切点
	*/
	@Before("@annotation(com.iweb.context.annotation.Pagination)")
	@Order(1)
	public void setDefaultPageSize(final JoinPoint jp) {
		Page page = getPage(jp.getArgs());
		if (Util.isEmpty(page) || page.getPageSize() > 0) {
			return;
		}
		page.setPageSize(pageSize!=null ? Integer.parseInt(pageSize):0);
	}

	/**
	 * 获取分页对象
	 *
	 * @param args 参数
	 * @return 分页对象。如果参数里没有分页对象，则返回null
	*/
	private Page getPage(final Object[] args) {
		Optional<Object> page = Arrays.stream(args).filter(arg -> arg instanceof Page).findFirst();
		if (!page.isPresent()) {
			return null;
		}
		return (Page) page.get();
	}
}
