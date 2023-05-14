package org.dhbw.mosbach.ai.domain.entity;

import org.dhbw.mosbach.ai.domain.vo.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Load {
    public Id id;
    public double fr;
    public double fa;
    public double n;
    public double xr;
    public double ya;
}
