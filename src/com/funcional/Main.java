package com.funcional;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Collector;

import java.util.stream.Stream;

import com.funcional.lista.Lista;
//Este record nos sirve para no modificar los datos que ingresamos
record PairDeber(String palabra, Integer conteo) {

  @Override
  public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      PairDeber palabra1 = (PairDeber) o;
      return Objects.equals(palabra, palabra1.palabra) && Objects.equals(conteo, palabra1.conteo);
  }

  @Override
  public int hashCode() {
      return Objects.hash(palabra, conteo);
  }
}

public class Main {
	 public static Lista<PairDeber> contar(String[] vstr) {
	        Lista<PairDeber> ret = Lista.NIL;

	        for (String s : vstr) {

	            PairDeber p = new PairDeber(s, 1);

	            var tmp1 = ret.contains(p);

	            if (tmp1.isEmpty()) {

	                //no lo encontro
	                ret = ret.prepend(p);
	            } else {
	                ///encontro

	                var item = tmp1.get();

	                ret = ret.remplace(item, new PairDeber(s, item.conteo() + 1));
	            }

	        }

	        return ret;

	    }

	    public static Lista<PairDeber> contar2(String[] vstr) {

	        List<PairDeber> ls=  Stream.of(vstr)
	                .collect(
	                        Collectors.groupingBy(Function.identity(), Collectors.counting())

	                )
	                .entrySet()
	                .stream()
	                .map(s-> new PairDeber(s.getKey(), s.getValue().intValue()))
	                .collect(Collectors.toList());

	        Lista<PairDeber> ret = Lista.NIL;

	        for( PairDeber p : ls){

	            ret = ret.prepend(p);
	        }

	        return ret;
	    }

	public static void main(String[] args) {
		// dado un nString contar el numero de repeticiones de cada palabra 
		
//		Function<String, String[]> f = a -> a.split(" ");
//		
//		Function<String[], List<Tupla<String, Integer>>> g = b ->{
//			Set<String> set = new HashSet<>(Arrays.asList(b));
//			List<Tupla<String, Integer>> lista = set.stream().map(c -> Tupla.<String,Integer>getTupla(b,c)).collect(Collectors.toList());
//			return lista;
//		};
//		
//	
//		var a = f.apply("hola mundo en java hola hola");
//		
//		for (int i = 0; i< a.length; i++ ) {
//			System.out.println(a[i]);
//		}
//		
//		var d = g.apply(a);
//		
//		d.stream().forEach(System.out::println);
//		
//		System.out.println("**************************************");
//
//		
//		Function<String, List<Tupla<String, Integer>> > comp = Compo.<String,String[], List<Tupla<String, Integer>> >composicion2().apply(f).apply(g);
//		System.out.println(comp.apply("hola mundo en java hola hola mundo en hola java"));
		String txt = "hola mundo hola hola texto en java mundo";
		Function<String, String[]> fn1 = str -> str.split(" ");

		Function<String[], Lista<PairDeber>> fn2 = vstr -> contar(vstr);

		Function<String, Lista<PairDeber>> fog = Compo.<String, String[], Lista<PairDeber>>composicion2().apply(fn1).apply(fn2);

		
		
		
		Lista<PairDeber> tmp = fog.apply(txt);
		tmp.forEach(s -> {
			System.out.printf("%-10s: %d\n", s.palabra(), s.conteo());
		});
	}

	}

