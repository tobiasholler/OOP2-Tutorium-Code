
public class Main {

	public static void main(String[] args) {
		Auto<Benzin> auto1 = new Auto<Benzin>();
		auto1.tanken(new Benzin());
		auto1.fahren();
		Benzin tank1 = auto1.tankAuspumpen();
		System.out.println(tank1);
	}

}
