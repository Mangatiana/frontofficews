package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
@Service
public class Photooserv {
    @Autowired
    Photoorepo photoRepository;

    public Object getPhotoByidProduit(int idProduit){
        try{
            Object obj=photoRepository.findPhotoByIdproduit(idProduit);
            return new Data(obj);   
        }
        catch (Exception e){
            return new Error(e);
        }
    }
    public Photo getPhotoByid(int idProduit)throws Exception{
        Photo obj=photoRepository.findPhotoByIdproduit(idProduit);
        return obj;
    }

    public void save(Photoo p){
        photoRepository.save(p);
    }
}
