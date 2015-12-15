package f1.app.drivers;

import f1.app.constructor.Constructor;
import f1.app.global.GlobalF1;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import junit.framework.Assert;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by kayipcheung on 28-11-15.
 */
public class DriverTest {
    @Test
    public void testASingleDriver() throws IOException {
        // Test a single driver
        DriverMutator mutator = new DriverMutator();
        mutator.setDriver(new Driver());
        mutator.getDriver().setCode("VET");
        mutator.getDriver().setDriverId("5");
        mutator.getDriver().setUrl("http:\\/\\/en.wikipedia.org\\/wiki\\/Sebastian_Vettel");
        mutator.getDriver().setGivenName("Sebastian");
        mutator.getDriver().setFamilyName("Vettel");
        mutator.getDriver().setDateOfBirth("Heppenheim, Germany");
        mutator.getDriver().setNationality("Germany");

        GlobalF1 global = new GlobalF1();
        String helmet = "Helmet_SebastianVettel.png";
        String driverImage = "SebastianVettel.jpg";
        String flagImage = "Flag_Germany.jpg";
        ImageView image1 = mutator.getDriver().setDriverHelmet(global.setTheImage("src/main/resources/Helmets/" + helmet));
        ImageView image2 = mutator.getDriver().setDriverFlag(global.setTheImage("src/main/resources/Flags/" + flagImage));
        ImageView image3 = mutator.getDriver().setDriverImage(global.setTheImage("src/main/resources/Drivers/" + driverImage));

        mutator.setConstructor(new Constructor());
        mutator.getConstructor().setConstructorId(Constructor.ConstructorId.FERRARI);
        mutator.getDriver().setConstructorInfo(mutator.getConstructor());
        mutator.getDriver().setBuffer(new StringBuffer());
        System.out.println(mutator.getDriver().getBuffer());
        Assert.assertNotNull(mutator.getDriver());
        Assert.assertEquals(mutator.getDriver().getCode(),"VET");
        Assert.assertEquals(mutator.getDriver().getDriverId(),"5");
        Assert.assertEquals(mutator.getDriver().getUrl(),"http:\\/\\/en.wikipedia.org\\/wiki\\/Sebastian_Vettel");
        Assert.assertEquals(mutator.getDriver().getGivenName(),"Sebastian");
        Assert.assertEquals(mutator.getDriver().getFamilyName(),"Vettel");
        Assert.assertEquals(mutator.getDriver().getDateOfBirth(),"Heppenheim, Germany");
        Assert.assertEquals(mutator.getDriver().getNationality(),"Germany");
        Assert.assertEquals(mutator.getDriver().getDriverHelmet(),image1);
        Assert.assertEquals(mutator.getDriver().getDriverFlag(),image2);
        Assert.assertEquals(mutator.getDriver().getDriverImage(),image3);

        Assert.assertNotNull(mutator.getConstructor());
        Assert.assertEquals(mutator.getConstructor().getConstructorId(),Constructor.ConstructorId.FERRARI);
}

    @Test
    public void testDriversFromUrl() throws IOException, ParseException {
        DriverMutator mutator = new DriverMutator();
        ArrayList<Driver> arrayList = mutator.createDriversFromURL(GlobalF1.SAVED_JSON_DIR_TEST);
        Assert.assertNotNull(arrayList);
        Assert.assertEquals(22,arrayList.size());
        boolean check = false;
        for(Driver temp: arrayList){
            mutator.getDriver().setBuffer(new StringBuffer());
            mutator.getDriver().toString(temp);
            if(temp.getGivenName().equals("Sebastian") && temp.getFamilyName().equals("Vettel")){
                check = true;
                Assert.assertTrue(check);
            }
        }
    }
}
