import java.util.*;
public class TestInsertion
{
    public static void main(String[] args)
    {
        if (args.length < 1)
        {
            System.out.println("\nusage:C:\\> java TestInsertion /the size of the array/ \n\n");
            System.exit(0);
        }
        Scanner cmd = new Scanner(args[0]);
        int asize = cmd.nextInt();
        Integer [] a1 = new Integer[asize];
        Integer [] a2 = new Integer[asize];

        Random r = new Random(50);
        for (int i = 0; i < asize; i++)
        {
            a1[i] = r.nextInt(1000);
            a2[i] = a1[i];
        }

        long start1 = System.nanoTime();
        Insertion.insertionSort(a1, asize);
        long end1 = System.nanoTime();
        long start2 = System.nanoTime();
        Insertion.insertionSort2(a2, asize);
        long end2 = System.nanoTime();
        System.out.println("Time for iterative insertion: " + (end1 - start1));
        System.out.println("Time for recursive insertion: " + (end2 - start2));

    }
}
