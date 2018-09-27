public class TestExtraCredit
{
    public static void main(String [] args)
    {
        MyStringBuilder b1 = new MyStringBuilder("Pepper");
        for (int i = 0; i < 5; i++)
            b1.append("Pepper");
        System.out.println("Now, b1 is: " + b1 + " and its length is " + b1.length());
        System.out.println();
        System.out.println("Testing setCharAt(int index, char ch) method: change index 30 to 'A'");
        b1.setCharAt(30,'A');
        System.out.println("Now, b1 is: " + b1 + " and its length is " + b1.length());
        System.out.println("Testing setCharAt(int index, char ch) method: change index 0 to 'B'");
        b1.setCharAt(0,'B');
        System.out.println("Now, b1 is: " + b1 + " and its length is " + b1.length());
        System.out.println();
        System.out.println("Testing lastIndexOf(String str) method: find the last index of String /Pepper/ ");
        int index = b1.lastIndexOf("Pepper");
        System.out.println("The last index of String /Pepper/ is " + index);
        System.out.println("Testing lastIndexOf(String str) method: find the last index of String /pepper/ ");
        index = b1.lastIndexOf("pepper");
        System.out.println("The last index of String /pepper/ is " + index);
        System.out.println("Testing lastIndexOf(String str) method: find the last index of String /Bepper/ ");
        index = b1.lastIndexOf("Bepper");
        System.out.println("The last index of String /Bepper/ is " + index);
        MyStringBuilder b2 = new MyStringBuilder();
        System.out.println( b2.reverse());
    }
}
