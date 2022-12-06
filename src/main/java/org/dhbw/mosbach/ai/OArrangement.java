package org.dhbw.mosbach.ai;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class OArrangement extends PanacheEntity {
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bearingA_id", referencedColumnName = "id")
    public Bearing bearingA;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bearingB_id", referencedColumnName = "id")
    public Bearing bearingB;
    public double xD1;
    public double xD2;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "load_id", referencedColumnName = "id")
    public Load load;
    public double a;
    public double b;
    public double c;
    public double lh10;
}
