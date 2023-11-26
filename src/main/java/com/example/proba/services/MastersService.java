package com.example.proba.services;

import com.example.proba.models.Image;
import com.example.proba.models.Masters;
import com.example.proba.repositories.MasterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class MastersService {
    private final MasterRepository masterRepository;

    public List<Masters> mastersList(String name){
        if(name != null) return masterRepository.findByFullname(name);
        return masterRepository.findAll();
    }

    public boolean addMasters(Masters masters, MultipartFile photo) throws IOException {
        if (masterRepository.findAllByFullname(masters.getFullname()) != null) {
            return false;
        }
        Image image5;
       if(photo.getSize()!=0){
           image5 = toImage(photo);
           masters.addImage(image5);
       }
        masterRepository.save(masters);
        return true;
    }

    private Image toImage(MultipartFile file) throws IOException {
        Image image=new Image();
        image.setName(file.getName());
        image.setOriginalFilename(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }
}
