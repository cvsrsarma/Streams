package com.org.streams.first.defEx;

import java.io.IOException;

public class ChildClss extends ParentClss{
	
	
	@Override
	public int max(int i, int j) {
		
		int k=super.max(j, i)-100;
		System.out.println(k);
		return k;
	}

	protected void protectedTest() throws IOException{
		// TODO Auto-generated method stub
	}
	
	protected void protectedTest(int i) {
		// TODO Auto-generated method stub
		super.protectedTest(i);
	}
	

}
