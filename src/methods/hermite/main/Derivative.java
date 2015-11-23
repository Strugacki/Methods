package methods.hermite.main;

import java.util.ArrayList;

import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;

public class Derivative {
	private double x;
	private int a;
	private DerivativeStructure polymonStruct;
	private DerivativeStructure x8;
	private DerivativeStructure x3;
	private DerivativeStructure x2;
	private DerivativeStructure x1;
	private DerivativeStructure free;
	private DerivativeStructure polymon;
			
	/**
	 * Constructor with argument
	 * @param point
	 */
	public Derivative(Point point){
		this.x=point.getX();
		this.a=point.getA();
		polymonStruct = new DerivativeStructure(1,a, 0, x);
		x3 = polymonStruct.pow(4);
		x2 = polymonStruct.pow(2);
		x1 = polymonStruct.pow(1);
		free = polymonStruct.pow(0);
		//function is 5x^4 + 3x^2 + 2x + 1
		polymon = new DerivativeStructure(5.0, x3, 3.0, x2, 2.0, x1, 1.0,free);
		
		//function is x^8 + 1
		//x8 = polymonStruct.pow(8);
		//polymon = new DerivativeStructure(1.0, x8, 1.0,free);
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<Double> makeDerivatives(){
		ArrayList<Double> listY = new ArrayList<Double>();
		double value = 0;
		value=this.polymon.getValue();
		System.out.println("Wartoœæ funkcji w punkcie: "+this.x+" wynosi ="+value);
		listY.add(value);
		for(int i = 1; i<this.a;i++){
			value=this.polymon.getPartialDerivative(i);
			System.out.println("Wartoœæ pochodnej rzêdu:"+i+" dla funkcji w punkcie: "+this.x+" wynosi ="+value);
			listY.add(value);
		}
		System.out.println();
		
		
		return listY;
	}
}
