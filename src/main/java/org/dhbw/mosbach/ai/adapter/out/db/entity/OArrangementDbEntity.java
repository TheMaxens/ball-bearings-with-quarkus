package org.dhbw.mosbach.ai.adapter.out.db.entity;

public class OArrangementDbEntity {
    @Column("ID")
    private String vin;
    @Column("LICENSE_PLATE")
    private String licensePlate;
    @Column("MILEAGE")
    private Double milage;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Double getMilage() {
        return milage;
    }

    public void setMilage(Double milage) {
        this.milage = milage;
    }
}
