package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

@Service
public class EnchereService {
    @Autowired
    EnchereRepository eRep;

    @Autowired
    UtilisateurServ userSev;
    public ArrayList<Enchere> getAll(){
        ArrayList<Enchere> encheres = new ArrayList<Enchere>();
        for(Enchere enchere : eRep.findAll()){
            encheres.add(enchere);

        }
        return encheres;
    }
    public Connection getConnex() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection("jdbc:postgresql://containers-us-west-196.railway.app:6815/railway?user=postgres&password=MKyy3iS7wOBvOBDO4vxo");
    }
    public void ajouter(Enchere v){
        eRep.save(v);
    }
    public int getId() throws ClassNotFoundException, SQLException{
        Connection con = getConnex();
        int id=0;
        PreparedStatement ps = con.prepareStatement("select * from mettre_enchere order by idmettre_enchere desc limit 1");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) { id=rs.getInt("idmettre_enchere"); }
        rs.close();
        ps.close();
        con.close();
        
        return id;
    }



    public ArrayList<Enchere> getEnchereEnCours() {
        ArrayList<Enchere> liste = new ArrayList<>();
        for(Enchere m : eRep.getAllEnCours()) {
            liste.add(m);
        }
        return liste;
    }

    public ArrayList<Enchere> getEnchereFini() {
        ArrayList<Enchere> liste = new ArrayList<>();
        for(Enchere m : eRep.getAllFini()) {
            liste.add(m);
        }
        return liste;
    }

    public ArrayList<Enchere> getWhere(Utilisateur vv){
        ArrayList<Enchere> v=new ArrayList<>();
        for(Enchere u :eRep.findByUtilisateur(vv)){
            v.add(u);
        }
        return v;

    }
