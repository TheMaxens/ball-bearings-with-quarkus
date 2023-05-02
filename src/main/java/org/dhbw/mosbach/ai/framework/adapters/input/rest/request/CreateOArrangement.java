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
    private CreateBearing bearing_a;

    @Valid
    private CreateBearing bearing_b;

    @Min(0)
    private double xd1;

    @Min(0)
    private double xd2;

    @Valid
    private CreateLoad load;

    @Min(0)
    private double a;

    @Min(0)
    private double b;

    @Min(0)
    private double c;
}
