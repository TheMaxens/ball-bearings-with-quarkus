package org.dhbw.mosbach.ai;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
public class Bearing extends PanacheEntityBase {
    @Id
    @SequenceGenerator(name = "bearingSequence", sequenceName = "bearingId_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bearingSequence")
    public Long id; 

    public double cdyn;
    public double y;
    public double e;
    public double xB1;
    public double p;
    public double fr;
    public double fa;
    public double lh10;

    public Bearing() {

    }

    public Bearing(double cdyn, double y, double e, double xB1) {
        this.cdyn = cdyn;
        this.y = y;
        this.e = e;
        this.xB1 = xB1;
    }   
}
