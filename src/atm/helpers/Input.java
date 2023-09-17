package atm.helpers;

import java.util.Scanner;

public class Input {

	private static Scanner input=null;

	public static Scanner getInstance() {
		if(input!=null) 
			return input;
		else {
			input=new Scanner(System.in);
			return input;
		} 
		
	}

	
	
	
}
