/**
 * <h1> UserNode</h1>
 * This is the UserNode. This node will be used in a binary tree.
 * The node will contain a pointer to left node and right node. 
 * The node will also contain the user name and IP address.
 * 
 * @author Certhomas Tan
 * @version 1.0
 * @2021-11-21
 */
public class UserNode {

	//Attributes 
	public UserNode left;
	public UserNode right;
	public String userName;
	public int IP;
	
	//Methods
	/**
	 * This constructor will create a node and set the user name and IP adress. 
	 * @param userName
	 * @param IP
	 */
	public UserNode(String userName, int IP) {
		this.left = null;
		this.right = null;
		this.userName = userName;
		this.IP = IP;
	}
	
}
