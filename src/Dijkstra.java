public class Dijkstra {
	
	private GraphInterface dijkstra(GraphInterface g, VertexInterface r, ASetInterface A, PiInterface pi, PreviousInterface previous) {
		A = initASet(r);
		
		VertexInterface pivot = r;
		
		double pi(r) = 0.0 ;
		
		if (VertexInterface x : g && isDifferent(x,r) == true) {
			pi(x) = Double.POSITIVE_INFINITY;
			}
		
		for (int j=1 ; j<= n-1 ; j++) {
			if (VertexInterface y : g) {
				if (isInA(y,A) == false && isSuccesor(pivot,y) == true) {
					if (pi(pivot) + p(pivot,y)< pi(y)) {
						pi(y) = pi(pivot) + p(pivot,y);			
					}
				}
			}
			searchMin(A) =  y;
			
			pivot = y ;
			
			A = A.union(pivot);
		 }
		
		
		
		 
		
			
			
		
			
			
		
		
	}

}
