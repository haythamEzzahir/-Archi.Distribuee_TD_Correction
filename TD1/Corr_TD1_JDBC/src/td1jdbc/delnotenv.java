package td1jdbc;

import java.sql.*;

public class delnotenv {

    public delnotenv(){
        try {
            // A. Enregistrer la classe de pilote
            Class c = Class.forName("com.mysql.cj.jdbc.Driver") ;
            // Protocole de connexion
            String protocole =  "jdbc:mysql:" ;
            // Adresse IP de l�h�te de la base et port
            String ip =  "localhost" ;  // d�pend du contexte
            String port =  "3306" ;  // port MySQL par d�faut
            // Nom de la base ;
            String nomBase =  "DBStds" ;  // d�pend du contexte
            // Cha�ne de connexion
            String conString = protocole +  "//" + ip +  ":" + port +  "/" + nomBase ;
            // Identifiants de connexion et mot de passe
            String nomConnexion =  "root" ;  // d�pend du contexte
            String motDePasse =  "" ;  // d�pend du contexte
            // B. Cr�er une connexion
            Connection con = DriverManager.getConnection(
                    conString, nomConnexion, motDePasse) ;
            // C. Cr�er un objet Statement
            Statement smt = con.createStatement() ;
            System.out.println("\n >> Suppression des �tudiants NV ...");
            // D. Ex�cuter des requ�tes
            System.out.println(" Suppression ...");

            String sql = "DELETE FROM STUDENT WHERE Note < 5";

            smt.executeUpdate(sql);

            System.out.println("Les �tudiants ayant des notes NV supprim�s avec succ�s ...");

            // E. Fermer la connexion
            con.close();

        }  catch (Exception e) {
            // gestion des exceptions
            System.out.println(e);

        }
    }

}