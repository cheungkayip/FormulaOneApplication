package f1.app.pojo;

/**
 * Created by kayipcheung on 07-12-15.
 */
public class DriverStandings {
    private String position;
    private String points;
    private String wins;
    private String driver;
    private String constructor;
    private StringBuffer buffer;

    public String getConstructor() {
        return constructor;
    }

    public void setConstructor(String constructor) {
        this.constructor = constructor;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getWins() {
        return wins;
    }

    public void setWins(String wins) {
        this.wins = wins;
    }

    public String getDriver() {

        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public StringBuffer toString(DriverStandings standings) {
        getBuffer().append("Position: ").append(standings.getPosition()).append("\n")
                .append("Driver: ").append(standings.getDriver()).append(" ").append("\n")
                .append("Constructor: ").append(standings.getConstructor()).append("\n")
                .append("Points: ").append(standings.getPoints()).append("\n")
                .append("Wins: ").append(standings.getWins()).append("\n");
        return getBuffer();
    }

    public StringBuffer getBuffer() {
        return buffer;
    }

    public void setBuffer(StringBuffer buffer) {
        this.buffer = buffer;
    }
}
