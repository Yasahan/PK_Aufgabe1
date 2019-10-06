import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Yasahan Zengin
 * Matrikelnummer: 01367563
 */

public abstract class Artikel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int Id;
	private String titel;
    private String publicationDate; // Format: dd/MM/yyyy
    private String publisher;
    private double price;

    public Artikel(int id, String titel, String publicationDate, String publisher, double price) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String currentDate = date.toString();
        Date currDate = format.parse(currentDate);
        Date pubDate = format.parse(publicationDate);

        Id = id;
        this.titel = titel;
        if(pubDate.compareTo(currDate) <= 0)
          this.publicationDate = publicationDate;
        else
            throw new IllegalArgumentException("Publication Date connot be in the future");
        this.publisher = publisher;
        if(price > 0)
            this.price = price;
        else
            throw new IllegalArgumentException("Price connot be negativ");
    }

   public int alter(){
       SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
       Date date = new Date();
       String currentDate = date.toString();

       int currDate = Integer.parseInt(currentDate.substring(6,10));
       int pubDate = Integer.parseInt(this.publicationDate.substring(6,10));

       return currDate-pubDate;
   }

   public abstract double rabatt();

   public void preis(){
        price -= rabatt();
   }


}
