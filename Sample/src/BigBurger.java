/**
 * @author dshah
 * @since 
 */
public class BigBurger
{
	//public static final String className = BigBurger.class.getName();
	
	
	public static void main(String[] args)
	{
		int[] arrivalTime = {2, 10, 11};
		int[] serviceTime = {3, 4, 3};
		BigBurger bb = new BigBurger();
		bb.maxWait(arrivalTime, serviceTime);
	}

	public int maxWait(int[] arrivalTime, int serviceTime[])
	{
		int maxWaitTime = 0;
		int leavingTime = 0;
		//System.out.println(className);
		if(arrivalTime.length == 1)
			return 0;
		
		for(int i = 0; i < arrivalTime.length; i++)
		{		
			leavingTime = leavingTime + (i == 0 ? arrivalTime[i] : 0) + serviceTime[i];
			if(maxWaitTime < leavingTime - arrivalTime[i] - serviceTime[i])
				maxWaitTime = leavingTime - arrivalTime[i] - serviceTime[i];
		}		
		return maxWaitTime;
	}
}
