package com.nhnacademy.project.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.nhnacademy.edu.springframework")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Mainconfig {

}
