package es.davidog.brawlhalla;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class MainClass {

	public static String TOKEN;
	@Value("${token}")
	private String token;

	public static void main(String[] args) {
		SpringApplication.run(MainClass.class, args);
	}

	@PostConstruct
	private void setToken() {
		TOKEN = token;
	}

}
