package td1jdbc;
import java.sql.* ;

public class addsutds {

    public addsutds ()
    {
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
            System.out.println("\n >> Ajout des �tudiants dans la table  ...");
            // D. Ex�cuter des requ�tes
            System.out.println("Insertion...");

            String sql = "INSERT INTO STUDENT (CNE, Nom, Note)" +
                    "VALUES (20854367, 'Boujdain Amal', 11)";
            smt.executeUpdate(sql);

            sql = "INSERT INTO STUDENT (CNE, Nom, Note)" +
                    "VALUES (19237645, 'Zougrar Imad', 14)";
            smt.executeUpdate(sql);

            sql = "INSERT INTO STUDENT (CNE, Nom, Note)" +
                    "VALUES (27361238, 'Dadi Maroan', 04)";
            smt.executeUpdate(sql);

            System.out.println("Les donn�es des �tudiants ins�r�s dans la table STUDENT avec succ�s ...");

            // E. Fermer la connexion
            con.close();

        }  catch (Exception e) {
            // gestion des exceptions
            System.out.println(e);

        }
    }

}