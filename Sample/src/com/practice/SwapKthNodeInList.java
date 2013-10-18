package com.practice;

/**
 * 
 *
 * @author dshah
 * @since 
 */
public class SwapKthNodeInList {
	
	public static int counter = 0;

	public static void main(String[] args) {
		
		Node n = createLinkedList();
		printNodeValues(n);
		int position = 1;
		
		Node swappedN = swapPositions(n, position);
		printNodeValues(swappedN);
	}

	private static Node swapPositions(Node head, int position) {
		int count = 1;
		
		Node temp = head;
		Node p1 = null, p2 = null;
		
		while(temp.getNext() != null) {
			if(count == position) {
				p1 = temp;
				p2 = head;
			}
			temp = temp.getNext();
			if(count > position) {
				p2 = p2.getNext();
			}
			count++;
		}
		
		if(p1 != null && p2 != null) {
			swap(p1, p2);
		}
		
		return head;
	}

	private static void swap(Node p1, Node p2) {
		int temp = p1.getValue();
		p1.setValue(p2.getValue());
		p2.setValue(temp);
	}

	private static void printNodeValues(Node n) {
		System.out.println("Name"+"\t"+"Value");
		System.out.println("-------------");
		while(n.getNext() != null) {
			System.out.println(n.getName()+"\t"+n.getValue());
			n = n.getNext();
		}
	}

	private static Node createLinkedList() {
		
		Node node = null;
		
		if(counter < 6) {
			counter++;
			node = new Node(counter+"", counter, createLinkedList());
		}
		
		return node;
	}
}
