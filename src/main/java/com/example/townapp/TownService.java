package com.example.townapp;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TownService {

    private final TownRepository townRepository;

    public TownService(TownRepository townRepository) {
        this.townRepository = townRepository;
    }

    public List<Town> getAllTowns() {
        return townRepository.findAll();
    }

    public Optional<Town> getTownById(Long id) {
        return townRepository.findById(id);
    }

    public Town addTown(Town town) {
        return townRepository.save(town);
    }

    public void deleteTown(Long id) {
        townRepository.deleteById(id);
    }

    public Town updateTown(Long id, Town updatedTown) {
        return townRepository.findById(id)
                .map(existingTown -> {
                    existingTown.setTitle(updatedTown.getTitle());
                    existingTown.setResidents(updatedTown.getResidents());
                    existingTown.setBackground(updatedTown.getBackground());
                    existingTown.setLocation(updatedTown.getLocation());
                    return townRepository.save(existingTown);
                })
                .orElseThrow(() -> new RuntimeException("Town not found"));
    }

    public List<Town> searchByTitle(String titlePart) {
        return townRepository.findByTitleContaining(titlePart);
    }

    public List<Town> searchByResidents(Long residents) {
        return townRepository.findByResidents(residents);
    }

    public List<Town> searchByResidentsRange(Long min, Long max) {
        return townRepository.findByResidentsBetween(min, max);
    }

    public List<Town> searchByBackgroundKeyword(String keyword) {
        return townRepository.findByBackgroundContaining(keyword);
    }
}

