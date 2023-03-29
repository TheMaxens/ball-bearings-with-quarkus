package org.dhbw.mosbach.ai.framework.adapters.input.rest.request;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonInclude;

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
    @Valid
    private CreateBearing bearingA;

    @Valid
    private CreateBearing bearingB;

    @Min(0)
    private double xD1;

    @Min(0)
    private double xD2;

    @Valid
    private CreateLoad load;

    @Min(0)
    private double a;

    @Min(0)
    private double b;

    @Min(0)
    private double c;
}
