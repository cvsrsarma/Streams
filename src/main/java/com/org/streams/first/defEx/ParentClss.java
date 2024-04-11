package com.org.streams.first.defEx;

public class ParentClss {
	
	protected void protectedTest() throws Exception {
		System.out.println("protected clss");
	}
	
	protected void protectedTest(int i) {
		System.out.println("protected clss");
	}
	public final void test() {
		System.out.println("Final method");
	}
	
	public final void test(int i) {
		System.out.println("over laoded final method");
	}
}
