package com.override;

public class Animal {
	private String name;
	
	public Animal (){
		name = "Generic Animal!";
	}
	protected void print() {
		System.out.println("This is from animal!");
	}

	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
		print();
	}
}
