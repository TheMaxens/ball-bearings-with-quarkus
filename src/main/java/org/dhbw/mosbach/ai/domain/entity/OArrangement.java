package org.dhbw.mosbach.ai.domain.entity;

import org.dhbw.mosbach.ai.domain.vo.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
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

}
