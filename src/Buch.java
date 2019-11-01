import java.text.DecimalFormat;

/**
 * @author Yasahan Zengin
 * Matrikelnummer: 01367563
 */

public class Buch extends Artikel {
	private static final DecimalFormat doubleFormat = new DecimalFormat(".00");
	private static final long serialVersionUID = 1L;
	private int pages;

	Buch(int id, String titel, String publisher, int publicationDate,  double price, int pages) {
		super(id, titel, publicationDate, publisher, price);
		if(pages <= 0){
			throw new IllegalArgumentException("Parameter ungueltig.");
		}
		this.pages = pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}
	public int getPages() {
		return pages;
	}


	@Override
	public double rabatt() {

		double rabatt = 0;
		int alter = this.alter();

		if(alter > 0 && alter <= 6){
			rabatt = alter*5;
		}
		if(alter > 6){
			rabatt = 30;
		}
		if(this.pages > 1000){
			rabatt += 3;
		}
		return rabatt;
	}

	@Override
	public String toString() {
		return "Typ:        Buch" + "\n" +
				super.toString() 		+ "\n" +
				"Preis:      " + doubleFormat.format(this.preis()).replace(',','.') + "\n" +
				"Seiten:     " + this.pages;
	}
}