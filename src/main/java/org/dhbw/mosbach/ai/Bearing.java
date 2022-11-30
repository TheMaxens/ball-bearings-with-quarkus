package org.dhbw.mosbach.ai;


public class Bearing {
    private double cdyn;
    private double y;
    private double e;
    private double xB1;
    private double p;
    private double fr;
    private double fa;
    private double lh10; 

    public Bearing(double cdyn, double y, double e, double xB1) {
        this.cdyn = cdyn;
        this.y = y;
        this.e = e;
        this.xB1 = xB1;
    }

    public double getCdyn() {
        return cdyn;
    }

    public double getY() {
        return y;
    }

    public double getE() {
        return e;
    }

    public double getxB1() {
        return xB1;
    }

    public double getP() {
        return p;
    }

    public double getFr() {
        return fr;
    }

    public double getFa() {
        return fa;
    }

    public double getLh10() {
        return lh10;
    }

}
