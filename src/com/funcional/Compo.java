package com.funcional;

import java.util.function.Function;

public interface Compo <T, U, V>{
	
	static <T> Function<Function<T, T>, Function<Function<T, T>, Function<T, T>>>  composicion1 (){
		return f -> g -> x -> f.apply(g.apply(x));
	}
	
	static <T, U, V> Function<Function<T, U>, Function<Function<U, V>, Function<T, V>>>  composicion2 (){
		return f -> g -> x -> g.apply(f.apply(x));
	}
	
	//string a String[]
	//String[] a tupla (String, integer)
	//string a tupla(String, integer)

	
	


			
}
