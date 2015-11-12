package methods.hermite.main;

import java.util.ArrayList;
import java.util.Scanner;

public class Hermite {

	private ArrayList<Point> points = new ArrayList<Point>();
	
	
	public Hermite(){
		
	}
	
	
	public Hermite readPoints(){
		
		Scanner in = new Scanner(System.in);
		System.out.println("Podaj kolejno wêz³y oraz ich krotnoœci. W celu zakoñczenia wpisz: licz \n");
		while(in.hasNextLine()){
			if(in.next().toString().equals("licz") && !(in.hasNextDouble())){
				break;
			}else{
				if(in.hasNextDouble()){
					double x = in.nextDouble();
					Point point = new Point();
					point.setX(x);
					System.out.println();
					System.out.println("Podaj krotnoœæ wêz³a: ");
					if(in.hasNextInt()){
						int a = in.nextInt();
						point.setA(a);
						points.add(point);
						System.out.println(point);
						System.out.println();
					}
				}
			}
			System.out.println("Podaj kolejno wêz³y oraz ich krotnoœci. W celu zakoñczenia wpisz: licz \n");
			System.out.println("Podaj wartoœæ x wêz³a: ");
		}
		return this;
	}
	
	
}
