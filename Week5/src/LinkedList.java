/*
 * LinkedList.java - Class to manage LinkedLists.
 * @author: @professorgordon
 * @url: http://johngordon.io/javaadvancedlinkedlists1.php
 * @license: Creative Commons. No Warranty. No Liability.
 * @disclaimer: This code file is intended strictly for
 *              academic purposes. It is NOT intended for
 *              use in production systems.
 */

import java.util.Random;

public class LinkedList 
{

	Node head;
	
	public void append(int data)
	{
		if (head == null)
		{
			head = new Node(data);
			return;
		}
		Node current = head;
		while (current.next != null)
		{
			current = current.next;
		}
		current.next = new Node(data);
	}
	
	public void printList()
	{
		Node current = head;
		System.out.print("List Contents: ");
		while (current != null)
		{
			System.out.print(current.data + " -> ");
			current = current.next;
		}
		System.out.println("null");
	}
	
	public void prepend(int data) {
		//Add node if no node exists in linked list
		if (head == null)
		{
			head = new Node(data);
			return;
		}
		//create new node, set new node.next to current head node, set head node to new node
		
		Node current = new Node(data);
		current.next = head;
		head = current;

	}
	
	public void delete(int data) {
		//check if any nodes exists in list
		if(head == null) {
			System.out.print("value not found in list");
			return;
		}
		
		//Use search to find node
		Node current = head;
		Node previous = null;
		boolean isFound = false;
		while(current != null) {
			if(current.data == data) {
				if(previous != null) {
					previous.next = previous.next.next;
				}
				else {
					head = current.next;
				}
				isFound = true;
			}
			else {
				previous = current;
			}
			current = current.next;
		}
		
		if(!isFound) {
			System.out.println(data + " was not found");
		}

		
		
	}
	
	public void search(int data) {
		int index = 0;
		Node current = head;
		while(current != null) {
			if(current.data == data) {
				System.out.println(data + " was found at node: " + index);
			}
			index ++;
			current = current.next;
		}
	}
	
	
	public int length() {
		int length = 1;
		
		if(head == null) {
			System.out.println("LinkedList length is " + length);
			return length;
		}
		Node current = head;
		while(current.next != null) {
			length++;
			current = current.next;
		}
		System.out.println("LinkedList length is " + length);
		return length;
	}
	
	
	//Challenge 1
	public void randomTest() {
		clear();
		Random rand = new Random();
		for(int i = 0; i < 800; i++) {
			append(rand.nextInt(100 - 0));
		}
	}
	
	
	//Challenge2 methods
	
	public void clear(){
		//clears head, all other nodes are orphaned
		head = null;
	}
	
	public boolean contains(int data) {
		Node current = head;
		boolean isFound = false;
		while(current != null) {
			if(current.data == data) {
				isFound = true;
			}
			current = current.next;
		}
		
		return isFound;
	}
	
	public int occurrences(int data) {
		Node current = head;
		int occurences = 0;
		while(current != null) {
			if(current.data == data) {
				occurences ++;
			}
			current = current.next;
		}
		return occurences;
	}
	
	public void deleteHead() {
		head = head.next;
	}
	
	public void deleteTail() {
		Node current = head;
		while(current.next.next != null) {
			current = current.next;
		}
		current.next = null;
	}
	
	public void deleteFirstOccurence(int data) {
		//check if any nodes exists in list
		if(head == null) {
		System.out.print("value not found in list");
			return;
		}
				
		//Use search to find node
		Node current = head;
		Node previous = null;
		while(current != null) {
			if(current.data == data) {
				if(previous != null) {
					previous.next = previous.next.next;
				}
				else {
					head = current.next;
				}
				return;
			}
			else {
				previous = current;
			}
				current = current.next;
		}
				
		System.out.println(data + " was not found");		
	}
	
	public void deleteLastOccurence(int data) {
		//TODO
	}
	
	public void deleteAllOccurence(int data) {
		delete(data);
	}
	
	public LinkedList fromArray(int[] arr) {
		LinkedList ll = new LinkedList();
		for(int x: arr) {
			ll.append(x);
		}
		return ll;
	}
	
	public boolean isEmpty() {
		if(head == null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int[] toArray() {
		int[] arr = new int[getLength()];
		Node current = head;
		for(int i = 0; i < getLength(); i++) {
			arr[i] = current.data;
			current = current.next;
		}
		return arr;
	}
	
	public int getPosition(int data) {
		int index = 0;
		Node current = head;
		while(current != null) {
			if(current.data == data) {
				return index;
			}
			index ++;
			current = current.next;
		}
		return -1;
	}

	private int getLength() {
		int length = 1;
		
		if(head == null) {
			return length;
		}
		Node current = head;
		while(current.next != null) {
			length++;
			current = current.next;
		}
		return length;
	}
}
