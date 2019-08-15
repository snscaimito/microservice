package net.caimito.microservice;

import org.springframework.data.repository.CrudRepository;

public interface HerdRepository extends CrudRepository<HerdEntity, Long> {

	public HerdEntity findByName(String name);

}
