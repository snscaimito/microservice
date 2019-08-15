package net.caimito.microservice;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@RestClientTest(HerdServiceClient.class)
public class ConsumerTest {
	
	@Autowired
	private HerdServiceClient client ;
	
	@Autowired
	private MockRestServiceServer server ;
	
	@Autowired
	private ObjectMapper objectMapper ;
	
	@Before
	public void setUp() throws Exception {
		String detailsString = objectMapper.writeValueAsString(new Herd("Casita", 30)) ;
		
		this.server.expect(requestTo("/herd/Casita")).andRespond(withSuccess(detailsString, MediaType.APPLICATION_JSON)) ;
	}
	
	@Test
	public void getHerdDetails() {
		Herd herd = this.client.getHerdDetails("Casita") ;
		
		assertThat(herd.getName(), is("Casita")) ;
		assertThat(herd.getAnimalCount(), is(30)) ;
	}

}
