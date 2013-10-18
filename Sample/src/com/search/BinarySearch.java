/**
 * 
 */
package com.search;

/**
 * @author Devang
 * <p>
 * The size of the array A is n = 2^m  where m is a known integer.  The first p elements are all equal to 9000.  
 * The next q elements are positive numbers less than 6000 and are sorted in increasing order. 
 * The remaining elements are all equal to 11000.  We do not know the values of p and q but we know that p < q < m. 
 * Propose an algorithm in pseudo-code to find an array element with a value equal to a given key K, where K<6000.  
 * Your algorithm must have a worst case complexity of O(lg m), and you must prove that your algorithm indeed has this
 * complexity.
 * <p>
 * Solution:
 * We know p < q < m and all are integers. Hence for worst case analysis, the maximum value of q <- (m - 1) and
 * p <- (q - 1) <- (m - 1 - 1) <- (m - 2).
 * 
 * So binary search will run from (m - 2) to ((m - 2) + (m - 1)) = (2m - 3). Now we know p and q. 
 * Hence, we can easily run the binary search on that indices.
 * <p>
 * Here is the number line showing the solution.
 * <p>
 * <--p=(m - 2)-->|<------q=(m - 1)------>|<-----------(n - p -q)------------>|<p>
 * ----------------------------------------------------------------------------<p>
 *                |                       |                                   |<p>
 * 0              m - 2                   2m - 3                              2 ^ m <p>
 */
public class BinarySearch
{
	private int[] input_;
	private int value_;
	
	public BinarySearch()
	{
		this(new int[]{}, 0);
	}
	
	public BinarySearch(int[] input, int value)
	{
		input_ = input;
		value_ = value;
	}
	
	/**
	 * @param start
	 * @param end
	 * @return
	 * 
	 * <p>
	 * This method will work correctly only when, (end - start + 1) == 2 ^ m (where m is positive integer). Please see the explanation give above.
	 * It has complexity of O(lg m) which is less than O(lg n).
	 */
	public int searchValue(int start, int end)
	{
		int location = -1;
		int middle;
		int m = (int)(Math.log(end + 1) / Math.log(2.0));
		System.out.println(m);
		
		start =  m - 2;
		end = (2 * m) - 3;
		
		while(start <= end)
		{
			middle = (start + end) / 2;
			if(input_[middle] == value_)
			{
				location = middle;
			}
			else if(input_[middle] == 9000)
			{
				start = middle  + 1;
				continue;
			}
			else if(input_[middle] == 11000)
			{
				end = middle - 1;
				continue;
			}
			else if(value_ < input_[middle])
			{
				end = middle - 1;
				continue;
			}
			else if (value_ > input_[middle])
			{
				start = middle  + 1;
				continue;
			}
		}
		
		return location;
	}
	
	/**
	 * Recursive approach with complexity O(lg n).
	 * @return any non-negative number that identifies the location of the number in the array. if value not found in the array then return -1.
	 */
	public int searchValueRecursion(int start, int end)
	{
		int location = -1;
		
		int middle = (start + end) / 2; 

		//System.out.println("Middle is " + middle);
		//System.out.println("Middle is " + middle + " location is " + location);
		
		if(start > end)
		{
			return location;
		}
		
		if(input_[middle] == value_)
		{
			return middle;
		}
		else if(input_[middle] == 9000)
		{
			location = searchValueRecursion(middle + 1, end);
		}
		else if(input_[middle] == 11000)
		{
			location = searchValueRecursion(start, middle - 1 );
		}
		else if(value_ < input_[middle])
		{
			location = searchValueRecursion(start, middle - 1 );
		}
		else if (value_ > input_[middle])
		{
			location = searchValueRecursion(middle + 1, end);
		}
		
		return location;
	}
	
	public int[] getInput_()
	{
		return input_;
	}

	public void setInput_(int[] input_)
	{
		this.input_ = input_;
	}

	public int getValue_()
	{
		return value_;
	}

	public void setValue_(int value_)
	{
		this.value_ = value_;
	}
}
