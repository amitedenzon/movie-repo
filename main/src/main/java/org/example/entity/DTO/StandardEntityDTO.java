package org.example.entity.DTO;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public abstract class StandardEntityDTO {
    protected String id;
    protected String name;
}
