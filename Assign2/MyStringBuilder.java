// CS 0445 Spring 2018
// Read this class and its comments very carefully to make sure you implement
// the class properly.  Note the items that are required and that cannot be
// altered!  Generally speaking you will implement your MyStringBuilder using
// a singly linked list of nodes.  See more comments below on the specific
// requirements for the class.

import java.util.ArrayList;
import java.util.Collections;

// For more details on the general functionality of most of these methods,
// see the specifications of the similar method in the StringBuilder class.  
public class MyStringBuilder
{
	// These are the only three instance variables you are allowed to have.
	// See details of CNode class below.  In other words, you MAY NOT add
	// any additional instance variables to this class.  However, you may
	// use any method variables that you need within individual methods.
	// But remember that you may NOT use any variables of any other
	// linked list class or of the predefined StringBuilder or 
	// or StringBuffer class in any place in your code.  You may only use the
	// String class where it is an argument or return type in a method.
	private CNode firstC;	// reference to front of list.  This reference is necessary
							// to keep track of the list
	private CNode lastC; 	// reference to last node of list.  This reference is
							// necessary to improve the efficiency of the append()
							// method
	private int length;  	// number of characters in the list

	// You may also add any additional private methods that you need to
	// help with your implementation of the public methods.

	// Create a new MyStringBuilder initialized with the chars in String s
	public MyStringBuilder(String s)
	{
		if (s == null || s.length() == 0) //if the String is null
		{
			firstC = null;
			lastC = null;
			length = 0;
		}
		else
		{
			firstC = new CNode(s.charAt(0)); //create the first node and put the first char of String s into the node
			length = 1;
			CNode currentNode = firstC;

			for (int i = 1; i < s.length(); i++) //after having the first node, we can use loop to put rest chars into each node
			{
				CNode newNode = new CNode(s.charAt(i));
				currentNode.next = newNode;
				currentNode = newNode;
				length++;
			}
			lastC = currentNode;
		}
	}

	// Create a new MyStringBuilder initialized with the chars in array s
	public MyStringBuilder(char [] s)
	{
		if (s == null || s.length == 0) //special case: char array is empty
		{
			firstC = null;
			lastC = null;
			length = 0;
		}
		else //normal case:
		{
			firstC = new CNode(s[0]);
			length = 1;
			CNode currentNode = firstC;

			for (int i = 1; i < s.length; i++)
			{
				CNode newNode = new CNode(s[i]);
				currentNode.next = newNode;
				currentNode = newNode;
				length++;
			}
			lastC = currentNode;
		}
	}

	// Create a new empty MyStringBuilder
	public MyStringBuilder()
	{
		firstC = null;
		lastC = null;
		length = 0;
	}

	// Append MyStringBuilder b to the end of the current MyStringBuilder, and
	// return the current MyStringBuilder.  Be careful for special cases!
	public MyStringBuilder append(MyStringBuilder b)
	{
		if (b == null || b.length == 0) //special case: b is empty
			return this;
		else if (this.length == 0) //special case: this object is empty
		{
			CNode readNode = b.firstC;
			firstC = new CNode(readNode.data);
			readNode = readNode.next;
			length = 1;
			CNode currentNode = firstC;

			for (int i = 1; i < b.length; i++)
			{
				CNode newNode = new CNode(readNode.data);
				readNode = readNode.next;
				currentNode.next = newNode;
				currentNode = newNode;
				length++;
			}
			lastC = currentNode;
		}
		else             //normal case
		{
			CNode readNode = b.firstC;
			for (int i = 0; i < b.length; i++)
			{
				CNode newNode = new CNode(readNode.data);
				readNode = readNode.next;
				lastC.next = newNode;
				lastC = newNode;
				length++;
			}
		}
		return this;
	}


	// Append String s to the end of the current MyStringBuilder, and return
	// the current MyStringBuilder.  Be careful for special cases!
	public MyStringBuilder append(String s)
	{
		if (s == null || s.length() == 0) // special case: string is empty
			return this;
		else if (this.length == 0) // special case: this object is empty
		{
			firstC = new CNode(s.charAt(0));
			length = 1;
			CNode currentNode = firstC;

			for (int i = 1; i < s.length(); i++)
			{
				CNode newNode = new CNode(s.charAt(i));
				currentNode.next = newNode;
				currentNode = newNode;
				length++;
			}
			lastC = currentNode;
		}
		else                   // normal case
		{
			for (int i = 0; i < s.length(); i++)
			{
				CNode newNode = new CNode(s.charAt(i));
				lastC.next = newNode;
				lastC = newNode;
				length++;
			}
		}
		return this;
	}

