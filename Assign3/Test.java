public class Test
{
    static char ca;
    public static void main(String[] args)
    {
        /*char[] c = {'a','b','c'};
        MyStringBuilder2 str = new MyStringBuilder2(c);
        str.reverse();
        MyStringBuilder2 str2 = new MyStringBuilder2("Pepper");
        str2.reverse();
        System.out.println(str + " " +  str.length());
        System.out.println(str2 + " " +  str2.length());
        //System.out.println(str2.getNodeAt(1).data);
        System.out.println(str2.substring(0,6));
        System.out.println(str2.charAt(5));
        str2.reverse().append(ca);
        System.out.println(str2);
        MyStringBuilder2 str3 = new MyStringBuilder2();
        str3.append('A');
        System.out.println(str3);
        str3.append('A');
        System.out.println(str3);
        str3.append(c);
        System.out.println(str3);
        str3.append("Pepper");
        //System.out.println(str3 + " "+ str3.length() + " "+ str3.lastC.data);
        str2.append(str3);
        System.out.println(str2 + " " + str2.length()+ " "+ str2.firstC.data + " "+str2.lastC.data);
        str2 = new MyStringBuilder2();
        str2.append(str3);
        System.out.println(str2 + " " + str2.length()+ " "+ str2.firstC.data + " "+str2.lastC.data);
        str2.deleteCharAt(3);
        System.out.println(str2 + " " + str2.length()+ " "+ str2.firstC.data + " "+str2.lastC.data);
        str2.delete(0,8);
        //System.out.println(str2 + " " + str2.length()+ " "+ str2.firstC.data + " "+str2.lastC.data);
        System.out.println(str2 + " " + str2.length());
        str2.insert(2,'A');
        System.out.println(str2 + " " + str2.length()+ " "+ str2.firstC.data + " "+str2.lastC.data);
        char[] c2 = {'1', '2', '3', '4','5'};
        str2 = new MyStringBuilder2();
        str2.insert(0,c2);
        System.out.println(str2 + " " + str2.length()+ " "+ str2.firstC.data + " "+str2.lastC.data);
        str2.insert(0,"AAAAPepper");
        System.out.println(str2 + " " + str2.length()+ " "+ str2.firstC.data + " "+str2.lastC.data);
        str2.insert(3,c2);
        System.out.println(str2 + " " + str2.length()+ " "+ str2.firstC.data + " "+str2.lastC.data);
        str2.insert(4,"AA");

        //str2.insert(3,"AA");
        System.out.println(str2 + " " + str2.length()+ " "+ str2.firstC.data + " "+str2.lastC.data);
        str2.insert(11,"a");
        System.out.println(str2 + " " + str2.length()+ " "+ str2.firstC.data + " "+str2.lastC.data);
        str2.insert(3,c2);
        System.out.println(str2 + " " + str2.length()+ " "+ str2.firstC.data + " "+str2.lastC.data);
        //str2.insert(2,"AA");
        //System.out.println(str2 + " " + str2.length()+ " "+ str2.firstC.data + " "+str2.lastC.data);*/
        MyStringBuilder2 str = new MyStringBuilder2("perpepperperr");
        str.replace(3,5,"AAAAA");
        System.out.println(str +" " + str.length());
        System.out.println(str.indexOf("per"));
        System.out.println(str.lastIndexOf("perr"));
        String patA = "PAB", patB = "456", patC = "ABC";
        String[] patterns = {patA, patB, patC};
        MyStringBuilder2 B = new MyStringBuilder2("666PPPPP56AAAAA");
        MyStringBuilder2 [] ans = B.regMatch(patterns);
        if (ans != null){
        for (int i = 0; i < ans.length; i++)
            System.out.println(ans[i]);}
        String str1 = "[A-Z]+";
        String str2 = "[0-9]*";
        String[] pats = {str1, str2};
        shorthandTest(pats, 0);
        System.out.println(pats[0]);
    }
    public static void shorthandTest (String[] pats, int i)
    {
        System.out.println("[A-Z]+" + pats[i].equals("[A-Z]+"));
        System.out.println("[0-9]*" + pats[i].equals("[0-9]*"));
        if (i < pats.length - 1)
        {
            if (pats[i].equals("[A-Z]+"))
                pats[i] = new String ("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
            else if ((pats[i]).equals("[0-9]*"))
                pats[i] = new String ("0123456789");
            System.out.println(pats[i]);
            shorthandTest(pats, i+1);
        }
    }
}
