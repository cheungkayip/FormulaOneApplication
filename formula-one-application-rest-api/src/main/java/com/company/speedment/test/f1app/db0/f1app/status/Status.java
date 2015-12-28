package com.company.speedment.test.f1app.db0.f1app.status;

import com.speedment.Entity;
import com.speedment.field.ComparableField;
import com.speedment.field.StringField;
import com.speedment.internal.core.field.ComparableFieldImpl;
import com.speedment.internal.core.field.StringFieldImpl;
import javax.annotation.Generated;

/**
 * An interface representing an entity (for example, a row) in the Table
 * 'f1app.db0.F1APP.status'.
 * <p>
 * This Class or Interface has been automatically generated by Speedment. Any
 * changes made to this Class or Interface will be overwritten.
 * 
 * @author Speedment
 */
@Generated("Speedment")
public interface Status extends Entity<Status> {
    
    /**
     * This Field corresponds to the {@link Status} field that can be obtained
     * using the {@link Status#getStatusId()} method.
     */
    public final static ComparableField<Status, Integer> STATUSID = new ComparableFieldImpl<>("statusId", Status::getStatusId, Status::setStatusId);
    /**
     * This Field corresponds to the {@link Status} field that can be obtained
     * using the {@link Status#getStatus()} method.
     */
    public final static StringField<Status> STATUS = new StringFieldImpl<>("status", Status::getStatus, Status::setStatus);
    
    /**
     * Returns the statusId of this Status. The statusId field corresponds to the
     * database column db0.F1APP.status.statusId.
     * 
     * @return the statusId of this Status
     */
    Integer getStatusId();
    
    /**
     * Returns the status of this Status. The status field corresponds to the
     * database column db0.F1APP.status.status.
     * 
     * @return the status of this Status
     */
    String getStatus();
    
    /**
     * Sets the statusId of this Status. The statusId field corresponds to the
     * database column db0.F1APP.status.statusId.
     * 
     * @param statusId to set of this Status
     * @return this Status instance
     */
    Status setStatusId(Integer statusId);
    
    /**
     * Sets the status of this Status. The status field corresponds to the
     * database column db0.F1APP.status.status.
     * 
     * @param status to set of this Status
     * @return this Status instance
     */
    Status setStatus(String status);
}