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
            oArrangementData.getC(), 
            oArrangementData.getLh10()
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
            .build();
        calculate(createOArrangement, oArrangementData);
        return oArrangementData;
    }

    private static Bearing bearingDataToDomain(BearingData bearingData) {
        Bearing bearing = new Bearing(
            Id.withId(bearingData.getId().toString()), 
            bearingData.getCdyn(),
            bearingData.getY(), 
            bearingData.getE(),
            bearingData.getXB1(), 
            bearingData.getP(), 
            bearingData.getFr(),
            bearingData.getFa(), 
            bearingData.getLh10()
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

    private static double calculateA(CreateOArrangement createOArrangement) {
        return createOArrangement.getLoad().getYa();
    }

    private static double calculateB(CreateOArrangement createOArrangement) {
        return createOArrangement.getXd1() - createOArrangement.getBearing_a().getXb1() + createOArrangement.getLoad().getXr();
    }

    private static double calculateC(CreateOArrangement createOArrangement) {
         return createOArrangement.getXd2() - createOArrangement.getXd1() + createOArrangement.getBearing_a().getXb1() + createOArrangement.getBearing_b().getXb1();
    }

    private static double calculateFrBearingB(CreateOArrangement createOArrangement) {
        return (createOArrangement.getLoad().getFa() * calculateA(createOArrangement)) / calculateC(createOArrangement) - (createOArrangement.getLoad().getFr() * calculateB(createOArrangement)) / calculateC(createOArrangement);
    }

    private static double calculateFrBearingA(CreateOArrangement createOArrangement) {
        return createOArrangement.getLoad().getFr() - calculateFrBearingB(createOArrangement);
    }

    private static double calculateFaBearingA(CreateOArrangement createOArrangement) {
        double faA;
        double tmp;
        double frA = calculateFrBearingA(createOArrangement);
        double frB = calculateFrBearingB(createOArrangement);
        double fyA = frA / createOArrangement.getBearing_a().getY();
        double fyB = frB / createOArrangement.getBearing_b().getY();

        if (fyA <= fyB) {
            faA = createOArrangement.getLoad().getFa() + 0.5 * fyB;
        } else {
            tmp = 0.5 * (fyA - fyB);
            if (createOArrangement.getLoad().getFa() > tmp) {
                faA = createOArrangement.getLoad().getFa() + 0.5 * fyB;
            } else {
                faA = 0;
            }
        }

        return faA;
        // 'Fall 1
        // If (FYA <= FYB) Then
        //     FaA_FAG = Ka + 0.5 * FYB
        // 'Fall 2
        // Else
        //     tmp = 0.5 * (FYA - FYB)
        //     If (Ka > tmp) Then
        //         FaA_FAG = Ka + 0.5 * FYB
        //     Else
        //         FaA_FAG = 0
        //     End If
        // End If
    }

    private static double calculateFaBearingB(CreateOArrangement createOArrangement) {
        double faB;
        double tmp;
        double frA = calculateFrBearingA(createOArrangement);
        double frB = calculateFrBearingB(createOArrangement);
        double fyA = frA / createOArrangement.getBearing_a().getY();
        double fyB = frB / createOArrangement.getBearing_b().getY();

        if (fyA <= fyB) {
            faB = 0;
        } else {
            tmp = 0.5 * (fyA - fyB);
            if (createOArrangement.getLoad().getFa() > tmp) {
                faB = 0;
            } else {
                faB = 0.5 * fyA - createOArrangement.getLoad().getFa();
            }
        }

        return faB;

        // 'Fall 1
        // If (FYA <= FYB) Then
        //     FaB_FAG = 0
        //     Exit Function
        // 'Fall 2
        // Else
        //     tmp = 0.5 * (FYA - FYB)
        //     If (Ka > tmp) Then
        //         FaB_FAG = 0
        //         Exit Function
        //     Else
        //         FaB_FAG = 0.5 * FYA - Ka
        //     End If
        // End If
    }

    private static double calculatePBearingA(CreateOArrangement createOArrangement) {
        double fafr;
        double p;
        double fr = Math.abs(calculateFrBearingA(createOArrangement));
        double fa = Math.abs(calculateFaBearingA(createOArrangement));
       
        if (fr == 0) {
            fafr = 999999999;
        } else {
            fafr = fa / fr;
        }

        if (fafr <= createOArrangement.getBearing_a().getE()) {
            p = fr;
        } else {
            p = 0.4 * fr + createOArrangement.getBearing_a().getY() * fa;
        }

        return p;
    //    Dim FaFr As Double
    //    'Betrag
    //    Fr = Abs(Fr)
    //    Fa = Abs(Fa)
    //    'Verhältnisse
    //    If (Fr = 0) Then
    //        FaFr = 999999999
    //    Else
    //        FaFr = Fa / Fr
    //    End If
    //    'Äquivalentlast
    //    If (FaFr <= e) Then
    //        P_FAG = Fr
    //    Else
    //        P_FAG = 0.4 * Fr + Y * Fa
    //    End If
    }

    private static double calculatePBearingB(CreateOArrangement createOArrangement) {
        double fafr;
        double p;
        double fr = Math.abs(calculateFrBearingB(createOArrangement));
        double fa = Math.abs(calculateFaBearingB(createOArrangement));
       
        if (fr == 0) {
            fafr = 999999999;
        } else {
            fafr = fa / fr;
        }

        if (fafr <= createOArrangement.getBearing_b().getE()) {
            p = fr;
        } else {
            p = 0.4 * fr + createOArrangement.getBearing_b().getY() * fa;
        }

        return p;
    }

    private static double calculateLh10BearingA(CreateOArrangement createOArrangement) {
        final double exp = 10.0/3; 
        double p = calculatePBearingA(createOArrangement);
        double tmp = createOArrangement.getBearing_a().getCdyn() / p;
        double lh10 =  Math.pow(tmp, exp);
        lh10 = (16666 / createOArrangement.getLoad().getN()) * lh10;
        return lh10;

        // Lh10nom = (c / P) ^ Exp
        // Lh10nom = 16666 / n * Lh10nom
    }

    private static double calculateLh10BearingB(CreateOArrangement createOArrangement) {
        final double exp = 10.0/3; 
        double p = calculatePBearingB(createOArrangement);
        double tmp = createOArrangement.getBearing_b().getCdyn() / p;
        double lh10 =  Math.pow(tmp, exp);
        lh10 = (16666 / createOArrangement.getLoad().getN()) * lh10;
        return lh10;

        // Lh10nom = (c / P) ^ Exp
        // Lh10nom = 16666 / n * Lh10nom
    }

    private static double calculateLh10(CreateOArrangement createOArrangement) {
        double lh10;
        double lh10A = calculateLh10BearingA(createOArrangement);
        double lh10B = calculateLh10BearingB(createOArrangement);

        if (lh10A < lh10B) {
            lh10 = lh10A;
        } else {
            lh10 = lh10B;
        }
        return lh10;
    }

    private static void calculate(CreateOArrangement createOArrangement, OArrangementData oArrangementData) {
        oArrangementData.setA(calculateA(createOArrangement));
        oArrangementData.setB(calculateB(createOArrangement));
        oArrangementData.setC(calculateC(createOArrangement));
        oArrangementData.getBearing_a().setFr(calculateFrBearingA(createOArrangement));
        oArrangementData.getBearing_b().setFr(calculateFrBearingB(createOArrangement));
        oArrangementData.getBearing_a().setFa(calculateFaBearingA(createOArrangement));
        oArrangementData.getBearing_b().setFa(calculateFaBearingB(createOArrangement));
        oArrangementData.getBearing_a().setP(calculatePBearingA(createOArrangement));
        oArrangementData.getBearing_b().setP(calculatePBearingB(createOArrangement));
        oArrangementData.getBearing_a().setLh10(calculateLh10BearingA(createOArrangement));
        oArrangementData.getBearing_b().setLh10(calculateLh10BearingB(createOArrangement));
        oArrangementData.setLh10(calculateLh10(createOArrangement));
    }
}
