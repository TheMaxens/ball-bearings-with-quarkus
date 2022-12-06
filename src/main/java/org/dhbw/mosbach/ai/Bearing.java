package org.dhbw.mosbach.ai;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Bearing extends PanacheEntity {
    public double cdyn;
    public double y;
    public double e;
    public double xB1;
    public double p;
    public double fr;
    public double fa;
    public double lh10;
}
