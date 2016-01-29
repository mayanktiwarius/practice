package com;
import com.ChopStick;

public class Philosopher extends Thread{
	ChopStick leftChopstick;
	ChopStick rightChopstick;
	String name;
	int philNr;
	
	public Philosopher(ChopStick left, ChopStick right, int leftnr, int rightnr){
		leftChopstick = left;
		rightChopstick = right;
		name = "Phils" + leftnr + rightnr;
		philNr = rightnr;
	}
	
	
	/*public void eat() {
		System.out.println(name + " picking left chopstick");
		if(!leftChopstick.pickUp()) {
			return;
		}
		System.out.println(name + " picking left chopstick");
		if(!rightChopstick.pickUp()) {
			leftChopstick.putDown();
			return;
		}
		System.out.println(name + " eating");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(name + " placing back chopsticks");
		rightChopstick.putDown();
		leftChopstick.putDown();
		System.out.println(name + " done with eating");
		return;
	}*/
	
	// Odd phil pick left and then right
	// even phil picks right and then left
	
	public void eat() {
		if (philNr % 2 == 0) {
			// Even right and then left
			System.out.println(name + " picking chopstick");
			rightChopstick.pickUp();
			leftChopstick.pickUp();
			try {
				System.out.println(name + " eating");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(name + " placing back chopsticks");
			leftChopstick.putDown();
			rightChopstick.putDown();
		} else {
			// Odd left and then right
			System.out.println(name + " picking chopstick");

			leftChopstick.pickUp();
			rightChopstick.pickUp();
			try {
				System.out.println(name + " eating");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(name + " placing back chopsticks");
			rightChopstick.putDown();
			leftChopstick.putDown();
			
		}
	}
	
	
	public void run() {
		for(int i = 0; i < 10; i++) {
			eat();
		}
	}
	

}
