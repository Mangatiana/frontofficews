package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class UtilisateurServ {
    @Autowired
    UtlisateurRep ur;

    public ArrayList<Utilisateur> getAll() {
        ArrayList<Utilisateur> list = new ArrayList<>();
        for(Utilisateur u: ur.findAll()) {
            list.add(u);
        }
        return list;
    }
    private static String Sha1(String password) throws UnsupportedEncodingException {
        String sha1 = "";
        try {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(password.getBytes("UTF-8"));
            sha1 = byteToHex(crypt.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return sha1;
    }

    private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash) {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }

    public  static String genererToken(String user){
        String name=user;
        LocalDateTime ajd=LocalDateTime.now();
        Integer Y=ajd.getYear();
        String taona=Y.toString();
        Integer m=ajd.getMonthValue();
        String volana=m.toString();
        Integer d=ajd.getDayOfMonth();
        String andro=d.toString();
        Integer min=ajd.getHour();
        String lera=min.toString();
        String hash="";
        try {
            String hash1=UtilisateurServ.Sha1(name);
            String h2=UtilisateurServ.Sha1(taona+volana+andro+lera);
            hash=UtilisateurServ.Sha1(hash1+h2);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(UtilisateurServ.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hash;
    }

    public Boolean check_token_si_valide(String nom){
        Boolean v=false;
        String token=this.genererToken(nom);
        ArrayList<Utilisateur> liste = this.getAll();
        for(int i=0; i<liste.size(); i++){
            if((liste.get(i).getNom().equals(nom)&&(liste.get(i).getToken().equals(token)))){
                v=true;
                break;
            }
        }
        return v;
    }

    public Connection getConnex() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection("jdbc:postgresql://containers-us-west-196.railway.app:6815/railway?user=postgres&password=MKyy3iS7wOBvOBDO4vxo");
    }

    public Utilisateur log(String mail, String mdp) throws SQLException {
        Utilisateur u = new Utilisateur();
        Boolean v=false;
        String t="null";
        ResultSet rs=null;
        Connection conn =null;
        PreparedStatement ps=null;
        try {
            conn = getConnex();
            String sql = "select * from utilisateur where email = ? and motdepasse = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,mail);
            ps.setString(2,mdp);
            System.out.println(ps.toString());
            rs=ps.executeQuery();
            if(rs!=null) {
                v=true;
                while(rs.next()) {
                    u.setIdutilisateur(rs.getInt("idutilisateur"));
                    u.setNom(rs.getString("nom"));
                    u.setPrenom(rs.getString("prenom"));
                    // u.setDatenaissance(liste.get(i).getDatenaissance());
                    // u.setEmail(mail);
                    // u.setMotdepasse(mdp);
                    u.setSolde(rs.getDouble("solde"));
                    String token=this.genererToken(mail);
                    u.setToken(token);
                    t=u.getToken();

                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(u.getNom());
        conn.close();
        return u;
    }

    public Boolean deco(String mail,String mdp){
        ArrayList<Utilisateur> liste=this.getAll();
        Boolean v=false;
        for(int i=0; i<liste.size(); i++){
            if((liste.get(i).getEmail().equals(mail)&&(liste.get(i).getMotdepasse().equals(mdp)))){
                v=true;
                Utilisateur u=new Utilisateur();
                u.setIdutilisateur(liste.get(i).getIdutilisateur());
                u.setNom(liste.get(i).getNom());
                u.setPrenom(liste.get(i).getPrenom());
                u.setDatenaissance(liste.get(i).getDatenaissance());
                u.setEmail(mail);
                u.setMotdepasse(mdp);
                u.setSolde(liste.get(i).getSolde());
                ur.save(u);
            }
        }
        return v;
    }


    public void inscription(Utilisateur v){
        ur.save(v);
    }

    public void updateUtilisateur(double newentre,int idutlisateur) throws SQLException, ClassNotFoundException {
        Connection con = getConnex();
        String sql = "update utilisateur set solde = ? where idutilisateur = ?";
        PreparedStatement ps = con.prepareStatement(sql);
       ps.setDouble(1,newentre);
       ps.setInt(2,idutlisateur);
        int i = ps.executeUpdate();
        con.close();
    }

    public void mampitomboSolde(double entrant,Utilisateur utilisateur) throws SQLException, ClassNotFoundException {
        System.out.println("solde taloha "+utilisateur.getSolde());
        double soldeActu = utilisateur.getSolde() + entrant;
        System.out.println("solde actu "+soldeActu);
        this.updateUtilisateur(soldeActu, utilisateur.getIdutilisateur());
    }



}
