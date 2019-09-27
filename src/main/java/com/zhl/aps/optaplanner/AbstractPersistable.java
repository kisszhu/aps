package com.zhl.aps.optaplanner;

import java.io.Serializable;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.optaplanner.core.api.domain.lookup.PlanningId;

/**
 * @program aps
 * @description:负责维护ID属性，对实体类的compareTo方法，toString方法进行重载
 * @author: meilong
 * @create: 2019/09/20 14:47
 */
public class AbstractPersistable implements Serializable, Comparable<AbstractPersistable> {

    protected Long id;

    protected AbstractPersistable() {
    }

    protected AbstractPersistable(Long id) {
        this.id = id;
    }

    @PlanningId
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int compareTo(AbstractPersistable other) {
        return new CompareToBuilder()
                .append(getClass().getName(), other.getClass().getName())
                .append(id, other.id)
                .toComparison();
    }

    @Override
    public String toString() {
        return getClass().getName().replaceAll(".*\\.", "") + "-" + id;
    }
}


