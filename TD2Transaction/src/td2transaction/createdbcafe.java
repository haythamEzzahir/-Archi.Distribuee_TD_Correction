package td2transaction;

import java.util.Scanner;
import java.sql.* ;

public class createdbcafe {

    public static void createdbcafe()
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
         String motDePasse =  "FS.Tetouan_2023" ;  // d�pend du contexte
         // C. Connexion
         Connection conct = DriverManager.getConnection(
            conString, nomConnexion, motDePasse) ;
        
        // D. Ex�cuter la requ�te
        Statement stmt = conct.createStatement();
        //�tape 4: ex�cuter la requ�te
        System.out.println("\n >> Cr�ation de la base de donn�es ...");
        stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS DBCafe");
        System.out.println("Base de donn�es DBCafe cr�e avec succ�s ...\n\n");

        // E. Fermer la connexion
         conct.close();
      }  catch (Exception e) {
         // gestion des exceptions
         System.out.println(e);
      }
        
    }
    
    public static void createtbclt()
    {
                try {
          // chargement de la classe par son nom
         Class c = Class.forName("com.mysql.cj.jdbc.Driver") ;
         
          // Protocole de connexion
         String protocole =  "jdbc:mysql:" ;
          // Adresse IP de l�h�te de la base et port
         String ip =  "localhost" ;  // d�pend du contexte
         String port =  "3306" ;  // port MySQL par d�faut
          // Nom de la base ;
         String nomBase =  "DBCafe" ;  // d�pend du contexte
          // Cha�ne de connexion
         String conString = protocole +  "//" + ip +  ":" + port +  "/" + nomBase ;
          // Identifiants de connexion et mot de passe
         String nomConnexion =  "root" ;  // d�pend du contexte
         String motDePasse =  "FS.Tetouan_2023" ;  // d�pend du contexte
          // B. Cr�er une connexion
         Connection con = DriverManager.getConnection(
            conString, nomConnexion, motDePasse) ;

             // C. Cr�er un objet Statement
             Statement smt = con.createStatement() ;
             System.out.println("\n >> Cr�ation de la table Client ...");
             // D. Ex�cuter des requ�tes
            String sql =  "CREATE TABLE IF NOT EXISTS CLIENT " +
                       "(idclt INTEGER NOT NULL AUTO_INCREMENT, " +
                       " nomclt VARCHAR(100), " + 
                       " adrclt VARCHAR(100), " + 
                       " telclt LONG, " + 
                       " PRIMARY KEY ( idclt ))";
         
            smt.executeUpdate(sql);
            
            System.out.println("La table CLIENT cr��e avec succ�s ...");
      
        // E. Fermer la connexion
         con.close();
         
      }  catch (Exception e) {
         // gestion des exceptions
         System.out.println(e);

      }

    }
    
    public static void createtbcmd()
    {
                try {
          // chargement de la classe par son nom
         Class c = Class.forName("com.mysql.cj.jdbc.Driver") ;
         
          // Protocole de connexion
         String protocole =  "jdbc:mysql:" ;
          // Adresse IP de l�h�te de la base et port
         String ip =  "localhost" ;  // d�pend du contexte
         String port =  "3306" ;  // port MySQL par d�faut
          // Nom de la base ;
         String nomBase =  "DBCafe" ;  // d�pend du contexte
          // Cha�ne de connexion
         String conString = protocole +  "//" + ip +  ":" + port +  "/" + nomBase ;
          // Identifiants de connexion et mot de passe
         String nomConnexion =  "root" ;  // d�pend du contexte
         String motDePasse =  "FS.Tetouan_2023" ;  // d�pend du contexte
          // B. Cr�er une connexion
         Connection con = DriverManager.getConnection(
            conString, nomConnexion, motDePasse) ;

             // C. Cr�er un objet Statement
             Statement smt = con.createStatement() ;
             // D. Ex�cuter des requ�tes            
            System.out.println("\n >> Cr�ation de la table Commande ...");
            String sql =  "CREATE TABLE IF NOT EXISTS COMMANDE " +
                       "(idcmd INTEGER NOT NULL AUTO_INCREMENT, " +
                       " idclt INTEGER NOT NULL, " + 
                       " datcmd DATE, " + 
                       " qtecmd INTEGER, " + 
                       " FOREIGN KEY (idclt) REFERENCES CLIENT(idclt)," + 
                       " PRIMARY KEY ( idcmd ))" ;
         
            smt.executeUpdate(sql);
            
            System.out.println("La table COMMANDE cr��e avec succ�s ...");
      
        // E. Fermer la connexion
         con.close();
         
      }  catch (Exception e) {
         // gestion des exceptions
         System.out.println(e);

      }

    }
    
    public static void deletclt()
    {
                try {
          // chargement de la classe par son nom
         Class c = Class.forName("com.mysql.cj.jdbc.Driver") ;
         
          // Protocole de connexion
         String protocole =  "jdbc:mysql:" ;
          // Adresse IP de l�h�te de la base et port
         String ip =  "localhost" ;  // d�pend du contexte
         String port =  "3306" ;  // port MySQL par d�faut
          // Nom de la base ;
         String nomBase =  "DBCafe" ;  // d�pend du contexte
          // Cha�ne de connexion
         String conString = protocole +  "//" + ip +  ":" + port +  "/" + nomBase ;
          // Identifiants de connexion et mot de passe
         String nomConnexion =  "root" ;  // d�pend du contexte
         String motDePasse =  "FS.Tetouan_2023" ;  // d�pend du contexte
          // B. Cr�er une connexion
         Connection con = DriverManager.getConnection(
            conString, nomConnexion, motDePasse) ;
        try{   
            //d�finir la gestion des transactions manuelles
            con.setAutoCommit(false);
            
             // C. Cr�er un objet Statement
             Statement smt = con.createStatement() ;
             
             System.out.println("\n >> Suppression de la table Client ...");
             // D. Ex�cuter des requ�tes
            
            smt.executeUpdate("DROP TABLE IF EXISTS COMMANDE");
            
            smt.executeUpdate("DROP TABLE IF EXISTS CLIENT");
            
            System.out.println(" La table Client supprim�e avec succ�s ...\n\n");
            
      
            // S'il n'y a pas d'erreur.
            con.commit();
            }
        catch(SQLException se)
            {
            // S'il y a une erreur.
            con.rollback();
            }
        // E. Fermer la connexion
         con.close();
         
      }  catch (Exception e) {
         // gestion des exceptions
         System.out.println(e);

      }

    }
    
    public static void deletcmd()
    {
                try {
          // chargement de la classe par son nom
         Class c = Class.forName("com.mysql.cj.jdbc.Driver") ;
         
          // Protocole de connexion
         String protocole =  "jdbc:mysql:" ;
          // Adresse IP de l�h�te de la base et port
         String ip =  "localhost" ;  // d�pend du contexte
         String port =  "3306" ;  // port MySQL par d�faut
          // Nom de la base ;
         String nomBase =  "DBCafe" ;  // d�pend du contexte
          // Cha�ne de connexion
         String conString = protocole +  "//" + ip +  ":" + port +  "/" + nomBase ;
          // Identifiants de connexion et mot de passe
         String nomConnexion =  "root" ;  // d�pend du contexte
         String motDePasse =  "FS.Tetouan_2023" ;  // d�pend du contexte
          // B. Cr�er une connexion
         Connection con = DriverManager.getConnection(
            conString, nomConnexion, motDePasse) ;

             // C. Cr�er un objet Statement
             Statement smt = con.createStatement() ;
             System.out.println("\n >> Suppression de la table Commande ...");
             // D. Ex�cuter des requ�tes
            
        smt.executeUpdate("DROP TABLE IF EXISTS COMMANDE");
        System.out.println(" La table Commande supprim�e avec succ�s ...\n\n");
      
        // E. Fermer la connexion
         con.close();
         
      }  catch (Exception e) {
         // gestion des exceptions
         System.out.println(e);

      }

    }
    
    public static void deletbdcafe()
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
         String motDePasse =  "FS.Tetouan_2023" ;  // d�pend du contexte
         // C. Connexion
         Connection conct = DriverManager.getConnection(
            conString, nomConnexion, motDePasse) ;
        
        // D. Ex�cuter la requ�te
        Statement stmt = conct.createStatement();
        //�tape 4: ex�cuter la requ�te
        System.out.println("\n >> Suppression de la base de donn�es ...");
        stmt.executeUpdate("DROP DATABASE IF EXISTS DBCafe");
        System.out.println(" Base de donn�es DBCafe supprim�e avec succ�s ...\n\n");

        // E. Fermer la connexion
         conct.close();
      }  catch (Exception e) {
         // gestion des exceptions
         System.out.println(e);
      }
    }
    
    public static void menuDB()
    {
         int choix = 0;
         Scanner masaisie = new Scanner(System.in,"UTF-8");
	 
	 do {
	        System.out.println(" >> CREATION DE LA BASE DE DONNEES DES CLIENTS / COMMANDES << \n");
                System.out.println("      1. Cr�er la base de donn�es DBCafe  ");
                System.out.println("      2. Cr�er la table des clients  ");
                System.out.println("      3. Cr�er la table des commandes  ");
                System.out.println("      4. Supprimer la table des clients  ");                
                System.out.println("      5. Supprimer la table des commandes  ");                
                System.out.println("      6. Supprimer la base de donn�es DBCafe  ");                
	 	System.out.println("      0. Retourner au menu principal  ");
                System.out.print("\n Entrez votre choix :  ");
	 	try
                 {
                  choix = masaisie.nextByte();
                
                 }catch(Exception e)
                  {
                     System.out.println("  Erreur, choix impr�vu !!!!!   -------");
                     e.printStackTrace();
                  } 
	 	switch(choix)
	 	{
	 		case 1 : 
	 		        System.out.println("\n ++++++ Choix 1 : Cr�er la base de donn�es  ++++++ \n");
                                createdbcafe();
                                TD2Transaction.pressEnterToContinue();
                            	break;
			 
			 case 2 : 
			        System.out.println("\n ++++++ Choix 2 : Cr�er de la table CLIENT  ++++++ \n");
                                createtbclt();
                                TD2Transaction.pressEnterToContinue();
                            	break;
			 case 3 :
                                System.out.println("\n ++++++ Choix 3 : Cr�er de la table COMMANDE  ++++++ \n");
                                createtbcmd();
                                TD2Transaction.pressEnterToContinue();
                            	break;
			 case 4 :
                                System.out.println("\n ++++++ Choix 4 : Supprimer de la table CLIENT  ++++++ \n");
                                deletclt();
                                TD2Transaction.pressEnterToContinue();
                            	break;
			 case 5 :
                                System.out.println("\n ++++++ Choix 5 : Supprimer de la table COMMANDE  ++++++ \n");
                                deletcmd();
                                TD2Transaction.pressEnterToContinue();
                            	break;
			 case 6 :
                                System.out.println("\n ++++++ Choix 6 : Supprimer de la base de donn�es DBCafe  ++++++ \n");
                                deletbdcafe();
                                TD2Transaction.pressEnterToContinue();
                            	TD2Transaction.pressEnterToContinue();
                            	break;
			 
                         case 0: {
			 	System.out.println("\n \n   -------   Fin de l'interface de gestion de la base de donn�es DBCafe   -------");
			 	TD2Transaction.pressEnterToContinue();
                                TD2Transaction.menu();
				break;
			 }
                         default : System.out.println("  Erreur, choix impr�vu !!!!!   -------");
		 
                }    
              
	 }while(choix!=0);		


    }
    
}
