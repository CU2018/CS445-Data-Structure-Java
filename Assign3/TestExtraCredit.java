public class TestExtraCredit
{
    public static void main(String[] args)
    {
        System.out.println("Test shorthand notation [A-Z]+");
        String str1 = "[A-Z]+";
        String str2 = "[0-9]*";
        String [] pat1 = {str1, str2};

        MyStringBuilder2 b1 = new MyStringBuilder2("1234HELLOTHERE456Friends---");
        MyStringBuilder2 b2 = new MyStringBuilder2("R2D2IsAVeryWittyDroid");
        MyStringBuilder2 b3 = new MyStringBuilder2("AA22-ABC123abc-ABC123***-BCA321***");

        testMatch(b1, pat1);
        testMatch(b2, pat1);
        testMatch(b3, pat1);

    }

    public static void testMatch(MyStringBuilder2 target, String [] pat)
    {
        System.out.print("Looking for pattern: ");
        for (String X: pat)
            System.out.print(X + " ");
        System.out.println();
        System.out.println("Looking in string: " + target);
        MyStringBuilder2 [] ans = target.regMatch(pat);
        if (ans != null)
        {
            System.out.print("Match: ");
            for (MyStringBuilder2 bb: ans)
                System.out.print(bb + " ");
            System.out.println();
        }
        else
            System.out.println("No match found!");
        System.out.println();
    }
}
