package com.company.speedment.test.f1app.db0.f1app.qualifying;

import com.speedment.Entity;
import com.speedment.field.ComparableField;
import com.speedment.field.StringField;
import com.speedment.internal.core.field.ComparableFieldImpl;
import com.speedment.internal.core.field.StringFieldImpl;
import java.util.Optional;
import javax.annotation.Generated;

/**
 * An interface representing an entity (for example, a row) in the
 * com.speedment.internal.ui.config.TableProperty@51f0afdf.
 * <p>
 * This Class or Interface has been automatically generated by Speedment. Any
 * changes made to this Class or Interface will be overwritten.
 * 
 * @author Speedment
 */
@Generated("Speedment")
public interface Qualifying extends Entity<Qualifying> {
    
    /**
     * This Field corresponds to the {@link Qualifying} field that can be
     * obtained using the {@link Qualifying#getQualifyId()} method.
     */
    public final static ComparableField<Qualifying, Integer> QUALIFYID = new ComparableFieldImpl<>("qualifyId", Qualifying::getQualifyId, Qualifying::setQualifyId);
    /**
     * This Field corresponds to the {@link Qualifying} field that can be
     * obtained using the {@link Qualifying#getRaceId()} method.
     */
    public final static ComparableField<Qualifying, Integer> RACEID = new ComparableFieldImpl<>("raceId", Qualifying::getRaceId, Qualifying::setRaceId);
    /**
     * This Field corresponds to the {@link Qualifying} field that can be
     * obtained using the {@link Qualifying#getDriverId()} method.
     */
    public final static ComparableField<Qualifying, Integer> DRIVERID = new ComparableFieldImpl<>("driverId", Qualifying::getDriverId, Qualifying::setDriverId);
    /**
     * This Field corresponds to the {@link Qualifying} field that can be
     * obtained using the {@link Qualifying#getConstructorId()} method.
     */
    public final static ComparableField<Qualifying, Integer> CONSTRUCTORID = new ComparableFieldImpl<>("constructorId", Qualifying::getConstructorId, Qualifying::setConstructorId);
    /**
     * This Field corresponds to the {@link Qualifying} field that can be
     * obtained using the {@link Qualifying#getNumber()} method.
     */
    public final static ComparableField<Qualifying, Integer> NUMBER = new ComparableFieldImpl<>("number", Qualifying::getNumber, Qualifying::setNumber);
    /**
     * This Field corresponds to the {@link Qualifying} field that can be
     * obtained using the {@link Qualifying#getPosition()} method.
     */
    public final static ComparableField<Qualifying, Integer> POSITION = new ComparableFieldImpl<>("position", o -> o.getPosition().orElse(null), Qualifying::setPosition);
    /**
     * This Field corresponds to the {@link Qualifying} field that can be
     * obtained using the {@link Qualifying#getQ1()} method.
     */
    public final static StringField<Qualifying> Q1 = new StringFieldImpl<>("q1", o -> o.getQ1().orElse(null), Qualifying::setQ1);
    /**
     * This Field corresponds to the {@link Qualifying} field that can be
     * obtained using the {@link Qualifying#getQ2()} method.
     */
    public final static StringField<Qualifying> Q2 = new StringFieldImpl<>("q2", o -> o.getQ2().orElse(null), Qualifying::setQ2);
    /**
     * This Field corresponds to the {@link Qualifying} field that can be
     * obtained using the {@link Qualifying#getQ3()} method.
     */
    public final static StringField<Qualifying> Q3 = new StringFieldImpl<>("q3", o -> o.getQ3().orElse(null), Qualifying::setQ3);
    
    /**
     * Returns the qualifyId of this Qualifying. The qualifyId field corresponds
     * to the database column db0.F1APP.qualifying.qualifyId.
     * 
     * @return the qualifyId of this Qualifying
     */
    Integer getQualifyId();
    
    /**
     * Returns the raceId of this Qualifying. The raceId field corresponds to the
     * database column db0.F1APP.qualifying.raceId.
     * 
     * @return the raceId of this Qualifying
     */
    Integer getRaceId();
    
