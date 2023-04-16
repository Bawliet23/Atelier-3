package com.example.atelier2.repositories;

import com.example.atelier2.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPatientRepository extends JpaRepository<Patient,Long> {
    Patient findByNom(String name);
    Page<Patient> findByMalade(boolean m, Pageable pageable);
    Page<Patient> findByNomContains(String kw, Pageable pageable);
    @Query("select p from Patient p where p.nom like :x and p.score>=:y")
    List<Patient> chercherPatient(@Param("x") String nom, @Param("y") int scoreMin);
}
