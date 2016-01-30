import java.util.*;

import javax.swing.BoundedRangeModel;


public class MaxHeap {
	public static void main(String[] args) {
		//PriorityQueue<Integer> pq= new PriorityQueue<Integer>(3,Collections.reverseOrder()); // Max heap
		PriorityQueue<Integer> pq= new PriorityQueue<Integer>(3); // Min heap by default
		pq.offer(1);
		pq.offer(2);
		pq.offer(3);
		pq.offer(4);
		pq.offer(5);
		pq.offer(6);
		pq.offer(7);
		pq.offer(8);
		pq.offer(9);
		pq.offer(10);
		Integer val = null;
		while((val = pq.poll()) != null) {
			System.out.println("Value: " + val);
		}
			
	}

}
