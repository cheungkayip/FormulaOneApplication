package f1.app.constructors;

import f1.app.constructor.ConstructorMutator;
import f1.app.constructor.ConstructorStandings;
import junit.framework.Assert;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by kayipcheung on 12-12-15.
 */
public class ConstructorStandingsTest {

    @Test
    public void testConstructorStandings() throws IOException, ParseException {
        ConstructorMutator mutator = new ConstructorMutator();
        ArrayList<ConstructorStandings> arrayList = mutator.displayConstructorStandings();
        Assert.assertNotNull(arrayList);
        Assert.assertEquals(11,arrayList.size());
        boolean check = false;
        boolean check2 = false;
        boolean check3 = false;
        for(ConstructorStandings temp: arrayList){
            if(temp.getConstructorName().equals("Mercedes") && temp.getPosition().equals("1") && temp.getPoints().equals("703") && temp.getWins().equals("16")){
                check = true;
            }
            if(temp.getConstructorName().equals("Ferrari") && temp.getPosition().equals("2")){
                check2 = true;
            }
            if(temp.getConstructorName().equals("Williams") && temp.getPosition().equals("3")){
                check3 = true;
            }
        }
        Assert.assertTrue(check);
        Assert.assertTrue(check2);
        Assert.assertTrue(check3);
    }
}
