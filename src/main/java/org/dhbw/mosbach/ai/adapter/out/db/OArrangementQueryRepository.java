package org.dhbw.mosbach.ai.adapter.out.db;

import org.dhbw.mosbach.ai.usecase.out.OArrangementDbQuery;

public class OArrangementQueryRepository implements OArrangementDbQuery {
    private VehicleToVehicleDbEntityMapper mapper;

    private static final String VIN = "WP0ZZZ99ZTS392155";
    private static final String LICENSE_PLATE_TEST_VALUE = "ES-EM 385";
    private static final double MILEAGE_TEST_VALUE = 100000;

    public VehicleQueryRepository(VehicleToVehicleDbEntityMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Vehicle findVehicleByVin(Vin vin) {
        VehicleDbEntity vehicleDbEntity = findVehicleDbEntity(vin.value());
        return mapper.mapVehicleDbEntityToVehicle(vehicleDbEntity);
    }

    @Override
    public Vehicle findVehicleByLicensePlate(LicensePlate licensePlate) {
        return mapper.mapVehicleDbEntityToVehicle(findVehicleDbEntity(licensePlate.value()));
    }

    private VehicleDbEntity findVehicleDbEntity(String vin) {
        VehicleDbEntity dbEntity = new VehicleDbEntity();
        dbEntity.setVin(VIN);
        dbEntity.setLicensePlate(LICENSE_PLATE_TEST_VALUE);
        dbEntity.setMilage(MILEAGE_TEST_VALUE);
        return dbEntity;
    }
}
