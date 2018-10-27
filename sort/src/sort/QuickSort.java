package sort;

import java.util.*;

import random.RandNumber;

public class QuickSort
{

	public QuickSort(List<Integer> array)
	{
		// TODO Auto-generated constructor stub
		long start = System.nanoTime();
		int len = array.size();
		if (len <= 1)
			return;
		sort(array, 0, len - 1);
		long end = System.nanoTime();
		System.out.println("quickSort time:" + (end - start));
	}

	public void sort(List<Integer> array, int begin, int end)
	{
		if (begin >= end)
			return;
		int p = partition(array, begin, end);
		sort(array, begin, p - 1);
		sort(array, p + 1, end);
	}

	public int partition(List<Integer> array, int begin, int end)
	{
		//System.out.println(begin+" "+end);
		int i = begin;
		int j = end;
		int temp = 0;
		while (i < j)
		{
			while (i < j && array.get(i) <= array.get(j))
				i++;
			if (i < j)
			{
				temp = array.get(j);
				array.set(j, array.get(i));
				array.set(i, temp);
				j--;
			}
			while (i < j && array.get(i) <= array.get(j))
				j--;
			if (i < j)
			{
				temp = array.get(j);
				array.set(j, array.get(i));
				array.set(i, temp);
				i++;
			}
		}
		return i;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		List<Integer> list = RandNumber.Rand();
		new QuickSort(list);
		for (int i : list)
			System.out.print(i + " ");
	}

}
