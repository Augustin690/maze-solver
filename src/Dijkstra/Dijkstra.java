package Dijkstra;

import Dijkstra.PiInterface;
import java.util.ArrayList;
import Dijkstra.ASetInterface;
import Dijkstra.VertexInterface;

public class Dijkstra {
	
	private PreviousInterface dijkstra(GraphInterface g, VertexInterface r, ASetInterface A, PiInterface pi, PreviousInterface previous) {
		A = initASet(r);
		
		VertexInterface pivot = r;
		
		int pi(r) = 0.0 ;
		VertexInterface x = x;
		if (VertexInterface x : g && isDifferent(x,r) == true) {
			int pi(x) = Double.POSITIVE_INFINITY;
			}
		
		for (int j=1 ; j<= n-1 ; j++) {
			if (VertexInterface y : g) {
				if (isInA(y,A) == false && isSuccesor(pivot,y) == true) {
					if (pi(pivot) + p(pivot,y)< pi(y)) {
						int pi(y) = pi(pivot) + p(pivot,y);			
					}
				}
			}
			VertexInterface A.searchMin() =  y;
			
			pivot = y ;
			
			A = A.union(pivot);
		 }
		
		
		
		 
		
			
			
		
			
			
		
		
	}

}
