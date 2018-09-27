public class BubbleSort //它重复地走访过要排序的数列，一次比较两个元素，如果他们的顺序错误就把他们交换过来。
                        //走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。
						//速度：O(N^2)
{                       
	public static void main (String[] args)
	{
		int[]arr = {7, 3, 13, 21, 9, 16, 5, 31};
		mystery(arr);
		for (int i = 0; i < arr.length ; ++i)
		{
			System.out.print(arr [i] + " ");
		}
	}
	static void mystery(int[] a)
	{
		for (int stop = a.length - 1; stop > 0; --stop)
		{
			boolean inversion = false;
			for (int i = 0; i < stop;++i) //通过两两左右比较，把最大的放到最后一个位置上，在stop--，找到第二大
			{
				if (a[i] > a[i+1]) //如果前者大于后者就swap
				{
					inversion = true;
					int tmp = a[i];
					a[i] = a[i+1];
					a[i+1] = tmp;
				}
			}
			if (!inversion) 
			{
				break;
			}
			
		}
	}
}