package org.example.entity.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DirectorDTO extends HumanDTO{
    List<String> movies;
}
