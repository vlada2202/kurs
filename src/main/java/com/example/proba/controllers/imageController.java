package com.example.proba.controllers;

import com.example.proba.models.Image;
import lombok.RequiredArgsConstructor;
import com.example.proba.repositories.imageRepository;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;

@RestController
@RequiredArgsConstructor
public class imageController {
    private final imageRepository imageRepository;

    @GetMapping("/images/{id}")
    private ResponseEntity<?> getImageById(@PathVariable Long id)
    {
        Image image=imageRepository.findById(id).orElse(null);
        return ResponseEntity.ok().
                header("fileName",image.getOriginalFilename()).
                contentType(MediaType.valueOf(image.getContentType())).
                contentLength(image.getSize()).
                body(new InputStreamResource(new ByteArrayInputStream(image.getBytes())));
    }

}
