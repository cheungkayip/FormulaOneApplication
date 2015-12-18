package f1.app.races;

import f1.app.ergast.url.Ergast;
import f1.app.global.GlobalF1;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by kayipcheung on 12-12-15.
 */
public class RaceMutator {
    private Ergast ergast;
    private RaceResults results;
    private ArrayList<RaceResults> raceResultList = new ArrayList<>();
    private ArrayList<String> circuitInformation = new ArrayList<>();


    public ArrayList<String> getCircuitInformation() {
        return circuitInformation;
    }

    public Ergast getErgast() {
        return ergast;
    }

    public void setErgast(Ergast ergast) {
        this.ergast = ergast;
    }

    public RaceResults getResults() {
        return results;
    }

    public void setResults(RaceResults results) {
        this.results = results;
    }

    public ArrayList<RaceResults> getRaceResultList() {
        return raceResultList;
    }

    public ArrayList<RaceResults> generateRaceResults(String resource) throws IOException, ParseException {
        ArrayList<String> raceNumberList = new ArrayList<>();
        setErgast(new Ergast());

        String circuitJSON = getErgast().decideTheRightJSON(resource, GlobalF1.CIRCUITS_JSON);
        JSONObject json = (JSONObject) new JSONParser().parse(circuitJSON);
        JSONObject mrData = (JSONObject) json.get("MRData");
        String total = mrData.get("total").toString();
        int totalRaces = Integer.parseInt(total);

        int raceNumber = 1;


        while (raceNumber <= totalRaces) {
            String jsonURL = getErgast().callUrlToGetJSONData(GlobalF1.RACE_RESULTS_DIR+raceNumber+"/results.Json");
            JSONObject parsedJsonUrl = (JSONObject) new JSONParser().parse(jsonURL);
            JSONObject raceResultsMRData = (JSONObject) parsedJsonUrl.get("MRData");
            JSONObject raceTable = (JSONObject) raceResultsMRData.get("RaceTable");
            JSONArray races = (JSONArray) raceTable.get("Races");
            races.stream().forEach(raceItem -> {
                JSONObject innerRaces = (JSONObject) raceItem;
                JSONObject innerCircuit = (JSONObject)innerRaces.get("Circuit");
                JSONObject innerLocation = (JSONObject)innerCircuit.get("Location");
                JSONArray results = (JSONArray) innerRaces.get("Results");

                results.stream().forEach(resultsItem -> {
                    setResults(new RaceResults());
                    getResults().setSeason(Integer.parseInt(innerRaces.get("season").toString()));
                    getResults().setRound(Integer.parseInt(innerRaces.get("round").toString()));
                    getResults().setCircuitName(innerCircuit.get("circuitName").toString());
                    getResults().setLocality(innerLocation.get("locality").toString());
                    getResults().setCountry(innerLocation.get("country").toString());

                    getResults().setRaceStartDate(innerRaces.get("date").toString());
                    getResults().setRaceStartTime(innerRaces.get("time").toString());
                    JSONObject json3 = (JSONObject) resultsItem;
                    getResults().setDriverNumber(Integer.parseInt(json3.get("number").toString()));
                    getResults().setFinishingPosition(json3.get("position").toString());
                    getResults().setDriverPoints(Integer.parseInt(json3.get("points").toString()));

                    JSONObject json4 = (JSONObject) json3.get("Driver");
                    if(json4 != null){
                        if(json4.get("permanentNumber") != null){
                            getResults().setDriverNumber(Integer.parseInt(json4.get("permanentNumber").toString()));
                        }
                        getResults().setGivenName(json4.get("givenName").toString());
                        getResults().setFamilyName(json4.get("familyName").toString());
                    }
                    JSONObject constructor = (JSONObject) json3.get("Constructor");
                    getResults().setConstructor(constructor.get("name").toString());

                    getResults().setStartingGrid(Integer.parseInt(json3.get("grid").toString()));
                    getResults().setDrivenLaps(Integer.parseInt(json3.get("laps").toString()));
                    getResults().setStatus(json3.get("status").toString());

                    JSONObject innerTime = (JSONObject) json3.get("Time");
                    if(innerTime != null){
                        getResults().setTotalRidingTime(innerTime.get("time").toString());
                    }
                    JSONObject innerFastestLap = (JSONObject) json3.get("FastestLap");
                    if(innerFastestLap != null) {
                        getResults().setFastestLapRank(Integer.parseInt(innerFastestLap.get("rank").toString()));
                        getResults().setFastestLap(Integer.parseInt(innerFastestLap.get("lap").toString()));
                        JSONObject innerTime2 = (JSONObject) innerFastestLap.get("Time");
                        if(innerTime2 != null){
                            getResults().setFastestLapTime(innerTime2.get("time").toString());
                        }
                    }

                    raceResultList.add(getResults());
                        }
                );

                circuitInformation.add("Round: " + getResults().getRound() + " " + "Circuit Name: "  + getResults().getCircuitName());
            });

            raceNumberList.add(jsonURL);
            raceNumber++;
        }
        return raceResultList;
    }

