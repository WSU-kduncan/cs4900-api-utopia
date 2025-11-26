package org.utopia.fitnessdb.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.security.auth.login.FailedLoginException;

import org.springframework.stereotype.Service;
import org.utopia.fitnessdb.dto.TrainerDto;
import org.utopia.fitnessdb.mapper.TrainerDtoMapper;
import org.utopia.fitnessdb.model.Client;
import org.utopia.fitnessdb.model.Trainer;
import org.utopia.fitnessdb.model.Session;
import org.utopia.fitnessdb.repository.ClientRepository;
import org.utopia.fitnessdb.repository.SessionRepository;
import org.utopia.fitnessdb.repository.TrainerRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TrainerService {
    private final TrainerRepository trainerRepository;
    private final TrainerDtoMapper trainerDtoMapper;
    private final ClientRepository clientRepository;
    private final SessionRepository sessionRepository;

    public List<Trainer> getAllTrainers() {
        return trainerRepository.findAll();
    }

    public Trainer getTrainerById(Integer id) throws EntityNotFoundException {
        Optional<Trainer> trainer = trainerRepository.findById(id);
        if (trainer.isEmpty()) {
            throw new EntityNotFoundException("Trainer with ID " + id + " not found");
        }
        return trainer.get();
    }

    public Trainer getTrainerByEmail(String email) throws EntityNotFoundException {
        Optional<Trainer> trainer = trainerRepository.findByEmail(email);
        if (trainer.isEmpty()) {
            throw new EntityNotFoundException("Trainer with email " + email + " not found");
        }
        return trainer.get();
    }

    public Trainer trainerLogin(String email, String passwordHash) throws EntityNotFoundException, FailedLoginException {
        Trainer trainer = getTrainerByEmail(email);

        if (!Objects.equals(trainer.getPasswordHash(), passwordHash)) {
            throw new FailedLoginException("Incorrect password.");
        }

        return trainer;
    }

    public Trainer createTrainer(TrainerDto trainerDto) throws EntityNotFoundException {
        return trainerRepository.saveAndFlush(trainerDtoMapper.toEntity(trainerDto));
    }

    public Trainer updateTrainer(Integer id, TrainerDto trainerDto) throws EntityNotFoundException {
        Trainer trainer = trainerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Trainer with ID " + id + " not found"));

        if (trainerDto.getEmail() != null) trainer.setEmail(trainerDto.getEmail());
        if (trainer.getName() != null) trainer.setName(trainerDto.getName());
        if (trainer.getPasswordHash() != null) trainer.setPasswordHash(trainerDto.getPasswordHash());

        return trainerRepository.saveAndFlush(trainer);
    }

    public void deleteTrainer(Integer id) {
        if (!trainerRepository.existsById(id)) {
            throw new EntityNotFoundException("Trainer not found with id " + id);
        }

        List<Client> clients = clientRepository.findByTrainerId(id);
        for (Client c : clients) {
            c.setTrainer(null);
            clientRepository.save(c);
        }

        List<Session> sessions = sessionRepository.findByTrainerId(id);
        for (Session s : sessions) {
            s.setTrainer(null);
            sessionRepository.save(s);
        }

        trainerRepository.deleteById(id);
    }

}
