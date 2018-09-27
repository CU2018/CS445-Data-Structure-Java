public class PrimQ1 <T> implements SimpleQueue<T>, Moves
{
	private T[] array;
	private int front, end, move;
	private static final int DEFAULT_CAPACITY = 10;
	
	public PrimQ1()
	{
		this(DEFAULT_CAPACITY);
		front = -1;
        end = -1;
	}
	
	@SuppressWarnings("unchecked")
	public PrimQ1(int n)
	{
		T[] temp = (T[]) (new Object[n]);
		array = temp;
		front = -1;
		end = -1;
	}
	
    public boolean offer(T element)
    {
		 if (isEmpty())
        {
			end++;
			front++;
            array[end] = element;
            move++;
            return true;
        }
        if (array.length <= front + 1)
            array = upSize(array);
        if (!isEmpty())
        {
			front++;
			for (int i = front; i > end; i--)
			{
				array[i] = array[i-1];
				move++;
			}
			array[end] = element;
            move++;
            return true;
        }
        return false;
    }
    // or add() or enqueue()
    // add a new element at the logical end of the Queue
    // return true if add is successful and false otherwise

    public T poll()
    {
    	if (front != -1)
    	{
			T temp = array[front];
			front--;
			move++;
			return temp;
		}
    	else
    		return null;
    }
    // or remove() or dequeue()
    // remove the element at the logical front of the Queue
    // return the element or null if the Queue is empty

    public T peek()
    {
		if (isEmpty())
			return null;
		else
			return array[front];
    }
    // or getFront()
    // get and return element at logical front of the Queue
    // do not remove the element
    // return null if Queue is empty

    public boolean isEmpty()
    {
		if (end == -1 && front == -1)
			return true;
        return false;
    }
    // return true if Queue is empty; false otherwise

    public void clear()
    {
		/*@SuppressWarnings("unchecked")
		T[] temp= (T[])new Object[DEFAULT_CAPACITY];
		array = temp;*/
		end = -1;
		front = -1;
		move = 0; //通过这种方式节省空间 不用创建新的数组
    }
    // clear all contents from Queue and set to empty

    public int getMoves()
    {
        return this.move;
    }
    // return the value of the moves variable

    public void setMoves(int val)
    {
		this.move = val;
    }
    // initialize the moves variable to val
	
	private T[] upSize (T[] fullArr)
	{
		@SuppressWarnings("unchecked")
		T[] newArr = (T[])new Object[fullArr.length * 2];
		for (int i = 0; i < fullArr.length; i++)
			newArr[i] = fullArr[i];
		return newArr;
	}
}
