import java.util.Arrays;


/**
 * @author Devang
 * Largest Prime Factor: http://projecteuler.net/problem=3
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 * 
 * Approach:
 * 1. 
 */
public class LargestPrimeFactor
{
	public static void main(String[] args)
	{
		long nanoStart = System.nanoTime();
		long maxNumber = 600851475143l;
		
		boolean[] isPrime = new boolean[10000];
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;
		for(int i = 2; i < isPrime.length; i++)
		{
			if(isPrime[i])
			{
				for(int k = 2 * i; k < isPrime.length; k += i)
				{
					isPrime[k] = false;
				}
			}
		}
		
		for(int k = isPrime.length - 1; k > 0; k--)
		{
			if(isPrime[k] && maxNumber % k == 0)
			{
				System.out.println("Largest prime is: " +k);
				break;
			}
		}
		
		System.out.println("Time taken " +(System.nanoTime() - nanoStart)+ " ns");
	}
}
