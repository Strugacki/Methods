package methods.hermite.main;

import java.util.ArrayList;

import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.interpolation.HermiteInterpolator;

public class Interpolation {
	private String polymonial;
	
	
	public Interpolation(){
		
	}
	
	/**
	 * @return the polynomial
	 */
	public String getPolymonial() {
		return polymonial;
	}

	/**
	 * @param polynomial the polynomial to set
	 */
	public void setPolymonial(String polymonial) {
		this.polymonial = polymonial;
	}
	 
	// obliczanie ilorazow roznicowych
    public double[] quotients(Hermite hermit,  double[] nodes) throws Exception {
    	int nodesNumber=0; // ilosc punktow
    	int k = 0;  // wypelnianie pierwszego wiersza
        for (int i = 0; i < hermit.getPointsNumber();i++) {
        	nodesNumber += hermit.getPoint(i).getSize(); // liczymy ilosc pochodnych
        }
        System.out.println();
        double[][] quotients = new double[nodesNumber][]; // tworzenie kolumn ilorazów jak w tej tabelce ze skryptu
        for (int i = 0; i < nodesNumber; i++){ // tworzenie wierszy
        	quotients[i] = new double[nodesNumber-i]; //tworzy siê tablicowa piramida 
        }
        for(int i = 0; i < hermit.getPointsNumber(); i++) {
            for (int j = 0; j < hermit.getPoint(i).getSize(); j++) {
            	quotients[k][0] = hermit.getPoint(i).getNthY(0); //wype³niamy pierwszy wiersz wartoœciamy funkcji f(x) dla danego x
                k++;
            }
        }
        int factorial = 1; // wypelnianie reszty wierszy
        for (int j = 1; j < nodesNumber; j++) { 
        	factorial *= j;
            for (int i = 0; i < nodesNumber - j; i++) {
                if (nodes[i+j] - nodes[i] == 0) { // jezeli w mianowniku zero
                	quotients[i][j] = hermit.getYfromX(nodes[i+j],j) / factorial; // metoda z silni¹ i pochodnymi
                }
                else { // zwykla metoda
                	quotients[i][j] = (quotients[i+1][j-1] - quotients[i][j-1]) / (nodes[i+j] - nodes[i]); //inaczej normalna metoda
                }
            }
        }
        int r=1;
        for (int i = 0; i < nodesNumber; i++) { 
            for (int j = 1; j < nodesNumber-i; j++) {
                	System.out.print("  f[t"+i+"][t"+j+"]:"+quotients[i][j]);
                }
            System.out.println();
            }
        double[] diagonal = quotients[0]; // zwrocenie gornej przekatnej z której budujemy wielomian. Chodzi o wspó³czynniki
        String polynom = "P(x)= ";
        for(int i=0;i<diagonal.length;i++){//testowe wypisanie wielomianu
        	if(diagonal[i]!=0){
        	polynom += diagonal[i]+"";
        	int l=i-1;
        	while(l>=0 && i>0){
        		if(nodes[l]>0){
        			polynom += "(x-"+nodes[l]+")";
        			if(l>=1){
        				polynom +="*";	
        			}
        		}
        		else if(nodes[l]<0){
        			polynom += "(x+"+nodes[l]*(-1)+")";
        			if(l>=1){
        				polynom +="*";	
        			}
        		}else if(nodes[l]==0.0){
        			polynom += "(x)";
        			if(l>=1){
        				polynom +="*";	
        			}
        		}
        		l--;
        	}
        	}
        	if(i<diagonal.length-1 && diagonal[i+1]>0 ){
        		polynom+="+";
        	}else{
        		polynom+=" ";
        	}
        }
    
        System.out.print(polynom);

        System.out.println();    
        Polynomial w = Polynomial.NewtonFormToPolynomial(nodes, diagonal);//nie dzia³a dobrze
        System.out.println();
        //System.out.println(w);
        return diagonal;
    }
	     
	    // interpolacja Hermite'a
	    public Interpolation(Hermite hermit){
	    	//System.out.println(hermit.getPointsNumber());
	    	int k = 0;  // wypelnianie tablicy
	    	int n=0;
	    	for (int i = 0; i < hermit.getPointsNumber(); i++) {
	            for (int j = 0; j <hermit.getPoint(i).getSize(); j++) {
	                n++;//zliczanie wêz³ów
	            }
	        }
	    	double[] nodes = new double[n]; //tutaj beda te nasze wezly t0 t1 itp
	        for (int i = 0; i < hermit.getPointsNumber(); i++) {
	            for (int j = 0; j <hermit.getPoint(i).getSize(); j++) {
	                nodes[k] = hermit.getPoint(i).getX();
	                k++;
	            }
	        }
	        for(int l=0;l<nodes.length;l++){
	        	System.out.println("Wartoœæ t["+l+"]: "+nodes[l]);//wypisywanie wêz³ów
	        }
	        try {
				double[] quotientss = quotients(hermit,nodes); // obliczenie ilorazow roznicowych
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	
	

}
