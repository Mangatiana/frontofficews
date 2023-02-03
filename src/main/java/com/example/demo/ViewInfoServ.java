package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
public class ViewInfoServ {
    @Autowired
    ViewInfoRepo eRep;

    public ArrayList<ViewInfoEnchere> getInfo(){
        ArrayList<ViewInfoEnchere> encheres = new ArrayList<ViewInfoEnchere>();
        for(ViewInfoEnchere enchere : eRep.getAllInfoCours()){
            encheres.add(enchere);

        }
        return encheres;
    }
}
