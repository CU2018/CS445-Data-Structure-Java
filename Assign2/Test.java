public class Test
{
    public static void main (String[] args)
    {
        /*System.out.println("Test non-arg constructor");
        MyStringBuilder s1 = new MyStringBuilder();
        System.out.println(s1.length());
        System.out.println("Test append(char[] c) method special case empty MyStringBuilder");
        char[] b = {'a','b','c'};
        s1.append(b);
        System.out.println("the length of s1 is "+ s1.length());
        System.out.println("the content of s1 is "+ s1);
        System.out.println("Test append(char c) when there is nothing in MyStringBuilder");
        s1.append('A'); //test append(char c) when there is nothing in MyStringBuilder
        System.out.println("the length of s1 is "+ s1.length());
        System.out.println("the content of s1 is "+ s1);

        System.out.println("Test String constructor");
        MyStringBuilder s2 = new MyStringBuilder("Pepper"); //test constructor MyStringBuilder(String s)
        System.out.println("the length of s2 is "+ s2.length()); //test length()
        System.out.println("the content of s2 is " + s2);

        System.out.println("Test char array constructor");
        char [] c = {'P', 'e', 'p','p','e','r'};
        MyStringBuilder s3 = new MyStringBuilder(c);
        System.out.println("the length of s3 is "+ s3.length());
        System.out.println("the content of s3 is "+ s3);
        System.out.println("Test char append method");
        s3.append('A'); //test append(char c) when there are something in MyStringBuilder
        System.out.println("the length of s3 is "+ s3.length());
        System.out.println("the content of s3 is "+ s3);

        System.out.println("Test append(char[] c) method special case empty array");
        char [] a = {};
        s3.append(a);
        System.out.println("the length of s3 is "+ s3.length());
        System.out.println("the content of s3 is "+ s3);

        System.out.println("Test append(char[] c) method normal case");
        char[] d = {'A','A','A','A'};
        s3.append(d);
        System.out.println("the length of s3 is "+ s3.length());
        System.out.println("the content of s3 is "+ s3);*/

        /*System.out.println("Test append(String s) when there is nothing in MyStringBuilder");
        MyStringBuilder s1 = new MyStringBuilder();
        s1.append("Pepper is good"); //test append(char c) when there is nothing in MyStringBuilder
        System.out.println("the length of s1 is "+ s1.length());
        System.out.println("the content of s1 is "+ s1);

        System.out.println("Test append(String s) when there is nothing in the String");
        String s = new String();
        s1.append(s);
        System.out.println("the length of s1 is "+ s1.length());
        System.out.println("the content of s1 is "+ s1);

        System.out.println("Test append(char[] c) method special case empty array");
        char [] a = new char[0];
        s1.append(a);
        System.out.println("the length of s1 is "+ s1.length());
        System.out.println("the content of s1 is "+ s1);

        System.out.println("Test append(String s) normal case");
        s1.append(" and very very good");
        System.out.println("the length of s1 is "+ s1.length());
        System.out.println("the content of s1 is "+ s1);*/
        /*System.out.println("Test charAt(int index) method");
        MyStringBuilder s1 = new MyStringBuilder("Good");
        System.out.println("Char at index 3 " + s1.charAt(3));
        System.out.println("Test append(String s) method normal case");
        s1.append(" very very good");
        System.out.println("the length of s1 is "+ s1.length());
        System.out.println("the content of s1 is "+ s1);
        System.out.println("Test append(String s) method with nothing in the string");
        String s = null;
        s1.append(s);
        System.out.println("the length of s1 is "+ s1.length());
        System.out.println("the content of s1 is "+ s1);

        System.out.println("Test append(String s) method with nothing in MyStringBuilder");
        MyStringBuilder s2 = new MyStringBuilder();
        String ss = null;
        s2.append(ss);
        System.out.println("the length of s2 is "+ s2.length());
        System.out.println("the content of s2 is "+ s2);*/
        /*MyStringBuilder s1 = new MyStringBuilder("Apple");
        s1.deleteCharAt(0);
        System.out.println(s1);
        s1.deleteCharAt(s1.length()-1);
        System.out.println(s1);
        s1.deleteCharAt(2);
        System.out.println(s1);
        s1.deleteCharAt(1);
        s1.deleteCharAt(0);
        System.out.println(s1);*/
        /*MyStringBuilder s1 = new MyStringBuilder("Pepper");
        s1.delete(1,2);
        System.out.println(s1);
        System.out.println(s1.length());*/
        /*for (int i = 0; i < 10; i++)
            System.out.println(Math.floor(Math.sqrt(i)));*/
        MyStringBuilder s1 = new MyStringBuilder();
        MyStringBuilder s2 = new MyStringBuilder("Pepper");
        s1.append(s2);
        System.out.println(s1 + " " + s1.length());
        s1.setCharAt(2, 'A');
        System.out.println(s1 + " " + s1.length());
        s1.append("Pepper");
        s1.append("Pepper");
        s1.append("Pepper");
        s1.append("Pepper");
        System.out.println(s1 + " " + s1.length());
        System.out.println("Last Index of Pepper is "+ s1.lastIndexOf("pepper"));


        /*MyStringBuilder s1 = new MyStringBuilder("Pepper is a good girl");
        System.out.println(s1.reverse());*/
       /* MyStringBuilder s1 = new MyStringBuilder();
        s1.insert(0,'p');
        s1.insert(0,'p');
        s1.insert(1,'r');
        s1.insert(1,'r');
        System.out.println(s1);
        System.out.println(s1.length());*/

        /*String str = new String();
        StringBuilder strb = new StringBuilder();
        MyStringBuilder mystrb = new MyStringBuilder();

        long startTime4StringAppend = System.nanoTime();
        for (int i = 0; i < 10; i++)   //Test str append()
             System.out.println(str += i);
        long time4StringAppend = System.nanoTime() - startTime4StringAppend;
        System.out.println("Time for String Append is " + time4StringAppend + " nanoseconds");

        long startTime4StrBAppend = System.nanoTime();
        for (int i = 0; i < 10; i++)   //Test strb append()
            System.out.println(strb.append(i));
        long time4StrBAppend = System.nanoTime() - startTime4StrBAppend;
        System.out.println("Time for StringBuiilder append is " + time4StrBAppend + " nanoseconds");

        long startTime4MyStrBAppend = System.nanoTime();
        for (int i = 0; i < 10; i++)   //Test mystrb append()
            System.out.println(mystrb.append(i+""));
        long time4MyStrBAppend = System.nanoTime() - startTime4MyStrBAppend;
        System.out.println("Time for MyStringBuiilder append is " + time4MyStrBAppend + " nanoseconds");

        System.out.println();


        long startTime4StringDelete = System.nanoTime();
        for (int i = 0; i < 10; i++)   //Test str append()
            System.out.println(str = str.substring(1, str.length()));
        long time4StringDelete = System.nanoTime() - startTime4StringDelete;
        System.out.println("Time for String Delete is " + time4StringDelete + " nanoseconds");

        long startTime4StrBDelete = System.nanoTime();
        for (int i = 0; i < 10; i++)   //Test strb delete(0,1)
            System.out.println(strb.delete(0,1));
        long time4StrBDelete = System.nanoTime() - startTime4StrBDelete;
        System.out.println("Time for StringBuiilder delete is " + time4StrBDelete + " nanoseconds");

        long startTime4MyStrBDelete = System.nanoTime();
        for (int i = 0; i < 10; i++)   //Test mystrb delete(0,1)
            System.out.println(mystrb.delete(0,1));
        long time4MyStrBDelete = System.nanoTime() - startTime4MyStrBDelete;
        System.out.println("Time for MyStringBuiilder delete is " + time4MyStrBDelete+ " nanoseconds");


        System.out.println();

        long startTime4StringInsert = System.nanoTime();
        for (int i = 0; i < 10; i++)   //Test str insert()
        {
           //if (str.length() == 0 || str.length() == 1)     //special case: str is null|| str.length() == 1
             //   System.out.println(str += "" + i);
           //else
            //{
                String firstHalf = str.substring(0, str.length() / 2);
                String secondHalf = str.substring(str.length() / 2, str.length());
                System.out.println(str = firstHalf + i + secondHalf);
           // }
        }
        long time4StringInsert = System.nanoTime() - startTime4StringInsert;
        System.out.println("Time for String Insert is " + time4StringInsert + " nanoseconds");

        long startTime4StrBInsert = System.nanoTime();
        for (int i = 0; i < 10; i++)   //Test strb insert()
        {
            //if (strb.length() == 0)
            //    System.out.println(strb.append(i));
            //else
                System.out.println(strb.insert(strb.length()/2,i));
        }
        long time4StrBInsert = System.nanoTime() - startTime4StrBInsert;
        System.out.println("Time for StringBuiilder insert is " + time4StrBInsert + " nanoseconds");

        long startTime4MyStrBInsert = System.nanoTime();
        for (int i = 0; i < 10; i++)   //Test mystrb insert()
            System.out.println(mystrb.insert(mystrb.length()/2,""+i));
        long time4MyStrBInsert = System.nanoTime() - startTime4MyStrBInsert;
        System.out.println("Time for MyStringBuiilder insert is " + time4MyStrBInsert + " nanoseconds");

        long startTime4StringDelete2 = System.nanoTime();
        for (int i = 0; i < 10; i++)   //Test str append()
            System.out.println(str = str.substring(0, str.length()-1));
        long time4StringDelete2 = System.nanoTime() - startTime4StringDelete2;
        System.out.println("Time for String Delete is " + time4StringDelete + " nanoseconds");

        long startTime4StrBDelete2 = System.nanoTime();
        for (int i = 0; i < 10; i++)   //Test strb delete(0,1)
            System.out.println(strb.delete(strb.length(),strb.length()+1));
        long time4StrBDelete2 = System.nanoTime() - startTime4StrBDelete2;
        System.out.println("Time for StringBuiilder delete is " + time4StrBDelete2 + " nanoseconds");

        long startTime4MyStrBDelete2 = System.nanoTime();
        for (int i = 0; i < 10; i++)   //Test mystrb delete(0,1)
            System.out.println(mystrb.delete(mystrb.length()-2,mystrb.length()-1));
        long time4MyStrBDelete2 = System.nanoTime() - startTime4MyStrBDelete;
        System.out.println("Time for MyStringBuiilder delete is " + time4MyStrBDelete2 + " nanoseconds");*/
        char [] c = new char [5];
        MyStringBuilder str = new MyStringBuilder(c);
        System.out.println(str + " " + str.length());
        StringBuilder str2 = new StringBuilder();
    }
}
