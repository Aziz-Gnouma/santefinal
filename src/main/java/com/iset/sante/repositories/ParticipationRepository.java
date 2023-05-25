package com.iset.sante.repositories;

import com.iset.sante.entities.Participation;
import com.iset.sante.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipationRepository extends JpaRepository<Participation, Long> {
    List<Participation> findByUser(User user);
}
