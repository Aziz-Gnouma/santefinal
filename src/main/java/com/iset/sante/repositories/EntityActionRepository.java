package com.iset.sante.repositories;


import com.iset.sante.entities.Action;
import com.iset.sante.entities.Evenement;
import org.hibernate.action.internal.EntityAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntityActionRepository extends JpaRepository<Action, Long> {

    @Query("select p from Action p where p.evenement = ?1")
    List<Action> findByEvenement (Evenement evenement);

}
