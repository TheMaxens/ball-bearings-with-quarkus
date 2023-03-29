package org.dhbw.mosbach.ai.framework.adapters.output.postgres.data;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

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
    @Valid
    private BearingData bearingA;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bearingB_id", referencedColumnName = "id")
    @Valid
    private BearingData bearingB;

    @Min(0)
    private double xD1;

    @Min(0)
    private double xD2;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "load_id", referencedColumnName = "id")
    @Valid
    private LoadData load;

    @Min(0)
    private double a;

    @Min(0)
    private double b;

    @Min(0)
    private double c;

    @JsonProperty(access = Access.READ_ONLY)
    private double lh10;
}