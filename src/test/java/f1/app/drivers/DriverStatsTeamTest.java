package f1.app.drivers;

import f1.app.statistics.Statistics;
import f1.app.teams.Team;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by kayipcheung on 28-11-15.
 */
public class DriverStatsTeamTest {
    @Test
    public void DriverClassTest(){
        // Test a single driver
        DriverMutator mutator = new DriverMutator();
        mutator.setDriver(new Driver());

        mutator.getDriver().setFirstName("Sebastian");
        mutator.getDriver().setLastName("Vettel");
        mutator.getDriver().setPlaceOfBirth("Heppenheim, Germany");
        mutator.getDriver().setCountry("Germany");

        mutator.setStatistics(new Statistics());
        mutator.getStatistics().setNumberOfPodiums(79);
        mutator.getStatistics().setPoints(1884);
        mutator.getStatistics().setGrandPrixEntered(157);
        mutator.getStatistics().setWorldChampionships(4);
        mutator.getStatistics().setHighestRaceFinish(1);
        mutator.getStatistics().setHighestGridPosition(1);
        mutator.getDriver().setStatisticsInfo(mutator.getStatistics());

        mutator.setTeam(new Team());
        mutator.getTeam().setTeamName(Team.TeamName.FERRARI);
        mutator.getDriver().setTeamInfo(mutator.getTeam());
        mutator.getDriver().setBuffer(new StringBuffer());
        System.out.println(mutator.getDriver().toString(mutator.getDriver()));
}

    @Test
    public void getDriversFromJSONFile(){
        // Test multiple drivers added to ArrayList + Read From JSON
        DriverMutator mutator = new DriverMutator();
        mutator.createTheDrivers();
        mutator.getDriver().setBuffer(new StringBuffer());
        System.out.println("Results from the Object: \n" + mutator.getDriver().toString(mutator.getDriver()));
        System.out.println("Results from the ArrayList: \n");

        for(Driver list :mutator.getDriverList())
            if(list instanceof Driver) {
                System.out.println(list);

            }

    }

}
