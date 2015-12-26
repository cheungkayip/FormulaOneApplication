package f1.app.races;

import java.util.ArrayList;

/**
 * Created by kayipcheung on 12-12-15.
 */
public class RaceResults {
    private int season;
    private int round;
    private String circuitName;
    private String locality;
    private String country;
    private String raceStartDate;
    private String raceStartTime;
    private String finishingPosition;
    private int driverNumber;
    private int driverPoints;
    private String givenName;
    private String familyName;
    private String constructor;
    private int startingGrid;
    private int drivenLaps;
    private String status;
    private String totalRidingTime;
    private int fastestLapRank;
    private int fastestLap;
    private String fastestLapTime;

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public int getRound() {
        return round;
    }

    public int setRound(int round) {
        this.round = round;
        return round;
    }

    public String getCircuitName() {
        return circuitName;
    }

    public String setCircuitName(String circuitName) {
        this.circuitName = circuitName;
        return circuitName;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRaceStartDate() {
        return raceStartDate;
    }

    public void setRaceStartDate(String raceStartDate) {
        this.raceStartDate = raceStartDate;
    }

    public String getRaceStartTime() {
        return raceStartTime;
    }

    public void setRaceStartTime(String raceStartTime) {
        this.raceStartTime = raceStartTime;
    }

    public String getFinishingPosition() {
        return finishingPosition;
    }

    public void setFinishingPosition(String finishingPosition) {
        this.finishingPosition = finishingPosition;
    }

    public int getDriverNumber() {
        return driverNumber;
    }

    public void setDriverNumber(int driverNumber) {
        this.driverNumber = driverNumber;
    }

    public int getDriverPoints() {
        return driverPoints;
    }

    public void setDriverPoints(int driverPoints) {
        this.driverPoints = driverPoints;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getConstructor() {
        return constructor;
    }

    public void setConstructor(String constructor) {
        this.constructor = constructor;
    }

    public int getStartingGrid() {
        return startingGrid;
    }

    public void setStartingGrid(int startingGrid) {
        this.startingGrid = startingGrid;
    }

    public int getDrivenLaps() {
        return drivenLaps;
    }

    public void setDrivenLaps(int drivenLaps) {
        this.drivenLaps = drivenLaps;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalRidingTime() {
        return totalRidingTime;
    }

    public void setTotalRidingTime(String totalRidingTime) {
        this.totalRidingTime = totalRidingTime;
    }

    public int getFastestLapRank() {
        return fastestLapRank;
    }

    public void setFastestLapRank(int fastestLapRank) {
        this.fastestLapRank = fastestLapRank;
    }

    public int getFastestLap() {
        return fastestLap;
    }

    public void setFastestLap(int fastestLap) {
        this.fastestLap = fastestLap;
    }

    public String getFastestLapTime() {
        return fastestLapTime;
    }

    public void setFastestLapTime(String fastestLapTime) {
        this.fastestLapTime = fastestLapTime;
    }
}
