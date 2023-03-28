package org.dhbw.mosbach.ai.framework.adapters.input.rest.request;

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
    @JsonProperty
    private double fr;

    @JsonProperty
    private double fa;

    @JsonProperty
    private double n;

    @JsonProperty
    private double xD2;

    @JsonProperty
    private double xr;

    @JsonProperty
    private double ya;
}
