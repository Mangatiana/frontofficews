package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategorieEnchereRep  extends JpaRepository<Categorie_Enchere,Integer> {
    @Query(value = "select * from categorie_enchere where idcategorie_enchere = : idcategorie_enchere", nativeQuery = true)
    Categorie_Enchere findByIdCategorie(@Param("idcategorie_enchere")int idcategorie_enchere);
}
