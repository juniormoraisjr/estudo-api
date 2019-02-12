package br.com.estudo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class EstudoApiConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstudoApiConfigApplication.class, args);
	}
}