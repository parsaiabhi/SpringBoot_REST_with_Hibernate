package com.matrix.rest.hibernate.REST_HIBERNATEExample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class RestHibernateExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestHibernateExampleApplication.class, args);
	}
}
