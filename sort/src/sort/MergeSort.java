package sort;

import java.util.ArrayList;
import java.util.List;
import random.RandNumber;

public class MergeSort
{

	public MergeSort(List<Integer> array)
	{
		// TODO Auto-generated constructor stub
		long start = System.nanoTime();
		int len = array.size();
		if (len < 1)
			return;
		sort(array, 0, array.size() - 1);
		long end = System.nanoTime();
		System.out.println("mergeSort time:" + (end - start));
	}

	public void sort(List<Integer> array, int begin, int end)
	{
		if (begin >= end)
			return;
		sort(array, begin, (end + begin) / 2);
		sort(array, (end + begin) / 2 + 1, end);
		merge(array, begin, end);
	}

	public void merge(List<Integer> array, int begin, int end)
	{
		int temp = 0;
		List<Integer> arr = new ArrayList<>();
		int middle = (begin + end) / 2;
		int i = begin;
		int j = middle + 1;

		while (i <= middle && j <= end)
		{
			arr.add(temp++, array.get(i) < array.get(j) ? array.get(i++) : array.get(j++));
		}
		while (i <= middle)
		{
			arr.add(temp++, array.get(i++));
		}
		while (j <= end)
		{
			arr.add(temp++, array.get(j++));
		}
		for (int k = 0; k < arr.size(); k++)
		{
			array.set(k + begin, arr.get(k));
		}
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		List<Integer> list = RandNumber.Rand();
		new MergeSort(list);
		for (int i : list)
			System.out.print(i + " ");

	}

}
