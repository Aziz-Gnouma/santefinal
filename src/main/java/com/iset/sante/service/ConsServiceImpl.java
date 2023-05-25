package com.iset.sante.service;

import com.iset.sante.entities.Appointment;
import com.iset.sante.repositories.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public class ConsultationServiceImpl  implements ConsulationService {
    @Autowired
    private ConsultationRepository ConsultationRepository;



    @Override
    public List<Appointment> getAllConsulation() {
        return ConsultationRepository.findAll();
    }


    @Override
    public void saveConsulation(Appointment appointment) {
        this.ConsultationRepository.save(appointment);
    }



    @Override
    public Appointment getConsulationById(long id) {
        Optional<Appointment> optional = ConsultationRepository.findById(id);
        Appointment Consulation = null;
        if (optional.isPresent()) {
            Consulation = optional.get();
        } else {
            throw new RuntimeException(" Appointment not found for id :: " + id);
        }
        return Consulation;
    }

    @Override
    public void deleteConsulationById(long id) {
        this.ConsultationRepository.deleteById(id);
    }

    @Override
    public Page<Appointment> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.ConsultationRepository.findAll(pageable);

    }
    @Override
    public List<Appointment> findByConsulation(Appointment appointment) {
        return null;
    }
}
