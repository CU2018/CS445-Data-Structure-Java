import java.util.*;

public class RandIndexQueue<T> implements MyQ<T>, Indexable<T>, Shufflable //通过实现这些接口 重写方法
{
    private T[] array; //泛型数组
    private int front; //logcial第一个数据存储的位置
    private int end; //logical最后一个数据存储的位置
    private int move; //用于计算BigO
    private int currentSize; //当前数组中已经initialized数据个数
    private static final int DEFAULT_CAPACITY = 10; //默认数组大小

    public RandIndexQueue() //non-args constructor
    {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked") //需要这个SuppressWarning 因为在下面的步骤中强转了Object为泛型
    public RandIndexQueue(int initialCapacity)
    {
        T[] temp = (T[]) new Object[initialCapacity];
        array = temp;
        clear(); //节省代码 初始化和clear操作类似
    }

    // Add a new Object to the MyQ in the next available location.  If
    // all goes well, return true; otherwise return false.
    public boolean offer(T item)
    {
        if (item != null) //保证传入的是有效数据
        {
            if (currentSize == array.length) //如果数组满了就upSize
               upSize();
            array[end] = item; //把传入的数据加到logical的最后一个元素的位置上
            end = (end+1) % array.length; //将end移到logical的下一个元素
            currentSize++;
            move++;
            return true;
        }
        else
            return false;
    }

    // Remove and return the logical front item in the MyQ.  If the MyQ
    // is empty, return null
    public T poll()
    {
        if (isEmpty())
            return null;
        else
        {
            T temp = array[front]; //先把logical的第一个元素存到temp里 用于返回值
            front = (front + 1) % array.length; //通过将front下标移到logical的下一个位置来从头删除元素
            currentSize--;
            move++;
            return temp;
        }
    }

    // Get and return the logical front item in the MyQ without removing it.
    // If the MyQ is empty, return null
    public T peek()
    {
        if (array[front] == null)
            return null;
        else
            return array[front]; //返回logical的第一个元素
    }

    // Return true if the MyQ is full, and false otherwise
    public boolean isFull() //只return flase 因为此数组是dynamic 的永远不会full，只是让用户知道当前状态
    {
        return false;
    }

    // Return true if the MyQ is empty, and false otherwise
    public boolean isEmpty()
    {
        return currentSize == 0;
    }

    // Return the number of items currently in the MyQ.  Determining the
    // length of a queue can sometimes very useful.
    public int size()
    {
        return currentSize;
    }

    // Reset the MyQ to empty status by reinitializing the variables
    // appropriately
    public void clear() //通过重置logical的头，尾和当前initialized个数来清除数组
    {
        front = 0;
        end = 0;
        currentSize = 0;
    }

    // Methods to get and set the value for the moves variable.  The idea for
    // this is the same as shown in Recitation Exercise 1 -- but now instead
    // of a separate interface these are incorporated into the MyQ<T>
    // interface.  The value of your moves variable should be updated during
    // an offer() or poll() method call.  However, any data movement required
    // to resize the underlying array should not be counted in the moves.
    public int getMoves()
    {
        return this.move;
    }
    public void setMoves(int moves)
    {
        this.move = moves;
    }

    public void shuffle() //应用了fisher-yates的洗牌算法 随机生成和数组个数相同的随机数，和当前循环到的位置交换
    {
        Random r = new Random();
        for (int i = 0; i < currentSize; i++)
        {
            int j = r.nextInt(currentSize);
            T temp = this.get(j); //通过内部的set和get方法交换
            this.set(j, this.get(i));
            this.set(i, temp);
        }
    }
    // Reorganize the items in the object in a pseudo-random way.  The exact
    // way is up to you but it should utilize a Random object (see Random in
    // the Java API).  Note that this should not change the size of the
    // collection.

    // Get and return the value located at logical location i in the implementing
    // collection, where location 0 is the logical beginning of the collection.
    // If the collection has fewer than (i+1) items, throw an IndexOutOfBoundsException
    public T get(int i)
    {
        if ( currentSize < i+1 ) //check是否能找到当前传入的logcial的下标
            throw new IndexOutOfBoundsException();
        else
            return array[(front + i) % array.length];
    }

    // Assign item to logical location i in the implementing collection, where location
    // 0 is the logical beginning of the collection.  If the collection has fewer than
    // (i+1) items, throw an IndexOutOfBoundsException
    public void set(int i, T item)
    {
        if ( currentSize < i+1 ) //check是否能找到当前传入的logcial的下标
            throw new IndexOutOfBoundsException();
        else
            array[(front + i) % array.length] = item;
    }

    @Override
    public String toString()
    {
        String content = "";
        for (int i = 0; i < currentSize ; i++)
            content +=  this.get(i) + " ";
        return "Contents: " + content;
    }

    private void upSize()
    {
        @SuppressWarnings("unchecked") //通过创建一个新的两倍大小的数组将数组扩容
        T[] newArray = (T[])new Object[array.length * 2];
        for (int i = 0; i < currentSize; i++) //logcial顺序遍历每个数据 并copy到新的数组里
            newArray[i] = this.get(i);
        front = 0; //将front放到下标为0的位置
        end = currentSize; //将end放到currentSize的位置，即可放入的下一个空位
        this.array = newArray;
    }

}
