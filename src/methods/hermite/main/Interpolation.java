package methods.hermite.main;

public class Interpolation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hermite hermite = new Hermite();
		hermite.readPoints();
		System.out.println("Wybany przedzia³ to ["+hermite.getP()+","+hermite.getK()+"]");
		for(int i=0;i<hermite.getPointsNumber();i++){
			System.out.println(hermite.getPoint(i));
		}

	}

}
