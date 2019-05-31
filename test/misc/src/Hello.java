package src;

import java.util.*;
import java.lang.Math.*;

class Hello{

	Hello(){
		System.out.println("Hello World!");
	}

	static{
			System.out.println("Hello World");
	}
	
	public static void main(String[] args) {
		// Hello h = new Hello();
		System.out.println(String.format("%tY-%<tB-%<td %<tA %<tr", new Date()));
		System.out.println(Math.sqrt(5.0));
	}

}