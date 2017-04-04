package bootstrap;

import utils.deansoffice.DeansOffice;
import utils.deansoffice.DeansOfficeVeryKindLady;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by Karol Pokomeda on 2017-03-29.
 */
public class ListThreeExThreeTest {
    public static void main(String[] args){
        SimpleDateFormat parser = new SimpleDateFormat("HH:mm:ss");

        DeansOfficeVeryKindLady employeeA = new DeansOfficeVeryKindLady("Renata");
        DeansOfficeVeryKindLady employeeB = new DeansOfficeVeryKindLady("Katarzyna");
        DeansOfficeVeryKindLady employeeC = new DeansOfficeVeryKindLady("Marlena");

        try {
            DeansOffice deansOffice = new DeansOffice(parser.parse("11:00:00"), parser.parse("15:00:00"));
            deansOffice.addEmployee(employeeA);
            deansOffice.addEmployee(employeeB);
            deansOffice.addEmployee(employeeC);
            deansOffice.openDeansOffice();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
