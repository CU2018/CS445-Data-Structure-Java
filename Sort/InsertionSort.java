public class InsertionSort
{
    //Methods for InsertionSort in Array iteratively
    public static <T extends Comparable<? super T>> void insertionSort(T[] a, int n) // a method for users
    {
        insertionSort(a, 0, n-1);
    }

    public static <T extends Comparable<? super T>> void insertionSort(T[] a, int first, int last)
    {   //loop from left to right in order to go through every elements
        for (int unsorted = first + 1; unsorted <= last; unsorted++)
        {
            T firstUnsorted = a[unsorted];
            insertionSort(firstUnsorted, a, first, unsorted - 1);
        }
    }

    private static <T extends Comparable<? super T>> void insertionSort(T element, T[] a, int start, int end)
    {   //loop from right to left in order to find the right place for the certain element
        int index;
        for (index = end; index >= start && element.compareTo(a[index]) < 0; index--)
            a[index + 1] = a[index];
        a[index + 1] = element;
    }

    //Methods for InsertionSort in Array recursively
    public static <T extends Comparable<? super T>> void insertionSort2(T[] a, int n)
    {
        insertionSort2(a, 0, n-1);
    }

    public static <T extends Comparable<? super T>> void insertionSort2(T[]a, int first, int last)
    {
        if (first < last)
        {
            insertionSort(a, first, last -1);
            rec_insertionSort(a[last], a, 0, last - 1);
        }
    }

    private static <T extends  Comparable<? super T>> void rec_insertionSort(T element, T[] a, int start, int end)
    {
        if (element.compareTo(a[end]) >= 0) //base case: element is greater or equal to its left
            a[end + 1] = element;
        else if (start < end)     //recursive case: element is smaller than its left and at least two values remain in the array
        {
            a[end + 1] = a[end];  //shift
            rec_insertionSort(element, a, start, end - 1); //recurse
        }
        else     // base case -- item is less than one to its left and only one value
                // remains in the array.  Shift the last value and place the item
        {
            a[end + 1] = a[end];
            a[end] = element;
        }
    }

    /*
    InsertionSort in linked list
    Node front = null;
    Node curr, prev;
    for (int i = 0; i < data.length; i++)
    {
        curr = front;
        prev = null;
        boolean done = false;
        while (curr != null && ! done)
        {
            if (curr.data.compareTo(data[i]) < 0) // curr.data < data[i]
                done = true;
            else
            {
                prev = curr;
                curr = curr.next;
            }
        }
        Node temp = new Node(data[i]);
        if (prev == null)
        {
            temp.next = front;
            front = temp;
        }
        else
        {
            temp.next = curr;
            prev.next = temp;
        }
    }
    */
}
