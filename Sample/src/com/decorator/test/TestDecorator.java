/**
 * 
 */
package com.decorator.test;

import com.decorator.Application;
import com.decorator.EvaluationCriteria;
import com.decorator.GPAEval;
import com.decorator.GREEval;
import com.decorator.Registrar;
import com.decorator.TOEFLEval;

/**
 * @author dshah
 */
public class TestDecorator 
{
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Application anApp = new Application();
		Registrar registrar = new Registrar();
		
		System.out.println("Running first eval");
		GPAEval aGPAEval = new GPAEval();
		registrar.evaluate(anApp, aGPAEval);
		
		//Evaluate GPA and GRE
		System.out.println("Running second eval");
		GREEval aGREEval = new GREEval(new GPAEval());
		registrar.evaluate(anApp, aGREEval);
		
		//Evaluate GPA and TOEFL
		System.out.println("Runnig third eval");
		TOEFLEval aTOEFLEval = new TOEFLEval(new GPAEval());
		registrar.evaluate(anApp, aTOEFLEval);
		
		//Evaluate TOEFL, GRE, GPA through chaining and decorator.
		System.out.println("Running forth eval");
		EvaluationCriteria criteria = new TOEFLEval(new GREEval(new GPAEval()));
		registrar.evaluate(anApp, criteria);
	}
}
