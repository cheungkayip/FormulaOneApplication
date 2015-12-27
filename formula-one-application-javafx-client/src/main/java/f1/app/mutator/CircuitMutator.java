package f1.app.mutator;

import f1.app.global.GlobalF1;
import f1.app.pojo.Circuit;
import f1.app.pojo.RaceResults;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by kayipcheung on 27-12-15.
 */
public class CircuitMutator {

    private Circuit circuit;

    public Circuit getCircuit() {
        return circuit;
    }

    public void setCircuit(Circuit circuit) {
        this.circuit = circuit;
    }

    public Circuit selectRaceImages(ArrayList<RaceResults> defaultFirstRace) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        setCircuit(new Circuit());
        GlobalF1 global = new GlobalF1();
        for (RaceResults race : defaultFirstRace) {
            String resourceNew = GlobalF1.FORMULA_ONE_RESOURCES_DIR;
            Object jsonFile = parser.parse(new FileReader(resourceNew + "CircuitNameFile.json"));

            JSONObject jsonObject = (JSONObject) jsonFile;
            JSONArray jsonFileArray = (JSONArray) jsonObject.get("Circuit");

            for (Object temp : jsonFileArray) {
                JSONObject obj = (JSONObject) temp;
                if (obj.get("circuitFlag").toString().contains(race.getCountry())) {
                    String circuitFlag = (String) obj.get("circuitFlag"); // Constructor Logo Image
                    circuit.setCircuitFlag(global.setTheImage(resourceNew + "Circuits/" + circuitFlag));
                    String circuitName = (String) obj.get("circuitName");
                    circuit.setCircuitImage(global.setTheImage(resourceNew + "Circuits/" + circuitName));
                    break;
                }
            }
        }
        return circuit;
        }

    }

