import java.text.DecimalFormat;

/**
 * @author Yasahan Zengin
 * Matrikelnummer: 01367563
 */

public class DVD extends Artikel {
	private static final DecimalFormat doubleFormat = new DecimalFormat(".00");
	private static final long serialVersionUID = 1L;
	private int ageRating;
	private int duration;

	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public void setAgeRating(int ageRating) {
		this.ageRating = ageRating;
	}
	public int getAgeRating() {
		return ageRating;
	}

	DVD(int id, String titel, String publisher, int publicationDate, double price, int duration, int ageRating) {
		super(id, titel, publicationDate, publisher, price);
		if(ageRating == 0 || ageRating == 6 ||ageRating == 12 ||ageRating == 16 ||ageRating == 18){
			this.ageRating = ageRating;
		}
		else{
			throw new IllegalArgumentException("Altersfreigabe ungueltig.");
		}
		if(duration <= 0){
			throw new IllegalArgumentException("Parameter ungueltig.");
		}
		this.duration = duration;
	}

	@Override
	public double rabatt() {

		int rabatt = 0;
		if(this.ageRating == 0){
			rabatt = 20;
		}
		else if(this.ageRating == 6){
			rabatt = 15;
		}
		else if(this.ageRating == 12){
			rabatt = 10;
		}
		else if(this.ageRating == 16){
			rabatt = 5;
		}
		return rabatt;
	}

	@Override
	public String toString() {
		return "Typ:        DVD" + "\n" +
				super.toString() 		+ "\n" +
				"Preis:      " + doubleFormat.format(this.preis()).replace(',','.') + "\n" +
				"Dauer:      " + this.duration+ "\n" +
				"Freigabe:   " + this.ageRating;
	}
}