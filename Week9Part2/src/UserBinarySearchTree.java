/**
 * <h1> UserBinrarySearchTree</h1>
 * This is a class that creates a Binary Tree structure.
 * It will sort by IP value of the last 3 numbers.
 * 
 * @author Certhomas Tan
 * @version 1.0
 * @2021-11-21
 */
public class UserBinarySearchTree {
	/**
	 * This is the root of the tree, this is where all methods will enter.
	 */
	public UserNode root; 
	
	/**
	 * This method inserts a node using ip and name. This is the public method that the user will use. 
	 * The method will only ask for ip and name. This method will create a new node and 
	 * call insert method with node as a parameter. 
	 * @param ip
	 * @param name
	 */
	public void insert(int ip, String name) {
		insert(new UserNode(name, ip));
	}
	
	/**
	 * This method inserts a node into the tree. This will call the insert method that need a node and\
	 * root parameter. 
	 * @param n this is the node to be inserted
	 */
	public void insert(UserNode n) {
		if(root == null)
		{
			root = n;
		}
		else {
			insert(n, root);
		}
	}
	
	/**
	 * This will insert depending on IP size. 
	 * If the node IP value already exists. 
	 * It will insert the node to the right of the Equivalent node. 
	 * @param n
	 * @param root
	 */
	private void insert(UserNode n, UserNode root) {
		if(root.IP > n.IP) {
			if(root.left == null){
				root.left = n;
				return;
			}
			insert(n, root.left);
		}
		else {
			if(root.right == null) {
				root.right = n;
				return;
			}
			insert(n, root.right);
		}
	}
	
	/**
	 * This method will search tree of ip address. This is the public method that will call 
	 * the private search method which will start at the root. 
	 * @param ip
	 * @return User node if exists in tree
	 */
	public UserNode search(int ip) {
		return search(ip, root);
	}
	
	/**
	 * This method will search the tree and start at the root. If the method finds node,
	 * it will return the node. If the node isn't found, the method will return null
	 * @param ip
	 * @param root
	 * @return Usernode if ip is found in tree. Otherwise it will return null. 
	 */
	private UserNode search(int ip, UserNode root) {
		if(root == null) {
			return null;
		}
		else {
			if(root.IP > ip) {
				return search(ip, root.left);
			}
			else if(root.IP < ip) {
				return search(ip, root.right);
			}
			else if (root.IP == ip) {
				return root;
			}
			else {
				return null;
			}
		}
	}
	
	/**
	 * This method will search the binary tree by name. If name exists, the user node will be returned.
	 * This is the public method that requires just a name. This method will automatically handle 
	 * establishing the entry point which is the root.  
	 * @param name
	 * @return UserNode
	 */
	public UserNode search(String name) {
		return search(name, root);
	}
	
	/**
	 * This method will search the binary tree by name under a subset of the tree depending on the 
	 * root that was entered in as a parameter. This will return the user node if the username mathced
	 * the node. Otherwise, the function will return null. 
	 * @param name
	 * @param root
	 * @return UserNode if name matches node
	 */
	private UserNode search(String name, UserNode root) {
		if(root == null) {
			return null;
		}
		if(root.userName.equals(name)) {
			return root;
		}
		
		UserNode tempNode = search(name, root.left);
		if(tempNode != null) {
				return tempNode;
		}
		return search(name, root.right);
	}
	
	/**
	 * This will return the number of nodes in the entire tree. This will handle establishing the 
	 * enter point of the tree. 
	 * @return number of nodes in the tree
	 */
	public int nodeCount() {
		return nodeCount(root);
	}
	
	/**
	 * this will return the number of nodes in the established subset of the tree. The subset of the
	 * tree will depend on the root that is entered as a parameter.
	 * @param root
	 * @return number of nodes in the tree
	 */
	private int nodeCount(UserNode root) {
		if(root == null) {
			return 0;
		}
		else {
			int leftBranch = nodeCount(root.left);
			int rightBranch = nodeCount(root.right);
			return leftBranch + rightBranch + 1;
		}
	}
	
	/**
	 * This method will print all nodes in the tree in order of ascending IP address. This method will
	 * handle the entry point of the tree. This method is to print the entire tree.
	 */
	public void printTreeInOrder() {
		if(root == null) {
			System.out.println("Tree is Empty");
			return;
		}
		printTreeInOrder(root);
	}
	
	/**
	 * This method will print all the nodes in the subset of the tree. The subset of the tree is determined
	 * by what root node is entered as a parameter. This will print the nodes in the tree in ascending order. 
	 * @param root
	 */
	private void printTreeInOrder(UserNode root) {
		if(root.left != null) {
			printTreeInOrder(root.left);
		}
		System.out.printf("10.0.0.%d  %s%n", root.IP, root.userName);
		
		if(root.right != null) {
			printTreeInOrder(root.right);
		}
		return;
	}
	
}
