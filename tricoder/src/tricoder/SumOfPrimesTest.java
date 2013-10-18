/**
 * 
 */
package tricoder;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;


/**
 * @author Devang
 * 
 */
public class SumOfPrimesTest
{
	protected SumOfPrimes sum;
	
	@Before
    public void setUp()
	{
		System.out.println();
        sum = new SumOfPrimes();
    }
	
	@Test//(timeout = 23)
	public void Testcase_1()
	{
		int last = 2000000;
		long startTime = System.currentTimeMillis();
		long total = 0;
		total = sum.sum(last);
		
		long totalTime = System.currentTimeMillis() - startTime;
		System.out.println("Test 1 : It took " + totalTime + " ms");
		System.out.println(total);
	}
	
	/*@Test//(timeout = 3000)
	public void Testcase_2()
	{
		int last = 100000000;
		long startTime = System.currentTimeMillis();
		long total = 0;
		total = sum.sum(last);
		
		long totalTime = System.currentTimeMillis() - startTime;
		System.out.println("Test 2 : It took " + totalTime + " ms");
		System.out.println(total);
	}*/
}
