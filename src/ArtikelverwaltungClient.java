import java.io.*;

/**
 * @author Yasahan Zengin
 * Matrikelnummer: 01367563
 */

public class ArtikelverwaltungClient {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Artikelverwaltung control = null;
        String dataName = args[0];
        File f = new File(dataName);

        if(f.isFile() && f.canRead()){
            System.out.println("File opening...");
            control = new Artikelverwaltung(dataName);
        }
        else
        {
            control = new Artikelverwaltung(dataName);
            FileOutputStream fileOut = new FileOutputStream(dataName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            fileOut.close();
            out.close();
        }

        if(args[1].equals("add")){
            if(args[2].equals("buch")){
                control.addArtikel(new Buch(Integer.parseInt(args[3]), args[4], Integer.parseInt(args[5]), args[6], Double.parseDouble(args[7]), Integer.parseInt(args[8])));
            }
            if(args[2].equals("dvd")){

            }
        }
        if(args[1].equals("list")){
            control.showAllArtikel();
        }
        if(args[1].equals("delete")){
            control.deleteArtikel(Integer.parseInt(args[2]));
        }
        if(args[1].equals("count")){
            System.out.println(control.artikelAmount());
        }
        if(args[1].equals("meanprice")){
            //TODO
        }
        if(args[1].equals("oldest")){
            //TODO
        }
    }
}