package com.example.townapp;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TownRepository extends JpaRepository<Town, Long> {
    List<Town> findByTitleContaining(String titlePart);
    List<Town> findByResidentsBetween(Long minResidents, Long maxResidents);
    List<Town> findByBackgroundContaining(String keyword);
    List<Town> findByResidents(Long residents);
}
