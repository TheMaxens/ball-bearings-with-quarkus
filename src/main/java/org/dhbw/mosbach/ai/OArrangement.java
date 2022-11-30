package org.dhbw.mosbach.ai;

public class OArrangement {
    private Bearing bearingA;
    private Bearing bearingB;
    private double xD1;
    private double xD2;
    private Load load;
    private double a;
    private double b;
    private double c;

    public OArrangement(Bearing bearingA, Bearing bearingB, double xD1, double xD2, Load load) {
        this.bearingA = bearingA;
        this.bearingB = bearingB;
        this.xD1 = xD1;
        this.xD2 = xD2;
        this.load = load;
    }

}
