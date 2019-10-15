import java.io.*;
import java.util.ArrayList;

/**
 * @author Yasahan Zengin
 * Matrikelnummer: 01367563
 */

public class SerializationArtikelDAO implements ArtikelDAO, Serializable {

    private static ArrayList<Artikel> artikels;

    SerializationArtikelDAO() {
        artikels = new ArrayList<>();
    }

    @Override
    public ArrayList<Artikel> getArtikel() {
        return artikels;
    }

    @Override
    public Artikel getArtikel(int id) {

        for(Artikel art : artikels)
            if(art.getId() == id)
                return art;
        return null;
    }

    @Override
    public void saveArtikel(Artikel artikel) throws IOException {

        if(getArtikel(artikel.getId()) != null)
            throw new IllegalArgumentException("Error: Artikel bereits vorhanden. " + "(id="+ artikel.getId() + ">)");
        FileOutputStream fileOut = new FileOutputStream("Artikel.txt");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        artikels.add(artikel);
        out.writeObject(artikels);
        fileOut.close();
        out.close();
    }

    @Override
    public void deleteArtikel(int id) throws IOException {

        if(getArtikel(id) == null)
            throw new IllegalArgumentException("Error: Artikel nicht vorhanden. " + "(id="+ id + ">)");
        else
            {
            artikels.remove(getArtikel(id));
            FileOutputStream fileOut = new FileOutputStream("Artikel.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(artikels);
            fileOut.close();
            out.close();
        }
    }
}