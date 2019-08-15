package net.caimito.microservice;

public class Herd {

	private String name ;
	
	private int animalCount ;

	public Herd(String name, int animalCount) {
		this.name = name ;
		this.animalCount = animalCount ;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAnimalCount() {
		return animalCount;
	}

	public void setAnimalCount(int animalCount) {
		this.animalCount = animalCount;
	}
	
}