	// Append char array c to the end of the current MyStringBuilder, and
	// return the current MyStringBuilder.  Be careful for special cases!
	public MyStringBuilder append(char [] c)
	{
		if (c == null || c.length == 0) //special case: char array is empty
			return this;
		else if (this.length == 0)      // special case: this object is empty
		{
			firstC = new CNode(c[0]);
			length = 1;
			CNode currentNode = firstC;

			for (int i = 1; i < c.length; i++)
			{
				CNode newNode = new CNode(c[i]);
				currentNode.next = newNode;
				currentNode = newNode;
				length++;
			}
			lastC = currentNode;
		}
		else                //normal case
		{
			for (int i = 0; i < c.length; i++)
			{
				CNode newNode = new CNode(c[i]);
				lastC.next = newNode;
				lastC = newNode;
				length++;
			}
		}
		return this;
	}

	// Append char c to the end of the current MyStringBuilder, and
	// return the current MyStringBuilder.  Be careful for special cases!
	public MyStringBuilder append(char c)
	{
		if (this.length == 0)         //special case: this object is empty
		{
			firstC = new CNode(c);
			lastC = firstC;
			length = 1;
		}
		else if (c == 0)          //special case: c is empty
			return this;
		else              // normal case
		{
			CNode newNode = new CNode(c);
			lastC.next = newNode;
			lastC = newNode;
			length++;
		}
		return this;
	}

	// Return the character at location "index" in the current MyStringBuilder.
	// If index is invalid, throw an IndexOutOfBoundsException.
	public char charAt(int index)
	{
		if (index >= 0 && index < this.length)
		{
			assert this.length != 0;
			return getNodeAt(index).data;
		}
		else throw new IndexOutOfBoundsException("Illegal index given to charAt operation");
	}

	// Delete the characters from index "start" to index "end" - 1 in the
	// current MyStringBuilder, and return the current MyStringBuilder.
	// If "start" is invalid or "end" <= "start" do nothing (just return the
	// MyStringBuilder as is).  If "end" is past the end of the MyStringBuilder, 
	// only remove up until the end of the MyStringBuilder. Be careful for 
	// special cases!
	public MyStringBuilder delete(int start, int end)
	{
		if ((start >= 0) && (start < this.length) && (end > start)) //when the start and end are valid
		{
			assert this.length != 0;

			if (start == 0)     // special case: delete the first node
			{
				if (this.length <= end - start)   // special case: delete the first node till the end
				{
					firstC = null;
					lastC = null;
					length = 0;
				}
				else        //special case: delete the first node till the "middle"
				{
					firstC = getNodeAt(end);
					length -= end;
				}
			}
			else if (end >= this.length)        //special case: the end passes the length but not start at 0
			{
				assert start != 0;
				CNode nodeBefore = this.getNodeAt(start - 1);
				nodeBefore.next = null;
				lastC = nodeBefore;
				length = start;
			}
			else       // normal case
			{
				CNode nodeBefore = this.getNodeAt(start - 1);
				CNode nodeAfter = nodeBefore.next;
				for (int i = 0; i < end - start; i++)
					nodeAfter = nodeAfter.next;
				nodeBefore.next = nodeAfter;
				length = this.length - (end - start);
			}
		}
		return this;
	}

	// Delete the character at location "index" from the current
	// MyStringBuilder and return the current MyStringBuilder.  If "index" is
	// invalid, do nothing (just return the MyStringBuilder as is).
	// Be careful for special cases!
	public MyStringBuilder deleteCharAt(int index)
	{
		if (index >= 0 && index < this.length) //when the index is valid
		{
			assert this.length != 0;
			if (index == 0)      // special case: delete the first node
			{
				firstC = firstC.next;
				if (this.length == 1)      // special case: delete the first node which is also the last node
					lastC = null;
			}
			else       //normal case
			{
				CNode nodeBefore = this.getNodeAt(index - 1);
				nodeBefore.next = nodeBefore.next.next;
				if (index == this.length - 1)     //special case: delete the last node
					lastC = nodeBefore;
			}
			length--;
		}
		return this;
	}

	// Find and return the index within the current MyStringBuilder where
	// String str first matches a sequence of characters within the current
	// MyStringBuilder.  If str does not match any sequence of characters
	// within the current MyStringBuilder, return -1.  Think carefully about
	// what you need to do for this method before implementing it.
	public int indexOf(String str)
	{
		CNode outerNode = firstC;
		CNode innerNode = firstC;
		for (int i = 0; i <= this.length - str.length(); i++)
		{
			int j;
			for (j = 0; j < str.length(); j++)
			{
				if (innerNode.data != str.charAt(j))
					break;
				innerNode = innerNode.next;
			}
			if (j >= str.length())
				return i;
			outerNode = outerNode.next;
			innerNode = outerNode;
		}

		return -1;
	}

