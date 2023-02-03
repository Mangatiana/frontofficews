package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@CrossOrigin
public class EncherirContr {
    @Autowired
    EncherirServ es;
    @Autowired
    MouvementService ms;

    /*@GetMapping ("/encherir")
    public void encherir(@RequestBody Encherir e) throws SQLException, ClassNotFoundException {
        ms.rencherir(e);
        es.enchr(e);

    }*/
    @GetMapping ("/encherir")
    public void encherir(@RequestParam (value="idu") int idu,@RequestParam (value="solde") double solde,@RequestParam (value="ide") int ide,@RequestParam (value="montant") double montant) throws SQLException, ClassNotFoundException {
       Encherir e=new Encherir();
       Utilisateur u=new Utilisateur();
       u.setIdutilisateur(idu);
       u.setSolde(solde);
       e.setUtilisateur(u);
       Enchere enc=new Enchere();
       enc.setIdmettre_enchere(ide);
       e.setMettre_enchere(enc);
       e.setMontant(montant);
        ms.rencherir(e);
       /* es.enchr(e);*/

    }

}
