package org.yosa.fakebaseweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;


@SpringBootApplication
@EnableMongoRepositories("org.yosa.fakebasecore.repositories")
@ComponentScan("org.yosa.fakebasecore")
public class FakebaseWebApplication{

	public static void main(String[] args) {
		SpringApplication.run(FakebaseWebApplication.class, args);
	}

}
