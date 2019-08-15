package net.caimito.microservice;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class HerdServiceTest {

	@Mock
	private HerdRepository herdRepository ;
	
	private HerdService herdService ;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		herdService = new HerdService(herdRepository) ;
	}
	
	@Test
	public void getHerdDetails() {
		when(herdRepository.findByName("Cruzado")).thenReturn(new HerdEntity("Cruzado", 30)) ;
		
		assertThat(herdService.getHerdDetails("Cruzado"), is(new Herd("Cruzado", 30))) ;
	}
	
}
