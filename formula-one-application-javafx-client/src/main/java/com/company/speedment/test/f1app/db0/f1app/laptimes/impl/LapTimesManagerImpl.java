package com.company.speedment.test.f1app.db0.f1app.laptimes.impl;

import com.company.speedment.test.f1app.db0.f1app.laptimes.LapTimes;
import com.speedment.Speedment;
import com.speedment.config.Column;
import com.speedment.config.Table;
import com.speedment.config.mapper.TypeMapper;
import com.speedment.exception.SpeedmentException;
import com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper;
import com.speedment.internal.core.config.mapper.identity.StringIdentityMapper;
import com.speedment.internal.core.manager.sql.AbstractSqlManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;

/**
 * A manager implementation representing an entity (for example, a row) in
 * the com.speedment.internal.ui.config.TableProperty@4bc5eae.
 * <p>
 * This Class or Interface has been automatically generated by Speedment. Any
 * changes made to this Class or Interface will be overwritten.
 * 
 * @author Speedment
 */
@Generated("Speedment")
public class LapTimesManagerImpl extends AbstractSqlManager<LapTimes> {
    
    private final TypeMapper<Integer, Integer> raceIdTypeMapper = new IntegerIdentityMapper();
    private final TypeMapper<Integer, Integer> driverIdTypeMapper = new IntegerIdentityMapper();
    private final TypeMapper<Integer, Integer> lapTypeMapper = new IntegerIdentityMapper();
    private final TypeMapper<Integer, Integer> positionTypeMapper = new IntegerIdentityMapper();
    private final TypeMapper<String, String> timeTypeMapper = new StringIdentityMapper();
    private final TypeMapper<Integer, Integer> millisecondsTypeMapper = new IntegerIdentityMapper();
    
    public LapTimesManagerImpl(Speedment speedment) {
        super(speedment);
        setSqlEntityMapper(this::defaultReadEntity);
    }
    
    @Override
    public Class<LapTimes> getEntityClass() {
        return LapTimes.class;
    }
    
    @Override
    public Object get(LapTimes entity, Column column) {
        switch (column.getName()) {
            case "raceId" : return entity.getRaceId();
            case "driverId" : return entity.getDriverId();
            case "lap" : return entity.getLap();
            case "position" : return entity.getPosition();
            case "time" : return entity.getTime();
            case "milliseconds" : return entity.getMilliseconds();
            default : throw new IllegalArgumentException("Unknown column '" + column.getName() + "'.");
        }
    }
    
    @Override
    public void set(LapTimes entity, Column column, Object value) {
        switch (column.getName()) {
            case "raceId" : entity.setRaceId((Integer) value); break;
            case "driverId" : entity.setDriverId((Integer) value); break;
            case "lap" : entity.setLap((Integer) value); break;
            case "position" : entity.setPosition((Integer) value); break;
            case "time" : entity.setTime((String) value); break;
            case "milliseconds" : entity.setMilliseconds((Integer) value); break;
            default : throw new IllegalArgumentException("Unknown column '" + column.getName() + "'.");
        }
    }
    
    @Override
    public Table getTable() {
        return speedment.getProjectComponent().getProject().findTableByName("db0.F1APP.lapTimes");
    }
    
    protected LapTimes defaultReadEntity(ResultSet resultSet) {
        final LapTimes entity = newInstance();
        try {
            entity.setRaceId(raceIdTypeMapper.toJavaType(resultSet.getInt(1)));
            entity.setDriverId(driverIdTypeMapper.toJavaType(resultSet.getInt(2)));
            entity.setLap(lapTypeMapper.toJavaType(resultSet.getInt(3)));
            entity.setPosition(positionTypeMapper.toJavaType(getInt(resultSet, 4)));
            entity.setTime(timeTypeMapper.toJavaType(resultSet.getString(5)));
            entity.setMilliseconds(millisecondsTypeMapper.toJavaType(getInt(resultSet, 6)));
        }
        catch (SQLException sqle) {
            throw new SpeedmentException(sqle);
        }
        return entity;
    }
    
    @Override
    public LapTimes newInstance() {
        return new LapTimesImpl(speedment);
    }
    
    @Override
    public List<Integer> primaryKeyFor(LapTimes entity) {
        return Arrays.asList(entity.getRaceId(), entity.getDriverId(), entity.getLap());
    }
}