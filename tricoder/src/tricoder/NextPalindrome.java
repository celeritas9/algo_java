package tricoder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;


/**
 * @author Devang
 * Problem: 
 * A positive integer is called a palindrome if its representation in the decimal system is the same when read 
 * from left to right and from right to left. For a given positive integer K of not more than 1000000 digits, 
 * write the value of the smallest palindrome larger than K to output. Numbers are always displayed without leading 
 * zeros. 
 * Input: The first line contains integer t, the number of test cases. Integers K are given in the next t lines. 
 * Output: For each K, output the smallest palindrome larger than K.
 * Example
 * 
 * Input:
 * 2
 * 808
 * 2133
 * 
 * Output:
 * 818
 * 2222
 */
public class NextPalindrome
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(new FileInputStream(new File("c://Devang//input"))));
		
		String noOfInputs = reader.readLine();
		if (noOfInputs != null)
		{
			for (int i = 0; i < Integer.parseInt(noOfInputs); i++)
			{
				String s = reader.readLine();
				String nextPalin = nextPalindrome(s);
				System.out.println(nextPalin);
			}
		}
		
		reader.close();
	}

	private static String nextPalindrome(String s)
	{
		char[] sChars = s.toCharArray();
		int middle, middleLeft, middleRight = 0;
		middle = sChars.length / 2;
		boolean isLengthEven = middle % 2 == 0;
		boolean doneCalculation = false;
		middleLeft = middle - 1;
		middleRight = isLengthEven == true ? middle : middle + 1;
		
		for (int left = middleLeft, right = middleRight; middleLeft > 0; right++, left--)
		{
			if (!isLengthEven && !doneCalculation)
			{
				int middleDigit = Character.getNumericValue(sChars[middle]);
				if (middleDigit < 9)
				{
					middleDigit++;
					sChars[middle] = (char)(('0') + middleDigit);
					doneCalculation = true;
				}
			}
			
			else if (isLengthEven && !doneCalculation)
			{
				
			}
			
			if (doneCalculation)
			{
				sChars[right] = sChars[left];
			}
		}
		
		return sChars.toString();
	}

	private static boolean isPalindrome(String i)
	{
		char[] iArray = i.toCharArray();
		for(int j = 0, k = iArray.length - 1; j < k; j++, k--)
		{
			if(iArray[j] != iArray[k])
				return false;
		}
		return true;
	}
}