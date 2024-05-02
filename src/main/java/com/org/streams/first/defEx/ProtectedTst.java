package com.org.streams.first.defEx;

public class ProtectedTst {
	
	public static void test() throws Exception {
		ParentClss p = new ParentClss();
		p.protectedTest();
	}
	
	public static void main(String [] args) throws Exception {
		test();
		ChildClss2 cls= new ChildClss2();
		System.out.println(cls.max(99,23));
		}

}
