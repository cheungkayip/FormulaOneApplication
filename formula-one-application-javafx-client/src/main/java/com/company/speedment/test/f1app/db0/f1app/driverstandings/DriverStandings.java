package com.company.speedment.test.f1app.db0.f1app.driverstandings;

import com.speedment.Entity;
import com.speedment.field.ComparableField;
import com.speedment.field.StringField;
import com.speedment.internal.core.field.ComparableFieldImpl;
import com.speedment.internal.core.field.StringFieldImpl;
import java.util.Optional;
import javax.annotation.Generated;

/**
 * An interface representing an entity (for example, a row) in the
 * com.speedment.internal.ui.config.TableProperty@dd7c5fa.
 * <p>
 * This Class or Interface has been automatically generated by Speedment. Any
 * changes made to this Class or Interface will be overwritten.
 * 
 * @author Speedment
 */
@Generated("Speedment")
public interface DriverStandings extends Entity<DriverStandings> {
    
    /**
     * This Field corresponds to the {@link DriverStandings} field that can be
     * obtained using the {@link DriverStandings#getDriverStandingsId()} method.
     */
    public final static ComparableField<DriverStandings, Integer> DRIVERSTANDINGSID = new ComparableFieldImpl<>("driverStandingsId", DriverStandings::getDriverStandingsId, DriverStandings::setDriverStandingsId);
    /**
     * This Field corresponds to the {@link DriverStandings} field that can be
     * obtained using the {@link DriverStandings#getRaceId()} method.
     */
    public final static ComparableField<DriverStandings, Integer> RACEID = new ComparableFieldImpl<>("raceId", DriverStandings::getRaceId, DriverStandings::setRaceId);
    /**
     * This Field corresponds to the {@link DriverStandings} field that can be
     * obtained using the {@link DriverStandings#getDriverId()} method.
     */
    public final static ComparableField<DriverStandings, Integer> DRIVERID = new ComparableFieldImpl<>("driverId", DriverStandings::getDriverId, DriverStandings::setDriverId);
    /**
     * This Field corresponds to the {@link DriverStandings} field that can be
     * obtained using the {@link DriverStandings#getPoints()} method.
     */
    public final static ComparableField<DriverStandings, Float> POINTS = new ComparableFieldImpl<>("points", DriverStandings::getPoints, DriverStandings::setPoints);
    /**
     * This Field corresponds to the {@link DriverStandings} field that can be
     * obtained using the {@link DriverStandings#getPosition()} method.
     */
    public final static ComparableField<DriverStandings, Integer> POSITION = new ComparableFieldImpl<>("position", o -> o.getPosition().orElse(null), DriverStandings::setPosition);
    /**
     * This Field corresponds to the {@link DriverStandings} field that can be
     * obtained using the {@link DriverStandings#getPositionText()} method.
     */
    public final static StringField<DriverStandings> POSITIONTEXT = new StringFieldImpl<>("positionText", o -> o.getPositionText().orElse(null), DriverStandings::setPositionText);
    /**
     * This Field corresponds to the {@link DriverStandings} field that can be
     * obtained using the {@link DriverStandings#getWins()} method.
     */
    public final static ComparableField<DriverStandings, Integer> WINS = new ComparableFieldImpl<>("wins", DriverStandings::getWins, DriverStandings::setWins);
    
    /**
     * Returns the driverStandingsId of this DriverStandings. The
     * driverStandingsId field corresponds to the database column
     * db0.F1APP.driverStandings.driverStandingsId.
     * 
     * @return the driverStandingsId of this DriverStandings
     */
    Integer getDriverStandingsId();
    
    /**
     * Returns the raceId of this DriverStandings. The raceId field corresponds
     * to the database column db0.F1APP.driverStandings.raceId.
     * 
     * @return the raceId of this DriverStandings
     */
    Integer getRaceId();
    
    /**
     * Returns the driverId of this DriverStandings. The driverId field
     * corresponds to the database column db0.F1APP.driverStandings.driverId.
     * 
     * @return the driverId of this DriverStandings
     */
    Integer getDriverId();
    
    /**
     * Returns the points of this DriverStandings. The points field corresponds
     * to the database column db0.F1APP.driverStandings.points.
     * 
     * @return the points of this DriverStandings
     */
    Float getPoints();
    
    /**
     * Returns the position of this DriverStandings. The position field
     * corresponds to the database column db0.F1APP.driverStandings.position.
     * 
     * @return the position of this DriverStandings
     */
    Optional<Integer> getPosition();
    
    /**
     * Returns the positionText of this DriverStandings. The positionText field
     * corresponds to the database column db0.F1APP.driverStandings.positionText.
     * 
     * @return the positionText of this DriverStandings
     */
    Optional<String> getPositionText();
    
    /**
     * Returns the wins of this DriverStandings. The wins field corresponds to
     * the database column db0.F1APP.driverStandings.wins.
     * 
     * @return the wins of this DriverStandings
     */
    Integer getWins();
    
    /**
     * Sets the driverStandingsId of this DriverStandings. The driverStandingsId
     * field corresponds to the database column
     * db0.F1APP.driverStandings.driverStandingsId.
     * 
     * @param driverStandingsId to set of this DriverStandings
     * @return this DriverStandings instance
     */
    DriverStandings setDriverStandingsId(Integer driverStandingsId);
    
    /**
     * Sets the raceId of this DriverStandings. The raceId field corresponds to
     * the database column db0.F1APP.driverStandings.raceId.
     * 
     * @param raceId to set of this DriverStandings
     * @return this DriverStandings instance
     */
    DriverStandings setRaceId(Integer raceId);
    
    /**
     * Sets the driverId of this DriverStandings. The driverId field corresponds
     * to the database column db0.F1APP.driverStandings.driverId.
     * 
     * @param driverId to set of this DriverStandings
     * @return this DriverStandings instance
     */
    DriverStandings setDriverId(Integer driverId);
    
    /**
     * Sets the points of this DriverStandings. The points field corresponds to
     * the database column db0.F1APP.driverStandings.points.
     * 
     * @param points to set of this DriverStandings
     * @return this DriverStandings instance
     */
    DriverStandings setPoints(Float points);
    
    /**
     * Sets the position of this DriverStandings. The position field corresponds
     * to the database column db0.F1APP.driverStandings.position.
     * 
     * @param position to set of this DriverStandings
     * @return this DriverStandings instance
     */
    DriverStandings setPosition(Integer position);
    
    /**
     * Sets the positionText of this DriverStandings. The positionText field
     * corresponds to the database column db0.F1APP.driverStandings.positionText.
     * 
     * @param positionText to set of this DriverStandings
     * @return this DriverStandings instance
     */
    DriverStandings setPositionText(String positionText);
    
    /**
     * Sets the wins of this DriverStandings. The wins field corresponds to the
     * database column db0.F1APP.driverStandings.wins.
     * 
     * @param wins to set of this DriverStandings
     * @return this DriverStandings instance
     */
    DriverStandings setWins(Integer wins);
}