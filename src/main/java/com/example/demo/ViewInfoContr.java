package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@CrossOrigin
public class ViewInfoContr {
    @Autowired
    ViewInfoServ eS;

    @GetMapping("/infoencours")
    public ArrayList<ViewInfoEnchere> getCours(){
        return eS.getInfo();
    }

}
