package com.amoeba.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.amoeba.processor.FileProcessor;

@Component
public class CustomRoutesBuilder extends RouteBuilder {

	@Autowired
	FileProcessor fileProcessor;
	
	@Value("${input.path}")
	String inbox;
	
	@Value("${output.path}")
	String outbox;
	@Value("${error.path}")
	String errorUrl;
	@Override
	public void configure() throws Exception {

		from(inbox).process(fileProcessor).to(outbox);	
	}

}
