package org.example.entity.DTO;

import lombok.Getter;
import lombok.Setter;
import org.example.entity.DAO.Actor;
import org.example.entity.DAO.Movie;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class MovieDTO extends StandardEntityDTO{

    private Integer stars;
    private String directorName; // Director's name or id
    private List<String> actorNames; // List of actor names or ids

}
