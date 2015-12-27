package f1.app.drivers;

import f1.app.mutator.DriverMutator;
import f1.app.pojo.DriverStandings;
import junit.framework.Assert;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by kayipcheung on 07-12-15.
 */
public class DriverStandingsTest {

    @Test
    public void testDriversFromUrl() throws IOException, ParseException {
        DriverMutator mutator = new DriverMutator();
        ArrayList<DriverStandings> arrayList = mutator.generateDriverStandings();
        Assert.assertNotNull(arrayList);
        Assert.assertEquals(22,arrayList.size());
        boolean check = false;
        boolean check2 = false;
        for(DriverStandings temp: arrayList){
            mutator.getDriverStandings().setBuffer(new StringBuffer());
            if(temp.getDriver().equals("Sebastian Vettel") && temp.getConstructor().equals("Ferrari")){
                check = true;

            }
            if(temp.getDriver().equals("Max Verstappen") && temp.getConstructor().equals("Toro Rosso")){
                check2 = true;
            }
        }
        Assert.assertTrue(check);
        Assert.assertTrue(check2);
    }
}
