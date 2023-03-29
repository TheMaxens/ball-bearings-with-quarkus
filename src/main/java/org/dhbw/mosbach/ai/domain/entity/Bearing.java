package org.dhbw.mosbach.ai.domain.entity;

import org.dhbw.mosbach.ai.domain.vo.Id;

import lombok.Getter;

@Getter
public class Bearing {
    public Id id; 
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

    public Bearing(Id id, double cdyn, double y, double e, double xB1) {
        this.id = id;
        this.cdyn = cdyn;
        this.y = y;
        this.e = e;
        this.xB1 = xB1;
    }   
}
