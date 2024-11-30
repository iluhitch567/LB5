package com.example.townapp;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/towns")
public class TownController {

    private final TownService townService;

    public TownController(TownService townService) {
        this.townService = townService;
    }

    @GetMapping
    public List<Town> getAllTowns() {
        return townService.getAllTowns();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Town> getTownById(@PathVariable Long id) {
        return townService.getTownById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Town addTown(@RequestBody Town town) {
        return townService.addTown(town);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTown(@PathVariable Long id) {
        townService.deleteTown(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public Town updateTown(@PathVariable Long id, @RequestBody Town updatedTown) {
        return townService.updateTown(id, updatedTown);
    }

    @GetMapping("/search")
    public List<Town> searchTowns(@RequestParam(required = false) String title,
                                  @RequestParam(required = false) Long residents,
                                  @RequestParam(required = false) Long minResidents,
                                  @RequestParam(required = false) Long maxResidents,
                                  @RequestParam(required = false) String backgroundKeyword) {
        if (title != null) return townService.searchByTitle(title);
        if (residents != null) return townService.searchByResidents(residents);
        if (minResidents != null && maxResidents != null) {
            return townService.searchByResidentsRange(minResidents, maxResidents);
        }
        if (backgroundKeyword != null) return townService.searchByBackgroundKeyword(backgroundKeyword);
        return townService.getAllTowns();
    }
}
