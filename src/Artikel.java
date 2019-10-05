import java.io.Serializable;

/**
 * @author <your-name-here>
 * Matrikelnummer:
 */

public abstract class Artikel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int Id;
	private String titel;
    private String publicationDate;
    private String publisher;
    private double price;
	
}
