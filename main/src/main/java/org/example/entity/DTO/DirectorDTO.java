package org.example.entity.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DirectorDTO extends StandardEntityDTO{
    List<String> movies;
}
