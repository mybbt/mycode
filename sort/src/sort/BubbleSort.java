package sort;

import java.util.List;

import random.RandNumber;

public class BubbleSort
{
	public BubbleSort(List<Integer> array)
	{
		long start = System.nanoTime();
		int len = array.size();
		int temp;
		for (int i = 0; i < len; i++)
			for (int j = 0; j < len - i - 1; j++)
			{
				if (array.get(j) > array.get(j + 1))
				{
					temp = array.get(j);
					array.set(j, array.get(j + 1));
					array.set(j + 1, temp);
				}
			}
		long end = System.nanoTime();
		System.out.println("bubbleSort time: " + (end - start));
	}

	public static void main(String[] args)
	{
		List<Integer> list = RandNumber.Rand();
		new BubbleSort(list);
		for (int i : list)
			System.out.print(i + " ");
	}
}
