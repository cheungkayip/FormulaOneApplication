package f1.app.ergast.url;

import org.junit.Test;

import java.io.IOException;

/**
 * Created by kayipcheung on 01-12-15.
 */
public class ErgastTest {
    @Test
    public void testDriversJSON() throws IOException {
        Ergast ergast = new Ergast();
        String output = "\n Drivers Output: \n" +
                ergast.callUrlToGetJSONData("http://ergast.com/api/f1/2015/drivers.json");
        System.out.println(output);
    }

    @Test
    public void testConstructorsJSON() throws IOException {
        Ergast ergast = new Ergast();
        String output = "\n Constructors Output: \n" +
                ergast.callUrlToGetJSONData("http://ergast.com/api/f1/2015/constructors.json");
        System.out.println(output);
    }
}
