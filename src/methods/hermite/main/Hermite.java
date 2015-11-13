package methods.hermite.main;

import java.util.ArrayList;
import java.util.Scanner;

public class Hermite {

	private int p;
	private int k;
	private ArrayList<Point> points = new ArrayList<Point>();
	
	
	public Hermite(){
		
	}
	
	public int getPointsNumber(){
		return this.points.size();
	}
	
	
	public Point getPoint(int i){
		return this.points.get(i);	
	}
	
	/**
	 * @return the p
	 */
	public int getP() {
		return p;
	}

	/**
	 * @param p the p to set
	 */
	public void setP(int p) {
		this.p = p;
	}

	/**
	 * @return the k
	 */
	public int getK() {
		return k;
	}

	/**
	 * @param k the k to set
	 */
	public void setK(int k) {
		this.k = k;
	}
	
	public Hermite readPoints(){
		
		Scanner in = new Scanner(System.in);
		System.out.print("Podaj pocz�tek przedzia�u: ");
		if(in.hasNextInt()){
			this.p=in.nextInt();
		}
		System.out.println();
		System.out.print("Podaj koniec przedzia�u: ");
		if(in.hasNextInt()){
			this.k=in.nextInt();
		}
		System.out.println();
		System.out.println("Podaj kolejno w�z�y oraz ich krotno�ci. W celu zako�czenia wpisz: licz \n");
		System.out.println("Podaj warto�� x w�z�a: ");
		while(in.hasNextDouble()){
					double x = in.nextDouble();
					if(x>=this.getP() && x<= this.getK()){
					Point point = new Point();
					point.setX(x);
					System.out.println();
					System.out.println("Podaj krotno�� w�z�a: ");
					if(in.hasNextInt()){
						int a = in.nextInt();
						point.setA(a);
						points.add(point);
						System.out.println(point);
						System.out.println();
					}
					System.out.println("Podaj warto�� x w�z�a: ");
			}else{
				System.out.println("Liczba nie mie�ci si� w przedziale, program ko�czy dzia�anie!!");
				break;
			}
		}
		return this;
	}
	
	
}
