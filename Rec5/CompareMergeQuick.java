import java.util.*;
public class CompareMergeQuick
{
    public static void main(String[] args)
    {
        if (args.length < 2)
        {
            System.out.println("\nusage:C:\\> java CompareMergeQuick /the size of the array/ +" +
                    "/the base case size for the quicksort/ \n\n");
            System.exit(0);
        }
        int asize = new Scanner(args[0]).nextInt();
        int bsize = new Scanner(args[1]).nextInt();
        Integer [] a1 = new Integer[asize];
        Integer [] a2 = new Integer[asize];

        Random r = new Random(50);
        for (int i = 0; i < asize; i++)
        {
            a1[i] = r.nextInt(1000);
            a2[i] = a1[i];
        }

        long start1 = System.nanoTime();
        TextMergeQuick.mergeSort(a1, asize);
        long end1 = System.nanoTime();

        TextMergeQuick.setMin(bsize);
        long start2 = System.nanoTime();
        TextMergeQuick.quickSort(a2, asize);
        long end2 = System.nanoTime();
        System.out.println("Time for MergeSort with array size of " + asize + ": "  +(end1 - start1));
        System.out.println("Time for QuickSort with array size of " + asize +
                " and base case size of " + bsize + ": "+ (end2 - start2));

    }
}

