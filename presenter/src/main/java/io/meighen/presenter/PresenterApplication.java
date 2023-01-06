package io.meighen.presenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PresenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(PresenterApplication.class, args);
	}

}
