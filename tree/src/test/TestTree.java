package test;

import java.util.Random;

public class TestTree
{

	public static void main(String[] args)
	{
		String i = "Non-recursive";
		// TODO Auto-generated method stub
		Tree t = new Tree();
		for (int k = 0; k < 29; k++)
		{
			Random rand = new Random();
			int num = rand.nextInt(10000);
			t.add(num, t.begin);
		}
		long start = System.nanoTime();
		t.preOrder(t.begin);
		long end = System.nanoTime();
		System.out.print("ǰ��ݹ������ʱ��" + (end - start));
		System.out.println();

		start = System.nanoTime();
		t.inOrder(t.begin);
		end = System.nanoTime();
		System.out.print("����ݹ������ʱ��" + (end - start));
		System.out.println();

		start = System.nanoTime();
		t.postOrder(t.begin);
		end = System.nanoTime();
		System.out.print("����ݹ������ʱ��" + (end - start));
		System.out.println();

		start = System.nanoTime();
		t.preOrder(i, t.begin);
		end = System.nanoTime();
		System.out.print("ǰ��ǵݹ������ʱ��" + (end - start));
		System.out.println();

		start = System.nanoTime();
		t.inOrder(i, t.begin);
		end = System.nanoTime();
		System.out.print("����ǵݹ������ʱ��" + (end - start));
		System.out.println();

		start = System.nanoTime();
		t.postOrder(i, t.begin);
		end = System.nanoTime();
		System.out.print("����ǵݹ������ʱ��" + (end - start));
	}

}
