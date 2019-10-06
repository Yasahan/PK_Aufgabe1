import java.io.Serializable;

/**
 * @author Yasahan Zengin
 * Matrikelnummer: 01367563
 */

public abstract class Artikel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int Id;
	private String titel;
    private String publicationDate;
    private String publisher;
    private double price;
    private String test;
	
}
