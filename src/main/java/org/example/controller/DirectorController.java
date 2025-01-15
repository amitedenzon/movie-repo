package org.example.controller;

import org.example.entity.DAO.Director;
import org.example.entity.DTO.DirectorDTO;
import org.example.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/directors")
public class DirectorController {
    private final DirectorService directorService;

    @Autowired
    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @GetMapping
    public List<DirectorDTO> getAllDirectors() {
        return directorService.getAllDirectors().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public DirectorDTO getDirectorById(@PathVariable String id) {
        Optional<Director> director = directorService.getDirectorById(id);
        return director.map(this::convertToDTO).orElse(null);
    }

    @PostMapping
    public DirectorDTO saveDirector(@RequestBody Director director) {
        Director savedDirector = directorService.saveDirector(director);
        return convertToDTO(savedDirector);
    }

    @PostMapping("/saveAll")
    public List<DirectorDTO> saveDirectors(@RequestBody List<Director> directors) {
        List<Director> savedDirectors = directorService.saveDirectors(directors);
        return savedDirectors.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void deleteDirector(@PathVariable String id) {
        directorService.deleteDirector(id);
    }

    private DirectorDTO convertToDTO(Director director) {
        return director.convertToDTO();
    }
}
