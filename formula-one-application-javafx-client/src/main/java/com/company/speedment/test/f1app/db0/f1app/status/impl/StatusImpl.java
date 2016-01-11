package com.company.speedment.test.f1app.db0.f1app.status.impl;

import com.company.speedment.test.f1app.db0.f1app.status.Status;
import com.speedment.Speedment;
import com.speedment.internal.core.code.AbstractBaseEntity;
import java.util.Objects;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * An implementation representing an entity (for example, a row) in the
 * com.speedment.internal.ui.config.TableProperty@a106287.
 * <p>
 * This Class or Interface has been automatically generated by Speedment. Any
 * changes made to this Class or Interface will be overwritten.
 * 
 * @author Speedment
 */
@Generated("Speedment")
public final class StatusImpl extends AbstractBaseEntity<Status> implements Status {
    
    private Integer statusId;
    private String status;
    
    StatusImpl(Speedment speedment) {
        super(speedment);
    }
    
    public StatusImpl(Speedment speedment, final Status status) {
        super(speedment);
        setStatusId(status.getStatusId());
        setStatus(status.getStatus());
    }
    
    @Override
    public Integer getStatusId() {
        return statusId;
    }
    
    @Override
    public String getStatus() {
        return status;
    }
    
    @Override
    public final StatusImpl setStatusId(Integer statusId) {
        this.statusId = statusId;
        return this;
    }
    
    @Override
    public final StatusImpl setStatus(String status) {
        this.status = status;
        return this;
    }
    
    @Override
    public Status copy() {
        return new StatusImpl(getSpeedment_(), this);
    }
    
    @Override
    public String toString() {
        final StringJoiner sj = new StringJoiner(", ", "{ ", " }");
        sj.add("statusId = "+Objects.toString(getStatusId()));
        sj.add("status = "+Objects.toString(getStatus()));
        return "StatusImpl "+sj.toString();
    }
    
    @Override
    public boolean equals(Object that) {
        if (this == that) { return true; }
        if (!(that instanceof Status)) { return false; }
        @SuppressWarnings("unchecked")
        final Status thatStatus = (Status)that;
        if (!Objects.equals(this.getStatusId(), thatStatus.getStatusId())) {return false; }
        if (!Objects.equals(this.getStatus(), thatStatus.getStatus())) {return false; }
        return true;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(getStatusId());
        hash = 31 * hash + Objects.hashCode(getStatus());
        return hash;
    }
    
    @Override
    public Class<Status> getEntityClass_() {
        return Status.class;
    }
}