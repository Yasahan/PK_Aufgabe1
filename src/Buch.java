import java.text.ParseException;
import java.util.Date;

/**
 * @author <your-name-here>
 * Matrikelnummer:
 */

public class Buch extends Artikel {

	private static final long serialVersionUID = 1L;


	public Buch(int id, String titel, String publicationDate, String publisher, double price) throws ParseException {
		super(id, titel, publicationDate, publisher, price);
	}

	@Override
	public double rabatt() {
		return 0;
	}
}