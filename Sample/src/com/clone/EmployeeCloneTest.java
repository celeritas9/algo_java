/**
 * 
 */
package com.clone;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author dshah
 *
 */
public class EmployeeCloneTest
{
	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		Employee emp1 = new Employee("devang", 1, new FileOutputStream("C:\\redknee\\test\\emp1.txt"));
		Employee emp2 = emp1.clone();
		
		System.out.println("Employee 1 name: " +emp1.name);
		System.out.println("Employee 1 id: " +emp1.id);
		System.out.println("Employee 1 os: " +((FileOutputStream)emp1.out).getFD());
		
		System.out.println("Employee 2 name: " +emp2.name);
		System.out.println("Employee 2 id: " +emp2.id);
		System.out.println("Employee 2 os: " +((FileOutputStream)emp2.out).getFD());
		
		/*Now changing the instance variables of Employee 1*/
		emp1.name = "xyz";
		emp1.id = 10;
		emp1.out = new FileOutputStream("C:\\redknee\\test\\emp10.txt");
		
		System.out.println("***************After changing the employee 1********************");
		System.out.println("Employee 1 name: " +emp1.name);
		System.out.println("Employee 1 id: " +emp1.id);
		System.out.println("Employee 1 os: " +((FileOutputStream)emp1.out).getFD());
		
		System.out.println("Employee 2 name: " +emp2.name);
		System.out.println("Employee 2 id: " +emp2.id);
		System.out.println("Employee 2 os: " +((FileOutputStream)emp2.out).getFD());
		
	}
}
