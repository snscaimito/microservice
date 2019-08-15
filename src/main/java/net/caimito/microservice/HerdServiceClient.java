package net.caimito.microservice;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HerdServiceClient {

	private final RestTemplate restTemplate ;
	
	public HerdServiceClient(RestTemplateBuilder restTemplateBuilder) {
		restTemplate = restTemplateBuilder.build() ;
	}
	
	public Herd getHerdDetails(String herdName) {
		return restTemplate.getForObject("/herd/{herdName}", Herd.class, herdName) ;
	}
	
}
