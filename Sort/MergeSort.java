public class MergeSort
{
    public static <T extends Comparable<? super T>> void mergeSort(T[]a, int n)
    {
        mergeSort(a, 0 , n - 1);
    }

    public static <T extends Comparable<? super T>> void mergeSort(T[]a, int first, int last)
    {
        T[] tempArray = (T[]) new Comparable<?>[a.length];  //overhead: extra memory
        mergeSort(a, tempArray, first, last);
    }

    private static <T extends Comparable<? super T>> void mergeSort(T[] a, T[] tempArray, int first, int last)
    {
        if (first < last)
        {
            int mid = (first + last) / 2;
            mergeSort(a, tempArray, first, mid);
            mergeSort(a, tempArray, mid + 1, last);
            if (a[mid].compareTo(a[mid + 1]) > 0)
                merge(a, tempArray, first, mid, last);
        }
    }

    private static <T extends Comparable<? super T>> void merge(T[] a, T[] tempArray, int first, int mid, int last)
    {
        int beginHalf1 = first;
        int endHalf1 = mid;
        int beginHalf2 = mid + 1;
        int endHalf2 = last;

        int index = beginHalf1;
        while (beginHalf1 <= endHalf1 && beginHalf2 <= endHalf2)      //stable sort
        {
            if (a[beginHalf1].compareTo(a[beginHalf2]) <= 0)
            {
                tempArray[index] = a[beginHalf1];
                beginHalf1++;
            }
            else
            {
                tempArray[index] = a[beginHalf2];
                beginHalf2++;
            }
            index++;
        }
        while(beginHalf1 <= endHalf1)
        {
            tempArray[index] = a[beginHalf1];
            beginHalf1++;
            index++;
        }
        while(beginHalf2 <= endHalf2)
        {
            tempArray[index] = a[beginHalf2];
            beginHalf2++;
            index++;
        }
        for (index = first; index <= last; index ++)
            a[index] = tempArray[index];
    }
}
