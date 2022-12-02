package org.dhbw.mosbach.ai;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Load {
    private double fr;
    private double fa;
    private double n;
    private double xr;
    private double ya;

    public Load(double fr, double fa, double n, double xr, double ya) {
        this.fr = fr;
        this.fa = fa;
        this.n = n;
        this.xr = xr;
        this.ya = ya;
    }

    @JsonProperty
    public double getFr() {
        return fr;
    }

    @JsonProperty
    public double getFa() {
        return fa;
    }

    @JsonProperty
    public double getN() {
        return n;
    }

    @JsonProperty
    public double getXr() {
        return xr;
    }

    @JsonProperty
    public double getYa() {
        return ya;
    }

    @JsonProperty
    public void setFr(double fr) {
        this.fr = fr;
    }

    @JsonProperty
    public void setFa(double fa) {
        this.fa = fa;
    }

    @JsonProperty
    public void setN(double n) {
        this.n = n;
    }

    @JsonProperty
    public void setXr(double xr) {
        this.xr = xr;
    }

    @JsonProperty
    public void setYa(double ya) {
        this.ya = ya;
    }
}
