import java.util.Random;

/*
 * BSTDemo.java - Class to demonstrate a binary search tree.
 * 
 * @author: @professorgordon
 * @url: http://johngordon.io/javaadvancedtrees.php
 * @license: Creative Commons. No Warranty. No Liability.
 * @disclaimer: This code file is intended strictly for
 *              academic purposes. It is NOT intended for
 *              use in production systems.
 *
 **/

public class BSTDemo 
{
	public static void main(String[] args) 
	{
		BinarySearchTree bst = new BinarySearchTree();
		// Sample Data: 20, 33, 18, 19, 46, 29, 4, 62
		bst.insert(20);
		bst.insert(33);
		bst.insert(18);
		bst.insert(19);
		bst.insert(46);
		bst.insert(29);
		bst.insert(4);
		bst.insert(62);
		System.out.print("PreOrder Traverse:\t");
		bst.preOrderTraverse(bst.root);
		System.out.println();
		System.out.print("InOrder Traverse:\t");
		bst.inOrderTraverse(bst.root);
		System.out.println();
		System.out.print("PostOrder Traverse:\t");
		bst.postOrderTraverse(bst.root);
		System.out.println();
		
		System.out.println("Search Test");
		System.out.println(bst.search(bst.root, 18).data);
		
		System.out.println("Depth Test");
		System.out.println(bst.depth(bst.root));
		System.out.println("deleting test: 18 and 33"); 
		bst.delete(bst.root, 18);
		bst.delete(bst.root, 33);
		System.out.print("PreOrder Traverse:\t");
		bst.preOrderTraverse(bst.root);
		
		System.out.println();
		System.out.println();
		System.out.println("Creating Random Binary Tree...");
		
		bst = new BinarySearchTree();
		int treeSize = 10000000;
		Random rand = new Random();
		for(int i = 0; i < treeSize; i++) {
			bst.insert(rand.nextInt(100) + 1);
		}
		System.out.println("Tree Creation finished");
		System.out.println("traversing tree...");
		long start = System.nanoTime();
		bst.preOrderTraverseNoPrint(bst.root);
		long end = System.nanoTime();
		
		long duration = (end - start);
		System.out.println("Node Count:" + treeSize);
		System.out.println("time to traverse: " + duration + "ns");
		
	}
}