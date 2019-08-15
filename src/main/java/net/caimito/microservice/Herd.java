package net.caimito.microservice;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

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

	public int getAnimalCount() {
		return animalCount;
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj, false) ;
	}
	
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, false) ;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this) ;
	}

}
