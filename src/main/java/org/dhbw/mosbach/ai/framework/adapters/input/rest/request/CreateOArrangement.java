package org.dhbw.mosbach.ai.framework.adapters.input.rest.request;

import org.dhbw.mosbach.ai.domain.entity.Bearing;
import org.dhbw.mosbach.ai.domain.entity.Load;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class CreateOArrangement {

    @JsonProperty
    private CreateBearing bearingA;

    @JsonProperty
    private CreateBearing bearingB;

    @JsonProperty
    private double xD1;

    @JsonProperty
    private double xD2;

    @JsonProperty
    private CreateLoad load;

    @JsonProperty
    private double a;

    @JsonProperty
    private double b;

    @JsonProperty
    private double c;
}
