package Dijkstra;

import Dijkstra.PiInterface;
import java.util.ArrayList;
import Dijkstra.ASetInterface;
import Dijkstra.VertexInterface;
import Dijkstra.GraphInterface;
import Dijkstra.PreviousInterface;

public class Dijkstra {
	
	private PreviousInterface dijkstra(GraphInterface g, VertexInterface r, ASetInterface A, PiInterface pi, PreviousInterface previous) {
	

		A = A.union(r);   //adding r to A which is supposed to be empty initially
		
		VertexInterface pivot = r;  
	
		VertexInterface x = null ;
	
		while (g.isInG(x)) {
			int PIx = pi.f(x);
			PIx = (int) Double.POSITIVE_INFINITY;      //setting pi(x) to positive infinity for x in g 
			}
		
		int PIr = pi.f(r);  //setting the value of pi(r) to 0
	    PIr = 0;
		
		int n = g.getNumber();
		
		for (int j=1 ; j<= n-1 ; j++) {
			while (g.isInG(x)) {
				if (A.isInA(x) == false && x.isSuccessor(pivot) == true) {
					if (pi.f(pivot) + g.getWeight(pivot,x)< pi.f(x)) {
						int PIx = pi.f(x);
						PIx = pi.f(pivot) + g.getWeight(pivot,x);
						VertexInterface fa = previous.father(x);
						fa = pivot;
						
					}
				}
			}
			VertexInterface y  =  A.searchMin();
			
			pivot = y ;
			
			A = A.union(pivot);
		 }
	}

}
