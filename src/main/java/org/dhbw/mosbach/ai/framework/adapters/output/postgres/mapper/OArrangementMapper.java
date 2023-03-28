package org.dhbw.mosbach.ai.framework.adapters.output.postgres.mapper;

import org.dhbw.mosbach.ai.domain.entity.Bearing;
import org.dhbw.mosbach.ai.domain.entity.Load;
import org.dhbw.mosbach.ai.domain.entity.OArrangement;
import org.dhbw.mosbach.ai.framework.adapters.output.postgres.data.BearingData;
import org.dhbw.mosbach.ai.framework.adapters.output.postgres.data.LoadData;
import org.dhbw.mosbach.ai.framework.adapters.output.postgres.data.OArrangementData;

public class OArrangementMapper {

    public static OArrangement oArrangementDataToDomain(OArrangementData oArrangementData) {
        OArrangement oArrangement = new OArrangement(
                bearingDataToDomain(oArrangementData.getBearingA()),
                bearingDataToDomain(oArrangementData.getBearingB()), oArrangementData.getXD1(),
                oArrangementData.getXD2(), loadDataToDomain(oArrangementData.getLoad()),
                oArrangementData.getA(), oArrangementData.getB(), oArrangementData.getC());
        return oArrangement;
    }

    public static OArrangementData oArrangementDomainToData(OArrangement oArrangement) {
        OArrangementData oArrangementData = OArrangementData.builder().
            bearingA(bearingDomainToData(oArrangement.getBearingA())).
            bearingB(bearingDomainToData(oArrangement.getBearingA())).
            xD1(oArrangement.getXD1()).
            xD2(oArrangement.getXD2()).
            load(loadDomainToData(oArrangement.getLoad())).
            a(oArrangement.getA()).
            b(oArrangement.getB()).
            c(oArrangement.getC()).
            build();
        return oArrangementData;
    }

    public static Bearing bearingDataToDomain(BearingData bearingData) {
        Bearing bearing = new Bearing(bearingData.getCdyn(), bearingData.getY(), bearingData.getE(),
                bearingData.getXB1());
        return bearing;
    }

    public static BearingData bearingDomainToData(Bearing bearing) {
        BearingData bearingData = BearingData.builder().
            cdyn(bearing.getCdyn()).
            y(bearing.getY()).
            e(bearing.getE()).
            xB1(bearing.getXB1()).
            build();
        return bearingData;
    }

    public static Load loadDataToDomain(LoadData loadData) {
        Load load = new Load(loadData.getFr(), loadData.getFa(), loadData.getN(), loadData.getXr(), loadData.getYa());
        return load;
    }

    public static LoadData loadDomainToData(Load load) {
        LoadData loadData = LoadData.builder().
            fr(load.getFr()).
            fa(load.getFa()).
            n(load.getN()).
            xr(load.getXr()).
            ya(load.getYa()).
            build();
        return loadData;
    }
}
