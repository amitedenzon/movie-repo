package org.example.entity.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class HumanDTO extends StandardEntityDTO {

    private Integer age;
    private String catchPhrase;
}


