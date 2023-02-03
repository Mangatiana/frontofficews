package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
@CrossOrigin
public class PhotooContr {
    @Autowired
    Photooserv photoService;
    @Autowired
    PhotoRepository pr;
    @Autowired
    Picturesrepo pic;

    @GetMapping("/{idproduit}")
    private Object getVProduit(@PathVariable("idproduit") int produitid) {
        return photoService.getPhotoByidProduit(produitid);
    }

    @PostMapping("/insertp")
    public void addPhoto(@RequestBody Photoo photo){
        photoService.save(photo);
        System.out.println("ao");
    }
    @GetMapping("/getphoto")
    public List<Pictures> getPhoto(){

        return pic.findAll();
    }

    @PutMapping()
    private void updatePhoto(@RequestBody Photoo photo){
        photoService.save(photo);
    }
}
