package td2transaction;

import java.util.Scanner;
import java.sql.* ;
import java.io.* ;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class gestioncommande {

    public static void passercmd()
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
         String nomBase =  "DBCafe" ;  // d�pend du contexte
          // Cha�ne de connexion
         String conString = protocole +  "//" + ip +  ":" + port +  "/" + nomBase ;
          // Identifiants de connexion et mot de passe
         String nomConnexion =  "root" ;  // d�pend du contexte
         String motDePasse =  "FS.Tetouan_2023" ;  // d�pend du contexte
          // B. Cr�er une connexion
         Connection conn = DriverManager.getConnection(
            conString, nomConnexion, motDePasse) ;
         
         //Pr�paration de notre Requ�te param�tr�e
         PreparedStatement stmt = conn.prepareStatement("INSERT INTO commande(idclt,datcmd,qtecmd) values(?,?,?)");
         Scanner s=new Scanner(System.in);
         //System.out.println("Entrer id client : ");
         //int sid=s.nextInt();
         //stmt.setInt(1,sid);
         int nbr=0;
         String choix="oui";
         while(choix.equals("oui"))
         {
            System.out.println("  --- Passer la commande " + ++nbr + "  --- ");
            System.out.print("\n   - Entrer > ID client :  ");
            int sidclt=s.nextInt();            
            long millis=System.currentTimeMillis(); 
            java.sql.Date sdate = new java.sql.Date(millis);
            System.out.println(  "   -        > Date Commande : " + sdate);
            System.out.print("   - Entrer > Quantit� comand�e du caf� en Kg :  ");
            int sqte=s.nextInt();
            stmt.setInt(1,sidclt);
            stmt.setDate(2, sdate);
            stmt.setInt(3,sqte);
            int i=stmt.executeUpdate();
            System.out.println("   >> " + i+" commande ins�r� avec succ�s");
            System.out.println("\\nnVous voulez ajouter une autre commande (oui/non) ?");
            choix=s.next();
         } 
         conn.close();         
      }  catch (Exception e) {
         // gestion des exceptions
         System.out.println(e);
      }

    }


    public static void updateqte()
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
         String nomBase =  "DBCafe" ;  // d�pend du contexte
          // Cha�ne de connexion
         String conString = protocole +  "//" + ip +  ":" + port +  "/" + nomBase ;
          // Identifiants de connexion et mot de passe
         String nomConnexion =  "root" ;  // d�pend du contexte
         String motDePasse =  "FS.Tetouan_2023" ;  // d�pend du contexte
          // B. Cr�er une connexion
         Connection conn = DriverManager.getConnection(
            conString, nomConnexion, motDePasse) ;
         
         //Pr�paration de notre Requ�te param�tr�e
         PreparedStatement stmt = conn.prepareStatement("UPDATE commande SET qtecmd = ? WHERE idcmd = ?");
         Scanner s=new Scanner(System.in);
         System.out.println("  --- Modifier quantit� demand�e dans une commande --- ");
            System.out.print("\n   - Entrer > ID commande � modifier :   ");
            int sidcmd=s.nextInt();           
            
            System.out.print("   - Entrer la nouvelle quantit� comand�e du caf� en Kg :   ");
            int sqte=s.nextInt();
            
            stmt.setInt(1, sqte);
            stmt.setInt(2,sidcmd);
            
            int i=stmt.executeUpdate();
            System.out.println("   >> " + i+" commande modif�e avec succ�s");
            
         conn.close();         
      }  catch (Exception e) {
         // gestion des exceptions
         System.out.println(e);
      }
 
    }
    
    public static void deletcmd()
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
         
         System.out.println("\n >> Suppression d'unE commande ...");
         //Pr�paration de notre Requ�te param�tr�e
         
            Scanner s=new Scanner(System.in);
            System.out.print("\n   - Entrer > ID de la commande � supprimer :   ");
            int sidcmd=s.nextInt();                       
            PreparedStatement stmtcmd = con.prepareStatement("DELETE FROM COMMANDE WHERE idcmd = ?");
            stmtcmd.setInt(1,sidcmd);
            int i=stmtcmd.executeUpdate();
            
            System.out.println(" Suppression ...");
           
           System.out.println("La commande ID: " + sidcmd + " supprim�e avec succ�s  ...");
         
         // E. Fermer la connexion
         con.close();
         
      }  catch (Exception e) {
         // gestion des exceptions
         System.out.println(e);

      }        
    
    }
    
    public static void listecmd(){
      try {
          // A. Enregistrer la classe de pilote
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
         PreparedStatement stmt = con.prepareStatement("SELECT idcmd, idclt, datcmd, qtecmd FROM commande WHERE idclt = ? ORDER BY idcmd ASC");
         Scanner s=new Scanner(System.in);
         System.out.println("  --- Afficher les commande effectu�es par un client --- ");
            System.out.print("\n   - Entrer > ID client rechercher :   ");
            int sidclt=s.nextInt();              
            stmt.setInt(1, sidclt);
            ResultSet res = stmt.executeQuery(  );
         System.out.println("Liste des commandes effectu�s par le client ID: " + sidclt + "\n");
         System.out.print("ID CMD\t|\tID CLT \t|\tDATE CMD\t|\tQTE CMD\n");
         System.out.println("---------------------------------------------------------------");
          while (res.next()) {
            //R�cup�rer par nom de colonne
            int vidcmd = res.getInt("idcmd");
            int vidclt = res.getInt("idclt");
            Date vdatecmd = res.getDate("datcmd");
            int vqtecmd = res.getInt("qtecmd");
            
            //Afficher les valeurs
            System.out.print(" " + vidcmd + "\t|\t");
            System.out.print(vidclt + "\t|\t");
            System.out.print(vdatecmd + "\t|\t");
            System.out.println(vqtecmd);
        }
        // E. Fermer la connexion
         con.close();
         
      }  catch (Exception e) {
         // gestion des exceptions
         System.out.println(e);

      }        

    }
    
    public static void listeallcmd()
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
         PreparedStatement stmt = con.prepareStatement("SELECT idcmd, idclt, datcmd, qtecmd FROM commande ORDER BY idcmd ASC");
         Scanner s=new Scanner(System.in);
         System.out.println("  --- Afficher toutes les commandes effectu�es  --- ");
         ResultSet res = stmt.executeQuery(  );
         System.out.println("Liste des commandes effectu�es : \n");
         System.out.print("ID CMD\t|\tID CLT \t|\tDATE CMD\t|\tQTE CMD\n");
         System.out.println("---------------------------------------------------------------");
          while (res.next()) {
            //R�cup�rer par nom de colonne
            int vidcmd = res.getInt("idcmd");
            int vidclt = res.getInt("idclt");
            Date vdatecmd = res.getDate("datcmd");
            int vqtecmd = res.getInt("qtecmd");
            
            //Afficher les valeurs
            System.out.print(" " + vidcmd + "\t|\t");
            System.out.print(vidclt + "\t|\t");
            System.out.print(vdatecmd + "\t|\t");
            System.out.println(vqtecmd);
        }
        // E. Fermer la connexion
         con.close();
         
      }  catch (Exception e) {
         // gestion des exceptions
         System.out.println(e);

      }        
        
    }
    
    public static void menugestioncmd()
    {
         int choix = 0;
         Scanner masaisie = new Scanner(System.in,"UTF-8");
	 
	 do {
	        System.out.println(" >> GESTION DES COMMANDES << \n");
                System.out.println("      1. Passer une commande  ");
                System.out.println("      2. Importer la liste des commandes  ");
                System.out.println("      3. Modifier la quantit� command�e d'une commande  ");
                System.out.println("      4. Supprimer une commande  ");
                System.out.println("      5. Afficher la liste des commandes effectu�es par un client  ");
                System.out.println("      6. Afficher toutes les commandes effectu�es  ");
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
	 		        System.out.println("\n ++++++ Choix 1 : Passer une Commande  ++++++ \n");
                                passercmd();
                                TD2Transaction.pressEnterToContinue();
                            	break;
			 
			 case 2 : 
			        System.out.println("\n ++++++ Choix 2 : Importer la liste des commandes  ++++++ \n");
                                //loadclients();
                                TD2Transaction.pressEnterToContinue();
                            	break;
			 case 3 :
                                System.out.println("\n ++++++ Choix 3 : Modifier la quantit� command�e d'une commande  ++++++ \n");
                                updateqte();
                                TD2Transaction.pressEnterToContinue();
                            	break;
			 case 4 :
                                System.out.println("\n ++++++ Choix 4 : Supprimer une commande  ++++++ \n");
                                deletcmd();
                                TD2Transaction.pressEnterToContinue();
                            	break;
			 case 5 :
                                System.out.println("\n ++++++ Choix 5 :  Afficher la liste des clients  ++++++ \n");
                                listecmd();
                                TD2Transaction.pressEnterToContinue();
                            	break;			 
                         case 6 :
                                System.out.println("\n ++++++ Choix 5 :  Afficher la liste des clients  ++++++ \n");
                                listeallcmd();
                                TD2Transaction.pressEnterToContinue();
                            	break;			 
                         case 0: {
			 	System.out.println("\n \n   -------   Fin de l'interface de gestion des CLIENTS   -------");
			 	TD2Transaction.pressEnterToContinue();
                                TD2Transaction.menu();
				break;
			 }
                         default : System.out.println("  Erreur, choix impr�vu !!!!!   -------");
		 
                }    
              
	 }while(choix!=0);		


    }
        
}
