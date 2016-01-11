package com.company.speedment.test.f1app.db0.f1app.races.impl;

import com.company.speedment.test.f1app.db0.f1app.races.Races;
import com.speedment.Speedment;
import com.speedment.config.Column;
import com.speedment.config.Table;
import com.speedment.config.mapper.TypeMapper;
import com.speedment.exception.SpeedmentException;
import com.speedment.internal.core.config.mapper.identity.DateIdentityMapper;
import com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper;
import com.speedment.internal.core.config.mapper.identity.StringIdentityMapper;
import com.speedment.internal.core.config.mapper.identity.TimeIdentityMapper;
import com.speedment.internal.core.manager.sql.AbstractSqlManager;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import javax.annotation.Generated;

/**
 * A manager implementation representing an entity (for example, a row) in
 * the com.speedment.internal.ui.config.TableProperty@61308848.
 * <p>
 * This Class or Interface has been automatically generated by Speedment. Any
 * changes made to this Class or Interface will be overwritten.
 * 
 * @author Speedment
 */
@Generated("Speedment")
public class RacesManagerImpl extends AbstractSqlManager<Races> {
    
    private final TypeMapper<Integer, Integer> raceIdTypeMapper = new IntegerIdentityMapper();
    private final TypeMapper<Integer, Integer> yearTypeMapper = new IntegerIdentityMapper();
    private final TypeMapper<Integer, Integer> roundTypeMapper = new IntegerIdentityMapper();
    private final TypeMapper<Integer, Integer> circuitIdTypeMapper = new IntegerIdentityMapper();
    private final TypeMapper<String, String> nameTypeMapper = new StringIdentityMapper();
    private final TypeMapper<Date, Date> dateTypeMapper = new DateIdentityMapper();
    private final TypeMapper<Time, Time> timeTypeMapper = new TimeIdentityMapper();
    private final TypeMapper<String, String> urlTypeMapper = new StringIdentityMapper();
    
    public RacesManagerImpl(Speedment speedment) {
        super(speedment);
        setSqlEntityMapper(this::defaultReadEntity);
    }
    
    @Override
    public Class<Races> getEntityClass() {
        return Races.class;
    }
    
    @Override
    public Object get(Races entity, Column column) {
        switch (column.getName()) {
            case "raceId" : return entity.getRaceId();
            case "year" : return entity.getYear();
            case "round" : return entity.getRound();
            case "circuitId" : return entity.getCircuitId();
            case "name" : return entity.getName();
            case "date" : return entity.getDate();
            case "time" : return entity.getTime();
            case "url" : return entity.getUrl();
            default : throw new IllegalArgumentException("Unknown column '" + column.getName() + "'.");
        }
    }
    
    @Override
    public void set(Races entity, Column column, Object value) {
        switch (column.getName()) {
            case "raceId" : entity.setRaceId((Integer) value); break;
            case "year" : entity.setYear((Integer) value); break;
            case "round" : entity.setRound((Integer) value); break;
            case "circuitId" : entity.setCircuitId((Integer) value); break;
            case "name" : entity.setName((String) value); break;
            case "date" : entity.setDate((Date) value); break;
            case "time" : entity.setTime((Time) value); break;
            case "url" : entity.setUrl((String) value); break;
            default : throw new IllegalArgumentException("Unknown column '" + column.getName() + "'.");
        }
    }
    
    @Override
    public Table getTable() {
        return speedment.getProjectComponent().getProject().findTableByName("db0.F1APP.races");
    }
    
    protected Races defaultReadEntity(ResultSet resultSet) {
        final Races entity = newInstance();
        try {
            entity.setRaceId(raceIdTypeMapper.toJavaType(resultSet.getInt(1)));
            entity.setYear(yearTypeMapper.toJavaType(resultSet.getInt(2)));
            entity.setRound(roundTypeMapper.toJavaType(resultSet.getInt(3)));
            entity.setCircuitId(circuitIdTypeMapper.toJavaType(resultSet.getInt(4)));
            entity.setName(nameTypeMapper.toJavaType(resultSet.getString(5)));
            entity.setDate(dateTypeMapper.toJavaType(resultSet.getDate(6)));
            entity.setTime(timeTypeMapper.toJavaType(resultSet.getTime(7)));
            entity.setUrl(urlTypeMapper.toJavaType(resultSet.getString(8)));
        }
        catch (SQLException sqle) {
            throw new SpeedmentException(sqle);
        }
        return entity;
    }
    
    @Override
    public Races newInstance() {
        return new RacesImpl(speedment);
    }
    
    @Override
    public Integer primaryKeyFor(Races entity) {
        return entity.getRaceId();
    }
}