package com.enhancesys.analytics.master.extractor.util;

public class DoubleLinkedListClass 
{
	Node head, tail = null;  
	int size;
	class Node{ 
        int data;  
        Node previous;  
        Node next;  
  
        public Node(int data) {  
            this.data = data;  
        }  
    }
	
	// used to delete node from start of Doubly linked list
		public Node deleteFirst() {
	 
			if (size == 0) 
				throw new RuntimeException("Doubly linked list is already empty");
			Node temp = head;
			head = head.next;
			head.previous = null;
			size--;
			return temp;
		}
	 
		// used to delete node from last of Doubly linked list
		public Node deleteLast() {
	 
			Node temp = tail;
			tail = tail.previous;
			tail.next=null;
			size--;
			return temp;
		}
	public void insertFirst(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		newNode.previous=null;
		if(head!=null)
			head.previous=newNode;
		head = newNode;
		if(tail==null)
			tail=newNode;
		size++;
	}
	
	public void insertLast(int data) {
		Node newNode = new Node(data);
		newNode.data = data;
		newNode.next = null;
		newNode.previous=tail;
		if(tail!=null)
			tail.next=newNode;
		tail = newNode;
		if(head==null)
			head=newNode;
		size++;
	}
	
	public void insertAtIndex(int i, int index){
		  if(index < 0 || index > i){
		    throw new IndexOutOfBoundsException("Index " + index +" not valid for linked list of size " + size);
		  }
		  Node newNode = new Node(i);
		  Node current = head;
		  //insert at the start
		  if(index == 0){
		    insertFirst(i);
		  }
		  // insert at last
		  else if(index == size){
		    insertLast(i);
		  }else{
		    for(int j = 0; j < index && current.next != null; j++){
		      current = current.next;
		    }
		    newNode.next = current;
		    current.previous.next = newNode;
		    newNode.previous = current.previous;
		    current.previous = newNode;
		    size++;    
		  }
		}
	
	 public void display() {  
	        //Node current will point to head  
	        Node current = head;  
	        if(head == null) {  
	            System.out.println("List is empty");  
	            return;  
	        }  
	        System.out.println("Nodes of doubly linked list: ");  
	        while(current != null) {  
	            //Prints each node by incrementing the pointer.  
	  
	            System.out.print(current.data + " ");  
	            current = current.next;  
	        }  
	    }  
	 
	 	public void searchNode(int value) 
	 	{  
	        int i = 1;  
	        boolean flag = false;  
	        //Node current will point to head  
	        Node current = head;  
	  
	        //Checks whether the list is empty  
	        if(head == null) 
	        {  
	            System.out.println("List is empty");  
	            return;  
	        }  
	        while(current != null) 
	        {  
	            //Compare value to be searched with each node in the list  
	            if(current.data == value) {  
	                flag = true;  
	                break;  
	            }  
	            current = current.next;  
	            i++;  
	        }  
	        if(flag)  
	             System.out.println("Node is present in the list at the position : " + i);  
	        else  
	             System.out.println("Node is not present in the list");  
	    }
	public static void main(String[] args) 
	{
		DoubleLinkedListClass myLinkedlist = new DoubleLinkedListClass();
		myLinkedlist.insertFirst(5);
		myLinkedlist.insertFirst(6);
		myLinkedlist.insertLast(20);
		myLinkedlist.insertFirst(7);
		myLinkedlist.insertFirst(1);
		myLinkedlist.insertLast(2);
		myLinkedlist.insertAtIndex(18, 2);
		myLinkedlist.deleteFirst();
		myLinkedlist.deleteLast();
		myLinkedlist.display();
		System.out.println();
		myLinkedlist.searchNode(5);
	}
	 
}
