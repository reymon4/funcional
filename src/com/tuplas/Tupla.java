package com.tuplas;

import java.util.ArrayList;
import java.util.List;

public sealed interface Tupla<S, I> permits TuplaImpl {

	S palabra();

	I cantidad();

	static <S, I> Tupla<S, I> of(S palabra, I cantidad) {
		System.out.println("entro a crear tupla");
		return new TuplaImpl<S, I>(palabra, cantidad);
	}

	static List<Tupla<String, Integer>> getList(String[] lista, Integer n, List<Tupla<String, Integer>> result ) {
		Tupla<String, Integer> tp = Tupla.of(lista[n], cantidadPalabra(lista[n], lista, 0, 0));
		if (n == lista.length-1) {
			return result;
		} else {
			System.out.println("entro al else");
			if (!result.contains(tp)) {
				System.out.println("entro a agregar");
				result.add(tp);
			}
			return Tupla.getList(lista, n+1, result);
		}
	}

	static Integer cantidadPalabra(String palabra, String[] lista, Integer n, Integer cantidad) {

		if (n == lista.length) {
			return cantidad;
		} else {
			if (palabra.equals(lista[n])) {
				cantidad = cantidad + 1;
			}
			return Tupla.cantidadPalabra(palabra, lista, n + 1, cantidad);
		}
	}
}
