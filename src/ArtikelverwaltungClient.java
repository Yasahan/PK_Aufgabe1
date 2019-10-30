import java.io.*;
import java.util.ArrayList;

/**
 * @author Yasahan Zengin
 * Matrikelnummer: 01367563
 */

public class ArtikelverwaltungClient {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Artikelverwaltung control;
        String dataName = args[0];
        File f = new File(dataName);

        if (f.isFile() && f.canRead()) {
            System.out.println("Existing file opening...");
            control = new Artikelverwaltung(dataName);


        } else {
            System.out.println("New File created: " + dataName);
            FileOutputStream fileOut = new FileOutputStream(dataName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            control = new Artikelverwaltung(dataName);
            fileOut.close();
            out.close();
        }

        switch (args[1]) {
            case "add":
                switch(args[2]){
                    case "buch":
                        int id = Integer.parseInt(args[3]);
                        String titel = args[4];
                        String publisher = args[5];
                        int publicationDate = Integer.parseInt(args[6]);
                        double price = Double.parseDouble(args[7]);
                        int pages = Integer.parseInt(args[8]);
                        control.addArtikel(new Buch(id, titel, publisher, publicationDate, price, pages));
                        break;
                    case "dvd":
                         id = Integer.parseInt(args[3]);
                         titel = args[4];
                         publisher = args[5];
                         publicationDate = Integer.parseInt(args[6]);
                         price = Double.parseDouble(args[7]);
                         int duration = Integer.parseInt(args[8]);
                         int ageRating = Integer.parseInt(args[9]);
                        control.addArtikel(new DVD(id, titel, publisher, publicationDate, price, duration, ageRating));
                        break;
                }
                break;
            case "list":
                control.showAllArtikel();
                break;
            case "delete":
                control.deleteArtikel(Integer.parseInt(args[2]));
                break;
            case "count":
                System.out.println(control.artikelAmount());
                break;
            case "meanprice":
                System.out.println(control.averagePrice());
                break;
            case "oldest":
                System.out.println(control.lastAddedArtikel());
                break;

        }
    }
}