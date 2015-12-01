package f1.app.teams;

import javafx.scene.image.ImageView;

/**
 * Created by kayipcheung on 28-11-15.
 */
public class Team {
   public enum TeamName {
       FERRARI, MERCEDES, WILLIAMS, RED_BULL_RACING, FORCE_INDIA, LOTUS, TORRO_ROSSO, SAUBER, MCLAREN, MARUSSIA
   }
    private TeamName teamName;
    private ImageView teamLogo;

    public Team(){

    }

    public Team(TeamName name){
        this.teamName = name;
    }

    public ImageView getTeamLogo() {
        return teamLogo;
    }

    public void setTeamLogo(ImageView teamLogo) {
        this.teamLogo = teamLogo;
    }

    public TeamName getTeamName() {
        return teamName;
    }

    public void setTeamName(TeamName teamName) {
        this.teamName = teamName;
    }


}
