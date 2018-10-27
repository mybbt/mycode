package sort;

import java.util.*;

import random.RandNumber;

public class SelectionSort
{

	public SelectionSort(List<Integer> array)
	{
		// TODO Auto-generated constructor stub
		long start = System.nanoTime();
		int len = array.size();
		int temp, t;
		for (int i = 0; i < len; i++)
		{
			t = i;
			for (int j = i + 1; j < len; j++)
			{
				if (array.get(t) > array.get(j))
				{
					t = j;
				}
			}
			temp = array.get(i);
			array.set(i, array.get(t));
			array.set(t, temp);
		}
		long end = System.nanoTime();
		System.out.println("selectionSort time:" + (end - start));
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		List<Integer> list = RandNumber.Rand();
		new SelectionSort(list);
		for (int i : list)
			System.out.print(i + " ");
	}

}
