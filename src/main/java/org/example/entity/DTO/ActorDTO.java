package org.example.entity.DTO;

import lombok.Getter;
import lombok.Setter;
import org.example.entity.DAO.Actor;
import org.example.entity.DAO.Movie;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class ActorDTO extends StandardEntityDTO{
    List<String> movies;
}
