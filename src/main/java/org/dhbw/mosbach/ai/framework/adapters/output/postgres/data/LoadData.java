package org.dhbw.mosbach.ai.framework.adapters.output.postgres.data;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "loads")
public class LoadData {
    @Id
    @GeneratedValue
    private UUID id;

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
