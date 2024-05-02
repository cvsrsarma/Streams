package com.org.streams.first.core;

import java.io.IOError;
import java.io.IOException;

import com.org.streams.first.defEx.ParentClss;

public class OverRideEx {

}

class A extends ParentClss{
	
	void overLoadEx() {
		System.out.println("OverLoad");
	}
	public void overLoadEx(int i){
		System.out.println("OverLoad");
	}
	
	private void overLoadEx(String s) {
		System.out.println(s);
	}
	
	 void overRd() throws Exception {
		System.out.println("Parent overRd");
		A a = new A();
		a.protectedTest();
	}
	 protected void protectedTest() throws Exception {
		 super.protectedTest();
			System.out.println("child clss");
		}
	
}
class B extends A{
	@Override
	void overRd() throws IOException{
		System.out.println("Child method");
	}
	protected void overRd(int i)  {
		System.out.println("Child method");
	}
	public void overRd(String s)  {
		System.out.println("Child method");
		
		A a = new A();
		
	}
	
	
}
