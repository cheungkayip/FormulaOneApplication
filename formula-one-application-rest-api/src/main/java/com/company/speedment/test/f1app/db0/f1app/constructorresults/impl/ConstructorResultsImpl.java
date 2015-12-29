package com.company.speedment.test.f1app.db0.f1app.constructorresults.impl;

import com.company.speedment.test.f1app.db0.f1app.constructorresults.ConstructorResults;
import com.speedment.Speedment;
import com.speedment.internal.core.code.AbstractBaseEntity;
import java.util.Objects;
import java.util.Optional;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * An implementation representing an entity (for example, a row) in the
 * com.speedment.internal.ui.config.TableProperty@1cc05b.
 * <p>
 * This Class or Interface has been automatically generated by Speedment. Any
 * changes made to this Class or Interface will be overwritten.
 * 
 * @author Speedment
 */
@Generated("Speedment")
public final class ConstructorResultsImpl extends AbstractBaseEntity<ConstructorResults> implements ConstructorResults {
    
    private Integer constructorResultsId;
    private Integer raceId;
    private Integer constructorId;
    private Float points;
    private String status;
    
    ConstructorResultsImpl(Speedment speedment) {
        super(speedment);
    }
    
    public ConstructorResultsImpl(Speedment speedment, final ConstructorResults constructorResults) {
        super(speedment);
        setConstructorResultsId(constructorResults.getConstructorResultsId());
        setRaceId(constructorResults.getRaceId());
        setConstructorId(constructorResults.getConstructorId());
        constructorResults.getPoints().ifPresent(this::setPoints);
        constructorResults.getStatus().ifPresent(this::setStatus);
    }
    
    @Override
    public Integer getConstructorResultsId() {
        return constructorResultsId;
    }
    
    @Override
    public Integer getRaceId() {
        return raceId;
    }
    
    @Override
    public Integer getConstructorId() {
        return constructorId;
    }
    
    @Override
    public Optional<Float> getPoints() {
        return Optional.ofNullable(points);
    }
    
    @Override
    public Optional<String> getStatus() {
        return Optional.ofNullable(status);
    }
    
    @Override
    public final ConstructorResultsImpl setConstructorResultsId(Integer constructorResultsId) {
        this.constructorResultsId = constructorResultsId;
        return this;
    }
    
    @Override
    public final ConstructorResultsImpl setRaceId(Integer raceId) {
        this.raceId = raceId;
        return this;
    }
    
    @Override
    public final ConstructorResultsImpl setConstructorId(Integer constructorId) {
        this.constructorId = constructorId;
        return this;
    }
    
    @Override
    public final ConstructorResultsImpl setPoints(Float points) {
        this.points = points;
        return this;
    }
    
    @Override
    public final ConstructorResultsImpl setStatus(String status) {
        this.status = status;
        return this;
    }
    
    @Override
    public ConstructorResults copy() {
        return new ConstructorResultsImpl(getSpeedment_(), this);
    }
    
    @Override
    public String toString() {
        final StringJoiner sj = new StringJoiner(", ", "{ ", " }");
        sj.add("constructorResultsId = "+Objects.toString(getConstructorResultsId()));
        sj.add("raceId = "+Objects.toString(getRaceId()));
        sj.add("constructorId = "+Objects.toString(getConstructorId()));
        sj.add("points = "+Objects.toString(getPoints().orElse(null)));
        sj.add("status = "+Objects.toString(getStatus().orElse(null)));
        return "ConstructorResultsImpl "+sj.toString();
    }
    
    @Override
    public boolean equals(Object that) {
        if (this == that) { return true; }
        if (!(that instanceof ConstructorResults)) { return false; }
        @SuppressWarnings("unchecked")
        final ConstructorResults thatConstructorResults = (ConstructorResults)that;
        if (!Objects.equals(this.getConstructorResultsId(), thatConstructorResults.getConstructorResultsId())) {return false; }
        if (!Objects.equals(this.getRaceId(), thatConstructorResults.getRaceId())) {return false; }
        if (!Objects.equals(this.getConstructorId(), thatConstructorResults.getConstructorId())) {return false; }
        if (!Objects.equals(this.getPoints(), thatConstructorResults.getPoints())) {return false; }
        if (!Objects.equals(this.getStatus(), thatConstructorResults.getStatus())) {return false; }
        return true;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(getConstructorResultsId());
        hash = 31 * hash + Objects.hashCode(getRaceId());
        hash = 31 * hash + Objects.hashCode(getConstructorId());
        hash = 31 * hash + Objects.hashCode(getPoints());
        hash = 31 * hash + Objects.hashCode(getStatus());
        return hash;
    }
    
    @Override
    public Class<ConstructorResults> getEntityClass_() {
        return ConstructorResults.class;
    }
}