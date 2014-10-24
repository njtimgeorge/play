package util;

import java.util.Date;
import java.util.LinkedList;

// An animal shelter holds only dogs and cats, and operates on a strictly 
// "first in, first out" basis. People must adopt either the "oldest" 
// (based on arrival time) of all animals at the shelter, or they can select 
// whether they would prefer a dog or a cat (and will receive the oldest 
// animal of that type). They cannot select which specific animal they 
// would like. Create the data structures to maintain this system and 
// implement operations such as enqueue, dequeueAny, dequeueDog and 
// dequeueCat.You may use the built-in LinkedList data structure.

public class PetShelterQueue {
	
	public enum critter {
		dog,
		cat
	}
	
	private class PetAdmission {
		private String petName;
		private long admittedOn;
		
		public String getName() {return petName;}
		
		public long getAdmittedOn() {
			return admittedOn;
		}

		PetAdmission(String name) {
			petName = name;
			admittedOn = System.nanoTime();
		}
	}
	
	private LinkedList<PetAdmission> cats;
	private LinkedList<PetAdmission> dogs;
	
	public PetShelterQueue() {
		cats = new LinkedList<PetAdmission>();
		dogs = new LinkedList<PetAdmission>();
	}
	
	public void enqueue(critter type, String name) {
		if(type == critter.cat) cats.addLast(new PetAdmission(name));
		else if(type == critter.dog) dogs.addLast(new PetAdmission(name));
	}

	public String dequeueAny() {
		if(cats.isEmpty() && dogs.isEmpty()) return null;
		
		if(cats.isEmpty())
			return dogs.poll().getName();

		if(dogs.isEmpty())
			return cats.poll().getName();
			
		if(cats.getFirst().getAdmittedOn() < dogs.getFirst().getAdmittedOn())
			return cats.poll().getName();
		else
			return dogs.poll().getName();
	}
	public String dequeueDog() {
		if(dogs.isEmpty()) return null;
		
		return dogs.poll().getName();		
	}
	
	public String dequeueCat() {
		if(cats.isEmpty()) return null;

		return cats.poll().getName();	
	}
}
