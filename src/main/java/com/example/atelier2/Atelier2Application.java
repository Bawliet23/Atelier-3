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
        patientRepository.save(new Patient(null, "mohamed", new Date(1999, Calendar.MAY, 24), false, 25));
        patientRepository.save(new Patient(null, "yassine", new Date(1999, Calendar.MAY, 24), false, 25));
        patientRepository.save(new Patient(null, "tarik", new Date(1999, Calendar.MAY, 24), false, 25));
        patientRepository.save(new Patient(null, "gogo", new Date(1999, Calendar.MAY, 24), false, 100));
        patientRepository.save(new Patient(null, "saitama", new Date(1999, Calendar.MAY, 24), false, 100));
        patientRepository.save(new Patient(null, "tanjiro", new Date(1999, Calendar.MAY, 24), false, 25));
        patientRepository.save(new Patient(null, "songoku", new Date(1999, Calendar.MAY, 24), false, 25));
        patientRepository.save(new Patient(null, "narutp", new Date(1999, Calendar.MAY, 24), false, 25));
    }
}
