/**
 * 
 */
package tricoder;

/**
 * @author Devang
 * Reference: http://www.maths.surrey.ac.uk/hosted-sites/R.Knott/Fibonacci/fibFormula.html
 * Uses the Binet's formula and golden ratio (1 + sqrt(5))/2 ~ 1.6180339887...
 */
public class Fibonacci_1
{
	public static void main(String[] args)
	{
		double Phi = (1 + Math.sqrt(5)) / 2;
		int n = 1;
		final int FINAL_LENGTH = 1000;
		//System.out.println("Length of 1 is 1");
		for(n = 2; n < 5000; n++)
		{
			double l = (n * Math.log10(Phi) - 0.5 * Math.log10(5));
			//System.out.println(l);
			long length = (long) Math.floor(l) + 1;
			if (length == FINAL_LENGTH)
			{
				System.out.println(n+ "th term is the first term with length " +FINAL_LENGTH);
				break;
			}
		}
	}
}
