package sort;

import java.util.List;

import random.RandNumber;

public class InsertSort
{
	public InsertSort(List<Integer> array)
	{
		long start = System.nanoTime();
		int len = array.size();
		for (int i = 1; i < len; i++)
		{
			int temp = array.get(i);
			int j = i;
			while (j > 0 && temp < array.get(j - 1))
			{
				array.set(j, array.get(j - 1));
				j--;
			}
			array.set(j, temp);
		}
		long end = System.nanoTime();
		System.out.println("insertSort time:" + (end - start));
	}

	public static void main(String[] args)
	{
		List<Integer> list = RandNumber.Rand();
		new InsertSort(list);
		for (int i : list)
			System.out.print(i + " ");
	}
}