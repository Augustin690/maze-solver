package Dijkstra;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map.Entry;

public class Dijkstra {
	
	
	public static Previous dijkstra(GraphInterface g, VertexInterface r) {
		ASet aset = new ASet();
		Pi pi = new Pi();
		Previous previous = new Previous();
		
		return dijkstra(g, r, aset, pi, previous);
		
	}
	
	public static int getMin1(Object[] array){ 
	    int minValue = (int) array[0]; 
	    for(int i=1;i<array.length;i++){ 
	    	int arrayi = (int) array[i];
	      if(arrayi < minValue){ 
	        minValue = arrayi; 
	      } 
	    } 
	    return minValue; 
	  } 
	
	private static Previous dijkstra(GraphInterface g, 
			                           VertexInterface r, 
			                           ASet aset, 
			                           Pi pi, 
			                           Previous previous) {
		
		
		HashSet<VertexInterface> A = (HashSet<VertexInterface>) aset;
		
	    A.add(r);   
		VertexInterface pivot = r;  
		pi.put(r, 0);
	

		ArrayList<VertexInterface> list = g.getAllVertices2();
		System.out.println(list.toString());
	    for(VertexInterface x : list) {
	    	if(x != r) {
			pi.put(x,Integer.MAX_VALUE);
	    	}
          }

		int n = g.getNumber();
		for (int j=0 ; j<= n-1 ; j++) {
			System.out.println(j);
			System.out.println(A.toString());
			for(VertexInterface y: list) {
				if(A.contains(y) == false  && g.isSuccessor(pivot,y,g) == true) {
			          if (pi.get(pivot) + g.getWeight(pivot,y) < pi.get(y)) {
							pi.put(y, pi.get(pivot) + g.getWeight(pivot,y));
							previous.put(y, pivot);
							}
			}

			}
			System.out.println(previous.toString());
			
			Object[] array = pi.values().toArray();
			System.out.println(array.toString());
			for(VertexInterface y: list) {
				if(A.contains(y) == false) {
					Integer min = getMin1(array);
					for(Entry<VertexInterface, Integer> entry: pi.entrySet()) {
						if (min == entry.getValue()) {
							VertexInterface ymin = entry.getKey();
							pivot =  ymin;
							A.add(pivot);
						}
						
					}
					
				}
			}
		}
		System.out.println(previous.toString());
		return previous;

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
