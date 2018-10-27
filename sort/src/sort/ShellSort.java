package sort;

import java.util.List;

import random.RandNumber;

public class ShellSort
{

	public ShellSort(List<Integer> array)
	{
		// TODO Auto-generated constructor stub
		long start = System.nanoTime();
		int len = array.size();
		int h = 1;
		int temp;
		while (h < len / 3)
		{
			h = h * 3 + 1;
		}
		while (h >= 1)
		{
			for (int i = h; i < len; i++)
			{
				for (int j = i; j >= h && array.get(j) < array.get(j - h); j -= h)
				{
					temp = array.get(j);
					array.set(j, array.get(j - h));
					array.set(j - h, temp);
				}
			}
			h = h / 3;
		}
		long end = System.nanoTime();
		System.out.println("shellSort time:" + (end - start));
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		List<Integer> list = RandNumber.Rand();
		new ShellSort(list);
		for (int i : list)
			System.out.print(i + " ");
	}

}
