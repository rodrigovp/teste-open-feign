package br.org.rodnet.testeopenfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TesteOpenFeignApplication {

	public static void main(String[] args) {
		SpringApplication
				.run(TesteOpenFeignApplication.class, args);
	}

}
