package org.utopia.fitnessdb.controller;

import org.utopia.fitnessdb.TrainerDTO;
import org.utopia.fitnessdb.Trainer;
import org.utopia.fitnessdb.TrainerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/trainers")
public class TrainerController {

    private final TrainerService trainerService;

    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @GetMapping
    public List<Trainer> getAllTrainers() {
        return trainerService.getAllTrainers();
    }

    @GetMapping("/{id}")
    public Optional<Trainer> getTrainerById(@PathVariable Integer id) {
        return trainerService.getTrainerById(id);
    }

    @GetMapping("/search")
    public List<Trainer> searchTrainersByName(@RequestParam String name) {
        return trainerService.searchTrainersByName(name);
    }
}
