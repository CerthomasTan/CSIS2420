import java.util.*;

public class Week2Part1 {

	@SuppressWarnings("null")
	public static void main(String[] args) {
		
		//Global Variables
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;
		int total = 0 ;
		int highScore = 0;
		int highScoreRow = 0;
		
		Scanner scanner = null;
		//Initialize scanner  
		try 
		{
			scanner = new Scanner(System.in);
		}
		finally {
			if (scanner == null) {
				scanner.close();
			}
		}
		
		//Ask User for Min value
		System.out.println("Please enter a min value");
		min = GetUserInput(scanner);
		
		//Ask User for Max value
		System.out.println("Please enter a max value");
		max = GetUserInput(scanner);
		
		//swap values if user accidentally switch min and max
		if(min > max) {
			int temp = min;
			min = max;
			max = temp;
		}
		
		//summation of each from min to max. i = 1
		for(int x = min; x <= max; x++) {
			total += x;
		}
		
		//print out total
		System.out.printf("%s %,d %n","Total", total);
		System.out.printf("%n%n");
		
		//Create 2d Array with values
		final int[][] gameScore = {
				{44,63,45,23,76,45},
				{76,23,56,98,33,24},
				{23,71,92,39,45,44},
				{70,20,46,64,77,29},
				{83,45,99,20,10,21},
				{86,34,92,34,88,11}
				};

		System.out.println("---------------------");
		System.out.println("total scores");
		System.out.println("---------------------");
		
		for(int row = 0; row < gameScore.length ; row++) {
			total = gameScore[0][0]; //clear score
			for(int coloumn = 0; coloumn < gameScore[row].length; coloumn++) {
				total += gameScore[row][coloumn];
			}
			if(total > highScore) {
				highScore = total;
				highScoreRow = row;
			}
			System.out.printf("Row %d: %d%n", row ,total);
		}
		
		System.out.println("---------------------");
		System.out.println("Highscore " + "Row: " + highScoreRow);
		System.out.println("---------------------");
		
		scanner.nextLine();
	}
	
	
	//Method for GetUserInput
	static int GetUserInput(Scanner s) {
		String userInput = null;
		int userInt = 0;
		while(userInput == null) {
			//get input from user
			userInput = s.nextLine();
			//try to parse text into integer
			try {userInt = Integer.parseInt(userInput);}
			catch(Exception error){
				if(error instanceof NumberFormatException) {
					System.out.println("Value is invalid, please enter an Integer");
					userInput = null; //clears userInput variable
				}
			}
		}
		
		return userInt;
	}
	
}


