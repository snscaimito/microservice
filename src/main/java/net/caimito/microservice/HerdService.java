package net.caimito.microservice;

import org.springframework.stereotype.Service;

@Service
public class HerdService {

	private final HerdRepository herdRepository;

	public HerdService(HerdRepository herdRepository) {
		this.herdRepository = herdRepository ;
	}

	public Herd getHerdDetails(String name) {
		HerdEntity entity = herdRepository.findByName(name) ;
		
		return new Herd(entity.getName(), entity.getAnimalCount()) ;
	}

}
