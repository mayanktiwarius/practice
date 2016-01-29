package com;

public class Cell<K,V> {
	private K key;
	private V value;
	
	public Cell(K key, V value) {
		this.key = key;
		this.value = value;
	}
	public K getKey() { return key;}
	public V getValue() {return value;}
	
	public boolean eqivalent(Cell<K,V> c) {
		return equivalent(c.getKey());
	}
	public boolean equivalent( K k) {
		return key.equals(k);
	}
	

}
