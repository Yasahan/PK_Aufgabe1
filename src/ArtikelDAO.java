/**
 * @author Yasahan Zengin
 * Matrikelnummer: 01367563
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface ArtikelDAO {

	List<Artikel> getArtikel() throws IOException, ClassNotFoundException;

	Artikel getArtikel(int id) throws IOException, ClassNotFoundException;
	
	void saveArtikel(Artikel artikel) throws IOException, ClassNotFoundException;

	void deleteArtikel(int id) throws IOException, ClassNotFoundException;
}