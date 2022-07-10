/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lenovo
 */
public class Gruppenstunde {
    
    private int GruppenstundenID;
    private int Gruppenstundennummer;
    private int Kapazitat;
    private String Datum;
    private String Tag;
    private int Dauer;
    private int TrainerID;
    
    public Gruppenstunde (int GruppenstundenID, int Gruppenstundennummer, int Kapazitat, String Datum, String Tag, int Dauer, int TrainerID){
        this.GruppenstundenID = GruppenstundenID;
        this.Gruppenstundennummer = Gruppenstundennummer;
        this.Kapazitat= Kapazitat;
        this.Datum = Datum;
        this.Tag = Tag;
        this.Dauer = Dauer;
        this.TrainerID = TrainerID;
    } 

    public String getTag() {
        return Tag;
    }

    public void setTag(String Tag) {
        this.Tag = Tag;
    }
    

    public int getGruppenstundenID() {
        return GruppenstundenID;
    }

    public int getGruppenstundennummer() {
        return Gruppenstundennummer;
    }

    public int getKapazitat() {
        return Kapazitat;
    }

    public String getDatum() {
        return Datum;
    }

    public int getDauer() {
        return Dauer;
    }

    public int getTrainerID() {
        return TrainerID;
    }

    public void setGruppenstundenID(int GruppenstundenID) {
        this.GruppenstundenID = GruppenstundenID;
    }

    public void setGruppenstundennummer(int Gruppenstundennummer) {
        this.Gruppenstundennummer = Gruppenstundennummer;
    }

    public void setKapazitat(int Kapazitat) {
        this.Kapazitat = Kapazitat;
    }

    public void setDatum(String Datum) {
        this.Datum = Datum;
    }

    public void setDauer(int Dauer) {
        this.Dauer = Dauer;
    }

    public void setTrainerID(int TrainerID) {
        this.TrainerID = TrainerID;
    }
    
      
}
