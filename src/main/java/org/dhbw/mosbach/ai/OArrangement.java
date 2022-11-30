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
    private double lh10;

    public OArrangement(Bearing bearingA, Bearing bearingB, double xD1, double xD2, Load load) {
        this.bearingA = bearingA;
        this.bearingB = bearingB;
        this.xD1 = xD1;
        this.xD2 = xD2;
        this.load = load;
    }

    public Bearing getBearingA() {
        return bearingA;
    }

    public Bearing getBearingB() {
        return bearingB;
    }

    public double getxD1() {
        return xD1;
    }

    public double getxD2() {
        return xD2;
    }

    public Load getLoad() {
        return load;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getLh10() {
        return lh10;
    }

}
