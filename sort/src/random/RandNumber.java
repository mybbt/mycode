package random;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandNumber
{
	public RandNumber()
	{

	}

	public static List<Integer> Rand()
	{
		List<Integer> list = new ArrayList<>();
		Random rand = new Random();
		for (int i = 0; i < 500; i++)
		{
			int q = rand.nextInt(30000);
			list.add(q);
		}
		return list;
	}
}