/*
    public ArrayList<Enchere> rechercheParMotCle(String search) {
        ArrayList<Enchere> v=new ArrayList<>();
        for(Enchere u :eRep.findAllByDescriptionContains(search)){
            v.add(u);
        }
        return v;
    }

    public ArrayList<Enchere> rechercheParDate(Date search) {
        ArrayList<Enchere> v=new ArrayList<>();
        for(Enchere u :eRep.findAllByDebutIs(search)){
            v.add(u);
        }
        return v;
    }
    public ArrayList<Enchere> rechercheParCateg(String search) {
        ArrayList<Enchere> v=new ArrayList<>();
        for(Enchere u :eRep.findAllByCategorie_enchereContaining(search)){
            v.add(u);
        }
        return v;
    }

    public ArrayList<Enchere> rechercheParPrix(double search) {
        ArrayList<Enchere> v=new ArrayList<>();
        for(Enchere u :eRep.findAllByMise_minimaleIs(search)){
            v.add(u);
        }
        return v;
    }

    public ArrayList<Enchere> rechercheParStatut(int search) {
        ArrayList<Enchere> v=new ArrayList<>();
        for(Enchere u :eRep.findAllByStatutEquals(search)){
            v.add(u);
        }
        return v;
    }
*/

    public ArrayList<Boolean> estFini(int iduser)
    {
        ArrayList<Boolean> b= new ArrayList<>();
        System.out.println("eto");
        for (LocalDateTime e: eRep.getFinEnchere(iduser)){

            if(e== LocalDateTime.now())
            {
                System.out.println("marina");
                b.add(false);

            }
            else {
                b.add(true);
                System.out.println("diso");
            }

        }
        return b;

    }

    public ArrayList<Enchere> getAjll(){
        ArrayList<Enchere> encheres = new ArrayList<Enchere>();
        for(Enchere enchere : eRep.findAll()){
            encheres.add(enchere);

        }
        return encheres;
    }

  

    public ArrayList<Enchere> rechercheAv(String motCle,String debut,String categorie,String prix,String statut) throws SQLException, ClassNotFoundException {

        String query = "select mettre_enchere.*,categorie_enchere.libelle from mettre_enchere join categorie_enchere on mettre_enchere.idcategorie_enchere=categorie_enchere.idcategorie_enchere ";
       // System.out.print("TEST: "+motCle.length());
        if(motCle!="" && debut!="" && categorie!="" && prix!="" && statut!="") {
            query = query + "where description like '%"+motCle+"%' and (debut::date)='"+debut+"' and libelle like '%"+categorie+"%' and mise_minimale="+prix+" and statut="+statut;
        }
        else if(motCle=="" && debut!="" && categorie!="" && prix!="" && statut!="") {
            query = query + "where (debut::date)='"+debut+"' and libelle like '%"+categorie+"%' and mise_minimale="+prix+" and statut="+statut;
        }
        else if(motCle=="" && debut=="" && categorie!="" && prix!="" && statut!="") {
            query = query + "where libelle like '%"+categorie+"%' and mise_minimale="+prix+" and statut="+statut;
        }
        else if(motCle=="" && debut=="" && categorie=="" && prix=="" && statut!="") {
            query = query + "where statut="+statut;
        }
        else if(motCle!="" && debut!="" && categorie=="" && prix=="" && statut=="") {
            query = query + "where description like '%"+motCle+"%' and (debut::date)='"+debut;
        }
        else if(motCle!="" && debut!="" && categorie!="" && prix=="" && statut=="") {
            query = query + "where description like '%\"+motCle+\"%' and (debut::date)='"+debut+"' and libelle like '%"+categorie+"%'";
        }
        else if(motCle!="" && debut!="" && categorie!="" && prix!="" && statut=="") {
            query = query + "where description like '%\"+motCle+\"%' and (debut::date)='"+debut+"' and libelle like '%"+categorie+"%' and mise_minimale="+prix;
        }
        else if(motCle!="" && debut=="" && categorie!="" && prix=="" && statut=="") {
            query = query + "where description like '%\"+motCle+\"%' and libelle like '%"+categorie+"%'";
        }
        else if(motCle!="" && debut=="" && categorie=="" && prix!="" && statut=="") {
            query = query + "where description like '%\"+motCle+\"%' and mise_minimale="+prix;
        }
        else if(motCle!="" && debut=="" && categorie!="" && prix!="" && statut=="") {
            query = query + "where description like '%\"+motCle+\"%' and libelle like '%"+categorie+"%' and mise_minimale="+prix;
        }
        else if(motCle!="" && debut=="" && categorie!="" && prix!="" && statut!="") {
            query = query + "where description like '%\"+motCle+\"%' and libelle like '%"+categorie+"%' and mise_minimale="+prix+" and statut="+statut;
        }
        else if(motCle!="" && debut=="" && categorie=="" && prix!="" && statut!="") {
            query = query + "where description like '%\"+motCle+\"%' and mise_minimale="+prix+" and statut="+statut;
        }
        else if(motCle!="" && debut=="" && categorie=="" && prix=="" && statut!="") {
            query = query + "where description like '%\"+motCle+\"%' and statut="+statut;
        }
        else if(motCle=="" && debut!="" && categorie!="" && prix=="" && statut=="") {
            query = query + "where (debut::date)='"+debut+"' and libelle like '%"+categorie+"%'";
        }
        else if(motCle=="" && debut!="" && categorie!="" && prix!="" && statut=="") {
            query = query + "where (debut::date)='"+debut+"' and libelle like '%"+categorie+"%' and mise_minimale="+prix;
        }
        else if(motCle=="" && debut!="" && categorie=="" && prix!="" && statut=="") {
            query = query + "where (debut::date)='"+debut+"' and mise_minimale="+prix;
        }
        else if(motCle=="" && debut!="" && categorie=="" && prix=="" && statut!="") {
            query = query + "where (debut::date)='"+debut+"' and statut="+statut;
        }
        else if(motCle=="" && debut!="" && categorie=="" && prix!="" && statut!="") {
            query = query + "where (debut::date)='"+debut+"' and mise_minimale="+prix+" and statut="+statut;
        }
        else if(motCle=="" && debut=="" && categorie!="" && prix!="" && statut=="") {
            query = query + "where libelle like '%\"+categorie+\"%' and mise_minimale="+prix;
        }
        else if(motCle=="" && debut=="" && categorie!="" && prix=="" && statut!="") {
            query = query + "where libelle like '%"+categorie+"%' and statut="+statut;
        }
        else if(motCle=="" && debut=="" && categorie!="" && prix=="" && statut=="") {
            query = query + "where libelle like '%"+categorie+"%'";
        }
        else if(motCle=="" && debut!="" && categorie=="" && prix=="" && statut=="") {
            query = query + "where (debut::date)='"+debut;
        }
        else if(motCle=="" && debut=="" && categorie=="" && prix!="" && statut=="") {
            query = query + "where mise_minimale="+prix;
        }
        else if(motCle!="" && debut=="" && categorie=="" && prix=="" && statut=="") {
            query = query + "where description like '%"+motCle+"%'";
            System.out.println(1);
            System.out.println(query);
        }
        else {
            query = query;
        }
        System.out.println(query);
        ArrayList<Enchere> liste = new ArrayList<>();
        Connection con = getConnex();
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet result = ps.executeQuery();
        while (result.next()) {
            Enchere e = new Enchere();
            e.setIdmettre_enchere(result.getInt(1));
            Utilisateur u = new Utilisateur();
            u.setIdutilisateur(result.getInt(2));
            e.setUtilisateur(u);
            Categorie_Enchere cE = new Categorie_Enchere();
            cE.setIdcategorie_Enchere(result.getInt(3));
            e.setDebut(result.getTimestamp(4).toLocalDateTime());
            Duree d = new Duree();
            d.setIdduree(result.getInt(5));
            e.setDuree_heure(d);
            e.setNom(result.getString(6));
            e.setMise_minimale(result.getDouble(7));
            e.setStatut(result.getInt(8));
            e.setDescription(result.getString(9));
            cE.setLibelle(result.getString(10));
            e.setCategorie_enchere(cE);
            liste.add(e);
        }
        return liste;
    }
