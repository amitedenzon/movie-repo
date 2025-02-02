package org.example.entity.DAO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.example.entity.DTO.MovieDTO;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "movie")
public class Movie extends StandardEntity implements DAO<MovieDTO> {

    @Column
    private Integer stars;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "director_id")
    private Director director;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "movie_actors",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private List<Actor> actors;

    @Override
    public MovieDTO convertToDTO() {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setId(this.getId());
        movieDTO.setName(this.getName());
        movieDTO.setStars(this.getStars());

        if (this.getDirector() != null) {
            movieDTO.setDirectorName(this.getDirector().getName());
        }

        if (this.getActors() != null) {
            List<String> actorNames = this.getActors().stream()
                    .map(Actor::getName)
                    .collect(Collectors.toList());
            movieDTO.setActorNames(actorNames);
        }

        return movieDTO;
    }
}
