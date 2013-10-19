/**
 * A palindromic number reads the same both ways. 
 * The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 * Find the largest palindrome made from the product of two 3-digit numbers.
 * 
 * @author Devang_1
 */
public class Palindrome_4
{

	public static void main(String[] args)
	{
		int num1 = 1000;
		int mult = 1;
		int temp = 1;
		int a = 100, b = 100;
		
		for(int i = num1; i >= 100; --i)
		{
			for(int j = i; j >= 100; --j)
			{
				temp = i * j;
				if(isPalin(temp) && temp > mult)
				{
					mult = temp;
					a = i; b = j;
					break;
				}
			}
		}
		
		/**
		 * An optimized way exists.
		 * Let P is a palindrome which is 6 digit long. P = xyzzyx.
		 * Hence, it's 100000*x + 10000*y + 1000*z + 100*z + 10*y + x.
		 * which is 100001*x + 10010*y + 1100*z.
		 * which is 11(9091*x + 910*y + 100*z).
		 * 
		 * i.e. at least one number of a and b (a * b = P) is divisible by 11.
		 */
		
		System.out.println("Maximum number is (n1 * n2) = (" +a+ "*" +b+ ") =" +mult);
	}
	
	private static boolean isPalin(int number)
	{
		boolean isPalin = true;
		String num = String.valueOf(number);
		for(int i = 0, j = num.length() - 1; i < j; i++, j--)
		{
			if(num.charAt(i) != num.charAt(j))
			{
				return false;
			}
		}
		
		return isPalin;
	}

}
