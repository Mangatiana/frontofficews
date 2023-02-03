package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtlisateurRep extends JpaRepository<Utilisateur,Integer> {
    @Query(value = "select * from utilisateur where idutilisateur = :idutilisateur",nativeQuery = true)
    Utilisateur findByIdutilisateur(@Param("idutilisateur") int idutilisateur);

    
}
