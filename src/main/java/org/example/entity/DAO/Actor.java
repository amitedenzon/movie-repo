package org.example.entity.DAO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.example.entity.DTO.ActorDTO;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "actor")
public class Actor extends Human implements DAO<ActorDTO> {

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "movie_actors",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    private List<Movie> movies;

    @Override
    public ActorDTO convertToDTO() {
        ActorDTO actorDTO = new ActorDTO();
        actorDTO.setId(this.getId());
        actorDTO.setName(this.getName());

        // Get movie names or ids the actor has acted in
        if (this.getMovies() != null) {
            List<String> movieNames = this.getMovies().stream()
                    .map(Movie::getName)
                    .collect(Collectors.toList());
            actorDTO.setMovies(movieNames);
        }

        return actorDTO;
    }
}