	// Insert String str into the current MyStringBuilder starting at index
	// "offset" and return the current MyStringBuilder.  if "offset" == 
	// length, this is the same as append.  If "offset" is invalid
	// do nothing.
	public MyStringBuilder insert(int offset, String str)
	{
		if (offset >= 0 && offset <= this.length)  //when the offset is valid
		{
			if (str == null || str.length() == 0)           //special case: string is empty
				return this;
			else if (offset == this.length || this.length == 0)  // special case: insert to the end or when this object is empty
				this.append(str);
			else
			{
				CNode strFirst = new CNode(str.charAt(0));
				CNode strLast;
				CNode currentNode = strFirst;
				for (int i = 1; i < str.length(); i++)
				{
					CNode newNode = new CNode(str.charAt(i));
					currentNode.next = newNode;
					currentNode = newNode;
				}
				strLast = currentNode;
				if (offset == 0)                 // special case: insert at the front
				{
					strLast.next = firstC;
					firstC = strFirst;
				}
				else        //normal case
				{
					CNode offsetNode = this.getNodeAt(offset - 1);
					strLast.next = offsetNode.next;
					offsetNode.next = strFirst;
				}
				length += str.length();
			}
		}
		return this;
	}

	// Insert character c into the current MyStringBuilder at index
	// "offset" and return the current MyStringBuilder.  If "offset" ==
	// length, this is the same as append.  If "offset" is invalid, 
	// do nothing.
	public MyStringBuilder insert(int offset, char c)
	{
		if (offset >= 0 && offset <= this.length)  //when offset is valid
		{
			if (c == 0)        //special case: char is empty
				return  this;
			else if (offset == this.length || this.length == 0)  // special case: insert to the end or when this object is empty
				this.append(c);
			else
			{
				CNode newNode = new CNode(c);
				if (offset == 0)          // special case: insert at the front
				{
					newNode.next = firstC;
					firstC = newNode;
				}
				else
				{
					CNode offsetNode = this.getNodeAt(offset - 1);
					newNode.next = offsetNode.next;
					offsetNode.next = newNode;
				}
				length++;
			}
		}

		return this;
	}

	// Insert char array c into the current MyStringBuilder starting at index
	// index "offset" and return the current MyStringBuilder.  If "offset" is
	// invalid, do nothing.
	public MyStringBuilder insert(int offset, char [] c)
	{
		if (offset >= 0 && offset <= this.length)  //when offset is valid
		{
			if (c == null || c.length == 0)           //special case: string is empty
				return this;
			else if (offset == this.length || this.length == 0)  // special case: insert to the end or when this object is empty
				this.append(c);
			else
			{
				CNode strFirst = new CNode(c[0]);
				CNode strLast;
				CNode currentNode = strFirst;
				for (int i = 1; i < c.length; i++)
				{
					CNode newNode = new CNode(c[i]);
					currentNode.next = newNode;
					currentNode = newNode;
				}
				strLast = currentNode;
				if (offset == 0)        // special case: insert at the front
				{
					strLast.next = firstC;
					firstC = strFirst;
				}
				else         //normal case
				{
					CNode offsetNode = this.getNodeAt(offset - 1);
					strLast.next = offsetNode.next;
					offsetNode.next = strFirst;

				}
				length += c.length;
			}
		}
		return this;
	}

	// Return the length of the current MyStringBuilder
	public int length()
	{
		return length;
	}

	// Delete the substring from "start" to "end" - 1 in the current
	// MyStringBuilder, then insert String "str" into the current
	// MyStringBuilder starting at index "start", then return the current
	// MyStringBuilder.  If "start" is invalid or "end" <= "start", do nothing.
	// If "end" is past the end of the MyStringBuilder, only delete until the
	// end of the MyStringBuilder, then insert.  This method should be done
	// as efficiently as possible.  In particular, you may NOT simply call
	// the delete() method followed by the insert() method, since that will
	// require an extra traversal of the linked list.
	public MyStringBuilder replace(int start, int end, String str)
	{
		if (this.length == 0)        // special case: the object is empty
			this.append(str);
		else if ((start >= 0) && (start < this.length) && (end > start)) //when the start and end are valid
		{
			if (str.length() == 0 || str == null) //special case: the str is empty
				return this;
			else if (start == 0)      //special case: replace from the front
			{
				CNode strFirst = new CNode(str.charAt(0));
				CNode strLast;
				CNode currentNode = strFirst;
				for (int i = 1; i < str.length(); i++)
				{
					CNode newNode = new CNode(str.charAt(i));
					currentNode.next = newNode;
					currentNode = newNode;
				}
				strLast = currentNode;
				if (this.length <= end - start)     //special case: replace from the front and end passes the length
				{
					lastC = strLast;
					length = str.length();
				}
				else           //special case: replace from the front but the end does not pass the length
				{
					strLast.next = this.getNodeAt(end);
					length = this.length - (end - start) + str.length();
				}
				firstC = strFirst;
			}
			else         // not start at the front / 0
			{
				assert start != 0;
				CNode strFirst = new CNode(str.charAt(0));
				CNode strLast;
				CNode currentNode = strFirst;
				for (int i = 1; i < str.length(); i++)
				{
					CNode newNode = new CNode(str.charAt(i));
					currentNode.next = newNode;
					currentNode = newNode;
				}
				strLast = currentNode;
				CNode nodeBefore = this.getNodeAt(start - 1);
				if (end >= this.length)        //special case: the end passes the length but not start at 0
				{
					nodeBefore.next = strFirst;
					strLast.next = null;
					length = start + str.length();
				}
				else        //normal case
				{
					CNode nodeAfter = nodeBefore.next;
					for (int i = 0; i < end - start; i++)
						nodeAfter = nodeAfter.next;
					nodeBefore.next = strFirst;
					strLast.next = nodeAfter;
					length = this.length - (end - start) + str.length();
				}
			}
		}

		return this;
	}

