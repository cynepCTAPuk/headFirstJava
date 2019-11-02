package com.example;

import com.example.Boo;

class SonOfBoo extends Boo {
	public SonOfBoo() {
		super("boo");
	}
	public SonOfBoo(int i) {
		super("Fred");
	}	
	public SonOfBoo(String s) {
		super(42);
	}
//	public com.example.SonOfBoo(int i, String s) {
//	}
//	public com.example.SonOfBoo(String a, String b, String c) {
//		super(a,b);
//	}
	public SonOfBoo(int i, int j) {
		super("man", j);
	}
//	public com.example.SonOfBoo(int i, int x, int y) {
//		super(i, "star");
//	}
}