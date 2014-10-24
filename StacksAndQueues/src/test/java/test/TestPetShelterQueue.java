package test;

import static org.junit.Assert.*;

import org.junit.Test;

import util.PetShelterQueue;
import util.PetShelterQueue.critter;

public class TestPetShelterQueue {

	// Empty list
	@Test
	public void TestEmptyList() {
		PetShelterQueue psq = new PetShelterQueue();
		
		assertNull(psq.dequeueAny());
		assertNull(psq.dequeueCat());
		assertNull(psq.dequeueDog());
	}

	// Empty list
	@Test
	public void TestDogList() {
		PetShelterQueue psq = new PetShelterQueue();
		
		psq.enqueue(critter.dog, "Mr Barky");
		psq.enqueue(critter.dog, "Rex");
		psq.enqueue(critter.dog, "Fideaux");
		
		assertEquals(psq.dequeueAny(), "Mr Barky");
		assertNull(psq.dequeueCat());
		assertEquals(psq.dequeueDog(), "Rex");
	}

	// Empty list
	@Test
	public void TestCatList() {
		PetShelterQueue psq = new PetShelterQueue();
		
		psq.enqueue(critter.cat, "Boots");
		psq.enqueue(critter.cat, "Mittens");
		psq.enqueue(critter.cat, "Puss In Boots");
		
		assertEquals(psq.dequeueAny(), "Boots");
		assertNull(psq.dequeueDog());
		assertEquals(psq.dequeueCat(), "Mittens");
	}
	
	@Test
	public void TestMixedList() {
		PetShelterQueue psq = new PetShelterQueue();
		
		psq.enqueue(critter.cat, "Boots");
		psq.enqueue(critter.cat, "Mittens");
		psq.enqueue(critter.dog, "Mr Barky");
		psq.enqueue(critter.dog, "Rex");
		psq.enqueue(critter.cat, "Puss In Boots");
		psq.enqueue(critter.dog, "Fideaux");		

		assertEquals(psq.dequeueAny(), "Boots");
		assertEquals(psq.dequeueAny(), "Mittens");
		assertEquals(psq.dequeueAny(), "Mr Barky");
		assertEquals(psq.dequeueCat(), "Puss In Boots");
	}
}
