package td1jdbc;

import java.sql.* ;

public class dropdb {

    public dropdb ()
    {
        try {
            // chargement de la classe par son nom
            Class c = Class.forName("com.mysql.cj.jdbc.Driver") ;

            // Protocole de connexion
            String protocole =  "jdbc:mysql:" ;
            // Adresse IP de l�h�te de la base et port
            String ip =  "localhost" ;  // d�pend du contexte
            String port =  "3306" ;  // port MySQL par d�faut
            // Cha�ne de connexion
            String conString = protocole +  "//" + ip +  ":" + port ;
            // Identifiants de connexion et mot de passe
            String nomConnexion =  "root" ;  // d�pend du contexte
            String motDePasse =  "" ;  // d�pend du contexte
            // C. Connexion
            Connection conct = DriverManager.getConnection(
                    conString, nomConnexion, motDePasse) ;

            // D. Ex�cuter la requ�te
            Statement stmt = conct.createStatement();
            //�tape 4: ex�cuter la requ�te
            System.out.println("\n >> Suppression de la base de donn�es ...");
            stmt.executeUpdate("DROP DATABASE DBStds");
            System.out.println(" Base de donn�es DBStds supprim�e avec succ�s ...\n\n");

            // E. Fermer la connexion
            conct.close();
        }  catch (Exception e) {
            // gestion des exceptions
            System.out.println(e);
        }
    }
}
