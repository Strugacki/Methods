package methods.hermite.main;

import java.util.ArrayList;

public class Point {

	private double x;
	private ArrayList<Double> y = new ArrayList<Double>();
	
	
	/**
	 * Constructor without arguments
	 */
	public Point(){
		
	}
	
	
	/**
	 * Constructor with one argument
	 * @param x
	 */
	public Point(double x){
		super();
		this.x=x;
	}	
	
	/**
	 * @return the x
	 */
	public double getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(double x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public ArrayList<Double> getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(ArrayList<Double> y) {
		this.y = y;
	}
	
	
	/**
	 * @param y
	 */
	public void addY(double y){
		this.y.add(y);
	}
	
	/**
	 * @param i
	 * @return the n-th element from y list
	 */
	public double getNthY(int i){
		return this.y.get(i);
	}
	
	/**
	 * @return the size of y list
	 */
	public int getSize(){
		return this.y.size();
	}
	
}
