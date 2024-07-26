package com.example.product.demoprojectproduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })

@EnableMongoAuditing
@EnableWebMvc


public class DemoprojectproductApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoprojectproductApplication.class, args);
	}

}
