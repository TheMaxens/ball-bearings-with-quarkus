package org.dhbw.mosbach.ai;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
public class Load extends PanacheEntityBase {
    @Id
    @SequenceGenerator(name = "loadSequence", sequenceName = "loadId_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loadSequence")
    public Long id; 

    public double fr;
    public double fa;
    public double n;
    public double xr;
    public double ya;

    public Load() {
    }

    public Load(double fr, double fa, double n, double xr, double ya) {
        this.fr = fr;
        this.fa = fa;
        this.n = n;
        this.xr = xr;
        this.ya = ya;
    }

    @JsonIgnore
    public void setId(Long id) {
        this.id = id;
    }   
}
