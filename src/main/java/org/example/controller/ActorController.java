package org.example.controller;

import org.example.entity.DAO.Actor;
import org.example.entity.DTO.ActorDTO;
import org.example.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/actors")
public class ActorController {
    private final ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping
    public List<ActorDTO> getAllActors() {
        return actorService.getAllActors().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ActorDTO getActorById(@PathVariable String id) {
        Optional<Actor> actor = actorService.getActorById(id);
        return actor.map(this::convertToDTO).orElse(null);
    }

    @PostMapping
    public ActorDTO saveActor(@RequestBody Actor actor) {
        Actor savedActor = actorService.saveActor(actor);
        return convertToDTO(savedActor);
    }

    @PostMapping("/saveAll")
    public List<ActorDTO> saveActors(@RequestBody List<Actor> actors) {
        List<Actor> savedActors = actorService.saveActors(actors);
        return savedActors.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void deleteActor(@PathVariable String id) {
        actorService.deleteActor(id);
    }

    private ActorDTO convertToDTO(Actor actor) {
        return actor.convertToDTO();
    }
}
