package com.company.speedment.test.f1app.db0.f1app.results;

import com.speedment.Entity;
import com.speedment.field.ComparableField;
import com.speedment.field.StringField;
import com.speedment.internal.core.field.ComparableFieldImpl;
import com.speedment.internal.core.field.StringFieldImpl;
import java.util.Optional;
import javax.annotation.Generated;

/**
 * An interface representing an entity (for example, a row) in the
 * com.speedment.internal.ui.config.TableProperty@9dd2e72.
 * <p>
 * This Class or Interface has been automatically generated by Speedment. Any
 * changes made to this Class or Interface will be overwritten.
 * 
 * @author Speedment
 */
@Generated("Speedment")
public interface Results extends Entity<Results> {
    
    /**
     * This Field corresponds to the {@link Results} field that can be obtained
     * using the {@link Results#getResultId()} method.
     */
    public final static ComparableField<Results, Integer> RESULTID = new ComparableFieldImpl<>("resultId", Results::getResultId, Results::setResultId);
    /**
     * This Field corresponds to the {@link Results} field that can be obtained
     * using the {@link Results#getRaceId()} method.
     */
    public final static ComparableField<Results, Integer> RACEID = new ComparableFieldImpl<>("raceId", Results::getRaceId, Results::setRaceId);
    /**
     * This Field corresponds to the {@link Results} field that can be obtained
     * using the {@link Results#getDriverId()} method.
     */
    public final static ComparableField<Results, Integer> DRIVERID = new ComparableFieldImpl<>("driverId", Results::getDriverId, Results::setDriverId);
    /**
     * This Field corresponds to the {@link Results} field that can be obtained
     * using the {@link Results#getConstructorId()} method.
     */
    public final static ComparableField<Results, Integer> CONSTRUCTORID = new ComparableFieldImpl<>("constructorId", Results::getConstructorId, Results::setConstructorId);
    /**
     * This Field corresponds to the {@link Results} field that can be obtained
     * using the {@link Results#getNumber()} method.
     */
    public final static ComparableField<Results, Integer> NUMBER = new ComparableFieldImpl<>("number", Results::getNumber, Results::setNumber);
    /**
     * This Field corresponds to the {@link Results} field that can be obtained
     * using the {@link Results#getGrid()} method.
     */
    public final static ComparableField<Results, Integer> GRID = new ComparableFieldImpl<>("grid", Results::getGrid, Results::setGrid);
    /**
     * This Field corresponds to the {@link Results} field that can be obtained
     * using the {@link Results#getPosition()} method.
     */
    public final static ComparableField<Results, Integer> POSITION = new ComparableFieldImpl<>("position", o -> o.getPosition().orElse(null), Results::setPosition);
    /**
     * This Field corresponds to the {@link Results} field that can be obtained
     * using the {@link Results#getPositionText()} method.
     */
    public final static StringField<Results> POSITIONTEXT = new StringFieldImpl<>("positionText", Results::getPositionText, Results::setPositionText);
    /**
     * This Field corresponds to the {@link Results} field that can be obtained
     * using the {@link Results#getPositionOrder()} method.
     */
    public final static ComparableField<Results, Integer> POSITIONORDER = new ComparableFieldImpl<>("positionOrder", Results::getPositionOrder, Results::setPositionOrder);
    /**
     * This Field corresponds to the {@link Results} field that can be obtained
     * using the {@link Results#getPoints()} method.
     */
    public final static ComparableField<Results, Float> POINTS = new ComparableFieldImpl<>("points", Results::getPoints, Results::setPoints);
    /**
     * This Field corresponds to the {@link Results} field that can be obtained
     * using the {@link Results#getLaps()} method.
     */
    public final static ComparableField<Results, Integer> LAPS = new ComparableFieldImpl<>("laps", Results::getLaps, Results::setLaps);
    /**
     * This Field corresponds to the {@link Results} field that can be obtained
     * using the {@link Results#getTime()} method.
     */
    public final static StringField<Results> TIME = new StringFieldImpl<>("time", o -> o.getTime().orElse(null), Results::setTime);
    /**
     * This Field corresponds to the {@link Results} field that can be obtained
     * using the {@link Results#getMilliseconds()} method.
     */
    public final static ComparableField<Results, Integer> MILLISECONDS = new ComparableFieldImpl<>("milliseconds", o -> o.getMilliseconds().orElse(null), Results::setMilliseconds);
    /**
     * This Field corresponds to the {@link Results} field that can be obtained
     * using the {@link Results#getFastestLap()} method.
     */
    public final static ComparableField<Results, Integer> FASTESTLAP = new ComparableFieldImpl<>("fastestLap", o -> o.getFastestLap().orElse(null), Results::setFastestLap);
    /**
     * This Field corresponds to the {@link Results} field that can be obtained
     * using the {@link Results#getRank()} method.
     */
    public final static ComparableField<Results, Integer> RANK = new ComparableFieldImpl<>("rank", o -> o.getRank().orElse(null), Results::setRank);
    /**
     * This Field corresponds to the {@link Results} field that can be obtained
     * using the {@link Results#getFastestLapTime()} method.
     */
    public final static StringField<Results> FASTESTLAPTIME = new StringFieldImpl<>("fastestLapTime", o -> o.getFastestLapTime().orElse(null), Results::setFastestLapTime);
    /**
     * This Field corresponds to the {@link Results} field that can be obtained
     * using the {@link Results#getFastestLapSpeed()} method.
     */
    public final static StringField<Results> FASTESTLAPSPEED = new StringFieldImpl<>("fastestLapSpeed", o -> o.getFastestLapSpeed().orElse(null), Results::setFastestLapSpeed);
    /**
     * This Field corresponds to the {@link Results} field that can be obtained
     * using the {@link Results#getStatusId()} method.
     */
    public final static ComparableField<Results, Integer> STATUSID = new ComparableFieldImpl<>("statusId", Results::getStatusId, Results::setStatusId);
    
