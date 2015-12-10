package f1.app.drivers;

import f1.app.constructor.Constructor;
import f1.app.global.GlobalF1;
import f1.app.statistics.Statistics;
import junit.framework.Assert;
import org.json.simple.parser.ParseException;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by kayipcheung on 28-11-15.
 */
public class DriverStatsTeamTest {
    @Test
    public void testASingleDriver(){
        // Test a single driver
        DriverMutator mutator = new DriverMutator();
        mutator.setDriver(new Driver());
        mutator.getDriver().setDriverId("5");
        mutator.getDriver().setUrl("http:\\/\\/en.wikipedia.org\\/wiki\\/Sebastian_Vettel");
        mutator.getDriver().setGivenName("Sebastian");
        mutator.getDriver().setFamilyName("Vettel");
        mutator.getDriver().setDateOfBirth("Heppenheim, Germany");
        mutator.getDriver().setNationality("Germany");
        mutator.setConstructor(new Constructor());
        mutator.getConstructor().setConstructorId(Constructor.ConstructorId.FERRARI);
        mutator.getDriver().setConstructorInfo(mutator.getConstructor());
        mutator.getDriver().setBuffer(new StringBuffer());

        Assert.assertNotNull(mutator.getDriver());
        Assert.assertEquals(mutator.getDriver().getDriverId(),"5");
        Assert.assertEquals(mutator.getDriver().getUrl(),"http:\\/\\/en.wikipedia.org\\/wiki\\/Sebastian_Vettel");
        Assert.assertEquals(mutator.getDriver().getGivenName(),"Sebastian");
        Assert.assertEquals(mutator.getDriver().getFamilyName(),"Vettel");
        Assert.assertEquals(mutator.getDriver().getDateOfBirth(),"Heppenheim, Germany");
        Assert.assertEquals(mutator.getDriver().getNationality(),"Germany");

        Assert.assertNotNull(mutator.getConstructor());
        Assert.assertEquals(mutator.getConstructor().getConstructorId(),Constructor.ConstructorId.FERRARI);
}

    @Test
    public void testDriversFromUrl() throws IOException, ParseException {
        DriverMutator mutator = new DriverMutator();
        ArrayList<Driver> arrayList = mutator.createDriversFromURL(GlobalF1.FORMULA_ONE_RESOURCES_TESTDIR);
        Assert.assertNotNull(arrayList);
        Assert.assertEquals(22,arrayList.size());
        boolean check = false;
        for(Driver temp: arrayList){
            if(temp.getGivenName().equals("Sebastian") && temp.getFamilyName().equals("Vettel")){
                check = true;
                Assert.assertTrue(check);
            }
        }
    }
}
