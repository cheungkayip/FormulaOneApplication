package f1.app.drivers;

import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by kayipcheung on 07-12-15.
 */
public class DriverStandingsTest {

    @Test
    public void testDriversFromUrl() throws IOException, ParseException {
        DriverMutator mutator = new DriverMutator();
        mutator.generateDriverStandings();
    }
}
