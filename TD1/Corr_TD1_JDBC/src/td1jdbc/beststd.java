package td1jdbc;

import java.sql.*;

public class beststd {
    public beststd(){
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
            System.out.println(" >> Recherche de l'�tudiant majorant de la promotion ...\n");
            // D. Ex�cuter des requ�tes
            String sql = "SELECT ID, CNE, Nom, Note FROM student" +
                    " WHERE Note = (" +
                    " SELECT MAX(Note) FROM student )";

            ResultSet res = smt.executeQuery(sql) ;
            System.out.println("L'�tudiant majorant de la promotion M36-1D / SMI-S6 \n");
            System.out.print("ID\t|\tCNE\t\t|\tNom\t\t|\tNote\n");
            System.out.println("-------------------------------------------------------------------");
            while (res.next()) {
                //R�cup�rer par nom de colonne
                int id = res.getInt("ID");
                int cne = res.getInt("CNE");
                String nom = res.getString("Nom");
                float note = res.getFloat("Note");
                //Afficher les valeurs
                System.out.print(" " + id + "\t|\t");
                System.out.print(cne + "\t|\t");
                System.out.print(nom + "\t|\t");
                System.out.println(note);
            }
            // E. Fermer la connexion
            con.close();

        }  catch (Exception e) {
            // gestion des exceptions
            System.out.println(e);

        }

    }

}