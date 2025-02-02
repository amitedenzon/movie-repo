package org.example.entity.DAO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.example.entity.DTO.DirectorDTO;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Director")
public class Director extends Human implements DAO<DirectorDTO> {

    @OneToMany(mappedBy = "director", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Movie> directedMovies;

    @Override
    public DirectorDTO convertToDTO() {
        DirectorDTO directorDTO = new DirectorDTO();
        directorDTO.setId(this.getId());
        directorDTO.setName(this.getName());

        // Get movie names or ids directed by the director
        if (this.getDirectedMovies() != null) {
            List<String> movieNames = this.getDirectedMovies().stream()
                    .map(Movie::getName)
                    .collect(Collectors.toList());
            directorDTO.setMovies(movieNames);
        }

        return directorDTO;
    }
}
