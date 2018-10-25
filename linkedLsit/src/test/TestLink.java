package test;

import java.util.*;

public class TestLink
{
	public static void main(String[] args)
	{
		long q;
		LinkList node = new LinkList();
		LinkList node2 = new LinkList();
		LinkList node3 = new LinkList();
		LinkList node4 = new LinkList();
		for (int i = 0; i < 650; i++)
		{
			Random rand = new Random();
			q = rand.nextInt(10000);
			node.add(new Node(q));
		}
		node.selectionSort();
		node.headprint();
		System.out.println();
		for (int i = 0; i < 650; i++)
		{
			Random rand = new Random();
			q = rand.nextInt(10000);
			node2.add(new Node(q));
		}
		node2.insertionSort();
		node2.headprint();
		System.out.println();
		for (int i = 0; i < 650; i++)
		{
			Random rand = new Random();
			q = rand.nextInt(10000);
			node3.add(new Node(q));
		}
		node3.shellSort();
		node3.headprint();
		System.out.println();
		for (int i = 0; i < 650; i++)
		{
			Random rand = new Random();
			q = rand.nextInt(10000);
			node4.add(new Node(q));
		}
		node4.quickSort(node);
		node4.headprint();
	}
}

/*
 * node.selectionSort(); node.headprint(); System.out.println();
 * node.insertionSort(); node.headprint(); System.out.println();
 * node.shellSort(); node.headprint(); System.out.println();
 * node.quickSort(node); node.headprint();
 */