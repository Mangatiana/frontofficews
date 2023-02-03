package com.example.demo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface Photoorepo extends MongoRepository<Photoo,String>{
    public Photo findPhotoByIdproduit(int idproduit);
}
