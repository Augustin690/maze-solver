package Dijkstra;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map.Entry;

public class Dijkstra {

	/**
	 * 
	 * @param g 
	 * @param r
	 * @return
	 */
	public static Previous dijkstra(GraphInterface g, VertexInterface r) {
		ASet aset = new ASet();
		Pi pi = new Pi();
		Previous previous = new Previous();
		
		return dijkstra(g, r, aset, pi, previous);
		
	}
	
	public static int getMin1(ArrayList<Integer> listPi){ 
		int size = listPi.size();
		int minValue;
		if(size != 0) {
			 minValue = listPi.get(0); 
			    for(int i=1;i<listPi.size();i++){ 
			      if(listPi.get(i) < minValue){ 
			        minValue = listPi.get(i); 
			      } 
			    }
			}
		else {
			return 0;
		}
	   
		return minValue; 
	  } 
	
	
	/**
	 * yes
	 * @param g vamos
	 * @param r
	 * @param aset
	 * @param pi
	 * @param previous
	 * @return
	 */
	private static Previous dijkstra(GraphInterface g, 
			                           VertexInterface r, 
			                           ASet aset, 
			                           Pi pi, 
			                           Previous previous) {
		
		
		HashSet<VertexInterface> A = (HashSet<VertexInterface>) aset;
		ArrayList<VertexInterface> list = g.getAllVertices2();
		ArrayList<VertexInterface> listnotinA = new ArrayList<VertexInterface>();
		
	    A.add(r);   
		VertexInterface pivot = r;  
		pi.put(r, 0);
		System.out.println(A.toString());
		for(VertexInterface y: list) {
			if(y.getLabel().contentEquals("W")){
				A.add(y);
			}
		}
	

		System.out.println(list.toString());
		System.out.println("Pi"+ pi.toString());
	    for(VertexInterface x : list) {
	    	if(x != r) {
			pi.put(x,Integer.MAX_VALUE);
	    	}
          }
	    System.out.println("Pi"+ pi.toString());
		int n = g.getNumber();
		for (int j=0 ; j<= n-1 ; j++) {
			System.out.println("j:"+j);
			System.out.println("A"+ A.toString());
			/*System.out.println("Pi"+ pi.toString());*/
			for(VertexInterface y: list) {
				if(A.contains(y) == false  && g.isSuccessor(pivot,y,g) == true) {
			          if (pi.get(pivot) + g.getWeight(pivot,y) < pi.get(y)) {
							pi.put(y, pi.get(pivot) + g.getWeight(pivot,y));
							previous.put(y, pivot);
							}
			}

			}
			/*System.out.println("previous boucle:"+ previous.toString());*/ 
			
			/*
			 *Créer une liste des éléments qui ne sont pas dans A 
			System.out.println("pivalues" + pi.values().size()); * En même temps, créer une liste contenant les Pi de ces sommets
			 * 
			 * Apres trouver le minimum de ces pi, récupérer l'indice dans la liste avec lequel on récupère le sommet dans la première liste -> pivot
			 */
			ArrayList<Integer> listPi = new ArrayList<Integer>();
			
			/*Object[] array = pi.values().toArray();*/
			
			/*System.out.println("listnotinA" + listnotinA);*/

			for(VertexInterface y: list) {
				if(A.contains(y) == false) {
					// pour min : regarder collections minimum
					listnotinA.add(y);
				}

			}
			/*System.out.println(listnotinA);*/
			ArrayList<VertexInterface> toRemove = new ArrayList<VertexInterface>();
			for(VertexInterface x: listnotinA) {
			    	if(A.contains(x)) {
			    		toRemove.add(x);
			    	}
			    }
			listnotinA.removeAll(toRemove);
		    for(VertexInterface y: listnotinA) {
		    	listPi.add(pi.get(y));
		    }
		    
		   /* ArrayList<Integer> toRemovePi = new ArrayList<Integer>();
		    for(VertexInterface x: toRemove) {
		    	toRemovePi.add(pi.get(x));
		    }*/
		    /*listPi.removeAll(toRemovePi);*/
		    /*System.out.println(listPi);*/
		    
		    int min = getMin1(listPi);
		    int minIndex;
		    VertexInterface ymin;
		    
		    if(listPi.size()!=0) {
		    	minIndex = listPi.indexOf(min);
			    ymin = listnotinA.get(minIndex);
		    }
		    else {
		    	minIndex = 0;
			    ymin = null;
		    }
		 
		    System.out.println(min);
		    System.out.println(minIndex);
		    System.out.println(ymin);
		    
		    pivot = ymin;
		    System.out.println(pivot);
	         
		    if(pivot!=null) {
		    	A.add(pivot);
		    }
			
		}
		System.out.println(previous.toString() + previous.size());
		return previous;

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
