package com;

public class Program {
	
	public static void main(String args[]) {
		String data = "2:(4,4,{{1,2},{1,3},{2,4},{3,4}},2,{{1,4},{2,3}}),(3,3,{{1,2},{1,3},{2,3}},3,{{1,2},{1,3},{2,3}})";
		String delim1 = ":";
		String token01[] = data.split(delim1);
		int datasetcount = Integer.parseInt(token01[0]);
		System.out.println(datasetcount);
		String delim2 = "),(";
		String token02[] = token01[1].split(delim2);
		for (int i=0; i<token02.length; i++) {
			System.out.println(token02[i]);
		}
		
		
	}

}
