
public class Diesel implements Kraftstoff {

	@Override
	public void wirdGetankt() {
		System.out.println("Das Auto wird mit Diesel betankt.");
	}

	@Override
	public void wirdVerbraucht() {
		System.out.println("Tuk tuk tuk.");
	}

}
