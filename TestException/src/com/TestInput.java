package com;

class WrongInputException extends Exception {
	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	WrongInputException(String s) {
	      super(s);
	   }
	}
	class Input {
	   void method() throws WrongInputException {
	      throw new WrongInputException("Wrong input");
	   }
	}
public	class TestInput {
	   public static void main(String[] args){
	      try {
	         new Input().method();
	      }
		  catch(WrongInputException wie) {
	         System.out.println(wie.getMessage());
	      }
	   } 
	}
