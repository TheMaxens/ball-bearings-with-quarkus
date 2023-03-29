package org.dhbw.mosbach.ai.domain.entity;

import org.dhbw.mosbach.ai.domain.vo.Id;

import lombok.Getter;

@Getter
public class OArrangement {
    public Id id;
    public Bearing bearingA;
    public Bearing bearingB;
    public double xD1;
    public double xD2;
    public Load load;
    public double a;
    public double b;
    public double c;
    public double lh10;

    public OArrangement() {
    }

    public OArrangement(Id id, Bearing bearingA, Bearing bearingB, double xD1, double xD2, Load load, double a, double b,
            double c) {
        this.id = id; 
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
