package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.ArrayList;

@RestController
@CrossOrigin
public class EnchereViewMaxContr {
    @Autowired
    EnchereService enchereService;

    @GetMapping("/enchereavecmaxgagnant")
    public ArrayList<EnchereViewMax> getAll(@RequestParam(value="idutilisateur") int idutilisateur) throws SQLException, ClassNotFoundException {
        return enchereService.getAll(idutilisateur);
    }

    @GetMapping("/encoreencherir")
    public ArrayList<EnchereViewMax> encore(@RequestParam(value="idutilisateur") int idutilisateur) throws SQLException, ClassNotFoundException {
        return enchereService.encore(idutilisateur);
    }

    @GetMapping("/checkTous")
    public void check() throws SQLException, ClassNotFoundException {
            enchereService.checkStatutdesEncheres();
    }

}