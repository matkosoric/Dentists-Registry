package edu.matko.soric.dentists;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

//		Map<String, Object> configMap = new HashMap<>();
//		configMap.put("SERVER_CONTEXT_PATH", "/dentists-application");
//
//
//		SpringApplication springApplication = new SpringApplication(Application.class);
//		springApplication.setDefaultProperties(configMap);
//		springApplication.run(args);

		SpringApplication.run(Application.class, args);
	}
}
