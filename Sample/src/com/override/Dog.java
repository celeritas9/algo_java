package com.override;

public class Dog extends Animal {
	private String name;
	static int count;
	
	public Dog () {
		name = "Dog";
	}
	protected void print() {
		if((++count) <= 5){
			System.out.println("This is from dog.");
			setName(name);
		}
	}
}
