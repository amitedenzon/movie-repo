package org.example.entity.DTO;

import lombok.Getter;
import lombok.Setter;
import org.example.entity.DAO.Director;
import org.example.entity.DAO.Movie;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class DirectorDTO extends StandardEntityDTO{
    List<String> movies;
}
