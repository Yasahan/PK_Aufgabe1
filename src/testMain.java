import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


public class testMain {

    public static void main(String[] args) throws ParseException, IOException, ClassNotFoundException {

        Buch b = new Buch(1001, "Ein ganzes Leben", 2014, "Hanser", 17.99, 1255);
        Buch b1 = new Buch(1002, "Fortnite", 2014, "Epic Games", 11.28, 288);
        Buch b2 = new Buch(1003, "Pubg", 2014, "IDK", 11.98, 65);
        Buch b3 = new Buch(1004, "Ein Apex", 2014, "EA", 17.99, 767);
        Buch b4 = new Buch(1005, "1en", 2014, "Greta", 21.88, 123);

        Artikelverwaltung control = new Artikelverwaltung();
        control.addArtikel(b);
        control.addArtikel(b2);
        control.addArtikel(b4);
        control.addArtikel(b3);
        control.showAllArtikel();
        control.showArtikel(1001);
        System.out.println("Last added Artikel ID: " + control.lastAddedArtikel());

    }
}
