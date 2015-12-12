package f1.app.constructors;

import f1.app.constructor.Constructor;
import f1.app.constructor.ConstructorMutator;
import f1.app.drivers.DriverMutator;
import f1.app.drivers.DriverStandings;
import junit.framework.Assert;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by kayipcheung on 04-12-15.
 */
public class ConstructorTest {
    @Test
    public void testConstructorInformation() throws IOException, ParseException {
        ConstructorMutator mutator = new ConstructorMutator();
        ArrayList<Constructor> arrayList = mutator.getAllTheConstructorInformation("src/main/resources/");
        mutator.getConstructor().setBuffer(new StringBuffer());
        Assert.assertNotNull(arrayList);
        Assert.assertEquals(11,arrayList.size());
        boolean check = false;
        boolean check2 = false;
        boolean check3 = false;
        for(Constructor temp: arrayList){
            if(temp.getConstructorName().equals("FERRARI") && temp.getNationality().equals("Italian")){
                check = true;
            }
            if(temp.getConstructorName().equals("MERCEDES") && temp.getNationality().equals("German")){
                check2 = true;
            }
            if(temp.getConstructorName().equals("TORO ROSSO") && temp.getNationality().equals("Italian")){
                check3 = true;
            }
        }
        Assert.assertTrue(check);
        Assert.assertTrue(check2);
        Assert.assertTrue(check3);
    }

}
