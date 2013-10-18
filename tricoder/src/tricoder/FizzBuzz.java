/**
 * 
 */
package tricoder;

/**
 * @author Devang
 * 
 * Runtime environment: Java SE 1.7
 */
public class FizzBuzz
{

	public static void main(String[] args)
	{
		int start = 1;
		int end = 100;
		final String fizz = "Fizz";
		final String buzz = "Buzz";
		final String fizzBuzz = "FizzBuzz";
		
		for (int i = start; i < end; i++)
		{
			if (i % 3 == 0 && i % 5 == 0)
				System.out.println(fizzBuzz);
			else if (i % 3 == 0)
				System.out.println(fizz);
			else if (i % 5 == 0)
				System.out.println(buzz);
			else
				System.out.println(i);
			
		}

	}

}
