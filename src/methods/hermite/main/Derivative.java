package methods.hermite.main;

import java.util.ArrayList;

import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;

public class Derivative {
    // Function of 1 variable, keep track of 3 derivatives with respect to that variable,
	// use 2.5 as the current value.  Basically, the identity function.
	private double x;
	private int a;
	private DerivativeStructure polymonStruct;
	private DerivativeStructure x3;
	private DerivativeStructure x2;
	private DerivativeStructure x1;
	private DerivativeStructure free;
	private DerivativeStructure polymon;
			
			public Derivative(Point point){
				this.x=point.getX();
				this.a=point.getA();
				polymonStruct = new DerivativeStructure(1,a, 0, x);
				x3 = polymonStruct.pow(3);
				x2 = polymonStruct.pow(2);
				x1 = polymonStruct.pow(1);
				free = polymonStruct.pow(0);
				polymon = new DerivativeStructure(5.0, x3, 3.0, x2, 2.0, x1, 1.0,free);
			}

			
			public ArrayList<Double> makeDerivatives(){
				ArrayList<Double> listY = new ArrayList<Double>();
				for(int i = 1; i<=this.a;i++){
					double value=this.polymon.getPartialDerivative(i);
					System.out.println("Partial derivative number:"+this.a+" for function in point: "+this.x+" is ="+value);
					listY.add(value);
				}
				
				
				
				return listY;
			}
}
