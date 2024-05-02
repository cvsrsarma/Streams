package com.org.streams.first.defEx;

import java.io.IOException;

public class ChildClss2 extends ChildClss{
	
	
	protected void protectedTest() throws IOException{
		// TODO Auto-generated method stub
	}
	
	protected void protectedTest(int i) {
		// TODO Auto-generated method stub
		super.protectedTest(i);
	}

	@Override
	public int max(int i, int j) {
		int k=super.max(i+100, j+100);
		System.out.println(k);
		return k;
	}
	

}
