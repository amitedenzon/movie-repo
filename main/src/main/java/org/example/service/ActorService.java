package org.example.service;

import org.example.entity.DAO.Actor;
import org.example.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorService {
    private final ActorRepository actorRepository;

    @Autowired
    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }

    public Optional<Actor> getActorById(String id) {
        return actorRepository.findById(id);
    }

    public Actor saveActor(Actor Actor) {
        return actorRepository.save(Actor);
    }

    public List<Actor> saveActors(List<Actor> Actors) {
        return actorRepository.saveAll(Actors);
    }

    public void deleteActor(String id) {
        actorRepository.deleteById(id);
    }

}
