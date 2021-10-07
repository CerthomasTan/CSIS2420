
public class PlayerNode {
	
	PlayerNode next;
	public int playerID;
	public String firstName;
	public String lastName;
	public String playerName;
	public PlayerType playerType;
	public double lifePoints;
	public double totalScore;
	
	//Constructor
	//Sets all the variable after taking in in parameters. 
	public PlayerNode(int playerID, String firstName, String lastName, String playerName, String playerType, 
					  double lifePoints, double totalScore) {
		this.playerID = playerID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.playerName = playerName;
		this.playerType = new PlayerType(playerType);
		this.lifePoints = lifePoints;
		this.totalScore = totalScore;
	}
	
	
	public String toString() {
		return String.format("%-15d %-15s %-15s %-15s %-15s %-15.2f %-15.0f\n",
				  playerID,
				  firstName,
				  lastName,
				  playerName,
				  playerType,
				  lifePoints,
				  totalScore);
	}
	
}
