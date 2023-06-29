package com.funcional.lista;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

public sealed interface Lista<T> permits Nil, Cons {

	Lista NIL = new Nil();

	T head();

	Lista<T> tail();

	boolean isEmpty();

	static <T> Lista<T> of(T h, Lista<T> t) {
		return new Cons<>(h, t);
	}

	static <T> Lista<T> of(T... elems) {
		Lista<T> ret = Lista.NIL;
		for (int i = elems.length - 1; i >= 0; i--) {
			T h = elems[i];
			var tmp = Lista.of(h, ret);
			ret = tmp;
		}
		return ret;
	}
	// OPERACIONES BASICAS CON LISTAS
	default Lista<T> append(T elemen) {
		return isEmpty() ? Lista.of(elemen) : Lista.of(head(), tail().append(elemen));
	}

	default Lista<T> prepend(T elem) {
		return Lista.of(elem, this);
	}

	default Lista<T> remove(T elem) {
		return isEmpty() ? NIL : isEmpty() ? tail() : Lista.of(head(), tail().remove(elem));
	}

	default Lista<T> drop(int n) {
		return isEmpty() || n <= 0 ? this : tail().drop(n - 1);
	}

	default Lista<T> dropWhile(Predicate<T> p) {
		return isEmpty() || p.test(head()) ? tail().dropWhile(p) : this;
	}

	default Lista<T> concat(Lista<T> a) {
		return isEmpty() ? a : Lista.of(head(), tail().concat(a));
	}

	default Lista<T> take(int n) {
		return isEmpty() || n < 0 ? NIL : Lista.of(head(), tail().take(n - 1));
	}

	default Lista<T> takeWile(Predicate<T> p) {
		return isEmpty() || !p.test(head()) ? NIL : Lista.of(head(), tail().takeWile(p));
	}
	
	//OPERACIONES CON ELEMENTOS DE LA LISTA
	
	static  Integer suma (Lista<Integer> ls) {
		return ls.isEmpty() ? 0 : ls.head()+ suma(ls.tail());
	}
	
	static Integer maximo (Lista<Integer> ls) {
		return ls.isEmpty() ? 0 : Math.max(ls.head(), maximo(ls.tail()));
	}

	
	////Correccion deber conteo
	default Lista<T> remplace(T elem, T newElem) {
		if (isEmpty()) {
			return Lista.NIL;
		}

		return head().equals(elem) ? Lista.of(newElem, tail()) : Lista.of(head(), tail().remplace(elem, newElem));

	}

	 default Optional<T> contains(T elemt){

	        if (isEmpty()){

	            return Optional.empty();

	        }

	        return head().equals(elemt)
	                ?Optional.of(head())
	                : tail().contains(elemt);

	        /*

	        if (head().equals(elemt)){
	            return Optional.of(head());
	        }else {

	            return  tail().contains(elemt);
	        }
	        */
	    }


	    default void forEach(Consumer<T> fn){

	        if (!isEmpty()){
	            fn.accept(head());
	            tail().forEach(fn);

	        }

	    }
	
	
}
