package com;


public class HashTest {
	public static void main(String[] args) {
		Hash<String,Integer> hash = new Hash<String,Integer> ();
		hash.put("Mayank",1);
		hash.put("Shivangi", 2);
		hash.put("Xxxxxx",3);
		int value = hash.get("Shivangi");
		System.out.println("Value is" + value);
		hash.remove("Shivangi");
		value = hash.get("Xxxxxx");
		System.out.println("Value for Xxxxxx is" + value);
		
		
	}

}
