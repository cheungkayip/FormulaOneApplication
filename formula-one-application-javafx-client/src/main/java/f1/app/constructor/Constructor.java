package f1.app.constructor;

import javafx.scene.image.ImageView;

/**
 * Created by kayipcheung on 28-11-15.
 */
public class Constructor {
    //http://ergast.com/api/f1/2015/constructors.json
   public enum ConstructorId {
       FERRARI, MERCEDES, WILLIAMS, RED_BULL, FORCE_INDIA, LOTUS_F1, TORO_ROSSO, SAUBER, MCLAREN, MANOR, MARUSSIA
   }
    private ConstructorId constructorId;
    private String constructorUrl;
    private String constructorName;
    private String nationality;
    private ImageView teamLogo;
    private StringBuffer buffer;
    public Constructor(){

    }

    public String getConstructorUrl() {
        return constructorUrl;
    }

    public void setConstructorUrl(String constructorUrl) {
        this.constructorUrl = constructorUrl;
    }

    public String getConstructorName() {
        return constructorName;
    }

    public void setConstructorName(String constructorName) {
        this.constructorName = constructorName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public ImageView getTeamLogo() {
        return teamLogo;
    }

    public ImageView setTeamLogo(ImageView teamLogo) {
        this.teamLogo = teamLogo;
        return teamLogo;
    }

    public ConstructorId getConstructorId() {
        return constructorId;
    }

    public void setConstructorId(ConstructorId constructorId) {
        this.constructorId = constructorId;
    }

    public StringBuffer toString(Constructor constructor){
        getBuffer().append(
                "Constructor ID: " + constructor.getConstructorId() + "\n" +
                        "URL: " + constructor.getConstructorUrl() + "\n" +
                        "Constructor Name: " + constructor.getConstructorName() + "\n" +
                        "Nationality: " + constructor.getNationality() + "\n"
        );
        return getBuffer();
    }
    public StringBuffer getBuffer() {
        return buffer;
    }

    public void setBuffer(StringBuffer buffer) {
        this.buffer = buffer;
    }
}
