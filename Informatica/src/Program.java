import javax.swing.text.html.MinimalHTMLWriter;

//{{5, 7, 2, 4},  {1, 8, 1, 3},  {6, 2, 9, 5}, {1, 6, 2, 8}}; 

public class Program {
	static Integer[][] matrix;
	static int globalRowLength;
	static int globalColLength;
	static String[][] path;
	/*public static void main(String args[]) {
		Program p = new Program();
		//int[][] matrix = null;
		int content;
		p.test();
		System.out.println("Hello World");
		String data = "{{5, 7, 2, 4},  {1, 8, 1, 3},  {6, 2, 9, 5},  {1, 6, 2, 8}}";
		String delim1 = "},";
		String token1[] = data.split(delim1);
		int matrixSize = token1.length;
		matrix = new Integer[matrixSize][matrixSize];
		for(int i=0; i< token1.length; i++) {
			token1[i] = token1[i].replace('{', ' ');
			token1[i] = token1[i].replace('}', ' ');
			String delim2 = ",";
			String token2[] = token1[i].split(delim2);
			for(int j=0; j< token2.length; j++) {
				//System.out.println(token2[j]);
				matrix[i][j] = Integer.parseInt(token2[j].trim());
			}
			
		}
		for(int i=0; i< matrixSize; i++) {
			for(int j=0; j<matrixSize;j++) {
				System.out.println(matrix[i][j]);
			}
		}
		
	}*/
	
	public static void main(String args[]) {
		Program p = new Program();
		//int[][] matrix = null;
		int content;
		p.test();
		System.out.println("Hello World");
		String data = "{2#6#8#6#9,2#5#5#5#0,1#3#8#8#7,3#2#0#6#9,2#1#4#5#8,5#6#7#4#7}";
		String delim1 = ",";
		String token1[] = data.split(delim1);
		int rowLength = token1.length;
		String delim2 = "#";
		String tokenTemp[] =token1[0].split(delim2);
		int colLength = tokenTemp.length;
		matrix = new Integer[rowLength][colLength];
		globalRowLength = rowLength;
		globalColLength = colLength;
		path = new String[globalRowLength][globalColLength];
		for(int i=0; i< token1.length; i++) {
			token1[i] = token1[i].replace('{', ' ');
			token1[i] = token1[i].replace('}', ' ');		
			String token2[] = token1[i].split(delim2);
			for(int j=0; j< token2.length; j++) {
				//System.out.println(token2[j]);
				matrix[i][j] = Integer.parseInt(token2[j].trim());
			}
			
		}
		for(int i=0; i< rowLength; i++) {
			for(int j=0; j<colLength;j++) {
				//System.out.println(matrix[i][j]);
			}
		}
		int cost = shortestPath(0, 0, globalRowLength-1, globalColLength-1);
		System.out.println("Cost is:" + cost);
		System.out.println("Path is: " + path[0][0]);
		
	}
	
	public static int shortestPath(int thisRow, int thisColumn, int destRow, int destColumn) {
		//System.out.println("thisRow:" + thisRow + thisColumn + destRow + destColumn);
		int horCost=0, verCost=0;
		int minCost = 0;
		if( thisRow == destRow && thisColumn == destColumn) {
			path[destRow][destColumn]= "";
			return matrix[destRow][destColumn];
		}
		if(thisRow + 1 == globalRowLength) { //Check next column and return	
			minCost = matrix[thisRow][thisColumn] + shortestPath(thisRow, thisColumn+1, destRow, destColumn);
			path[thisRow][thisColumn] = "H".concat(path[thisRow][thisColumn+1]);
			return minCost;
		}
		if (thisColumn +1 == globalColLength) { // Check next row
			minCost = matrix[thisRow][thisColumn]+ shortestPath(thisRow+1, thisColumn, destRow, destColumn);
			path[thisRow][thisColumn] = "V".concat(path[thisRow + 1][thisColumn]);
			return minCost;
		}
		horCost = shortestPath(thisRow, thisColumn+1, destRow, destColumn);
		verCost = shortestPath(thisRow+1, thisColumn, destRow, destColumn);
		
		if (horCost < verCost) {
			minCost = matrix[thisRow][thisColumn] + horCost;
			path[thisRow][thisColumn] = "H".concat(path[thisRow][thisColumn+1]);
		} else {
			minCost = matrix[thisRow][thisColumn] + verCost;
			path[thisRow][thisColumn] = "V".concat(path[thisRow + 1][thisColumn]);
		}
		return minCost;
		//return minimum(matrix[thisRow][thisColumn] + shortestPath(thisRow, thisColumn+1, destRow, destColumn),
		//		matrix[thisRow][thisColumn]+shortestPath(thisRow+1, thisColumn, destRow, destColumn));
	
	}
	public static int minimum(int a, int b) {
		if(a <= b ) return a;
		return b;
	}
	public void test(){
		System.out.println("Hello Test");
	}
}
