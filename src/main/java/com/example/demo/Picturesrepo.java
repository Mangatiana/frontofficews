package com.example.demo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface Picturesrepo extends MongoRepository<Pictures,String>{
    public Photo findPhotoByIdproduit(int idproduit);
}
