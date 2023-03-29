package org.dhbw.mosbach.ai.domain.entity;

import org.dhbw.mosbach.ai.domain.vo.Id;

import lombok.Getter;

@Getter
public class OArrangement {
    public Id id;
    public Bearing bearing_a;
    public Bearing bearing_b;
    public double xd1;
    public double xd2;
    public Load load;
    public double a;
    public double b;
    public double c;
    public double lh10;

    public OArrangement() {
    }

    public OArrangement(Id id, Bearing bearing_a, Bearing bearing_b, double xd1, double xd2, Load load, double a, double b,
            double c) {
        this.id = id; 
        this.bearing_a = bearing_a;
        this.bearing_b = bearing_b;
        this.xd1 = xd1;
        this.xd2 = xd2;
        this.load = load;
        this.a = a;
        this.b = b;
        this.c = c;
    }
}