/*
    public ArrayList<EnchereView> listeEnchereAvecMax() throws SQLException, ClassNotFoundException {
        ArrayList<EnchereView> liste = new ArrayList<>();
        Connection con = getConnex();
        String sql = "select * from enchereview";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet res = ps.executeQuery();
        while(res.next()) {
            EnchereView enchereView = new EnchereView();
            Enchere enchere = eRep.getEnchereByIdEnchere(res.getInt("idmettre_enchere"));
            System.out.println(enchere.getIdmettre_enchere() + " desc :"+ enchere.getDescription());
            enchereView.setEnchere(enchere);
            enchereView.setMax(res.getDouble("max"));
            liste.add(enchereView);
        }
        return liste;
    }
*/
public ArrayList<EnchereView> listeEnchereAvecMax(int idu) throws SQLException, ClassNotFoundException {
    ArrayList<EnchereView> liste = new ArrayList<>();
    Connection con = getConnex();
    String sql = "select * from enchereview where idutilisateur=?";
    PreparedStatement ps = con.prepareStatement(sql);
    ps.setInt(1,idu);
    ResultSet res = ps.executeQuery();
    while(res.next()) {
        EnchereView enchereView = new EnchereView();
        // Enchere enchere = eRep.getEnchereByIdEnchere(res.getInt("idmettre_enchere"));
        Enchere e=new Enchere();
        e.setDescription(res.getString("description"));
        e.setDebut(res.getTimestamp("debut").toLocalDateTime());
        e.setNom(res.getString("nom"));
        e.setStatut(res.getInt("statut"));
        // System.out.println(enchere.getIdmettre_enchere() + " desc :"+ enchere.getDescription());
        enchereView.setEnchere(e);
        enchereView.setMax(res.getDouble("max"));
        liste.add(enchereView);
    }
    ps=con.prepareStatement("select * from mettre_enchere where idutilisateur=? and idmettre_enchere not in(select idmettre_enchere from enchereview where idutilisateur=?) ");
    ps.setInt(1, idu);
    ps.setInt(2, idu);
    ResultSet rs=ps.executeQuery();
    while(rs.next()) {
        EnchereView enchereView = new EnchereView();
        // Enchere enchere = eRep.getEnchereByIdEnchere(rs.getInt("idmettre_enchere"));
        Enchere e=new Enchere();
        e.setDescription(rs.getString("description"));
        e.setDebut(rs.getTimestamp("debut").toLocalDateTime());
        e.setNom(rs.getString("nom"));
        e.setStatut(rs.getInt("statut"));
        // System.out.println(enchere.getIdmettre_enchere() + " desc :"+ enchere.getDescription());
        enchereView.setEnchere(e);
        enchereView.setMax(rs.getDouble("mise_minimale"));
        liste.add(enchereView);
    }
    ps.close();
    rs.close();
    con.close();
    return liste;
}
public ArrayList<EnchereView> listeEnchereAvecMax1(int idu) throws SQLException, ClassNotFoundException {
    ArrayList<EnchereView> liste = new ArrayList<>();
    Connection con = getConnex();
    String sql = "select * from enchereview where idmettre_enchere=?";
    PreparedStatement ps = con.prepareStatement(sql);
    ps.setInt(1,idu);
    ResultSet res = ps.executeQuery();
    while(res.next()) {
        EnchereView enchereView = new EnchereView();
        // Enchere enchere = eRep.getEnchereByIdEnchere(res.getInt("idmettre_enchere"));
        Enchere e=new Enchere();
        e.setDescription(res.getString("description"));
        e.setDebut(res.getTimestamp("debut").toLocalDateTime());
        e.setNom(res.getString("nom"));
        e.setStatut(res.getInt("statut"));
        // System.out.println(enchere.getIdmettre_enchere() + " desc :"+ enchere.getDescription());
        enchereView.setEnchere(e);
        enchereView.setMax(res.getDouble("max"));
        liste.add(enchereView);
    }
    con.close();
    return liste;
}



