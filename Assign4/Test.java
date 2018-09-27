import MyTreePackage.*;

public class Test
{
    public static void main (String[] args)
    {
        BinaryNode<Integer> root = init5();
        ComparableBinaryTree<Integer> T1 = new ComparableBinaryTree<>();
        T1.setRootNode(root);
        System.out.println("The tree is full? " + root.isFull());
        for (int i = 0; i < 3; i++)
        {
            boolean bal = T1.isBalanced(i);
            if (bal)
                System.out.println("Tree is " + i + " balanced");
            else
                System.out.println("Tree is NOT " + i + " balanced");
        }
        System.out.println(T1.getMax());
        System.out.println(T1.getMin());
        System.out.println("The tree is BST? " + T1.isBST());
        System.out.println("Value 100 has rank: " + T1.rank(100));
        for (int i = -1; i < 16; i++) // Find some ranks of some values
        {
            try
            {
                int val = T1.get(i);
                System.out.println("Rank " + i + " item is " + val);
            }
            catch (IndexOutOfBoundsException e)
            {
                System.out.println("Index " + i + " out of range for tree");
            }
        }
        System.out.println();
        T1.saveInorder("BST1.dat");

        BinaryTree<Integer> T2 = new BinaryTree<>();
        T2.buildInorder("BST1.dat");
        System.out.println(T2.getRootData());
    }

    public static BinaryNode<Integer> init1()
    {
        BinaryNode<Integer> temp1 = new BinaryNode<Integer>(new Integer(60));
        BinaryNode<Integer> temp2 = new BinaryNode<Integer>(new Integer(30));
        BinaryNode<Integer> temp3 = new BinaryNode<Integer>(new Integer(80), temp1, temp2);
        temp1 = new BinaryNode<Integer>(new Integer(20));
        temp2 = new BinaryNode<Integer>(new Integer(15), temp1, temp3);
        temp3 = temp2;
        temp2 = new BinaryNode<Integer>(new Integer(50));
        temp1 = new BinaryNode<Integer>(new Integer(40), null, temp2);
        temp2 = new BinaryNode<Integer>(new Integer(75));
        BinaryNode<Integer> temp4 = new BinaryNode<Integer>(new Integer(65), temp1, temp2);
        temp1 = new BinaryNode<Integer>(new Integer(90), temp4, temp3);
        return temp1;
    }
    public static BinaryNode<Integer> init2()
    {
        BinaryNode<Integer> temp1 = new BinaryNode<Integer>(new Integer(17));
        BinaryNode<Integer> temp2 = new BinaryNode<Integer>(new Integer(20), temp1, null);
        temp1 = new BinaryNode<Integer>(new Integer(10));
        BinaryNode<Integer> temp3 = new BinaryNode<Integer>(new Integer(15), temp1, temp2);
        temp2 = new BinaryNode<Integer>(new Integer(30));
        temp1 = new BinaryNode<Integer>(new Integer(25), temp3, temp2);
        temp3 = temp1;

        temp1 = new BinaryNode<Integer>(new Integer(55));
        temp2 = new BinaryNode<Integer>(new Integer(70));
        BinaryNode<Integer> temp4 = new BinaryNode<Integer>(new Integer(60), temp1, temp2);
        temp1 = new BinaryNode<Integer>(new Integer(80));
        temp2 = new BinaryNode<Integer>(new Integer(85), temp1, null);
        temp1 = new BinaryNode<Integer>(new Integer(75), temp4, temp2);

        temp4 = new BinaryNode<Integer>(new Integer(50), temp3, temp1);
        return temp4;
    }
    public static BinaryNode<Integer> init3()
    {
        BinaryNode<Integer> temp1 = new BinaryNode<Integer>(new Integer(5));
        BinaryNode<Integer> temp2 = new BinaryNode<Integer>(new Integer(15));
        BinaryNode<Integer> temp3 = new BinaryNode<Integer>(new Integer(80), temp1, temp2);

        temp1 = new BinaryNode<Integer>(new Integer(40));
        temp2 = new BinaryNode<Integer>(new Integer(10));
        BinaryNode<Integer> temp4 = new BinaryNode<Integer>(new Integer(70), temp1, temp2);

        temp3 = new BinaryNode<Integer>(new Integer(50), temp3, temp4);
        return temp3;
    }

    public static BinaryNode<Integer> init4()
    {
        BinaryNode<Integer> temp1 = new BinaryNode<>(new Integer(5));
        BinaryNode<Integer> temp2 = new BinaryNode<>(new Integer(15));
        BinaryNode<Integer> temp3 = new BinaryNode<>(new Integer(80), temp1, temp2);
        BinaryNode<Integer> temp4 = new BinaryNode<>(new Integer(90));
        BinaryNode<Integer> temp5 = new BinaryNode<>(new Integer(10), temp3, temp4);

        return temp5;
    }

    public static BinaryNode<Integer> init5()
    {
        BinaryNode<Integer> temp1 = new BinaryNode<>(new Integer(5));
        BinaryNode<Integer> temp3 = new BinaryNode<>(new Integer(1), temp1, null);
        return temp3;
    }
}
