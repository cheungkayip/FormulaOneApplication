package f1.app.statistics;

import f1.app.drivers.Driver;

/**
 * Created by kayipcheung on 28-11-15.
 */
public class Statistics {
    private Driver driverInfo;
    private long numberOfPodiums;
    private long points;
    private long grandPrixEntered;
    private long WorldChampionships;
    private long highestRaceFinish;
    private long highestGridPosition;

    public Driver getDriverInfo() {
        return driverInfo;
    }

    public void setDriverInfo(Driver driverInfo) {
        this.driverInfo = driverInfo;
    }

    public long getNumberOfPodiums() {
        return numberOfPodiums;
    }

    public void setNumberOfPodiums(long numberOfPodiums) {
        this.numberOfPodiums = numberOfPodiums;
    }

    public long getPoints() {
        return points;
    }

    public void setPoints(long points) {
        this.points = points;
    }

    public long getGrandPrixEntered() {
        return grandPrixEntered;
    }

    public void setGrandPrixEntered(long grandPrixEntered) {
        this.grandPrixEntered = grandPrixEntered;
    }

    public long getWorldChampionships() {
        return WorldChampionships;
    }

    public void setWorldChampionships(long worldChampionships) {
        WorldChampionships = worldChampionships;
    }

    public long getHighestRaceFinish() {
        return highestRaceFinish;
    }

    public void setHighestRaceFinish(long highestRaceFinish) {
        this.highestRaceFinish = highestRaceFinish;
    }

    public long getHighestGridPosition() {
        return highestGridPosition;
    }

    public void setHighestGridPosition(long highestGridPosition) {
        this.highestGridPosition = highestGridPosition;
    }
}
