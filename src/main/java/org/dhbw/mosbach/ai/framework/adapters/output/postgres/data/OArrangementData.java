package org.dhbw.mosbach.ai.framework.adapters.output.postgres.data;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "oArrangements")
public class OArrangementData {
    @Id
    @GeneratedValue
    private UUID id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bearingA_id", referencedColumnName = "id")
    private BearingData bearing_a;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bearingB_id", referencedColumnName = "id")
    private BearingData bearing_b;

    private double xD1;

    private double xD2;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "load_id", referencedColumnName = "id")
    private LoadData load;

    private double a;

    private double b;

    private double c;

    private double lh10;
}