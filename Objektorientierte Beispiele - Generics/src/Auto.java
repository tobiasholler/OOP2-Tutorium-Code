
public class Auto<T extends Kraftstoff> {
	private T getankterKraftstoff;
	public Auto() {
		System.out.println("Ein Auto wurde gebaut.");
	}
	public void fahren() {
		getankterKraftstoff.wirdVerbraucht();
	}
	public void tanken(T neuerKraftstoff) {
		getankterKraftstoff = neuerKraftstoff;
		getankterKraftstoff.wirdGetankt();
	}
	public T tankAuspumpen() {
		return getankterKraftstoff;
	}
}
