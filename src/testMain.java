import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class testMain {

    public static void main(String[] args) throws ParseException {

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        String strDate1 = "07/12/1993";
        String strDate2 = "08/12/1993";

        Date date1 = formatter.parse(strDate1);
        Date date2 = formatter.parse(strDate2);

        if(date1.compareTo(date2) <= 0){
            System.out.println("Date1 is older than date2");
        }






    }


}
