package com.iweb.api.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.iweb.api.mapper*")
public class MybatisPlusConfig {
}
