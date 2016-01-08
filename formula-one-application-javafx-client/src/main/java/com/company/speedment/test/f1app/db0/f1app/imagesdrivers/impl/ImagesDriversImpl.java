package com.company.speedment.test.f1app.db0.f1app.imagesdrivers.impl;

import com.company.speedment.test.f1app.db0.f1app.imagesdrivers.ImagesDrivers;
import com.speedment.Speedment;
import com.speedment.internal.core.code.AbstractBaseEntity;
import java.util.Objects;
import java.util.Optional;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * An implementation representing an entity (for example, a row) in the
 * com.speedment.internal.ui.config.TableProperty@4c6393b5.
 * <p>
 * This Class or Interface has been automatically generated by Speedment. Any
 * changes made to this Class or Interface will be overwritten.
 * 
 * @author Speedment
 */
@Generated("Speedment")
public final class ImagesDriversImpl extends AbstractBaseEntity<ImagesDrivers> implements ImagesDrivers {
    
    private String driverDisplayImage;
    private String driverHelmet;
    private String lastName;
    private String driverImageId;
    private String driverFlag;
    
    ImagesDriversImpl(Speedment speedment) {
        super(speedment);
    }
    
    public ImagesDriversImpl(Speedment speedment, final ImagesDrivers imagesDrivers) {
        super(speedment);
        imagesDrivers.getDriverDisplayImage().ifPresent(this::setDriverDisplayImage);
        imagesDrivers.getDriverHelmet().ifPresent(this::setDriverHelmet);
        imagesDrivers.getLastName().ifPresent(this::setLastName);
        setDriverImageId(imagesDrivers.getDriverImageId());
        imagesDrivers.getDriverFlag().ifPresent(this::setDriverFlag);
    }
    
    @Override
    public Optional<String> getDriverDisplayImage() {
        return Optional.ofNullable(driverDisplayImage);
    }
    
    @Override
    public Optional<String> getDriverHelmet() {
        return Optional.ofNullable(driverHelmet);
    }
    
    @Override
    public Optional<String> getLastName() {
        return Optional.ofNullable(lastName);
    }
    
    @Override
    public String getDriverImageId() {
        return driverImageId;
    }
    
    @Override
    public Optional<String> getDriverFlag() {
        return Optional.ofNullable(driverFlag);
    }
    
    @Override
    public final ImagesDriversImpl setDriverDisplayImage(String driverDisplayImage) {
        this.driverDisplayImage = driverDisplayImage;
        return this;
    }
    
    @Override
    public final ImagesDriversImpl setDriverHelmet(String driverHelmet) {
        this.driverHelmet = driverHelmet;
        return this;
    }
    
    @Override
    public final ImagesDriversImpl setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
    
    @Override
    public final ImagesDriversImpl setDriverImageId(String driverImageId) {
        this.driverImageId = driverImageId;
        return this;
    }
    
    @Override
    public final ImagesDriversImpl setDriverFlag(String driverFlag) {
        this.driverFlag = driverFlag;
        return this;
    }
    
    @Override
    public ImagesDrivers copy() {
        return new ImagesDriversImpl(getSpeedment_(), this);
    }
    
    @Override
    public String toString() {
        final StringJoiner sj = new StringJoiner(", ", "{ ", " }");
        sj.add("driverDisplayImage = "+Objects.toString(getDriverDisplayImage().orElse(null)));
        sj.add("driverHelmet = "+Objects.toString(getDriverHelmet().orElse(null)));
        sj.add("lastName = "+Objects.toString(getLastName().orElse(null)));
        sj.add("driverImageId = "+Objects.toString(getDriverImageId()));
        sj.add("driverFlag = "+Objects.toString(getDriverFlag().orElse(null)));
        return "ImagesDriversImpl "+sj.toString();
    }
    
    @Override
    public boolean equals(Object that) {
        if (this == that) { return true; }
        if (!(that instanceof ImagesDrivers)) { return false; }
        @SuppressWarnings("unchecked")
        final ImagesDrivers thatImagesDrivers = (ImagesDrivers)that;
        if (!Objects.equals(this.getDriverDisplayImage(), thatImagesDrivers.getDriverDisplayImage())) {return false; }
        if (!Objects.equals(this.getDriverHelmet(), thatImagesDrivers.getDriverHelmet())) {return false; }
        if (!Objects.equals(this.getLastName(), thatImagesDrivers.getLastName())) {return false; }
        if (!Objects.equals(this.getDriverImageId(), thatImagesDrivers.getDriverImageId())) {return false; }
        if (!Objects.equals(this.getDriverFlag(), thatImagesDrivers.getDriverFlag())) {return false; }
        return true;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(getDriverDisplayImage());
        hash = 31 * hash + Objects.hashCode(getDriverHelmet());
        hash = 31 * hash + Objects.hashCode(getLastName());
        hash = 31 * hash + Objects.hashCode(getDriverImageId());
        hash = 31 * hash + Objects.hashCode(getDriverFlag());
        return hash;
    }
    
    @Override
    public Class<ImagesDrivers> getEntityClass_() {
        return ImagesDrivers.class;
    }
}