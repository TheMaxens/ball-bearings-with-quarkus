package org.dhbw.mosbach.ai.adapter.in;

import org.dhbw.mosbach.ai.usecase.in.OArrangementCommand;
import org.dhbw.mosbach.ai.usecase.in.OArrangementQuery;

public class OArrangementController {

    private OArrangementQuery oArrangementQuery;
    private OArrangToOArrangResourceMapper mapper;
    private OArrangementCommand oArrangementCommand;

    public OArrangementController(OArrangementQuery oArrangementQuery, OArrangToOArrangResourceMapper mapper,
            OArrangementCommand oArrangementCommand) {
        this.oArrangementQuery = oArrangementQuery;
        this.mapper = mapper;
        this.oArrangementCommand = oArrangementCommand;
    }

    // @GetMapping("/{vin}")
    public VehicleResource readVehicle(@PathVariable("vin") String vin) {
        return mapper.mapVehicleToVehicleResource(vehicleQuery.findByVin(new Vin(vin)));
    }

    // @PutMapping("/{vin}")
    public VehicleResource updateVehicle(@PathVariable("vin") String vin,
            @RequestBody VehicleMotionDataResource resource) {
        VehicleMotionData vehicleMotionData = mapper.mapVehicleResourceToVehicleMotionData(resource);
        Vehicle updatedVehicle = vehicleCommand.update(new Vin(vin), vehicleMotionData);
        return mapper.mapVehicleToVehicleResource(updatedVehicle);
    }

    // @PostMapping
    public VehicleResource createVehicle(@RequestBody VehicleResource resource) {
        Vehicle createdVehice = vehicleCommand.create(mapper.mapVehicleResourceToVehicle(resource));
        return mapper.mapVehicleToVehicleResource(createdVehice);
    }

}
