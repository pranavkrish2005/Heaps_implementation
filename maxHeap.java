public class maxHeap
{
	int[] heap;
	
	public maxHeap()
	{
		heap = new int[0];
	}
	
	public maxHeap(int[] arr)
	{
		heap = arr;
	}
	
	public void add(int element)
	{
		int[] temp = new int[heap.length + 1];
		if(heap.length == 0)
		{
			temp[temp.length - 1] = element;
			heap = temp;
			return;
		}
		for(int i = 0; i < heap.length; i++)
			temp[i] = heap[i];
		int elementindex = temp.length;
		temp[elementindex - 1] = element;
		int parent = elementindex/2;
		while(elementindex - 1 > 0 && temp[elementindex - 1] > temp[parent - 1])
		{
			int t = temp[parent - 1];
			temp[parent - 1] = temp[elementindex - 1];
			temp[elementindex - 1] = t;
			elementindex = parent;
			parent = elementindex/2;
		}
		heap = temp;
	}
	
	public int peek()
	{
		return heap[0];
	}
	
	public int pop()
	{
		int x = this.peek();
		int[] temp = new int[heap.length - 1];
		if(heap.length == 1)
		{
			heap = temp;
			return x;
		}
		temp[0] = heap[heap.length - 1];
		for(int i = 1; i < temp.length; i++)
			temp[i] = heap[i];
		int parent = 1;
		int leftchild = 2*(parent);
		int rightchild = 2*(parent) + 1;
		while((parent - 1 >= 0 && (leftchild - 1 < temp.length && rightchild - 1 < temp.length)) && (temp[parent - 1] < temp[leftchild - 1] || temp[parent - 1] < temp[rightchild - 1]))
		{
			if(temp[rightchild - 1] <= temp[leftchild - 1])
			{
				int t = temp[parent - 1];
				temp[parent - 1] = temp[leftchild - 1];
				temp[leftchild - 1] = t;
				parent = leftchild;
				leftchild = 2*(parent);
				rightchild = 2*(parent) + 1;
			}
			else if(temp[rightchild - 1] > temp[leftchild - 1])
			{
				int t = temp[parent - 1];
				temp[parent - 1] = temp[rightchild - 1];
				temp[rightchild - 1] = t;
				parent = rightchild;
				leftchild = 2*(parent);
				rightchild = 2*(parent) + 1;
			}
		}
		
		if(leftchild - 1 < temp.length && temp[parent - 1] < temp[leftchild - 1])
		{
			int t = temp[parent - 1];
			temp[parent - 1] = temp[leftchild - 1];
			temp[leftchild - 1] = t;
		}
		else if(rightchild - 1 < temp.length && temp[parent - 1] < temp[rightchild - 1])
		{
			int t = temp[parent - 1];
			temp[parent - 1] = temp[rightchild - 1];
			temp[rightchild - 1] = t;
		}

		heap = temp;
		return x;
	}
	
	public int size()
	{
		return heap.length;
	}
	
	public String toString()
	{
		String output = "[";
		System.out.println("The heap is : ");
		for(int i = 0; i < heap.length; i++)
			output += heap[i] + ", ";
		if(heap.length != 0)
			output = output.substring(0, output.length() - 2);
		output += "]";
		return output;
	}
	
	public static void main(String args[])
	{
		maxHeap one = new maxHeap();
		one.add(5);
		one.add(2);
		one.add(1);
		one.add(-2);
		one.add(6);
		one.add(5);
		one.add(-5);
		System.out.println(one.toString());
		System.out.println(one.pop());
		System.out.println(one.toString());
		System.out.println(one.pop());
		System.out.println(one.toString());
		System.out.println(one.pop());
		System.out.println(one.toString());
		System.out.println(one.pop());
		System.out.println(one.toString());
		System.out.println(one.pop());
		System.out.println(one.toString());
		System.out.println(one.pop());
		System.out.println(one.toString());
		System.out.println(one.pop());
		System.out.println(one.toString());
		
	}
}
