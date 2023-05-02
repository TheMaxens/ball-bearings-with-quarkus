package org.dhbw.mosbach.ai.domain.entity;

import org.dhbw.mosbach.ai.domain.vo.Id;

import lombok.Getter;

@Getter
public class Load {
    public Id id;
    public double fr;
    public double fa;
    public double n;
    public double xr;
    public double ya;

    public Load() {
    }

    public Load(Id id, double fr, double fa, double n, double xr, double ya) {
        this.id = id;
        this.fr = fr;
        this.fa = fa;
        this.n = n;
        this.xr = xr;
        this.ya = ya;
    }
}
