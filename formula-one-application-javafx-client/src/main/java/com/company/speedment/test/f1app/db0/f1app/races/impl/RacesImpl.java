package com.company.speedment.test.f1app.db0.f1app.races.impl;

import com.company.speedment.test.f1app.db0.f1app.races.Races;
import com.speedment.Speedment;
import com.speedment.internal.core.code.AbstractBaseEntity;
import java.sql.Date;
import java.sql.Time;
import java.util.Objects;
import java.util.Optional;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * An implementation representing an entity (for example, a row) in the
 * com.speedment.internal.ui.config.TableProperty@61308848.
 * <p>
 * This Class or Interface has been automatically generated by Speedment. Any
 * changes made to this Class or Interface will be overwritten.
 * 
 * @author Speedment
 */
@Generated("Speedment")
public final class RacesImpl extends AbstractBaseEntity<Races> implements Races {
    
    private Integer raceId;
    private Integer year;
    private Integer round;
    private Integer circuitId;
    private String name;
    private Date date;
    private Time time;
    private String url;
    
    RacesImpl(Speedment speedment) {
        super(speedment);
    }
    
    public RacesImpl(Speedment speedment, final Races races) {
        super(speedment);
        setRaceId(races.getRaceId());
        setYear(races.getYear());
        setRound(races.getRound());
        setCircuitId(races.getCircuitId());
        setName(races.getName());
        setDate(races.getDate());
        races.getTime().ifPresent(this::setTime);
        races.getUrl().ifPresent(this::setUrl);
    }
    
    @Override
    public Integer getRaceId() {
        return raceId;
    }
    
    @Override
    public Integer getYear() {
        return year;
    }
    
    @Override
    public Integer getRound() {
        return round;
    }
    
    @Override
    public Integer getCircuitId() {
        return circuitId;
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public Date getDate() {
        return date;
    }
    
    @Override
    public Optional<Time> getTime() {
        return Optional.ofNullable(time);
    }
    
    @Override
    public Optional<String> getUrl() {
        return Optional.ofNullable(url);
    }
    
    @Override
    public final RacesImpl setRaceId(Integer raceId) {
        this.raceId = raceId;
        return this;
    }
    
    @Override
    public final RacesImpl setYear(Integer year) {
        this.year = year;
        return this;
    }
    
    @Override
    public final RacesImpl setRound(Integer round) {
        this.round = round;
        return this;
    }
    
    @Override
    public final RacesImpl setCircuitId(Integer circuitId) {
        this.circuitId = circuitId;
        return this;
    }
    
    @Override
    public final RacesImpl setName(String name) {
        this.name = name;
        return this;
    }
    
    @Override
    public final RacesImpl setDate(Date date) {
        this.date = date;
        return this;
    }
    
    @Override
    public final RacesImpl setTime(Time time) {
        this.time = time;
        return this;
    }
    
    @Override
    public final RacesImpl setUrl(String url) {
        this.url = url;
        return this;
    }
    
    @Override
    public Races copy() {
        return new RacesImpl(getSpeedment_(), this);
    }
    
    @Override
    public String toString() {
        final StringJoiner sj = new StringJoiner(", ", "{ ", " }");
        sj.add("raceId = "+Objects.toString(getRaceId()));
        sj.add("year = "+Objects.toString(getYear()));
        sj.add("round = "+Objects.toString(getRound()));
        sj.add("circuitId = "+Objects.toString(getCircuitId()));
        sj.add("name = "+Objects.toString(getName()));
        sj.add("date = "+Objects.toString(getDate()));
        sj.add("time = "+Objects.toString(getTime().orElse(null)));
        sj.add("url = "+Objects.toString(getUrl().orElse(null)));
        return "RacesImpl "+sj.toString();
    }
    
    @Override
    public boolean equals(Object that) {
        if (this == that) { return true; }
        if (!(that instanceof Races)) { return false; }
        @SuppressWarnings("unchecked")
        final Races thatRaces = (Races)that;
        if (!Objects.equals(this.getRaceId(), thatRaces.getRaceId())) {return false; }
        if (!Objects.equals(this.getYear(), thatRaces.getYear())) {return false; }
        if (!Objects.equals(this.getRound(), thatRaces.getRound())) {return false; }
        if (!Objects.equals(this.getCircuitId(), thatRaces.getCircuitId())) {return false; }
        if (!Objects.equals(this.getName(), thatRaces.getName())) {return false; }
        if (!Objects.equals(this.getDate(), thatRaces.getDate())) {return false; }
        if (!Objects.equals(this.getTime(), thatRaces.getTime())) {return false; }
        if (!Objects.equals(this.getUrl(), thatRaces.getUrl())) {return false; }
        return true;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(getRaceId());
        hash = 31 * hash + Objects.hashCode(getYear());
        hash = 31 * hash + Objects.hashCode(getRound());
        hash = 31 * hash + Objects.hashCode(getCircuitId());
        hash = 31 * hash + Objects.hashCode(getName());
        hash = 31 * hash + Objects.hashCode(getDate());
        hash = 31 * hash + Objects.hashCode(getTime());
        hash = 31 * hash + Objects.hashCode(getUrl());
        return hash;
    }
    
    @Override
    public Class<Races> getEntityClass_() {
        return Races.class;
    }
}