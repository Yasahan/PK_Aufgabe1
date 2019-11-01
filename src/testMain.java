import java.io.*;
import java.util.ArrayList;

public class testMain {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Artikelverwaltung control;
        String dataName = "Artikel.txt";
        File f = new File(dataName);

        int id;
        String titel;
        String publisher;
        int publicationDate;
        double price;
        int pages;
        int duration;
        int ageRating;

        if (f.isFile() && f.canRead()) {
            control = new Artikelverwaltung(dataName);
        }
        else {
            FileOutputStream fileOut = new FileOutputStream(dataName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(new ArrayList<Artikel>());
            control = new Artikelverwaltung(dataName);
            fileOut.close();
            out.close();
        }

        // test case add
/*        id = 1008; titel = "Kartoffel 1"; publisher = "GmbH 1"; publicationDate = 2012; price = 16.99; pages = 799;
        control.addArtikel(new Buch(id, titel, publisher, publicationDate, price, pages));
        id = 1004; titel = "Kartoffel 2"; publisher = "GmbH 2"; publicationDate = 2013; price = 11.99; pages = 899;
        control.addArtikel(new Buch(id, titel, publisher, publicationDate, price, pages));
        id = 1005; titel = "Kartoffel 2"; publisher = "GmbH 2"; publicationDate = 2012; price = 13.99; duration = 120; ageRating = 16;
        control.addArtikel(new DVD(id, titel, publisher, publicationDate, price, duration, ageRating));*/

        // test case read list
        control.showAllArtikel();

        // test case read an article
        control.showArtikel(1002);

        // test case average price
        control.averagePrice();

        // test case article amount
        control.artikelAmount();

        // test case delete
        control.deleteArtikel(1003);

        // test case last addes
        control.lastAddedArtikel();



    }
}
