package com.example.proba.repositories;

import com.example.proba.models.Appointment;
import com.example.proba.models.Masters;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MasterRepository extends JpaRepository<Masters,Long> {
    List<Masters> findByFullname(String fullname);

    //    @Query(value = "SELECT * FROM Appointment WHERE appointment = ?", nativeQuery = true)
    Masters findAllByFullname(String fullname);
}
