package com.company.speedment.test.f1app.db0.f1app.pitstops.impl;

import com.company.speedment.test.f1app.db0.f1app.pitstops.PitStops;
import com.speedment.Speedment;
import com.speedment.config.Column;
import com.speedment.config.Table;
import com.speedment.config.mapper.TypeMapper;
import com.speedment.exception.SpeedmentException;
import com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper;
import com.speedment.internal.core.config.mapper.identity.StringIdentityMapper;
import com.speedment.internal.core.config.mapper.identity.TimeIdentityMapper;
import com.speedment.internal.core.manager.sql.AbstractSqlManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;

/**
 * A manager implementation representing an entity (for example, a row) in
 * the Table 'f1app.db0.F1APP.pitStops'.
 * <p>
 * This Class or Interface has been automatically generated by Speedment. Any
 * changes made to this Class or Interface will be overwritten.
 * 
 * @author Speedment
 */
@Generated("Speedment")
public class PitStopsManagerImpl extends AbstractSqlManager<PitStops> {
    
    private final TypeMapper<Integer, Integer> raceIdTypeMapper = new IntegerIdentityMapper();
    private final TypeMapper<Integer, Integer> driverIdTypeMapper = new IntegerIdentityMapper();
    private final TypeMapper<Integer, Integer> stopTypeMapper = new IntegerIdentityMapper();
    private final TypeMapper<Integer, Integer> lapTypeMapper = new IntegerIdentityMapper();
    private final TypeMapper<Time, Time> timeTypeMapper = new TimeIdentityMapper();
    private final TypeMapper<String, String> durationTypeMapper = new StringIdentityMapper();
    private final TypeMapper<Integer, Integer> millisecondsTypeMapper = new IntegerIdentityMapper();
    
    public PitStopsManagerImpl(Speedment speedment) {
        super(speedment);
        setSqlEntityMapper(this::defaultReadEntity);
    }
    
    @Override
    public Class<PitStops> getEntityClass() {
        return PitStops.class;
    }
    
    @Override
    public Object get(PitStops entity, Column column) {
        switch (column.getName()) {
            case "raceId" : return entity.getRaceId();
            case "driverId" : return entity.getDriverId();
            case "stop" : return entity.getStop();
            case "lap" : return entity.getLap();
            case "time" : return entity.getTime();
            case "duration" : return entity.getDuration();
            case "milliseconds" : return entity.getMilliseconds();
            default : throw new IllegalArgumentException("Unknown column '" + column.getName() + "'.");
        }
    }
    
    @Override
    public void set(PitStops entity, Column column, Object value) {
        switch (column.getName()) {
            case "raceId" : entity.setRaceId((Integer) value); break;
            case "driverId" : entity.setDriverId((Integer) value); break;
            case "stop" : entity.setStop((Integer) value); break;
            case "lap" : entity.setLap((Integer) value); break;
            case "time" : entity.setTime((Time) value); break;
            case "duration" : entity.setDuration((String) value); break;
            case "milliseconds" : entity.setMilliseconds((Integer) value); break;
            default : throw new IllegalArgumentException("Unknown column '" + column.getName() + "'.");
        }
    }
    
    @Override
    public Table getTable() {
        return speedment.getProjectComponent().getProject().findTableByName("db0.F1APP.pitStops");
    }
    
    protected PitStops defaultReadEntity(ResultSet resultSet) {
        final PitStops entity = newInstance();
        try {
            entity.setRaceId(raceIdTypeMapper.toJavaType(resultSet.getInt(1)));
            entity.setDriverId(driverIdTypeMapper.toJavaType(resultSet.getInt(2)));
            entity.setStop(stopTypeMapper.toJavaType(resultSet.getInt(3)));
            entity.setLap(lapTypeMapper.toJavaType(resultSet.getInt(4)));
            entity.setTime(timeTypeMapper.toJavaType(resultSet.getTime(5)));
            entity.setDuration(durationTypeMapper.toJavaType(resultSet.getString(6)));
            entity.setMilliseconds(millisecondsTypeMapper.toJavaType(getInt(resultSet, 7)));
        }
        catch (SQLException sqle) {
            throw new SpeedmentException(sqle);
        }
        return entity;
    }
    
    @Override
    public PitStops newInstance() {
        return new PitStopsImpl(speedment);
    }
    
    @Override
    public List<Integer> primaryKeyFor(PitStops entity) {
        return Arrays.asList(entity.getRaceId(), entity.getDriverId(), entity.getStop());
    }
}