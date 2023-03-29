package org.dhbw.mosbach.ai.framework.adapters.input.rest.request;

import javax.validation.constraints.Min;

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
public class CreateLoad {
    @Min(0)
    private double fr;

    @Min(0)
    private double fa;

    @Min(0)
    private double n;

    @Min(0)
    private double xr;

    @Min(0)
    private double ya;
}
