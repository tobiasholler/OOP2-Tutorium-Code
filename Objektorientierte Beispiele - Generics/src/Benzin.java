
public class Benzin implements Kraftstoff {

	@Override
	public void wirdGetankt() {
		System.out.println("Das Auto wird mit Benzin betankt.");
	}

	@Override
	public void wirdVerbraucht() {
		System.out.println("Brumm brumm.");
	}

}
