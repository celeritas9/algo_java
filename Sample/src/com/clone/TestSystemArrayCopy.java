package com.clone;

import java.util.LinkedList;

public class TestSystemArrayCopy {

	public static void main(String[] args)
	{
		Employee1[] source = new Employee1[5];
		Employee1[] destination = new Employee1[5];
		
		System.out.println("source " +source+ " destination " +destination);
		System.out.println("Before system.arrayCopy equality check " + (source == destination));
		
		for(int i = 0; i < 5; i++)
		{
			Employee1 emp1 = new Employee1("a"+i, i, new LinkedList());
			source[i] = emp1;
		}
		
		System.arraycopy(source, 0, destination, 0, source.length);
		System.out.println("source " +source+ " destination " +destination);
		System.out.println("After system.arrayCopy equality check " + (source[0] == destination[0]));
		
		//Now modify a cloned object field in source array and see if it's reflected on the destination.
		source[2].name = "modifiedName";
		System.out.println("After modifiying name in source[2], verifying destination[2].name: " +destination[2].name);
		
		
		partialDeepCloneArray(source, destination);
		System.out.println("source " +source+ " destination " +destination);
		System.out.println("After partial deep cloning reference equality check " + (source[0] == destination[0]));
		System.out.println("After partial deep cloning reference equality check on uncloned field " + (source[0].ll == destination[0].ll));
		//Now modify a cloned object field in source array and see if it's reflected on the destination.
		source[2].name = "againModifiedName";
		System.out.println("After deep clone and after modifiying name in source[2], verifying destination[2].name: " +destination[2].name);
	}

	//This method is partial deep clone. The third field LinkedList is not cloned.
	public static void partialDeepCloneArray(Employee1[] source, Employee1[] destination)
	{
		int i = 0;
		for(Employee1 emp : source)
		{
			Employee1 destEmp = new Employee1(new String(emp.name), emp.id, emp.ll);
			destination[i++] = destEmp;
		}
	}
}
