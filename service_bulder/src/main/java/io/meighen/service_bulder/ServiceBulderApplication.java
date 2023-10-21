package io.meighen.service_bulder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServiceBulderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceBulderApplication.class, args);
	}

}
