package org.dhbw.mosbach.ai.framework.adapters.output.postgres.mapper;

import org.dhbw.mosbach.ai.domain.entity.Bearing;
import org.dhbw.mosbach.ai.domain.entity.Load;
import org.dhbw.mosbach.ai.domain.entity.OArrangement;
import org.dhbw.mosbach.ai.domain.vo.Id;
import org.dhbw.mosbach.ai.framework.adapters.input.rest.request.CreateBearing;
import org.dhbw.mosbach.ai.framework.adapters.input.rest.request.CreateLoad;
import org.dhbw.mosbach.ai.framework.adapters.input.rest.request.CreateOArrangement;
import org.dhbw.mosbach.ai.framework.adapters.output.postgres.data.BearingData;
import org.dhbw.mosbach.ai.framework.adapters.output.postgres.data.LoadData;
import org.dhbw.mosbach.ai.framework.adapters.output.postgres.data.OArrangementData;

public class OArrangementMapper {

    public static OArrangement oArrangementDataToDomain(OArrangementData oArrangementData) {
        OArrangement oArrangement = new OArrangement(
            Id.withId(oArrangementData.getId().toString()),
            bearingDataToDomain(oArrangementData.getBearing_a()),
            bearingDataToDomain(oArrangementData.getBearing_b()),
            oArrangementData.getXD1(),
            oArrangementData.getXD2(),
            loadDataToDomain(oArrangementData.getLoad()),
            oArrangementData.getA(),
            oArrangementData.getB(),
            oArrangementData.getC()
        );
        return oArrangement;
    }

    public static OArrangementData createOArrangementToData(CreateOArrangement createOArrangement) {
        OArrangementData oArrangementData = OArrangementData.builder()
            .bearing_a(createBearingToData(createOArrangement.getBearing_a()))
            .bearing_b(createBearingToData(createOArrangement.getBearing_b()))
            .xD1(createOArrangement.getXd1())
            .xD2(createOArrangement.getXd2())
            .load(createLoadToData(createOArrangement.getLoad()))
            .a(createOArrangement.getA())
            .b(createOArrangement.getB())
            .c(createOArrangement.getC())
            .build();
        return oArrangementData;
    }

    private static Bearing bearingDataToDomain(BearingData bearingData) {
        Bearing bearing = new Bearing(
            Id.withId(bearingData.getId().toString()), 
            bearingData.getCdyn(),
            bearingData.getY(), 
            bearingData.getE(),
            bearingData.getXB1()
            );
        return bearing;
    }

    private static BearingData createBearingToData(CreateBearing createBearing) {
        BearingData bearingData = BearingData.builder().
            cdyn(createBearing.getCdyn()).
            y(createBearing.getY()).
            e(createBearing.getE()).
            xB1(createBearing.getXb1()).
            build();
        return bearingData;
    }

    private static Load loadDataToDomain(LoadData loadData) {
        Load load = new Load(
            Id.withId(loadData.getId().toString()),
            loadData.getFr(),
            loadData.getFa(),
            loadData.getN(),
            loadData.getXr(),
            loadData.getYa()
        );
        return load;
    }

    private static LoadData createLoadToData(CreateLoad createLoad) {
        LoadData loadData = LoadData.builder().
            fr(createLoad.getFr()).
            fa(createLoad.getFa()).
            n(createLoad.getN()).
            xr(createLoad.getXr()).
            ya(createLoad.getYa()).
            build();
        return loadData;
    }
}
