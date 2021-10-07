import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class PlayerLinkedListDemo {

	public static void main(String[] args) throws IOException {
		PlayerLinkedList pll = new PlayerLinkedList();
		Scanner sc = new Scanner(System.in);
		System.out.println("-----------Player List Console-----------");
		
		readPlayerData(pll, sc);
		menu(pll, sc);
		
	}
	
	public static void printMenu() {
		System.out.println("------------Menu----------");
		System.out.println("1. Add New Player");
		System.out.println("2. Delete Player");
		System.out.println("3. Report Total Player Number");
		System.out.println("4. Print Full Player List");
		System.out.println("5. Search by Player ID");
		System.out.println("6. Search by Player's Real Name");
		System.out.println("7. Search by Player's Game Name");
		System.out.println("8. Report Player with Highest Total Score");
		System.out.println("9. Report Player with Lowest Total Score");
		System.out.println("0. Exit Program");
		System.out.println("--------------------------");
		System.out.print("Enter a a value from 0-9:");
	}

	public static void readPlayerData(PlayerLinkedList pll, Scanner sc) throws IOException {
		//read file
		System.out.println("Loading Player File....");
		String fileAddress = "Players.csv";
		File playerFile = new File(fileAddress);

		/* Checks if File exists. If not satisfied, 
		 * program will request user to enter a valid address. 
		 * This will loop until an appropriate data file is available 
		 */
		while(!playerFile.exists()) {
			System.out.println("File not found. Exiting Program");
			System.out.println("Please Enter Address of File:");
			fileAddress = sc.nextLine(); 
			playerFile = new File(fileAddress); 
		}


		/*Will start be trying to place file into the buffered reader.
		 * If its able, this will begin reading each line and adding all values to total
		 * Additional exception check is placed if file is moved before code executes. 
		 */
		if(playerFile.exists() || playerFile.length() > 0) {
			BufferedReader br = null;
			String line = "";
			try {
				br = new BufferedReader(new FileReader(fileAddress));
			} catch (FileNotFoundException e) {
				System.out.println("File not found. Exiting Program");
			}

			//will start reading lines
			while((line = br.readLine()) != null){
				line = line.replaceAll("[^\\x00-\\x7F]", "");
				String[] lineParts = line.split(",");
				int playerID = Integer.parseInt(lineParts[0]);
				String firstName = lineParts[1];
				String lastName = lineParts[2];
				String gameName = lineParts[3];
				String playerType = lineParts[4];
				double lowestScore = Double.parseDouble(lineParts[5]);
				double highestScore = Double.parseDouble(lineParts[6]);

				pll.append(playerID, firstName, lastName, gameName, playerType, lowestScore, highestScore);
			}
			System.out.println("Finished Loading File");
			System.out.println();
			br.close();
		}
	}

	public static void menu(PlayerLinkedList pll, Scanner sc) {
		Boolean appOpen = true;
		do {
			printMenu();
			String userInput;
			int userInt = -1;
			boolean validNumber = false; 
			while(!validNumber) {
				userInput = sc.nextLine();
				try {
					userInt = Integer.parseInt(userInput);
					validNumber = true;
				} catch(NumberFormatException e) {
					System.out.println("Not a valid Number, please enter a whole number");
				};
			}
			switch(userInt) {
				//Exit program
				case 0:
					appOpen = !appOpen;
					break;
				//Add player
				case 1:
					addPlayer(pll, sc);
					pressEnterToContinue(sc);
					break;
				//Delete player 
				case 2:
					deletePlayer(pll,sc);
					pressEnterToContinue(sc);
					break;
				//Get Total count of List
				case 3:
					System.out.println("Total number of Players: " + pll.length());
					pressEnterToContinue(sc);
					break;
				//Get printed list of all players in list
				case 4:
					pll.printPlayerList();
					pressEnterToContinue(sc);
					break;
				//Search by Players ID
				case 5:
					searchPlayerID(pll, sc);
					pressEnterToContinue(sc);
					break;
				//Search by Players User Name
				case 6:
					searchPlayerUserName(pll,sc);
					pressEnterToContinue(sc);
					break;
				//Search by Players Game Name
				case 7:
					searchPlayerGameName(pll, sc);
					pressEnterToContinue(sc);
					break;
				//Find player with Highest score
				case 8:
					System.out.println("High Score");
					System.out.println(pll.highScore());
					pressEnterToContinue(sc);
					break;
				//Find player with lowest score
				case 9:
					System.out.println("Low Score");
					System.out.println(pll.lowScore());
					pressEnterToContinue(sc);
					break;
				default:
					System.out.println("value is invalid, please try again");
			}
		} while(appOpen);
		
		System.out.println("exiting program");
	}

	public static void addPlayer(PlayerLinkedList pll, Scanner sc) {
		System.out.println("--------AddPlayer--------");
		System.out.println("Enter First Name");
		String firstName = sc.nextLine();
		System.out.println("Enter Last Name");
		String lastName = sc.nextLine();
		System.out.println("Enter Player Name");
		String playerName = sc.nextLine();
		System.out.println("Enter Player Type");
		String playerType = sc.nextLine();
		
		Random rand = new Random();
		Boolean numAvailable = false;
		System.out.println("Assigning ID.....");
		int numID = 0;
		while(!numAvailable) {
			numID = rand.nextInt(9999 - 1000) + 1000;
			if(pll.search(numID) == null) {
				numAvailable = !numAvailable;
			}
		}
		System.out.println("Player Created");
		pll.append(numID, firstName, lastName, playerName, playerType, 0, 0);
	}

	public static void deletePlayer(PlayerLinkedList pll, Scanner sc) {
		System.out.println("enter user ID to Delete or press e to return to main menu");
		String userInput = sc.nextLine();
		Boolean CommandOpen = true;
		int userIDInput = -1;
		while(CommandOpen) {
			if(userInput.equals("e")) {return;}
			try {
				userIDInput = Integer.parseInt(userInput);
			} catch(NumberFormatException e) {
				System.out.print("Invalid Number, ");
			}
			int tempLength = pll.length();
			pll.delete(userIDInput);
			if(tempLength > pll.length()) {
				CommandOpen = false;
				System.out.println("Player was removed from List");
			}
			else {
				System.out.println("PlayerID was not found in List, re-enter user ID to Delete or press e to return to main menu");
				userInput = sc.nextLine();
			}
		}
		
	}

	public static void searchPlayerID(PlayerLinkedList pll, Scanner sc) {
		System.out.println("enter user ID to search player or enter \"e\" to return ");
		String userInput = sc.nextLine();
		Boolean CommandOpen = true;
		int userIDInput = -1;
		while(CommandOpen) {
			if(userInput.equals("e")) {return;}
			try {
				userIDInput = Integer.parseInt(userInput);
			} catch(NumberFormatException e) {
				System.out.println("invalid number");
			}
			PlayerNode searchNode = pll.search(userIDInput);
			if(searchNode == null) {
				System.out.println("ID was not found, enter user ID to search player or enter \"e\" to return ");
				userInput = sc.nextLine();
			}
			else {
				pll.printPlayerListHeader();
				System.out.println(searchNode);
				CommandOpen = false;
			}
		}
	}
	
	public static void searchPlayerUserName(PlayerLinkedList pll, Scanner sc) {
		Boolean commandOpen = true;
		
		while(commandOpen) {
			System.out.println("Enter First Name (case-sensative)");
			String firstName = sc.nextLine();
			System.out.println("Enter last  Name (case-sensative)");
			String lastName = sc.nextLine();
			PlayerNode searchNode = pll.search(firstName, lastName);
			if(searchNode == null){
				System.out.println("Player Not Found, type e if you want to cancel search or press enter to try again");
				if(sc.nextLine().equals("e")) {
					System.out.print("returning to main, ");
					return;
				}
			}
			else {
				pll.printPlayerListHeader();
				System.out.println(searchNode);
				return;
			}
		}
	}
	
	public static void searchPlayerGameName(PlayerLinkedList pll, Scanner sc) {
		Boolean commandOpen = true;
			
		while(commandOpen) {
			System.out.println("Enter Player Game Name (case-sensative)");
			String gamerName = sc.nextLine();
			PlayerNode searchNode = pll.search(gamerName);
			if(searchNode == null){
				System.out.println("Player Not Found, type e if you want to cancel search or press enter to try again");
				if(sc.nextLine().equals("e")) {
					System.out.print("returning to main, ");
					return;
				}
			}
			else {
				pll.printPlayerListHeader();
				System.out.println(searchNode);
				return;
			}
		}
	}

	public static void pressEnterToContinue(Scanner sc) {
		System.out.println("press enter to continue......");
		sc.nextLine();
	}
}
