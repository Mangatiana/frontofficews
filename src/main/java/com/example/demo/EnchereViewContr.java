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
public class EnchereViewContr {
    @Autowired
    EnchereService enchereService;

    @GetMapping("/enchereavecmax")
    public ArrayList<EnchereView> getAll(@RequestParam(value = "idu") int idu) throws SQLException, ClassNotFoundException {
        return enchereService.listeEnchereAvecMax(idu);
    }

    @GetMapping("/enchereavecmax1")
    public ArrayList<EnchereView> getAll1(@RequestParam(value = "idu") int idu) throws SQLException, ClassNotFoundException {
        return enchereService.listeEnchereAvecMax1(idu);
    }
}
