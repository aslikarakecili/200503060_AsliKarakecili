/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lenovo
 */
public class Kunde {
    private int KundenID;
    private String Ausweis;
    private String Vorname;
    private String Nachname;
    private String Geschlecht;
    private int Age;
    private int Lange;
    private float Gewicht;
    private String Telefonnummer;
    private String Zweck;
    private String Diatprogramm;
    private String Sportprogramm;
    private float Rechnung;
    private boolean Bezahlt;
    private String Gruppenstundenum;
    private String Rechnungsdatum;
    
    public Kunde (int KundenID, String Ausweis, String Vorname, String Nachname, String Geschlecht, int Age, int Lange, float Gewicht, String Telefonnummer, String Zweck, String Diatprogramm, String Sportprogramm, float Rechnung, boolean Bezahlt, String Gruppenstundenum, String Rechnungsdatum){
        this.KundenID = KundenID;
        this.Ausweis = Ausweis;
        this.Vorname = Vorname;
        this.Nachname = Nachname;
        this.Geschlecht = Geschlecht;
        this.Age = Age;
        this.Lange = Lange;
        this.Gewicht = Gewicht;
        this.Telefonnummer = Telefonnummer;
        this.Zweck = Zweck;
        this.Diatprogramm = Diatprogramm;
        this.Sportprogramm = Sportprogramm;
        this.Rechnung = Rechnung;
        this.Bezahlt = Bezahlt;
        this.Gruppenstundenum = Gruppenstundenum;
        this.Rechnungsdatum = Rechnungsdatum;
    }

    public int getKundenID() {
        return KundenID;
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

    public int getLange() {
        return Lange;
    }

    public float getGewicht() {
        return Gewicht;
    }

    public String getTelefonnummer() {
        return Telefonnummer;
    }

    public String getZweck() {
        return Zweck;
    }

    public String getDiatprogramm() {
        return Diatprogramm;
    }

    public String getSportprogramm() {
        return Sportprogramm;
    }

    public float getRechnung() {
        return Rechnung;
    }

    public boolean isBezahlt() {
        return Bezahlt;
    }

    public String getGruppenstundenum() {
        return Gruppenstundenum;
    }

    public String getRechnungsdatum() {
        return Rechnungsdatum;
    }

    public void setKundenID(int KundenID) {
        this.KundenID = KundenID;
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

    public void setLange(int Lange) {
        this.Lange = Lange;
    }

    public void setGewicht(float Gewicht) {
        this.Gewicht = Gewicht;
    }

    public void setTelefonnummer(String Telefonnummer) {
        this.Telefonnummer = Telefonnummer;
    }

    public void setZweck(String Zweck) {
        this.Zweck = Zweck;
    }

    public void setDiatprogramm(String Diatprogramm) {
        this.Diatprogramm = Diatprogramm;
    }

    public void setSportprogramm(String Sportprogramm) {
        this.Sportprogramm = Sportprogramm;
    }

    public void setRechnung(float Rechnung) {
        this.Rechnung = Rechnung;
    }

    public void setBezahlt(boolean Bezahlt) {
        this.Bezahlt = Bezahlt;
    }

    public void setGruppenstundenum(String Gruppenstundenum) {
        this.Gruppenstundenum = Gruppenstundenum;
    }

    public void setRechnungsdatum(String Rechnungsdatum) {
        this.Rechnungsdatum = Rechnungsdatum;
    }
    
}
