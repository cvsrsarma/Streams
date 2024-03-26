package com.org.streams.first.core;

public interface AbstractClass {
	
	public default void getMessage() {
		System.out.println("Hello from Abstract method.");
	}

}
