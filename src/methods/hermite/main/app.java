package methods.hermite.main;


public class app {

	public static void main(String[] args) {
		Hermite hermite = new Hermite();
		hermite.readPoints();
		System.out.println("Wybrany przedzia³ to ["+hermite.getP()+","+hermite.getK()+"]");
		for(int i=0;i<hermite.getPointsNumber();i++){
			System.out.println(hermite.getPoint(i));
		}
		hermite.fillDirevativesValues();
		Interpolation interpolation = new Interpolation(hermite);
	}

}
