package com.company.speedment.test.f1app.db0.f1app.qualifying.impl;

import com.company.speedment.test.f1app.db0.f1app.qualifying.Qualifying;
import com.speedment.Speedment;
import com.speedment.internal.core.code.AbstractBaseEntity;
import java.util.Objects;
import java.util.Optional;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * An implementation representing an entity (for example, a row) in the
 * com.speedment.internal.ui.config.TableProperty@5625d157.
 * <p>
 * This Class or Interface has been automatically generated by Speedment. Any
 * changes made to this Class or Interface will be overwritten.
 * 
 * @author Speedment
 */
@Generated("Speedment")
public final class QualifyingImpl extends AbstractBaseEntity<Qualifying> implements Qualifying {
    
    private Integer qualifyId;
    private Integer raceId;
    private Integer driverId;
    private Integer constructorId;
    private Integer number;
    private Integer position;
    private String q1;
    private String q2;
    private String q3;
    
    QualifyingImpl(Speedment speedment) {
        super(speedment);
    }
    
    public QualifyingImpl(Speedment speedment, final Qualifying qualifying) {
        super(speedment);
        setQualifyId(qualifying.getQualifyId());
        setRaceId(qualifying.getRaceId());
        setDriverId(qualifying.getDriverId());
        setConstructorId(qualifying.getConstructorId());
        setNumber(qualifying.getNumber());
        qualifying.getPosition().ifPresent(this::setPosition);
        qualifying.getQ1().ifPresent(this::setQ1);
        qualifying.getQ2().ifPresent(this::setQ2);
        qualifying.getQ3().ifPresent(this::setQ3);
    }
    
    @Override
    public Integer getQualifyId() {
        return qualifyId;
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
    public Integer getConstructorId() {
        return constructorId;
    }
    
    @Override
    public Integer getNumber() {
        return number;
    }
    
    @Override
    public Optional<Integer> getPosition() {
        return Optional.ofNullable(position);
    }
    
    @Override
    public Optional<String> getQ1() {
        return Optional.ofNullable(q1);
    }
    
    @Override
    public Optional<String> getQ2() {
        return Optional.ofNullable(q2);
    }
    
    @Override
    public Optional<String> getQ3() {
        return Optional.ofNullable(q3);
    }
    
    @Override
    public final QualifyingImpl setQualifyId(Integer qualifyId) {
        this.qualifyId = qualifyId;
        return this;
    }
    
    @Override
    public final QualifyingImpl setRaceId(Integer raceId) {
        this.raceId = raceId;
        return this;
    }
    
    @Override
    public final QualifyingImpl setDriverId(Integer driverId) {
        this.driverId = driverId;
        return this;
    }
    
    @Override
    public final QualifyingImpl setConstructorId(Integer constructorId) {
        this.constructorId = constructorId;
        return this;
    }
    
    @Override
    public final QualifyingImpl setNumber(Integer number) {
        this.number = number;
        return this;
    }
    
    @Override
    public final QualifyingImpl setPosition(Integer position) {
        this.position = position;
        return this;
    }
    
    @Override
    public final QualifyingImpl setQ1(String q1) {
        this.q1 = q1;
        return this;
    }
    
    @Override
    public final QualifyingImpl setQ2(String q2) {
        this.q2 = q2;
        return this;
    }
    
    @Override
    public final QualifyingImpl setQ3(String q3) {
        this.q3 = q3;
        return this;
    }
    
    @Override
    public Qualifying copy() {
        return new QualifyingImpl(getSpeedment_(), this);
    }
    
    @Override
    public String toString() {
        final StringJoiner sj = new StringJoiner(", ", "{ ", " }");
        sj.add("qualifyId = "+Objects.toString(getQualifyId()));
        sj.add("raceId = "+Objects.toString(getRaceId()));
        sj.add("driverId = "+Objects.toString(getDriverId()));
        sj.add("constructorId = "+Objects.toString(getConstructorId()));
        sj.add("number = "+Objects.toString(getNumber()));
        sj.add("position = "+Objects.toString(getPosition().orElse(null)));
        sj.add("q1 = "+Objects.toString(getQ1().orElse(null)));
        sj.add("q2 = "+Objects.toString(getQ2().orElse(null)));
        sj.add("q3 = "+Objects.toString(getQ3().orElse(null)));
        return "QualifyingImpl "+sj.toString();
    }
    
    @Override
    public boolean equals(Object that) {
        if (this == that) { return true; }
        if (!(that instanceof Qualifying)) { return false; }
        @SuppressWarnings("unchecked")
        final Qualifying thatQualifying = (Qualifying)that;
        if (!Objects.equals(this.getQualifyId(), thatQualifying.getQualifyId())) {return false; }
        if (!Objects.equals(this.getRaceId(), thatQualifying.getRaceId())) {return false; }
        if (!Objects.equals(this.getDriverId(), thatQualifying.getDriverId())) {return false; }
        if (!Objects.equals(this.getConstructorId(), thatQualifying.getConstructorId())) {return false; }
        if (!Objects.equals(this.getNumber(), thatQualifying.getNumber())) {return false; }
        if (!Objects.equals(this.getPosition(), thatQualifying.getPosition())) {return false; }
        if (!Objects.equals(this.getQ1(), thatQualifying.getQ1())) {return false; }
        if (!Objects.equals(this.getQ2(), thatQualifying.getQ2())) {return false; }
        if (!Objects.equals(this.getQ3(), thatQualifying.getQ3())) {return false; }
        return true;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(getQualifyId());
        hash = 31 * hash + Objects.hashCode(getRaceId());
        hash = 31 * hash + Objects.hashCode(getDriverId());
        hash = 31 * hash + Objects.hashCode(getConstructorId());
        hash = 31 * hash + Objects.hashCode(getNumber());
        hash = 31 * hash + Objects.hashCode(getPosition());
        hash = 31 * hash + Objects.hashCode(getQ1());
        hash = 31 * hash + Objects.hashCode(getQ2());
        hash = 31 * hash + Objects.hashCode(getQ3());
        return hash;
    }
    
    @Override
    public Class<Qualifying> getEntityClass_() {
        return Qualifying.class;
    }
}