
public class UserBinarySearchTree {
	public UserNode root;
	//insert
	public void insert(int ip, String name) {
		insert(new UserNode(name, ip));
	}
	
	public void insert(UserNode n) {
		if(root == null)
		{
			root = n;
		}
		else {
			insert(n, root);
		}
	}
	
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
	
	public UserNode search(int ip) {
		return search(ip, root);
	}
	
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
	
	public UserNode search(String name) {
		return search(name, root);
	}
	
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
	
	public int nodeCount() {
		return nodeCount(root);
	}
	
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
	
	public void printTreeInOrder() {
		if(root == null) {
			System.out.println("Tree is Empty");
			return;
		}
		printTreeInOrder(root);
	}
	
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
