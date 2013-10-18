package com.decorator;

/**
 * @author dshah
 */
public class GPAEval extends EvaluationCriteria
{
	public boolean evaluate(Application theApp)
	{
		System.out.println("GPAEval.evaluate called");
		return true;
	}
}
