package org.example.service;

import org.example.entity.DAO.Director;
import org.example.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DirectorService {
    private final DirectorRepository directorRepository;

    @Autowired
    public DirectorService(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    public List<Director> getAllDirectors() {
        return directorRepository.findAll();
    }

    public Optional<Director> getDirectorById(String id) {
        return directorRepository.findById(id);
    }

    public Director saveDirector(Director Director) {
        return directorRepository.save(Director);
    }

    public List<Director> saveDirectors(List<Director> Directors) {
        return directorRepository.saveAll(Directors);
    }

    public void deleteDirector(String id) {
        directorRepository.deleteById(id);
    }

}
