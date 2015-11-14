package methods.hermite.main;

import java.util.ArrayList;

import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;

public class Interpolation {
	private String polymonial;
	
	
	public Interpolation(){
		
	}
	
	/**
	 * @return the polymonial
	 */
	public String getPolymonial() {
		return polymonial;
	}

	/**
	 * @param polymonial the polymonial to set
	 */
	public void setPolymonial(String polymonial) {
		this.polymonial = polymonial;
	}
	 
	// obliczanie ilorazow roznicowych
	    private double[] quotients(Hermite hermit,  double[] nodes) throws Exception {
	    	int nodesNumber = 0; // ilosc punktow
	        double[][] quotients = new double[nodesNumber][]; // tworzenie kolumn ilorazów jak w tej tabelce ze skryptu
	        for (int i = 0; i < hermit.getPointsNumber();i++) {
	        	nodesNumber += hermit.getPoint(i).getSize(); // liczymy ilosc pochodnych
	        }
	        for (int i = 0; i < nodesNumber; i++) // tworzenie wierszy
	        	quotients[i] = new double[nodesNumber-i];
	        int k = 0;  // wypelnianie pierwszego wiersza
	        for (int i = 0; i < hermit.getPointsNumber(); i++) {
	            for (int j = 0; j < hermit.getPoint(i).getSize(); j++) {
	            	quotients[k][0] = hermit.getPoint(i).getNthY(0);
	                k++;
	            }
	        }
	        int factorial = 1; // wypelnianie reszty wierszy
	        for (int j = 1; j < nodesNumber; j++) { 
	        	factorial *= j;
	            for (int i = 0; i < nodesNumber - j; i++) {
	                if (nodes[i+j] - nodes[i] == 0) { // jezeli w mianowniku zero
	                	quotients[i][j] = hermit.getYfromX(nodes[i+j],j) / factorial; // alternatywna metoda
	                }
	                else { // zwykla metoda
	                	quotients[i][j] = (quotients[i+1][j-1] - quotients[i][j-1]) / (nodes[i+j] - nodes[i]);
	                }
	            }
	        }
	        double[] diagonal = quotients[0]; // zwrocenie gornej przekatnej z której budujemy wielomian. Chodzi o te œmieszne wspó³czynniki
	        return diagonal;
	    }
	     
	    // interpolacja Hermite'a
	    private void interpolacja(Hermite hermit){
	    	double[] nodes = new double[hermit.getPointsNumber()]; //tutaj beda te nasze wezly t0 t1 itp
	        int k = 0;  // wypelnianie tablicy
	        for (int i = 0; i < hermit.getPointsNumber(); i++) {
	            for (int j = 0; j <hermit.getPoint(i).getSize(); j++) {
	                nodes[k] = hermit.getPoint(i).getX();
	                k++;
	            }
	        }
	        try {
				double[] quotients = quotients(hermit,nodes);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // obliczenie ilorazow roznicowych
	    }
	
	

}
