package com.iset.sante.service;


import com.iset.sante.entities.*;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EvenementService {
    List<Evenement> getAllEvenement();
    void saveEvent(Evenement evenement);
    void saveRep(reponse reponse);
    Evenement getEvenementById(long id);
    Appointment getConstById(long id);
    void deleteEvenementById(long id);
    void deleteConsById(long id);
    Page<Evenement> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
    Action saveAct(Action action);
    interessant  saveI(interessant interessant);
    List<Action> findByEvenement (Evenement evenement);
    List<Action> getAllActions();
    void saveConsulation(Appointment appointment);
    List<Appointment> getAllConsulation();
    List<reponse> getAllreponse();

}
