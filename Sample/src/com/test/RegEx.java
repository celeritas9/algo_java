/**
 * 
 */
package com.test;

/**
 * @author dshah
 *
 */
public class RegEx {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String a = "12|34|54";
		String[] aArr = a.split("\\|");
		//System.out.println(aArr[0] + " "+aArr[1] +" "+aArr[2]);
		Object obj = "30|40|35|36|19";
		long totalDebit = 0;
        long balance = 0;
        long chargedBundleTime = 0;
		if(obj != null)
        {
        	String dynPartitionNumber = (String)obj;
        	String[] dynPartitionNumberArr = dynPartitionNumber.split("\\|");
        	
        	//obj = UtilProcessor.getGenericFiledValue(getContext(), genericToBeanFieldHome_, PROCESSOR_NAME, TOTAL_DEBIT, genericValueMap, CLASS_NAME);
	        String tDebit = "167200000|3200012|1200000|1500|1300";
	        String[] tDebitArray = tDebit.split("\\|");
	        
	        //obj = UtilProcessor.getGenericFiledValue(getContext(), genericToBeanFieldHome_, PROCESSOR_NAME, BALANCE, genericValueMap, CLASS_NAME);
            String bal = "1200|1400|1300|1000|2000";
            String[] balArr = bal.split("\\|");
        	int index = 0;
        	long unitBucketCharge = 0;
	        long unitBucketBalance = 0;
	        long currencyBucketBalance = 0;
	        long currencyBucketCharge = 0;
	        long subsriptionCharge = 0;
	        boolean bucketIndicator = false;
        	for(String dynPartitionNumberString : dynPartitionNumberArr)
        	{
        		if(!(dynPartitionNumberString.equals("")))
        		{
        			long dynPNum = Long.parseLong(dynPartitionNumberString);
        			if(dynPNum > 160) dynPNum = dynPNum - 160;
        	        else if(dynPNum > 140) dynPNum = dynPNum - 140;
        	        else if(dynPNum > 120) dynPNum = dynPNum - 120;
        	        else {}/*Do not alter dynPNum*/
        			if(dynPNum == 30)
        			{
        				subsriptionCharge = subsriptionCharge + Long.parseLong(tDebitArray[index]);
        				//System.out.println("when  30:"+dynPNum);
        			}
        			else if(dynPNum > 30 && dynPNum <= 39)	/*Range 31 to 39 including*/
        			{
        				currencyBucketCharge = currencyBucketCharge + Long.parseLong(tDebitArray[index]);
        				currencyBucketBalance = currencyBucketBalance + (long)Double.parseDouble(balArr[index]);
        				bucketIndicator = true;
        				//System.out.println("when in range 31-39:"+dynPNum);
        			}
        			else /*if dynPNum < 30 || dynPNum > 39 */
        			{
        				unitBucketCharge = unitBucketCharge + Long.parseLong(tDebitArray[index]);
        				unitBucketBalance = unitBucketBalance + (long)Double.parseDouble(balArr[index]);
        				bucketIndicator = true;
        				//System.out.println("when not 30 to 39:"+dynPNum);
        			}
        		}
        		else
        		{
        			//Do nothing
        		}
        		index++;
        	}
        	System.out.println("subscriptionCharge: "+subsriptionCharge+" currenyBucketCharge: "+currencyBucketCharge +", currencyBucketBalance: "
        			+currencyBucketBalance+", unitBucketCharge: "+unitBucketCharge+", unitBucketBalance: "+unitBucketBalance);
        }
		
	}

}
