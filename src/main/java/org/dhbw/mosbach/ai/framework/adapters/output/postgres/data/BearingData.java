package org.dhbw.mosbach.ai.framework.adapters.output.postgres.data;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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

    private double cdyn;

    private double y;

    private double e;

    private double xB1;

    private double p;

    private double fr;

    private double fa;

    private double lh10;
}
