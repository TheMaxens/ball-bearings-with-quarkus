package org.dhbw.mosbach.ai;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
public class OArrangement extends PanacheEntityBase {
    @Id
    @SequenceGenerator(name = "oArrangementSequence", sequenceName = "oArrangementId_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "oArrangementSequence")
    public Long id; 
    
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

    public OArrangement() {
    }

    public OArrangement(Bearing bearingA, Bearing bearingB, double xD1, double xD2, Load load, double a, double b,
            double c) {
        this.bearingA = bearingA;
        this.bearingB = bearingB;
        this.xD1 = xD1;
        this.xD2 = xD2;
        this.load = load;
        this.a = a;
        this.b = b;
        this.c = c;
    }
}
