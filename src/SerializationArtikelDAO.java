import java.io.*;
import java.util.ArrayList;

/**
 * @author Yasahan Zengin
 * Matrikelnummer: 01367563
 */

public class SerializationArtikelDAO implements ArtikelDAO, Serializable {

    private static ArrayList<Artikel> artikels;
    private String dataName;


    SerializationArtikelDAO(String name) throws IOException, ClassNotFoundException {
        dataName = name;
        artikels = new ArrayList<Artikel>();
        setArtikel();
    }

    @SuppressWarnings("unchecked")
    private void setArtikel() throws IOException, ClassNotFoundException {
        try{
            FileInputStream fis = new FileInputStream(dataName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            artikels = (ArrayList<Artikel>) ois.readObject();
            fis.close();
            ois.close();
        }catch (IOException e) {
            e.getMessage();
        }
    }

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }

    @Override
    public ArrayList<Artikel> getArtikel() {
        return artikels;
    }

    @Override
    public Artikel getArtikel(int id) {

        if(artikels != null){
            for(Artikel art : artikels)
                if(art.getId() == id)
                    return art;
        }
        return null;
    }

    @Override
    public void saveArtikel(Artikel artikel)  {

        if(getArtikel(artikel.getId()) != null)
            throw new IllegalArgumentException("Error: Artikel bereits vorhanden. " + "(id="+ artikel.getId() + ">)");
        try{
            FileOutputStream fileOut = new FileOutputStream(dataName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            artikels.add(artikel);
            out.writeObject(artikels);
            System.out.println("Info: Artikel " + artikel.getId() +  " added.");
            fileOut.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteArtikel(int id) {

        if(getArtikel(id) == null){
            throw new IllegalArgumentException("Error: Artikel nicht vorhanden. " + "(id="+ id + ">)");
        }
        else {
            artikels.remove(getArtikel(id));
            try{
                FileOutputStream fileOut = new FileOutputStream(dataName);
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(artikels);
                fileOut.close();
                out.close();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Product: " + id + " deleted!");
    }
}