package f1.app.drivers;

import f1.app.drivers.Driver;
import f1.app.drivers.DriverMutator;
import f1.app.statistics.Statistics;
import f1.app.teams.Team;
import org.junit.Test;

/**
 * Created by kayipcheung on 28-11-15.
 */
public class DriverStatsTeamTest {
    @Test
    public void DriverClassTest(){
        Driver driver = new Driver();
        driver.setFirstName("Sebastian");
        driver.setLastName("Vettel");
        driver.setPlaceOfBirth("Heppenheim, Germany");
        driver.setCountry("Germany");

        Statistics statisticsInfo = new Statistics();
        statisticsInfo.setNumberOfPodiums(79);
        statisticsInfo.setPoints(1884);
        statisticsInfo.setGrandPrixEntered(157);
        statisticsInfo.setWorldChampionships(4);
        statisticsInfo.setHighestRaceFinish(1);
        statisticsInfo.setHighestGridPosition(1);
        driver.setStatisticsInfo(statisticsInfo);

        Team team = new Team(Team.TeamName.FERRARI);

//        team.setTeamLogo("ScuderiaFerrari.png");
        driver.setTeamInfo(team);

        System.out.println(driver.toString(driver));
}

}
