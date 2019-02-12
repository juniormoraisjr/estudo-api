package br.com.estudo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EstudoLicencaSoftwareServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstudoLicencaSoftwareServerApplication.class, args);
	}
}