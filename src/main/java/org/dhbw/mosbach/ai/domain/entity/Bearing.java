package org.dhbw.mosbach.ai.domain.entity;

import org.dhbw.mosbach.ai.domain.vo.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Bearing {
    public Id id; 
    public double cdyn;
    public double y;
    public double e;
    public double xb1;
    public double p;
    public double fr;
    public double fa;
    public double lh10;  
}
