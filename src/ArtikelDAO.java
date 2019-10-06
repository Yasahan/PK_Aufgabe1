/**
 * @author <your-name-here>
 * Matrikelnummer:
 */

import java.util.List;

public interface ArtikelDAO {

	List<Artikel> getArtikel();

	Artikel getArtikel(int id);
	
	void saveArtikel(Artikel artikel);

	void deleteArtikel(int id);
}