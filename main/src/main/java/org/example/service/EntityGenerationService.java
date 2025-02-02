package org.example.service;

import jakarta.transaction.Transactional;
import org.example.entity.DAO.Actor;
import org.example.entity.DAO.Director;
import org.example.entity.DAO.Movie;
import org.example.repository.ActorRepository;
import org.example.repository.DirectorRepository;
import org.example.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class EntityGenerationService {

    private final ActorRepository actorRepository;
    private final DirectorRepository directorRepository;
    private final MovieRepository movieRepository;

    @Autowired
    public EntityGenerationService(ActorRepository actorRepository, DirectorRepository directorRepository, MovieRepository movieRepository) {
        this.actorRepository = actorRepository;
        this.directorRepository = directorRepository;
        this.movieRepository = movieRepository;
    }

    @Transactional
    public void generateEntities() {
        Actor actor1 = actorRepository.save(Actor.builder().name("Leonardo DiCaprio").age(49).catchPhrase("I have no regrets about my career.").build());
        Actor actor2 = actorRepository.save(Actor.builder().name("Matthew McConaughey").age(55).catchPhrase("Just keep living.").build());
        Actor actor3 = actorRepository.save(Actor.builder().name("Kate Winslet").age(48).catchPhrase("I'm still dreaming.").build());
        Actor actor4 = actorRepository.save(Actor.builder().name("Brad Pitt").age(60).catchPhrase("This is just the beginning.").build());
        Actor actor5 = actorRepository.save(Actor.builder().name("Tom Hardy").age(47).catchPhrase("I'm just here to create.").build());

        Director director1 = directorRepository.save(Director.builder().name("Christopher Nolan").age(53).catchPhrase("The only way to make a good movie is to believe in it.").build());
        Director director2 = directorRepository.save(Director.builder().name("Quentin Tarantino").age(60).catchPhrase("I steal from every single movie ever made.").build());

        Movie movie1 = Movie.builder()
                .name("Interstellar")
                .director(director1)
                .actors(Arrays.asList(actor1, actor2))
                .stars(5)
                .build();

        movieRepository.save(movie1);

        Movie movie2 = Movie.builder()
                .name("Inglourious Basterds")
                .director(director2)
                .actors(Arrays.asList(actor3, actor4, actor5))
                .stars(5)
                .build();

        movieRepository.save(movie2);

        System.out.println("Entities generated and saved to the database.");
    }
}
