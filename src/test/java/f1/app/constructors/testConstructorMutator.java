package f1.app.constructors;

import f1.app.constructor.ConstructorMutator;
import f1.app.drivers.DriverMutator;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by kayipcheung on 04-12-15.
 */
public class testConstructorMutator {
    @Test
    public void testDriversFromUrl() throws IOException, ParseException {
        ConstructorMutator mutator = new ConstructorMutator();
        mutator.getAllTheConstructorInformation();
        mutator.getConstructor().setBuffer(new StringBuffer());
        System.out.println("Results from the Object: \n" + mutator.getConstructor().toString(mutator.getConstructor()));
    }

}
