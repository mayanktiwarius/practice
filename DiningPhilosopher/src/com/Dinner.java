package com;
import com.ChopStick;
import com.Philosopher;

public class Dinner {
	static ChopStick [] chops;
	static Philosopher [] phils;
	
	public static void main(String[] args) {
		setUpDinner();
		
	}
	public static void setUpDinner() {
		chops = new ChopStick[5];
		phils = new Philosopher[5];
		//Instantiate chops
		for (int i = 0; i< 5; i++) {
			chops[i] = new ChopStick(i);
		}
		//instantiate phils
		for (int i = 0; i < 5 ; i++) {
			int left = (i+5 -1) %5;
			int right = i;
			phils[i] = new Philosopher(chops[left], chops[right], left, right);
		}
		// Start the dinner
		while(true){
		for (int i = 0; i < 5; i++) {
			phils[i].start();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
	}

}
