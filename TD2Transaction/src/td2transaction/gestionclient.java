package td2transaction;

import java.util.Scanner;
import java.sql.* ;
import java.io.* ;


public class gestionclient {

    public static Savepoint savepoint;

    public static void addclient()
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
         PreparedStatement stmt = conn.prepareStatement("INSERT INTO client(nomclt,adrclt,telclt) values(?,?,?)");
         Scanner s=new Scanner(System.in);
         //System.out.println("Entrer id client : ");
         //int sid=s.nextInt();
         //stmt.setInt(1,sid);
         int nbr=0;
         String choix="oui";
         while(choix.equals("oui"))
         {
            System.out.println("  --- Ajout d'client " + ++nbr + "  --- ");
            System.out.print("\n   - Entrer > Nom client :   ");
            String sname=s.next();
            System.out.print("   - Entrer > Adresse client :   ");
            String sadr=s.next();
            System.out.print("   - Entrer > Num�roe T�l�phone client :   ");
            int stel=s.nextInt();
            stmt.setString(1,sname);
            stmt.setString(2,sadr);
            stmt.setInt(3,stel);
            int i=stmt.executeUpdate();
            System.out.println("   >> " + i+" client ins�r� avec succ�s");
            System.out.println("\\nnVous voulez ajouter un autre client (oui/non) ?");
            choix=s.next();
         } 
         conn.close();         
      }  catch (Exception e) {
         // gestion des exceptions
         System.out.println(e);
      }

    }

    public static void loadclients()
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
         
         try{
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO client(nomclt,adrclt,telclt) values(?,?,?)");
         
            // Le fichier d'entr�e
            FileInputStream file = new FileInputStream("C:\\Users\\User\\Documents\\NetBeansProjects\\TD2Transaction\\src\\td2transaction\\ListeClient.txt");   
            
            Scanner s = new Scanner(file);             
            int nbr=0;
            System.out.println("Liste des clients import�s � partir du fichier 'ListeClient.txt' \n");
            //System.out.print("ID\t|\tNom\t\t|\tAdresse\t\t|\tT�l�phone\n");
            System.out.print("Nom\t\t|\tAdresse\t\t|\tT�l�phone\n");
            System.out.println("-------------------------------------------------------------------");                            
            while(s.hasNextLine())
              {
                  //int sid=s.nextInt();
                String sname=s.next();
                String sadr=s.next();         
                long stel=s.nextLong();
                
                //System.out.print(" " + sid + "\t|\t");
                System.out.print(sname + "\t\t|\t");
                System.out.print(sadr + "\t\t|\t");
                System.out.println(stel);
                //stmt.setInt(1,sid);
                stmt.setString(1,sname);
                stmt.setString(2,sadr);
                stmt.setLong(3,stel);         
                int i=stmt.executeUpdate();              
                //System.out.println(i+" ins�r� avec succ�s");                
            }
         }
         catch(IOException e)
        {   
            e.printStackTrace();
        }
         conn.close();         
         
      }  catch (Exception e) {
         // gestion des exceptions
         System.out.println(e);
      }

    }
    
    public static void updateclt()
    {
        
    }
    
    public static void deletclient()
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
         try{   
            //d�finir la gestion des transactions manuelles
            con.setAutoCommit(false);

           //d�finir un point de sauvegarde
            Savepoint savepoint = con.setSavepoint("Savepoint1");
   
         // C. Cr�er un objet Statement
         
         System.out.println("\n >> Suppression d'un client ...");
         //Pr�paration de notre Requ�te param�tr�e
         
            Scanner s=new Scanner(System.in);
            System.out.print("\n   - Entrer > ID du client � supprimer :   ");
            int sidclt=s.nextInt();                       
            boolean ok=true;
            while(ok)
            {
                PreparedStatement stmtcmd = con.prepareStatement("DELETE FROM Commande WHERE idclt = ?");
            
                stmtcmd.setInt(1,sidclt);
                int j=stmtcmd.executeUpdate();
                if(j==0)
                   ok=false;
            }
            PreparedStatement stmtclt = con.prepareStatement("DELETE FROM CLIENT WHERE idclt = ?");
            stmtclt.setInt(1,sidclt);
            int i=stmtclt.executeUpdate();
            
            
            System.out.println(" Suppression ...");
           // S'il n'y a pas d'erreur.
            con.commit();

           System.out.println("Le client ID: " + sidclt + "  supprim� avec succ�s, ainsi toutes ses commandes  ...");
         }
         catch(SQLException se)
            {
            // S'il y a une erreur.
            con.rollback(savepoint);
            }

         
         // E. Fermer la connexion
         con.close();
         
      }  catch (Exception e) {
         // gestion des exceptions
         System.out.println(e);

      }        
    
    }
    
    public static void listeclient(){
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
         Statement smt = con.createStatement() ;
         System.out.println(" >> G�n�rer la liste des clients ...\n");
          // D. Ex�cuter des requ�tes
    
                  String sql = "SELECT idclt, nomclt, adrclt, telclt FROM client" +
                          " ORDER BY idclt ASC";

         ResultSet res = smt.executeQuery(sql) ;
         System.out.println("Liste des clients  \n");
         System.out.print("ID\t|\tNOM\t\t|\tADRESSE\t\t|\tTELEPHONE\n");
         System.out.println("----------------------------------------------------------------------------");
          while (res.next()) {
            //R�cup�rer par nom de colonne
            int id = res.getInt("idclt");
            String nom = res.getString("nomclt");
            String adr = res.getString("adrclt");
            long tel = res.getLong("telclt");
            //Afficher les valeurs
            System.out.print(" " + id + "\t|\t");
            System.out.print(nom + "\t\t|\t");
            System.out.print(adr + "\t\t|\t");
            System.out.println(tel);
        }
        // E. Fermer la connexion
         con.close();
         
      }  catch (Exception e) {
         // gestion des exceptions
         System.out.println(e);

      }        

    }
    
    public static void menugestionclt()
    {
         int choix = 0;
         Scanner masaisie = new Scanner(System.in,"UTF-8");
	 
	 do {
	        System.out.println(" >> GESTION DES CLIENTS << \n");
                System.out.println("      1. Ajouter un client  ");
                System.out.println("      2. Importer la liste des clients  ");
                System.out.println("      3. Modifier les information d'un client  ");
                System.out.println("      4. Supprimer un client  ");
                System.out.println("      5. Afficher la liste des clients  ");
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
	 		        System.out.println("\n ++++++ Choix 1 : Ajouter un Client  ++++++ \n");
                                addclient();
                                TD2Transaction.pressEnterToContinue();
                            	break;
			 
			 case 2 : 
			        System.out.println("\n ++++++ Choix 2 : Importer la liste des clients  ++++++ \n");
                                loadclients();
                                TD2Transaction.pressEnterToContinue();
                            	break;
			 case 3 :
                                System.out.println("\n ++++++ Choix 3 : Modifier les informations d'un client  ++++++ \n");
                                updateclt();
                                TD2Transaction.pressEnterToContinue();
                            	break;
			 case 4 :
                                System.out.println("\n ++++++ Choix 4 : Supprimer un client  ++++++ \n");
                                deletclient();
                                TD2Transaction.pressEnterToContinue();
                            	break;
			 case 5 :
                                System.out.println("\n ++++++ Choix 5 :  Afficher la liste des clients  ++++++ \n");
                                listeclient();
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
