import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yasahan Zengin
 * Matrikelnummer: 01367563
 */

public class SerializationArtikelDAO implements ArtikelDAO, Serializable {

    private static List<Artikel> articles;
    private String dataName;

    SerializationArtikelDAO(String name) throws IOException, ClassNotFoundException {
        dataName = name;
        articles = new ArrayList<>();
        loadArticles();
    }

    @SuppressWarnings("unchecked")
    private void loadArticles() throws IOException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream(dataName); ObjectInputStream ois = new ObjectInputStream(fis)) {
            articles = (ArrayList<Artikel>) ois.readObject();
        } catch (IOException e) {
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
    public List<Artikel> getArtikel() {
        if(articles == null){
            throw new IllegalArgumentException("Articles is null!");
        }
        return articles;
    }

    @Override
    public Artikel getArtikel(int id) {
        return articles.stream().filter(artikel -> artikel.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void saveArtikel(Artikel artikel) {
        if (getArtikel(artikel.getId()) != null)
            throw new IllegalArgumentException("Error: Artikel bereits vorhanden. " + "(id=" + artikel.getId() + ">)");
        articles.add(artikel);
        saveArticlesList();
        System.out.println("Info: Artikel " + artikel.getId() + " added.");
    }

    @Override
    public void deleteArtikel(int id) {
        if (getArtikel(id) == null) {
            throw new IllegalArgumentException("Error: Artikel nicht vorhanden. " + "(id=" + id + ">)");
        }
        articles.remove(getArtikel(id));
        saveArticlesList();
        System.out.println("Info: Artikel " +  id +  " deleted.");
    }

    private void saveArticlesList() {
        FileOutputStream fileOut = null;
        ObjectOutputStream out = null;
        try {
            fileOut = new FileOutputStream(dataName);
            out = new ObjectOutputStream(fileOut);
            out.writeObject(articles);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeStream(fileOut);
            closeStream(out);
        }
    }

    private static void closeStream(Closeable c) {
        if (c != null) {
            try {
                c.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}