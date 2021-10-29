
/*
 * BinarySearchTree.java - Class to manage binary search 
 *                         tree implementations.
 * 
 * @author: @professorgordon
 * @url: http://johngordon.io/javaadvancedtrees.php
 * @license: Creative Commons. No Warranty. No Liability.
 * @disclaimer: This code file is intended strictly for
 *              academic purposes. It is NOT intended for
 *              use in production systems.
 *
 */

public class BinarySearchTree 
{
	public BSTNode root;

	public void insert(int data)
	{
		BSTNode newNode = new BSTNode(data);  
		if(root == null)
		{  
			root = newNode;  
			return;  
		}  
		else
		{  
			BSTNode current = root, parent = null;  
			while(true) 
			{  
				parent = current;  
				if(data < current.data)
				{  
					current = current.left;  
					if(current == null)
					{  
						parent.left = newNode;  
						return;  
					}  
				}  
				else
				{  
					current = current.right;  
					if(current == null)
					{  
						parent.right = newNode;  
						return;  
					}  
				}  
			}  
		}  
	}
	
	public void preOrderTraverse(BSTNode n)
	{  
		if(root == null)
		{  
			System.out.println("Tree is empty");  
			return;  
		}  
		else
		{  
			System.out.print(n.data + " ");  
			if(n.left!= null)
			{
				preOrderTraverse(n.left);  
			}
			if(n.right!= null)
			{
				preOrderTraverse(n.right);  
			}
		}  
	}  

	//Pre order traverse with no print statement. Used to test speed since sysout can misrepresent actual time traversing.
	public void preOrderTraverseNoPrint(BSTNode n)
	{  
		if(root == null)
		{  
			return;  
		}  
		else
		{    
			if(n.left!= null)
			{
				preOrderTraverseNoPrint(n.left);  
			}
			if(n.right!= null)
			{
				preOrderTraverseNoPrint(n.right);  
			}
		}  
	}  
	
	public void inOrderTraverse(BSTNode n)
	{  
		if(root == null)
		{  
			System.out.println("Tree is empty");  
			return;  
		}  
		else
		{  
			if(n.left!= null)
			{
				inOrderTraverse(n.left);  
			}
			System.out.print(n.data + " ");  
			if(n.right!= null)
			{
				inOrderTraverse(n.right);  
			}
		}  
	}  

	public void postOrderTraverse(BSTNode n)
	{  
		if(root == null)
		{  
			System.out.println("Tree is empty");  
			return;  
		}  
		else
		{  
			if(n.left!= null)
			{
				postOrderTraverse(n.left);  
			}
			if(n.right!= null)
			{
				postOrderTraverse(n.right);  
			}
			System.out.print(n.data + " ");  
		}  
	}

	public BSTNode search(BSTNode n, int searchData) {
		if(n == null || n.data == searchData) {
			return n;
		}
		if(n.data < searchData) {
			return search(n.right, searchData);
		}
		else {
			return search(n.left, searchData);
		}
	}
	
	public int depth(BSTNode n) {
		//tree is empty from the n point
		if(n == null) {
			return 0; 
		}
		//find deepest length of tree from root
		else {
			//create right branch
			int rightTree = depth(n.right);
			//create left branch
			int leftTree = depth(n.left);
			return (Math.max(leftTree, rightTree) + 1);
		}
	}
	
	public BSTNode delete(BSTNode n, int searchData) {
		if(n == null) {
			return null;
		}
		
		//find node
		if(n.data > searchData) {
			//go left
			n.left = delete(n.left, searchData);
		}
		else if(n.data < searchData){
			n.right = delete(n.right,searchData);
		}
		
		//if node is found, recursive call would be to set call 
		else {
			//handles nodes with one child or no child
			if(n.left == null) {
				//return right if left is empty, 
				//okay if right is null which would indicate end of tree
				return n.right;
			}
			else if(n.right == null) {
				//return left if right is empty, since left was already checked
				//left side would be null 
				return n.left;
			}
			//handles nodes with 2 children, replace node with next sucessor , then delete node. Both left and right would
			//work. This program will chose to go base of the right subtree.
			else {
				n.data = InOrderSuccessor(n.right);
				n.right = delete(n.right, n.data);
			}
		}
		
		//if node doesn't equal search and is at deepest point
		return n;
	}
	
	public int InOrderSuccessor(BSTNode n) {
		int data = n.data;
		BSTNode current = n;
		while(current.left != null) {
			data = root.left.data;
			current = current.left;
		}
		return data;
	}
}