public ArrayList<EnchereViewMax> encore(int idu) throws SQLException, ClassNotFoundException {
    ArrayList<EnchereViewMax> liste = new ArrayList<>();
    Connection con = getConnex();
    String sql = "select*from EnchereViewMax where idu in(select idutilisateur from encherir) and statut=0 and idu=?";
    PreparedStatement ps = con.prepareStatement(sql);
    ps.setInt(1,idu);
    ResultSet res = ps.executeQuery();
    while(res.next()) {
        EnchereViewMax enchereView = new EnchereViewMax();
        // Enchere enchere = eRep.getEnchereByIdEnchere(res.getInt("idmettre_enchere"));
        Enchere e=new Enchere();
        e.setIdmettre_enchere(res.getInt("idmettre_enchere"));
        e.setMise_minimale((res.getDouble("mise_minimale")));
        e.setDescription(res.getString("description"));
        e.setDebut(res.getTimestamp("debut").toLocalDateTime());
        e.setNom(res.getString("nom"));
        e.setStatut(res.getInt("statut"));
        // System.out.println(enchere.getIdmettre_enchere() + " desc :"+ enchere.getDescription());
        enchereView.setEnchere(e);
        enchereView.setMax(res.getDouble("max_montant"));
        liste.add(enchereView);
    }
    con.close();
    return liste;
}

