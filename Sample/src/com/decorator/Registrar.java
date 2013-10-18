/**
 * 
 */
package com.decorator;

/**
 * @author dshah
 *
 */
public class Registrar
{
	public boolean evaluate(Application theApp, EvaluationCriteria criteria)
	{
		boolean success = criteria.evaluate(theApp);
		return success;
	}
}
