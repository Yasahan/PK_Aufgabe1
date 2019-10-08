import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


public class testMain {

    public static void main(String[] args) throws ParseException {

        Buch b = new Buch(1001, "Ein ganzes Leben", 2014, "Hanser", 17.99, 767);
        Buch b1 = new Buch(1002, "Ein ganzes Leben", 2014, "Hanser", 17.99, 767);
        Buch b2 = new Buch(1003, "Ein ganzes Leben", 2014, "Hanser", 17.99, 767);
        Buch b3 = new Buch(1004, "Ein ganzes Leben", 2014, "Hanser", 17.99, 767);
        Buch b4 = new Buch(1005, "Ein ganzes Leben", 2014, "Hanser", 17.99, 767);

        List tmp = new ArrayList<Artikel>();
        tmp.add(b);
        tmp.add(b1);
        tmp.add(b2);
        tmp.add(b3);
        tmp.add(b4);








    }
}
