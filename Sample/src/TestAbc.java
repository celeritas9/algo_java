import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

/*
 * This code is a protected work and subject to domestic and international
 * copyright law(s).  A complete listing of authors of this work is readily
 * available.  Additionally, source code is, by its very nature, confidential
 * information and inextricably contains trade secrets and other information
 * proprietary, valuable and sensitive to Redknee.  No unauthorized use,
 * disclosure, manipulation or otherwise is permitted, and may only be used
 * in accordance with the terms of the license agreement entered into with
 * Redknee Inc. and/or its subsidiaries.
 *
 * Copyright (c) Redknee Inc. and its subsidiaries. All Rights Reserved.
 */

/**
 * 
 *
 * @author dshah
 * @since 
 */
public class TestAbc {

	public static void main(String args[]){
		
		try{
			class FilterLogTest extends PrintStream{
				public FilterLogTest(OutputStream oStr){
					super(oStr);
				}
				public void println(String x) {
					if (x.startsWith("entered in the getRawAmountStringV4"))
						return;
					super.println(x);
				}
			}
			
			OutputStream output = new FileOutputStream("/opt/redknee/product/cps/current/log/productcpsctl.log", true);
			PrintStream printOut = new FilterLogTest(output);
			System.setOut(printOut);
		}catch(Throwable t){
			
		}
	}
	
}
