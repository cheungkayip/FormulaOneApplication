package f1.app.constructor;

import javafx.scene.image.ImageView;

/**
 * Created by kayipcheung on 28-11-15.
 */
public class Constructor {
    //http://ergast.com/api/f1/2015/constructors.json
   public enum ConstructorId {
       FERRARI, MERCEDES, WILLIAMS, RED_BULL_RACING, FORCE_INDIA, LOTUS, TORRO_ROSSO, SAUBER, MCLAREN, MARUSSIA
   }
    private ConstructorId constructorId;
    private String constructorUrl;
    private String constructorName;
    private String nationality;
    private ImageView teamLogo;

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

    public Constructor(ConstructorId name){
        this.constructorId = name;
    }

    public ImageView getTeamLogo() {
        return teamLogo;
    }

    public void setTeamLogo(ImageView teamLogo) {
        this.teamLogo = teamLogo;
    }

    public ConstructorId getConstructorId() {
        return constructorId;
    }

    public void setConstructorId(ConstructorId constructorId) {
        this.constructorId = constructorId;
    }


}
