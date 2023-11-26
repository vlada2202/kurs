package com.example.proba.services;

import com.example.proba.models.Image;
import com.example.proba.models.Products;
import com.example.proba.models.User;
import com.example.proba.repositories.ProductRepository;
import com.example.proba.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    public List<Products> listProducts(String title){
        if(title != null) return productRepository.findByTitle(title);
        return productRepository.findAll();
    }

    public void saveProduct(Principal principal,Products product, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException {
       product.setUser(getUserByPrincipal(principal));
        Image image1;
        Image image2;
        Image image3;
    if(file1.getSize()!=0)
        {
            image1=toImageEntity(file1);
            image1.setPreviewImage(true);
            product.addImageToProduct(image1);
        }
    if(file2.getSize()!=0)
        {
            image2=toImageEntity(file2);
            product.addImageToProduct(image2);
        }
    if(file3.getSize()!=0)
        {
            image3=toImageEntity(file3);
            product.addImageToProduct(image3);
        }
    log.info("Saving new Product.Title:{};Master:{}",product.getTitle(),product.getMaster());
    Products productsFromDb=productRepository.save(product);
    productsFromDb.setPreviewImageId(productsFromDb.getImages().get(0).getId());
    productRepository.save(product);
    }

    public User getUserByPrincipal(Principal principal) {
        if (principal == null)
        {
            return new User();
        }
        return userRepository.findByEmail(principal.getName());
    }

    private Image toImageEntity(MultipartFile file) throws IOException {
        Image image=new Image();
        image.setName(file.getName());
        image.setOriginalFilename(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }

    public void deleteProduct(Long id)
    {
        productRepository.deleteById(id);
    }


    public Products getProductById(Long id) {
       return productRepository.findById(id).orElse(null);
    }
}
