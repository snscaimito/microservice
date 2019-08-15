package net.caimito.microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/herd")
public class HerdServiceController {
	
	@Autowired
	private HerdService herdService ;

	@GetMapping(value = "/{name}")
	public Herd getHerdDetails(@PathVariable("name") String name) {
		return herdService.getHerdDetails(name) ;		
	}
	
}
