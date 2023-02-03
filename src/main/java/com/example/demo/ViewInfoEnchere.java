package com.example.demo;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="mettre_enchere")
@NoArgsConstructor
public class ViewInfoEnchere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmettre_enchere", nullable=false)
    private int idmettre_enchere;

    @ManyToOne(targetEntity = Utilisateur.class)
    @JoinColumn(name = "idutilisateur",referencedColumnName = "idutilisateur")
    private Utilisateur utilisateur;

    @ManyToOne(targetEntity = Categorie_Enchere.class)
    @JoinColumn(name = "idcategorie_enchere",referencedColumnName = "idcategorie_enchere")
    private Categorie_Enchere categorie_enchere;

    @Column(name = "debut", nullable = false)
    private LocalDateTime debut=LocalDateTime.now();

    @ManyToOne(targetEntity = Duree.class)
    @JoinColumn(name = "idduree",referencedColumnName = "idduree")
    private Duree duree_heure;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "mise_minimale", nullable = false)
    private double mise_minimale;

    @Column(name = "statut", nullable = false)
    private int statut;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "photo", nullable = false)
    private String photo;


}
