package f1.app.ergast.url;

import org.junit.Test;

import java.io.IOException;

/**
 * Created by kayipcheung on 01-12-15.
 */
public class ErgastTest {
    @Test
    public void testGetJSONDrivers() throws IOException {
        Ergast ergast = new Ergast();
        String output = "\nOutput: \n" + ergast.callUrlToGetJSONData("http://ergast.com/api/f1/2015/drivers.json?callback=myParser");
        System.out.println(output);
    }

    @Test
    public void testGetJSONandPutInObjects(){

    }
}
