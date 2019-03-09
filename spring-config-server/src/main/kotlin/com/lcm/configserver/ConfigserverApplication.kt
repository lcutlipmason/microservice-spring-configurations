package com.lcm.configserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.boot.runApplication
import org.springframework.cloud.config.server.EnableConfigServer
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableConfigServer
public class ConfigserverApplication 
	fun main(args: Array<String>) {
		SpringApplicationBuilder(ConfigserverApplication::class.java).properties("spring-config-name:spring-config-srv")
				.build().run(*args)
	}
