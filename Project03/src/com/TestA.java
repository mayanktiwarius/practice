package com;

public class TestA {
	public static void main(String args[]) {
		String baseData = "2:(4,4,{{1,2},{1,3},{2,4},{3,4}},2,{{1,4},{2,3}}),(3,3,{{1,2},{1,3},{2,3}},3,{{1,2},{1,3},{2,3}})";
		String baseDelim = ":";
		String baseToken[] = baseData.split(baseDelim);
		int noOfRecords = Integer.parseInt(baseToken[0]);
		System.out.println(noOfRecords);
		String[] tupleData  = new String[noOfRecords];
		int start = 0,end=0,tupleNr =0;
		for(int counter=0; counter<baseToken[1].length(); counter++) {
			if(baseToken[1].charAt(counter) == '(') {
				start = counter;
				continue;
			}
			if(baseToken[1].charAt(counter) == ')') {
				end = counter;
				tupleData[tupleNr++] = baseToken[1].substring(start, end+1);
				TestA.parseFurther(tupleData[tupleNr-1]);
				System.out.println(tupleData[tupleNr-1]);
				continue;
			}
			
		}
	}
	
	public static void parseFurther(String record){
		int noOfPlayers=0;
		int noOfEdges = 0;
		int noOfPairs = 0;
		/*for(int counter=0; counter<record.length(); counter++) {
			if (record.charAt(counter) == '(' || record.charAt(counter) == ')' ) continue;
			
			
		}*/
		System.out.println("parseFurther" + record);
		int counter = 0;
		//System.out.println("Place 1" + counter);
		while(counter < record.length()) {
			if (record.charAt(counter) == '(' || record.charAt(counter) == ')' ){
				counter++;
				continue;
			}
			if(record.charAt(counter) == '{') { // Get till the end of } and send to other function for parsing
				int start = counter;
				int traceBrac = 0;
				while(counter <  record.length()) {
					if(record.charAt(counter) == '{') {
						traceBrac++;
					}
					if(record.charAt(counter) == '}') {
						traceBrac--;
					}
					if (traceBrac == 0) break;
					counter++;
					//System.out.println("Place 2" + counter);
				}
				int end = counter;
				String tuple = record.substring(start,end+1);
				System.out.println(tuple);
				parsePairs(tuple);
			}
			counter++;
			
		  
		}
		
	}
	
	public static int[][] parsePairs(String data) {
		int[][] pairs;
		String delim = ",";
		
		String tokens[] = data.split(delim);
		//pairs = new int[10][2];
		int records = (tokens.length + 1) /2;
		pairs = new int[records][2];
		int counter=0;
		for(int i=0; i<records;i++) {
			for(int j=0; j<2; j++){
				tokens[counter] = tokens[counter].replaceAll("\\{", " "); // Most tricky part in this parsing
				tokens[counter] = tokens[counter].replaceAll("\\}", " ");
				pairs[i][j] = Integer.parseInt(tokens[counter].trim());
				System.out.println(pairs[i][j]);
				counter++;
			
			}
		}
		
		return pairs;
		
	}

}
