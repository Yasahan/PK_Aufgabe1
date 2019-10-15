import java.io.IOException;
import java.util.List;

/**
 * @author Yasahan Zengin
 * Matrikelnummer: 01367563
 */
 
public class Artikelverwaltung {
	private final ArtikelDAO control;

    Artikelverwaltung() {
		control = new SerializationArtikelDAO();
    }

    void showArtikel(int id) throws IOException, ClassNotFoundException {
		System.out.println(control.getArtikel(id));
	}

	void showAllArtikel() throws IOException, ClassNotFoundException {
		for(Artikel art : control.getArtikel())
			System.out.println(art + "\n");
	}
	void addArtikel(Artikel art) throws IOException, ClassNotFoundException {
		control.saveArtikel(art);
	}
	public void deleteArtikel(int id) throws IOException, ClassNotFoundException {
		control.deleteArtikel(id);
	}
	public int artikelAmount() throws IOException, ClassNotFoundException {
		List<Artikel> tmp = control.getArtikel();
		return tmp.size();
	}
	public double averagePrice() throws IOException, ClassNotFoundException {
		List<Artikel> tmp = control.getArtikel();
		double count = 0;
		for(Artikel art : tmp){
			count += art.getPrice();
		}
		return count/tmp.size();
	}
	int lastAddedArtikel() throws IOException, ClassNotFoundException {
    	return control.getArtikel().get(control.getArtikel().size()-1).getId();
	}




}