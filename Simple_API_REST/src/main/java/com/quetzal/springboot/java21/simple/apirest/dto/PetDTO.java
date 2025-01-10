package com.quetzal.springboot.java21.simple.apirest.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class PetDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String species;
	private String race;
	private String color;
	private LocalDateTime  birthdate;
	private Long weight;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public LocalDateTime getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(LocalDateTime birthdate) {
		this.birthdate = birthdate;
	}
	public Long getWeight() {
		return weight;
	}
	public void setWeight(Long weight) {
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return "PetDTO [name=" + name + ", species=" + species + ", race=" + race + ", color=" + color + ", birthdate="
				+ birthdate + ", weight=" + weight + "]";
	}

}
