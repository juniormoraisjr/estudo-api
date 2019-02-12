package br.com.estudo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EstudoEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstudoEurekaServerApplication.class, args);
	}
}