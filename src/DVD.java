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

	public DVD(int id, String titel, int publicationDate, String publisher, double price, int ageRating, int duration) {
		super(id, titel, publicationDate, publisher, price);
		if(ageRating == 0 || ageRating == 6 ||ageRating == 12 ||ageRating == 16 ||ageRating == 18){
			this.ageRating = ageRating;
		}
		else{
			throw new IllegalArgumentException("Error: Altersfreigabe ungueltig.");
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
		return (double)rabatt/100;
	}

	@Override
	public String toString() {
		return "Typ:           DVD" + "\n" +
				super.toString() 		+ "\n" +
				"Preis:         " + doubleFormat.format(this.preis()).replace(',','.') + "\n" +
				"Dauer:         " + this.duration+ "\n" +
				"Freigabe:       " + this.ageRating;
	}
}