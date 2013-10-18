package com.compiler;

/**
 * The program is to test the javac.
 *
 * @author dshah
 * @since 
 */
public class TestCompilation
{
	public static final String className = TestCompilation.class.getName();
	public static final String classCanonicalName = TestCompilation.class.getCanonicalName();
	public static final String classSimpleName = TestCompilation.class.getSimpleName();
	
	public static void main(String[] args)
	{
		Object temp2 = null;
		Object msg = null;
		int choice = 0;
		
		do
		{
			if(choice == 1)
			{
				msg = temp2;
				temp2 = null;
				continue;
			}
			msg = temp2;
			temp2 = null;

		} while (msg != null);
		
		System.out.println("Class name is: " +className);
		System.out.println("Class canonical name is: " +classCanonicalName);
		System.out.println("Class simple name is: " +classSimpleName);
	}
}
