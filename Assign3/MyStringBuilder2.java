// CS 0445 Spring 2018
// Read this class and its comments very carefully to make sure you implement
// the class properly.  The data and public methods in this class are identical
// to those MyStringBuilder, with the exception of the two additional methods
// shown at the end.  You cannot change the data or add any instance
// variables.  However, you may (and will need to) add some private methods.
// No iteration is allowed in this implementation. 



// For more details on the general functionality of most of these methods,
// see the specifications of the similar method in the StringBuilder class.  
public class MyStringBuilder2
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

	// Create a new MyStringBuilder2 initialized with the chars in String s
	public MyStringBuilder2(String s)
	{
		if (s != null && s.length() > 0)
			makeStringBuilder (s,0);
		else     // no String so initialize empty MyStringBuilder2
		{
			length = 0;
			firstC = null;
			lastC = null;
		}
	}

	private void makeStringBuilder (String s, int pos)
	{
		if (pos < s.length() - 1)         // recursive case
		{
			makeStringBuilder(s, pos + 1);
			firstC = new CNode(s.charAt(pos), firstC);
			length++;
		}
		else if (pos == s.length() - 1)   //base case: reach the last char in String
		{
			firstC = new CNode(s.charAt(pos));
			lastC = firstC;
			length = 1;
		}
		else          //should never be reached; just a safeguard
		{
			length = 0;
			firstC = null;
			lastC = null;
		}
	}

	// Create a new MyStringBuilder2 initialized with the chars in array s
	public MyStringBuilder2(char [] s)
	{
		if (s != null && s.length > 0)
			makeCharBuilder(s, 0);
		else
		{
			length = 0;
			firstC = null;
			lastC = null;
		}
	}

	private void makeCharBuilder(char [] s, int pos)
	{
		if (pos < s.length - 1)       //recursive case
		{
			makeCharBuilder(s, pos + 1);
			firstC = new CNode(s[pos], firstC);
			length++;
		}
		else if (pos == s.length - 1)     //special case: last element in the array
		{
			firstC = new CNode(s[pos]);
			lastC = firstC;
			length = 1;
		}
		else          //should never be reached; just a safeguard
		{
			length = 0;
			firstC = null;
			lastC = null;
		}
	}

	// Create a new empty MyStringBuilder2
	public MyStringBuilder2()
	{
		length = 0;
		firstC = null;
		lastC = null;
	}

	// Append MyStringBuilder2 b to the end of the current MyStringBuilder2, and
	// return the current MyStringBuilder2.  Be careful for special cases!
	public MyStringBuilder2 append(MyStringBuilder2 b)
	{
		if (b == null || b.length == 0)  // special case: b is empty
			return this;
		else if (length == 0)    //special case: this object is empty
		{
			CNode readNode = b.firstC;
			firstC = new CNode(readNode.data);
			readNode = readNode.next;
			length = 1;
			CNode currentNode = firstC;
			appendMyString(b, readNode, currentNode);
		}
		else      //normal case
			appendMyString(b, b.firstC, lastC);
		return this;
	}

	private void appendMyString (MyStringBuilder2 b, CNode read, CNode curr)
	{
		if (read != null)
		{
			CNode newNode = new CNode(read.data);
			curr.next = newNode;
			lastC = newNode;
			length++;
			appendMyString(b, read.next, curr.next);
		}
	}


	// Append String s to the end of the current MyStringBuilder2, and return
	// the current MyStringBuilder2.  Be careful for special cases!
	public MyStringBuilder2 append(String s)
	{
		if (s == null || s.length() == 0)  // special case: string is empty
			return this;
		else if (length == 0)    //special case: this object is empty
			makeStringBuilder(s,0);
		else      //normal case
			appendString(s, 0);
		return this;
	}

	private void appendString(String s, int pos)
	{
		if (lastC != null && pos < s.length())
		{
			CNode newNode = new CNode(s.charAt(pos));
			lastC.next = newNode;
			lastC = newNode;
			length++;
			appendString(s,pos + 1);
		}
	}

	// Append char array c to the end of the current MyStringBuilder2, and
	// return the current MyStringBuilder2.  Be careful for special cases!
	public MyStringBuilder2 append(char [] c)
	{
		if (c == null || c.length == 0)  // special case: char array is empty
			return this;
		else if (length == 0)    //special case: this object is empty
			makeCharBuilder(c, 0);
		else      //normal case
			appendCharArray(c, 0);
		return this;
	}

	private void appendCharArray(char[] c, int pos)
	{
		if (lastC != null && pos < c.length)
		{
			CNode newNode = new CNode(c[pos]);
			lastC.next = newNode;
			lastC = newNode;
			length++;
			appendCharArray(c, pos + 1);
		}
	}

	// Append char c to the end of the current MyStringBuilder2, and
	// return the current MyStringBuilder2.  Be careful for special cases!
	public MyStringBuilder2 append(char c)
	{
		if (c == 0 )   // special case: c is empty
			return this;
		else if (length == 0) // special case: this object is empty
		{
			firstC = new CNode(c);
			lastC = firstC;
			length = 1;
		}
		else          //normal case
		{
			CNode newNode = new CNode(c);
			lastC.next = newNode;
			lastC = newNode;
			length++;
		}
		return this;
	}

	// Return the character at location "index" in the current MyStringBuilder2.
	// If index is invalid, throw an IndexOutOfBoundsException.
	public char charAt(int index)
	{
		return getNodeAt(index).data;
	}

	// Delete the characters from index "start" to index "end" - 1 in the
	// current MyStringBuilder2, and return the current MyStringBuilder2.
	// If "start" is invalid or "end" <= "start" do nothing (just return the
	// MyStringBuilder2 as is).  If "end" is past the end of the MyStringBuilder2, 
	// only remove up until the end of the MyStringBuilder2. Be careful for 
	// special cases!
	public MyStringBuilder2 delete(int start, int end)
	{
		if (start >= 0 && start < length && end > start)    //when the start and end are valid
		{
			assert  this.length != 0;
			if (start == 0)     //special case: delete the first node
			{
				if (length <= end - start)  // special case: delete the first node till the end
				{
					firstC = null;
					lastC = null;
					length = 0;
				}
				else      //special case delte the first node till the "middle"
				{
					firstC = getNodeAt(end);
					length -= end;
				}
			}
			else if (end >= this.length)    // special case: the end passes the length but not start at 0
			{
				assert start != 0;
				CNode nodeBefore = getNodeAt(start - 1);
				nodeBefore.next = null;
				lastC = nodeBefore;
				length = start;
			}
			else     //normal case
			{
				CNode nodeBefore = getNodeAt(start - 1);
				CNode nodeAfter = getNode(end + 1, start, nodeBefore);   //get the node after index "end" using recursion
				nodeBefore.next = nodeAfter;
				length = length - (end - start);
			}
		}
		return this;
	}

	// Delete the character at location "index" from the current
	// MyStringBuilder2 and return the current MyStringBuilder2.  If "index" is
	// invalid, do nothing (just return the MyStringBuilder2 as is).
	// Be careful for special cases!
	public MyStringBuilder2 deleteCharAt(int index)
	{
		if (index >= 0 && index < length)   //when the index is valid
		{
			assert length != 0;
			if (index == 0)     //special case: delete the first node
			{
				firstC = firstC.next;
				if (this.length == 1)   //special case: delete the first node which is also the only node
					lastC = null;
			}
			else    //normal case
			{
				CNode nodeBefore = getNodeAt(index - 1);
				nodeBefore.next = nodeBefore.next.next;
				if (index == length - 1)     //special case: delete the last node
					lastC = nodeBefore;
			}
			length--;
		}
		return this;
	}

	// Find and return the index within the current MyStringBuilder2 where
	// String str first matches a sequence of characters within the current
	// MyStringBuilder2.  If str does not match any sequence of characters
	// within the current MyStringBuilder2, return -1.  Think carefully about
	// what you need to do for this method before implementing it.
	public int indexOf(String str)
	{
		if (length == 0 || str.length() > length || str == null || str.length() == 0 )     //base case: not found
			return -1;
		else
			return rec_indexOf(str, 0,0, firstC);
	}

	private int rec_indexOf(String str, int pos, int index, CNode curr)
	{
		if (index + str.length() > length)     //base case: not found
			return -1;
		else if (matchString(str,pos,curr))     return index;      //base case: match the whole string
		else         //recursive case: match the next character
			return rec_indexOf(str,pos,index + 1, curr.next);

	}

	private boolean matchString(String str, int pos, CNode curr)
	{
		if (str.charAt(pos) != curr.data)     //base case: not found
			return false;
		else if (str.charAt(pos) == curr.data && pos == str.length() - 1) return true;    //base case: find the whole string
		else         //  if (str.charAt(pos) == curr.data)     //recursive case: find one char
			return matchString(str, pos + 1, curr.next);
	}

	// Insert String str into the current MyStringBuilder2 starting at index
	// "offset" and return the current MyStringBuilder2.  if "offset" == 
	// length, this is the same as append.  If "offset" is invalid
	// do nothing.
	public MyStringBuilder2 insert(int offset, String str)
	{
		if (offset >= 0 && offset <= length) //when offset is valid
		{
			if (str == null)      //special case: the string is empty
				return this;
			else if (offset == length || length == 0)  //special case: insert to the end or when this object is empty
				append(str);
			else
			{
				CNode strFirst = new CNode(str.charAt(0));
				CNode strLast = makeString(str, 1, strFirst);
				if (offset == 0)    //special case: insert at the front
				{
					strLast.next = firstC;
					firstC = strFirst;
				}
				else     //normal case
				{
					CNode offsetNode = getNodeAt(offset - 1);
					strLast.next = offsetNode.next;
					offsetNode.next = strFirst;
				}
				length += str.length();
			}
		}
		return this;
	}

	private CNode makeString(String str, int pos, CNode curr)
	{
		if (pos < str.length())
		{
			CNode newNode = new CNode(str.charAt(pos));
			curr.next = newNode;
			curr = newNode;
			return makeString(str, pos + 1, curr);
		}
		return curr;
	}

	// Insert character c into the current MyStringBuilder2 at index
	// "offset" and return the current MyStringBuilder2.  If "offset" ==
	// length, this is the same as append.  If "offset" is invalid, 
	// do nothing.
	public MyStringBuilder2 insert(int offset, char c)
	{
		if (offset >= 0 && offset <= length)   //when offset is valid
		{
			if (c == 0)   //special case: char is empty
				return this;
			else if (offset == length || length == 0) //special case: insert to the end or when this object is empty
			   append(c);
			else
			{
				CNode newNode = new CNode(c);
				if (offset == 0)        //special case: insert at the front
				{
					newNode.next = firstC;
					firstC = newNode;
				}
				else
				{
					CNode offsetNode = getNodeAt(offset - 1);
					newNode.next = offsetNode.next;
					offsetNode.next = newNode;
				}
				length++;
			}
		}
		return this;
	}

	// Insert char array c into the current MyStringBuilder2 starting at index
	// index "offset" and return the current MyStringBuilder2.  If "offset" is
	// invalid, do nothing.
	public MyStringBuilder2 insert(int offset, char [] c)
	{
		if (offset >= 0 && offset <= length)   //when offset is valid
		{
			if (c == null || c.length == 0)        //special case: char array is empty
				return this;
			else if (offset == length || length == 0)     //special case: insert to the end or when this object is empty
				this.append(c);
			else
			{
				CNode charFirst = new CNode(c[0]);
				CNode charLast = makeChar(c,1,charFirst);
				if (offset == 0)   //insert at the front
				{
					charLast.next = firstC;
					firstC = charFirst;
				}
				else        //normal case
				{
					CNode offsetNode = getNodeAt(offset - 1);
					charLast.next = offsetNode.next;
					offsetNode.next = charFirst;
				}
				length += c.length;
			}
		}
		return this;
	}

	private CNode makeChar (char [] c, int pos, CNode curr)
	{
		if (pos < c.length)
		{
			CNode newNode = new CNode(c[pos]);
			curr.next = newNode;
			curr = newNode;
			return makeChar(c, pos + 1, curr);
		}
		return curr;
	}

	// Return the length of the current MyStringBuilder2
	public int length()
	{
		return length;
	}

	// Delete the substring from "start" to "end" - 1 in the current
	// MyStringBuilder2, then insert String "str" into the current
	// MyStringBuilder2 starting at index "start", then return the current
	// MyStringBuilder2.  If "start" is invalid or "end" <= "start", do nothing.
	// If "end" is past the end of the MyStringBuilder2, only delete until the
	// end of the MyStringBuilder2, then insert.  This method should be done
	// as efficiently as possible.  In particular, you may NOT simply call
	// the delete() method followed by the insert() method, since that will
	// require an extra traversal of the linked list.
	public MyStringBuilder2 replace(int start, int end, String str)
	{
		if (length == 0)      //special case: the object is empty
		    this.append(str);
		else if (start >= 0 && start < length && end > start)    //when the start and end are valid
		{
			if (str.length() == 0 || str == null)        //special case: the string is empty
				return this;
			else if (start == 0)
			{
				CNode strFirst = new CNode(str.charAt(0));
				CNode strLast = makeString(str, 1, strFirst);
				if (length <= end - start)     //special case: replace from the front and end passes the length
				{
					lastC = strLast;
					length = str.length();
				}
				else           //special case: replace from the front but the end does not pass the length
				{
					strLast.next = getNodeAt(end);
					length = length - (end - start) + str.length();
				}
				firstC = strFirst;
			}
			else           // not start at the front or start is not 0
			{
				assert start != 0;
				CNode strFirst = new CNode(str.charAt(0));
				CNode strLast = makeString(str, 1, strFirst);
				CNode nodeBefore = getNodeAt(start - 1);
				if (end >= length)      //special case: the end passes the length but not start at 0
				{
					nodeBefore.next = strFirst;
					strLast.next = null;
					length =start + str.length();
				}
				else     //normal case: replace in the "middle"
				{
					CNode nodeAfter = getNode(end + 1, start, nodeBefore);   //get the node after index "end" using recursion
					nodeBefore.next = strFirst;
					strLast.next = nodeAfter;
					length = length - (end - start) + str.length();
				}
			}
		}
		return this;
	}

	// Reverse the characters in the current MyStringBuilder2 and then
	// return the current MyStringBuilder2.
	public MyStringBuilder2 reverse()
	{
		rec_reverse(firstC);
		return this;
	}

	private CNode rec_reverse(CNode curr)
	{
		if (curr == null) return null;     //special case: empty MyStringBuilder
		if (curr.next == null)        //base case: reach the end of the list
		{
			firstC = curr;
			return curr;
		}
		else              //recursive case
		{
			CNode temp = rec_reverse(curr.next);
			temp.next = curr;
			curr.next = null;
			lastC = curr;
			return curr;
		}
	}
	
	// Return as a String the substring of characters from index "start" to
	// index "end" - 1 within the current MyStringBuilder2
	public String substring(int start, int end)
	{
		if (length != 0 && start < end && start >= 0 && end <= length)    //legal start and end
		{
			char [] c = new char[end - start];
			CNode curr = getNodeAt(start);
			getSubstring(c, 0, curr);
			return (new String (c));
		}
		else
			return null;
	}

	private void getSubstring(char[] c, int pos, CNode curr)
	{
		if (curr != null && pos < c.length)
		{
			c[pos] = curr.data;
			getSubstring(c, pos + 1, curr.next);
		}
	}

	// Return the entire contents of the current MyStringBuilder2 as a String
	public String toString()
	{
		char[] c = new char[length];
		getString(c, 0, firstC);
		return (new String(c));
	}

	private void getString(char[] c, int pos, CNode curr)
	{
		if (curr != null)
		{
			c[pos] = curr.data;
			getString(c, pos + 1, curr.next );
		}
	}

	private CNode getNodeAt(int index)
	{
		assert (length != 0) && (index >= 0) && (index < length);
		CNode currentNode = getNode(index, 0, firstC);
		return currentNode;
	}

	private CNode getNode (int index, int pos, CNode curr)
	{
		assert (length != 0) && (index >= 0) && (index < length) && (index <= pos);
		if (pos < index)
		{
			curr = getNode(index, pos + 1,curr.next);
			return curr;
		}
		else       //pos == index
			return curr;
	}

	// Find and return the index within the current MyStringBuilder2 where
	// String str LAST matches a sequence of characters within the current
	// MyStringBuilder2.  If str does not match any sequence of characters
	// within the current MyStringBuilder2, return -1.  Think carefully about
	// what you need to do for this method before implementing it.  For some
	// help with this see the Assignment 3 specifications.
	public int lastIndexOf(String str)
	{
		if (length == 0 || str.length() > length || str == null || str.length() == 0)
			return -1;
		else
			return rec_lastIndexOf(str, 0, firstC);
	}

	private int rec_lastIndexOf(String str, int index, CNode curr)
	{
		int result = -1;
		if (index < length - str.length())       //recursive case: recurse till the last possible index
			result = rec_lastIndexOf(str, index + 1, curr.next);
		if (result == -1)    //cannot match the string from the last
		{
			if (matchString(str,0,curr))    //match the string from curr
				return index;
			else return result;       //curr node does not match
		}
		else  // find the string from the last
			return result;
	}
	
	// Find and return an array of MyStringBuilder2, where each MyStringBuilder2
	// in the return array corresponds to a part of the match of the array of
	// patterns in the argument.  If the overall match does not succeed, return
	// null.  For much more detail on the requirements of this method, see the
	// Assignment 3 specifications.
	public MyStringBuilder2 [] regMatch(String [] pats)
	{
		//shorthandTest(pats, 0);
		MyStringBuilder2 [] matches = new MyStringBuilder2[pats.length];
		loadMatches(0,matches);
		loopRegMatch(pats, firstC, matches);
		if (matches[matches.length - 1].length != 0)
			return matches;
		else
			return null;
	}

	/*private void shorthandTest (String[] pats, int i)
	{
		if (i < pats.length)
		{
			if (pats[i].equals("[A-Z]+"))
				pats[i] = new String ("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
			else if ((pats[i]).equals("[0-9]*"))
				pats[i] = new String ("0123456789");
			shorthandTest(pats, i+1);
		}
	}*/

	private void loadMatches(int i, MyStringBuilder2[] matches)
	{
		if (i < matches.length)
		{
			matches[i] = new MyStringBuilder2();
			loadMatches(i+1, matches);
		}
	}

	private void loopRegMatch(String[] pats, CNode curr, MyStringBuilder2[] matches)
	{
		boolean result = rec_regMatch(pats,0, curr, matches);
		if (!result && curr.next != null)
			loopRegMatch(pats, curr.next, matches);
	}

	private boolean matchPats (String str, int pos, CNode curr)
	{
		if (str.charAt(pos) == curr.data) return true;        //base case: find one match
		else if (str.charAt(pos) != curr.data && pos == str.length() - 1) //base case: not found
			return false;
		else      // recursive case: curr does not match, move to the next pos
			return matchPats(str, pos + 1, curr);
	}


	private boolean rec_regMatch(String[] pats, int i, CNode curr, MyStringBuilder2[] matches)
	{
		if (curr == null)  //base case 1: no characters left in MyStringBuilder2
		{
			if (matches[matches.length - 1].length != 0) // last pattern has matches
				return true;
			else return false;        //make loopRegMatch start at the next node
		}
		else if (!matchPats(pats[i], 0, curr))    //base case 2: curr data does not match curr pattern
		{
			if (matches[matches.length - 1].length != 0)      //the last pattern has matches
				return true;
			else return false; //make loopRegMatch start at the next node
		}
		else      // curr.data matches curr pattern
		{
			matches[i].append(curr.data);       //append the matched character
			if (rec_regMatch(pats, i, curr.next, matches))  //if we continue to match this pattern, will it reach true?
				return true;
			else if (rec_regMatch(pats, i+1, curr.next, matches))  // Attention: this is next pattern and next node here,
			                                                    //because we have added curr.data into our curr patterns
															// that's why we cannot match it again with the next node if
															//the situation before cannot match, if it return false,
															//meaning we need to backtrack and goes to else block below
				return true;
			else      //backtrack: when the two situations cannot succeed, we delete this char, and tell the loopMatches to move to the next node
			{
				int last = matches[i].length;
				matches[i].delete(last - 1, last);
				return false;
			}
		}
	}

	/*private boolean rec_regMatch(String[] pats, int i, CNode curr, MyStringBuilder2[] matches)
	{
		if (i == 0 && !pats[i].contains(curr.data + "")) //base case: the curr data does not match pattern 0
		{
			if (curr.next == null) return false;       //no characters left in the MyStringBuilder2, pattern 0 cannot be matched
			else if (matches[i].length == 0)    //nothing matches pattern 0
				rec_regMatch(pats, i, curr.next, matches);  //move down to the next character
			else    //at least one character in pattern 0 is matched
				rec_regMatch(pats, i+1, curr, matches);       //move to the next pattern but stay at the same character
		}
		else if (pats[i].contains(curr.data + ""))   //at least one character in pattern i is matched
		{
			matches[i].append(curr.data);
			if (curr.next == null && i != pats.length - 1) return false;
			else if (i == pats.length - 1) return true;
			else if (rec_regMatch(pats, i, curr.next, matches))//move down to the next character
				return true;
			else if (rec_regMatch(pats, i+1, curr.next, matches)) //move down to the next pattern
				return true;
			else return false;
		}
		else // (i != 0 && !pats[i].contains(curr.data + ""))  //state 3: no characters in pattern i match where i!= 0
		{
			if (i == pats.length - 1 && matches[i].length != 0)//although this does not match, the pattern still has been matched
				return true;
			else          //pattern i has not been matched
			{
				int matchEnd = matches[i].length;
				matches[i].delete(matchEnd - 1, matchEnd);
				return false;
			}
		}
		return false;
	}*/
	
	// You must use this inner class exactly as specified below.  Note that
	// since it is an inner class, the MyStringBuilder2 class MAY access the
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

