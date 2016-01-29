package com;

import java.io.*;
import java.util.ArrayList;

public class TrieTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
		try {
			System.out.println("Enter the string");
			
			String data = br.readLine();
			SuffixTree st = new SuffixTree(data);
			System.out.println("Enter the substring that you want to search");
			String pattern = br.readLine();
			ArrayList<Integer> positions = st.search(pattern);
			System.out.println("Positions: " + positions);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		

	}

}
