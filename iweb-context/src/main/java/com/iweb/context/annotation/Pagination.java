package com.iweb.context.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 分页
 * <p>
 * 添加该注解，返回结果会自动添加上分页的数据格式。一般用于controller
 *
 * @author   fanmingxin
 * @Date	 2018年4月12日
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Pagination {

}
