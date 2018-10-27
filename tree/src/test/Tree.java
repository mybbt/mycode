package test;

public class Tree
{
	Node begin;

	public Tree()
	{
		begin = new Node();
	}

	public void add(int da, Node t)
	{
		if (t.data == 0)
		{
			t.data = da;
			t.lchild = null;
			t.rchild = null;
		} else if (da < t.data)
		{
			if (t.lchild == null)
				t.lchild = new Node();
			add(da, t.lchild);
		} else if (da > t.data)
		{
			if (t.rchild == null)
				t.rchild = new Node();
			add(da, t.rchild);
		}
	}

	public void preOrder(Node t)
	{
		if (t == null)
			return;
		else
		{
			System.out.print(t.data);
			System.out.print(" ");
			preOrder(t.lchild);
			preOrder(t.rchild);
		}
	}

	public void inOrder(Node t)
	{
		if (t == null)
			return;
		else
		{
			inOrder(t.lchild);
			System.out.print(t.data);
			System.out.print(" ");
			inOrder(t.rchild);
		}
	}

	public void postOrder(Node t)
	{
		if (t == null)
			return;
		else
		{
			postOrder(t.lchild);
			postOrder(t.rchild);
			System.out.print(t.data);
			System.out.print(" ");
		}
	}

	public void preOrder(String i, Node t)
	{
		if (t == null)
			return;
		int top = -1;
		Node[] s = new Node[10];
		while (t != null || top != -1)
		{
			while (t != null)
			{
				System.out.print(t.data);
				System.out.print(" ");
				s[++top] = t;
				t = t.lchild;
			}

			if (top != -1)
			{
				t = s[top--];
				t = t.rchild;
			}
		}
	}

	public void inOrder(String i, Node t)
	{
		if (t == null)
			return;
		int top = -1;
		Node[] s = new Node[10];
		while (t != null || top != -1)
		{
			while (t != null)
			{
				s[++top] = t;
				t = t.lchild;
			}
			if (top != -1)
			{
				t = s[top--];
				System.out.print(t.data);
				System.out.print(" ");
				t = t.rchild;
			}
		}
	}

	public void postOrder(String i, Node t)
	{
		if (t == null)
			return;
		int top = -1;
		Node[] s = new Node[10];
		int[] flag = new int[10];
		while (t != null || top != -1)
		{
			while (t != null)
			{
				s[++top] = t;
				flag[top] = 0;
				t = t.lchild;

			}

			while (top != -1 && flag[top] == 1)
			{
				t = s[top--];
				System.out.print(t.data);
				System.out.print(" ");
				t = null;
			}

			if (top != -1)
			{
				t = s[top];
				flag[top] = 1;
				t = t.rchild;
			}
		}
	}
}
