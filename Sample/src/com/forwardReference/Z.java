package com.forwardReference;

class Z {
	static int peek(){ return j;}
	static int i = peek();
	static int j;
}