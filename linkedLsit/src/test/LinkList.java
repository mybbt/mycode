package test;

public class LinkList
{
	public Node head;
	public Node tail;

	public LinkList()
	{
		// TODO Auto-generated constructor stub
		this.head = null;
		this.tail = null;
	}

	public void add(Node node)
	{
		// node.next = head;
		// head = node;
		if (head == null)
		{
			head = node;
			tail = head;
		}

		else
		{
			node.prev = tail;
			tail.next = node;
			tail = node;
		}
	}

	public void insert(long index, Node node)
	{
		Node temp = head;
		Node temp1 = null;
		long i = 1;
		while (temp != null && i != index)
		{
			temp1 = temp;
			temp = temp.next;
			i++;
		}
		if (i == index)
		{
			node.next = temp;
			temp.prev = node;
			node.prev = temp1;
			temp1.next = node;

		} else if (i == index && temp.next == null)
			tail = node;
		Node d = head;
		Node e = null;
		while (d != null)
		{
			e = d;
			d = d.next;
		}
		tail = e;
	}

	public void delete(long index)
	{
		Node temp = head;
		Node temp1 = null;
		long i = 1;
		while (temp != null && i != index)
		{
			temp1 = temp;
			temp = temp.next;
			i++;
		}
		if (i == index)
		{

			temp1.next = temp.next;
			temp.next.prev = temp1;
		}
		Node d = head;
		Node e = null;
		while (d != null)
		{
			e = d;
			d = d.next;
		}
		tail = e;
	}

	public void selectionSort()
	{
		long start = System.nanoTime();
		Node temp = head;
		Node e = temp.next;
		long min;
		while (temp != null)
		{
			while (e != null)
			{
				if (temp.data > e.data)
				{
					min = e.data;
					e.data = temp.data;
					temp.data = min;
				}
				e = e.next;
			}
			temp = temp.next;
			e = temp;
		}
		long end = System.nanoTime();
		System.out.println("选择排序:" + (end - start) + "ms");
	}

	public void insertionSort()
	{
		long start = System.nanoTime();
		long num = 0;
		long min;
		Node t = head;

		Node temp = head;
		Node ex = temp.next;
		Node ch = head;
		while (t != null)
		{
			num++;
			t = t.next;
		}
		for (long i = 1; i <= num; i++)
		{
			if (ex != null)
			{
				for (long j = i; j > 0; j--)
				{
					if (temp.data > ex.data)
					{
						min = ex.data;
						ex.data = temp.data;
						temp.data = min;
					}
					if (temp.prev != null && ex.prev != null)
					{
						temp = temp.prev;
						ex = ex.prev;
					}
				}
				ch = ch.next;
				temp = ch;
				ex = temp.next;
			}
		}
		long end = System.nanoTime();
		System.out.println("插入排序:" + (end - start) + "ms");
	}

	public void shellSort()
	{
		long start = System.nanoTime();
		long num = 0;
		long h = 1;
		long min;
		Node t = head;

		Node ex = head;
		Node ch = head;
		while (t != null)
		{
			num++;
			t = t.next;
		}

		while (h < num / 3)
		{
			h = h * 3 + 1;
		}
		while (h >= 1)
		{
			for (long i = h; i < num; i++)
			{
				for (long j = 0; j < num; j += h)
				{
					for (long k = 0; k < h && ex.next != null; k++)
					{
						ex = ex.next;
					}
					if (ch.data > ex.data)
					{
						min = ex.data;
						ex.data = ch.data;
						ch.data = min;
					}
					if (ch.next != null)
						ch = ch.next;
				}
				ex = head;
				ch = head;
			}
			h = h / 3;
		}
		long end = System.nanoTime();
		System.out.println("希尔排序:" + (end - start) + "ms");
	}

	public void quickSort(LinkList k)
	{
		long start = System.nanoTime();
		long num = k.size();
		k.quickSort(this.head, this.tail, 1, num, num);
		long end = System.nanoTime();
		System.out.println("快速排序:" + (end - start) + "ms");
	}

	private void quickSort(Node head, Node tail, long begin, long num, long num2)
	{
		if (begin >= num)
			return;
		Node temp = toPartition(head, tail, begin, num);
		long i;
		long j;
		Node ch;
		Node ch2;
		long ts = tailsize(temp);
		long hs = headsize(temp);
		if (ts > 1)
		{
			i = ts - 1;
			ch = temp.prev;
		} else
		{
			i = 1;
			ch = this.head;
		}
		if (hs > 1)
		{
			j = ts + 1;
			ch2 = temp.next;
		} else
		{
			j = num2;
			ch2 = this.tail;
		}
		quickSort(head, ch, begin, i, num2);
		quickSort(ch2, tail, j, num, num2);
	}

	private static Node toPartition(Node head, Node tail, long begin, long count)
	{
		Node first = head;
		Node last = tail;
		long min;
		while (begin < count)
		{
			while (begin < count && first.data < last.data)
			{
				count--;
				last = last.prev;
			}
			if (begin < count)
			{
				min = first.data;
				first.data = last.data;
				last.data = min;
				begin++;
				first = first.next;
			}

			while (begin < count && first.data < last.data)
			{
				begin++;
				first = first.next;
			}
			if (begin < count)
			{
				min = first.data;
				first.data = last.data;
				last.data = min;
				count--;
				last = last.prev;
			}
		}
		return last;
	}

	public void tailprint()
	{
		Node temp = tail;
		while (temp != null)
		{
			System.out.print(temp.data + "  ");
			temp = temp.prev;
		}
	}

	public void headprint()
	{
		Node temp = head;
		while (temp != null)
		{
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	public long headsize(Node node)
	{
		Node temp = node;
		long i = 0;
		while (temp != null)
		{
			i++;
			temp = temp.next;
		}
		return i;
	}

	public long tailsize(Node node)
	{
		Node temp = node;
		long i = 0;
		while (temp != null)
		{
			i++;
			temp = temp.prev;
		}
		return i;
	}

	public Node gethead(Node node)
	{
		Node temp = node;
		Node temp1 = temp;
		while (temp != null)
		{
			temp1 = temp;
			temp = temp.prev;
		}
		return temp1;
	}

	public Node gettail(Node node)
	{
		Node temp = node;
		Node temp1 = temp;
		while (temp != null)
		{
			temp1 = temp;
			temp = temp.next;
		}
		return temp1;
	}

	public long size()
	{
		Node temp = head;
		long i = 0;
		while (temp != null)
		{
			i++;
			temp = temp.next;
		}
		return i;
	}

}
