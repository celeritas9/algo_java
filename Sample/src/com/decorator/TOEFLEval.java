/**
 * 
 */
package com.decorator;

/**
 * @author dshah
 *
 */
public class TOEFLEval extends CriteriaLink
{
	public TOEFLEval(EvaluationCriteria theNext) 
	{
		super(theNext);
	}

	public boolean evaluate(Application theApp)
	{
		if(super.evaluate(theApp))
		{
			System.out.println("TOEFLEval.evaluate called");
			return true;
		}
		else
		{
			return false;
		}
	}

}
