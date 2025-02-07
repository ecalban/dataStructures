package application;

public class Animal {

	Long animalId;
	String animalKind;
	String animalName;
	int animalAge;
	Animal next;
	
	Animal(Long animalId, String animalKind, String animalName, int animalAge){
		this.animalId = animalId;
		this.animalKind = animalKind;
		this.animalName = animalName;
		this.animalAge = animalAge;
		next = null;
	}
}
