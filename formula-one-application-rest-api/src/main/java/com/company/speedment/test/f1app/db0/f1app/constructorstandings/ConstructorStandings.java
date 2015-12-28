package com.company.speedment.test.f1app.db0.f1app.constructorstandings;

import com.speedment.Entity;
import com.speedment.field.ComparableField;
import com.speedment.field.StringField;
import com.speedment.internal.core.field.ComparableFieldImpl;
import com.speedment.internal.core.field.StringFieldImpl;
import java.util.Optional;
import javax.annotation.Generated;

/**
 * An interface representing an entity (for example, a row) in the Table
 * 'f1app.db0.F1APP.constructorStandings'.
 * <p>
 * This Class or Interface has been automatically generated by Speedment. Any
 * changes made to this Class or Interface will be overwritten.
 * 
 * @author Speedment
 */
@Generated("Speedment")
public interface ConstructorStandings extends Entity<ConstructorStandings> {
    
    /**
     * This Field corresponds to the {@link ConstructorStandings} field that can
     * be obtained using the {@link
     * ConstructorStandings#getConstructorStandingsId()} method.
     */
    public final static ComparableField<ConstructorStandings, Integer> CONSTRUCTORSTANDINGSID = new ComparableFieldImpl<>("constructorStandingsId", ConstructorStandings::getConstructorStandingsId, ConstructorStandings::setConstructorStandingsId);
    /**
     * This Field corresponds to the {@link ConstructorStandings} field that can
     * be obtained using the {@link ConstructorStandings#getRaceId()} method.
     */
    public final static ComparableField<ConstructorStandings, Integer> RACEID = new ComparableFieldImpl<>("raceId", ConstructorStandings::getRaceId, ConstructorStandings::setRaceId);
    /**
     * This Field corresponds to the {@link ConstructorStandings} field that can
     * be obtained using the {@link ConstructorStandings#getConstructorId()}
     * method.
     */
    public final static ComparableField<ConstructorStandings, Integer> CONSTRUCTORID = new ComparableFieldImpl<>("constructorId", ConstructorStandings::getConstructorId, ConstructorStandings::setConstructorId);
    /**
     * This Field corresponds to the {@link ConstructorStandings} field that can
     * be obtained using the {@link ConstructorStandings#getPoints()} method.
     */
    public final static ComparableField<ConstructorStandings, Float> POINTS = new ComparableFieldImpl<>("points", ConstructorStandings::getPoints, ConstructorStandings::setPoints);
    /**
     * This Field corresponds to the {@link ConstructorStandings} field that can
     * be obtained using the {@link ConstructorStandings#getPosition()} method.
     */
    public final static ComparableField<ConstructorStandings, Integer> POSITION = new ComparableFieldImpl<>("position", o -> o.getPosition().orElse(null), ConstructorStandings::setPosition);
    /**
     * This Field corresponds to the {@link ConstructorStandings} field that can
     * be obtained using the {@link ConstructorStandings#getPositionText()}
     * method.
     */
    public final static StringField<ConstructorStandings> POSITIONTEXT = new StringFieldImpl<>("positionText", o -> o.getPositionText().orElse(null), ConstructorStandings::setPositionText);
    /**
     * This Field corresponds to the {@link ConstructorStandings} field that can
     * be obtained using the {@link ConstructorStandings#getWins()} method.
     */
    public final static ComparableField<ConstructorStandings, Integer> WINS = new ComparableFieldImpl<>("wins", ConstructorStandings::getWins, ConstructorStandings::setWins);
    
    /**
     * Returns the constructorStandingsId of this ConstructorStandings. The
     * constructorStandingsId field corresponds to the database column
     * db0.F1APP.constructorStandings.constructorStandingsId.
     * 
     * @return the constructorStandingsId of this ConstructorStandings
     */
    Integer getConstructorStandingsId();
    
    /**
     * Returns the raceId of this ConstructorStandings. The raceId field
     * corresponds to the database column db0.F1APP.constructorStandings.raceId.
     * 
     * @return the raceId of this ConstructorStandings
     */
    Integer getRaceId();
    
    /**
     * Returns the constructorId of this ConstructorStandings. The constructorId
     * field corresponds to the database column
     * db0.F1APP.constructorStandings.constructorId.
     * 
     * @return the constructorId of this ConstructorStandings
     */
    Integer getConstructorId();
    
    /**
     * Returns the points of this ConstructorStandings. The points field
     * corresponds to the database column db0.F1APP.constructorStandings.points.
     * 
     * @return the points of this ConstructorStandings
     */
    Float getPoints();
    
    /**
     * Returns the position of this ConstructorStandings. The position field
     * corresponds to the database column
     * db0.F1APP.constructorStandings.position.
     * 
     * @return the position of this ConstructorStandings
     */
    Optional<Integer> getPosition();
    
    /**
     * Returns the positionText of this ConstructorStandings. The positionText
     * field corresponds to the database column
     * db0.F1APP.constructorStandings.positionText.
     * 
     * @return the positionText of this ConstructorStandings
     */
    Optional<String> getPositionText();
    
    /**
     * Returns the wins of this ConstructorStandings. The wins field corresponds
     * to the database column db0.F1APP.constructorStandings.wins.
     * 
     * @return the wins of this ConstructorStandings
     */
    Integer getWins();
    
    /**
     * Sets the constructorStandingsId of this ConstructorStandings. The
     * constructorStandingsId field corresponds to the database column
     * db0.F1APP.constructorStandings.constructorStandingsId.
     * 
     * @param constructorStandingsId to set of this ConstructorStandings
     * @return this ConstructorStandings instance
     */
    ConstructorStandings setConstructorStandingsId(Integer constructorStandingsId);
    
    /**
     * Sets the raceId of this ConstructorStandings. The raceId field corresponds
     * to the database column db0.F1APP.constructorStandings.raceId.
     * 
     * @param raceId to set of this ConstructorStandings
     * @return this ConstructorStandings instance
     */
    ConstructorStandings setRaceId(Integer raceId);
    
    /**
     * Sets the constructorId of this ConstructorStandings. The constructorId
     * field corresponds to the database column
     * db0.F1APP.constructorStandings.constructorId.
     * 
     * @param constructorId to set of this ConstructorStandings
     * @return this ConstructorStandings instance
     */
    ConstructorStandings setConstructorId(Integer constructorId);
    
    /**
     * Sets the points of this ConstructorStandings. The points field corresponds
     * to the database column db0.F1APP.constructorStandings.points.
     * 
     * @param points to set of this ConstructorStandings
     * @return this ConstructorStandings instance
     */
    ConstructorStandings setPoints(Float points);
    
    /**
     * Sets the position of this ConstructorStandings. The position field
     * corresponds to the database column
     * db0.F1APP.constructorStandings.position.
     * 
     * @param position to set of this ConstructorStandings
     * @return this ConstructorStandings instance
     */
    ConstructorStandings setPosition(Integer position);
    
    /**
     * Sets the positionText of this ConstructorStandings. The positionText field
     * corresponds to the database column
     * db0.F1APP.constructorStandings.positionText.
     * 
     * @param positionText to set of this ConstructorStandings
     * @return this ConstructorStandings instance
     */
    ConstructorStandings setPositionText(String positionText);
    
    /**
     * Sets the wins of this ConstructorStandings. The wins field corresponds to
     * the database column db0.F1APP.constructorStandings.wins.
     * 
     * @param wins to set of this ConstructorStandings
     * @return this ConstructorStandings instance
     */
    ConstructorStandings setWins(Integer wins);
}