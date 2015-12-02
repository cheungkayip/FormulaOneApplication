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

        mutator.getDriver().setGivenName("Sebastian");
        mutator.getDriver().setFamilyName("Vettel");
        mutator.getDriver().setPlaceOfBirth("Heppenheim, Germany");
        mutator.getDriver().setNationality("Germany");

        mutator.setStatistics(new Statistics());
        mutator.getStatistics().setNumberOfPodiums(79);
        mutator.getStatistics().setPoints(1884);
        mutator.getStatistics().setGrandPrixEntered(157);
        mutator.getStatistics().setWorldChampionships(4);
        mutator.getStatistics().setHighestRaceFinish(1);
        mutator.getStatistics().setHighestGridPosition(1);
        mutator.getDriver().setStatisticsInfo(mutator.getStatistics());

        mutator.setConstructor(new Constructor());
        mutator.getConstructor().setConstructorId(Constructor.ConstructorId.FERRARI);
        mutator.getDriver().setConstructorInfo(mutator.getConstructor());
        mutator.getDriver().setBuffer(new StringBuffer());
        System.out.println(mutator.getDriver().toString(mutator.getDriver()));
}

    @Test
    public void testDriversFromJSONFile(){
        // Test multiple drivers added to ArrayList + Read From JSON
        DriverMutator mutator = new DriverMutator();
        mutator.createDriversFromJSONFile();
        mutator.getDriver().setBuffer(new StringBuffer());
        System.out.println("Results from the Object: \n" + mutator.getDriver().toString(mutator.getDriver()));
        System.out.println("Results from the ArrayList: \n");

        for(Driver list :mutator.getDriverList())
            if(list instanceof Driver) {
                System.out.println(list);
            }
    }

    @Test
    public void testDriversFromUrl() throws IOException, ParseException {
        DriverMutator mutator = new DriverMutator();
        mutator.createDriversFromURL();
        mutator.getDriver().setBuffer(new StringBuffer());
        System.out.println("Results from the Object: \n" + mutator.getDriver().toString(mutator.getDriver()));
    }

}
