import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lenovo
 */
public class Sekretar {
    
    private int SekretarID;
    private String Ausweis;
    private String Vorname;
    private String Nachname;
    private String Geschlecht;
    private int Age;
    private String Telefonnummer;
    private String Adresse;
    private float Gehalt;
    private boolean Genommen;
    
    public Sekretar (int SekretarID, String Ausweis, String Vorname, String Nachname, String Geschlecht, int Age, String Telefonnummer, String Adresse, float Gehalt, boolean Genommen){
        this.SekretarID = SekretarID;
        this.Ausweis = Ausweis;
        this.Vorname = Vorname;
        this.Nachname = Nachname;
        this.Geschlecht = Geschlecht;
        this.Age = Age;
        this.Telefonnummer = Telefonnummer;
        this.Adresse = Adresse;
        this.Gehalt = Gehalt;
        this.Genommen = Genommen;
    } 

    public int getSekretarID() {
        return SekretarID;
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

    public void setSekretarID(int SekretarID) {
        this.SekretarID = SekretarID;
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
    

    
}