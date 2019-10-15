import java.io.Serializable;
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
    private int publicationDate; // Format: dd/MM/yyyy
    private String publisher;
    private double price;

    int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public int getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(int publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    Artikel(int id, String titel, int publicationDate, String publisher, double price) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        Date date = new Date();
        String currDate = format.format(date);
        int intCurrDate = Integer.parseInt(currDate);
        Id = id;
        this.titel = titel;
        if(publicationDate <= intCurrDate)
          this.publicationDate = publicationDate;
        else
            throw new IllegalArgumentException("Error: Erscheinungsjahr ungueltig.");
        this.publisher = publisher;
        if(price >= 0)
            this.price = price;
        else
            throw new IllegalArgumentException("Price connot be negativ");
    }

   int alter(){
       SimpleDateFormat format = new SimpleDateFormat("yyyy");
       Date date = new Date();
       String currDate = format.format(date);
       int currentDate = Integer.parseInt(currDate);
       return currentDate-publicationDate;
   }

   protected abstract double rabatt();

   double preis(){
        return price - rabatt();
   }

    @Override
    public String toString() {
        return  "Id:            " + Id + "\n" +
                "Titel:         " + titel + "\n" +
                "Jahr:          " + publicationDate + "\n" +
                "Verlag:        " + publisher + "\n" +
                "Grundpreis:    " + price;
    }
}
