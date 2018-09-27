// CS 0445 Spring 2018
// Recitation Exercise 3

// Read over the partial implementation of the SimpleRecList below.
// Run the main program (CS445Rec3.java) and trace the constructor and
// toString() methods so that you fully understand how the recursion is 
// working.

// Then add the reverse() method and test it using the same main program
// (after removing the comments)

public class SimpleRecList
{
	private Node<String> front, rear;  // instance variables
	
	public SimpleRecList(String [] data)
	{
		front = null;
		rear = null;
		if (data.length > 0)  // if there is some data, call the recursive
			rec_init(data,0); // method to initialize
	}
	
	// Recursive method to initialize the list with data
	private void rec_init(String [] data, int loc)
	{
		if (loc < data.length-1) // up to the 2nd last value
		{
			// Recursively initialize the rest of the list
			// Then add a new front node with the current data
			// This will serve to build the list from back to front
			// Trace it to see this.
			rec_init(data, loc+1); 
			front = new Node<String>(data[loc], front);
		}
		else if (loc == data.length-1)  // last value
		{
			// Since we have a rear node we must initialize this as
			// a special case.  The cases above assume that the
			// rear pointer has already been set and it will not need
			// to change.
			front = new Node<String>(data[loc]);
			rear = front;
		}
	}
	
	public String toString()
	{
		StringBuilder str = new StringBuilder();
		return rec_toString(front, str);
	}
	
	// Recursive method to convert the list into a String.  This is using
	// a StringBuilder.  Note that the StringBuilder was created above in the
	// non-recursive method, and then it is passed into the recursive method
	// as an argument.
	private String rec_toString(Node<String> curr, StringBuilder B)
	{
		// Rather than going back to front, this method goes front to back.
		// If we still have Nodes left, add the data from the current Node
		// to the StringBuilder and then recursively get the String of the
		// remaining nodes.
		if (curr != null)
		{
			B.append(curr.getData());
			B.append(" ");
			return rec_toString(curr.getNextNode(), B);
		}
		// When we get to null all of the data has been added so just return
		// the String.
		else
			return B.toString();
	}
	
	// Method to reverse the data in the list.
	// You must implement this method
	// public void reverse()
	public void reverse()
	{
		rec_reverse(front);
	}

	private Node rec_reverse(Node<String> curr)
	{
		if (curr == null) return null; // base case 1: empty linked list
		if (curr.getNextNode() == null)    //base case 2: recurse to the last node of the list, which is also the new front
		{
			front = curr;   //new front node
			return curr;
		}
		else  //recursive case: reverse the remaining
		{
			Node<String> temp = rec_reverse(curr.getNextNode());
			temp.setNextNode(curr);  //这里的curr是当前activation record的local variable curr
			curr.setNextNode(null);
			rear = curr; //当前最后一个node应该是curr 而不是temp
			return curr;
		}
	}
}
