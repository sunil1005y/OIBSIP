import java.util.Scanner;
import java.util.Random;

class NumberGuessGame {
	
	
	int systemInput;
	int userInput;
	int noOfGuesses = 0;
	
	NumberGuessGame() {
		Random random = new Random();
		this.systemInput = random.nextInt(100) + 1;
	}

	
	public boolean takeUserInput() {
		if ( noOfGuesses < 10 ) {
			System.out.print("Guess The Number : ");
			this.userInput = GuessingNumber.takeIntegerInput(100);
			noOfGuesses++;
			return false;
		}
		else {
			System.out.println("Number of Attempts Finished...Better Luck Next time\n");
			return true;
		}
	}
	
	

	public boolean isCorrectGuess() {
		
		if ( systemInput == userInput ) {
			System.out.println("CONGRATULATIONS, You Guess The Number " + systemInput +
			" in " + noOfGuesses + " guesses");
			switch(noOfGuesses) {
				case 1:
				System.out.println("Your Score is 100");
				break;
				case 2:
				System.out.println("Your Score is 90");
				break;
				case 3:
				System.out.println("Your Score is 80");
				break;
				case 4:
				System.out.println("Your Score is 70");
				break;
				case 5:
				System.out.println("Your Score is 60");
				break;
				case 6:
				System.out.println("Your Score is 50");
				break;
				case 7:
				System.out.println("Your Score is 40");
				break;
				case 8:
				System.out.println("Your Score is 30");
				break;
				case 9:
				System.out.println("Your Score is 20");
				break;
				case 10:
				System.out.println("Your Score is 10");
				break;
			}
			System.out.println();
			return true;
		}
		else if ( noOfGuesses < 10 && userInput > systemInput ) {
			if ( userInput - systemInput > 10 ) {
				System.out.println("Too High");
			}
			else {
				System.out.println("Little High");
			}
		}
		else if ( noOfGuesses < 10 && userInput < systemInput ) {
			if ( systemInput - userInput > 10 ) {
				System.out.println("Too low");
			}
			else {
				System.out.println("Little low");
			}
		}
		return false;
	}
}

public class GuessingNumber {
	public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	
	public static int takeIntegerInput(int limit) {
		int input = 0;
		boolean flag = false;
		
		while ( !flag ) {
			try {
				Scanner sc = new Scanner(System.in);
				input = sc.nextInt();
				flag = true;
				
				if ( flag && input > limit || input < 1 ) {
					System.out.println("Choose the Number between 1 to " + limit);
					flag = false;
				}
			}
			catch ( Exception e ) {
				System.out.println("Enter Only Integer Value");
				flag = false;
			}
		};
		return input;
	}
	
	public static void main(String[] args) {
		System.out.println(ANSI_RED_BACKGROUND+"\t\t******** NUMBER GUESSING GAME*********"+ANSI_RESET);
		System.out.println(ANSI_GREEN+"\tRules for the game :\n\t1- A number is chosen" + " between 1 to 100." + "\n\t2- Guess the number"+ " within 10 trials."+ANSI_RESET);

		System.out.println(ANSI_YELLOW+"1. Start The Game \n2. Exit");
		System.out.print("Enter Your Choice : ");
		int choice = takeIntegerInput(2);
		int nextRound = 1;
		int noOfRound = 0;
		
		if ( choice == 1 ) {

			while ( nextRound == 1 ) {
				NumberGuessGame numberguessgame = new NumberGuessGame();
				boolean isMatched = false;
				boolean isLimitCross = false;
				System.out.println("\nRound " + ++noOfRound + " starts...");
				
				while ( !isMatched && !isLimitCross) {
					isLimitCross = numberguessgame.takeUserInput();
					isMatched = numberguessgame.isCorrectGuess();
				}
				System.out.println("1. Next Round \n2. Exit");
				System.out.println("Enter Your Choice : ");
				nextRound = takeIntegerInput(2);
				if ( nextRound != 1 ) {
					System.exit(0);
				}
			}
		}
		else {
			System.exit(0);
		}
	}
}
