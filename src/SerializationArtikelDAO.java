import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yasahan Zengin
 * Matrikelnummer: 01367563
 */

public class SerializationArtikelDAO implements ArtikelDAO, Serializable {

    @Override
    public List<Artikel> getArtikel() throws IOException, ClassNotFoundException {

        List tmp = new ArrayList();
        FileInputStream fis = new FileInputStream("Artikel.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        tmp = (ArrayList) ois.readObject();
        fis.close();
        ois.close();

        return tmp;
    }

    @Override
    public Artikel getArtikel(int id) throws IOException, ClassNotFoundException {
        List<Artikel> tmp = this.getArtikel();
        for(Artikel art : tmp)
            if(art.getId() == id)
                return art;
        return null;
    }

    @Override
    public void saveArtikel(Artikel artikel) throws IOException, ClassNotFoundException {

        FileOutputStream fileOut = new FileOutputStream("Artikel.txt");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);

        if(getArtikel(artikel.getId()) != null)
            throw new IllegalArgumentException("Error: Artikel bereits vorhanden. " + "(id="+ artikel.getId() + ">)");

        out.writeObject(artikel);
        out.close();
    }

    @Override
    public void deleteArtikel(int id) throws IOException, ClassNotFoundException {

        List<Artikel> tmp = this.getArtikel();
        if(getArtikel(id) == null)
            throw new IllegalArgumentException("Error: Artikel nicht vorhanden. " + "(id="+ id + ">)");
        else
            {
            tmp.remove(getArtikel(id));
            FileOutputStream fileOut = new FileOutputStream("Artikel.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(tmp);
            out.close();
        }
    }
}