    /**
     * Returns the resultId of this Results. The resultId field corresponds to
     * the database column db0.F1APP.results.resultId.
     * 
     * @return the resultId of this Results
     */
    Integer getResultId();
    
    /**
     * Returns the raceId of this Results. The raceId field corresponds to the
     * database column db0.F1APP.results.raceId.
     * 
     * @return the raceId of this Results
     */
    Integer getRaceId();
    
    /**
     * Returns the driverId of this Results. The driverId field corresponds to
     * the database column db0.F1APP.results.driverId.
     * 
     * @return the driverId of this Results
     */
    Integer getDriverId();
    
    /**
     * Returns the constructorId of this Results. The constructorId field
     * corresponds to the database column db0.F1APP.results.constructorId.
     * 
     * @return the constructorId of this Results
     */
    Integer getConstructorId();
    
    /**
     * Returns the number of this Results. The number field corresponds to the
     * database column db0.F1APP.results.number.
     * 
     * @return the number of this Results
     */
    Integer getNumber();
    
    /**
     * Returns the grid of this Results. The grid field corresponds to the
     * database column db0.F1APP.results.grid.
     * 
     * @return the grid of this Results
     */
    Integer getGrid();
    
    /**
     * Returns the position of this Results. The position field corresponds to
     * the database column db0.F1APP.results.position.
     * 
     * @return the position of this Results
     */
    Optional<Integer> getPosition();
    
    /**
     * Returns the positionText of this Results. The positionText field
     * corresponds to the database column db0.F1APP.results.positionText.
     * 
     * @return the positionText of this Results
     */
    String getPositionText();
    
    /**
     * Returns the positionOrder of this Results. The positionOrder field
     * corresponds to the database column db0.F1APP.results.positionOrder.
     * 
     * @return the positionOrder of this Results
     */
    Integer getPositionOrder();
    
    /**
     * Returns the points of this Results. The points field corresponds to the
     * database column db0.F1APP.results.points.
     * 
     * @return the points of this Results
     */
    Float getPoints();
    
    /**
     * Returns the laps of this Results. The laps field corresponds to the
     * database column db0.F1APP.results.laps.
     * 
     * @return the laps of this Results
     */
    Integer getLaps();
    
    /**
     * Returns the time of this Results. The time field corresponds to the
     * database column db0.F1APP.results.time.
     * 
     * @return the time of this Results
     */
    Optional<String> getTime();
    
    /**
     * Returns the milliseconds of this Results. The milliseconds field
     * corresponds to the database column db0.F1APP.results.milliseconds.
     * 
     * @return the milliseconds of this Results
     */
    Optional<Integer> getMilliseconds();
    
    /**
     * Returns the fastestLap of this Results. The fastestLap field corresponds
     * to the database column db0.F1APP.results.fastestLap.
     * 
     * @return the fastestLap of this Results
     */
    Optional<Integer> getFastestLap();
    
    /**
     * Returns the rank of this Results. The rank field corresponds to the
     * database column db0.F1APP.results.rank.
     * 
     * @return the rank of this Results
     */
    Optional<Integer> getRank();
    
    /**
     * Returns the fastestLapTime of this Results. The fastestLapTime field
     * corresponds to the database column db0.F1APP.results.fastestLapTime.
     * 
     * @return the fastestLapTime of this Results
     */
    Optional<String> getFastestLapTime();
    
    /**
     * Returns the fastestLapSpeed of this Results. The fastestLapSpeed field
     * corresponds to the database column db0.F1APP.results.fastestLapSpeed.
     * 
     * @return the fastestLapSpeed of this Results
     */
    Optional<String> getFastestLapSpeed();
    
