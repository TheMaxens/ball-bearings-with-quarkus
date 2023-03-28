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
public class CreateBearing {

    @JsonProperty
    private double cdyn;

    @JsonProperty
    private double y;

    @JsonProperty
    private double e;

    @JsonProperty
    private double xB1;
}
