
public class PlayerLinkedList {

	PlayerNode head;
	
	
	//add player to end of list
	//TODO: remove playerID and assign new unique player ID
	public void append(int playerID, String firstName, String lastName, String playerName, String playerType, double healthPoints,double totalScore) {
		
		PlayerNode tempPlayerNode = new PlayerNode(playerID, firstName, lastName, playerName, playerType, healthPoints, totalScore);
		
		//check if list is empty
		if(head == null) {
			head = tempPlayerNode;
			return;
		}
		
		//iterate to end of list
		PlayerNode current = head;
		
		while(current.next != null) {
			current = current.next;
		}
		
		current.next = tempPlayerNode;
		
	}
	
	//delete player if ID exists
	public void delete(int playerID) {
		//check if head is empty
		if(head == null) {
			return;
		}
		
		//check if headnode matches ID
		PlayerNode current = head;
		if(current.playerID == playerID) {
			head = current.next;
			return;
		}
		
		//iterates thru list and finds ID. Deletes node if ID matches.
		PlayerNode prev = current;
		current = current.next;
		while(current != null) {
			if(current.playerID == playerID) {
				prev.next = current.next;
				return;
			}
			else {
				prev = current;
				current = current.next;
			}
		}
	}
	
	//returns the number of nodes in the link list
	public int length() {
		//check if list is empty
		int nodeCount = 0;
		if(head == null) {
			return nodeCount;
		}
		
		//counts each node and iterates the node by 1;
		PlayerNode current = head;
		nodeCount++;
		while(current.next != null) {
			nodeCount++;
			current = current.next;
		}
		return nodeCount;
	}
	
	public void prepend(int playerID, String firstName, String lastName, String gameName, String playerClass, double lifePoints,double highestScore) {
		PlayerNode tempNode = new PlayerNode(playerID, firstName, lastName, gameName, playerClass, lifePoints, highestScore);
		tempNode.next = head;
		head = tempNode;
		return;
	}
	
	//prints all players in list in console
	public void printPlayerList() {
		PlayerNode current = head;
		System.out.println("Player List");
		printPlayerListHeader();
		while(current != null) {
			System.out.printf("%-15d %-15s %-15s %-15s %-15s %-15.2f %-15.0f\n",
							  current.playerID,
							  current.firstName,
							  current.lastName,
							  current.playerName,
							  current.playerType,
							  current.lifePoints,
							  current.totalScore);
			current = current.next;
		}
	}
	
	//search linked list for player ID, return Node reference if ID is found. Returns null if ID is not located in list
	public PlayerNode search(int playerID) {
		if(head == null) {
			return null;
		}
		
		PlayerNode current = head;
		while(current != null) {
			if(current.playerID == playerID) {
				return current;
			}
			current = current.next;
		}
		return null;
	}
	
	//search linked list with first name and last name. 
	public PlayerNode search(String firstName, String lastName) {
		if(head == null) {
			return null;
		}
		
		PlayerNode current = head;
		while(current != null) {
			if(current.firstName.equals(firstName) && current.lastName.equals(lastName)) {
				return current;
			}
			current = current.next;
		}
		return null;
	}
	
	//search using playerName
	public PlayerNode search(String playerName) {
		if(head == null) {
			return null;
		}
		
		PlayerNode current = head;
		while(current != null) {
			if(current.playerName.equals(playerName)) {
				return current;
			}
			current = current.next;
		}
		return null;
	}
	
	//print list of players with a certain class type
	//TODO: create struct/enum or class that contains classes to avoid string literal comparisons and redundant code.
	public void search(PlayerType playerType) {
		
		//check if list is empty, exit and print "list is empty if true"
		if(head == null) {
			System.out.println("List is Empty");
			return;
		}
		
		//creates statement of what is searched for and creates headers
		System.out.println("Player with " + playerType + " class");
		printPlayerListHeader();
		
		//searches and prints out player if playertype matches
		PlayerNode current = head;
		while(current != null) {
			if(current.playerType.name.equals(playerType.name)) {
				System.out.printf("%-15d %-15s %-15s %-15s %-15s %-15.2f %-15.0f\n",
								  current.playerID,
								  current.firstName,
								  current.lastName,
								  current.playerName,
								  current.playerType,
								  current.lifePoints,
								  current.totalScore);
			}
			current = current.next;
		}
		return;
	}
	
	//returns player and score
	public String highScore() {
		String report;
		if(head == null) {
			report = "List is Empty";
			return report;
		}
		
		PlayerNode current = head;
		if(current.next == null) {
			report = String.format("%s %s score:%.0",current.firstName, current.lastName, current.totalScore);
			return report;
		}
		
		PlayerNode highestScoreNode = current;
		while(current != null) {
			if(current.totalScore > highestScoreNode.totalScore) {
				highestScoreNode = current;
			}
			current = current.next;
		}
		report = String.format("%s %s score:%.0f",highestScoreNode.firstName, highestScoreNode.lastName, highestScoreNode.totalScore);
		return report;
	}
	
	//returns player will lowest score
	public String lowScore() {
		String report;
		if(head == null) {
			report = "List is Empty";
			return report;
		}
		
		PlayerNode current = head;
		if(current.next == null) {
			report = String.format("%s %s score:%f.2",current.firstName, current.lastName, current.totalScore);
			return report;
		}
		
		PlayerNode lowestScoreNode = current;
		while(current != null) {
			if(current.totalScore < lowestScoreNode.totalScore) {
				lowestScoreNode = current;
			}
			current = current.next;
		}
		report = String.format("%s %s score:%.0f",lowestScoreNode.firstName, lowestScoreNode.lastName, lowestScoreNode.totalScore);
		return report;
	}
	
	//prints header to console
	public void printPlayerListHeader() {
		System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s %-15s\n", 
						  "playerID", 
						  "First Name", 
						  "Last Name", 
						  "Player Name", 
						  "Player Type",
						  "Life Points",
						  "Total Score");
	}
}