    public ArrayList<RaceResults> decideWhichRaceIsDisplayed(ArrayList<RaceResults> list, Number raceName){
        ArrayList<RaceResults> reconstructedList = new ArrayList<>();
        String raceRound = String.valueOf(raceName);
        switch(raceRound){
            case "0":
                list.stream()
                        .filter(s->s.getCircuitName().equals("Albert Park Grand Prix Circuit"))
                        .forEach(reconstructedList::add);
                break;
            case "1":
                list.stream()
                        .filter(s->s.getCircuitName().equals("Sepang International Circuit"))
                        .forEach(reconstructedList::add);
                break;
            case "2":
                list.stream()
                        .filter(s->s.getCircuitName().equals("Shanghai International Circuit"))
                        .forEach(reconstructedList::add);
                break;
            case "3":
                list.stream()
                        .filter(s->s.getCircuitName().equals("Bahrain International Circuit"))
                        .forEach(reconstructedList::add);
                break;
            case "4":
                list.stream()
                        .filter(s->s.getCircuitName().equals("Circuit de Catalunya"))
                        .forEach(reconstructedList::add);
                break;
            case "5":
                list.stream()
                        .filter(s->s.getCircuitName().equals("Circuit de Monaco"))
                        .forEach(reconstructedList::add);
                break;
            case "6":
                list.stream()
                        .filter(s->s.getCircuitName().equals("Circuit Gilles Villeneuve"))
                        .forEach(reconstructedList::add);
                break;
            case "7":
                list.stream()
                        .filter(s->s.getCircuitName().equals("Red Bull Ring"))
                        .forEach(reconstructedList::add);
                break;
            case "8":
                list.stream()
                        .filter(s->s.getCircuitName().equals("Silverstone Circuit"))
                        .forEach(reconstructedList::add);
                break;
            case "9":
                list.stream()
                        .filter(s->s.getCircuitName().equals("Hungaroring"))
                        .forEach(reconstructedList::add);
                break;
            case "10":
                list.stream()
                        .filter(s->s.getCircuitName().equals("Circuit de Spa-Francorchamps"))
                        .forEach(reconstructedList::add);
                break;
            case "11":
                list.stream()
                        .filter(s->s.getCircuitName().equals("Autodromo Nazionale di Monza"))
                        .forEach(reconstructedList::add);
                break;
            case "12":
                list.stream()
                        .filter(s->s.getCircuitName().equals("Marina Bay Street Circuit"))
                        .forEach(reconstructedList::add);
                break;
            case "13":
                list.stream()
                        .filter(s->s.getCircuitName().equals("Suzuka Circuit"))
                        .forEach(reconstructedList::add);
                break;
            case "14":
                list.stream()
                        .filter(s->s.getCircuitName().equals("Sochi International Street Circuit"))
                        .forEach(reconstructedList::add);
                break;
            case "15":
                list.stream()
                        .filter(s->s.getCircuitName().equals("Circuit of the Americas"))
                        .forEach(reconstructedList::add);
                break;
            case "16":
                list.stream()
                        .filter(s->s.getCircuitName().equals("Autódromo Hermanos Rodríguez"))
                        .forEach(reconstructedList::add);
                break;
            case "17":
                list.stream()
                        .filter(s->s.getCircuitName().equals("Autódromo José Carlos Pace"))
                        .forEach(reconstructedList::add);
                break;
            case "18":
                list.stream()
                        .filter(s->s.getCircuitName().equals("Yas Marina Circuit"))
                        .forEach(reconstructedList::add);
                break;
        }
        return reconstructedList;
    }
}