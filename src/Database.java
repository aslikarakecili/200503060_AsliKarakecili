/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.sql.*;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author lenovo
 */
public class Database {
    
        public static Connection getCon() throws Exception{
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fitplus?&useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC&autoReconnect=true&useSSL=false","root","agk130922");
            return con;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    } 
        
        //Sekretarfunktionen
        public static void addSekretar (Sekretar sekretar) {
            try{
            Connection con = Database.getCon();
            PreparedStatement ps = con.prepareStatement("insert into sekretar values (?,?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, sekretar.getSekretarID());
            ps.setString(2, sekretar.getAusweis());
            ps.setString(3, sekretar.getVorname());
            ps.setString(4, sekretar.getNachname());
            ps.setString(5, sekretar.getGeschlecht());
            ps.setInt(6, sekretar.getAge());
            ps.setString(7, sekretar.getTelefonnummer());
            ps.setString(8, sekretar.getAdresse());
            ps.setFloat(9, sekretar.getGehalt());
            ps.setBoolean(10, sekretar.isGenommen());
            ps.setString(11, sekretar.getGehaltsdatum());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Erfolgreich Gespeichert");
        }
            catch(Exception e){
                e.printStackTrace();
            }
    }
        public static void updateSekretar (Sekretar sekretar){
            try{
            Connection con = Database.getCon();
            PreparedStatement ps = con.prepareStatement("update sekretar set Ausweis=?,Vorname=?,Nachname=?,Geschlecht=?,Age=?,Telefonnummer=?,Adresse=?,Gehalt=?,Genommen=?,Gehaltsdatum=? where SekretarID=?");
            ps.setString(1, sekretar.getAusweis());
            ps.setString(2, sekretar.getVorname());
            ps.setString(3, sekretar.getNachname());
            ps.setString(4, sekretar.getGeschlecht());
            ps.setInt(5, sekretar.getAge());
            ps.setString(6, sekretar.getTelefonnummer());
            ps.setString(7, sekretar.getAdresse());
            ps.setFloat(8, sekretar.getGehalt());
            ps.setBoolean(9, sekretar.isGenommen());
            ps.setString(10, sekretar.getGehaltsdatum());
            ps.setInt(11, sekretar.getSekretarID());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Erfolgreich Aktualisiert");
        }
            catch(Exception e){
                e.printStackTrace();
                // JOptionPane.showMessageDialog(null, e);
            }
        }
        public static void deleteSekretar (String SekretarID){
            int checkSekretarID = 0;
            try{
                Connection con = Database.getCon();
                Statement st = con.createStatement();
                st.executeUpdate("delete from sekretar where SekretarID = " +SekretarID);
                JOptionPane.showMessageDialog(null, "Erfolgreich Gelöscht");
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
        public static Sekretar searchSekretarName (String Vorname, String Nachname){
            int checkSekretarID = 0;
            try{
                Connection con = Database.getCon();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from sekretar where Vorname = '"+Vorname+"' and Nachname = '"+Nachname+"'");
                while(rs.next()){
                    checkSekretarID = 1;
                    Sekretar sekretar = new Sekretar(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8),rs.getFloat(9),rs.getBoolean(10),rs.getString(11));
                    return sekretar;
                }
                if (checkSekretarID == 0){
                    JOptionPane.showMessageDialog(null, "Ein solcher Sekretarname existiert nicht");
                }
                
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
            return null;  
        }
        public static Sekretar searchSekretarID (String SekretarID){
            int checkSekretarID = 0;
            try{
                Connection con = Database.getCon();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from sekretar where SekretarID = '"+SekretarID+"'");
                while(rs.next()){
                    checkSekretarID = 1;
                    Sekretar sekretar = new Sekretar(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8),rs.getFloat(9),rs.getBoolean(10),rs.getString(11));
                    return sekretar;
                }
                if (checkSekretarID == 0){
                    JOptionPane.showMessageDialog(null, "Eine solche SekretarID existiert nicht");
                }
                
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
            return null;  
        }
        public static ResultSet getDataSekretarFilterGehalt (int Genommen){
            
            try{
                Connection con = Database.getCon();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from sekretar where sekretar.Genommen = '"+Genommen+"'");
                return rs;        
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
            return null;
        }
        public static ResultSet getDataSekretar (){
            
            try{
                Connection con = Database.getCon();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from sekretar");
                return rs;        
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
            return null;
        }
        public static int maxSekretarID (){
            try{
                int SekretarID = 1;
                Connection con = Database.getCon();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select max(SekretarID) from sekretar");
                while (rs.next()){
                    SekretarID = rs.getInt(1);
                    SekretarID = SekretarID+1;
                }
                return SekretarID;
            }
            catch(Exception e){
               e.printStackTrace();
            }
            return 1;
        }
        
        //Trainerfunktionen
        public static void addTrainer (Trainer trainer) {
            try{
            Connection con = Database.getCon();
            PreparedStatement ps = con.prepareStatement("insert into trainer values (?,?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, trainer.getTrainerID());
            ps.setString(2, trainer.getAusweis());
            ps.setString(3, trainer.getVorname());
            ps.setString(4, trainer.getNachname());
            ps.setString(5, trainer.getGeschlecht());
            ps.setInt(6, trainer.getAge());
            ps.setString(7, trainer.getTelefonnummer());
            ps.setString(8, trainer.getAdresse());
            ps.setFloat(9, trainer.getGehalt());
            ps.setBoolean(10, trainer.isGenommen());
            ps.setString(11, trainer.getGehaltsdatum());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Erfolgreich Gespeichert");
        }
            catch(Exception e){
                e.printStackTrace();
            }
        
       }
        public static Trainer searchTrainerID (String TrainerID){
            int checkTrainerID = 0;
            try{
                Connection con = Database.getCon();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from trainer where TrainerID = '"+TrainerID+"'");
                while(rs.next()){
                    checkTrainerID= 1;
                    Trainer trainer = new Trainer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8),rs.getFloat(9),rs.getBoolean(10),rs.getString(11));
                    return trainer;
                }
                if (checkTrainerID == 0){
                    JOptionPane.showMessageDialog(null, "Eine solche TrainerID existiert nicht");
                }
                
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
            return null;
        }
        public static void updateTrainer (Trainer trainer){
            try{
            Connection con = Database.getCon();
            PreparedStatement ps = con.prepareStatement("update trainer set Ausweis=?,Vorname=?,Nachname=?,Geschlecht=?,Age=?,Telefonnummer=?,Adresse=?,Gehalt=?,Genommen=?,Gehaltsdatum=? where TrainerID=?");
            ps.setString(1, trainer.getAusweis());
            ps.setString(2, trainer.getVorname());
            ps.setString(3, trainer.getNachname());
            ps.setString(4, trainer.getGeschlecht());
            ps.setInt(5, trainer.getAge());
            ps.setString(6, trainer.getTelefonnummer());
            ps.setString(7, trainer.getAdresse());
            ps.setFloat(8, trainer.getGehalt());
            ps.setBoolean(9, trainer.isGenommen());
            ps.setString(10, trainer.getGehaltsdatum());
            ps.setInt(11, trainer.getTrainerID());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Erfolgreich Aktualisiert");
        }
            catch(Exception e){
                e.printStackTrace();
                // JOptionPane.showMessageDialog(null, e);
            }
        }
        public static void deleteTrainer (String TrainerID){
            
            try{
                Connection con = Database.getCon();
                Statement st = con.createStatement();
                st.executeUpdate("delete from trainer where TrainerID = " +TrainerID);
                JOptionPane.showMessageDialog(null, "Erfolgreich Gelöscht");
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
        public static Trainer searchTrainerName (String Vorname, String Nachname){
            int checkTrainerID = 0;
            try{
                Connection con = Database.getCon();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from trainer where Vorname = '"+Vorname+"' and Nachname = '"+Nachname+"'");
                while(rs.next()){
                    checkTrainerID = 1;
                    Trainer trainer = new Trainer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8),rs.getFloat(9),rs.getBoolean(10),rs.getString(11));
                    return trainer;
                }
                if (checkTrainerID == 0){
                    JOptionPane.showMessageDialog(null, "Ein solcher Trainername existiert nicht");
                }
                
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
            return null;  
        }
        public static ResultSet getDataTrainerFilterGehalt (int Genommen){
            
            try{
                Connection con = Database.getCon();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from trainer where trainer.Genommen = '"+Genommen+"'");
                return rs;        
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
            return null;
        }
        public static ResultSet getDataTrainer (){
            
            try{
                Connection con = Database.getCon();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from trainer");
                return rs;        
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
            return null;
        }
        public static int maxTrainerID (){
            try{
                int TrainerID = 1;
                Connection con = Database.getCon();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select max(TrainerID) from trainer");
                while (rs.next()){
                    TrainerID = rs.getInt(1);
                    TrainerID = TrainerID+1;
                }
                return TrainerID;
            }
            catch(Exception e){
               e.printStackTrace();
            }
            return 1;
        }
       
        //Kundenfunktionen
        public static int maxKundenID (){
            try{
                int KundenID = 1;
                Connection con = Database.getCon();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select max(KundenID) from kunde");
                while (rs.next()){
                    KundenID = rs.getInt(1);
                    KundenID = KundenID+1;
                }
                return KundenID;
            }
            catch(Exception e){
               e.printStackTrace();
            }
            return 1;
        }
        public static void addKunde (Kunde kunde) {
            try{
            Connection con = Database.getCon();
            PreparedStatement ps = con.prepareStatement("insert into kunde values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, kunde.getKundenID());
            ps.setString(2, kunde.getAusweis());
            ps.setString(3, kunde.getVorname());
            ps.setString(4, kunde.getNachname());
            ps.setString(5, kunde.getGeschlecht());
            ps.setInt(6, kunde.getAge());
            ps.setInt(7, kunde.getLange());
            ps.setFloat(8, kunde.getGewicht());
            ps.setString(9, kunde.getTelefonnummer());
            ps.setString(10, kunde.getZweck());
            ps.setString(11, kunde.getDiatprogramm());
            ps.setString(12, kunde.getSportprogramm());
            ps.setFloat(13, kunde.getRechnung());
            ps.setBoolean(14, kunde.isBezahlt());
            ps.setString(15, kunde.getGruppenstundenum());
            ps.setString(16, kunde.getRechnungsdatum());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Erfolgreich Gespeichert");
        }
            catch(Exception e){
                e.printStackTrace();
            }
        
       }
        public static Kunde searchKundenID (String KundenID){
            int checkKundenID = 0;
            try{
                Connection con = Database.getCon();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from kunde where KundenID = '"+KundenID+"'");
                while(rs.next()){
                    checkKundenID= 1;
                    Kunde kunde = new Kunde(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7),rs.getFloat(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getFloat(13),rs.getBoolean(14),rs.getString(15),rs.getString(16));
                    return kunde;
                }
                if (checkKundenID == 0){
                    JOptionPane.showMessageDialog(null, "Eine solche KundenID existiert nicht");
                }
                
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
            return null;
        }
        public static void updateKunde (Kunde kunde){
            try{
            Connection con = Database.getCon();
            PreparedStatement ps = con.prepareStatement("update kunde set Ausweis=?,Vorname=?,Nachname=?,Geschlecht=?,Age=?,Lange=?,Gewicht=?,Telefonnummer=?,Zweck=?,Diatprogramm=?,Sportprogramm=?,Rechnung=?,Bezahlt=?,Gruppenstundenum=?,Rechnungsdatum=? where KundenID=?");
            ps.setString(1, kunde.getAusweis());
            ps.setString(2, kunde.getVorname());
            ps.setString(3, kunde.getNachname());
            ps.setString(4, kunde.getGeschlecht());
            ps.setInt(5, kunde.getAge());
            ps.setInt(6, kunde.getLange());
            ps.setFloat(7, kunde.getGewicht());
            ps.setString(8, kunde.getTelefonnummer());
            ps.setString(9, kunde.getZweck());
            ps.setString(10, kunde.getDiatprogramm());
            ps.setString(11, kunde.getSportprogramm());
            ps.setFloat(12, kunde.getRechnung());
            ps.setBoolean(13, kunde.isBezahlt());
            ps.setString(14, kunde.getGruppenstundenum());
            ps.setString(15, kunde.getRechnungsdatum());
            ps.setInt(16, kunde.getKundenID());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Erfolgreich Aktualisiert");
        }
            catch(Exception e){
                e.printStackTrace();
                // JOptionPane.showMessageDialog(null, e);
            }
        }
        public static void deleteKunde(String KundenID){
            
            try{
                Connection con = Database.getCon();
                Statement st = con.createStatement();
                st.executeUpdate("delete from kunde where KundenID = " +KundenID);
                JOptionPane.showMessageDialog(null, "Erfolgreich Gelöscht");
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
        public static Kunde searchKundeName (String Vorname, String Nachname){
            int checkKundenID = 0;
            try{
                Connection con = Database.getCon();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from kunde where Vorname = '"+Vorname+"' and Nachname = '"+Nachname+"'");
                while(rs.next()){
                    checkKundenID = 1;
                    Kunde kunde = new Kunde(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7),rs.getFloat(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getFloat(13),rs.getBoolean(14),rs.getString(15),rs.getString(16));
                    return kunde;
                }
                if (checkKundenID == 0){
                    JOptionPane.showMessageDialog(null, "Eine solche Kundenname existiert nicht");
                }
                
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
            return null;  
        }
        public static ResultSet getDataKundeFilterRechnung (int Bezahlt){
            try{
                Connection con = Database.getCon();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from kunde where kunde.Bezahlt = '"+Bezahlt+"'");
                return rs;        
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
            return null;
        }
        public static ResultSet getDataKunde (){
            
            try{
                Connection con = Database.getCon();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from kunde");
                return rs;        
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
            return null;
        }
        public static ResultSet getDataKundeFilterZweck (String Zweck){
            try{
                Connection con = Database.getCon();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from kunde where kunde.Zweck = '"+Zweck+"'");
                return rs;        
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
            return null;
        }
        
       
        //Diatprogrammfunktionen
        public static int maxDiatID (){
            try{
                int DiatID = 1;
                Connection con = Database.getCon();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select max(DiatID) from diatprogramm");
                while (rs.next()){
                    DiatID = rs.getInt(1);
                    DiatID = DiatID+1;
                return DiatID;
                }
            }    
            catch(Exception e){
               e.printStackTrace();
            }
            return 1;
        }        
        public static void addDiatprogramm (Diatprogramm diatprogramm) {
            try{
            Connection con = Database.getCon();
            PreparedStatement ps = con.prepareStatement("insert into diatprogramm values (?,?,?,?,?)");
            ps.setInt(1, diatprogramm.getDiatID());
            ps.setString(2, diatprogramm.getDiatname());
            ps.setString(3, diatprogramm.getTage());
            ps.setString(4, diatprogramm.getNahrungen());
            ps.setString(5, diatprogramm.getUhrzeiten());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Erfolgreich Gespeichert");
        }
            catch(Exception e){
                e.printStackTrace();
            }
       } 
        public static Diatprogramm searchDiatID (String DiatID){
            int checkDiatID = 0;
            try{
                Connection con = Database.getCon();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from diatprogramm where DiatID = '"+DiatID+"'");
                while(rs.next()){
                    checkDiatID= 1;
                    Diatprogramm diatprogramm = new Diatprogramm(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
                    return diatprogramm;
                }
                if (checkDiatID == 0){
                    JOptionPane.showMessageDialog(null, "Ein solcher DiatID existiert nicht");
                }
                
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
            return null;
        }
        public static void updateDiatprogramm (Diatprogramm diatprogramm){
            try{
            Connection con = Database.getCon();
            PreparedStatement ps = con.prepareStatement("update diatprogramm set Diatname=?,Tage=?,Nahrungen=?,Uhrzeiten=? where DiatID=?");
            ps.setString(1, diatprogramm.getDiatname());
            ps.setString(2, diatprogramm.getTage());
            ps.setString(3, diatprogramm.getNahrungen());
            ps.setString(4, diatprogramm.getUhrzeiten());
            ps.setInt(5, diatprogramm.getDiatID());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Erfolgreich Aktualisiert");
        }
            catch(Exception e){
                e.printStackTrace();
                // JOptionPane.showMessageDialog(null, e);
            }
        }
        public static Diatprogramm searchDiatName (String Diatname){
            int checkDiatID = 0;
            try{
                Connection con = Database.getCon();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from diatprogramm where Diatname = '"+Diatname+"'");
                while(rs.next()){
                    checkDiatID = 1;
                    Diatprogramm diatprogramm = new Diatprogramm(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
                    return diatprogramm;
                }
                if (checkDiatID == 0){
                    JOptionPane.showMessageDialog(null, "Eine solche Diätname existiert nicht");
                }
                
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
            return null;  
        }
        public static void deleteDiatprogramm(String DiatID){
            
            try{
                Connection con = Database.getCon();
                Statement st = con.createStatement();
                st.executeUpdate("delete from diatprogramm where DiatID = " +DiatID);
                JOptionPane.showMessageDialog(null, "Erfolgreich Gelöscht");
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
        public static ResultSet getDataDiatprogramm (){
            
            try{
                Connection con = Database.getCon();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from diatprogramm");
                return rs;        
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
            return null;
        }
        
        //Gruppenstundenfunktionen
        public static int maxGruppenstundenID (){
            try{
                int GruppenstundenID = 1;
                Connection con = Database.getCon();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select max(GruppenstundenID) from gruppenstunde");
                while (rs.next()){
                    GruppenstundenID = rs.getInt(1);
                    GruppenstundenID = GruppenstundenID+1;
                return GruppenstundenID;
                }
            }    
            catch(Exception e){
               e.printStackTrace();
            }
            return 1;
        }    
        public static void addGruppenstunde (Gruppenstunde gruppenstunde) {
            try{
            Connection con = Database.getCon();
            PreparedStatement ps = con.prepareStatement("insert into gruppenstunde values (?,?,?,?,?,?,?)");
            ps.setInt(1, gruppenstunde.getGruppenstundenID());
            ps.setInt(2, gruppenstunde.getGruppenstundennummer());
            ps.setInt(3, gruppenstunde.getKapazitat());
            ps.setString(4, gruppenstunde.getDatum());
            ps.setString(5, gruppenstunde.getTag());
            ps.setInt(6, gruppenstunde.getDauer());
            ps.setInt(7, gruppenstunde.getTrainerID());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Erfolgreich Gespeichert");
        }
            catch(Exception e){
                e.printStackTrace();
            }
       } 
        public static Gruppenstunde searchGruppenstundenID (String GruppenstundenID){
            int checkGruppenstundenID = 0;
            try{
                Connection con = Database.getCon();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from gruppenstunde where GruppenStundenID = '"+GruppenstundenID+"'");
                while(rs.next()){
                    checkGruppenstundenID= 1;
                    Gruppenstunde gruppenstunde = new Gruppenstunde(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7));
                    return gruppenstunde;
                }
                if (checkGruppenstundenID == 0){
                    JOptionPane.showMessageDialog(null, "Ein solcher GruppenstundenID existiert nicht");
                }
                
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
            return null;
        }
        public static Gruppenstunde searchGruppenstundeName (String Datum, int TrainerID){
            int checkGruppenstundenID = 0;
            try{
                Connection con = Database.getCon();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from gruppenstunde where Datum = '"+Datum+"' and TrainerID = '"+TrainerID+"'");
                while(rs.next()){
                    checkGruppenstundenID = 1;
                    Gruppenstunde gruppenstunde = new Gruppenstunde(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7));
                    return gruppenstunde;
                }
                if (checkGruppenstundenID == 0){
                    JOptionPane.showMessageDialog(null, "Eine solche Gruppenstunde existiert nicht");
                }
                
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
            return null;  
        }
        public static void updateGruppenstunde (Gruppenstunde gruppenstunde){
            try{
                Connection con = Database.getCon();
                PreparedStatement ps = con.prepareStatement("update gruppenstunde set Gruppenstundennummer=?,Kapazitat=?,Datum=?,Tag=?,Dauer=?,TrainerID=? where GruppenStundenID=?");
                ps.setInt(1, gruppenstunde.getGruppenstundennummer());
                ps.setInt(2, gruppenstunde.getKapazitat());
                ps.setString(3, gruppenstunde.getDatum());
                ps.setString(4, gruppenstunde.getTag());
                ps.setInt(5, gruppenstunde.getDauer());
                ps.setInt(6, gruppenstunde.getTrainerID());
                ps.setInt(7, gruppenstunde.getGruppenstundenID());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Erfolgreich Aktualisiert");
        }
            catch(Exception e){
                e.printStackTrace();
                // JOptionPane.showMessageDialog(null, e);
            }
        }    
        public static void deleteGruppenstunde(String GruppenstundenID){
            
                try{
                    Connection con = Database.getCon();
                    Statement st = con.createStatement();
                    st.executeUpdate("delete from gruppenstunde where GruppenStundenID = " +GruppenstundenID);
                    JOptionPane.showMessageDialog(null, "Erfolgreich Gelöscht");
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
                }
        }
        public static ResultSet getDataGruppenstundeFilterTrainerID(int TrainerID){
            int checkSekretarID = 0;
            try{
                Connection con = Database.getCon();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from gruppenstunde where TrainerID = '"+TrainerID+"'");
                return rs;
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
            checkSekretarID = 1;
                if (checkSekretarID == 0){
                    JOptionPane.showMessageDialog(null, "Eine solche SekretarID existiert nicht");
                }
            return null;  
        }
        public static ResultSet getDataGruppenstunde(){
            try{
                Connection con = Database.getCon();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from gruppenstunde");
                return rs;        
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
            return null;
        }
      
        //Multiuserloginfunktionen
        public static ResultSet getDataMultiuserloginAdmin(){
            try{
                Connection con = Database.getCon();
                PreparedStatement pst = con.prepareStatement("select Nutzername, Passwort from multiuserlogin where UserID='Admin'"); 
                ResultSet rs = pst.executeQuery();
                return rs;        
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
            return null;
        }
        public static ResultSet getDataMultiuserloginTrainer(){
            try{
                Connection con = Database.getCon();
                PreparedStatement pst = con.prepareStatement("select Nutzername, Passwort from multiuserlogin where UserID='Trainer'"); 
                ResultSet rs = pst.executeQuery();
                return rs;        
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
            return null;
        }
        public static ResultSet getDataMultiuserloginSekretar(){
            try{
                Connection con = Database.getCon();
                PreparedStatement pst = con.prepareStatement("select Nutzername, Passwort, Usertype from multiuserlogin where UserID='Sekretar'"); 
                ResultSet rs = pst.executeQuery();
                return rs;        
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
            return null;
        }
        
        public static void updateMultiuserloginAdmin (Multiuserlogin multiuserlogin){
            try{
            Connection con = Database.getCon();
            PreparedStatement ps = con.prepareStatement("update multiuserlogin set Nutzername=?, Passwort=?, Usertype=? where UserID=?");
            ps.setString(1, multiuserlogin.getNutzername());
            ps.setString(2, multiuserlogin.getPasswort());
            ps.setString(3, multiuserlogin.getUsertype());
            ps.setString(4, multiuserlogin.getUserID());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Erfolgreich Aktualisiert");
        }
            catch(Exception e){
                e.printStackTrace();
                // JOptionPane.showMessageDialog(null, e);
            }
        }
        public static void updateMultiuserloginTrainer (Multiuserlogin multiuserlogin){
            try{
            Connection con = Database.getCon();
            PreparedStatement ps = con.prepareStatement("update multiuserlogin set Nutzername=?, Passwort=?, Usertype='Trainer' where UserID='Trainer'");
            ps.setString(1, multiuserlogin.getNutzername());
            ps.setString(2, multiuserlogin.getPasswort());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Erfolgreich Aktualisiert");
        }
            catch(Exception e){
                e.printStackTrace();
                // JOptionPane.showMessageDialog(null, e);
            }
        }
        public static void updateMultiuserloginSekretar (Multiuserlogin multiuserlogin){
            try{
            Connection con = Database.getCon();
            PreparedStatement ps = con.prepareStatement("update multiuserlogin set Nutzername=?, Passwort=?, Usertype=? where UserID='Sekretar'");
            ps.setString(1, multiuserlogin.getNutzername());
            ps.setString(2, multiuserlogin.getPasswort());
            ps.setString(3, multiuserlogin.getUsertype());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Erfolgreich Aktualisiert");
        }
            catch(Exception e){
                e.printStackTrace();
                // JOptionPane.showMessageDialog(null, e);
            }
        }
}        
    