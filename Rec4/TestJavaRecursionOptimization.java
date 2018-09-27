import java.util.Random;
import java.util.Scanner;

public class TestJavaRecursionOptimization
{
    public static void main(String[] args)
    {
        System.out.print("Enter the number of the array: ");
        System.out.println();
        Scanner kbd = new Scanner(System.in);
        int anumber = kbd.nextInt();
        System.out.print("Enter the size of the array: ");
        System.out.println();
        int asize = kbd.nextInt();

        Random generator = new Random();
        Integer[] a1 = new Integer[asize];
        Long[] times = new Long[anumber];
        for (int i = 0; i < anumber; i++)
        {
            for (int j = 0; j < asize; j++)
                a1[j] = generator.nextInt();
            long start = System.nanoTime();
            Insertion.insertionSort2(a1, asize);
            long end = System.nanoTime();
            times[i] = end - start;
        }
        long total = 0;
        for (int i = 0; i < times.length; i++)
            total += times[i];
        System.out.println(total / anumber);

        //hardcode: Java optimize recursion when the size and number of the array is hardcoded instead of
        //getting the int from the users like the one above; therefore, theoretically, recursive InsertionSort
        //is slower than iterative InsertionSort due to overhead of run-time stack and activation records
        int anumber2 = 5;
        int asize2 = 1000;
        Integer[] a2 = new Integer[asize2];
        Long[] times2 = new Long[anumber2];
        for (int i = 0; i < anumber2; i++)
        {
            for (int j = 0; j < asize2; j++)
                a2[j] = generator.nextInt();
            long start = System.nanoTime();
            Insertion.insertionSort2(a2, asize2);
            long end = System.nanoTime();
            times2[i] = end - start;
        }
        long total2 = 0;
        for (int i = 0; i < times.length; i++)
            total2 += times2[i];
        System.out.println(total2 / anumber);
    }

}
