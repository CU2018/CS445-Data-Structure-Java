public class ShellSort
{
    public static <T extends Comparable<? super T>> void shellSort(T[] a, int n)
    {
        shellSort(a, 0, n - 1);
    }

    public static <T extends Comparable<? super T>> void shellSort(T[]a, int first, int last)
    {
        int n = last - first + 1;
        int space = n / 2;
        while (space > 0)
        {
            for (int begin = first; begin < first + space; begin++)
                incrementalInsertionSort(a, begin, last, space);
            space /= 2;
        }
    }

    private static <T extends Comparable<? super T>> void incrementalInsertionSort(T[] a, int first, int last, int space)
    {
        int unsorted, index;
        for (unsorted = first + space; unsorted <= last; unsorted += space)
        {
            T nextToInsert = a[unsorted];
            index = unsorted - space;
            while (index >= first && nextToInsert.compareTo(a[index]) < 0)
            {
                a[index + space] = a[index];
                index -= space;
            }
            a[index + space] = nextToInsert;
        }
    }

}