	// Reverse the characters in the current MyStringBuilder and then
	// return the current MyStringBuilder.
	public MyStringBuilder reverse()   //insert to the front
	{
		/*CNode newFirst = firstC;       //通过create newNode并存放currentNode的数据， 把newNode添加到数组的front
		CNode currentNode = firstC.next;
		lastC = firstC;
		int i = 1;
		while (i < this.length)
		{
			CNode newNode = new CNode(currentNode.data, newFirst); //这一步让这个方法占用运存更多，但两个方法都是O（N）
			newFirst = newNode;
			currentNode = currentNode.next;
			i++;
		}
		lastC.next = null;
		firstC = newFirst;
		return this;*/

		if (this.length < 2) //判断大小是否可以实现reverse
			return this;
		CNode first = firstC;       //通过三个pointers来实现顺序的reverse而不创建新的node，仅改变pointer
		CNode newFirst = firstC.next;
		CNode next = newFirst.next;

		first.next = null;
		while (newFirst != null)
		{
			newFirst.next = first;
			first = newFirst;
			newFirst = next;
			if (next != null)
				next = next.next;
		}
		lastC = firstC;
		firstC = first;
		return this;
	}
	
	// Return as a String the substring of characters from index "start" to
	// index "end" - 1 within the current MyStringBuilder
	public String substring(int start, int end)
	{
		CNode currentNode = getNodeAt(start);
		char[] c = new char[end - start];
		int i = 0;
		while (i < c.length)
		{
			c[i] = currentNode.data;
			i++;
			currentNode = currentNode.next;
		}
		return new String(c);
	}

	// Return the entire contents of the current MyStringBuilder as a String
	public String toString()
	{
		CNode currentNode = firstC;
		char[] c = new char[length];
		int i = 0;
		while (currentNode != null)
		{
			c[i] = currentNode.data;
			i++;
			currentNode = currentNode.next;
		}
		return new String(c);
	}

	public void setCharAt(int index, char ch)       //Extra Credit
	{
		if ((this.length != 0) && (index >= 0) && (index < this.length))     //when index is valid
		{
			CNode setNode = this.getNodeAt(index);
			setNode.data = ch;
		}
		else
			throw new IndexOutOfBoundsException();
	}

	public int lastIndexOf (String str)         //Extra Credit
	{
		int max = -1;
		CNode outerNode = firstC;
		CNode innerNode = firstC;
		for (int i = 0; i <= this.length - str.length(); i++)
		{
			int j;
			for (j = 0; j < str.length(); j++)
			{
				if (innerNode.data != str.charAt(j))
					break;
				innerNode = innerNode.next;
			}
			if (j >= str.length())
			{
				if (i > max)
					max = i;
			}
			outerNode = outerNode.next;
			innerNode = outerNode;
		}
		return max;
	}

	private CNode getNodeAt(int index)      //private method
	{
		assert (this.length != 0) && (index >= 0) && (index < this.length);
		CNode currentNode = firstC;
		for (int i = 0; i < index; i++)
			currentNode = currentNode.next;
		assert currentNode != null;
		return currentNode;
	}

	// You must use this inner class exactly as specified below.  Note that
	// since it is an inner class, the MyStringBuilder class MAY access the
	// data and next fields directly.
	private class CNode
	{
		private char data;
		private CNode next;

		public CNode(char c)
		{
			data = c;
			next = null;
		}

		public CNode(char c, CNode n)
		{
			data = c;
			next = n;
		}
	}
}

