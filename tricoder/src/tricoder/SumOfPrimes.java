/**
 * 
 */
package tricoder;


/**
 * @author Devang
 * Approach: 1. For each number less than 2M, check if it's a prime number.
 * 			 2. If it's a prime then add the number to the final sum.
 * 
 * Runtime environment: Java SE 1.7
 */
public class SumOfPrimes /*implements Runnable*/
{
	/*
	 * Reference: http://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
	 */
	public long sumOptimized(int last)
	{
		boolean[] isPrime = new boolean[last+1];
		long sum = 0;
		
		for(int i = 0; i < isPrime.length; i++)
		{
			isPrime[i] = true;
		}
		
		int sqrt = (int)Math.sqrt(last);
		for (int i = 2; i <= sqrt; i++)
		{
			if(isPrime[i])
			{
				for(int j = i * i; j <= last; j = j + i)
				{
					isPrime[j] = false;
				}
			}
		}
		
		for(int k = 0; k < last; k++)
		{
			if(isPrime[k])
			{
				sum = sum + k;
			}
		}
		return sum;
	}
	
	/*
	 * Original method.
	 */
	public long sum(int last)
	{
		long sum = 0;
		for (long i = last; i > 1; i--)
		{
			if (isPrime(i))
			{
				sum = sum +  i;
			}
		}
		
		return sum;
	}
	
	private boolean isPrime (long number)
	{
		long sqrt = (long) Math.sqrt(number);
		for (long i = sqrt; i > 1; i--)
		{
			if (number % i == 0)
			{
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args)
	{
		int last = 100000000;
		SumOfPrimes sum = new SumOfPrimes();
		long total = 0;

		/*long startTime = System.currentTimeMillis();
		total = sum.sum(last);
		long totalTime = System.currentTimeMillis() - startTime;

		System.out.println("Test 1 : It took " + totalTime + " ms");
		System.out.println(total);*/
		
		long startTime1 = System.currentTimeMillis();
		total = sum.sumOptimized(last);
		long totalTime1 = System.currentTimeMillis() - startTime1;
		
		System.out.println("Test 2 : It took " + totalTime1 + " ms for " +last+ " numbers.");
		System.out.println(total);
		
		last = 2000000;
		long startTime2 = System.currentTimeMillis();
		total = sum.sumOptimized(last);
		long totalTime2 = System.currentTimeMillis() - startTime2;
		
		System.out.println("Test 3 : It took " + totalTime2 + " ms for " +last+ " numbers.");
		System.out.println(total);
	}
}
