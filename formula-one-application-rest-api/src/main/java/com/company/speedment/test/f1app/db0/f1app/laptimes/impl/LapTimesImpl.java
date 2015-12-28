package com.company.speedment.test.f1app.db0.f1app.laptimes.impl;

import com.company.speedment.test.f1app.db0.f1app.laptimes.LapTimes;
import com.speedment.Speedment;
import com.speedment.internal.core.code.AbstractBaseEntity;
import java.util.Objects;
import java.util.Optional;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * An implementation representing an entity (for example, a row) in the Table
 * 'f1app.db0.F1APP.lapTimes'.
 * <p>
 * This Class or Interface has been automatically generated by Speedment. Any
 * changes made to this Class or Interface will be overwritten.
 * 
 * @author Speedment
 */
@Generated("Speedment")
public final class LapTimesImpl extends AbstractBaseEntity<LapTimes> implements LapTimes {
    
    private Integer raceId;
    private Integer driverId;
    private Integer lap;
    private Integer position;
    private String time;
    private Integer milliseconds;
    
    LapTimesImpl(Speedment speedment) {
        super(speedment);
    }
    
    public LapTimesImpl(Speedment speedment, final LapTimes lapTimes) {
        super(speedment);
        setRaceId(lapTimes.getRaceId());
        setDriverId(lapTimes.getDriverId());
        setLap(lapTimes.getLap());
        lapTimes.getPosition().ifPresent(this::setPosition);
        lapTimes.getTime().ifPresent(this::setTime);
        lapTimes.getMilliseconds().ifPresent(this::setMilliseconds);
    }
    
    @Override
    public Integer getRaceId() {
        return raceId;
    }
    
    @Override
    public Integer getDriverId() {
        return driverId;
    }
    
    @Override
    public Integer getLap() {
        return lap;
    }
    
    @Override
    public Optional<Integer> getPosition() {
        return Optional.ofNullable(position);
    }
    
    @Override
    public Optional<String> getTime() {
        return Optional.ofNullable(time);
    }
    
    @Override
    public Optional<Integer> getMilliseconds() {
        return Optional.ofNullable(milliseconds);
    }
    
    @Override
    public final LapTimesImpl setRaceId(Integer raceId) {
        this.raceId = raceId;
        return this;
    }
    
    @Override
    public final LapTimesImpl setDriverId(Integer driverId) {
        this.driverId = driverId;
        return this;
    }
    
    @Override
    public final LapTimesImpl setLap(Integer lap) {
        this.lap = lap;
        return this;
    }
    
    @Override
    public final LapTimesImpl setPosition(Integer position) {
        this.position = position;
        return this;
    }
    
    @Override
    public final LapTimesImpl setTime(String time) {
        this.time = time;
        return this;
    }
    
    @Override
    public final LapTimesImpl setMilliseconds(Integer milliseconds) {
        this.milliseconds = milliseconds;
        return this;
    }
    
    @Override
    public LapTimes copy() {
        return new LapTimesImpl(getSpeedment_(), this);
    }
    
    @Override
    public String toString() {
        final StringJoiner sj = new StringJoiner(", ", "{ ", " }");
        sj.add("raceId = "+Objects.toString(getRaceId()));
        sj.add("driverId = "+Objects.toString(getDriverId()));
        sj.add("lap = "+Objects.toString(getLap()));
        sj.add("position = "+Objects.toString(getPosition().orElse(null)));
        sj.add("time = "+Objects.toString(getTime().orElse(null)));
        sj.add("milliseconds = "+Objects.toString(getMilliseconds().orElse(null)));
        return "LapTimesImpl "+sj.toString();
    }
    
    @Override
    public boolean equals(Object that) {
        if (this == that) { return true; }
        if (!(that instanceof LapTimes)) { return false; }
        @SuppressWarnings("unchecked")
        final LapTimes thatLapTimes = (LapTimes)that;
        if (!Objects.equals(this.getRaceId(), thatLapTimes.getRaceId())) {return false; }
        if (!Objects.equals(this.getDriverId(), thatLapTimes.getDriverId())) {return false; }
        if (!Objects.equals(this.getLap(), thatLapTimes.getLap())) {return false; }
        if (!Objects.equals(this.getPosition(), thatLapTimes.getPosition())) {return false; }
        if (!Objects.equals(this.getTime(), thatLapTimes.getTime())) {return false; }
        if (!Objects.equals(this.getMilliseconds(), thatLapTimes.getMilliseconds())) {return false; }
        return true;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(getRaceId());
        hash = 31 * hash + Objects.hashCode(getDriverId());
        hash = 31 * hash + Objects.hashCode(getLap());
        hash = 31 * hash + Objects.hashCode(getPosition());
        hash = 31 * hash + Objects.hashCode(getTime());
        hash = 31 * hash + Objects.hashCode(getMilliseconds());
        return hash;
    }
    
    @Override
    public Class<LapTimes> getEntityClass_() {
        return LapTimes.class;
    }
}