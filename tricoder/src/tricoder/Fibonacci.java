/**
 * 
 */
package tricoder;

import java.math.BigInteger;

/**
 * @author Devang
 * 
 * Runtime environment: Java SE 1.7
 */
public class Fibonacci
{
	public static void main(String[] args)
	{
		int MAX = Integer.MAX_VALUE;
		int length = 1000;
		BigInteger f1 = BigInteger.valueOf(1);
		BigInteger f2 = BigInteger.valueOf(1);
		BigInteger fn = BigInteger.valueOf(0);
		for (int i = 3; i < MAX; i++)
		{
			fn = f1.add(f2);
			if(String.valueOf(fn).length() == length)
			{
				System.out.println(i+ "th term "+fn+ " is the first term with length " +String.valueOf(fn).length());
				break;
			}
			f1 = f2;
			f2 = fn;
		}
	}
}
