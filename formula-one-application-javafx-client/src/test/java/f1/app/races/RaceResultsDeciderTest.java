package f1.app.races;

import f1.app.global.GlobalF1;
import f1.app.mutator.RaceMutator;
import f1.app.pojo.RaceResults;
import junit.framework.Assert;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * Created by kayipcheung on 18-12-15.
 */
public class RaceResultsDeciderTest {
    @Test
    public void RaceDeciderTest() throws IOException, ParseException {
        RaceMutator mutator = new RaceMutator();
        ArrayList<RaceResults> arrayList = mutator.generateRaceResults(GlobalF1.SAVED_JSON_DIR_TEST);
        arrayList.stream().forEach(item -> {
            int theRound = item.getRound();
            ArrayList<RaceResults> result = mutator.decideWhichRaceIsDisplayed(arrayList,theRound);

            Assert.assertNotNull(arrayList);
            Assert.assertNotNull(result);
            Assert.assertEquals(378,arrayList.size());
            if(theRound == 0) {
                Stream<RaceResults> albertPark = result.stream().filter(circuitName -> circuitName.getCircuitName().equals("Albert Park Grand Prix Circuit"));
                Assert.assertEquals("Lewis", albertPark.findFirst().get().getGivenName());
                Assert.assertEquals("Hamilton", albertPark.findFirst().get().getGivenName());
                Assert.assertEquals("1", albertPark.findAny().get().getFinishingPosition());
                Assert.assertEquals("Nico", albertPark.findFirst().get().getGivenName());
                Assert.assertEquals("Rosberg", albertPark.findFirst().get().getGivenName());
                Assert.assertEquals("2", albertPark.findFirst().get().getFinishingPosition());
            }
        });

    }
}
