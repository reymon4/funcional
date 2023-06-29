package com.tuplas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.funcional.Compo;

public class Main {
	public static void main(String[] args) {
		// dado un nString contar el numero de repeticiones de cada palabra 
		
		Function<String, String[]> f = a -> a.split(" ");
		var a = f.apply("hola mundo en java hola hola");
		
		System.out.println("hola: " + Tupla.cantidadPalabra("hola", a, 0,0) );
		
		Function<String[], List<Tupla<String, Integer>>> g = b -> {
			List<Tupla<String, Integer>> result = new ArrayList<>();
			return Tupla.getList(b, 0, result);
		};
		
		var d = g.apply(a);
		
		System.out.println(d);
		
		d.stream().forEach(System.out::println);
		
		Function<String, List<Tupla<String, Integer>> > comp = Compo.<String,String[], List<Tupla<String, Integer>> >composicion2().apply(f).apply(g);
		System.out.println(comp.apply("hola mundo en java hola hola mundo en hola java"));
	}
}
