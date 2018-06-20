package application;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Konto {
	private DoubleProperty kontostand;
	public Konto() {
		kontostand = new SimpleDoubleProperty(0.5);
	}
	public double getKontostand() {
		return kontostand.get();
	}
	public void setKontostand(double neuerKontostand) {
		kontostand.set(neuerKontostand);
	}
	public DoubleProperty kontostandProperty() {
		return kontostand;
	}
}
