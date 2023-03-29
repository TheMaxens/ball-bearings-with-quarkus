package org.dhbw.mosbach.ai.framework.adapters.output.postgres.data;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bearings")
public class BearingData {
    @Id
    @GeneratedValue
    private UUID id;

    @Min(0)
    private double cdyn;

    @Min(0)
    private double y;

    @Min(0)
    private double e;

    @Min(0)
    private double xB1;

    @JsonProperty(access = Access.READ_ONLY)
    private double p;

    @JsonProperty(access = Access.READ_ONLY)
    private double fr;

    @JsonProperty(access = Access.READ_ONLY)
    private double fa;

    @JsonProperty(access = Access.READ_ONLY)
    private double lh10;
}
