package org.utopia.fitnessdb.service;

import jakarta.persistence.EntityNotFoundException;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.utopia.fitnessdb.model.Routine;
import org.utopia.fitnessdb.repository.RoutineRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoutineService {
    private final RoutineRepository routineRepository;

    public List<Routine> getAllRoutines() {
        return routineRepository.findAll();
    }

    public Routine getRoutineById(Integer id) throws EntityNotFoundException {
        Optional<Routine> Routine = routineRepository.findById(id);
        if (Routine.isEmpty()) {
            throw new EntityNotFoundException("Routine with ID: " + id + " not found");
        }
        return Routine.get();
    }

    public Routine getRoutineByName(String name) throws EntityNotFoundException {
        Optional<Routine> Routine = routineRepository.findByName(name);
        if (Routine.isEmpty()) {
            throw new EntityNotFoundException("Routine with email: " + name + " not found");
        }
        return Routine.get();
    }
}
