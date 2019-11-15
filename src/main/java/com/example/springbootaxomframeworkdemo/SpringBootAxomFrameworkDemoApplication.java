package com.example.springbootaxomframeworkdemo;

import com.example.springbootaxomframeworkdemo.config.SwaggerConfig;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(SwaggerConfig.class)
public class SpringBootAxomFrameworkDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAxomFrameworkDemoApplication.class, args);
	}


}
