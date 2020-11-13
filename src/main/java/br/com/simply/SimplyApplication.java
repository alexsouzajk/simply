package br.com.simply;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SimplyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimplyApplication.class, args);
	}

}
