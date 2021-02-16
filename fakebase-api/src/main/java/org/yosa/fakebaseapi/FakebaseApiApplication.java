package org.yosa.fakebaseapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableMongoRepositories("org.yosa.fakebasecore.repositories")
@ComponentScan("org.yosa.fakebasecore")
@ComponentScan("org.yosa.fakebaseapi")
public class FakebaseApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FakebaseApiApplication.class, args);
	}

}
