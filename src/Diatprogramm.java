/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lenovo
 */
public class Diatprogramm {
    
    private int DiatID;
    private String Diatname;
    private String Tage;
    private String Nahrungen;
    private String Uhrzeiten;
    
    public Diatprogramm (int DiatID, String Diatname, String Tage, String Nahrungen, String Uhrzeiten){
        this.DiatID = DiatID;
        this.Diatname = Diatname;
        this.Tage = Tage;
        this.Nahrungen = Nahrungen;
        this.Uhrzeiten = Uhrzeiten;
    } 

    public int getDiatID() {
        return DiatID;
    }

    public String getDiatname() {
        return Diatname;
    }

    public String getTage() {
        return Tage;
    }

    public String getNahrungen() {
        return Nahrungen;
    }

    public String getUhrzeiten() {
        return Uhrzeiten;
    }

    public void setDiatID(int DiatID) {
        this.DiatID = DiatID;
    }

    public void setDiatname(String Diatname) {
        this.Diatname = Diatname;
    }

    public void setTage(String Tage) {
        this.Tage = Tage;
    }

    public void setNahrungen(String Nahrungen) {
        this.Nahrungen = Nahrungen;
    }

    public void setUhrzeiten(String Uhrzeiten) {
        this.Uhrzeiten = Uhrzeiten;
    }
    
    
    
}
