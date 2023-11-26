package com.example.proba.repositories;

import com.example.proba.models.Appointment;
import com.example.proba.models.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AppoinmentRepository extends JpaRepository<Appointment,Long> {
    List<Appointment> findByName(String name);

//    @Query(value = "SELECT * FROM Appointment WHERE appointment = ?", nativeQuery = true)
    Appointment findAllByName(String name);
}
