package com.amoeba.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class FileProcessor  implements  Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		
		String fileContent = exchange.getIn().getBody(String.class);
		exchange.getIn().setHeader(Exchange.FILE_NAME, "sani");
		
		
	
			//exchange.getIn().setBody(fileContent.toUpperCase());
			exchange.getIn().setBody(fileContent.toLowerCase());

		System.out.println("Headers :"+exchange.getIn().getHeaders());

	}

	
}
