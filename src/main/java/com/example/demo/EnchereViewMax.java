package com.example.demo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
public class EnchereViewMax {
        Enchere enchere;

         String photo;

         double max;

         String nom_gagnant;


         String prenom;

    }