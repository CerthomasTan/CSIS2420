import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
/**
 * <h1>Week9 part 2 - UserIPTreeProgram</h1>
 * UserIpTree program creates a binary tree using extranal data that is given thru a cvs.
 * In this program, you will be able to create the tree, search by IP, search by User Name,
 * get a total count, and get a sorted print out of all users in the node by IP. All the 
 * out put will be given in the console. 
 * 
 * 
 * @author Certhomas Tan
 * @version 1.0
 * @2021-11-21
 */
public class UserIPTreeProgram {
	/**
	 * This is the main program method. This will be the main program that acts as the UI
	 * for the user. The user will be given 6 different options to chose from. They will 
	 * enter a number between 1 - 6 and the program will execute a different function accordingly.
	 * Program will inform user if entry is invalid. Program will run until user exits program. 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		//varibles for program loop condition, scanner for both user input and file io, and binary search tree
		Boolean isProgramRunning = true;
		Scanner scanner = new Scanner(System.in);
		UserBinarySearchTree bst = new UserBinarySearchTree();
		
		//program loop and switch cases for user option. 
		while(isProgramRunning) {
			printMenu();
			int userInt = getUserInt(scanner);
			//main menu, appropriate choices are 1-6. 6 exits program
			switch(userInt)
			{
				//option 1: generate tree
				case 1: 
					bst = new UserBinarySearchTree();
					createBSTFromCSV(bst, scanner);
					break;
				
				//option 2: search by IP address
				case 2:
					searchByIP(bst, scanner);
					break;
					
				//option 3: search by Name 
				case 3:
					searchByName(bst, scanner);
					break;
					
				//option 4: prints out total nodes
				case 4:
					getTotalNodes(bst);
					break;
					
				//option 5: prints out all entries in order of ascending IP.
				case 5:
					printTree(bst);
					break;
					
				//option 6: exits program
				case 6:
					isProgramRunning = false;
					System.out.println("Exiting Program");
					break;
				
				//if number doesn't equal any integers between 1 - 6, will inform user that 
				default:
					System.out.println("Option is not Avaliable, please try again");
					break;
			}
		}
		scanner.close();
	}
	
	/**
	 * This method will print the main menu to the console
	 */
	public static void printMenu() {
		System.out.println("-----------------------");
		System.out.printf(
				"1 Build Users Tree\n"
				+ "2 find by IP Address\n"
				+ "3 Find by UserName\n"
				+ "4 Report Number of Nodes\n"
				+ "5 Print Entire Tree\n"
				+ "6 Exit\n");
		System.out.println("-----------------------");
		System.out.println("Enter 1, 2, 3, 4, 5, 6");
		
	}
	
	/**
	 * This method will ask the user to input a number. Method will ensure that the user inputs a 
	 * valid integer. If user enters a valid integer, the method will return that number. If user 
	 * inputs a non-integer, method will prompt user that entry is invalid and will have to re-enter a value. 
	 * @param scanner
	 * @return userInt
	 */
	public static int getUserInt(Scanner scanner) {
		//creates program loop
		Boolean IsValidInt = false;
		int userInt = 0;
		
		//loop will run until user inputs valid number
		while(!IsValidInt) {
			//get userInput
			String userString = scanner.nextLine();
			//try to parse. if no exception are encountered, parse to int. 
			try {
				userInt = Integer.parseInt(userString);
				IsValidInt = true;
			}
			// if non-integer is entered, inform user of invalid entry and request re-entry of value. 
			catch(Exception e) {
				System.out.println("Invalid input, please input a number"); 
				IsValidInt = false;
			}
		}
		return userInt;
	}
	
	/**
	 * This method will create a binary tree using data from a csv file. 
	 * @param bst
	 * @param sc
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public static void createBSTFromCSV(UserBinarySearchTree bst, Scanner sc) throws NumberFormatException, IOException {
		
		//get csv file path and check if file exists. If not found, prompt user for valid file path.
		String path = "users.csv";
		File dataFile = new File(path);
		while(!dataFile.exists() || dataFile.length() < 0 ) {
			System.out.println("File not found");
			System.out.println("Please Enter Address of File:");
			path = sc.nextLine(); 
			dataFile = new File(path); 
		}
		
		//once csv is found, will read data and place in buffered reader and create the binary tree
		if(dataFile.exists() || dataFile.length() > 0) {
			BufferedReader br = null;
			String line = "";
			try {
				br = new BufferedReader(new FileReader(path));
			} catch (FileNotFoundException e) {
				System.out.println("File not found. Exiting Program");
			}
			
			//will start reading lines and insert nodes to binary tree with parsed data from csv.
			System.out.println("Creating Binary Search Tree....");
			while((line = br.readLine()) != null){
				String[] userInfo = line.split(",");
				int userIp = Integer.parseInt(userInfo[0]);
				String userName = userInfo[1];
				bst.insert(userIp, userName);
			}
			
			System.out.println("Finished Creating Binary Search Tree....");
			
			//close file, buffered reader, and file reader
			br.close();
		}
	}
	
	/**
	 * This method will search a binary tree by IP. Method will ask user for an IP. If IP is found in 
	 * binary tree, the method will print the IP and user to the console. If not found, console will 
	 * inform user that IP was not found in the binary tree.
	 * @param bst Binary Search Tree
	 * @param sc 
	 */
	public static void searchByIP(UserBinarySearchTree bst, Scanner sc) {
		//Request user for input
		System.out.println("Search by IP");
		System.out.println("Please last 3 digit of IP:");
		int userInt = getUserInt(sc);
		
		//searches tree by user inputted IP
		UserNode searchNode = bst.search(userInt);
		
		//prints results of whether IP was found.
		if(searchNode == null) {
			System.out.printf("10.0.0.%d was not found%n", userInt);
		}
		else {
			System.out.printf("Found: 10.0.0.%d %s%n", searchNode.IP, searchNode.userName);
		}
	}

	/**
	 * This method will search a binary tree by UserName. Method will ask user for an UserName. If UserName is found in 
	 * binary tree, the method will print the IP and user to the console. If not found, console will 
	 * inform user that UserName was not found in the binary tree.
	 * @param bst Binary Search Tree
	 * @param sc
	 */
	public static void searchByName(UserBinarySearchTree bst, Scanner sc) {
		//request user to input name
		System.out.println("Search by Name");
		System.out.println("Please enter name:");
		String userName = sc.nextLine();
		
		//searches name in bst
		UserNode searchNode = bst.search(userName);
		
		//prints to console whether username was found in bst or not.
		if(searchNode == null) {
			System.out.printf("%s was not found%n", userName);
		}
		else {
			System.out.printf("Found: 10.0.0.%d %s%n", searchNode.IP, searchNode.userName);
		}
	}
	
	/**
	 * This method will print to the console the total number of nodes in a binary search tree
	 * @param bst
	 */
	public static void getTotalNodes(UserBinarySearchTree bst) {
		//prints total number of nodes
		System.out.printf("Total Number of Nodes in Tree:%d%n", bst.nodeCount());
	}
	
	/**
	 * This method will print all entries in the tree in ascending order of IP addresses.
	 * @param bst Binary Search Tree
	 */
	public static void printTree(UserBinarySearchTree bst) {
		//prints nodes in ascending order by IP
		System.out.println("-----User Node List-----");
		bst.printTreeInOrder();
	}
	
}
