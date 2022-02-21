import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class App {

        //MAIN MENU `WELKOM....`
        static void Menu() throws InterruptedException {
            Scanner input = new Scanner(System.in);
            int choice;
            do {                        
                System.out.println("\n\n\n\n\n\nWELKOM IN SURICURRENCY MENU");
                System.out.println("---------------------------");
                System.out.print("1       Overzicht van de banken \n");
                System.out.print("2       Voordeel optie\n");
                System.out.print("3       Overige gegevens\n");
                System.out.print("4  [X]  AFSLUITEN\n");
                keuze(); 
                choice = input.nextInt();
            }
            while(choice > 4);
            switch(choice){
            case 1:
                Sub_Menu();  
                break;
            case 2:
                Sub2_Menu(); 
                break;
            case 3: 
                Sub3_Menu();
                break;
            case 4: // AFSLUITEN
                close();
                break;
            }
            // BAD MENU OPTION DIRECT
            if (choice > 4 || choice < 1){
                do{
                    choice = input.nextInt();
                }
                while(choice < 4 );
            }
            input.close();
          }
        
        //SUB MENU `OVERZICHT VAN DE BANKEN`
        static void Sub_Menu() throws InterruptedException {
            Connection dbConnection = null;
            System.out.println("\n\n\n\n\n\nOVERZICHT VAN DE BANKEN");
            System.out.println("------------------------");
            try { 
                dbConnection = getConnection(); 
                if (dbConnection != null) { 
                } 
                String sql = "SELECT * FROM bank";
                Statement stmt = dbConnection.createStatement();
                ResultSet rs = stmt.executeQuery(sql); 
                // LOOP THROUGH THE RESULT SET
                while (rs.next()) {
                    System.out.println(
                        rs.getString("id") + "\t" + 
                        rs.getString("naam") + "\t");
                }   
            } catch (SQLException ex) { 
                System.out.println("An error occurred while connecting MySQL databse"); ex.printStackTrace(); 
                }
        
            Scanner input = new Scanner(System.in);
            int choice;
            do{
                System.out.print("6  [<]  TERUG NAAR MENU\n");
                System.out.print("7  [X]  AFSLUITEN\n");
                keuze(); 
                choice = input.nextInt();   
            }
            while(choice > 7);
            switch(choice){  
            case 1: // SUB MENU 1 - DE SURINAAMSE BANK - DATABASE CONNECTION - valuta_soort
                System.out.print("\n\n\n\n\n\nDE SURINAAMSE BANK - OVERZICHT VAN DE VALUTASOORTEN\n");
                System.out.println("-----------------------------------------------------");
                try { 
                    dbConnection = getConnection(); 
                    if (dbConnection != null) { 
                    } 
                    String sql = "SELECT * FROM valuta_soort";
                    Statement stmt = dbConnection.createStatement();
                    ResultSet rs = stmt.executeQuery(sql); 
                    // LOOP THROUGH THE RESULT SET
                    while (rs.next()) {
                        System.out.println(
                            rs.getString("id") + "\t" + 
                            rs.getString("valuta_eenheid") + "\t");
                    }   
                } catch (SQLException ex) { 
                    System.out.println("An error occurred while connecting MySQL databse"); ex.printStackTrace(); 
                }
                int choice3;
                do{
                    System.out.print("6  [<]  TERUG NAAR MENU\n");
                    System.out.print("7  [X]  AFSLUITEN\n");
                    keuze();                    
                    choice3 = input.nextInt();   
                }
                while(choice3 > 7);
                switch(choice3){       
                case 1: // DE SURINAAMSE BANK - DATABASE CONNECTION - valuta_USD - AANKOOP EN VERKOOP 
                    System.out.print("\n\n\n\n\n\nDE SURINAAMSE BANK - OVERZICHT VAN DE KOERSEN\n");
                    System.out.println("---------------------------------------------"); 
                    System.out.println("AANGEPAST \tVALUTA SOORT \tAANKOOP KOERS \tVERKOOP KOERS");  
                    try { 
                        dbConnection = getConnection(); 
                        if (dbConnection != null) { 
                        } 
                        String sql = "SELECT * FROM valuta_koers left join valuta_soort on valuta_koers.valuta_soort_id = valuta_soort.id where bank1_id = 1 and valuta_soort_id = 1;";
                        Statement stmt = dbConnection.createStatement();
                        ResultSet rs = stmt.executeQuery(sql); 
                        // LOOP THROUGH THE RESULT SET
                        while (rs.next()) {
                                System.out.println(
                                rs.getString("koers_date") + "\t" +
                                rs.getString("valuta_eenheid") + "\t\t" +
                                rs.getString("koers_opkoop") + "\t\t" +
                                rs.getString("koers_verkoop") + "\t");
                        }   
                    } catch (SQLException ex) { 
                        System.out.println("An error occurred while connecting MySQL databse"); ex.printStackTrace(); 
                    }
                    // SELECT OPTIONS OM TERUG TE GAAN NAAR MENU OF AFSLUITEN
                    Scanner input3a = new Scanner(System.in);
                    int choice3a;
                    do {                  
                        TerugEnAfsluiten();
                        keuze();                        
                        choice3a = input3a.nextInt();
                    }
                    while(choice3a > 2);
                    switch(choice3a){
                    case 1: // TERUG NAAR MAIN MENU
                        Menu(); 
                        break;  
                    case 2: // AFSLUITEN
                        close(); 
                        break;
                    } // BAD MENU OPTION DIRECT
                    if (choice3a > 2 || choice3a < 1){
                        do{
                            choice3a = input3a.nextInt();
                        }
                        while(choice3a < 2 );
                    }  
                    break;
                case 2: // DE SURINAAMSE BANK - DATABASE CONNECTION - valuta_EURO - AANKOOP EN VERKOOP 
                    System.out.print("\n\n\n\n\n\nDE SURINAAMSE BANK - OVERZICHT VAN DE KOERSEN\n");
                    System.out.println("---------------------------------------------\n");
                    System.out.println("AANGEPAST \tVALUTA SOORT \tAANKOOP KOERS \tVERKOOP KOERS");  
                    try {  
                        if (dbConnection != null) { 
                        } 
                        String sql = "SELECT * FROM valuta_koers left join valuta_soort on valuta_koers.valuta_soort_id = valuta_soort.id where bank1_id = 1 and valuta_soort_id = 2;";
                        Statement stmt = dbConnection.createStatement();
                        ResultSet rs = stmt.executeQuery(sql); 
                        // LOOP THROUGH THE RESULT SET
                        while (rs.next()) {
                            System.out.println(
                            rs.getString("koers_date") + "\t" +
                            rs.getString("valuta_eenheid") + "\t\t" +
                            rs.getString("koers_opkoop") + "\t\t" +
                            rs.getString("koers_verkoop") + "\t");
                        }   
                    } catch (SQLException ex) { 
                        System.out.println("An error occurred while connecting MySQL databse"); ex.printStackTrace(); 
                    }
                    // SELECT OPTIONS OM TERUG TE GAAN NAAR MENU OF AFSLUITEN
                    Scanner input3b = new Scanner(System.in);
                    int choice3b;
                    do {
                        TerugEnAfsluiten();                        
                        keuze();                        
                        choice3b = input3b.nextInt();
                    }
                    while(choice3b > 2);
                    switch(choice3b){
                    case 1: // TERUG NAAR MAIN MENU
                        Menu();
                        break;  
                    case 2: // AFSLUITEN
                        close();
                        break;
                    } // BAD MENU OPTION DIRECT
                    if (choice3b > 2 || choice3b < 1){
                        do{
                            choice3b = input3b.nextInt();
                        }
                        while(choice3b < 2 );
                    }  
                    break;
                case 3: // DE SURINAAMSE BANK - DATABASE CONNECTION - valuta_GYD - AANKOOP EN VERKOOP
                    System.out.println("NOG GEEN DATA VOOR GYD...\n\n");
                    AutoReturnToMenu();
                    Menu();
                    break;
                case 4: // DE SURINAAMSE BANK - DATABASE CONNECTION - valuta_BRL - AANKOOP EN VERKOOP
                    System.out.println("NOG GEEN DATA VOOR BRL...\n\n");
                    AutoReturnToMenu();
                    Menu();
                    break;
                case 5: // DE SURINAAMSE BANK - DATABASE CONNECTION - valuta_FRF - AANKOOP EN VERKOOP
                    System.out.println("NOG GEEN DATA VOOR FRF...\n\n");
                    AutoReturnToMenu();
                    Menu();
                    break;
                case 6: // TERUG NAAR MAIN MENU
                    Menu();
                    break;
                case 7: // AFSLUITEN
                    close();
                    break;
            }
            // BAD MENU OPTION DIRECT  
            if (choice3 > 7 || choice3 < 1){
                do{
                    choice3 = input.nextInt();
                }
                while(choice3 < 7 );
            }
            break; 
            case 2: // SUB MENU 1 - DE FINA BANK - DATABASE CONNECTION - valuta_soort
                System.out.print("\n\n\n\n\n\nDE FINA BANK - OVERZICHT VAN DE VALUTASOORTEN\n");
                System.out.println("---------------------------------------------");
                try { 
                    if (dbConnection != null) { 
                    } 
                    String sql = "SELECT * FROM valuta_soort";
                    Statement stmt = dbConnection.createStatement();
                    ResultSet rs = stmt.executeQuery(sql); 
                    // LOOP THROUGH THE RESULT SET
                    while (rs.next()) {
                        System.out.println(
                            rs.getString("id") + "\t" + 
                            rs.getString("valuta_eenheid") + "\t");
                    }   
                } catch (SQLException ex) { 
                    System.out.println("An error occurred while connecting MySQL databse"); ex.printStackTrace(); 
                }
                int choice4;
                do{
                    System.out.print("6  [<]  TERUG NAAR MENU\n");
                    System.out.print("7  [X]  AFSLUITEN\n");
                    keuze();                    
                    choice4 = input.nextInt();   
                    System.out.println( "\n---------------------------------------------------------------------"); 
                }
                while(choice4 >6);
                switch(choice4){
                case 1: // DE FINA BANK - DATABASE CONNECTION - valuta_USD - AANKOOP EN VERKOOP 
                    System.out.print("\n\n\n\n\n\nDE FINA BANK - OVERZICHT VAN DE KOERSEN\n");
                    System.out.println("---------------------------------------\n");
                    System.out.println("AANGEPAST \tVALUTA SOORT \tAANKOOP KOERS \tVERKOOP KOERS");  
                    try { 
                        if (dbConnection != null) { 
                        } 
                        String sql = "SELECT * FROM valuta_koers left join valuta_soort on valuta_koers.valuta_soort_id = valuta_soort.id where bank1_id = 2 and valuta_soort_id = 1;";
                        Statement stmt = dbConnection.createStatement();
                        ResultSet rs = stmt.executeQuery(sql); 
                        // LOOP THROUGH THE RESULT SET
                        while (rs.next()) {
                            System.out.println(
                            rs.getString("koers_date") + "\t" +
                            rs.getString("valuta_eenheid") + "\t\t" +
                            rs.getString("koers_opkoop") + "\t\t" +
                            rs.getString("koers_verkoop") + "\t");
                        }   
                    } catch (SQLException ex) { 
                          System.out.println("An error occurred while connecting MySQL databse"); ex.printStackTrace(); 
                    }
                    // SELECT OPTIONS OM TERUG TE GAAN NAAR MENU OF AFSLUITEN
                    Scanner input3a = new Scanner(System.in);
                    int choice3a;
                    do {
                        TerugEnAfsluiten();                        
                        keuze();                        
                        choice3a = input3a.nextInt();
                    }
                    while(choice3a > 2);
                    switch(choice3a){
                    case 1: // TERUG NAAR MAIN MENU
                        Menu();
                        break;  
                    case 2: // AFSLUITEN
                        close();
                        break;
                    } // BAD MENU OPTION DIRECT
                    if (choice3a > 2 || choice3a < 1){
                        do{
                            choice3a = input3a.nextInt();
                        }
                        while(choice3a < 2 );
                    }  
                    break;
                case 2: // DE FINA BANK - DATABASE CONNECTION - valuta_EURO - AANKOOP EN VERKOOP 
                    System.out.print("\n\n\n\n\n\nDE FINA BANK - OVERZICHT VAN DE KOERSEN\n");
                    System.out.println("---------------------------------------\n");  
                    System.out.println("AANGEPAST \tVALUTA SOORT \tAANKOOP KOERS \tVERKOOP KOERS");  
                    try {  
                        if (dbConnection != null) { 
                        } 
                        String sql = "SELECT * FROM valuta_koers left join valuta_soort on valuta_koers.valuta_soort_id = valuta_soort.id where bank1_id = 2 and valuta_soort_id = 2;";
                        Statement stmt = dbConnection.createStatement();
                        ResultSet rs = stmt.executeQuery(sql); 
                        // LOOP THROUGH THE RESULT SET
                        while (rs.next()) {
                            System.out.println(
                            rs.getString("koers_date") + "\t" +
                            rs.getString("valuta_eenheid") + "\t\t" +
                            rs.getString("koers_opkoop") + "\t\t" +
                            rs.getString("koers_verkoop") + "\t");
                        }   
                    } catch (SQLException ex) { 
                        System.out.println("An error occurred while connecting MySQL databse"); ex.printStackTrace(); 
                    }
                    // SELECT OPTIONS OM TERUG TE GAAN NAAR MENU OF AFSLUITEN
                    Scanner input3b = new Scanner(System.in);
                    int choice3b;
                    do {
                        TerugEnAfsluiten();                        
                        keuze();                        
                        choice3b = input3b.nextInt();
                    }
                    while(choice3b > 2);
                    switch(choice3b){
                    case 1: // TERUG NAAR MAIN MENU
                        Menu();
                        break;  
                    case 2: // AFSLUITEN
                        close();
                        break;
                    } // BAD MENU OPTION DIRECT
                    if (choice3b > 2 || choice3b < 1){
                        do{
                            choice3b = input3b.nextInt();
                        }
                        while(choice3b < 2 );
                    }  
                    break;
                case 3: // DE FINA BANK - DATABASE CONNECTION - valuta_GYD- AANKOOP EN VERKOOP
                    System.out.println("NOG GEEN DATA VOOR GYD...\n\n");
                    AutoReturnToMenu();
                    Menu();
                    break;
                case 4: // DE FINA BANK - DATABASE CONNECTION - valuta_BRL - AANKOOP EN VERKOOP
                    System.out.println("NOG GEEN DATA VOOR BRL...\n\n");
                    AutoReturnToMenu();
                    Menu();
                    break;
                case 5: // DE FINA BANK - DATABASE CONNECTION - valuta_FRF - AANKOOP EN VERKOOP
                    System.out.println("NOG GEEN DATA VOOR FRF...\n\n");
                    AutoReturnToMenu();
                    Menu();
                break;
                case 6: // TERUG NAAR MAIN MENU
                    Menu();
                    break;
                case 7: // AFSLUITEN
                   close();
                   break;
            }
            // BAD MENU OPTION DIRECT
            if (choice4 > 6 || choice4 < 1){
                do{
                    choice4 = input.nextInt();
                }
                while(choice4 < 7 );
            }
            break;   
            case 3: // SUB MENU 1 - DE AMANAH BANK - DATABASE CONNECTION - valuta_soort
                System.out.print("\n\n\n\n\n\nDE AMANAH BANK - OVERZICHT VAN DE VALUTASOORTEN\n");
                System.out.println("-----------------------------------------------");
                try { 
                    if (dbConnection != null) { 
                    } 
                    String sql = "SELECT * FROM valuta_soort";
                    Statement stmt = dbConnection.createStatement();
                    ResultSet rs = stmt.executeQuery(sql); 
                    // LOOP THROUGH THE RESULT SET
                    while (rs.next()) {
                        System.out.println(
                            rs.getString("id") + "\t" + 
                            rs.getString("valuta_eenheid") + "\t");
                    }   
                } catch (SQLException ex) { 
                    System.out.println("An error occurred while connecting MySQL databse"); ex.printStackTrace(); 
                }
                int choice5;
                do{
                    System.out.print("6  [<]  TERUG NAAR MENU\n");
                    System.out.print("7  [X]  AFSLUITEN\n");
                    keuze();                    
                    choice5 = input.nextInt();   
                    System.out.println( "\n---------------------------------------------------------------------"); 
                }
                while(choice5 >6);
                switch(choice5){
                case 1: // DE AMANAH BANK - DATABASE CONNECTION - valuta_USD - AANKOOP EN VERKOOP       
                    System.out.print("\n\n\n\n\n\nDE AMANAH BANK - OVERZICHT VAN DE KOERSEN\n");
                    System.out.println("-----------------------------------------\n");
                    System.out.println("AANGEPAST \tVALUTA SOORT \tAANKOOP KOERS \tVERKOOP KOERS");  
                    try { 
                        if (dbConnection != null) { 
                        } 
                        String sql = "SELECT * FROM valuta_koers left join valuta_soort on valuta_koers.valuta_soort_id = valuta_soort.id where bank1_id = 3 and valuta_soort_id = 1;";
                        Statement stmt = dbConnection.createStatement();
                        ResultSet rs = stmt.executeQuery(sql); 
                        // LOOP THROUGH THE RESULT SET
                        while (rs.next()) {
                            System.out.println(
                            rs.getString("koers_date") + "\t" +
                            rs.getString("valuta_eenheid") + "\t\t" +
                            rs.getString("koers_opkoop") + "\t\t" +
                            rs.getString("koers_verkoop") + "\t");
                        }   
                    } catch (SQLException ex) { 
                        System.out.println("An error occurred while connecting MySQL databse"); ex.printStackTrace(); 
                    }
                    // SELECT OPTIONS OM TERUG TE GAAN NAAR MENU OF AFSLUITEN
                    Scanner input3a = new Scanner(System.in);
                    int choice3a;
                    do {
                        TerugEnAfsluiten();                        
                        keuze();                        
                        choice3a = input3a.nextInt();
                    }
                    while(choice3a > 2);
                    switch(choice3a){
                    case 1: // TERUG NAAR MAIN MENU
                        Menu();
                        break;  
                    case 2: // AFSLUITEN
                        close();
                        break;
                    } // BAD MENU OPTION DIRECT
                    if (choice3a > 2 || choice3a < 1){
                        do{
                            choice3a = input3a.nextInt();
                        }
                        while(choice3a < 2 );
                    }  
                case 2: // DE AMANAH BANK - DATABASE CONNECTION - valuta_EURO - AANKOOP EN VERKOOP       
                    System.out.print("\n\n\n\n\n\nDE AMANAH BANK - OVERZICHT VAN DE KOERSEN\n");
                    System.out.println("-----------------------------------------\n");  
                    System.out.println("AANGEPAST \tVALUTA SOORT \tAANKOOP KOERS \tVERKOOP KOERS");                      
                    try {  
                        if (dbConnection != null) { 
                        } 
                        String sql = "SELECT * FROM valuta_koers left join valuta_soort on valuta_koers.valuta_soort_id = valuta_soort.id where bank1_id = 3 and valuta_soort_id = 2;";
                        Statement stmt = dbConnection.createStatement();
                        ResultSet rs = stmt.executeQuery(sql); 
                        // LOOP THROUGH THE RESULT SET
                        while (rs.next()) {
                            System.out.println(
                            rs.getString("koers_date") + "\t" +
                            rs.getString("valuta_eenheid") + "\t\t" +
                            rs.getString("koers_opkoop") + "\t\t" +
                            rs.getString("koers_verkoop") + "\t");
                        }   
                    } catch (SQLException ex) { 
                        System.out.println("An error occurred while connecting MySQL databse"); ex.printStackTrace(); 
                    }
                    // SELECT OPTIONS OM TERUG TE GAAN NAAR MENU OF AFSLUITEN
                    Scanner input3b = new Scanner(System.in);
                    int choice3b;
                    do {
                        TerugEnAfsluiten();                        
                        keuze();                       
                        choice3b = input3b.nextInt();
                    }
                    while(choice3b > 2);
                    switch(choice3b){
                    case 1: // TERUG NAAR MAIN MENU
                        Menu();
                        break;  
                    case 2: // AFSLUITEN
                        close();
                        break;
                    } // BAD MENU OPTION DIRECT
                    if (choice3b > 2 || choice3b < 1){
                        do{
                            choice3b = input3b.nextInt();
                        }
                        while(choice3b < 2 );
                    }  
                    break;
                case 3: // DE AMANAH BANK - DATABASE CONNECTION - valuta_GYD - AANKOOP EN VERKOOP
                    System.out.println("NOG GEEN DATA VOOR GYD...\n\n");
                    AutoReturnToMenu();
                    Menu();
                    break;
                case 4: // DE AMANAH BANK - DATABASE CONNECTION - valuta_BRL - AANKOOP EN VERKOOP
                    System.out.println("NOG GEEN DATA VOOR BRL...\n\n");
                    AutoReturnToMenu();
                    Menu();
                    break;
                case 5: // DE AMANAH BANK - DATABASE CONNECTION - valuta_FRF - AANKOOP EN VERKOOP
                    System.out.println("NOG GEEN DATA VOOR FRF...\n\n");
                    AutoReturnToMenu();
                    Menu();
                    break;
                case 6: // TERUG NAAR MAIN MENU
                    Menu();
                    break;
                case 7: // AFSLUITEN
                    close();
                    break;
            }
                // BAD MENU OPTION DIRECT
            if (choice5 > 6 || choice5 < 1){
                do{
                    choice5 = input.nextInt();
                }
                while(choice5 < 7 );
            }
            break;   
            case 4: // SUB MENU 1 - DE GODO BANK - DATABASE CONNECTION - valuta_soort  
                System.out.print("\n\n\n\n\n\nDE GODO BANK - OVERZICHT VAN DE VALUTASOORTEN\n");
                System.out.println("---------------------------------------------");                
                try { 
                    if (dbConnection != null) { 
                    } 
                    String sql = "SELECT * FROM valuta_soort";
                    Statement stmt = dbConnection.createStatement();
                    ResultSet rs = stmt.executeQuery(sql); 
                    // LOOP THROUGH THE RESULT SET
                    while (rs.next()) {
                        System.out.println(
                            rs.getString("id") + "\t" + 
                            rs.getString("valuta_eenheid") + "\t");
                    }   
                } catch (SQLException ex) { 
                    System.out.println("An error occurred while connecting MySQL databse"); ex.printStackTrace(); 
                }
                int choice6;
                do{
                    System.out.print("6  [<]  TERUG NAAR MENU\n");
                    System.out.print("7  [X]  AFSLUITEN\n");
                    keuze();                    
                    choice6 = input.nextInt();   
                }
                while(choice6 >6);
                switch(choice6){
                case 1: // DE GODO BANK - DATABASE CONNECTION - valuta_USD - AANKOOP EN VERKOOP               
                    System.out.print("\n\n\n\n\n\nDE GODO BANK - OVERZICHT VAN DE KOERSEN\n");
                    System.out.println("---------------------------------------");
                    System.out.println("AANGEPAST \tVALUTA SOORT \tAANKOOP KOERS \tVERKOOP KOERS");                  
                    try { 
                        if (dbConnection != null) { 
                        } 
                        String sql = "SELECT * FROM valuta_koers left join valuta_soort on valuta_koers.valuta_soort_id = valuta_soort.id where bank1_id = 4 and valuta_soort_id = 1;";
                        Statement stmt = dbConnection.createStatement();
                        ResultSet rs = stmt.executeQuery(sql); 
                        // LOOP THROUGH THE RESULT SET
                        while (rs.next()) {
                            System.out.println(
                            rs.getString("koers_date") + "\t" +
                            rs.getString("valuta_eenheid") + "\t\t" +
                            rs.getString("koers_opkoop") + "\t\t" +
                            rs.getString("koers_verkoop") + "\t");
                        }   
                    } catch (SQLException ex) { 
                        System.out.println("An error occurred while connecting MySQL databse"); ex.printStackTrace(); 
                    }
                    // SELECT OPTIONS OM TERUG TE GAAN NAAR MENU OF AFSLUITEN
                    Scanner input3a = new Scanner(System.in);
                    int choice3a;
                    do {
                        TerugEnAfsluiten();                        
                        keuze();                        
                        choice3a = input3a.nextInt();
                    }
                    while(choice3a > 2);
                    switch(choice3a){
                    case 1: // TERUG NAAR MAIN MENU
                        Menu();
                        break;  
                    case 2: // AFSLUITEN
                        close();
                        break;
                    } // BAD MENU OPTION DIRECT
                    if (choice3a > 2 || choice3a < 1){
                        do{
                            choice3a = input3a.nextInt();
                        }
                        while(choice3a < 2 );
                    }  
                case 2: // DE GODO BANK - DATABASE CONNECTION - valuta_EURO - AANKOOP EN VERKOOP              
                    System.out.print("\n\n\n\n\n\nDE GODO BANK - OVERZICHT VAN DE KOERSEN\n");
                    System.out.println("---------------------------------------");
                    System.out.println("AANGEPAST \tVALUTA SOORT \tAANKOOP KOERS \tVERKOOP KOERS");                  
                    try {  
                        if (dbConnection != null) { 
                        } 
                        String sql = "SELECT * FROM valuta_koers left join valuta_soort on valuta_koers.valuta_soort_id = valuta_soort.id where bank1_id = 4 and valuta_soort_id = 2;";
                        Statement stmt = dbConnection.createStatement();
                        ResultSet rs = stmt.executeQuery(sql); 
                        // LOOP THROUGH THE RESULT SET
                        while (rs.next()) {
                            System.out.println(
                            rs.getString("koers_date") + "\t" +
                            rs.getString("valuta_eenheid") + "\t\t" +
                            rs.getString("koers_opkoop") + "\t\t" +
                            rs.getString("koers_verkoop") + "\t");
                        }   
                    } catch (SQLException ex) { 
                        System.out.println("An error occurred while connecting MySQL databse"); ex.printStackTrace(); 
                    }
                    // SELECT OPTIONS OM TERUG TE GAAN NAAR MENU OF AFSLUITEN
                    Scanner input3b = new Scanner(System.in);
                    int choice3b;
                    do {
                        TerugEnAfsluiten();                        
                        keuze();                        
                        choice3b = input3b.nextInt();
                    }
                    while(choice3b > 2);
                    switch(choice3b){
                    case 1: // TERUG NAAR MAIN MENU
                        Menu();
                        break;  
                    case 2: // AFSLUITEN
                        close();
                        break;
                    } // BAD MENU OPTION DIRECT
                    if (choice3b > 2 || choice3b < 1){
                        do{
                            choice3b = input3b.nextInt();
                        }
                        while(choice3b < 2 );
                    }  
                    break;
                case 3: // DE GODO BANK - DATABASE CONNECTION - valuta_GYD - AANKOOP EN VERKOOP
                    System.out.println("NOG GEEN DATA VOOR GYD...\n\n");
                    AutoReturnToMenu();
                    Menu();
                    break;
                case 4: // DE GODO BANK - DATABASE CONNECTION - valuta_BRL - AANKOOP EN VERKOOP
                    System.out.println("NOG GEEN DATA VOOR BRL...\n\n");
                    AutoReturnToMenu();
                    Menu();
                break;
                case 5: // DE GODO BANK - DATABASE CONNECTION - valuta_FRF - AANKOOP EN VERKOOP
                    System.out.println("NOG GEEN DATA VOOR FRF...\n\n");
                    AutoReturnToMenu();
                    Menu();
                    break;
                case 6: // TERUG NAAR MAIN MENU
                    Menu();
                    break;
                case 7: // AFSLUITEN
                    close();
                    break;
            }
                // BAD MENU OPTION DIRECT
            if (choice6 > 6 || choice6 < 1){
                do{
                    choice6 = input.nextInt();
                }
                while(choice6 < 7 );
            }
            break;   
            case 5: // SUB MENU 1 - DE REPUBLIC BANK - DATABASE CONNECTION - valuta_soort 
                System.out.print("\n\n\n\n\n\nDE REPUBLIC BANK - OVERZICHT VAN DE VALUTASOORTEN\n");
                System.out.println("-------------------------------------------------");                
                try { 
                    if (dbConnection != null) { 
                    } 
                    String sql = "SELECT * FROM valuta_soort";
                    Statement stmt = dbConnection.createStatement();
                    ResultSet rs = stmt.executeQuery(sql); 
                    // LOOP THROUGH THE RESULT SET
                    while (rs.next()) {
                        System.out.println(
                            rs.getString("id") + "\t" + 
                            rs.getString("valuta_eenheid") + "\t");
                    }   
                } catch (SQLException ex) { 
                    System.out.println("An error occurred while connecting MySQL databse"); ex.printStackTrace(); 
                }
                int choice7;
                do{
                    System.out.print("6  [<]  TERUG NAAR MENU\n");
                    System.out.print("7  [X]  AFSLUITEN\n");
                    keuze();                    
                    choice7 = input.nextInt();   
                    System.out.println( "\n---------------------------------------------------------------------"); 
                }
                while(choice7 >6);
                switch(choice7){
                case 1: // DE REPUBLIC BANK - DATABASE CONNECTION - valuta_USD - AANKOOP EN VERKOOP 
                System.out.print("\n\n\n\n\n\nDE REPUBLIC BANK - OVERZICHT VAN DE VALUTASOORTEN\n");
                System.out.println("-------------------------------------------------");
                System.out.println("AANGEPAST \tVALUTA SOORT \tAANKOOP KOERS \tVERKOOP KOERS");                      
                try { 
                        if (dbConnection != null) { 
                        } 
                        String sql = "SELECT * FROM valuta_koers left join valuta_soort on valuta_koers.valuta_soort_id = valuta_soort.id where bank1_id = 5 and valuta_soort_id = 1;";
                        Statement stmt = dbConnection.createStatement();
                        ResultSet rs = stmt.executeQuery(sql); 
                        // LOOP THROUGH THE RESULT SET
                        while (rs.next()) {
                            System.out.println(
                            rs.getString("koers_date") + "\t" +
                            rs.getString("valuta_eenheid") + "\t\t" +
                            rs.getString("koers_opkoop") + "\t\t" +
                            rs.getString("koers_verkoop") + "\t");
                        }   
                    } catch (SQLException ex) { 
                        System.out.println("An error occurred while connecting MySQL databse"); ex.printStackTrace(); 
                    }
                    // SELECT OPTIONS OM TERUG TE GAAN NAAR MENU OF AFSLUITEN
                    Scanner input3a = new Scanner(System.in);
                    int choice3a;
                    do {
                        TerugEnAfsluiten();                        
                        keuze();                        
                        choice3a = input3a.nextInt();
                    }
                    while(choice3a > 2);
                    switch(choice3a){
                    case 1: // TERUG NAAR MAIN MENU
                        Menu();
                        break;  
                    case 2: // AFSLUITEN
                        close();
                        break;
                    } // BAD MENU OPTION DIRECT
                    if (choice3a > 2 || choice3a < 1){
                        do{
                            choice3a = input3a.nextInt();
                        }
                        while(choice3a < 2 );
                    }  
                case 2: // DE REPUBLIC BANK - DATABASE CONNECTION - valuta_EURO - AANKOOP EN VERKOOP 
                    System.out.print("\n\n\n\n\n\nDE REPUBLIC BANK - OVERZICHT VAN DE VALUTASOORTEN\n");
                    System.out.println("-------------------------------------------------");
                    System.out.println("AANGEPAST \tVALUTA SOORT \tAANKOOP KOERS \tVERKOOP KOERS");                      
                    try {  
                        if (dbConnection != null) { 
                        } 
                        String sql = "SELECT * FROM valuta_koers left join valuta_soort on valuta_koers.valuta_soort_id = valuta_soort.id where bank1_id = 5 and valuta_soort_id = 2;";
                        Statement stmt = dbConnection.createStatement();
                        ResultSet rs = stmt.executeQuery(sql); 
                        // LOOP THROUGH THE RESULT SET
                        while (rs.next()) {
                            System.out.println(
                            rs.getString("koers_date") + "\t" +
                            rs.getString("valuta_eenheid") + "\t\t" +
                            rs.getString("koers_opkoop") + "\t\t" +
                            rs.getString("koers_verkoop") + "\t");
                        }   
                    } catch (SQLException ex) { 
                        System.out.println("An error occurred while connecting MySQL databse"); ex.printStackTrace(); 
                    }
                    // SELECT OPTIONS OM TERUG TE GAAN NAAR MENU OF AFSLUITEN
                    Scanner input3b = new Scanner(System.in);
                    int choice3b;
                    do {
                        TerugEnAfsluiten();                        
                        keuze();                        
                        choice3b = input3b.nextInt();
                    }
                    while(choice3b > 2);
                    switch(choice3b){
                    case 1: // TERUG NAAR MAIN MENU
                        Menu();
                        break;  
                    case 2: // AFSLUITEN
                        close();
                        break;
                    } // BAD MENU OPTION DIRECT
                    if (choice3b > 2 || choice3b < 1){
                        do{
                            choice3b = input3b.nextInt();
                        }
                        while(choice3b < 2 );
                    }  
                    break;
                case 3: // DE REPUBLIC BANK - DATABASE CONNECTION - valuta_GYD - AANKOOP EN VERKOOP 
                    System.out.println("NOG GEEN DATA VOOR GYD...\n\n");
                    AutoReturnToMenu();
                    Menu();
                    break;
                case 4: // DE REPUBLIC BANK - DATABASE CONNECTION - valuta_BRL - AANKOOP EN VERKOOP 
                    System.out.println("NOG GEEN DATA VOOR BRL...\n\n");
                    AutoReturnToMenu();
                    Menu();
                    break;
                case 5: // DE REPUBLIC BANK - DATABASE CONNECTION - valuta_FRF - AANKOOP EN VERKOOP  
                    System.out.println("NOG GEEN DATA VOOR FRF...\n\n");
                    AutoReturnToMenu();
                    Menu();
                    break;
                case 6: // TERUG NAAR MAIN MENU
                    Menu();
                    break;
                case 7: // AFSLUITEN
                    close();
                    break;
        }
            // BAD MENU OPTION DIRECT
        if (choice7 > 7 || choice7 < 1){
            do{
                choice7 = input.nextInt();
            }
            while(choice7 < 7 );
        }
        case 6: // TERUG NAAR MAIN MENU
            Menu();  
            break;
        case 7: // AFSLUITEN
            close();
            break;
        } // BAD MENU OPTION DIRECT
        if (choice > 7 || choice < 1){
            do{
                choice = input.nextInt();
            }
            while(choice < 7 );
        }
        input.close();
        }
        
        //SUB 2 MENU `VOORDEEL OPTIE`
        static void Sub2_Menu() throws InterruptedException {
            //SUB MENU 2 -  VOORDEEL OPTIE - KIES VALUTASOORT
            System.out.println( "\n\n\n\n\n\nDE VOORDEEL OPTIES: Kies uw valuta soort");
            System.out.println(             "----------------------------------------");
            Scanner input = new Scanner(System.in);
            int choice4;
            do{
                System.out.print("1       $ (US DOLLAR)\n");
                System.out.print("2       € (EURO)\n");
                System.out.print("3  [<]  TERUG NAAR MENU\n");
                System.out.print("4  [X]  AFSLUITEN\n");
                keuze();                
                choice4 = input.nextInt();          
            }
            while(choice4 > 4);
            switch(choice4){
            case 1: //SUB SUB MENU VOORDEEL OPTIE - VALUTASOORT USD - AANKOOP OF VERKOOP
                System.out.println( "\n\n\n\n\n\nDE VOORDEEL OPTIES: Aankoop of Verkoop");
                System.out.println(             "--------------------------------------");
                int choiceAankoopVerkoopUsd;
                do{
                    System.out.print("1       Aankoop\n");
                    System.out.print("2       Verkoop\n");
                    System.out.print("3  [<]  TERUG NAAR MENU\n");
                    System.out.print("4  [X]  AFSLUITEN\n");
                    keuze();                        
                    choiceAankoopVerkoopUsd = input.nextInt();   
                }
                while(choiceAankoopVerkoopUsd > 4 );
                switch(choiceAankoopVerkoopUsd){
                case 1: // VOORDEEL OPTIE VOOR AANKOOP VAN USD 
                    Voordeel_aankoop_usd();
                    break;
                case 2: // VOORDEEL OPTIE VOOR VERKOOP VAN USD 
                    Voordeel_verkoop_usd();
                    break;
                case 3: // TERUG NAAR MAIN MENU
                        Menu();
                        break;
                case 4: // AFSLUITEN
                    close();
                    break;
                } // BAD MENU OPTION DIRECT
                if (choiceAankoopVerkoopUsd > 4 || choiceAankoopVerkoopUsd < 1){
                    do{
                        choiceAankoopVerkoopUsd = input.nextInt();
                    }
                        while(choiceAankoopVerkoopUsd < 4 );
                    }  
                break;
            case 2:  // SUB SUB MENU VOORDEEL OPTIE - VALUTASOORT EURO - AANKOOP OF VERKOOP
                System.out.println( "\n\n\n\n\n\nDE VOORDEEL OPTIES: Aankoop of Verkoop");
                System.out.println(             "--------------------------------------");
                int choiceAankoopVerkoopEuro;
                do{
                    System.out.print("1       Aankoop\n");
                    System.out.print("2       Verkoop\n");
                    System.out.print("3  [<]  TERUG NAAR MENU\n");
                    System.out.print("4  [X]  AFSLUITEN\n");
                    keuze();                    
                    choiceAankoopVerkoopEuro = input.nextInt();   
                }
                while(choiceAankoopVerkoopEuro >4);
                switch(choiceAankoopVerkoopEuro){
                case 1: // VOORDEEL OPTIE VOOR AANKOOP VAN EURO 
                    Voordeel_aankoop_euro();
                    break;
                case 2: // VOORDEEL OPTIE VOOR VERKOOP VAN EURO    
                    Voordeel_verkoop_euro();
                    break;
                case 3: // TERUG NAAR MAIN MENU
                        Menu();
                        break;
                case 4: // AFSLUITEN
                        close();
                        break;
                } // BAD MENU OPTION DIRECT
                if (choiceAankoopVerkoopEuro > 4 || choiceAankoopVerkoopEuro < 1){
                    do{
                        choiceAankoopVerkoopEuro = input.nextInt();
                    }
                    while(choiceAankoopVerkoopEuro < 4 );
                }  
                break;
            case 3: // TERUG NAAR MAIN MENU
                Menu();
                break; 
            case 4: // AFSLUITEN
                close();
                break;
            } // BAD MENU OPTION DIRECT
            if (choice4 > 4 || choice4 < 1){
                do{
                choice4 = input.nextInt();
                }
                while(choice4 < 4 );
            }    
            input.close();
        }
        
        // SUB 3 MENU `OVERIGE GEGEVENS`
        static void Sub3_Menu() throws InterruptedException {
            System.out.println("\n-----------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("OPLEIDING:      UNIVERSITY OF APPLIED SCIENCE AND TECHNOLOGY (UNASAT)");
            System.out.println("RICHTING:       BEDRIJFSKUNDIGE INFORMATICA");
            System.out.println("COHORT:         2020/2021");
            System.out.println("SEMESTER:       2 | BLOK: 2");
            System.out.println("BEROEPSPRODUCT: JAVA EN DATABASES");
            System.out.println("PROJECT:        Een applicatie die een overzicht geeft van de verschillende banken in Suriname met hun bijbehorende wisselkoersen per valutasoort\n");
            System.out.println("BOUWERS VAN DEZE APPLICATIE:");
            System.out.println("# \t NAAM \t\t\t STUDENTEN NUMMER \t");
            System.out.println("1 \t Karijoleksono Hanif \t BI/1120/015 \t");
            System.out.println("2 \t Karin Setrodjemino  \t BI/1117/010 \t");
            System.out.println("3 \t Ruiz Ceder          \t SE/1116/036 \t");
            System.out.println("4 \t Sudjata Doekhi      \t BI/1120/006 \t");
                Scanner input = new Scanner(System.in);
                int choice;
                do {
                    TerugEnAfsluiten();                        
                    keuze();                    
                    choice = input.nextInt();
                }
                while(choice > 2);
                switch(choice){
                case 1: // TERUG NAAR MAIN MENU
                    Menu();  
                    break;
                case 2: // AFSLUITEN
                    close();
                    break;
                }
                  // BAD MENU OPTION DIRECT
                    if (choice > 2 || choice < 1){
                        do{
                            choice = input.nextInt();
                        }
                        while(choice < 2 );
                    }
                    input.close();
        }
      

        // VOORDEEL OPTIE KOPEN USD
        static void Voordeel_aankoop_usd() throws InterruptedException{
            Connection dbConnection = null;
            System.out.println("\n\n\n\n\n\nVOORDELIGSTE OPTIE VOOR HET AANKOPEN VAN $ (US DOLLAR) IS BIJ: ");
            System.out.println(            "--------------------------------------------------------------");
            try { 
                dbConnection = getConnection(); 
                if (dbConnection != null) { 
                } 
                String sql ="select naam as Bank, max(koers_date), min(koers_opkoop), valuta_eenheid from dagkoersen where valuta_eenheid = 'USD' order by naam;";
                Statement stmt = dbConnection.createStatement();
                ResultSet rs = stmt.executeQuery(sql); 
                // LOOP THROUGH THE RESULT SET
                while (rs.next()) {
                    System.out.println("# \tBANK \t\t\tAANGEPAST \tVALUTA SOORT \tBEDRAG");
                    System.out.println("1" + "\t" +
                    rs.getString("Bank") + "\t" + 
                    rs.getString("max(koers_date)") + "\t" + 
                    rs.getString("valuta_eenheid") + "\t\t" + 
                    rs.getString("min(koers_opkoop)") + "\t");
                }   
            } catch (SQLException ex) { 
                System.out.println("An error occurred while connecting MySQL databse"); ex.printStackTrace(); 
            }
            Scanner input = new Scanner(System.in);
            int choice;
            do {
                TerugEnAfsluiten();                        
                keuze();                    
                choice = input.nextInt();
            }
            while(choice > 2);
            switch(choice){
            case 1: // TERUG NAAR MAIN MENU
                Menu();  
                break;
            case 2: // AFSLUITEN
                close();
                break;
            }
            // BAD MENU OPTION DIRECT
                if (choice > 2 || choice < 1){
                do{
                    choice = input.nextInt();
                }
                while(choice < 2 );
            }
            input.close();
        }

        // VOORDEEL OPTIE VERKOPEN USD
        static void Voordeel_verkoop_usd() throws InterruptedException{
            Connection dbConnection = null;
            System.out.println("\n\n\n\n\n\nVOORDELIGSTE OPTIE VOOR HET VERKOPEN VAN $ (US DOLLAR) IS BIJ: ");
            System.out.println(            "-------------------------------------------------------------");
            try { 
                dbConnection = getConnection(); 
                if (dbConnection != null) { 
                } 
                String sql ="select naam as Bank, max(koers_date), max(koers_verkoop), valuta_eenheid from dagkoersen where valuta_eenheid = 'USD' order by naam;";
                Statement stmt = dbConnection.createStatement();
                ResultSet rs = stmt.executeQuery(sql); 
                // LOOP THROUGH THE RESULT SET
                while (rs.next()) {
                    System.out.println("# \tBANK \t\t\tAANGEPAST \tVALUTA SOORT \tBEDRAG");
                    System.out.println("1" + "\t" +
                    rs.getString("Bank") + "\t" + 
                    rs.getString("max(koers_date)") + "\t" + 
                    rs.getString("valuta_eenheid") + "\t\t" + 
                    rs.getString("max(koers_verkoop)") + "\t");
                }   
            } catch (SQLException ex) { 
                System.out.println("An error occurred while connecting MySQL databse"); ex.printStackTrace(); 
            }
            Scanner input = new Scanner(System.in);
            int choice;
            do {
                TerugEnAfsluiten();                        
                keuze();                    
                choice = input.nextInt();
            }
            while(choice > 2);
            switch(choice){
            case 1: // TERUG NAAR MAIN MENU
                Menu();  
                break;
            case 2: // AFSLUITEN
                close();
                break;
            }
            // BAD MENU OPTION DIRECT
                if (choice > 2 || choice < 1){
                do{
                    choice = input.nextInt();
                }
                while(choice < 2 );
            }
            input.close();
        }

        // VOORDEEL OPTIE KOPEN EURO
        static void Voordeel_aankoop_euro() throws InterruptedException{
            Connection dbConnection = null;
            System.out.println("\n\n\n\n\n\nVOORDELIGSTE OPTIE VOOR HET AANKOPEN VAN € (EURO) IS BIJ: ");
            System.out.println(            "---------------------------------------------------------");
            try { 
                dbConnection = getConnection(); 
                if (dbConnection != null) { 
                } 
                String sql ="select naam as Bank, max(koers_date), min(koers_opkoop), valuta_eenheid from dagkoersen where valuta_eenheid = 'Euro' order by naam;";
                Statement stmt = dbConnection.createStatement();
                ResultSet rs = stmt.executeQuery(sql); 
                // LOOP THROUGH THE RESULT SET
                while (rs.next()) {
                    System.out.println("# \tBANK \t\t\tAANGEPAST \tVALUTA SOORT \tBEDRAG");
                    System.out.println("1" + "\t" +
                    rs.getString("Bank") + "\t" + 
                    rs.getString("max(koers_date)") + "\t" + 
                    rs.getString("valuta_eenheid") + "\t\t" + 
                    rs.getString("min(koers_opkoop)") + "\t");
                }   
            } catch (SQLException ex) { 
                System.out.println("An error occurred while connecting MySQL databse"); ex.printStackTrace(); 
            }
            Scanner input = new Scanner(System.in);
            int choice;
            do {
                TerugEnAfsluiten();                        
                keuze();                    
                choice = input.nextInt();
            }
            while(choice > 2);
            switch(choice){
            case 1: // TERUG NAAR MAIN MENU
                Menu();  
                break;
            case 2: // AFSLUITEN
                close();
                break;
            }
            // BAD MENU OPTION DIRECT
                if (choice > 2 || choice < 1){
                do{
                    choice = input.nextInt();
                }
                while(choice < 2 );
            }
            input.close();
        }

        // VOORDEEL OPTIE VERKOPEN EURO
        static void Voordeel_verkoop_euro() throws InterruptedException{
            Connection dbConnection = null;
            System.out.println("\n\n\n\n\n\nVOORDELIGSTE OPTIE VOOR HET VERKOPEN VAN € (EURO) IS BIJ: ");
            System.out.println(            "---------------------------------------------------------");
            try { 
                dbConnection = getConnection(); 
                if (dbConnection != null) { 
                } 
                String sql ="select naam as Bank, max(koers_date), max(koers_verkoop), valuta_eenheid from dagkoersen where valuta_eenheid = 'Euro' order by naam;";
                Statement stmt = dbConnection.createStatement();
                ResultSet rs = stmt.executeQuery(sql); 
                // LOOP THROUGH THE RESULT SET
                while (rs.next()) {
                    System.out.println("# \tBANK \t\t\tAANGEPAST \tVALUTA SOORT \tBEDRAG");
                    System.out.println("1" + "\t" +
                    rs.getString("Bank") + "\t" + 
                    rs.getString("max(koers_date)") + "\t" + 
                    rs.getString("valuta_eenheid") + "\t\t" + 
                    rs.getString("max(koers_verkoop)") + "\t");
                }   
            } catch (SQLException ex) { 
                System.out.println("An error occurred while connecting MySQL databse"); ex.printStackTrace(); 
            }
            Scanner input = new Scanner(System.in);
            int choice;
            do {
                TerugEnAfsluiten();                        
                keuze();                    
                choice = input.nextInt();
            }
            while(choice > 2);
            switch(choice){
            case 1: // TERUG NAAR MAIN MENU
                Menu();  
                break;
            case 2: // AFSLUITEN
                close();
                break;
            }
            // BAD MENU OPTION DIRECT
                if (choice > 2 || choice < 1){
                do{
                    choice = input.nextInt();
                }
                while(choice < 2 );
            }
            input.close();
        }


        // APPLICATIE AFSLUITEN
        static void close() throws InterruptedException{
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
            Thread.sleep(100);
            System.out.println("Applicatie afgesloten..................\n");
            System.exit(0);
        }

        // VOER UW MENU KEUZE IN
        static void keuze() throws InterruptedException{
            System.out.println("\nVoer uw menu keuze in: ");
        }

        // 1 TERUG NAAR MAIN MENU EN 2 AFSLUITEN
        static void TerugEnAfsluiten() throws InterruptedException{     
            System.out.print("\n1  [<]  TERUG NAAR MENU\n");
            System.out.print("2  [X]  AFSLUITEN\n");
        } 

        // ... WIJ BRENGEN U TERUG NAAR HET HOOFDMENU...
        static void AutoReturnToMenu() throws InterruptedException{     
            Thread.sleep(1000);
            System.out.println("...Wij brengen u terug naar het HOOFDMENU...\n\n");
            Thread.sleep(1000);
        } 

    
    //CONNECTION WITH DATABASE
    public static Connection getConnection() throws SQLException {
        Connection conn = null;

        // assign db parameters
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "abcd";
        String databasename = "mydb";
        Properties info = new Properties(); 
        info.put("user", user); 
        info.put("password", password); 
    
        // create a connection to the database
        conn = DriverManager.getConnection(url + databasename, info);
    
        return conn;
    }

    //RUN METHODS
    public static void main(String[] args) throws InterruptedException{
        Menu();
    }
    }

















// GET DATA FROM DATABASE
        //Connection dbConnection = null;
        /*try { 
            dbConnection = getConnection(); 
            
            if (dbConnection != null) { 
                System.out.println("Successfully connected to MySQL database test"); 
            } 
            String sql = "SELECT * FROM bank";
            Statement stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery(sql); 
            // LOOP THROUGH THE RESULT SET
            while (rs.next()) {
                System.out.println(
                    rs.getString("id") + "\t" + 
                    rs.getString("naam") + "\t" +
                    rs.getString("email"));
            }   
        } catch (SQLException ex) { 
            System.out.println("An error occurred while connecting MySQL databse"); ex.printStackTrace(); 
        }
    }
    */
    

