import java.util.*;


public class MaxHeap {
	public static void main(String[] args) {
		//PriorityQueue<Integer> pq= new PriorityQueue<Integer>(10,Collections.reverseOrder());
		PriorityQueue<Integer> pq= new PriorityQueue<Integer>(10);
		pq.offer(1);
		pq.offer(2);
		pq.offer(3);
		Integer val = null;
		while((val = pq.poll()) != null) {
			System.out.println("Value: " + val);
		}
			
	}

}
