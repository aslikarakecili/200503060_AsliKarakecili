/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lenovo
 */
public class Trainer {
    private int TrainerID;
    private String Ausweis;
    private String Vorname;
    private String Nachname;
    private String Geschlecht;
    private int Age;
    private String Telefonnummer;
    private String Adresse;
    private float Gehalt;
    private boolean Genommen;
    private String Gehaltsdatum;
    
    public Trainer (int TrainerID, String Ausweis, String Vorname, String Nachname, String Geschlecht, int Age, String Telefonnummer, String Adresse, float Gehalt, boolean Genommen, String Gehaltsdatum){
        this.TrainerID = TrainerID;
        this.Ausweis = Ausweis;
        this.Vorname = Vorname;
        this.Nachname = Nachname;
        this.Geschlecht = Geschlecht;
        this.Age = Age;
        this.Telefonnummer = Telefonnummer;
        this.Adresse = Adresse;
        this.Gehalt = Gehalt;
        this.Genommen = Genommen;
        this.Gehaltsdatum = Gehaltsdatum;
    } 

    public int getTrainerID() {
        return TrainerID;
    }

    public String getAusweis() {
        return Ausweis;
    }

    public String getVorname() {
        return Vorname;
    }

    public String getNachname() {
        return Nachname;
    }

    public String getGeschlecht() {
        return Geschlecht;
    }

    public int getAge() {
        return Age;
    }

    public String getTelefonnummer() {
        return Telefonnummer;
    }

    public String getAdresse() {
        return Adresse;
    }

    public float getGehalt() {
        return Gehalt;
    }

    public boolean isGenommen() {
        return Genommen;
    }

    public String getGehaltsdatum() {
        return Gehaltsdatum;
    }

    public void setTrainerID(int TrainerID) {
        this.TrainerID = TrainerID;
    }

    public void setAusweis(String Ausweis) {
        this.Ausweis = Ausweis;
    }

    public void setVorname(String Vorname) {
        this.Vorname = Vorname;
    }

    public void setNachname(String Nachname) {
        this.Nachname = Nachname;
    }

    public void setGeschlecht(String Geschlecht) {
        this.Geschlecht = Geschlecht;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public void setTelefonnummer(String Telefonnummer) {
        this.Telefonnummer = Telefonnummer;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    public void setGehalt(float Gehalt) {
        this.Gehalt = Gehalt;
    }

    public void setGenommen(boolean Genommen) {
        this.Genommen = Genommen;
    }

    public void setGehaltsdatum(String Gehaltsdatum) {
        this.Gehaltsdatum = Gehaltsdatum;
    }
    
    
}
