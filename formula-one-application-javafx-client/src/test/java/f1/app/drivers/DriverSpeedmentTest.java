package f1.app.drivers;

import com.company.speedment.test.f1app.db0.f1app.drivers.Drivers;
import com.company.speedment.test.f1app.db0.f1app.imagesdrivers.ImagesDrivers;
import f1.app.mutator.DriverMutator;
import junit.framework.Assert;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * Created by kayipcheung on 28-12-15.
 */
public class DriverSpeedmentTest {
    @Test
    public void testDriversImagesFromDB() throws IOException, ParseException {
        DriverMutator mutator = new DriverMutator();
        List<ImagesDrivers> list = mutator.speedmentDataLoader();
        Assert.assertEquals("1", list.get(0).getDriverImageId().toString());
    }

    @Test
    public void testDriversInfoFromDB() {
        DriverMutator driver = new DriverMutator();
        List<Drivers> list = driver.speedmentDriverLoader();
        Assert.assertEquals("Lewis",list.get(0).getForename());
        Assert.assertEquals("Hamilton",list.get(0).getSurname());
        Assert.assertEquals("hamilton",list.get(0).getDriverRef());
        Assert.assertEquals("http://en.wikipedia.org/wiki/Lewis_Hamilton",list.get(0).getUrl());
//        Assert.assertEquals("British",list.get(0).getNationality());
    }

}
