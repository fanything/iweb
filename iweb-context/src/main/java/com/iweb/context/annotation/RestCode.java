/**
 * Void.java
 * com.we.core.web.annotation
 * Copyright (c) 2017, 北京聚智未来科技有限公司版权所有.
*/

package com.iweb.context.annotation;

import java.lang.annotation.*;

/**
 * @Author:FanMingxin
 * @Date: 2018-05-09 下午 02:28
 * @Description:分页
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RestCode {

}
