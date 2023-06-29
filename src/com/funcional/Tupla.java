package com.funcional;

public final class Tupla <S, I> {
	
	private final S string;
	private final I integer;
	
	public Tupla(S string, I integer) {
		this.string = string;
		this.integer = integer;
	}

	public S getString() {
		return string;
	}

	public I getInteger() {
		return integer;
	}

	@Override
	public String toString() {
		return String.format("( %s , %s )", string, integer.toString());
	}
	
	static <S, I> Tupla<S, I> getTupla(String[] lista, String str){
		Integer contador = 0;
		for (int i = 0; i< lista.length; i++ ) {
			if(str.equals(lista[i])) contador++;
		}
		return new Tupla(str, contador);
	}
	
	
	

}
