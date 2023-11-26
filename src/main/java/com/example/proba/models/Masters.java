package com.example.proba.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
@Entity
@Table(name = "masters")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Masters {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "fullname")
    private String fullname;
    @Column(name = "description")
    private String description;
    @Column(name="photo",columnDefinition = "longblob")
    @Lob
    private byte[] photo;
    public void addImage(Image image){
        photo= image.getBytes();
    }

}
