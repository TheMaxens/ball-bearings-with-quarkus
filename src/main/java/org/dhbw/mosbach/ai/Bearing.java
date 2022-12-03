package org.dhbw.mosbach.ai;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;

@Entity
public class Bearing extends PanacheEntity {
    // private double cdyn;
    // private double y;
    // private double e;
    // private double xB1;
    // private double p;
    // private double fr;
    // private double fa;
    // private double lh10;
    public double cdyn;
    public double y;
    public double e;
    public double xB1;
    public double p;
    public double fr;
    public double fa;
    public double lh10;

    public Bearing(double cdyn, double y, double e, double xB1) {
        this.cdyn = cdyn;
        this.y = y;
        this.e = e;
        this.xB1 = xB1;
    }

    // @JsonProperty
    // public double getCdyn() {
    //     return cdyn;
    // }

    // @JsonProperty
    // public double getY() {
    //     return y;
    // }

    // @JsonProperty
    // public double getE() {
    //     return e;
    // }

    // @JsonProperty
    // public double getxB1() {
    //     return xB1;
    // }

    // @JsonProperty
    // public double getP() {
    //     return p;
    // }

    // @JsonProperty
    // public double getFr() {
    //     return fr;
    // }

    // @JsonProperty
    // public double getFa() {
    //     return fa;
    // }

    // @JsonProperty
    // public double getLh10() {
    //     return lh10;
    // }

    // @JsonProperty
    // public void setCdyn(double cdyn) {
    //     this.cdyn = cdyn;
    // }

    // @JsonProperty
    // public void setY(double y) {
    //     this.y = y;
    // }

    // @JsonProperty
    // public void setE(double e) {
    //     this.e = e;
    // }

    // @JsonProperty
    // public void setxB1(double xB1) {
    //     this.xB1 = xB1;
    // }

    // @JsonIgnore
    // public void setP(double p) {
    //     this.p = p;
    // }

    // @JsonIgnore
    // public void setFr(double fr) {
    //     this.fr = fr;
    // }

    // @JsonIgnore
    // public void setFa(double fa) {
    //     this.fa = fa;
    // }

    // @JsonIgnore
    // public void setLh10(double lh10) {
    //     this.lh10 = lh10;
    // }
}
