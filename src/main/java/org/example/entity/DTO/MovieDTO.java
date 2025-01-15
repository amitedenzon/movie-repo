package org.example.entity.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MovieDTO extends StandardEntityDTO {

    private Integer stars;
    private String directorName; // Director's name or id
    private List<String> actorNames; // List of actor names or ids

}
