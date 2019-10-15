/**
 * @author Yasahan Zengin
 * Matrikelnummer: 01367563
 */

import java.io.IOException;
import java.util.List;

public interface ArtikelDAO {

	List<Artikel> getArtikel();

	Artikel getArtikel(int id);
	
	void saveArtikel(Artikel artikel) throws IOException;

	void deleteArtikel(int id) throws IOException;
}