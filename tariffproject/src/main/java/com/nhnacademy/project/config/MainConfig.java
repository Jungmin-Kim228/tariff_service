package com.nhnacademy.project.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.nhnacademy")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class MainConfig {

}
