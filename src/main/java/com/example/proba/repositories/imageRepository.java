package com.example.proba.repositories;

import com.example.proba.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface imageRepository extends JpaRepository<Image,Long> {
}
