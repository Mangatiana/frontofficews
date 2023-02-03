package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface ViewInfoRepo extends JpaRepository<ViewInfoEnchere,Integer>{
    @Query(value = "select * from vue_mettre_enchere_photo where statut=0",nativeQuery = true)
    List<ViewInfoEnchere> getAllInfoCours();


}
