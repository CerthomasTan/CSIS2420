/*
 * LinkedListDemo1.java - Program to demonstrate use of the
 *                        LinkedList and Node classes.
 * @author: @professorgordon
 * @url: http://johngordon.io/javaadvancedlinkedlists1.php
 * @license: Creative Commons. No Warranty. No Liability.
 * @disclaimer: This code file is intended strictly for
 *              academic purposes. It is NOT intended for
 *              use in production systems.
 */

public class LinkedListDemo1 
{

	public static void main(String[] args)

	{
		System.out.println("intialization test");
		LinkedList ll = new LinkedList();
		ll.append(2);
		ll.append(4);
		ll.append(6);
		ll.append(8);
		ll.append(10);
		ll.printList();
		
		//Assignment
		//prepend
		System.out.println();
		System.out.println("prepend test");
		ll.prepend(5);
		ll.prepend(6);
		ll.printList();
		
		//delete
		System.out.println();
		System.out.println("delete test");
		ll.delete(5);
		ll.delete(0);
		ll.printList();
		
		//search
		System.out.println();
		System.out.println("search test");
		ll.search(10);
		ll.append(10);
		ll.search(10);
		ll.search(0);
		
		//length
		System.out.println();
		System.out.println("length test");
		ll.length();
		ll.printList();
		ll.append(0);
		ll.length();
		ll.printList();
		
		//challenge 1 random 800 nodes
		System.out.println();
		System.out.println("800 random test");
		ll.randomTest();
		ll.length();
		
		//challenge2
		//clear
		System.out.println();
		System.out.println("clear test");
		ll.clear();
		ll.printList();
		
		//contains
		System.out.println();
		System.out.println("contains test");
		ll.append(0);
		System.out.println(ll.contains(0));
		System.out.println(ll.contains(1));
		ll.printList();
		
		//occurences
		System.out.println();
		System.out.println("occurence test");
		System.out.println(ll.occurrences(0));
		ll.append(0);
		System.out.println(ll.occurrences(0));
		ll.printList();
		
		//deleteHead
		System.out.println();
		System.out.println("delete head test");
		ll.prepend(2);
		ll.printList();
		ll.deleteHead();
		ll.printList();
		
		//deletetail
		System.out.println();
		System.out.println("delete tail test");
		ll.append(1);
		ll.printList();
		ll.deleteTail();
		ll.printList();
		
		//delete first occurence
		System.out.println();
		System.out.println("delete first occurence test");
		ll.append(1);
		ll.append(2);
		ll.printList();
		ll.deleteFirstOccurence(1);
		ll.printList();
		
		//TODO last occurence
		
		//delete all occurence
		System.out.println();
		System.out.println("delete all occurence test");
		ll.append(5);
		ll.append(5);
		ll.append(2);
		ll.append(5);
		ll.printList();
		ll.deleteAllOccurence(5);
		ll.printList();
		
		
		//from array
		System.out.println();
		System.out.println("from array test");
		int[] arr = {1,2,3,4,5,6};
		ll = ll.fromArray(arr);
		ll.printList();
		
		//to array
		System.out.println();
		System.out.println("To array test");
		arr = null;
		ll.append(10);
		arr = ll.toArray();
		ll.printList();
		for(int data: arr) {
			System.out.println(data);
		}
		
		//get position
		System.out.println();
		System.out.println("position test");
		ll.printList();
		System.out.println(ll.getPosition(5));
		ll.printList();
		
	}
	
}
