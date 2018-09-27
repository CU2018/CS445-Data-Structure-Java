package MyTreePackage;

import java.util.ArrayList;
import java.util.Collections;

public class ComparableBinaryTree<T extends Comparable<? super T>> extends BinaryTree<T>
        implements  ComparableTreeInterface<T>
{
    public ComparableBinaryTree()
    {
        super();
    }

    public ComparableBinaryTree(T rootData)
    {
        super();
        setRootNode(new BinaryNode<>(rootData));
    }

    // If the tree is not empty, return the maximum
    // value in the tree; otherwise return null
    public T getMax()
    {
        return getMax(getRootNode());
    }

    private T getMax(BinaryNode<T> current)
    {
        T max = null;
        if (current != null)
        {
            max = current.getData();
            T leftMax = getMax(current.getLeftChild());
            T rightMax = getMax(current.getRightChild());
            if (leftMax == null && rightMax == null) //only one node
                return max;
            else if (leftMax != null && rightMax == null)//only has left child
            {
                if (leftMax.compareTo(max) > 0)
                    max = leftMax;
            }
            else if (rightMax != null && leftMax == null)// only has right child
            {
                if (rightMax.compareTo(max) > 0)
                    max = rightMax;
            }
            else   // has two children
            {
                assert leftMax != null && rightMax != null;
                if (leftMax.compareTo(rightMax) > 0 && leftMax.compareTo(max) > 0) // leftMax is the max
                    max = leftMax;
                else if (rightMax.compareTo(leftMax) > 0 && rightMax.compareTo(max) > 0) // rightMax is the max
                    max = rightMax;
            }
        }
        return max;
    }




    // If the tree is not empty, return the minimum
    // value in the tree; otherwise return null
    public T getMin()
    {
        return getMin(getRootNode());
    }

    private T getMin(BinaryNode<T> current)
    {
        T min = null;
        if (current != null)
        {
            min = current.getData();
            T leftMin = getMin(current.getLeftChild());
            T rightMin = getMin(current.getRightChild());
            if (leftMin == null && rightMin == null) //only// one node
                return min;
            else if (leftMin != null && rightMin == null)//only has left child
            {
                if (leftMin.compareTo(min) < 0)
                    min = leftMin;
            } else if (rightMin != null && leftMin == null)// only has right child
            {
                if (rightMin.compareTo(min) < 0)
                    min = rightMin;
            } else   // has two children
            {
                assert leftMin != null && rightMin != null;
                if (leftMin.compareTo(rightMin) < 0 && leftMin.compareTo(min) < 0) // leftMax is the max
                    min = leftMin;
                else if (rightMin.compareTo(leftMin) < 0 && rightMin.compareTo(min) < 0) // rightMax is the max
                    min = rightMin;
            }
        }
        return min;
    }

    // Return true if the the tree meets the
    // recursive definition of a BST; else
    // return false
    public boolean isBST()
    {
        return isBST(getRootNode());
    }

    private boolean isBST(BinaryNode<T> current)
    {
        if (current == null) return true;
        else if (current.isLeaf()) return true;
        else if (current.hasLeftChild() && !current.hasRightChild()) //has only left child
        {
            if (current.getLeftChild().getData().compareTo(current.getData()) > 0)
                return false;
            else
                return isBST(current.getLeftChild());  //check whether left subtree is a bst
        }
        else if (current.hasRightChild() && !current.hasLeftChild())   //has only right child
        {
            if (current.getRightChild().getData().compareTo(current.getData()) <= 0)
                return false;
            else
                return isBST(current.getRightChild());     //check whether right subtree is a bst
        }
        else      //has both left and right child
        {
            if (current.getLeftChild().getData().compareTo(current.getData()) > 0
                    ||current.getRightChild().getData().compareTo(current.getData()) <= 0)
                return false;
            else
                return isBST(current.getLeftChild())&&isBST(current.getRightChild()); //check whether left and right subtrees are both bsts
        }

    }

    // Return the rank of data in the tree
    // with 0 being the smallest answer and
    // N being the largest answer.  data does not have to be
    // present in the tree.  If duplicates are present in the tree
    // this answer should be minimized.
    public int rank(T data)
    {
        return rank(data, getRootNode());
    }

    private int rank(T data, BinaryNode<T> current)
    {
        int rank = 0;
        if (current == null) return rank; // base case: node is empty
        int cmp = data.compareTo(current.getData());
        if (cmp > 0) rank++;
       // if (current.hasLeftChild())   // recursive case: recursively get rank from left subtrees
            rank += rank(data, current.getLeftChild());
        //if (current.hasRightChild())   // recursive case: recursively get rank from right subtrees
            rank += rank(data, current.getRightChild());
        return rank;
    }

    // Return the value in the tree with rank
    // i in the ordering.  If there are duplicates
    // the first occurrence should be returned.
    public T get(int i)
    {
        int bound = 0;
        if (getRootNode() != null)
            bound = getRootNode().getNumberOfNodes();
        if (i < 0 || i > bound - 1)
            throw new IndexOutOfBoundsException();
        ArrayList<T> arr = new ArrayList<>(bound);
        toArray(arr, getRootNode());
        Collections.sort(arr);
        return arr.get(i);
    }

    private void toArray(ArrayList<T> arr,  BinaryNode<T> current)
    {
        if (current != null)
        {
            arr.add(current.getData());
            if (current.hasLeftChild())
                toArray(arr, current.getLeftChild());
            if (current.hasRightChild())
                toArray(arr, current.getRightChild());
        }
    }

}
