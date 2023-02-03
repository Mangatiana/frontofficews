package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@CrossOrigin
public class Categorie_EnchereContr {
    @Autowired
    Categorie_EnchereServ cserve;

    @GetMapping("/categories")
    public ArrayList<Categorie_Enchere> getAll(){
        return cserve.getAll();
    }
}
