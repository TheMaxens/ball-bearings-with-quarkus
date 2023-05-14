package org.dhbw.mosbach.ai.domain.vo;

import java.util.UUID;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class Id {

    private final UUID uuid;

    private Id(UUID uuid) {
        this.uuid = uuid;
    }

    public Id() {
        this.uuid = UUID.randomUUID();
    }

    public static Id withId(String id) {
        return new Id(UUID.fromString(id));
    }

    public static Id withoutId() {
        return new Id(UUID.randomUUID());
    }
}
