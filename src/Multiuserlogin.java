/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lenovo
 */
public class Multiuserlogin {
   
    private String UserID;
    private String Nutzername;
    private String Passwort;
    private String Usertype;

    
    public Multiuserlogin (String UserID, String Nutzername, String Passwort, String Usertype){
        this.UserID = UserID;
        this.Nutzername = Nutzername;
        this.Passwort = Passwort;
        this.Usertype = Usertype;
    }

    public String getUserID() {
        return UserID;
    }
    
    
    public String getNutzername() {
        return Nutzername;
    }

    public String getPasswort() {
        return Passwort;
    }

    public String getUsertype() {
        return Usertype;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public void setUsertype(String Usertype) {
        this.Usertype = Usertype;
    }

    public void setNutzername(String Nutzername) {
        this.Nutzername = Nutzername;
    }

    public void setPasswort(String Passwort) {
        this.Passwort = Passwort;
    }

    
    
    
}
