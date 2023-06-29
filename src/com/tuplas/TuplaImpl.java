package com.tuplas;

public final class TuplaImpl<S, I> implements Tupla<S, I>{

	private final S palabra;
	private final I cantidad;
	
	public TuplaImpl(S palabra, I cantidad) {
		this.palabra = palabra;
		this.cantidad = cantidad;
	}

	@Override
	public S palabra() {
		// TODO Auto-generated method stub
		return palabra;
	}

	@Override
	public I cantidad() {
		// TODO Auto-generated method stub
		return cantidad;
	}
	

	@Override
	public String toString() {
		return String.format("( %s , %s )", palabra, cantidad.toString());
	}

}
