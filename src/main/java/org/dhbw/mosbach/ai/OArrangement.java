package org.dhbw.mosbach.ai;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OArrangement {
    private UUID uid; 
    private Bearing bearingA;
    private Bearing bearingB;
    private double xD1;
    private double xD2;
    private Load load;
    private double a;
    private double b;
    private double c;
    private double lh10;

    public OArrangement(Bearing bearingA, Bearing bearingB, double xD1, double xD2, Load load) {
        this.bearingA = bearingA;
        this.bearingB = bearingB;
        this.xD1 = xD1;
        this.xD2 = xD2;
        this.load = load;
    }

    @JsonProperty
    public Bearing getBearingA() {
        return bearingA;
    }

    @JsonProperty
    public Bearing getBearingB() {
        return bearingB;
    }

    @JsonProperty
    public double getxD1() {
        return xD1;
    }

    @JsonProperty
    public double getxD2() {
        return xD2;
    }

    @JsonProperty
    public Load getLoad() {
        return load;
    }

    @JsonProperty
    public double getA() {
        return a;
    }

    @JsonProperty
    public double getB() {
        return b;
    }

    @JsonProperty
    public double getC() {
        return c;
    }

    @JsonProperty
    public double getLh10() {
        return lh10;
    }

    @JsonProperty
    public UUID getUid() {
        return uid;
    }

    @JsonIgnore
    public void setUid(UUID uid) {
        this.uid = uid;
    }

    @JsonProperty
    public void setBearingA(Bearing bearingA) {
        this.bearingA = bearingA;
    }

    @JsonProperty
    public void setBearingB(Bearing bearingB) {
        this.bearingB = bearingB;
    }

    @JsonProperty
    public void setxD1(double xD1) {
        this.xD1 = xD1;
    }

    @JsonProperty
    public void setxD2(double xD2) {
        this.xD2 = xD2;
    }

    @JsonProperty
    public void setLoad(Load load) {
        this.load = load;
    }

    @JsonIgnore
    public void setA(double a) {
        this.a = a;
    }

    @JsonIgnore
    public void setB(double b) {
        this.b = b;
    }

    @JsonIgnore
    public void setC(double c) {
        this.c = c;
    }

    @JsonIgnore
    public void setLh10(double lh10) {
        this.lh10 = lh10;
    }
}
