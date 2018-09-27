import java.util.*;

public class Assig2B
{
    public static void main(String [] args)
    {
        if (args.length < 1)
        {
            System.out.println("\nusage: C:\\> java Assig2B number of operations\n");
            System.exit(0);
        }
        Scanner kbd = new Scanner(args[0]);
        int N = kbd.nextInt();

        String str = new String();
        StringBuilder strb = new StringBuilder();
        MyStringBuilder mystrb = new MyStringBuilder();

        //String operations
        long startTime4StringAppend = System.nanoTime();
        for (int i = 0; i < N; i++)   //Test str append()
            str += 'A';
        long time4StringAppend = System.nanoTime() - startTime4StringAppend;

        long startTime4StringDelete = System.nanoTime();
        for (int i = 0; i < N; i++)   //Test str delete(1,0)
            str = str.substring(1, str.length());
        long time4StringDelete = System.nanoTime() - startTime4StringDelete;

        long startTime4StringInsert = System.nanoTime();
        for (int i = 0; i < N; i++)   //Test str insert()
        {
            String firstHalf = str.substring(0, str.length() / 2);
            String secondHalf = str.substring(str.length() / 2, str.length());
            str = firstHalf + 'A' + secondHalf;
        }
        long time4StringInsert = System.nanoTime() - startTime4StringInsert;


        //StringBuilder operations
        long startTime4StrBAppend = System.nanoTime();
        for (int i = 0; i < N; i++)   //Test strb append()
            strb.append('A');
        long time4StrBAppend = System.nanoTime() - startTime4StrBAppend;

        long startTime4StrBDelete = System.nanoTime();
        for (int i = 0; i < N; i++)   //Test strb delete(0,1)
            strb.delete(0,1);
        long time4StrBDelete = System.nanoTime() - startTime4StrBDelete;

        long startTime4StrBInsert = System.nanoTime();
        for (int i = 0; i < N; i++)   //Test strb insert()
            strb.insert(strb.length()/2,'a');
        long time4StrBInsert = System.nanoTime() - startTime4StrBInsert;


        //MyStringBuilder operations
        long startTime4MyStrBAppend = System.nanoTime();
        for (int i = 0; i < N; i++)   //Test mystrb append()
            mystrb.append('A');
        long time4MyStrBAppend = System.nanoTime() - startTime4MyStrBAppend;

        long startTime4MyStrBDelete = System.nanoTime();
        for (int i = 0; i < N; i++)   //Test mystrb delete(0,1)
            mystrb.delete(0,1);
        long time4MyStrBDelete = System.nanoTime() - startTime4MyStrBDelete;

        long startTime4MyStrBInsert = System.nanoTime();
        for (int i = 0; i < N; i++)   //Test mystrb insert()
            mystrb.insert(mystrb.length()/2,'a');
        long time4MyStrBInsert = System.nanoTime() - startTime4MyStrBInsert;

        long time4EachStringAppend = time4StringAppend / N;
        long time4EachStringDelete = time4StringDelete / N;
        long time4EachStringInsert = time4StringInsert / N;
        long time4EachStrBAppend = time4StrBAppend / N;
        long time4EachStrBDelete = time4StrBDelete / N;
        long time4EachStrBInsert = time4StrBInsert / N;
        long time4EachMyStrBAppend = time4MyStrBAppend / N;
        long time4EachMyStrBDelete = time4MyStrBDelete / N;
        long time4EachMyStrBInsert = time4MyStrBInsert / N;

        System.out.println("Time for String operations: ");
        System.out.println("All String append operations cost " + time4StringAppend + " nanoseconds;");
        System.out.println("Every String append operation costs " + time4EachStringAppend + " nanoseconds.");
        System.out.println("All String delete operations cost " + time4StringDelete + " nanoseconds;");
        System.out.println("Every String delete operation costs " + time4EachStringDelete + " nanoseconds.");
        System.out.println("All String insert operations cost " + time4StringInsert + " nanoseconds;");
        System.out.println("Every String insert operation costs " + time4EachStringInsert + " nanoseconds.");
        System.out.println();
        System.out.println("Time for all StringBuilder operations: " );
        System.out.println("All StringBuilder append operations cost " + time4StrBAppend + " nanoseconds;");
        System.out.println("Every StringBuilder append operation costs " + time4EachStrBAppend + " nanoseconds.");
        System.out.println("All StringBuilder delete operations cost " + time4StrBDelete + " nanoseconds;");
        System.out.println("Every StringBuilder delete operation costs " + time4EachStrBDelete + " nanoseconds.");
        System.out.println("All StringBuilder insert operations cost " + time4StrBInsert + " nanoseconds;");
        System.out.println("Every StringBuilder insert operation costs " + time4EachStrBInsert + " nanoseconds.");
        System.out.println();
        System.out.println("Time for all MyStringBuilder operations: ");
        System.out.println("All MyStringBuilder append operations cost " + time4MyStrBAppend + " nanoseconds;");
        System.out.println("Every MyStringBuilder append operation costs " + time4EachMyStrBAppend + " nanoseconds.");
        System.out.println("All MyStringBuilder delete operations cost " + time4MyStrBDelete + " nanoseconds;");
        System.out.println("Every MyStringBuilder delete operation costs " + time4EachMyStrBDelete + " nanoseconds.");
        System.out.println("All MyStringBuilder insert operations cost " + time4MyStrBInsert + " nanoseconds;");
        System.out.println("Every StMyStringBuilderring insert operation costs " + time4EachMyStrBInsert + " nanoseconds.");

    }
}
