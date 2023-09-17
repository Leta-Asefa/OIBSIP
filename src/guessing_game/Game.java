package guessing_game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {

	private int randomNumber = 0;
	private int guessedValue = 0;
	private int trials=0;
	private Scanner input = null;

	public Game() {
		input = new Scanner(System.in);
		updateRandomNumber();
		askToGuess();
		acceptValue();
		checkValue();
	}

	public void askToGuess() {
		drawLine();
		System.out.println(" \t\t\t\t\tGuessing Game  ( Task 1 )");
		System.out.println(" \t\t\t\t\tGuess between 1 and 10");
		drawLine();
	}

	public void acceptValue() {
		
		System.out.println(" \t\t\t\t\tGuess . . .");
		try {
			guessedValue = input.nextInt();
			trials++;
		}
		catch(InputMismatchException e) {
			System.out.println(" \t\t\t\t\tplese enter a number only !");
			input.next(); // to consume the enter character in the buffer
			this.acceptValue();
		}
	}

	public void updateRandomNumber() {
		randomNumber = (int) (Math.random() * 10);
		trials=0;
		//System.out.println(randomNumber);
	}

	private void checkValue() {

		if(guessedValue==randomNumber) {
			drawLine();
			System.out.println(" \t\t\t\t\tYou Got It ! (Total Trials = "+ trials + ")");
			System.out.println(" \t\t\t\t\tRestart = 1  :  Quit = any character  . . . ");
			drawLine();
			String bool=input.next();
			if(bool.equals("1")) 
					restart();
			else quit();
		
		}
		else if(guessedValue<randomNumber) {
			
			System.out.println(" \t\t\t\t\t(Lower) Try again . . . \n");
			drawLine();
			acceptValue();
			checkValue();
			
		}
		else {
			
			System.out.println(" \t\t\t\t\t(Higher) Try again . . . \n");
			drawLine();
			acceptValue();
			checkValue();
		}
	}

	private void  quit() {
		System.exit(1);
	}

	private void restart() {
		updateRandomNumber();
		askToGuess();
		acceptValue();
		checkValue();	
	}
	public void drawLine(){
		System.out.println(" \t\t\t\t\t################################");
	}
}