public ArrayList<EnchereViewMax> getAll(int id) throws SQLException, ClassNotFoundException {
    ArrayList<EnchereViewMax> liste = new ArrayList<>();
    Connection con = getConnex();
    String sql = "select * from EnchereViewMax where idutilisateur=?";
    PreparedStatement ps = con.prepareStatement(sql);
    ps.setInt(1,id);
    ResultSet res = ps.executeQuery();
    while(res.next()) {
        EnchereViewMax enchereView = new EnchereViewMax();
        Enchere enchere = eRep.getEnchereByIdEnchere(res.getInt("idmettre_enchere"));
        System.out.println(enchere.getIdmettre_enchere() + " desc :"+ enchere.getDescription());
        enchereView.setEnchere(enchere);
        enchereView.setMax(res.getDouble("max_montant"));
        enchereView.setPhoto(res.getString("photo"));
        enchereView.setNom_gagnant(res.getString("nom_gagnant"));
        enchereView.setPrenom(res.getString("prenom"));
        liste.add(enchereView);
    }
    return liste;
}

public ArrayList<EnchereViewMax> encoreTous() throws SQLException, ClassNotFoundException {
    ArrayList<EnchereViewMax> liste = new ArrayList<>();
    Connection con = getConnex();
    String sql = "select*from EnchereViewMax";
    PreparedStatement ps = con.prepareStatement(sql);
   ResultSet res = ps.executeQuery();
    while(res.next()) {
        EnchereViewMax enchereView = new EnchereViewMax();
        // Enchere enchere = eRep.getEnchereByIdEnchere(res.getInt("idmettre_enchere"));
        Enchere e=new Enchere();
        e.setIdmettre_enchere(res.getInt("idmettre_enchere"));
        e.setDescription(res.getString("description"));
        e.setDebut(res.getTimestamp("debut").toLocalDateTime());
        e.setNom(res.getString("nom"));
        e.setStatut(res.getInt("statut"));
        //System.out.println("valeurduree"+res.getDouble("valeur"));
        Duree d = new Duree();
        d.setIdduree(res.getInt("idduree"));
        d.setValeur(res.getDouble("valeur"));
        e.setDuree_heure(d);
        //e.getDuree_heure().setValeur(24);
        // System.out.println(enchere.getIdmettre_enchere() + " desc :"+ enchere.getDescription());
        Utilisateur u = new Utilisateur();
        u.setIdutilisateur(res.getInt("idu"));
        u.setSolde(res.getDouble("solde"));
        e.setUtilisateur(u);
        System.out.println("idmettre_enchere"+res.getInt("idmettre_enchere"));
        enchereView.setEnchere(e);
        enchereView.setMax(res.getDouble("max_montant"));
        liste.add(enchereView);
    }
    con.close();
    return liste;
}
public LocalDateTime getDateFin(EnchereViewMax enchere) {
    LocalDateTime dateDebut = enchere.getEnchere().getDebut();
    System.out.println("date debut"+dateDebut);
    System.out.println("date fin"+enchere.getEnchere().getDuree_heure().getValeur());
    long duree = (long) enchere.getEnchere().getDuree_heure().getValeur();
    System.out.println("duree"+duree);
    System.out.println("result"+dateDebut.plusHours(duree));
    return dateDebut.plusHours(duree);
}

public void updateEnchere(int idmettre_enchere) throws SQLException, ClassNotFoundException {
Connection con = getConnex();
    String sql = "update mettre_enchere set statut = 1 where idmettre_enchere= ?";
    PreparedStatement ps = con.prepareStatement(sql);
    ps.setInt(1,idmettre_enchere);
    System.out.println(ps);
    int i = ps.executeUpdate();
    con.close();
}

public void checkStatutdesEncheres() throws SQLException, ClassNotFoundException {
    for(EnchereViewMax enchere : this.encoreTous()){
        System.out.println("desc"+enchere.getEnchere().getDuree_heure().getValeur());
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime dateFin = getDateFin(enchere);
        if(dateFin.isBefore(now)) {
            System.out.println("datefin"+dateFin);
            this.updateEnchere(enchere.getEnchere().getIdmettre_enchere());
            userSev.mampitomboSolde(enchere.getMax(), enchere.enchere.getUtilisateur());
        }
    }
}
}
