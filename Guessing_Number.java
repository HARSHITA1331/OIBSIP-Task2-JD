package OIBSIP;

import java.util.*;

class The_Guessing_Game {
	
	int systemInput;
	int userInput;
	int noOfGuesses = 0;
	
	// Generating random number in default constructor
	The_Guessing_Game() {
		Random random = new Random();
		this.systemInput = random.nextInt(100) + 1;
	}
	
	
	//Taking user guesses
	public boolean UserInput() {
		if ( noOfGuesses < 5 ) {
			System.out.print("Guess a number : ");
			this.userInput = Guessing_Number.takeIntegerInput(100);
			noOfGuesses++;
			return false;
		}
		else {
			System.out.println("Number of attempts finished...Better luck next time\n");
			return true;
		}
	}
	
	
	//Checking user guess status
	public boolean CorrectGuess() {
		
		if ( systemInput == userInput ) {
			System.out.println("Congratulations, you guess the number " + systemInput +" in " + noOfGuesses + " guesses");
			switch(noOfGuesses) {
				case 1:
				System.out.println("Your score is 100");
				break;
				case 2:
				System.out.println("Your score is 80");
				break;
				case 3:
				System.out.println("Your score is 60");
				break;
				case 4:
				System.out.println("Your score is 40");
				break;
				case 5:
				System.out.println("Your score is 20");
				break;
			}
			System.out.println();
			return true;
		}
		else if ( noOfGuesses < 5 && userInput > systemInput ) {
			if ( userInput - systemInput > 5 ) {
				System.out.println("Too High");
			}
			else {
				System.out.println("Little High");
			}
		}
		else if ( noOfGuesses < 5 && userInput < systemInput ) {
			if ( systemInput - userInput > 5 ) {
				System.out.println("Too low");
			}
			else {
				System.out.println("Little low");
			}
		}
		return false;
	}
}


public class Guessing_Number {

	// static method to take integer input without any limit and exception error exception handling and input limit handling
		public static int takeIntegerInput(int limit) {
			int input = 0;
			boolean flag = false;
			
			while ( !flag ) {
				try {
					Scanner sc = new Scanner(System.in);
					input = sc.nextInt();
					flag = true;
					
					if ( flag && input > limit || input < 1 ) {
						System.out.println("Choose the number between 1 to " + limit);
						flag = false;
					}
				}
				catch ( Exception e ) {
					System.out.println("Enter only integer value");
					flag = false;
				}
			};
			return input;
		}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			// Taking input to start the game
				System.out.println("1. Start the Game ");
				System.out.println("2. Exit");
				System.out.println("Enter your choice : ");
				int choice = takeIntegerInput(2);
				int nextRound = 1;
				int noOfRound = 0;
				
				if ( choice == 1 ) {
					
					// to check if user wants to play next round 
					while ( nextRound == 1 ) {
						The_Guessing_Game game = new The_Guessing_Game();
						boolean Matched = false;
						boolean LimitCrossed = false;
						System.out.println("\nRound " + ++noOfRound + " starts...");
						
						// to check correct guess and limit cross
						while ( !Matched && !LimitCrossed) {
							LimitCrossed = game.UserInput();
							Matched = game.CorrectGuess();
						}
						// input for next round
						System.out.println("1. Next Round \n2. Exit");
						System.out.println("Enter your choice : ");
						nextRound = takeIntegerInput(2);
						if ( nextRound != 1 ) {
							System.out.println("Thanks for playing my game....");
							System.out.println("Hope you enjoyed playing it....");
							System.exit(0);
						}
					}
				}
				else {
					System.out.println("Thanks for playing my game....");
					System.out.println("Hope you enjoyed playing it....");
					System.exit(0);
				}
				
	}

}
