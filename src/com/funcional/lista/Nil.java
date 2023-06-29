package com.funcional.lista;

//--nodo final
public final class Nil<T> implements Lista<T> {
	
	
    protected Nil(){
    }
    @Override
    public T head() {
        return null;
    }

    @Override
    public Lista<T> tail() {
        return null;
    }

    public boolean isEmpty (){
        return true;
    }

    public String toString(){
        return  "NIL";
    }
}
