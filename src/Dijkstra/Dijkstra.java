package Dijkstra;

import java.util.ArrayList;
import java.util.HashSet;


public class Dijkstra {

	/**
	 * Implementing the Dijkstra algorithm: returns the shortest path from the root to every other vertex in a graph
	 * @param g the graph 
	 * @param r the root 
	 * @return the previous hashtable that associates each vertex to its father when taking the shortest path starting from the root
	 */
	public static Previous dijkstra(GraphInterface g, VertexInterface r) {
		ASet aset = new ASet();
		Pi pi = new Pi();
		Previous previous = new Previous();
		
		return dijkstra(g, r, aset, pi, previous);
		
	}
	
	/**
	 * Returns the minimum value of an ArrayList of Integers
	 * @param listPi the ArrayList of Integers
	 * @return the minimum value
	 */
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
	 * Implementing the Dijkstra algorithm  returns the shortest path from the root to every other vertex in a graph
	 * @param g the graph
	 * @param r the root
	 * @param aset the set that contains the vertices that have been examined
	 * @param pi hashtable that associates each vertex to the length of the shortest path from it to the root  
	 * @param previous hashtable of vertices
	 * @return the previous hashtable that associates each vertex to its father when taking the shortest path starting from the root
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
			for(VertexInterface y: list) {
				if(A.contains(y) == false  && g.isSuccessor(pivot,y,g) == true) {
			          if (pi.get(pivot) + g.getWeight(pivot,y) < pi.get(y)) {
							pi.put(y, pi.get(pivot) + g.getWeight(pivot,y));
							previous.put(y, pivot);
							}
			}

			}
			
			ArrayList<Integer> listPi = new ArrayList<Integer>();

			for(VertexInterface y: list) {
				if(A.contains(y) == false) {
					
					listnotinA.add(y);
				}

			}
		
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
