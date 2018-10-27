package random;

interface Imessage{
	public void print();
}

public class Test
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		fun(()->System.out.println("Hello world"));
	}

	private static void fun(Imessage ms)
	{
		// TODO Auto-generated method stub
		ms.print();
	}

}
