package org.dhbw.mosbach.ai.framework.adapters.input.rest.request;

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
public class CreateBearing {
    @Min(0)
    private double cdyn;

    @Min(0)
    private double y;

    @Min(0)
    private double e;

    @Min(0)
    private double xB1;
}
