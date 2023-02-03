package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;

@RestController
@CrossOrigin
public class UtilisateurContr {
    @Autowired
    UtilisateurServ userv;

    @GetMapping("/listUser")
    public ArrayList<Utilisateur> getListUser() {
        return userv.getAll();
    }

    @GetMapping("/login")
    public Utilisateur login(@RequestParam(value = "mail")String mail, @RequestParam(value = "motdepasse")String mdp) throws SQLException {
        return userv.log(mail, mdp);

    }
    @GetMapping("/deco")
    public Boolean deco(@RequestParam (value = "mail")String mail,@RequestParam(value = "motdepasse")String mdp) {
        return userv.deco(mail, mdp);

    }
    @GetMapping("/token")
    public String genererTkn(@RequestParam(value = "mail")String mail){
        return userv.genererToken(mail);
    }

    @GetMapping("/check")
    public Boolean ckeck(@RequestParam(value = "nom")String mail){
        return userv.check_token_si_valide(mail);

    }

    @PostMapping("/inscrire")
    public void inscrire(@RequestBody Utilisateur e){
        userv.inscription(e);
    }
    @GetMapping("/modifierSolde")
    public void modifierSolde(@RequestParam double entrant,Utilisateur utilisateur) throws SQLException, ClassNotFoundException {
        userv.mampitomboSolde(entrant,utilisateur);
    }

}
