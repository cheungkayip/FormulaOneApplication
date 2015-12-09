package f1.app.drivers;

import f1.app.constructor.Constructor;
import f1.app.statistics.Statistics;
import org.json.simple.parser.ParseException;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

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
        System.out.println(mutator.getDriver().toString(mutator.getDriver()));
}

    @Test
    public void testDriversFromUrl() throws IOException, ParseException {
        DriverMutator mutator = new DriverMutator();
        mutator.createDriversFromURL();
//        mutator.getDriver().setBuffer(new StringBuffer());
//        System.out.println("Results from the Object: \n" + mutator.getDriver().toString(mutator.getDriver()));
    }

}
