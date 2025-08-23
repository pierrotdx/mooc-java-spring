package com.mycompany.invoise;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"com.mycompany.invoise.repository.memory", "com.mycompany.invoise.service.prefix", "com.mycompany.invoise.controller.web"})
@PropertySource("classpath:application.properties")
public class AppConfig {}
