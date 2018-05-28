
public class Strom implements Kraftstoff {

	@Override
	public void wirdGetankt() {
		System.out.println("Das Auto wird mit Strom aufgeladen.");
	}

	@Override
	public void wirdVerbraucht() {
		System.out.println("Surrrrr.");
	}

}