    /**
     * Returns the statusId of this Results. The statusId field corresponds to
     * the database column db0.F1APP.results.statusId.
     * 
     * @return the statusId of this Results
     */
    Integer getStatusId();
    
    /**
     * Sets the resultId of this Results. The resultId field corresponds to the
     * database column db0.F1APP.results.resultId.
     * 
     * @param resultId to set of this Results
     * @return this Results instance
     */
    Results setResultId(Integer resultId);
    
    /**
     * Sets the raceId of this Results. The raceId field corresponds to the
     * database column db0.F1APP.results.raceId.
     * 
     * @param raceId to set of this Results
     * @return this Results instance
     */
    Results setRaceId(Integer raceId);
    
    /**
     * Sets the driverId of this Results. The driverId field corresponds to the
     * database column db0.F1APP.results.driverId.
     * 
     * @param driverId to set of this Results
     * @return this Results instance
     */
    Results setDriverId(Integer driverId);
    
    /**
     * Sets the constructorId of this Results. The constructorId field
     * corresponds to the database column db0.F1APP.results.constructorId.
     * 
     * @param constructorId to set of this Results
     * @return this Results instance
     */
    Results setConstructorId(Integer constructorId);
    
    /**
     * Sets the number of this Results. The number field corresponds to the
     * database column db0.F1APP.results.number.
     * 
     * @param number to set of this Results
     * @return this Results instance
     */
    Results setNumber(Integer number);
    
    /**
     * Sets the grid of this Results. The grid field corresponds to the database
     * column db0.F1APP.results.grid.
     * 
     * @param grid to set of this Results
     * @return this Results instance
     */
    Results setGrid(Integer grid);
    
    /**
     * Sets the position of this Results. The position field corresponds to the
     * database column db0.F1APP.results.position.
     * 
     * @param position to set of this Results
     * @return this Results instance
     */
    Results setPosition(Integer position);
    
    /**
     * Sets the positionText of this Results. The positionText field corresponds
     * to the database column db0.F1APP.results.positionText.
     * 
     * @param positionText to set of this Results
     * @return this Results instance
     */
    Results setPositionText(String positionText);
    
    /**
     * Sets the positionOrder of this Results. The positionOrder field
     * corresponds to the database column db0.F1APP.results.positionOrder.
     * 
     * @param positionOrder to set of this Results
     * @return this Results instance
     */
    Results setPositionOrder(Integer positionOrder);
    
    /**
     * Sets the points of this Results. The points field corresponds to the
     * database column db0.F1APP.results.points.
     * 
     * @param points to set of this Results
     * @return this Results instance
     */
    Results setPoints(Float points);
    
    /**
     * Sets the laps of this Results. The laps field corresponds to the database
     * column db0.F1APP.results.laps.
     * 
     * @param laps to set of this Results
     * @return this Results instance
     */
    Results setLaps(Integer laps);
    
    /**
     * Sets the time of this Results. The time field corresponds to the database
     * column db0.F1APP.results.time.
     * 
     * @param time to set of this Results
     * @return this Results instance
     */
    Results setTime(String time);
    
    /**
     * Sets the milliseconds of this Results. The milliseconds field corresponds
     * to the database column db0.F1APP.results.milliseconds.
     * 
     * @param milliseconds to set of this Results
     * @return this Results instance
     */
    Results setMilliseconds(Integer milliseconds);
    
    /**
     * Sets the fastestLap of this Results. The fastestLap field corresponds to
     * the database column db0.F1APP.results.fastestLap.
     * 
     * @param fastestLap to set of this Results
     * @return this Results instance
     */
    Results setFastestLap(Integer fastestLap);
    
    /**
     * Sets the rank of this Results. The rank field corresponds to the database
     * column db0.F1APP.results.rank.
     * 
     * @param rank to set of this Results
     * @return this Results instance
     */
    Results setRank(Integer rank);
    
    /**
     * Sets the fastestLapTime of this Results. The fastestLapTime field
     * corresponds to the database column db0.F1APP.results.fastestLapTime.
     * 
     * @param fastestLapTime to set of this Results
     * @return this Results instance
     */
    Results setFastestLapTime(String fastestLapTime);
    
    /**
     * Sets the fastestLapSpeed of this Results. The fastestLapSpeed field
     * corresponds to the database column db0.F1APP.results.fastestLapSpeed.
     * 
     * @param fastestLapSpeed to set of this Results
     * @return this Results instance
     */
    Results setFastestLapSpeed(String fastestLapSpeed);
    
    /**
     * Sets the statusId of this Results. The statusId field corresponds to the
     * database column db0.F1APP.results.statusId.
     * 
     * @param statusId to set of this Results
     * @return this Results instance
     */
    Results setStatusId(Integer statusId);
}