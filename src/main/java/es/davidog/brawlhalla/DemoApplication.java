package es.davidog.brawlhalla;

import es.davidog.brawlhalla.model.PlayerRanked;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Scanner;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Value("${token}")
	private String token;

	@Override
	public void run(String... args) throws Exception {
		int bid = 263827;
		String endpoint = "/ranked";

		StringBuilder builder = new StringBuilder("https://api.brawlhalla.com/player/");
		builder.append(Integer.toString(bid));
		builder.append(endpoint);
		builder.append("?api_key=");
		builder.append(token);
		RestTemplate rest = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.add("User-Agent", "BrawlhallaStatsRequester");
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		ResponseEntity<PlayerRanked> apiResponse = rest.exchange(builder.toString(), HttpMethod.GET, new HttpEntity<String>(headers), PlayerRanked.class);
		if (!apiResponse.getStatusCode().is2xxSuccessful()) {
			System.err.println(apiResponse.getStatusCode().getReasonPhrase());
			System.exit(-1);
		}
		PlayerRanked playerRanked = apiResponse.getBody();
		Scanner s = new Scanner(System.in);
		s.close();
	}
}