    /**
     * Returns the driverId of this Qualifying. The driverId field corresponds to
     * the database column db0.F1APP.qualifying.driverId.
     * 
     * @return the driverId of this Qualifying
     */
    Integer getDriverId();
    
    /**
     * Returns the constructorId of this Qualifying. The constructorId field
     * corresponds to the database column db0.F1APP.qualifying.constructorId.
     * 
     * @return the constructorId of this Qualifying
     */
    Integer getConstructorId();
    
    /**
     * Returns the number of this Qualifying. The number field corresponds to the
     * database column db0.F1APP.qualifying.number.
     * 
     * @return the number of this Qualifying
     */
    Integer getNumber();
    
    /**
     * Returns the position of this Qualifying. The position field corresponds to
     * the database column db0.F1APP.qualifying.position.
     * 
     * @return the position of this Qualifying
     */
    Optional<Integer> getPosition();
    
    /**
     * Returns the q1 of this Qualifying. The q1 field corresponds to the
     * database column db0.F1APP.qualifying.q1.
     * 
     * @return the q1 of this Qualifying
     */
    Optional<String> getQ1();
    
    /**
     * Returns the q2 of this Qualifying. The q2 field corresponds to the
     * database column db0.F1APP.qualifying.q2.
     * 
     * @return the q2 of this Qualifying
     */
    Optional<String> getQ2();
    
    /**
     * Returns the q3 of this Qualifying. The q3 field corresponds to the
     * database column db0.F1APP.qualifying.q3.
     * 
     * @return the q3 of this Qualifying
     */
    Optional<String> getQ3();
    
    /**
     * Sets the qualifyId of this Qualifying. The qualifyId field corresponds to
     * the database column db0.F1APP.qualifying.qualifyId.
     * 
     * @param qualifyId to set of this Qualifying
     * @return this Qualifying instance
     */
    Qualifying setQualifyId(Integer qualifyId);
    
    /**
     * Sets the raceId of this Qualifying. The raceId field corresponds to the
     * database column db0.F1APP.qualifying.raceId.
     * 
     * @param raceId to set of this Qualifying
     * @return this Qualifying instance
     */
    Qualifying setRaceId(Integer raceId);
    
    /**
     * Sets the driverId of this Qualifying. The driverId field corresponds to
     * the database column db0.F1APP.qualifying.driverId.
     * 
     * @param driverId to set of this Qualifying
     * @return this Qualifying instance
     */
    Qualifying setDriverId(Integer driverId);
    
    /**
     * Sets the constructorId of this Qualifying. The constructorId field
     * corresponds to the database column db0.F1APP.qualifying.constructorId.
     * 
     * @param constructorId to set of this Qualifying
     * @return this Qualifying instance
     */
    Qualifying setConstructorId(Integer constructorId);
    
    /**
     * Sets the number of this Qualifying. The number field corresponds to the
     * database column db0.F1APP.qualifying.number.
     * 
     * @param number to set of this Qualifying
     * @return this Qualifying instance
     */
    Qualifying setNumber(Integer number);
    
    /**
     * Sets the position of this Qualifying. The position field corresponds to
     * the database column db0.F1APP.qualifying.position.
     * 
     * @param position to set of this Qualifying
     * @return this Qualifying instance
     */
    Qualifying setPosition(Integer position);
    
    /**
     * Sets the q1 of this Qualifying. The q1 field corresponds to the database
     * column db0.F1APP.qualifying.q1.
     * 
     * @param q1 to set of this Qualifying
     * @return this Qualifying instance
     */
    Qualifying setQ1(String q1);
    
    /**
     * Sets the q2 of this Qualifying. The q2 field corresponds to the database
     * column db0.F1APP.qualifying.q2.
     * 
     * @param q2 to set of this Qualifying
     * @return this Qualifying instance
     */
    Qualifying setQ2(String q2);
    
    /**
     * Sets the q3 of this Qualifying. The q3 field corresponds to the database
     * column db0.F1APP.qualifying.q3.
     * 
     * @param q3 to set of this Qualifying
     * @return this Qualifying instance
     */
    Qualifying setQ3(String q3);
}