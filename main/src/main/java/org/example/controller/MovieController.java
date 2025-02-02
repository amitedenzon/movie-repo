package org.example.controller;

import org.example.entity.DAO.Movie;
import org.example.entity.DTO.MovieDTO;
import org.example.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<MovieDTO> getAllMovies() {
        return movieService.getAllMovies().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/id/{id}")
    public MovieDTO getMovieById(@PathVariable String id) {
        Optional<Movie> movie = movieService.getMovieById(id);
        return movie.map(this::convertToDTO).orElse(null);
    }

    @GetMapping("/name/{name}")
    public MovieDTO getMovieByName(@PathVariable String name) {
        Optional<Movie> movie = movieService.getMovieByName(name);
        return movie.map(this::convertToDTO).orElse(null);
    }

    @PostMapping
    public MovieDTO saveMovie(@RequestBody Movie movie) {
        Movie savedMovie = movieService.saveMovie(movie);
        return convertToDTO(savedMovie);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable String id) {
        movieService.deleteMovie(id);
    }

    private MovieDTO convertToDTO(Movie movie) {
        return movie.convertToDTO();
    }
}
