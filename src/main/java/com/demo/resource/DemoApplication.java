package com.demo.resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
//		Map<String, Object> prop = new HashMap<String, Object>();
//		prop.put("server.port", "8089");
		SpringApplication.run(DemoApplication.class, args);
//		app.setDefaultProperties(prop);
//		app.run(args);

	}
}
