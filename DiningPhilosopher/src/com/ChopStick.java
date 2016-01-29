package com;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ChopStick {
	Lock lk;
	String name;
	Semaphore sem;
	
	public ChopStick(int place) {
		lk = new ReentrantLock();
		name = "Chops" + place;
		sem = new Semaphore(1);
	}
	
	public void pickUp(){
		//return lk.tryLock();
		try {
			sem.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}
	
	public void putDown() {
		//lk.unlock();
		sem.release();
	}
}
