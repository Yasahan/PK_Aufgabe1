import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

/**
 * @author Yasahan Zengin
 * Matrikelnummer: 01367563
 */

public class Artikelverwaltung {
	private final ArtikelDAO control;
    private static final DecimalFormat doubleFormat = new DecimalFormat(".00");


	Artikelverwaltung(String name) throws IOException, ClassNotFoundException {
		control = new SerializationArtikelDAO(name);
	}

	void showArtikel(int id) throws IOException, ClassNotFoundException {
		System.out.println(control.getArtikel(id));
	}

	void showAllArtikel() throws IOException, ClassNotFoundException {

		if(control.getArtikel() == null){
			return;
		}
		for(Artikel art : control.getArtikel())
			System.out.println(art + "\n");
	}
	void addArtikel(Artikel art) throws IOException, ClassNotFoundException {
		control.saveArtikel(art);
	}
	void deleteArtikel(int id) throws IOException, ClassNotFoundException {
		control.deleteArtikel(id);
	}
	int artikelAmount() throws IOException, ClassNotFoundException {
		if(control.getArtikel() == null){
			return 0;
		}else{
			return control.getArtikel().size();
		}
	}
	String averagePrice() throws IOException, ClassNotFoundException {

		List<Artikel> tmp = control.getArtikel();

		if(control.getArtikel().size() == 0){
			return "0.00";
		}
		else{
			double count = 0;
			for(Artikel art : tmp){
				count += art.preis();
			}
			return doubleFormat.format(count/tmp.size());
		}
	}
	void lastAddedArtikel() throws IOException, ClassNotFoundException {
		if(control.getArtikel().size() != 0){
			System.out.println(control.getArtikel().get(control.getArtikel().size() - 1).getId());
		}
	}
}