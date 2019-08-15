package net.caimito.microservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HerdEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name ;
	
	private int animalCount ;
	
	public HerdEntity() {
	}
	
	public HerdEntity(String name, int animalCount) {
		this.name = name ;
		this.animalCount = animalCount ;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAnimalCount() {
		return animalCount;
	}
}
