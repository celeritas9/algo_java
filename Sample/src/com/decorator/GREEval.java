/**
 * 
 */
package com.decorator;

/**
 * @author dshah
 *
 */
public class GREEval extends CriteriaLink
{
	public GREEval(EvaluationCriteria theNext) 
	{
		super(theNext);
	}

	public boolean evaluate(Application theApp)
	{
		if(super.evaluate(theApp))
		{
			System.out.println("GREEval.evaluate called");
			return true;
		}
		else
		{
			return false;
		}
	}
}
