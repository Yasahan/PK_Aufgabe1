import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yasahan Zengin
 * Matrikelnummer: 01367563
 */

public class SerializationArtikelDAO implements ArtikelDAO, Serializable {

    private static ArrayList<Artikel> artikels;

    public SerializationArtikelDAO() {
        this.artikels = new ArrayList<Artikel>();
    }

    @Override
    public ArrayList<Artikel> getArtikel() throws IOException, ClassNotFoundException {
        return artikels;
    }

    @Override
    public Artikel getArtikel(int id) throws IOException, ClassNotFoundException {

        for(Artikel art : artikels)
            if(art.getId() == id)
                return art;
        return null;
    }

    @Override
    public void saveArtikel(Artikel artikel) throws IOException, ClassNotFoundException {

        if(getArtikel(artikel.getId()) != null)
            throw new IllegalArgumentException("Error: Artikel bereits vorhanden. " + "(id="+ artikel.getId() + ">)");
        FileOutputStream fileOut = new FileOutputStream("Artikel.txt");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        artikels.add(artikel);
        out.writeObject(artikels);
        out.close();
    }

    @Override
    public void deleteArtikel(int id) throws IOException, ClassNotFoundException {

        if(getArtikel(id) == null)
            throw new IllegalArgumentException("Error: Artikel nicht vorhanden. " + "(id="+ id + ">)");
        else
            {
            artikels.remove(getArtikel(id));
            FileOutputStream fileOut = new FileOutputStream("Artikel.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(artikels);
            out.close();
        }
    }
}