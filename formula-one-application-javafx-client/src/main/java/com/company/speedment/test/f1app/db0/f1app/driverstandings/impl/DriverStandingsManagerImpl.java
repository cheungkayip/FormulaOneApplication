package com.company.speedment.test.f1app.db0.f1app.driverstandings.impl;

import com.company.speedment.test.f1app.db0.f1app.driverstandings.DriverStandings;
import com.speedment.Speedment;
import com.speedment.config.Column;
import com.speedment.config.Table;
import com.speedment.config.mapper.TypeMapper;
import com.speedment.exception.SpeedmentException;
import com.speedment.internal.core.config.mapper.identity.FloatIdentityMapper;
import com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper;
import com.speedment.internal.core.config.mapper.identity.StringIdentityMapper;
import com.speedment.internal.core.manager.sql.AbstractSqlManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.annotation.Generated;

/**
 * A manager implementation representing an entity (for example, a row) in
 * the com.speedment.internal.ui.config.TableProperty@dd7c5fa.
 * <p>
 * This Class or Interface has been automatically generated by Speedment. Any
 * changes made to this Class or Interface will be overwritten.
 * 
 * @author Speedment
 */
@Generated("Speedment")
public class DriverStandingsManagerImpl extends AbstractSqlManager<DriverStandings> {
    
    private final TypeMapper<Integer, Integer> driverStandingsIdTypeMapper = new IntegerIdentityMapper();
    private final TypeMapper<Integer, Integer> raceIdTypeMapper = new IntegerIdentityMapper();
    private final TypeMapper<Integer, Integer> driverIdTypeMapper = new IntegerIdentityMapper();
    private final TypeMapper<Float, Float> pointsTypeMapper = new FloatIdentityMapper();
    private final TypeMapper<Integer, Integer> positionTypeMapper = new IntegerIdentityMapper();
    private final TypeMapper<String, String> positionTextTypeMapper = new StringIdentityMapper();
    private final TypeMapper<Integer, Integer> winsTypeMapper = new IntegerIdentityMapper();
    
    public DriverStandingsManagerImpl(Speedment speedment) {
        super(speedment);
        setSqlEntityMapper(this::defaultReadEntity);
    }
    
    @Override
    public Class<DriverStandings> getEntityClass() {
        return DriverStandings.class;
    }
    
    @Override
    public Object get(DriverStandings entity, Column column) {
        switch (column.getName()) {
            case "driverStandingsId" : return entity.getDriverStandingsId();
            case "raceId" : return entity.getRaceId();
            case "driverId" : return entity.getDriverId();
            case "points" : return entity.getPoints();
            case "position" : return entity.getPosition();
            case "positionText" : return entity.getPositionText();
            case "wins" : return entity.getWins();
            default : throw new IllegalArgumentException("Unknown column '" + column.getName() + "'.");
        }
    }
    
    @Override
    public void set(DriverStandings entity, Column column, Object value) {
        switch (column.getName()) {
            case "driverStandingsId" : entity.setDriverStandingsId((Integer) value); break;
            case "raceId" : entity.setRaceId((Integer) value); break;
            case "driverId" : entity.setDriverId((Integer) value); break;
            case "points" : entity.setPoints((Float) value); break;
            case "position" : entity.setPosition((Integer) value); break;
            case "positionText" : entity.setPositionText((String) value); break;
            case "wins" : entity.setWins((Integer) value); break;
            default : throw new IllegalArgumentException("Unknown column '" + column.getName() + "'.");
        }
    }
    
    @Override
    public Table getTable() {
        return speedment.getProjectComponent().getProject().findTableByName("db0.F1APP.driverStandings");
    }
    
    protected DriverStandings defaultReadEntity(ResultSet resultSet) {
        final DriverStandings entity = newInstance();
        try {
            entity.setDriverStandingsId(driverStandingsIdTypeMapper.toJavaType(resultSet.getInt(1)));
            entity.setRaceId(raceIdTypeMapper.toJavaType(resultSet.getInt(2)));
            entity.setDriverId(driverIdTypeMapper.toJavaType(resultSet.getInt(3)));
            entity.setPoints(pointsTypeMapper.toJavaType(resultSet.getFloat(4)));
            entity.setPosition(positionTypeMapper.toJavaType(getInt(resultSet, 5)));
            entity.setPositionText(positionTextTypeMapper.toJavaType(resultSet.getString(6)));
            entity.setWins(winsTypeMapper.toJavaType(resultSet.getInt(7)));
        }
        catch (SQLException sqle) {
            throw new SpeedmentException(sqle);
        }
        return entity;
    }
    
    @Override
    public DriverStandings newInstance() {
        return new DriverStandingsImpl(speedment);
    }
    
    @Override
    public Integer primaryKeyFor(DriverStandings entity) {
        return entity.getDriverStandingsId();
    }
}