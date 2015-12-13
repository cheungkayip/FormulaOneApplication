package f1.app.races;

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
        ArrayList<RaceResults> arrayList = mutator.generateRaceResults();
        Assert.assertNotNull(arrayList);
        Assert.assertEquals(378,arrayList.size());
        arrayList.forEach(item->System.out.println(item.getFinishingPosition() + " " + item.getGivenName() + " " + item.getFamilyName() + " " + item.getCircuitName() + " " + item.getCountry()));
    }
}
