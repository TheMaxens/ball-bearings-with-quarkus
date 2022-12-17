package org.dhbw.mosbach.ai;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
public class Bearing extends PanacheEntityBase {
    @Id
    @SequenceGenerator(name = "bearingSequence", sequenceName = "bearingId_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bearingSequence")
    public Long id; 

    @Min(0)
    public double cdyn;
    @Min(0)
    public double y;
    @Min(0)
    public double e;
    @Min(0)
    public double xB1;
    @JsonProperty(access = Access.READ_ONLY)
    public double p;
    @JsonProperty(access = Access.READ_ONLY)
    public double fr;
    @JsonProperty(access = Access.READ_ONLY)
    public double fa;
    @JsonProperty(access = Access.READ_ONLY)
    public double lh10;

    public Bearing() {

    }

    public Bearing(double cdyn, double y, double e, double xB1) {
        this.cdyn = cdyn;
        this.y = y;
        this.e = e;
        this.xB1 = xB1;
    }   

    @JsonIgnore
    public void setId(Long id) {
        this.id = id;
    }   
}
