package f1.app.races;

import f1.app.global.GlobalF1;
import junit.framework.Assert;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by kayipcheung on 12-12-15.
 */
public class RaceResultsTest {

    @Test
    public void raceResultsTest() throws IOException, ParseException {
        RaceMutator mutator = new RaceMutator();
        ArrayList<RaceResults> arrayList = mutator.generateRaceResults(GlobalF1.SAVED_JSON_DIR_TEST);
        Assert.assertNotNull(arrayList);
        Assert.assertEquals(378,arrayList.size());
        }
}
