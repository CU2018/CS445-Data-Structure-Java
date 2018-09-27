import java.util.*;
public class TestSort
{
    public static void main (String[] args)
    {

        int asize = 10;
        Integer [] a1 = new Integer[asize];

        Random r = new Random(50);
        for (int i = 0; i < asize; i++)
        {
            a1[i] = r.nextInt(1000);
            System.out.print(a1[i] + " ");
        }
        System.out.println();
        //InsertionSort.insertionSort(a1, asize);
        //InsertionSort.insertionSort2(a1, asize);
        //ShellSort.shellSort(a1,asize);
        //MergeSort.mergeSort(a1, asize);
        QuickSort.quickSort(a1,asize);
        for (int i = 0; i < asize; i++)
        {
            System.out.print(a1[i]+ " ");
        }
    }
}
