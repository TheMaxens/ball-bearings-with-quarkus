package org.dhbw.mosbach.ai.adapter.out.db;


import org.dhbw.mosbach.ai.usecase.in.OArrangementCommand;
import org.dhbw.mosbach.ai.usecase.out.OArrangementDbCommand;
import org.springframework.stereotype.Component;

@Component
public class OArrangementCommandRepository implements OArrangementDbCommand {

    private OArrangToOArrangDbEntityMapper mapper;

    private static final String VIN = "WP0ZZZ99ZTS392155";
    private static final String LICENSE_PLATE_TEST_VALUE = "ES-EM 385";
    private static final double MILEAGE_TEST_VALUE = 100000;

    public OArrangementCommandRepository(OArrangToOArrangDbEntityMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Vehicle saveVehicle(Vehicle vehicle) {
        VehicleDbEntity savedVehicle = technicalSaveWithSqlStuff(vehicle);
        return mapper.mapVehicleDbEntityToVehicle(savedVehicle);
    }

    private VehicleDbEntity technicalSaveWithSqlStuff(Vehicle vehicle) {
        //INSERT INTO ...
        // UPDATE ...
        // jdbcRepository.save(mapper.mapVehicleToVehicleDbEntity(vehicle));
        VehicleDbEntity dbEntity = new VehicleDbEntity();
        dbEntity.setVin(VIN);
        dbEntity.setLicensePlate(LICENSE_PLATE_TEST_VALUE);
        dbEntity.setMilage(MILEAGE_TEST_VALUE);
        return dbEntity;
    }
}
