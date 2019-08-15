package net.caimito.microservice;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(HerdServiceController.class)
public class HerdServiceControllerTest {

	@Autowired
	private MockMvc mockMvc ;
	
	@MockBean
	private HerdService herdService ;
	
	@Test
	public void getHerdDetails() throws Exception {
		when(herdService.getHerdDetails("Cruzado")).thenReturn(new Herd("Cruzado", 30));
		
		this.mockMvc.perform(get("/herd/Cruzado"))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(content().json("{\"name\":\"Cruzado\",\"animalCount\":30}"));
	}
	
}
