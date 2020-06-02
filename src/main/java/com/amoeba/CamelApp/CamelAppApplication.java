package com.amoeba.CamelApp;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.spring.SpringCamelContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.amoeba.routes.CustomRoutesBuilder;

@ComponentScan("com.amoeba.processor")
@SpringBootApplication
//@ImportResource("${classpath:spring/camel-context.xml}")
public class CamelAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CamelAppApplication.class, args);
		
	}
	@Bean
	SpringCamelContext cameContext(ApplicationContext context) {
		SpringCamelContext  springCamelContext = null;
		try {
			springCamelContext = new  SpringCamelContext(context);
			springCamelContext.addRoutes(customRouteBuilder());
			
		}
		catch(Exception  e) {
			e.printStackTrace();
		}
		return springCamelContext;
		
	}

	@Bean
	RouteBuilder  customRouteBuilder() {
		return new CustomRoutesBuilder();
	}
}
