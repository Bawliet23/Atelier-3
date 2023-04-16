package com.example.atelier2;

import com.example.atelier2.entities.Patient;
import com.example.atelier2.repositories.IPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Atelier2Application implements CommandLineRunner {
    @Autowired
    private IPatientRepository patientRepository;
    public static void main(String[] args) {
        SpringApplication.run(Atelier2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        patientRepository.save(new Patient(null,"mohamed",new Date(1999, Calendar.MAY,24),false,25));
        patientRepository.save(new Patient(null,"yassine",new Date(1999, Calendar.MAY,24),false,25));
        patientRepository.save(new Patient(null,"tarik",new Date(1999, Calendar.MAY,24),false,25));
        List<Patient> patients = patientRepository.findAll();
        patients.forEach(patient -> {
            System.out.println("****************");
            System.out.println(patient.getId());
            System.out.println(patient.getNom());
            System.out.println(patient.getDateNaissance());
            System.out.println(patient.getScore());
            System.out.println("****************");
        });


        /* chercher par nom */
        Patient p1 = patientRepository.findByNom("mohamed");
        System.out.println(p1.toString());


        /*update*/
        Patient p = patientRepository.findById(1L).orElse(null);
        p.setNom("kira");
        patientRepository.save(p);
        List<Patient> patients1 = patientRepository.findAll();
        System.out.println("update");
        patients1.forEach(patient -> {
            System.out.println("****************");
            System.out.println(patient.getId());
            System.out.println(patient.getNom());
            System.out.println(patient.getDateNaissance());
            System.out.println(patient.getScore());
            System.out.println("****************");
        });


        /* delete */
        patientRepository.deleteById(p.getId());
        List<Patient> patients2 = patientRepository.findAll();
        System.out.println("deleteById");
        patients2.forEach(patient -> {
            System.out.println("****************");
            System.out.println(patient.getId());
            System.out.println(patient.getNom());
            System.out.println(patient.getDateNaissance());
            System.out.println(patient.getScore());
            System.out.println("****************");
        });
        /* cherche par nom et score */
        List<Patient> patients3 = patientRepository.chercherPatient("yassine",22);
        System.out.println("chercherPatient");
        patients3.forEach(patient -> {
            System.out.println(patient.getId());
            System.out.println(patient.getNom());
            System.out.println(patient.getDateNaissance());
            System.out.println(patient.getScore());
            System.out.println("****************");
        });
    }
}
