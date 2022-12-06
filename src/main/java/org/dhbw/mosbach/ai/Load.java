package org.dhbw.mosbach.ai;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Load extends PanacheEntity {
    public double fr;
    public double fa;
    public double n;
    public double xr;
    public double ya;
}
