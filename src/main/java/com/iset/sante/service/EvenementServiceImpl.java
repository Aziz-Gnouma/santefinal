package com.iset.sante.service;


import com.iset.sante.entities.*;
import com.iset.sante.repositories.ActionRepoitory;
import com.iset.sante.repositories.ConsultationRepository;
import com.iset.sante.repositories.EvenementRepository;
import com.iset.sante.repositories.reponseRepository;
import com.iset.sante.repositories.interessantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EvenementServiceImpl implements EvenementService {

    @Autowired
    private EvenementRepository EvenementRepository;
    @Autowired
    private reponseRepository reponseRepository;
    @Autowired
    private interessantRepository interessantRepository;

    @Autowired
    private ActionRepoitory ActionRepoitory;

    @Autowired
    private ConsultationRepository ConsultationRepository;




    @Override
    public List<Evenement> getAllEvenement() {
        return EvenementRepository.findAll();
    }
    @Override
    public List<Action> getAllActions() {
        return ActionRepoitory.findAll();
    }



    @Override
    public void saveEvent(Evenement evenement) {
        this.EvenementRepository.save(evenement);
    }

    @Override
    public void saveRep(reponse reponse) {
        this.reponseRepository.save(reponse);
    }

    @Override
    public Action saveAct(Action action) {
        return ActionRepoitory.save(action);
    }

    @Override
    public interessant saveI(interessant interessant) {
        return interessantRepository.save(interessant);
    }

    @Override
    public List<Action> findByEvenement(Evenement evenement) {
        return null;
    }
    @Override
    public Evenement getEvenementById(long id) {
        Optional<Evenement> optional = EvenementRepository.findById(id);
        Evenement evenement = null;
        if (optional.isPresent()) {
            evenement = optional.get();
        } else {
            throw new RuntimeException(" Evenement not found for id :: " + id);
        }
        return evenement;
    }

    @Override
    public Appointment getConstById(long id) {
        Optional<Appointment> optional = ConsultationRepository.findById(id);
        Appointment appointment = null;
        if (optional.isPresent()) {
            appointment = optional.get();
        } else {
            throw new RuntimeException(" appoiment not found for id :: " + id);
        }
        return appointment;
    }

    @Override
    public void deleteEvenementById(long id) {
        this.EvenementRepository.deleteById(id);
    }
    @Override
    public void deleteConsById(long id) {
        this.ConsultationRepository.deleteById(id);
    }


    @Override
    public Page<Evenement> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.EvenementRepository.findAll(pageable);

    }


    @Override
    public void saveConsulation(Appointment appointment) {
        this.ConsultationRepository.save (appointment);
    }

    @Override
    public List<Appointment> getAllConsulation() {
        return ConsultationRepository.findAll();
    }

    @Override
    public List<reponse> getAllreponse() {
        return reponseRepository.findAll();
    }
}
