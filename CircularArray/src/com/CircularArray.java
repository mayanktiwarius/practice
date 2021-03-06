package com;

import java.util.Iterator;

public class CircularArray<T> {
	private T[] items;
	private int head = 0;
	
	
	public CircularArray(int size) {
		items = (T[]) new Object[size];		
	}
	
	public T[] getArray() {
		return items;
	}
	private int convertIndex(int index) {
		if(index < 0) {
			index += items.length;
		}
		return (head + index) % items.length;
		
	}
	
	public void rotate(int rightSteps) {
		head = convertIndex(rightSteps);
	}
	
	public T get(int index) throws Exception{
		if(index<0 || index >= items.length) {
			throw new Exception("OOB");
		}
		return items[convertIndex(index)];
	}
	public void set(int index, T value) {
		items[convertIndex(index)] = value;
	}
	
	public Iterator<T> getIterator() {
		return new CirclarArrayIterator<T> (this);
	}
	
	public class CirclarArrayIterator <TI> implements Iterator <TI> {

		private int _current=-1;
		private TI[] _items;
		public CirclarArrayIterator(CircularArray<TI> array) {
			_items = array.items;
			
		}
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return _current < _items.length -1;
		}

		@Override
		public TI next() {
			// TODO Auto-generated method stub
			_current++;
			TI item = (TI) _items[convertIndex(_current)];
			return item;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException();
		}

	}
}
