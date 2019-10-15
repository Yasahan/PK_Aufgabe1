import java.io.*;

public class testMain {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // Test Objects
        Buch b = new Buch(1001, "Ein ganzes Leben", 2014, "Hanser", 17.99, 1255);
        Buch b1 = new Buch(1002, "Fortnite", 2016, "Epic Games", 11.28, 288);
        Buch b2 = new Buch(1003, "Pubg", 2015, "IDK", 11.98, 65);
        Buch b3 = new Buch(1004, "Ein Apex", 2011, "EA", 17.99, 767);
        Buch b4 = new Buch(1005, "1en", 2010, "Greta", 21.88, 123);
        DVD d = new DVD (1006, "Herr der Ringe", 2012, "New Line Cinema", 15.99, 12,180);
        DVD d1 = new DVD (1007, "Matrix", 2005, "Paradise", 15.99, 0,163);
        DVD d2 = new DVD (1008, "Hellboy", 2009, "Pixar", 15.99, 6,120);
        DVD d3 = new DVD (1009, "The Godfather", 1972, "Cinema Italia", 25.99, 18,180);
        Artikelverwaltung control = new Artikelverwaltung();
        // Test Case: Add Products
        control.addArtikel(b);
        control.addArtikel(b2);
        control.addArtikel(b4);
        control.addArtikel(b3);
        control.addArtikel(b1);
        control.addArtikel(d);
        control.addArtikel(d1);
        control.addArtikel(d2);
        control.addArtikel(d3);
        //control.addArtikel(b4); -> Test Case: Same Product
        // Test Case: Delete Product
        control.deleteArtikel(1008);
        // Test Case: Show all products
        control.showAllArtikel();
        // Test Case: Show a products with ID
        control.showArtikel(1001);
        // Test Case: Show last added product
        System.out.println("Last added Artikel ID: " + control.lastAddedArtikel());
        // Test Case: Amount of all products
        System.out.println(control.artikelAmount());

    }
}
